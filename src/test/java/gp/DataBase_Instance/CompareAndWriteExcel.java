package gp.DataBase_Instance;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import gp.Step.StepDefinition;

public class CompareAndWriteExcel extends StepDefinition {

	public static List<CRMData> compareData(List<CRMData> uiData, List<CRMData> excelData) {
		List<CRMData> result = new ArrayList<>();
		for (CRMData uiRecord : uiData) {
			
			boolean foundMatch = false;

			for (CRMData excelRecord : excelData) {
				if(uiRecord.getInvoice_no().concat("-").concat(uiRecord.getProduct_code())
						.equals(excelRecord.getInvoice_no().concat("-").concat(excelRecord.getProduct_code()))){
					CRMData resultData = new CRMData();
					resultData.setInvoice_no(excelRecord.getInvoice_no());
					resultData.setProduct_code(excelRecord.getProduct_code());
//					resultData.setGross_profit_percentage(excelRecord.getGross_profit_percentage());
					resultData.setExcel_gross_profit_percentage(excelRecord.getGross_profit_percentage());
					resultData.setUi_gross_profit_percentage(uiRecord.getGross_profit_percentage());
					resultData.setGross_profit_percentage_diff(
							String.valueOf(
									subtractPercentages(excelRecord.getGross_profit_percentage(),
											uiRecord.getGross_profit_percentage()))+"%");	
									
							
					if (uiRecord.getGross_profit_percentage().equals(excelRecord.getGross_profit_percentage())) {

						resultData.setGpmatch(true);
//						System.out.println(resultData);
						result.add(resultData);
					} else {
						resultData.setGpmatch(false);
//						System.out.println(resultData);
						result.add(resultData);
					}
					break;
				}
			}
		}
		
		String filePath = "result.xlsx";

		writeResultToExcel(result, filePath);

		// Optionally, you could also add any excelData records that do not have a
		// corresponding UIData record here
		return result;

	}
	
	public static double subtractPercentages(String p1, String p2) {
        // Remove the '%' character and parse the remaining string to a double
        double value1 = Double.parseDouble(p1.replace("%", ""));
        double value2 = Double.parseDouble(p2.replace("%", ""));

        // Perform the subtraction
        double result = value1 - value2;

        // Return the result
        return result;
    }

	public static void main(String[] args) {
		// Example usage
		List<CRMData> uiData = new ArrayList<>();
		List<CRMData> excelData = new ArrayList<>();

		// Add data to uiData and excelData

		List<CRMData> result = compareData(uiData, excelData);
		for (CRMData data : result) {
			System.out.println(data);
		}
	}

	public static void writeResultToExcel(List<CRMData> result, String filePath) {

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Comparison Result");

		// Create header row
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("Invoice No");
		headerRow.createCell(1).setCellValue("Product Code");
		headerRow.createCell(2).setCellValue("Excel Gross Profit Percentage");
		headerRow.createCell(3).setCellValue("UI Gross Profit Percentage");
		headerRow.createCell(4).setCellValue("Diff");
		headerRow.createCell(5).setCellValue("GP Match");

		// Fill data rows
		int rowNum = 1;
		for (CRMData data : result) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(data.getInvoice_no());
			row.createCell(1).setCellValue(data.getProduct_code());
			row.createCell(2).setCellValue(data.getExcel_gross_profit_percentage());
			row.createCell(3).setCellValue(data.getUi_gross_profit_percentage());
			row.createCell(4).setCellValue(data.getGross_profit_percentage_diff());
			row.createCell(5).setCellValue(data.isGpmatch() ? "True" : "False");
		}

		// Write the workbook to a file
		try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
			workbook.write(fileOut);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
