package gp.Step;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ecERP.libglobal.LibGlobal;
import gp.DataBase_Instance.CRMData;
import gp.DataBase_Instance.CompareAndWriteExcel;
import gp.DataBase_Instance.DataBase;
import gp.DataBase_Instance.ExcelReader;
import gp.HTTP.HttpService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition extends LibGlobal {

	public static WebDriver driver;
	static List<CRMData> dataBaseData;
	static List<CRMData> uiData;
	static List<CRMData> excelData;

	public String mismatchData = "select reg.so_num, reg.issue_dispname,  "
			+ "case when (select (if(prod.pr_rev_id is not null, concat(prod.productcode , rev.rev_name), prod.productcode)) "
			+ "			from product prod left join pr_revision rev on  prod.pr_rev_id = rev.pr_rev_id "
			+ "			where productid = reg.cust_product_id) is not null   "
			+ "	 then (select (if(prod.pr_rev_id is not null, concat(prod.productcode , rev.rev_name), prod.productcode)) "
			+ "			from product prod left join pr_revision rev on  prod.pr_rev_id = rev.pr_rev_id "
			+ "			where productid = reg.cust_product_id) "
			+ "	 else (case when (select epncode from mech_epn where material_id = (select material_id "
			+ "					  from componentissuedetail issue_det where issue_det.ir_id = reg.ir_id limit 1)) is not null "
			+ "				then (select epncode from mech_epn where material_id = (select material_id "
			+ "					  from componentissuedetail issue_det where issue_det.ir_id = reg.ir_id limit 1)) "
			+ "                else  (select mpncode from mpn mpn left join mpn_revision mpn_rev on mpn_rev.mpn_rev_id = mpn.mpn_rev_id "
			+ "					   where mpn_id = (select ppn_id from componentissuedetail issue_det where issue_det.ir_id = reg.ir_id limit 1)) "
			+ "          end) " + "end as product_code, "
			+ "(select name from status where status_id = reg.status_id) as status "
			+ "from componentissueregister reg where so_num in(select so_no from crm_invoices where invoice_number_seq in ( %s )) ";

	@Given("User create the Data Base Instance")
	public void user_create_the_data_base_instance() throws SQLException {

		DataBase.getConnection();
		dataBaseData = DataBase.getSoNo("");
	}

	
	@When("User validate the Database data with UI Data")
	public void user_validate_the_database_data_with_ui_data() throws InterruptedException, SQLException, IOException {
		String month = getData("GP Inputs", 1, 1);;
		String financialYear_string = getData("GP Inputs", 1, 0);
		List<CRMData> gpUIData = getAPIData(convertMonthNametoID(month), financialYear_string);
		uiData = gpUIData;
		Validation(gpUIData);
	}
	
	private String convertMonthNametoID(String monthName) {
	    switch(monthName) {
	        case "January": return "1";
	        case "February": return "2";
	        case "March": return "3";
	        case "April": return "4";
	        case "May": return "5";
	        case "June": return "6";
	        case "July": return "7";
	        case "August": return "8";
	        case "September": return "9";
	        case "October": return "10";
	        case "November": return "11";
	        case "December": return "12";
	        default: return "";
	    }
	}
	
	private List<CRMData> getAPIData(String monthId, String financialYear) {
		//Local
//		String URL = "http://localhost:8080/restapi/grossprofit/data?monthId="+monthId
//				+"&financialYear="+financialYear;
		String URL = "https://erp.e-consystems.net/restapi/grossprofit/data?monthId="+monthId
				+"&financialYear="+financialYear;
		
		List<LinkedHashMap<String, Object>> monthWiseGPList = HttpService.getInstance().httpGet(URL, null, "");
		List<CRMData> UIData = new ArrayList<CRMData>();
		monthWiseGPList.stream().forEach(data ->{
			CRMData crmData = new CRMData();
			crmData.setSo_no(String.valueOf(data.get("so_no")));
			crmData.setInvoice_no(String.valueOf(data.get("invoice_no")));
			crmData.setInvoice_date(Date
					.valueOf(LocalDate.parse(String.valueOf(data.get("invoice_date_ui")), DateTimeFormatter.ofPattern("dd-MMM-yy"))));
			crmData.setCrm_typeof_orderl(String.valueOf(data.get("order_type")));
			crmData.setOwner_name(String.valueOf(data.get("owner_name")));
			crmData.setAccount_name(String.valueOf(data.get("account_name")));
			crmData.setMarket_area(String.valueOf(data.get("market_area")));
			crmData.setProduct_code(String.valueOf(data.get("product_code")));
			crmData.setQty(Integer.valueOf(String.valueOf(data.get("invoice_qty"))));
			crmData.setUnitprice_usd(String.valueOf(data.get("list_price")));
			crmData.setMat_value_realized_usd(String.valueOf(data.get("material_value_realized")));
			crmData.setMat_value_incurred_usd(String.valueOf(data.get("material_value_incurred")));
			crmData.setInward_frieght_incurred_usd(String.valueOf(data.get("inward_freight_incurred")));
			crmData.setPacking_material(String.valueOf(data.get("packing_material")));
			crmData.setOthers_incurred(String.valueOf(data.get("others_incurred")));
			crmData.setCost_incurred(String.valueOf(data.get("cost_incurred")));
			crmData.setGp_excluding_freight(String.valueOf(data.get("gross_profit_excluding_freight")));
			crmData.setGp_excluding_freight_inpercentage(String.valueOf(data.get("gp_excluding_freight_percentage")));
			crmData.setFreight_realized(String.valueOf(data.get("freight_realized")));
			crmData.setInvoice_value(String.valueOf(data.get("invoice_value")));
			crmData.setFreight_incurred(String.valueOf(data.get("freight_incurred")));
			crmData.setCost_incurred_incl_freight(String.valueOf(data.get("cost_incurred_incl_freight")));
			crmData.setGross_profit(String.valueOf(data.get("gross_profit")));
			crmData.setGross_profit_percentage(String.valueOf(data.get("gross_profit_percentage")));
			
			UIData.add(crmData);
		});
		System.out.println(monthWiseGPList);
		return UIData;
	}

	private void Validation(List<CRMData> gpUIData) throws SQLException {

		// Adjust invoice date based on the day of the week if
		List<CRMData> gpUIData1 = gpUIData.stream()
//				.filter(uiData -> uiData.getInvoice_date().equals(Date.valueOf(LocalDate.now().minusDays(getMinusDays()))))
				.collect(Collectors.toList());

		Set<String> uidbInvoiceNumbers = new HashSet<>();
		for (CRMData uidbData : gpUIData1) {
			uidbInvoiceNumbers.add(uidbData.getInvoice_no());
		}

		List<String> missingInvoiceNumbers = new ArrayList<>();
		List<String> missingSONumbers = new ArrayList<>();

		List<String> matchedInvoiceNumbers = new ArrayList<>();
		for (CRMData dbData : dataBaseData) {
			if (!uidbInvoiceNumbers.contains(dbData.getInvoice_no())) {
				missingInvoiceNumbers.add(dbData.getInvoice_no());
				missingSONumbers.add(dbData.getSo_no());
			} else {
				matchedInvoiceNumbers.add(dbData.getInvoice_no());
			}
		}

		Map<String, List<CRMData>> crmData = dataBaseData.stream().filter(crm -> crm.getInvoice_no() != null)
				.collect(Collectors.groupingBy(CRMData::getInvoice_no));
		Map<String, List<CRMData>> gpData = gpUIData1.stream().collect(Collectors.groupingBy(CRMData::getInvoice_no));

		List<CRMData> mark = new ArrayList<CRMData>();
		dataBaseData.stream().forEach(crm -> {
			gpUIData1.stream().filter(uiData -> uiData.getSo_no().equals(crm.getSo_no()))
					.filter(uiData -> uiData.getInvoice_no() != null && crm.getInvoice_no() != null).forEach(gp -> {
						CRMData mismatchMark = new CRMData();
						if (crm.getInvoice_no().equals(gp.getInvoice_no())) {
							mismatchMark.setInvoice_no(gp.getInvoice_no());
							mismatchMark.setProduct_code(gp.getProduct_code());
							if (!crm.getProduct_code().equals(gp.getProduct_code())) {
								mismatchMark.setProductMisMatch(true);
							} else {
								mismatchMark.setProductMisMatch(false);
								mismatchMark.setQty(gp.getQty());
								if (crm.getQty() != gp.getQty()) {
									mismatchMark.setQtyMismatch(true);
								} else {
									mismatchMark.setQtyMismatch(false);
								}
							}
						}
						mark.add(mismatchMark);
					});
		});
		StringBuilder soNOList = new StringBuilder(missingSONumbers.stream().collect(Collectors.joining(",")));
		List<CRMData> issueList = DataBase.getIssueData(soNOList.toString());
		missingInvoiceNumbers = missingInvoiceNumbers.stream().distinct().sorted(Comparator.comparing(String::valueOf))
				.collect(Collectors.toList());
		generateReport(missingInvoiceNumbers, gpUIData1, matchedInvoiceNumbers, issueList);

	}

	// Original Code

	public static void generateReportForProductLevel(List<CRMData> uiData, StringBuilder html) {
		html.append("<table style=\"border-collapse: collapse; border: 1px solid black;\">");
		html.append(
				"<tr><th colspan=\"6\" style=\"border: 1px solid black; color:green; background-color: lightgray;\">Count Matched Invoice Numbers Validation</th></tr>");
		html.append(
				"<tr><th style=\"border: 1px solid black; color:black;\">S.No</th><th style=\"border: 1px solid black; color:black;\">Invoice No</th>"
						+ "<th style=\"border: 1px solid black; color:black;\">Product Code</th> <th style=\"border: 1px solid black; color:black;\">Product Code Validation</th>"
						+ "<th style=\"border: 1px solid black; color:black;\">Qty</th><th style=\"border: 1px solid black; color:black;\">Qty Validation</th>"
						+ "</tr>");
		for (int i = 0; i < uiData.size(); i++) {
			html.append("<tr><td style=\"border: 1px solid black;\">").append(i + 1)
					.append("</td><td style=\"border: 1px solid black;\">").append(uiData.get(i).getInvoice_no())
					.append("<td style=\"border: 1px solid black;\">").append(uiData.get(i).getProduct_code())
					.append("</td><td style=\"border: 1px solid black;\">")
					.append(getMatchedInfo(uiData.get(i).isProductMisMatch()))
					.append("<td style=\"border: 1px solid black;\">").append(uiData.get(i).getQty())
					.append("</td><td style=\"border: 1px solid black;\">")
					.append(getMatchedInfo(uiData.get(i).isQtyMismatch())).append("</td></tr>");
		}
		html.append("</table>");
	}

	public static void generateReportForIssueERP(List<CRMData> uiData, StringBuilder html) {
		html.append("<table style=\"border-collapse: collapse; border: 1px solid black;\">");
		html.append(
				"<tr><th colspan=\"7\" style=\"border: 1px solid black; color:red; background-color: lightgray;\">Count Missing Invoice Numbers Validation</th></tr>");
		html.append("<tr><th style=\"border: 1px solid black; color:black;\">S.No</th>"
				+ "<th style=\"border: 1px solid black; color:black;\">SO No</th>"
				+ "<th style=\"border: 1px solid black; color:black;\">Invoice No</th>"
				+ "<th style=\"border: 1px solid black; color:black;\">MR Number</th> "
				+ "<th style=\"border: 1px solid black; color:black;\">Product Code</th>"
				+ "<th style=\"border: 1px solid black; color:black;\">Status</th> "
				+ "<th style=\"border: 1px solid black; color:black;\">Invoice Date</th>"
				+ "<th style=\"border: 1px solid black; color:black;\">GRN Inward Date</th>" + "</tr>");
		for (int i = 0; i < uiData.size(); i++) {
			html.append("<tr><td style=\"border: 1px solid black;\">").append(i + 1)
					.append("</td><td style=\"border: 1px solid black;\">").append(uiData.get(i).getSo_no())
					.append("</td><td style=\"border: 1px solid black;\">").append(uiData.get(i).getInvoice_no())
					.append("</td><td style=\"border: 1px solid black;\">").append(uiData.get(i).getIssue_name())
					.append("<td style=\"border: 1px solid black;\">").append(uiData.get(i).getProduct_code())
					.append("<td style=\"border: 1px solid black;\">").append(uiData.get(i).getIssue_status())
					.append("<td style=\"border: 1px solid black;\">").append(uiData.get(i).getInvoice_date())
					.append("<td style=\"border: 1px solid black;\">").append(uiData.get(i).getGrn_date())
					.append("</td></tr>");
		}
		html.append("</table>");
	}

	private static String getMatchedInfo(boolean validtion) {
		if (validtion) {
			return "Mismatched";
		} else {
			return "Matched";
		}
	}

	public static void generateReport(List<String> missingInvoiceNumbers, List<CRMData> uiData,
			List<String> matchedInvoiceNumbers, List<CRMData> issueList) {
		StringBuilder html = new StringBuilder("<html><body>");

		html.append("<table>");
		html.append("<tr><th style=\"color:blue;\">Gross Profit - Report : </th></tr>");
		html.append("</table>");
		html.append("<br>");
		// Invoice Date
		html.append("<table style=\"border-collapse: collapse; border: 1px solid black;\">");
		html.append(
				"<tr><th style=\"border: 1px solid black; color:blue;\">Invoice Date : </th><th style=\"border: 1px solid black;\">")
				.append(LocalDate.now().minusDays(getMinusDays()).format(DateTimeFormatter.ofPattern("dd-MMM-yy")))
				.append("</th></tr>");
		html.append("</table>");

		// Invoice Count
		html.append("<table style=\"border-collapse: collapse; border: 1px solid black;\">");
		html.append("<tr><td style=\"border: 1px solid black;\">").append("Invoice Count (ERP/CRM)")
				.append("</td><td style=\"border: 1px solid black;\">")
				.append(uiData.size() + "/" + dataBaseData.size()).append("</td></tr>");
		html.append("</table>");

		html.append("<br>");

		// Matched Invoice Number
		html.append("<table style=\"border-collapse: collapse; border: 1px solid black;\">");
		html.append(
				"<tr><th colspan=\"2\" style=\"border: 1px solid black; color:green; background-color: lightgray;\">Count Matched Invoice Numbers</th></tr>");
		html.append(
				"<tr><th style=\"border: 1px solid black; color:black;\">S.No</th><th style=\"border: 1px solid black; color:black;\">Invoice No</th></tr>");

		for (int i = 0; i < matchedInvoiceNumbers.size(); i++) {
			html.append("<tr><td style=\"border: 1px solid black;\">").append(i + 1)
					.append("</td><td style=\"border: 1px solid black;\">").append(matchedInvoiceNumbers.get(i))
					.append("</td></tr>");
		}
		html.append("</table>");
		html.append("<br>");

		// Missing Invoice Number
		html.append("<table style=\"border-collapse: collapse; border: 1px solid black;\">");
		html.append(
				"<tr><th colspan=\"2\" style=\"border: 1px solid black; color:red; background-color: lightgray;\">Count Missing Invoice Numbers</th></tr>");
		html.append(
				"<tr><th style=\"border: 1px solid black; color:black;\">S.No</th><th style=\"border: 1px solid black; color:black;\">Invoice No</th>"
						+ "<th style=\"border: 1px solid black; color:black;\">SO No</th></tr>");

		Map<String, List<CRMData>> invoiceNOAndSONOMap = dataBaseData.stream()
				.collect(Collectors.groupingBy(CRMData::getInvoice_no));
		for (int i = 0; i < missingInvoiceNumbers.size(); i++) {
			html.append("<tr><td style=\"border: 1px solid black;\">").append(i + 1)
					.append("</td><td style=\"border: 1px solid black;\">").append(missingInvoiceNumbers.get(i))
					.append("</td><td style=\"border: 1px solid black;\">")
					.append(invoiceNOAndSONOMap.get(missingInvoiceNumbers.get(i)).get(0).getSo_no())
					.append("</td></tr>");
		}

		html.append("</table>");
		html.append("<br>");
		generateReportForProductLevel(uiData, html);
		html.append("<br>");
		html.append("</body></html>");

		html.append("</table>");
		html.append("<br>");
		generateReportForIssueERP(issueList, html);
		html.append("<br>");
		html.append("</body></html>");

		// Write the HTML content to a file
		try (FileWriter writer = new FileWriter("Report.html")) {
			writer.write(html.toString());
			System.out.println(
					"HTML report generated successfully at: D:\\Automation Data\\GIT Scripts\\Login Page Automation Script\\erp_automation\\target\\Report.html");
		} catch (IOException e) {
			System.err.println("Error occurred while generating HTML report: " + e.getMessage());
		}
	}

	private static int getMinusDays() {
		if (LocalDate.now().getDayOfWeek() == DayOfWeek.MONDAY) {
			return 2;
		} else {
			return 1;
		}
	}

	@When("User read the excel sheet")
	public void user_read_the_excel_sheet() {
		ExcelReader reader = new ExcelReader();
		List<CRMData> con = reader.readExcel("C:\\Users\\AntonyAshwinthAR\\Desktop\\Final GP\\24-25_GrossProfit.xlsx");
		excelData = con;
	}

	@When("User compare the GP Data")
	public void user_compare_the_gp_data() throws InterruptedException, SQLException {

		List<CRMData> result = CompareAndWriteExcel.compareData(uiData, excelData);
	}
}
