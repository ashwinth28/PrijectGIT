package ecERP.Asset;

import static org.junit.Assume.assumeThat;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.transport.DockerHttpClient.Request.Method;

import ecERP.libglobal.LibGlobal;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AssetManagement_StepDefinition extends LibGlobal{

		public static WebDriver driver;
		public String popup1;
		public int lastAppearedIndex;

		@Given("User on the login page")
		public void user_on_the_login_page() {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			driver.get("https://qa-erp.e-consystems.net");
//			driver.get("https://stage-erp.e-consystems.net");
//			driver.get("http://192.168.8.119:8080/#/login");
//			driver.get("http://localhost:8080/#/");
//			driver.get("http://localhost:4200/#/");
			driver.manage().window().maximize();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement appTitle = driver.findElement(By.xpath("//h2[@class = 'heading-erp'][1]"));
			wait.until(ExpectedConditions.visibilityOf(appTitle));
			String title = appTitle.getText();
			System.out.println("Title of the Application: " + title);

			String pageTitle = driver.getTitle();
			System.out.println("Page Title: " + pageTitle);

			WebElement logo = driver.findElement(By.xpath("//img[@class = 'logo-src'][1]"));
			Boolean l = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete "
					+ "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", logo);
			// verify if status is true
			if (l) {
				System.out.println("Logo present");
			} else {
				System.out.println("Logo not present");
			}
		}

		@Given("User enters the SCM Team Member {string} and {string}")
		public void user_enters_the_scm_team_member_and(String username, String password) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement loginID = driver.findElement(By.xpath("//input[@id='loginkey'][1]"));
			loginID.sendKeys(username);
			WebElement loginPassword = driver.findElement(By.xpath("//input[@id='password'][1]"));
			loginPassword.sendKeys(password);
			WebElement btnClick = driver.findElement(By.xpath("//input[@id='remembermeCheck'][1]"));
			btnClick.click();
			WebElement btnUnclick = driver.findElement(By.xpath("//input[@id='remembermeCheck'][1]"));
			btnUnclick.click();
			WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit'][1]"));
			signInButton.click();
		}

		@When("User create the PO Request for PO ORDER")
		public void user_create_the_po_request_for_po_order() throws IOException, InterruptedException {

			WebElement purchaseOrderBtn = driver.findElement(By.xpath("(//a[contains(text(),'Purchase Order')])[1]"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(purchaseOrderBtn,
					By.xpath("(//a[contains(text(),'Purchase Order')])[1]")));
			purchaseOrderBtn.click();

			WebElement addBtn = driver.findElement(By.xpath("(//button[@title='Add' and @type='button'])[1]"));
			addBtn.click();
			Thread.sleep(1000);

			WebElement branch = (driver.findElement(By.xpath("(//select)[1]")));
			String mas_data = getData("Admin Fields", 11, 0);
			select(branch).selectByVisibleText(mas_data);
			Thread.sleep(500);

			WebElement wareHouse = (driver.findElement(By.xpath("(//select)[2]")));
			String mas_data1 = getData("Admin Fields", 11, 1);
			select(wareHouse).selectByVisibleText(mas_data1);
			Select s = new Select(driver.findElement(By.xpath("(//select)[3]")));
			List<WebElement> options = s.getOptions();
			WebElement storeFieldText = s.getFirstSelectedOption();
			System.out.println("Store : " + storeFieldText.getText());
			Thread.sleep(1000);
			WebElement poNumberFieldText = driver.findElement(
					By.xpath("(//div//app-form-text//div//input[@tooltipposition='bottom' and @type='text'])[1]"));
			System.out.println("PO Number : " + poNumberFieldText.getAttribute("value"));

			WebElement poStatusFieldText = driver.findElement(
					By.xpath("(//div//app-form-text//div//input[@tooltipposition='bottom' and @type='text'])[2]"));
			System.out.println("PO Status : " + poStatusFieldText.getAttribute("value"));

			WebElement poDateFieldValue = driver.findElement(
					By.xpath("(//div//app-form-text//div//input[@tooltipposition='bottom' and @type='text'])[3]"));
			System.out.println("PO Date : " + poDateFieldValue.getAttribute("value"));

			WebElement vendorField = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
			String mas_data2 = getData("Admin Fields", 11, 3);
			vendorField.sendKeys(mas_data2);
			Thread.sleep(500);

			List<WebElement> vendorList = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
			for (WebElement webElement : vendorList) {
				String list = webElement.getText();
				if (list.contains(mas_data2)) {
					Thread.sleep(500);
					JavascriptExecutor k = (JavascriptExecutor) driver;
					k.executeScript("arguments[0].click();", webElement);
					System.out.println(webElement);
					break;
				}
				Thread.sleep(1000);
			}

			Select s1 = new Select(driver.findElement(By.xpath("(//select)[7]")));
			List<WebElement> options1 = s1.getOptions();
			WebElement paymentTerms = s1.getFirstSelectedOption();
			System.out.println("Payment Terms : " + paymentTerms.getText());

			Select s2 = new Select(driver.findElement(By.xpath("(//select)[8]")));
			List<WebElement> options2 = s2.getOptions();
			WebElement paymentMode = s2.getFirstSelectedOption();
			System.out.println("Payment Mode : " + paymentMode.getText());

			Select s3 = new Select(driver.findElement(By.xpath("(//select)[9]")));
			List<WebElement> options3 = s3.getOptions();
			WebElement poOwner = s3.getFirstSelectedOption();
			System.out.println("PO Owner : " + poOwner.getText());

			// PO Order - RM Type

			WebElement orderType = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//select)[5]")));
			String mas_data3 = getData("Admin Fields", 11, 4);
			selectOptionByText(orderType, mas_data3);

			WebElement materialType = driver.findElement(By.xpath("(//select)[6]"));
			String mas_data4 = getData("Admin Fields", 11, 5);
			selectOptionByText(materialType, mas_data4);

			WebElement jiraNumber = driver.findElement(By.xpath("(//input[@id='JiraNo' and @type='text'])[1]"));
			jiraNumber.sendKeys("12345");

			WebElement quoteNumber = driver.findElement(By.xpath("(//input[@id='QuoteNo' and @type='text'])[1]"));
			quoteNumber.sendKeys("54321");

			WebElement quoteDate = driver.findElement(By.xpath("(//input [@type='date'])[1]"));
			String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			quoteDate.sendKeys(date);

			Select s4 = new Select(driver.findElement(By.xpath("(//select)[10]")));
			List<WebElement> options4 = s4.getOptions();
			WebElement approvalStatus = s4.getFirstSelectedOption();
			System.out.println("Approval Status : " + approvalStatus.getText());
			Thread.sleep(1000);

			// Grid Values

			// RM Grid Fields

			if (mas_data4.contains("RM")) {

				MRI_Multiple_Lineitems_POGridFields_RM(driver);

			}

			// NBM Grid Fields
			else {
				
//1st Line
				JavascriptExecutor j = (JavascriptExecutor) driver;
				WebElement costCenter = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l1 r1')]"));
				j.executeScript("arguments[0].click();", costCenter);
				WebElement costCenter1 = driver
						.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
				String costcenter_string = getData("Grid_Data", 2, 15);

				int maxretries = 3;
				for (int i = 0; i < maxretries; i++) {
					try {
						costCenter1 = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
						select(costCenter1).selectByVisibleText(costcenter_string);
						break;
					} catch (StaleElementReferenceException e) {
						System.out.println("Maximum Retry Failed");
					}
				}
				Thread.sleep(500);

				WebElement expenseCategory = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l2 r2')]"));
				j.executeScript("arguments[0].click();", expenseCategory);
				WebElement expenseCategory1 = driver
						.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
				String expensecategory_string = getData("Grid_Data", 2, 16);
				select(expenseCategory1).selectByVisibleText(expensecategory_string);

				WebElement partNo = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l3 r3')]"));
				j.executeScript("arguments[0].click();", partNo);
				WebElement partNo1 = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
				String grid_data = getData("Grid_Data", 2, 17);
				partNo1.sendKeys(grid_data);
				WebElement autoSuggestion = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
				autoSuggestion.click();

				WebElement qty = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l4 r4')]"));
				j.executeScript("arguments[0].click();", qty);
				Thread.sleep(500);
				try {
					j.executeScript("arguments[0].click();", qty);
				} catch (StaleElementReferenceException e3) {
					qty = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l4 r4')]"));
					j.executeScript("arguments[0].click();", qty);
				}
				WebElement qty1 = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l4 r4')]//input"));
				String grid_data3 = getData("Grid_Data", 2, 18);
				qty1.sendKeys(grid_data3);

				WebElement unitPrice = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l5 r5')]"));
				j.executeScript("arguments[0].click();", unitPrice);
				Thread.sleep(500);
				try {
					j.executeScript("arguments[0].click();", unitPrice);
					Thread.sleep(500);
				} catch (StaleElementReferenceException e4) {
					unitPrice = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l5 r5')]"));
					j.executeScript("arguments[0].click();", unitPrice);
				}
				WebElement unitPrice1 = driver
						.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l5 r5')]//input"));
				String grid_data4 = getData("Grid_Data", 2, 19);
				unitPrice1.sendKeys(grid_data4);

				WebElement UOM = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l9 r9')]"));
				j.executeScript("arguments[0].click();", UOM);
				Thread.sleep(500);
				try {
					j.executeScript("arguments[0].click();", UOM);
				} catch (StaleElementReferenceException e5) {
					UOM = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l9 r9')]"));
					j.executeScript("arguments[0].click();", UOM);
				}
				WebElement UOM1 = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l9 r9')]//select"));
				selectOptionByIndex(UOM1, 0);

				WebElement deliveryDate = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l10 r10')]"));
				j.executeScript("arguments[0].click();", deliveryDate);
				Thread.sleep(500);
				try {
					j.executeScript("arguments[0].click();", deliveryDate);
				} catch (StaleElementReferenceException e5) {
					deliveryDate = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l10 r10')]"));
					j.executeScript("arguments[0].click();", deliveryDate);
				}
				WebElement deliverDate1 = driver
						.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l10 r10')]//input"));
				String date1 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				deliverDate1.sendKeys(date1);

				// With IQC checkbox code

				WebElement checkBox = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l11 r11')]"));
				j.executeScript("arguments[0].click();", checkBox);
				Thread.sleep(500);
				try {
					j.executeScript("arguments[0].click();", checkBox);
				} catch (StaleElementReferenceException e5) {
					checkBox = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l11 r11')]"));
					j.executeScript("arguments[0].click();", checkBox);
				}
				WebElement checkBox1 = driver
						.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l11 r11')]//input[@type='checkbox']"));
				j.executeScript("arguments[0].click();", checkBox1);

				// Withot IQC Checkbox code
				WebElement insReason = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l12 r12')]"));
				j.executeScript("arguments[0].click();", insReason);
				Thread.sleep(500);
				try {
					j.executeScript("arguments[0].click();", insReason);
				} catch (StaleElementReferenceException e5) {
					insReason = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l12 r12')]"));
					j.executeScript("arguments[0].click();", insReason);
				}
				WebElement reasonText = driver
						.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l12 r12')]//input[@type='text']"));
				reasonText.sendKeys("Not Required");
				Thread.sleep(500);
				driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l11 r11')]")).click();
				
				WebElement add_btn = driver.findElement(By.xpath("//div//button[@tooltipposition='bottom'][1]//i"));
				j.executeScript("arguments[0].click();", add_btn);
				
//2nd Line
				WebElement costCenter2 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l1 r1')]"));
				j.executeScript("arguments[0].click();", costCenter2);
				WebElement costCenter3 = driver
						.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
				String costcenter_string1 = getData("Grid_Data", 3, 15);

				for (int i = 0; i < maxretries; i++) {
					try {
						costCenter3 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
						select(costCenter3).selectByVisibleText(costcenter_string1);
						break;
					} catch (StaleElementReferenceException e) {
						System.out.println("Maximum Retry Failed");
					}
				}

				Thread.sleep(500);

				WebElement expenseCategory2 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l2 r2')]"));
				j.executeScript("arguments[0].click();", expenseCategory2);
				WebElement expenseCategory3 = driver
						.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
				String expensecategory_string1 = getData("Grid_Data", 3, 16);
				select(expenseCategory3).selectByVisibleText(expensecategory_string1);

				WebElement partNo2 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l3 r3')]"));
				j.executeScript("arguments[0].click();", partNo2);
				WebElement partNo3 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
				String partNo_string = getData("Grid_Data", 3, 17);
				partNo3.sendKeys(partNo_string);
				WebElement autoSuggestion1 = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
				autoSuggestion1.click();

				WebElement qty2 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l4 r4')]"));
				j.executeScript("arguments[0].click();", qty2);
				Thread.sleep(500);
				try {
					j.executeScript("arguments[0].click();", qty2);
				} catch (StaleElementReferenceException e3) {
					qty2 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l4 r4')]"));
					j.executeScript("arguments[0].click();", qty2);
				}
				WebElement qty3 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l4 r4')]//input"));
				String qty_string = getData("Grid_Data", 3, 18);
				qty3.sendKeys(qty_string);

				WebElement unitPrice2 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l5 r5')]"));
				j.executeScript("arguments[0].click();", unitPrice2);
				Thread.sleep(500);
				try {
					j.executeScript("arguments[0].click();", unitPrice2);
					Thread.sleep(500);
				} catch (StaleElementReferenceException e4) {
					unitPrice2 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l5 r5')]"));
					j.executeScript("arguments[0].click();", unitPrice2);
				}
				WebElement unitPrice3 = driver
						.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l5 r5')]//input"));
				String unitprice_string = getData("Grid_Data", 3, 19);
				unitPrice3.sendKeys(unitprice_string);

				WebElement UOM2 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l9 r9')]"));
				j.executeScript("arguments[0].click();", UOM2);
				Thread.sleep(500);
				try {
					j.executeScript("arguments[0].click();", UOM2);
				} catch (StaleElementReferenceException e5) {
					UOM2 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l9 r9')]"));
					j.executeScript("arguments[0].click();", UOM2);
				}
				WebElement UOM3 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l9 r9')]//select"));
				selectOptionByIndex(UOM3, 0);

				WebElement deliveryDate2 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l10 r10')]"));
				j.executeScript("arguments[0].click();", deliveryDate2);
				Thread.sleep(500);
				try {
					j.executeScript("arguments[0].click();", deliveryDate2);
				} catch (StaleElementReferenceException e5) {
					deliveryDate2 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l10 r10')]"));
					j.executeScript("arguments[0].click();", deliveryDate2);
				}
				WebElement deliveryDate3 = driver
						.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l10 r10')]//input"));
				String deliverydate_string = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				deliveryDate3.sendKeys(deliverydate_string);

				// With IQC checkbox code

				WebElement checkBox2 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l11 r11')]"));
				j.executeScript("arguments[0].click();", checkBox2);
				Thread.sleep(500);
				try {
					j.executeScript("arguments[0].click();", checkBox2);
				} catch (StaleElementReferenceException e5) {
					checkBox2 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l11 r11')]"));
					j.executeScript("arguments[0].click();", checkBox2);
				}
				WebElement checkBox3 = driver
						.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l11 r11')]//input[@type='checkbox']"));
				j.executeScript("arguments[0].click();", checkBox3);

				// Withot IQC Checkbox code
				WebElement insReason1 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l12 r12')]"));
				j.executeScript("arguments[0].click();", insReason1);
				Thread.sleep(500);
				try {
					j.executeScript("arguments[0].click();", insReason1);
				} catch (StaleElementReferenceException e5) {
					insReason1 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l12 r12')]"));
					j.executeScript("arguments[0].click();", insReason1);
				}
				WebElement reasonText1 = driver
						.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l12 r12')]//input[@type='text']"));
				reasonText1.sendKeys("Not Required");
				Thread.sleep(500);
				driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l11 r11')]")).click();

				j.executeScript("arguments[0].click();", add_btn);
				
//3rd Line
				WebElement costCenter4 = driver.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l1 r1')]"));
				j.executeScript("arguments[0].click();", costCenter4);
				WebElement costCenter5 = driver
						.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
				String costcenter_string2 = getData("Grid_Data", 4, 15);

				for (int i = 0; i < maxretries; i++) {
					try {
						costCenter5 = driver.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
						select(costCenter5).selectByVisibleText(costcenter_string2);
						break;
					} catch (StaleElementReferenceException e) {
						System.out.println("Maximum Retry Failed");
					}
				}

				Thread.sleep(500);

				WebElement expenseCategory4 = driver.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l2 r2')]"));
				j.executeScript("arguments[0].click();", expenseCategory4);
				WebElement expenseCategory5 = driver
						.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
				String expensecategory_string2 = getData("Grid_Data", 4, 16);
				select(expenseCategory5).selectByVisibleText(expensecategory_string2);

				WebElement partNo4 = driver.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l3 r3')]"));
				j.executeScript("arguments[0].click();", partNo4);
				WebElement partNo5 = driver.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
				String partNo_string1 = getData("Grid_Data", 4, 17);
				partNo5.sendKeys(partNo_string1);
				WebElement autoSuggestion2 = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
				autoSuggestion2.click();

				WebElement qty4 = driver.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l4 r4')]"));
				j.executeScript("arguments[0].click();", qty4);
				Thread.sleep(500);
				try {
					j.executeScript("arguments[0].click();", qty4);
				} catch (StaleElementReferenceException e3) {
					qty4 = driver.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l4 r4')]"));
					j.executeScript("arguments[0].click();", qty4);
				}
				WebElement qty5 = driver.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l4 r4')]//input"));
				String qty_string1 = getData("Grid_Data", 4, 18);
				qty5.sendKeys(qty_string1);

				WebElement unitPrice4 = driver.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l5 r5')]"));
				j.executeScript("arguments[0].click();", unitPrice4);
				Thread.sleep(500);
				try {
					j.executeScript("arguments[0].click();", unitPrice4);
					Thread.sleep(500);
				} catch (StaleElementReferenceException e4) {
					unitPrice4 = driver.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l5 r5')]"));
					j.executeScript("arguments[0].click();", unitPrice4);
				}
				WebElement unitPrice5 = driver
						.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l5 r5')]//input"));
				String unitprice_string1 = getData("Grid_Data", 4, 19);
				unitPrice5.sendKeys(unitprice_string1);

				WebElement UOM4 = driver.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l9 r9')]"));
				j.executeScript("arguments[0].click();", UOM4);
				Thread.sleep(500);
				try {
					j.executeScript("arguments[0].click();", UOM4);
				} catch (StaleElementReferenceException e5) {
					UOM4 = driver.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l9 r9')]"));
					j.executeScript("arguments[0].click();", UOM4);
				}
				WebElement UOM5 = driver.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l9 r9')]//select"));
				selectOptionByIndex(UOM5, 0);

				WebElement deliveryDate4 = driver.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l10 r10')]"));
				j.executeScript("arguments[0].click();", deliveryDate4);
				Thread.sleep(500);
				try {
					j.executeScript("arguments[0].click();", deliveryDate4);
				} catch (StaleElementReferenceException e5) {
					deliveryDate4 = driver.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l10 r10')]"));
					j.executeScript("arguments[0].click();", deliveryDate4);
				}
				WebElement deliveryDate5 = driver
						.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l10 r10')]//input"));
				String deliverydate_string1 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				deliveryDate5.sendKeys(deliverydate_string1);

				// With IQC checkbox code

				WebElement checkBox4 = driver.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l11 r11')]"));
				j.executeScript("arguments[0].click();", checkBox4);
				Thread.sleep(500);
				try {
					j.executeScript("arguments[0].click();", checkBox4);
				} catch (StaleElementReferenceException e5) {
					checkBox4 = driver.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l11 r11')]"));
					j.executeScript("arguments[0].click();", checkBox4);
				}
				WebElement checkBox5 = driver
						.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l11 r11')]//input[@type='checkbox']"));
				j.executeScript("arguments[0].click();", checkBox5);

				// Withot IQC Checkbox code
				WebElement insReason2 = driver.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l12 r12')]"));
				j.executeScript("arguments[0].click();", insReason2);
				Thread.sleep(500);
				try {
					j.executeScript("arguments[0].click();", insReason2);
				} catch (StaleElementReferenceException e5) {
					insReason2 = driver.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l12 r12')]"));
					j.executeScript("arguments[0].click();", insReason2);
				}
				WebElement reasonText2 = driver
						.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l12 r12')]//input[@type='text']"));
				reasonText2.sendKeys("Not Required");
				Thread.sleep(500);
				driver.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l11 r11')]")).click();	
			}
		}

		@When("User click on the save button")
		public void user_click_on_the_save_button() throws InterruptedException {
			try {
				Thread.sleep(500);
				WebElement saveButton = driver
						.findElement(By.xpath("(//div//button[@id='submitbutton' and @type='submit'])"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", saveButton);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.elementToBeClickable(saveButton));
				if (saveButton.isEnabled()) {
					System.out.println("Save Button Enabled");
					js.executeScript("arguments[0].click();", saveButton);
				} else {
					wait.until(ExpectedConditions.visibilityOf(saveButton));
					js.executeScript("arguments[0].click();", saveButton);
					System.out.println("Save Button Check Retry");
				}
//				WebElement successfullPoCreation = wait.until(ExpectedConditions.presenceOfElementLocated(
//						By.xpath("//app-wstable//div[@class='ws-table-head']//table[@role='grid']//tbody//tr[1]")));
//				js.executeScript("window.scrollTo(0,0);", successfullPoCreation);
//				System.out.println("Successfull PO Creation : " + successfullPoCreation.getText());
			} catch (StaleElementReferenceException | NoSuchElementException e) {
			}
			Thread.sleep(5000);
		}

		@When("User click on the Edit button")
		public void user_click_on_the_Edit_button() {
			JavascriptExecutor j = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement purchaseOrderBtn = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(),'Purchase Order')])[1]")));
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
			wait1.until(ExpectedConditions.elementToBeClickable(purchaseOrderBtn));
			j.executeScript("arguments[0].click();", purchaseOrderBtn);

			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement editBtn = wait2.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//table[@role='grid']//tbody//tr[1]//th//button[1]//i")));
			WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait3.until(ExpectedConditions.elementToBeClickable(editBtn));
			j.executeScript("arguments[0].click();", editBtn);

			WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/app-root/div/app-main/div/app-submenu/div/app-tab/section/div/app-gridwrapper/div/div/div/app-form/section/div")));
		}

		@When("User verify the PO and providing Pre-Approval")
		public void user_verify_the_po_and_providing_pre_approval() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement dropdown = driver.findElement(By.xpath("(//div//app-form-select//select)"));
			if (dropdown.isEnabled()) {
				Select s = new Select(dropdown);
				Thread.sleep(500);
				s.selectByIndex(1);
				Thread.sleep(500);
			} else {
				System.out.println("Dropdown is disabled. Cannot select an option.");
			}
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//div[1]//input[@pattern='[a-zA-Z0-9*/\\s]+' and @type='text'])[1]")));
			WebElement remarks = driver
					.findElement(By.xpath("(//div[1]//input[@pattern='[a-zA-Z0-9*/\\s]+' and @type='text'])[1]"));
			remarks.sendKeys("Siva Pradeep : Pre Approved");
			Thread.sleep(1000);
		}

		@When("User click on the Save button")
		public void user_click_on_the_Save_button() throws InterruptedException {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Thread.sleep(1000);
			WebElement saveButton = driver.findElement(By.xpath("(//button[@id='submitbutton' and @type='submit'])"));
			js.executeScript("arguments[0].scrollIntoView(true);", saveButton);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(saveButton));
			
			if (saveButton.isEnabled()) {
				js.executeScript("arguments[0].click();", saveButton);
				System.out.println("Save Button Enabled");
			} else {
				System.out.println("Save Button Disabled");
				driver.quit();
			}
			Thread.sleep(2000);
		}

		@Then("User verifies the PO Status has been changed and Signout")
		public void user_verifies_the_po_status_has_been_changed_and_signout() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement poStatusFilter = driver.findElement(By.xpath("//select[@name='postatusid']"));
			selectOptionByIndex(poStatusFilter, 0);
			Thread.sleep(1000);

			WebElement poStatus = driver
					.findElement(By.xpath("//app-wstable//div[@class='ws-table-head']//table[@role='grid']//tbody//tr[1]"));
			System.out.println("Approval Status : " + poStatus.getText());
			WebElement profileClick = driver.findElement(By.xpath("(//app-header//div//div//span[@class = 'd-block'])[1]"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,0);", profileClick);
			wait.until(ExpectedConditions.elementToBeClickable(profileClick));
			js.executeScript("arguments[0].click();", profileClick);
			WebElement signOutBtn = driver.findElement(
					By.xpath("//h3[contains (@class, 'dropdown-item-title') and contains (text(), 'Sign out ')][1]"));
			signOutBtn.click();
			driver.quit();
		}

		@Given("User enters the Operations Head {string} and {string}")
		public void user_enters_the_operations_head_and(String username, String password) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement loginID = driver.findElement(By.xpath("//input[@id='loginkey'][1]"));
			loginID.sendKeys(username);
			WebElement loginPassword = driver.findElement(By.xpath("//input[@id='password'][1]"));
			loginPassword.sendKeys(password);
			WebElement btnClick = driver.findElement(By.xpath("//input[@id='remembermeCheck'][1]"));
			btnClick.click();
			WebElement btnUnclick = driver.findElement(By.xpath("//input[@id='remembermeCheck'][1]"));
			btnUnclick.click();
			WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit'][1]"));
			signInButton.click();
		}

		@Given("User verify the PO and providing Final-Approval")
		public void user_verify_the_po_and_providing_final_approval() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement dropdown = driver.findElement(By.xpath("(//div//app-form-select//select)"));
			if (dropdown.isEnabled()) {
				Select s = new Select(dropdown);
				Thread.sleep(500);
				s.selectByIndex(1);
				Thread.sleep(500);
			} else {
				System.out.println("Dropdown is disabled. Cannot select an option.");
			}
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//div[1]//input[@pattern='[a-zA-Z0-9*/\\s]+' and @type='text'])[1]")));
			WebElement remarks = driver
					.findElement(By.xpath("(//div[1]//input[@pattern='[a-zA-Z0-9*/\\s]+' and @type='text'])[1]"));
			remarks.sendKeys("Salim : Final Approved");
			Thread.sleep(1000);
		}

		@Given("User click on the Issue icon")
		public void user_click_on_the_issue_icon() throws InterruptedException {
			JavascriptExecutor j = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement purchaseOrderBtn = driver.findElement(By.xpath("(//a[contains(text(),'Purchase Order')])[1]"));
			wait.until(ExpectedConditions.elementToBeClickable(purchaseOrderBtn));
			j.executeScript("arguments[0].click();", purchaseOrderBtn);
			Thread.sleep(1000);

			int maxretries = 3;
			for (int i = 0; i < maxretries; i++) {
				try {
					WebElement issueIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(
							(By.xpath("(//table[@role='grid']//tbody//tr[1]//th//button[2]//i)[1]"))));
					j.executeScript("arguments[0].click();", issueIcon);
					break;
				} catch (StaleElementReferenceException | NoSuchElementException e) {
					System.out.println("Maximum Retry Failed");
				}
			}
			Thread.sleep(5000);
		}

		@When("User click on the Issue button")
		public void user_click_on_the_issue_button() throws InterruptedException {
			Select s = new Select(driver.findElement(By.xpath("(//select)[11]")));
			List<WebElement> options = s.getOptions();
			WebElement poApprovalStatus = s.getFirstSelectedOption();
			System.out.println("Approval Status : " + poApprovalStatus.getText());

			WebElement issueButton = driver.findElement(By.xpath("(//button[@id='submitbutton' and @type='submit'])"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", issueButton);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(issueButton));
			js.executeScript("arguments[0].click();", issueButton);
			Thread.sleep(2000);
		}

		@Then("User verifies the PO Status has been changed to Issued and Signout")
		public void user_verifies_the_po_status_has_been_changed_to_issued_and_signout() throws InterruptedException {
			WebElement successfullyIssued = driver
					.findElement(By.xpath("//app-wstable//div[@class='ws-table-head']//table[@role='grid']//tbody//tr[1]"));
			System.out.println("Successfull PO Issued : " + successfullyIssued.getText());
			Thread.sleep(1000);

			WebElement profileClick = driver.findElement(By.xpath("(//app-header//div//div//span[@class = 'd-block'])[1]"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,0);", profileClick);
			Thread.sleep(1000);
			profileClick.click();
			WebElement signOutBtn = driver.findElement(
					By.xpath("//h3[contains (@class, 'dropdown-item-title') and contains (text(), 'Sign out ')][1]"));
			signOutBtn.click();
			driver.quit();
			Thread.sleep(1000);
		}

		@Given("User enters the Store Team Member {string} and {string}")
		public void user_enters_the_store_team_member_and(String username, String password) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement loginID = driver.findElement(By.xpath("//input[@id='loginkey'][1]"));
			loginID.sendKeys(username);
			WebElement loginPassword = driver.findElement(By.xpath("//input[@id='password'][1]"));
			loginPassword.sendKeys(password);
			WebElement btnClick = driver.findElement(By.xpath("//input[@id='remembermeCheck'][1]"));
			btnClick.click();
			WebElement btnUnclick = driver.findElement(By.xpath("//input[@id='remembermeCheck'][1]"));
			btnUnclick.click();
			WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit'][1]"));
			signInButton.click();
		}

		@When("User create the GRN Request for Fully Received")
		public void user_create_the_grn_request_for_fully_received()
				throws InterruptedException, IOException {
			JavascriptExecutor j = (JavascriptExecutor) driver;

			WebElement receiptmodule = driver.findElement(By.xpath("(//a[contains(text(),'Receipt')])[1]"));
			receiptmodule.click();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement addBtn = driver.findElement(By.xpath("(//button[@title='Add' and @type='button'])[1]"));
			wait.until(ExpectedConditions.elementToBeClickable(addBtn));
			addBtn.click();
			Thread.sleep(2000);

			// Store Tile Drop-down Fields

			WebElement storeTileDropdown = driver.findElement(By.xpath("//*[@id='headingOne']/h5/button"));
			wait.until(ExpectedConditions.elementToBeClickable(storeTileDropdown));
			j.executeScript("arguments[0].click();", storeTileDropdown);
			Thread.sleep(700);

			WebElement branch = (driver
					.findElement(By.xpath("//*[@id='collapseOne']/div/div[1]/app-form-dyna-select/div/select")));
			wait.until(ExpectedConditions.visibilityOf(branch));
			String mas_data = getData("Admin Fields", 11, 0);
			select(branch).selectByVisibleText(mas_data);
			Thread.sleep(300);

			WebElement store = (driver
					.findElement(By.xpath("//*[@id='collapseOne']/div/div[2]/app-form-dyna-select/div/select")));
			String mas_data1 = getData("Admin Fields", 11, 2);
			select(store).selectByVisibleText(mas_data1);
			Thread.sleep(300);

			WebElement orderType = (driver
					.findElement(By.xpath("//*[@id='collapseOne']/div/div[3]/app-form-dyna-select/div/select")));
			String mas_data2 = getData("Admin Fields", 11, 4);
			select(orderType).selectByVisibleText(mas_data2);
			Thread.sleep(300);

			WebElement materialType = (driver
					.findElement(By.xpath("//*[@id='collapseOne']/div/div[4]/app-form-dyna-select/div/select")));
			String mas_data3 = getData("Admin Fields", 11, 5);
			select(materialType).selectByVisibleText(mas_data3);
			Thread.sleep(300);

			WebElement vendorField = driver.findElement(By.xpath("(//input[@type='text' and @role='combobox'])[1]"));
			String mas_data4 = getData("Admin Fields", 11, 3);
			vendorField.sendKeys(mas_data4);
			Thread.sleep(400);

			List<WebElement> vendorList = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
			for (WebElement webElement : vendorList) {
				String list = webElement.getText();
				if (list.contains(mas_data4)) {
					Thread.sleep(500);
					webElement.click();
					System.out.println(webElement);
					break;
				}
				Thread.sleep(1000);
			}

			WebElement multiPO = driver
					.findElement(By.xpath("//*[@id='collapseOne']/div/div[6]/app-form-dyna-select/div/select"));
			select(multiPO);
			int lastIndex = getOptions(multiPO).size() - 1;
			selectOptionByIndex(multiPO, lastIndex);
			Thread.sleep(500);

			// Master Fields
			/* /for "DOMESTIC"/ */
			WebElement purchaseCategoryDomestic = driver.findElement(By.xpath("(//app-form-dyna-select//div//select)[3]"));
			String attribute2 = purchaseCategoryDomestic.getAttribute("value");
			System.out.println(attribute2);
			System.out.println(attribute2.equals("1: 2"));

			if (attribute2.equals("1: 2")) {

				WebElement receiptNumber = driver.findElement(
						By.xpath("(//div//app-form-text//div//input[@tooltipposition='bottom' and @type='text'])[1]"));
				if (receiptNumber.isEnabled()) {
					System.out.println("Field is Enabled as Not Expected");
				} else {
					System.out.println("Field is Disabled as Expected");
					System.out.println("Receipt Number : " + receiptNumber.getAttribute("value"));
				}

				WebElement receiptDateandTime = driver
						.findElement(By.xpath("(//app-form-text//div//input [@type='text'])[2]"));
				if (receiptDateandTime.isEnabled()) {
					System.out.println("Field is Enabled as Not Expected");
				} else {
					System.out.println("Field is Disabled as Expected");
					System.out.println("Receipt Date/Time : " + receiptDateandTime.getAttribute("value"));
				}

				WebElement invoiceDate = driver.findElement(By.xpath("(//input [@type='date'])[1]"));
				String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				invoiceDate.sendKeys(date);

				WebElement invoiceNumber = driver.findElement(By.xpath("(//input[@pattern='[a-zA-Z0-9*-{}@()/\\s]+'])[2]"));
				invoiceNumber.sendKeys(UUID());

				WebElement logisticsCarrier = driver.findElement(By.xpath("(//app-form-dyna-select//div//select)[1]"));
				selectOptionByIndex(logisticsCarrier, 1);

				WebElement incoterm = driver.findElement(By.xpath("(//app-form-dyna-select//div//select)[2]"));
				if (incoterm.isEnabled()) {
					System.out.println("Field is Enabled as Not Expected");
				} else {
					System.out.println("Field is Disabled as Expected");
					System.out.println("Incoterm : " + incoterm.getAttribute("text"));
				}

				WebElement purchaseCategory = driver
						.findElement(By.xpath("(//app-form-dyna-select//div//select)[3]//option[@value='1: 2']"));
				if (purchaseCategory.isEnabled()) {
					System.out.println("Field is Enabled as Not Expected");
				} else {
					System.out.println("Field is Disabled as Expected");
					System.out.println("Purchase Category : " + purchaseCategory.getAttribute("text"));
				}

				WebElement trackingNo = driver.findElement(By.xpath("(//input[@pattern='[a-zA-Z0-9*-{}@()/\\s]+'])[3]"));
				trackingNo.sendKeys("12345");
				Thread.sleep(500);

				WebElement noOfPackages = driver.findElement(By.xpath("(//input[@pattern='[0-9]*'])[1]"));
				noOfPackages.sendKeys("10");

				// Store Tile Drop-down Fields

				WebElement geDate = driver.findElement(By.xpath("(//app-form-date[1]//div[1]//input[@type='date'])[2]"));
				String date1 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				geDate.sendKeys(date1);
				Thread.sleep(1000);

				WebElement gateEntryNo = driver.findElement(By.xpath("(//input[@pattern='[a-zA-Z0-9*-{}@()/\\s]+'])[4]"));
				gateEntryNo.sendKeys("2");

				WebElement paymentTerms = driver.findElement(
						By.xpath("(//app-form-text//div//input[@tooltipposition='bottom' and @type='text'])[8]"));
				if (paymentTerms.isEnabled()) {
					System.out.println("Field is Enabled as Not Expected");
				} else {
					System.out.println("Field is Disabled as Expected");
					System.out.println("Payment Terms : " + paymentTerms.getAttribute("text"));
				}

				WebElement paymentDueDate = driver
						.findElement(By.xpath("(//app-form-date[1]//div[1]//input[@type='date'])[3]"));
				String date2 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				paymentDueDate.sendKeys(date2);
				Thread.sleep(1000);

				WebElement currency = driver.findElement(By.xpath("(//app-form-dyna-select[1]//div[1]//select)[9]"));
				if (currency.isEnabled()) {
					System.out.println("Field is Enabled as Not Expected");
				} else {
					System.out.println("Field is Disabled as Expected");
					System.out.println("Currency : " + currency.getAttribute("text"));
				}

				WebElement totalReceiptValue = driver.findElement(
						By.xpath("(//app-form-text//div//input[@tooltipposition='bottom' and @type='text'])[9]"));
				if (totalReceiptValue.isEnabled()) {
					System.out.println("Field is Enabled as Not Expected");
				} else {
					System.out.println("Field is Disabled as Expected");
					System.out.println("Total Receipt Value : " + totalReceiptValue.getAttribute("value"));
				}

				WebElement additionalChargesTax = driver.findElement(
						By.xpath("(//div//app-form-text//div//input[@tooltipposition='bottom' and @type='text'])[10]"));
				additionalChargesTax.sendKeys("100");

				WebElement additionalChargesNonTax = driver.findElement(
						By.xpath("(//div//app-form-text//div//input[@tooltipposition='bottom' and @type='text'])[11]"));
				additionalChargesNonTax.sendKeys("50");

				WebElement remarks = driver
						.findElement(By.xpath("(//app-form-text[1]//div[1]//textarea[@type='textarea'])[1]"));
				remarks.sendKeys("Suresh : GRN Entry");
				Thread.sleep(1000);

				WebElement toBeCredit = driver.findElement(
						By.xpath("(//div//app-form-text//div//input[@tooltipposition='bottom' and @type='text'])[12]"));
				if (toBeCredit.isEnabled()) {
					System.out.println("Field is Enabled as Not Expected");

				} else {
					System.out.println("Field is Disabled as Expected");
					System.out.println("To Be Credit Value : " + toBeCredit.getAttribute("value"));
				}

				WebElement checkBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
				checkBox.click();

				WebElement moveToReceiveQtyButton = driver
						.findElement(By.xpath("//div//button[contains (text(), 'Move to Receive Qty')]"));
				moveToReceiveQtyButton.click();
				Thread.sleep(1000);

				String attribute = totalReceiptValue.getAttribute("value");
				WebElement invoiceValue = driver.findElement(
						By.xpath("(//app-form-text//div[1]//input [@pattern='^[+-]?((\\d+(\\.\\d*)?)|(\\.\\d+))$'])"));
				invoiceValue.sendKeys(attribute);
			}
			else {
				WebElement receiptNumber = driver.findElement(
						By.xpath("(//div//app-form-text//div//input[@tooltipposition='bottom' and @type='text'])[1]"));
				if (receiptNumber.isEnabled()) {
					System.out.println("Field is Enabled as Not Expected");
				} else {
					System.out.println("Field is Disabled as Expected");
					System.out.println("Receipt Number : " + receiptNumber.getAttribute("value"));
				}

				WebElement receiptDateandTime = driver
						.findElement(By.xpath("(//app-form-text//div//input [@type='text'])[2]"));
				if (receiptDateandTime.isEnabled()) {
					System.out.println("Field is Enabled as Not Expected");
				} else {
					System.out.println("Field is Disabled as Expected");
					System.out.println("Receipt Date/Time : " + receiptDateandTime.getAttribute("value"));
				}

				WebElement invoiceDate = driver.findElement(By.xpath("(//input [@type='date'])[1]"));
				String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				invoiceDate.sendKeys(date);

				WebElement invoiceNumber = driver
						.findElement(By.xpath("(//input[@pattern=\"[a-zA-Z0-9*-{}@()/\\s]+\"])[2]"));
				invoiceNumber.sendKeys(UUID());

				WebElement logisticsCarrier = driver.findElement(By.xpath("(//app-form-dyna-select//div//select)[1]"));
				selectOptionByIndex(logisticsCarrier, 1);

				WebElement incoterm = driver
						.findElement(By.xpath("(//app-form-dyna-select//div//select)[2]//option [@value='0: 1']"));
				if (incoterm.isEnabled()) {
					System.out.println("Field is Enabled as Not Expected");
				} else {
					System.out.println("Field is Disabled as Expected");
					System.out.println("Incoterm : " + incoterm.getAttribute("text"));
				}

				WebElement purchaseCategory = driver
						.findElement(By.xpath("(//app-form-dyna-select//div//select)[3]//option[@value='0: 1']"));
				if (purchaseCategory.isEnabled()) {
					System.out.println("Field is Enabled as Not Expected");
				} else {
					System.out.println("Field is Disabled as Expected");
					System.out.println("Purchase Category : " + purchaseCategory.getAttribute("text"));
				}

				WebElement customerRequestNo = driver
						.findElement(By.xpath("(//input[@pattern='[a-zA-Z0-9*-{}@()/\\s]+'])[3]"));
				customerRequestNo.sendKeys("1234");

				WebElement BOENo = driver.findElement(By.xpath("(//input[@pattern='[a-zA-Z0-9*-{}@()/\\s]+'])[4]"));
				BOENo.sendKeys("12345");

				WebElement BOEDate = driver.findElement(By.xpath("(//app-form-date[1]//div[1]//input[@type='date'])[2]"));
				String date1 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				BOEDate.sendKeys(date1);
				Thread.sleep(1000);

				WebElement trackingNo = driver.findElement(By.xpath("(//input[@pattern='[a-zA-Z0-9*-{}@()/\\s]+'])[5]"));
				trackingNo.sendKeys("12345");

				WebElement noOfPackages = driver.findElement(By.xpath("(//input[@pattern='[0-9]*'])[1]"));
				noOfPackages.sendKeys("2");

				WebElement exchangeRate = driver
						.findElement(By.xpath("(//input[@tooltipevent='focus' and @type='text'])[8]"));
				exchangeRate.sendKeys("2");

				// Store Tile Drop-down Fields

				WebElement geDate = driver.findElement(By.xpath("(//app-form-date[1]//div[1]//input[@type='date'])[3]"));
				String date2 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				geDate.sendKeys(date2);
				Thread.sleep(1000);

				WebElement gateEntryNo = driver.findElement(By.xpath("(//input[@pattern='[a-zA-Z0-9*-{}@()/\\s]+'])[6]"));
				gateEntryNo.sendKeys("2");

				WebElement paymentTerms = driver.findElement(
						By.xpath("(//app-form-text//div//input[@tooltipposition='bottom' and @type='text'])[11]"));
				if (paymentTerms.isEnabled()) {
					System.out.println("Field is Enabled as Not Expected");

				} else {
					System.out.println("Field is Disabled as Expected");
					System.out.println("Payment Terms : " + paymentTerms.getAttribute("text"));
				}

				WebElement paymentDueDate = driver
						.findElement(By.xpath("(//app-form-date[1]//div[1]//input[@type='date'])[4]"));
				String date3 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				paymentDueDate.sendKeys(date3);
				Thread.sleep(1000);

				WebElement currency = driver.findElement(By.xpath("(//app-form-dyna-select[1]//div[1]//select)[9]"));
				if (currency.isEnabled()) {
					System.out.println("Field is Enabled as Not Expected");
				} else {
					System.out.println("Field is Disabled as Expected");
					System.out.println("Currency : " + currency.getAttribute("text"));
				}

				WebElement totalReceiptValue = driver.findElement(
						By.xpath("(//app-form-text//div//input[@tooltipposition='bottom' and @type='text'])[12]"));
				if (totalReceiptValue.isEnabled()) {
					System.out.println("Field is Enabled as Not Expected");

				} else {
					System.out.println("Field is Disabled as Expected");
					System.out.println("Total Receipt Value : " + totalReceiptValue.getAttribute("value"));
				}

				WebElement additionalChargesTax = driver.findElement(
						By.xpath("(//app-form-text//div//input[@tooltipposition='bottom' and @type='text'])[13]"));
				additionalChargesTax.sendKeys("50");

				WebElement additionalChargesNonTax = driver.findElement(
						By.xpath("(//app-form-text//div//input[@tooltipposition='bottom' and @type='text'])[14]"));
				additionalChargesNonTax.sendKeys("50");

				WebElement remarks = driver
						.findElement(By.xpath("(//app-form-text[1]//div[1]//textarea[@type='textarea'])[1]"));
				remarks.sendKeys("Suresh : GRN Entry");
				Thread.sleep(1000);

				WebElement toBeCredit = driver.findElement(
						By.xpath("(//div//app-form-text//div//input[@tooltipposition='bottom' and @type='text'])[15]"));
				if (toBeCredit.isEnabled()) {
					System.out.println("Field is Enabled as Not Expected");

				} else {
					System.out.println("Field is Disabled as Expected");
					System.out.println("To Be Credit Value : " + toBeCredit.getAttribute("value"));
				}

				WebElement checkBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
				j.executeScript("arguments[0].click();", checkBox);

				WebElement moveToReceiveQtyButton = driver
						.findElement(By.xpath("//div//button[contains (text(), 'Move to Receive Qty')]"));
				moveToReceiveQtyButton.click();
				Thread.sleep(3000);

				String attribute = totalReceiptValue.getAttribute("value");
				WebElement invoiceValue = driver.findElement(
						By.xpath("(//app-form-text//div//input[@tooltipposition='bottom' and @type='text'])[9]"));
				invoiceValue.sendKeys(attribute);
			}
		}

		@When("User select the Fully Received status from the filter")
		public void user_select_the_fully_received_status_from_the_filter()
				throws InterruptedException {
			JavascriptExecutor j = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement receiptBtn = driver.findElement(By.xpath("(//a[contains(text(),'Receipt')])[1]"));
			j.executeScript("window.scrollTo(0,0);", receiptBtn);
			wait.until(ExpectedConditions.elementToBeClickable(receiptBtn));
			j.executeScript("arguments[0].click();", receiptBtn);

//			WebElement materialType = driver.findElement(By.xpath("//select[@name='materialtypeid']"));
//			selectOptionByIndex(materialType, 1);
	//
//			WebElement orderType = driver.findElement(By.xpath("//select[@name='ordertypeid']"));
//			selectOptionByIndex(orderType, 1);
	//
//			WebElement purCategory = driver.findElement(By.xpath("//select[@name='purcategoryid']"));
//			selectOptionByIndex(purCategory, 2);

			WebElement GRNStatus = driver.findElement(By.xpath("//select[@name='receiptstatusid']"));
			selectOptionByIndex(GRNStatus, 2);
			Thread.sleep(3000);
		}

		@When("User click on the edit button")
		public void user_click_on_the_edit_button() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement receiptmodule = driver.findElement(By.xpath("(//a[contains(text(),'Receipt')])[1]"));
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("window.scrollTo(0,0);", receiptmodule);
			wait.until(ExpectedConditions.elementToBeClickable(receiptmodule));
			j.executeScript("arguments[0].click();", receiptmodule);
			Thread.sleep(1000);

			WebElement editBtn = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//table[@role='grid']//tbody//tr[1]//th//button[1]//i")));
			wait.until(ExpectedConditions.elementToBeClickable(editBtn));
			j.executeScript("arguments[0].click();", editBtn);
			Thread.sleep(2000);
		}

		@When("User move the stock to the Store")
		public void user_move_the_stock_to_the_store() throws InterruptedException {
			JavascriptExecutor j = (JavascriptExecutor) driver;
			WebElement checkBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
			j.executeScript("arguments[0].click();", checkBox);
			
			WebElement btnMoveToStore = driver.findElement(By.xpath("//button[contains (text(), 'Move to Store')]"));
			btnMoveToStore.click();
		}

		@Then("User click on the signout button")
		public void user_click_on_the_signout_button() throws InterruptedException {
			WebElement profileClick = driver.findElement(By.xpath("(//app-header//div//div//span[@class = 'd-block'])[1]"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,0);", profileClick);
			Thread.sleep(1000);
			profileClick.click();
			WebElement signOutBtn = driver.findElement(
					By.xpath("//h3[contains (@class, 'dropdown-item-title') and contains (text(), 'Sign out ')][1]"));
			signOutBtn.click();
			driver.quit();
		}
		
		@Given("User enters the Admin Team Member {string} and {string}")
		public void user_enters_the_admin_team_member_and(String username, String password) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement loginID = driver.findElement(By.xpath("//input[@id='loginkey'][1]"));
			loginID.sendKeys(username);
			WebElement loginPassword = driver.findElement(By.xpath("//input[@id='password'][1]"));
			loginPassword.sendKeys(password);
			WebElement btnClick = driver.findElement(By.xpath("//input[@id='remembermeCheck'][1]"));
			btnClick.click();
			WebElement btnUnclick = driver.findElement(By.xpath("//input[@id='remembermeCheck'][1]"));
			btnUnclick.click();
			WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit'][1]"));
			signInButton.click();
		}
		
		@When("User create the PO Request for PO ORDER for IT")
		public void user_create_the_po_request_for_po_order_for_it() throws InterruptedException, IOException {
			
			WebElement purchaseOrderBtn = driver.findElement(By.xpath("(//a[contains(text(),'Purchase Order')])[1]"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(purchaseOrderBtn,
					By.xpath("(//a[contains(text(),'Purchase Order')])[1]")));
			purchaseOrderBtn.click();

			WebElement addBtn = driver.findElement(By.xpath("(//button[@title='Add' and @type='button'])[1]"));
			addBtn.click();
			Thread.sleep(1000);

			WebElement branch = (driver.findElement(By.xpath("(//select)[1]")));
			String mas_data = getData("Admin Fields", 11, 0);
			select(branch).selectByVisibleText(mas_data);
			Thread.sleep(500);

			WebElement wareHouse = (driver.findElement(By.xpath("(//select)[2]")));
			String mas_data1 = getData("Admin Fields", 11, 1);
			select(wareHouse).selectByVisibleText(mas_data1);
			Select s = new Select(driver.findElement(By.xpath("(//select)[3]")));
			List<WebElement> options = s.getOptions();
			WebElement storeFieldText = s.getFirstSelectedOption();
			System.out.println("Store : " + storeFieldText.getText());
			Thread.sleep(1000);
			WebElement poNumberFieldText = driver.findElement(
					By.xpath("(//div//app-form-text//div//input[@tooltipposition='bottom' and @type='text'])[1]"));
			System.out.println("PO Number : " + poNumberFieldText.getAttribute("value"));

			WebElement poStatusFieldText = driver.findElement(
					By.xpath("(//div//app-form-text//div//input[@tooltipposition='bottom' and @type='text'])[2]"));
			System.out.println("PO Status : " + poStatusFieldText.getAttribute("value"));

			WebElement poDateFieldValue = driver.findElement(
					By.xpath("(//div//app-form-text//div//input[@tooltipposition='bottom' and @type='text'])[3]"));
			System.out.println("PO Date : " + poDateFieldValue.getAttribute("value"));

			WebElement vendorField = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
			String mas_data2 = getData("Admin Fields", 11, 3);
			vendorField.sendKeys(mas_data2);
			Thread.sleep(500);

			List<WebElement> vendorList = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
			for (WebElement webElement : vendorList) {
				String list = webElement.getText();
				if (list.contains(mas_data2)) {
					Thread.sleep(500);
					JavascriptExecutor k = (JavascriptExecutor) driver;
					k.executeScript("arguments[0].click();", webElement);
					System.out.println(webElement);
					break;
				}
				Thread.sleep(1000);
			}

			Select s1 = new Select(driver.findElement(By.xpath("(//select)[7]")));
			List<WebElement> options1 = s1.getOptions();
			WebElement paymentTerms = s1.getFirstSelectedOption();
			System.out.println("Payment Terms : " + paymentTerms.getText());

			Select s2 = new Select(driver.findElement(By.xpath("(//select)[8]")));
			List<WebElement> options2 = s2.getOptions();
			WebElement paymentMode = s2.getFirstSelectedOption();
			System.out.println("Payment Mode : " + paymentMode.getText());

			Select s3 = new Select(driver.findElement(By.xpath("(//select)[9]")));
			List<WebElement> options3 = s3.getOptions();
			WebElement poOwner = s3.getFirstSelectedOption();
			System.out.println("PO Owner : " + poOwner.getText());

			// PO Order - RM Type

			WebElement orderType = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//select)[5]")));
			String mas_data3 = getData("Admin Fields", 11, 4);
			selectOptionByText(orderType, mas_data3);

			WebElement materialType = driver.findElement(By.xpath("(//select)[6]"));
			String mas_data4 = getData("Admin Fields", 11, 5);
			selectOptionByText(materialType, mas_data4);

			WebElement jiraNumber = driver.findElement(By.xpath("(//input[@id='JiraNo' and @type='text'])[1]"));
			jiraNumber.sendKeys("12345");

			WebElement quoteNumber = driver.findElement(By.xpath("(//input[@id='QuoteNo' and @type='text'])[1]"));
			quoteNumber.sendKeys("54321");

			WebElement quoteDate = driver.findElement(By.xpath("(//input [@type='date'])[1]"));
			String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			quoteDate.sendKeys(date);

			Select s4 = new Select(driver.findElement(By.xpath("(//select)[10]")));
			List<WebElement> options4 = s4.getOptions();
			WebElement approvalStatus = s4.getFirstSelectedOption();
			System.out.println("Approval Status : " + approvalStatus.getText());
			Thread.sleep(1000);

			// Grid Values

			// RM Grid Fields

			if (mas_data4.contains("RM")) {

				MRI_Multiple_Lineitems_POGridFields_RM(driver);

			}

			// NBM Grid Fields
			else {
				
//1st Line
				JavascriptExecutor j = (JavascriptExecutor) driver;
				WebElement costCenter = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l1 r1')]"));
				j.executeScript("arguments[0].click();", costCenter);
				WebElement costCenter1 = driver
						.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
				String costcenter_string = getData("Grid_Data", 2, 15);

				int maxretries = 3;
				for (int i = 0; i < maxretries; i++) {
					try {
						costCenter1 = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
						select(costCenter1).selectByVisibleText(costcenter_string);
						break;
					} catch (StaleElementReferenceException e) {
						System.out.println("Maximum Retry Failed");
					}
				}
				Thread.sleep(500);

				WebElement expenseCategory = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l2 r2')]"));
				j.executeScript("arguments[0].click();", expenseCategory);
				WebElement expenseCategory1 = driver
						.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
				String expensecategory_string = getData("Grid_Data", 2, 16);
				select(expenseCategory1).selectByVisibleText(expensecategory_string);

				WebElement partNo = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l3 r3')]"));
				j.executeScript("arguments[0].click();", partNo);
				WebElement partNo1 = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
				String grid_data = getData("Grid_Data", 2, 17);
				partNo1.sendKeys(grid_data);
				WebElement autoSuggestion = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
				autoSuggestion.click();

				WebElement qty = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l4 r4')]"));
				j.executeScript("arguments[0].click();", qty);
				Thread.sleep(500);
				try {
					j.executeScript("arguments[0].click();", qty);
				} catch (StaleElementReferenceException e3) {
					qty = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l4 r4')]"));
					j.executeScript("arguments[0].click();", qty);
				}
				WebElement qty1 = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l4 r4')]//input"));
				String grid_data3 = getData("Grid_Data", 2, 18);
				qty1.sendKeys(grid_data3);

				WebElement unitPrice = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l5 r5')]"));
				j.executeScript("arguments[0].click();", unitPrice);
				Thread.sleep(500);
				try {
					j.executeScript("arguments[0].click();", unitPrice);
					Thread.sleep(500);
				} catch (StaleElementReferenceException e4) {
					unitPrice = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l5 r5')]"));
					j.executeScript("arguments[0].click();", unitPrice);
				}
				WebElement unitPrice1 = driver
						.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l5 r5')]//input"));
				String grid_data4 = getData("Grid_Data", 2, 19);
				unitPrice1.sendKeys(grid_data4);

				WebElement UOM = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l9 r9')]"));
				j.executeScript("arguments[0].click();", UOM);
				Thread.sleep(500);
				try {
					j.executeScript("arguments[0].click();", UOM);
				} catch (StaleElementReferenceException e5) {
					UOM = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l9 r9')]"));
					j.executeScript("arguments[0].click();", UOM);
				}
				WebElement UOM1 = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l9 r9')]//select"));
				selectOptionByIndex(UOM1, 0);

				WebElement deliveryDate = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l10 r10')]"));
				j.executeScript("arguments[0].click();", deliveryDate);
				Thread.sleep(500);
				try {
					j.executeScript("arguments[0].click();", deliveryDate);
				} catch (StaleElementReferenceException e5) {
					deliveryDate = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l10 r10')]"));
					j.executeScript("arguments[0].click();", deliveryDate);
				}
				WebElement deliverDate1 = driver
						.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l10 r10')]//input"));
				String date1 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				deliverDate1.sendKeys(date1);

				// With IQC checkbox code

				WebElement checkBox = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l11 r11')]"));
				j.executeScript("arguments[0].click();", checkBox);
				Thread.sleep(500);
				try {
					j.executeScript("arguments[0].click();", checkBox);
				} catch (StaleElementReferenceException e5) {
					checkBox = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l11 r11')]"));
					j.executeScript("arguments[0].click();", checkBox);
				}
				WebElement checkBox1 = driver
						.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l11 r11')]//input[@type='checkbox']"));
				j.executeScript("arguments[0].click();", checkBox1);

				// Withot IQC Checkbox code
				WebElement insReason = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l12 r12')]"));
				j.executeScript("arguments[0].click();", insReason);
				Thread.sleep(500);
				try {
					j.executeScript("arguments[0].click();", insReason);
				} catch (StaleElementReferenceException e5) {
					insReason = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l12 r12')]"));
					j.executeScript("arguments[0].click();", insReason);
				}
				WebElement reasonText = driver
						.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l12 r12')]//input[@type='text']"));
				reasonText.sendKeys("Not Required");
				Thread.sleep(500);
				driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l11 r11')]")).click();
				
				WebElement add_btn = driver.findElement(By.xpath("//div//button[@tooltipposition='bottom'][1]//i"));
				j.executeScript("arguments[0].click();", add_btn);
				
//2nd Line
				WebElement costCenter2 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l1 r1')]"));
				j.executeScript("arguments[0].click();", costCenter2);
				WebElement costCenter3 = driver
						.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
				String costcenter_string1 = getData("Grid_Data", 3, 15);

				for (int i = 0; i < maxretries; i++) {
					try {
						costCenter3 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
						select(costCenter3).selectByVisibleText(costcenter_string1);
						break;
					} catch (StaleElementReferenceException e) {
						System.out.println("Maximum Retry Failed");
					}
				}

				Thread.sleep(500);

				WebElement expenseCategory2 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l2 r2')]"));
				j.executeScript("arguments[0].click();", expenseCategory2);
				WebElement expenseCategory3 = driver
						.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
				String expensecategory_string1 = getData("Grid_Data", 3, 16);
				select(expenseCategory3).selectByVisibleText(expensecategory_string1);

				WebElement partNo2 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l3 r3')]"));
				j.executeScript("arguments[0].click();", partNo2);
				WebElement partNo3 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
				String partNo_string = getData("Grid_Data", 3, 17);
				partNo3.sendKeys(partNo_string);
				WebElement autoSuggestion1 = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
				autoSuggestion1.click();

				WebElement qty2 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l4 r4')]"));
				j.executeScript("arguments[0].click();", qty2);
				Thread.sleep(500);
				try {
					j.executeScript("arguments[0].click();", qty2);
				} catch (StaleElementReferenceException e3) {
					qty2 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l4 r4')]"));
					j.executeScript("arguments[0].click();", qty2);
				}
				WebElement qty3 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l4 r4')]//input"));
				String qty_string = getData("Grid_Data", 3, 18);
				qty3.sendKeys(qty_string);

				WebElement unitPrice2 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l5 r5')]"));
				j.executeScript("arguments[0].click();", unitPrice2);
				Thread.sleep(500);
				try {
					j.executeScript("arguments[0].click();", unitPrice2);
					Thread.sleep(500);
				} catch (StaleElementReferenceException e4) {
					unitPrice2 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l5 r5')]"));
					j.executeScript("arguments[0].click();", unitPrice2);
				}
				WebElement unitPrice3 = driver
						.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l5 r5')]//input"));
				String unitprice_string = getData("Grid_Data", 3, 19);
				unitPrice3.sendKeys(unitprice_string);

				WebElement UOM2 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l9 r9')]"));
				j.executeScript("arguments[0].click();", UOM2);
				Thread.sleep(500);
				try {
					j.executeScript("arguments[0].click();", UOM2);
				} catch (StaleElementReferenceException e5) {
					UOM2 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l9 r9')]"));
					j.executeScript("arguments[0].click();", UOM2);
				}
				WebElement UOM3 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l9 r9')]//select"));
				selectOptionByIndex(UOM3, 0);

				WebElement deliveryDate2 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l10 r10')]"));
				j.executeScript("arguments[0].click();", deliveryDate2);
				Thread.sleep(500);
				try {
					j.executeScript("arguments[0].click();", deliveryDate2);
				} catch (StaleElementReferenceException e5) {
					deliveryDate2 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l10 r10')]"));
					j.executeScript("arguments[0].click();", deliveryDate2);
				}
				WebElement deliveryDate3 = driver
						.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l10 r10')]//input"));
				String deliverydate_string = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				deliveryDate3.sendKeys(deliverydate_string);

				// With IQC checkbox code

				WebElement checkBox2 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l11 r11')]"));
				j.executeScript("arguments[0].click();", checkBox2);
				Thread.sleep(500);
				try {
					j.executeScript("arguments[0].click();", checkBox2);
				} catch (StaleElementReferenceException e5) {
					checkBox2 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l11 r11')]"));
					j.executeScript("arguments[0].click();", checkBox2);
				}
				WebElement checkBox3 = driver
						.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l11 r11')]//input[@type='checkbox']"));
				j.executeScript("arguments[0].click();", checkBox3);

				// Without IQC Checkbox code
				WebElement insReason1 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l12 r12')]"));
				j.executeScript("arguments[0].click();", insReason1);
				Thread.sleep(500);
				try {
					j.executeScript("arguments[0].click();", insReason1);
				} catch (StaleElementReferenceException e5) {
					insReason1 = driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l12 r12')]"));
					j.executeScript("arguments[0].click();", insReason1);
				}
				WebElement reasonText1 = driver
						.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l12 r12')]//input[@type='text']"));
				reasonText1.sendKeys("Not Required");
				Thread.sleep(500);
				driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l11 r11')]")).click();

		}
		}
}
