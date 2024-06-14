package ecERP.Multiple_Line_Items;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
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

import ecERP.libglobal.LibGlobal;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Multiple_Line_Items extends LibGlobal {

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
//		driver.get("https://stage-erp.e-consystems.net");
//		driver.get("http://192.168.8.119:8080/#/login");
//		driver.get("http://localhost:4200/#/");
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
	public void user_enters_the_SCM_Team_Member_and(String username, String password) {
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

	@When("User create the PO Request for PO ORDER \\(RM-Domestic)")
	public void user_create_the_po_request_for_po_order_rm_domestic() throws InterruptedException, IOException {

		WebElement purchaseOrderBtn = driver.findElement(By.xpath("(//a[contains(text(),'Purchase Order')])[1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(purchaseOrderBtn,
				By.xpath("(//a[contains(text(),'Purchase Order')])[1]")));
		purchaseOrderBtn.click();

		WebElement addBtn = driver.findElement(By.xpath("(//button[@title='Add' and @type='button'])[1]"));
		addBtn.click();
		Thread.sleep(1000);

		WebElement branch = (driver.findElement(By.xpath("(//select)[1]")));
		String mas_data = getData("Master_Data", 1, 0);
		select(branch).selectByVisibleText(mas_data);
		Thread.sleep(500);

		WebElement wareHouse = (driver.findElement(By.xpath("(//select)[2]")));
		String mas_data1 = getData("Master_Data", 1, 1);
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
		String mas_data2 = getData("Master_Data", 1, 3);
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
		String mas_data3 = getData("Master_Data", 1, 4);
		selectOptionByText(orderType, mas_data3);

		WebElement materialType = driver.findElement(By.xpath("(//select)[6]"));
		String mas_data4 = getData("Master_Data", 1, 5);
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

		// FG Grid Fields
		if (mas_data4.contains("FG")) {

			WebElement costCenter = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[2]"));
			JavascriptExecutor c = (JavascriptExecutor) driver;
			c.executeScript("arguments[0].click();", costCenter);
			WebElement costCenter1 = driver
					.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[2]//select"));
			selectOptionByIndex(costCenter1, 0);

			WebElement expenseCategory = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[3]"));
			JavascriptExecutor e = (JavascriptExecutor) driver;
			e.executeScript("arguments[0].click();", expenseCategory);
			WebElement expenseCategory1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[3]//select"));
			selectOptionByIndex(expenseCategory1, 0);

			WebElement partNo = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[4]"));
			JavascriptExecutor p = (JavascriptExecutor) driver;
			p.executeScript("arguments[0].click();", partNo);
			WebElement partNo1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[4]//input"));
			String grid_data = getData("Grid_Data", 4, 0);
			partNo1.sendKeys(grid_data);
			WebElement autoSuggestion = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
			autoSuggestion.click();

			WebElement workType = driver.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[5]"));
			JavascriptExecutor w = (JavascriptExecutor) driver;
			w.executeScript("arguments[0].click();", workType);
			Thread.sleep(500);
			try {
				w.executeScript("arguments[0].click();", workType);
			} catch (StaleElementReferenceException e1) {
				workType = driver.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[5]"));
				w.executeScript("arguments[0].click();", workType);
			}
			WebElement workType1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[5]//select"));
			selectOptionByIndex(workType1, 0);

			WebElement name = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[6]"));
			JavascriptExecutor n = (JavascriptExecutor) driver;
			n.executeScript("arguments[0].click();", name);
			Thread.sleep(500);
			try {
				n.executeScript("arguments[0].click();", name);
			} catch (StaleElementReferenceException e2) {
				name = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[6]"));
				n.executeScript("arguments[0].click();", name);
			}
			Thread.sleep(1000);
			WebElement name1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[6]//input"));
			String grid_data2 = getData("Grid_Data", 4, 1);
			name1.sendKeys(grid_data2);
			WebElement autoSuggestion1 = driver.findElement(By.xpath("//*[@class='ui-menu-item'][1]"));
			autoSuggestion1.click();

			WebElement qty = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[7]"));
			JavascriptExecutor q = (JavascriptExecutor) driver;
			q.executeScript("arguments[0].click();", qty);
			Thread.sleep(500);
			try {
				q.executeScript("arguments[0].click();", qty);
			} catch (StaleElementReferenceException e3) {
				qty = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[7]"));
				q.executeScript("arguments[0].click();", qty);
			}
			WebElement qty1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[7]//input"));
			String grid_data3 = getData("Grid_Data", 4, 2);
			qty1.sendKeys(grid_data3);

			WebElement unitPrice = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[8]"));
			JavascriptExecutor u = (JavascriptExecutor) driver;
			u.executeScript("arguments[0].click();", unitPrice);
			Thread.sleep(500);
			try {
				u.executeScript("arguments[0].click();", unitPrice);
				Thread.sleep(500);
			} catch (StaleElementReferenceException e4) {
				unitPrice = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[8]"));
				u.executeScript("arguments[0].click();", unitPrice);
			}
			WebElement unitPrice1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[8]//input"));
			String grid_data4 = getData("Grid_Data", 4, 3);
			unitPrice1.sendKeys(grid_data4);

			WebElement UOM = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[12]"));
			JavascriptExecutor U = (JavascriptExecutor) driver;
			U.executeScript("arguments[0].click();", UOM);
			Thread.sleep(500);
			try {
				U.executeScript("arguments[0].click();", UOM);
			} catch (StaleElementReferenceException e5) {
				UOM = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[12]"));
				U.executeScript("arguments[0].click();", UOM);
			}
			WebElement UOM1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[12]//select"));
			selectOptionByIndex(UOM1, 0);

			WebElement deliveryDate = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[13]"));
			JavascriptExecutor d = (JavascriptExecutor) driver;
			d.executeScript("arguments[0].click();", deliveryDate);
			Thread.sleep(500);
			try {
				d.executeScript("arguments[0].click();", deliveryDate);
			} catch (StaleElementReferenceException e5) {
				deliveryDate = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[13]"));
				d.executeScript("arguments[0].click();", deliveryDate);
			}
			WebElement deliverDate1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[13]//input"));
			String date1 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			deliverDate1.sendKeys(date1);

			// With IQC checkbox code

			WebElement checkBox = driver
					.findElement(By.xpath("(//div[@id='form_grid_0']//div[@style='top:0px']//div)[14]"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", checkBox);
			Thread.sleep(500);
			try {
				js.executeScript("arguments[0].click();", checkBox);
			} catch (StaleElementReferenceException e5) {
				checkBox = driver.findElement(By.xpath("(//div[@id='form_grid_0']//div[@style='top:0px']//div)[14]"));
				js.executeScript("arguments[0].click();", checkBox);
			}
			WebElement checkBox1 = driver.findElement(
					By.xpath("(//div[@id='form_grid_0']//div[@style='top:0px']//div)[14]//input[@type='checkbox']"));
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("arguments[0].click();", checkBox1);
//			j.executeScript("arguments[0].click();", checkBox1);

			// Withot IQC Checkbox code
			WebElement insReason = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[15]"));
			j.executeScript("arguments[0].click();", insReason);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", insReason);
			} catch (StaleElementReferenceException e5) {
				insReason = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[15]"));
				j.executeScript("arguments[0].click();", insReason);
			}
			WebElement reasonText = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[15]//input[@type='text']"));
			reasonText.sendKeys("Not Required");
			Thread.sleep(500);
			driver.findElement(By.xpath("(//div[@id='form_grid_0']//div[@style='top:0px']//div)[14]")).click();

			WebElement add_btn = driver.findElement(By.xpath("//div//button[@tooltipposition='bottom'][1]//i"));
			j.executeScript("arguments[0].click();", add_btn);

		}

		// RM Grid Fields
		else {
			JavascriptExecutor j = (JavascriptExecutor) driver;

			WebElement add_btn = driver.findElement(By.xpath("//div//button[@tooltipposition='bottom'][1]//i"));
			j.executeScript("arguments[0].click();", add_btn);

			WebElement add_btn1 = driver.findElement(By.xpath("//div//button[@tooltipposition='bottom'][1]//i"));
			j.executeScript("arguments[0].click();", add_btn1);

			WebElement parent_element = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div"));

			java.util.List<WebElement> childElements = parent_element.findElements(By.xpath("./*"));
			
			
			int child_element_count = childElements.size();
			System.out.println(child_element_count);

			for (int i = 0; i < child_element_count; i++) {
				WebElement element = childElements.get(i);
				List<WebElement> childElements_1 = element.findElements(By.xpath("./*"));
				int child_element_count_1 = childElements_1.size();
				System.out.println("child_element_count_1" + child_element_count_1);
				
//				String grid_data = getData("Grid_Data", 1, 0);
//				int attempts = Integer.parseInt(grid_data);
				
				int attempts = 0;
				while (attempts < 3) {
					try {
						System.out.println("first while");
						WebElement costCenter = element.findElement(By.xpath(".//div[contains(@class,'slick-cell l1 r1')]"));
						j.executeScript("arguments[0].click();", costCenter);
						WebElement costCenter1 = element
								.findElement(By.xpath(".//div[contains(@class,'slick-cell l1 r1')]//select"));
						selectOptionByIndex(costCenter1, 1);
						break;
					} catch (StaleElementReferenceException e) {
						attempts++;
					}
				}
				int attempts_2 = 0;
				while (attempts_2 < 3) {
					try {
						System.out.println("second while");
						WebElement expenseCategory = element
								.findElement(By.xpath(".//div[contains(@class, 'slick-cell l2 r2')]"));
						j.executeScript("arguments[0].click();", expenseCategory);
						wait.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath(".//div[contains(@class,'slick-cell l2 r2')]//select")));
						WebElement expenseCategory1 = element
								.findElement(By.xpath(".//div[contains(@class,'slick-cell l2 r2')]//select"));
						selectOptionByIndex(expenseCategory1, 0);
						
						break;
					} catch (StaleElementReferenceException e) {
						attempts_2++;
					}
				}
				int attempts_3 = 0;
				while (attempts_3 < 3) {
					try {
				
						System.out.println("third while");
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[contains (@class, 'slick-cell l3 r3')]")));
						WebElement partNo = element.findElement(By.xpath(".//div[contains (@class, 'slick-cell l3 r3')]"));
						j.executeScript("arguments[0].click();", partNo);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[contains (@class, 'slick-cell l3 r3')]//input")));
						WebElement partNo1 = element
								.findElement(By.xpath(".//div[contains (@class, 'slick-cell l3 r3')]//input"));
						String grid_data = getData("Grid_Data", 1, 0);
						partNo1.sendKeys(grid_data);
						WebElement autoSuggestion = element.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
						wait.until(ExpectedConditions.visibilityOf(autoSuggestion));
						autoSuggestion.click();
						System.out.println("Third while");
						
						break;
					} catch (StaleElementReferenceException e) {
						attempts_3++;
					}
				}
//				
//				int attempts_4 = 0;
//				while (attempts_4 < 3) {
//					try {	
//						WebElement packingType = driver
//								.findElement(By.xpath(".//div[contains (@class, 'slick-cell l4 r4')]"));
//						j.executeScript("arguments[0].click();", packingType);
//						WebElement packingType1 = driver
//								.findElement(By.xpath(".//div[contains (@class, 'slick-cell l4 r4')]//select"));
//						selectOptionByIndex(packingType1, 0);
//						
//						break;
//					} catch (StaleElementReferenceException e) {
//						attempts_4++;
//					}
//				}
			
//				for (int k = 0; k < child_element_count_1; k++) {
//					
//					int attempts = 0;
//					while (attempts < 3) {
//						try {
//							WebElement costCenter = element.findElement(By.xpath(".//div[@class='slick-cell l1 r1']"));
//							j.executeScript("arguments[0].click();", costCenter);
//							WebElement costCenter1 = element
//									.findElement(By.xpath(".//div[contains(@class, 'slick-cell l1 r1')]//select"));
//							selectOptionByIndex(costCenter1, 1);
//					
//							WebElement expenseCategory = element
//									.findElement(By.xpath(".//div[contains (@class, 'slick-cell l2 r2')]"));
//							j.executeScript("arguments[0].click();", expenseCategory);
//							wait.until(ExpectedConditions.visibilityOfElementLocated(
//									By.xpath(".//div[contains(@class, 'slick-cell l2 r2')]//select")));
//							WebElement expenseCategory1 = element
//									.findElement(By.xpath(".//div[contains(@class, 'slick-cell l2 r2')]//select"));
//							selectOptionByIndex(expenseCategory1, 0);
//							
//							WebElement partNo = element.findElement(By.xpath(".//div[contains (@class, 'slick-cell l3 r3')]"));
//							j.executeScript("arguments[0].click();", partNo);
//							WebElement partNo1 = element
//									.findElement(By.xpath(".//div[contains (@class, 'slick-cell l3 r3')]//input"));
//							String grid_data = getData("Grid_Data", 1, 0);
//							partNo1.sendKeys(grid_data);
//							WebElement autoSuggestion = element.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
//							autoSuggestion.click();
//							
//							break;
//						} catch (StaleElementReferenceException e) {
//							attempts++;
//						}
//					}
//				}
			}
//			JavascriptExecutor j = (JavascriptExecutor) driver;
//			WebElement costCenter = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[2]"));
//			j.executeScript("arguments[0].click();", costCenter);
//			WebElement costCenter1 = driver
//					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[2]//select"));
//			selectOptionByIndex(costCenter1, 0);
//
//			WebElement expenseCategory = driver
//					.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[3]"));
//			j.executeScript("arguments[0].click();", expenseCategory);
//			WebElement expenseCategory1 = driver
//					.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[3]//select"));
//			selectOptionByIndex(expenseCategory1, 0);
//
//			WebElement partNo = driver.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[4]"));
//			j.executeScript("arguments[0].click();", partNo);
//			WebElement partNo1 = driver
//					.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[4]//input"));
//			String grid_data = getData("Grid_Data", 1, 0);
//			partNo1.sendKeys(grid_data);
//			WebElement autoSuggestion = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
//			autoSuggestion.click();
//
//			WebElement packingType = driver
//					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[5]"));
//			j.executeScript("arguments[0].click();", packingType);
//			WebElement packingType1 = driver
//					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[5]//select"));
//			selectOptionByIndex(packingType1, 0);
//
//			WebElement workType = driver.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[6]"));
//			j.executeScript("arguments[0].click();", workType);
//			WebElement workType1 = driver
//					.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[6]//select"));
//			selectOptionByIndex(workType1, 0);
//
//			WebElement name = driver.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[7]"));
//			j.executeScript("arguments[0].click();", name);
//			WebElement name1 = driver
//					.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[7]//input"));
//			String grid_data1 = getData("Grid_Data", 1, 1);
//			name1.sendKeys(grid_data1);
//			WebElement autoSuggestion1 = driver.findElement(By.xpath("//*[@class=\"ui-menu-item\"][1]"));
//			autoSuggestion1.click();
//
//			WebElement qty = driver.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[8]"));
//			j.executeScript("arguments[0].click();", qty);
//			WebElement qty1 = driver
//					.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[8]//input"));
//			String grid_data2 = getData("Grid_Data", 1, 2);
//			qty1.sendKeys(grid_data2);
//
//			WebElement unitPrice = driver
//					.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[9]"));
//			j.executeScript("arguments[0].click();", unitPrice);
//			WebElement unitPrice1 = driver
//					.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[9]//input"));
//			String grid_data3 = getData("Grid_Data", 1, 3);
//			unitPrice1.sendKeys(grid_data3);
//
//			WebElement UOM = driver.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[13]"));
//			j.executeScript("arguments[0].click();", UOM);
//			WebElement UOM1 = driver
//					.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[13]//select"));
//			selectOptionByIndex(UOM1, 0);
//
//			WebElement deliveryDate = driver
//					.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[14]"));
//			j.executeScript("arguments[0].click();", deliveryDate);
//			WebElement deliverDate1 = driver
//					.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[14]//input"));
//			String date1 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//			deliverDate1.sendKeys(date1);
//
//			// With IQC checkbox code
//
//			WebElement checkBox = driver
//					.findElement(By.xpath("(//div[@id='form_grid_0']//div[@style='top:0px']//div)[15]"));
//			j.executeScript("arguments[0].click();", checkBox);
//			WebElement checkBox1 = driver.findElement(
//					By.xpath("(//div[@id='form_grid_0']//div[@style='top:0px']//div)[15]//input[@type='checkbox']"));
//			j.executeScript("arguments[0].click();", checkBox1);
////			j.executeScript("arguments[0].click();", checkBox1);
//
//			// Withot IQC Checkbox code
//
//			WebElement insReason = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[16]"));
//			j.executeScript("arguments[0].click();", insReason);
//			WebElement reasonText = driver
//					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[16]//input[@type='text']"));
//			reasonText.sendKeys("Not Required");
//			driver.findElement(By.xpath("(//div[@id='form_grid_0']//div[@style='top:0px']//div)[15]")).click();
//
//			WebElement add_btn = driver.findElement(By.xpath("//div//button[@tooltipposition='bottom'][1]//i"));
//			j.executeScript("arguments[0].click();", add_btn);
//			
////2nd Line	
//			int scrollAmount = 2000;
//			WebElement cost_Center = driver.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[2])[2]"));
//			j.executeScript("arguments[0].click();", cost_Center);
//			j.executeScript("arguments[0].scrollRight += arguments[1];", cost_Center, scrollAmount);
//			Thread.sleep(1000);
//			WebElement cost_Center1 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[2])[2]//select"));
//			selectOptionByIndex(cost_Center1, 1);
//			
//			WebElement expense_Category = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[3])[2]"));
//			j.executeScript("arguments[0].click();", expense_Category);
//			WebElement expense_Category1 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[3])[2]//select"));
//			selectOptionByIndex(expense_Category1, 1);
//
//			WebElement part_No = driver.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[4])[2]"));
//			j.executeScript("arguments[0].click();", part_No);
//			WebElement part_No1 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[4])[2]//input"));
//			String grid_data4 = getData("Grid_Data", 1, 0);
//			part_No1.sendKeys(grid_data4);
//			WebElement auto_Suggestion = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
//			auto_Suggestion.click();
//
//			WebElement packing_Type = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[5])[2]"));
//			j.executeScript("arguments[0].click();", packing_Type);
//			WebElement packing_Type1 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[5])[2]//select"));
//			selectOptionByIndex(packing_Type1, 0);
//
//			WebElement work_Type = driver.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[6])[2]"));
//			j.executeScript("arguments[0].click();", work_Type);
//			WebElement work_Type1 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[6])[2]//select"));
//			selectOptionByIndex(work_Type1, 0);
//
//			WebElement name_1 = driver.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[7])[2]"));
//			j.executeScript("arguments[0].click();", name_1);
//			WebElement name_2 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[7])[2]//input"));
//			String grid_data5 = getData("Grid_Data", 1, 1);
//			name_2.sendKeys(grid_data5);
//			WebElement auto_Suggestion1 = driver.findElement(By.xpath("//*[@class='ui-menu-item'][1]"));
//			auto_Suggestion1.click();
//
//			WebElement qty_1 = driver.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[8])[2]"));
//			j.executeScript("arguments[0].click();", qty_1);
//			WebElement qty_2 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[8])[2]//input"));
//			String grid_data6 = getData("Grid_Data", 1, 2);
//			qty_2.sendKeys(grid_data6);
//
//			WebElement unit_Price = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[9])[2]"));
//			j.executeScript("arguments[0].click();", unit_Price);
//			WebElement unit_Price1 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[9])[2]//input"));
//			String grid_data7 = getData("Grid_Data", 1, 3);
//			unit_Price1.sendKeys(grid_data7);
//
//			WebElement UOM_1 = driver.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[13])[2]"));
//			j.executeScript("arguments[0].click();", UOM_1);
//			WebElement UOM_2 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[13])[2]//select"));
//			selectOptionByIndex(UOM_2, 0);
//
//			WebElement delivery_Date = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[14])[2]"));
//			j.executeScript("arguments[0].click();", delivery_Date);
//			WebElement deliver_Date1 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[14])[2]//input"));
//			String date_1 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//			deliver_Date1.sendKeys(date_1);
//
//			// With IQC checkbox code
//
//			WebElement check_Box = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[15])[2]"));
//			j.executeScript("arguments[0].click();", check_Box);
//			WebElement check_Box1 = driver.findElement(
//					By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[15])[2]//input[@type='checkbox']"));
//			j.executeScript("arguments[0].click();", check_Box1);
//
//			// Withot IQC Checkbox code
//
//			WebElement ins_Reason = driver.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[16])[2]"));
//			j.executeScript("arguments[0].click();", ins_Reason);
//			WebElement reason_Text = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[16])[2]//input[@type='text']"));
//			reason_Text.sendKeys("Not Required");
//			driver.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[15])[2]")).click();
//
//			j.executeScript("arguments[0].click();", add_btn);
//			
////3rd Line
//			WebElement cost_Center2 = driver.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[2])[3]"));
//			j.executeScript("arguments[0].click();", cost_Center2);
//			j.executeScript("arguments[0].scrollRight += arguments[1];", cost_Center2, scrollAmount);
//			Thread.sleep(1000);
//			WebElement cost_Center3 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[2])[3]//select"));
//			selectOptionByIndex(cost_Center3, 2);
//			
//			WebElement expense_Category2 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[3])[3]"));
//			j.executeScript("arguments[0].click();", expense_Category2);
//			WebElement expense_Category3 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[3])[3]//select"));
//			selectOptionByIndex(expense_Category3, 2);
//
//			WebElement part_No2 = driver.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[4])[3]"));
//			j.executeScript("arguments[0].click();", part_No2);
//			WebElement part_No3 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[4])[3]//input"));
//			String grid_data8 = getData("Grid_Data", 1, 0);
//			part_No3.sendKeys(grid_data8);
//			WebElement auto_Suggestion2 = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
//			auto_Suggestion2.click();
//
//			WebElement packing_Type2 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[5])[3]"));
//			j.executeScript("arguments[0].click();", packing_Type2);
//			WebElement packing_Type3 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[5])[3]//select"));
//			selectOptionByIndex(packing_Type3, 0);
//
//			WebElement work_Type2 = driver.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[6])[3]"));
//			j.executeScript("arguments[0].click();", work_Type2);
//			WebElement work_Type3 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[6])[3]//select"));
//			selectOptionByIndex(work_Type3, 0);
//
//			WebElement name_3 = driver.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[7])[3]"));
//			j.executeScript("arguments[0].click();", name_3);
//			WebElement name_4 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[7])[3]//input"));
//			String grid_data9 = getData("Grid_Data", 1, 1);
//			name_4.sendKeys(grid_data9);
//			WebElement auto_Suggestion3 = driver.findElement(By.xpath("//*[@class='ui-menu-item'][1]"));
//			auto_Suggestion3.click();
//
//			WebElement qty_3 = driver.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[8])[3]"));
//			j.executeScript("arguments[0].click();", qty_3);
//			WebElement qty_4 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[8])[3]//input"));
//			String grid_data10 = getData("Grid_Data", 1, 2);
//			qty_4.sendKeys(grid_data10);
//
//			WebElement unit_Price2 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[9])[3]"));
//			j.executeScript("arguments[0].click();", unit_Price2);
//			WebElement unit_Price3 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[9])[3]//input"));
//			String grid_data11 = getData("Grid_Data", 1, 3);
//			unit_Price3.sendKeys(grid_data11);
//
//			WebElement UOM_3 = driver.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[13])[3]"));
//			j.executeScript("arguments[0].click();", UOM_3);
//			WebElement UOM_4 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[13])[3]//select"));
//			selectOptionByIndex(UOM_4, 0);
//
//			WebElement delivery_Date2 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[14])[3]"));
//			j.executeScript("arguments[0].click();", delivery_Date2);
//			WebElement deliver_Date3 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[14])[3]//input"));
//			String date_2 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//			deliver_Date3.sendKeys(date_2);
//
//			// With IQC checkbox code
//
//			WebElement check_Box2 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[15])[3]"));
//			j.executeScript("arguments[0].click();", check_Box2);
//			WebElement check_Box3 = driver.findElement(
//					By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[15])[3]//input[@type='checkbox']"));
//			j.executeScript("arguments[0].click();", check_Box3);
//
//			// Withot IQC Checkbox code
//
//			WebElement ins_Reason1 = driver.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[16])[3]"));
//			j.executeScript("arguments[0].click();", ins_Reason1);
//			WebElement reason_Text1 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[16])[3]//input[@type='text']"));
//			reason_Text1.sendKeys("Not Required");
//			driver.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[15])[3]")).click();
//
//			j.executeScript("arguments[0].click();", add_btn);
//
////4th Line
//			WebElement cost_Center4 = driver.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[2])[4]"));
//			j.executeScript("arguments[0].click();", cost_Center4);
//			j.executeScript("arguments[0].scrollRight += arguments[1];", cost_Center4, scrollAmount);
//			Thread.sleep(1000);
//			WebElement cost_Center5 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[2])[4]//select"));
//			selectOptionByIndex(cost_Center5, 2);
//			
//			WebElement expense_Category4 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[3])[4]"));
//			j.executeScript("arguments[0].click();", expense_Category4);
//			WebElement expense_Category5 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[3])[4]//select"));
//			selectOptionByIndex(expense_Category5, 2);
//
//			WebElement part_No4 = driver.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[4])[4]"));
//			j.executeScript("arguments[0].click();", part_No4);
//			WebElement part_No5 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[4])[4]//input"));
///*Continue*/String grid_data12 = getData("Grid_Data", 1, 0);
//			part_No5.sendKeys(grid_data12);
//			WebElement auto_Suggestion4 = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
//			auto_Suggestion4.click();
//
//			WebElement packing_Type4 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[5])[4]"));
//			j.executeScript("arguments[0].click();", packing_Type4);
//			WebElement packing_Type5 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[5])[4]//select"));
//			selectOptionByIndex(packing_Type5, 0);
//
//			WebElement work_Type4 = driver.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[6])[4]"));
//			j.executeScript("arguments[0].click();", work_Type4);
//			WebElement work_Type5 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[6])[4]//select"));
//			selectOptionByIndex(work_Type5, 0);
//
//			WebElement name_5 = driver.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[7])[4]"));
//			j.executeScript("arguments[0].click();", name_5);
//			WebElement name_6 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[7])[4]//input"));
//			String grid_data13 = getData("Grid_Data", 1, 1);
//			name_6.sendKeys(grid_data13);
//			WebElement auto_Suggestion5 = driver.findElement(By.xpath("//*[@class='ui-menu-item'][1]"));
//			auto_Suggestion5.click();
//
//			WebElement qty_5 = driver.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[8])[4]"));
//			j.executeScript("arguments[0].click();", qty_5);
//			WebElement qty_6 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[8])[4]//input"));
//			String grid_data14 = getData("Grid_Data", 1, 2);
//			qty_6.sendKeys(grid_data14);
//
//			WebElement unit_Price4 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[9])[4]"));
//			j.executeScript("arguments[0].click();", unit_Price4);
//			WebElement unit_Price5 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[9])[4]//input"));
//			String grid_data15 = getData("Grid_Data", 1, 3);
//			unit_Price5.sendKeys(grid_data15);
//
//			WebElement UOM_5 = driver.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[13])[4]"));
//			j.executeScript("arguments[0].click();", UOM_5);
//			WebElement UOM_6 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[13])[4]//select"));
//			selectOptionByIndex(UOM_6, 0);
//
//			WebElement delivery_Date4 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[14])[4]"));
//			j.executeScript("arguments[0].click();", delivery_Date4);
//			WebElement deliver_Date5 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[14])[4]//input"));
//			String date_3 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//			deliver_Date5.sendKeys(date_3);
//
//			// With IQC checkbox code
//
//			WebElement check_Box4 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[15])[4]"));
//			j.executeScript("arguments[0].click();", check_Box4);
//			WebElement check_Box5 = driver.findElement(
//					By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[15])[4]//input[@type='checkbox']"));
//			j.executeScript("arguments[0].click();", check_Box5);
//
//			// Withot IQC Checkbox code
//
//			WebElement ins_Reason2 = driver.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[16])[4]"));
//			j.executeScript("arguments[0].click();", ins_Reason2);
//			WebElement reason_Text2 = driver
//					.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[16])[4]//input[@type='text']"));
//			reason_Text2.sendKeys("Not Required");
//			driver.findElement(By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[15])[4]")).click();
//
//			j.executeScript("arguments[0].click();", add_btn);
//			
		}

	}
	
	public void selectRow(int index) {
		
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

//			Thread.sleep(2000);
			WebElement successfullPoCreation = wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//app-wstable//div[@class='ws-table-head']//table[@role='grid']//tbody//tr[1]")));
//			WebElement successfullPoCreation = driver.findElement(
//					By.xpath("//app-wstable//div[@class='ws-table-head']//table[@role='grid']//tbody//tr[1]"));
//			wait.until(ExpectedConditions.visibilityOf(successfullPoCreation));
			js.executeScript("window.scrollTo(0,0);", successfullPoCreation);
			System.out.println("Successfull PO Creation : " + successfullPoCreation.getText());

		} catch (StaleElementReferenceException | NoSuchElementException e) {
		}
		Thread.sleep(2000);
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

	@Given("User enters the SCM Team Head {string} and {string}")
	public void user_enters_the_SCM_Team_Head_and(String username, String password) {
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

	@Given("User click on the Edit button")
	public void user_click_on_the_Edit_button() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement purchaseOrderBtn = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(),'Purchase Order')])[1]")));
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait1.until(ExpectedConditions.elementToBeClickable(purchaseOrderBtn));
		purchaseOrderBtn.click();

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement editBtn = wait2.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@role='grid']//tbody//tr[1]//th//button[1]//i")));
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait3.until(ExpectedConditions.elementToBeClickable(editBtn));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", editBtn);

		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-main/div/app-submenu/div/app-tab/section/div/app-gridwrapper/div/div/div/app-form/section/div")));
	}

	@Given("User verify the PO and providing Pre-Approval")
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
		Thread.sleep(1000);
		WebElement saveButton = driver.findElement(By.xpath("(//button[@id='submitbutton' and @type='submit'])"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		if (saveButton.isEnabled()) {
			js.executeScript("arguments[0].click();", saveButton);
			System.out.println("Save Button Enabled");
			Thread.sleep(1000);
		} else {
			System.out.println("Save Button Disabled");
			driver.quit();
		}
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dropdown = driver.findElement(By.xpath("(//div//app-form-select//select)"));
		if (dropdown.isEnabled()) {
			Select s = new Select(dropdown);
			wait.until(ExpectedConditions.visibilityOf(dropdown));
			s.selectByIndex(1);
			Thread.sleep(500);
		} else {
			System.out.println("Dropdown is disabled. Cannot select an option.");
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[1]//input[@pattern='[a-zA-Z0-9*/\\s]+' and @type='text'])[1]")));
		WebElement remarks = driver
				.findElement(By.xpath("(//div[1]//input[@pattern='[a-zA-Z0-9*/\\s]+' and @type='text'])[1]"));
		remarks.sendKeys("Salim : Final Approved");
		Thread.sleep(1000);
	}

	@Given("User click on the Issue icon")
	public void user_click_on_the_issue_icon() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement purchaseOrderBtn = driver.findElement(By.xpath("(//a[contains(text(),'Purchase Order')])[1]"));
		purchaseOrderBtn.click();
		Thread.sleep(1000);

		WebElement issueIcon = driver
				.findElement(By.xpath("(//table[@role='grid']//tbody//tr[1]//th//button[2]//i)[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", issueIcon);
		try {
			js.executeScript("arguments[0].click();", issueIcon);
		} catch (StaleElementReferenceException | NoSuchElementException e) {
			issueIcon = driver.findElement(By.xpath("(//table[@role='grid']//tbody//tr[1]//th//button[2]//i)[1]"));
			js.executeScript("arguments[0].click();", issueIcon);
		}
		Thread.sleep(2000);
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
		issueButton.click();
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
	}

	@Given("User enters the Store Team Member {string} and {string}")
	public void user_enters_the_Store_Team_Member_and(String username, String password) {
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

	@When("User create the GRN Request for Fully Received - \\(PO Order - RM - Domestic)")
	public void user_create_the_grn_request_for_fully_received_po_order_rm_domestic()
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
		String mas_data = getData("Master_Data", 1, 0);
		select(branch).selectByVisibleText(mas_data);
		Thread.sleep(300);

		WebElement store = (driver
				.findElement(By.xpath("//*[@id='collapseOne']/div/div[2]/app-form-dyna-select/div/select")));
		String mas_data1 = getData("Master_Data", 1, 2);
		select(store).selectByVisibleText(mas_data1);
		Thread.sleep(300);

		WebElement orderType = (driver
				.findElement(By.xpath("//*[@id='collapseOne']/div/div[3]/app-form-dyna-select/div/select")));
		String mas_data2 = getData("Master_Data", 1, 4);
		select(orderType).selectByVisibleText(mas_data2);
		Thread.sleep(300);

		WebElement materialType = (driver
				.findElement(By.xpath("//*[@id='collapseOne']/div/div[4]/app-form-dyna-select/div/select")));
		String mas_data3 = getData("Master_Data", 1, 5);
		select(materialType).selectByVisibleText(mas_data3);
		Thread.sleep(300);

		WebElement vendorField = driver.findElement(By.xpath("(//input[@type='text' and @role='combobox'])[1]"));
		String mas_data4 = getData("Master_Data", 1, 3);
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

		else { // Import Fields

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

	@When("User select the Fully Received status from the filter - \\(PO Order - RM - Domestic)")
	public void user_select_the_fully_received_status_from_the_filter_po_order_rm_domestic()
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement receiptBtn = driver.findElement(By.xpath("(//a[contains(text(),'Receipt')])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(receiptBtn));
		receiptBtn.click();

//		WebElement materialType = driver.findElement(By.xpath("//select[@name='materialtypeid']"));
//		selectOptionByIndex(materialType, 1);

//		WebElement orderType = driver.findElement(By.xpath("//select[@name='ordertypeid']"));
//		selectOptionByIndex(orderType, 1);

//		WebElement purCategory = driver.findElement(By.xpath("//select[@name='purcategoryid']"));
//		selectOptionByIndex(purCategory, 2);

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
	public void user_move_the_stock_to_the_store() {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebElement checkBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		j.executeScript("arguments[0].click();", checkBox);

		WebElement btnMoveToStore = driver.findElement(By.xpath("//button[contains (text(), 'Move to Store')]"));
		btnMoveToStore.click();
	}

}
