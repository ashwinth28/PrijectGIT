package ecERP.ISSUE;

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

import ecERP.libglobal.LibGlobal;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Samples_StepDefinition extends LibGlobal {

	public static WebDriver driver;

	@Given("User on the login page for Samples")
	public void user_on_the_login_page_for_Samples() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.get("https://qa-erp.e-consystems.net");
//		driver.get("https://stage-erp.e-consystems.net");
//		driver.get("http://192.168.8.119:8080/#/login");
//		driver.get("http://localhost:8080/#/");
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

	@When("User click on the save button for Samples")
	public void user_click_on_the_save_button_for_Samples() throws InterruptedException {
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
		} catch (StaleElementReferenceException | NoSuchElementException e) {
		}
		Thread.sleep(5000);
	}

	@When("User click on the Edit button for Samples")
	public void user_click_on_the_Edit_button_for_Samples() {
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

	@When("User click on the Save button for Samples")
	public void user_click_on_the_Save_button_for_Samples() throws InterruptedException {
		Thread.sleep(1000);
		WebElement saveButton = driver.findElement(By.xpath("(//button[@id='submitbutton' and @type='submit'])"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		if (saveButton.isEnabled()) {
			js.executeScript("arguments[0].click();", saveButton);
			System.out.println("Save Button Enabled");
		} else {
			System.out.println("Save Button Disabled");
			driver.quit();
		}
		Thread.sleep(2000);
	}

	@Given("User enters the Store Team Member {string} and {string} for Samples")
	public void user_enters_the_store_team_member_and_for_Samples(String username, String password) {
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

	public void Add_Line_Item_for_Samples_GRN() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		int maxretries = 3;
		for (int i = 0; i < maxretries; i++) {
			try {
				WebElement dummy = driver
						.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l7 r7')]"));
				dummy.click();
				WebElement add_btn = driver.findElement(By.xpath(".//div//button[@ptooltip='Add']//i"));
				j.executeScript("arguments[0].click();", add_btn);
				break;
			} catch (StaleElementReferenceException e) {
			}
		}
	}

	@When("User create the GRN Request for Fully Received for Samples")
	public void user_create_the_grn_request_for_fully_received_for_Samples() throws InterruptedException, IOException {
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
		Thread.sleep(1000);

		WebElement branch = (driver
				.findElement(By.xpath("//*[@id='collapseOne']/div/div[1]/app-form-dyna-select/div/select")));
		wait.until(ExpectedConditions.visibilityOf(branch));
		String mas_data = getData("Samples Master Fields", 11, 0);
		select(branch).selectByVisibleText(mas_data);
		Thread.sleep(300);

		WebElement store = (driver
				.findElement(By.xpath("//*[@id='collapseOne']/div/div[2]/app-form-dyna-select/div/select")));
		String mas_data1 = getData("Samples Master Fields", 11, 2);
		select(store).selectByVisibleText(mas_data1);
		Thread.sleep(300);

		WebElement orderType = (driver
				.findElement(By.xpath("//*[@id='collapseOne']/div/div[3]/app-form-dyna-select/div/select")));
		String mas_data2 = getData("Samples Master Fields", 11, 4);
		select(orderType).selectByVisibleText(mas_data2);
		Thread.sleep(300);

		WebElement currency = driver.findElement(By.xpath("(//app-form-dyna-select[1]//div[1]//select)[7]"));
		String currency_string = getData("Samples Master Fields", 11, 5);
		select(currency).selectByVisibleText(currency_string);

		WebElement supplierType = (driver
				.findElement(By.xpath("//*[@id='collapseOne']/div/div[4]/app-form-select/div/select")));
		String supplierType_string = getData("Samples Master Fields", 11, 8);
		select(supplierType).selectByVisibleText(supplierType_string);
		Thread.sleep(300);

		if (supplierType_string.contains("Vendor")) {

			WebElement vendorField = driver.findElement(By.xpath("(//input[@type='text' and @role='combobox'])[1]"));
			String vendorField_string = getData("Samples Master Fields", 1, 14);
			vendorField.sendKeys(vendorField_string);

			List<WebElement> vendorList = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
			for (WebElement webElement : vendorList) {
				String list = webElement.getText();
				if (list.contains(vendorField_string)) {
					Thread.sleep(500);
					webElement.click();
					System.out.println(webElement);
					break;
				}
				Thread.sleep(1000);
			}
		} else {
			WebElement customerField = driver.findElement(By.xpath("(//input[@type='text' and @role='combobox'])[1]"));
			String customerField_string = getData("Samples Master Fields", 1, 13);
			customerField.sendKeys(customerField_string);

			List<WebElement> customerList = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
			for (WebElement webElement : customerList) {
				String list = webElement.getText();
				if (list.contains(customerField_string)) {
					Thread.sleep(500);
					webElement.click();
					System.out.println(webElement);
					break;
				}
				Thread.sleep(1000);
			}
		}

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
			gateEntryNo.sendKeys("8267");

			WebElement paymentDueDate = driver
					.findElement(By.xpath("(//app-form-date[1]//div[1]//input[@type='date'])[3]"));
			String date2 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			paymentDueDate.sendKeys(date2);
			Thread.sleep(1000);

			WebElement totalReceiptValue = driver.findElement(
					By.xpath("(//app-form-text//div//input[@tooltipposition='bottom' and @type='text'])[8]"));
			if (totalReceiptValue.isEnabled()) {
				System.out.println("Field is Enabled as Not Expected");
			} else {
				System.out.println("Field is Disabled as Expected");
				System.out.println("Total Receipt Value : " + totalReceiptValue.getAttribute("value"));
			}

			WebElement additionalChargesTax = driver.findElement(
					By.xpath("(//div//app-form-text//div//input[@tooltipposition='bottom' and @type='text'])[9]"));
			additionalChargesTax.sendKeys("100");

			WebElement additionalChargesNonTax = driver.findElement(
					By.xpath("(//div//app-form-text//div//input[@tooltipposition='bottom' and @type='text'])[10]"));
			additionalChargesNonTax.sendKeys("50");

			WebElement remarks = driver
					.findElement(By.xpath("(//app-form-text[1]//div[1]//textarea[@type='textarea'])[1]"));
			remarks.sendKeys("Suresh : GRN Entry");
			Thread.sleep(1000);

			/* / Grid Fields / */

//1st Line
			WebElement itemDesc = driver
					.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l2 r2')]"));
			j.executeScript("arguments[0].click();", itemDesc);
			WebElement itemDesc1 = driver.findElement(
					By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l2 r2')]//input"));
			String itemDesc1_string = getData("Samples Master Fields", 11, 9);
			itemDesc1.sendKeys(itemDesc1_string);
			Thread.sleep(500);

			// Without IQC checkbox code
			WebElement checkBox = driver
					.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l3 r3')]"));
			j.executeScript("arguments[0].click();", checkBox);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", checkBox);
			} catch (StaleElementReferenceException e5) {
				checkBox = driver
						.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l3 r3')]"));
				j.executeScript("arguments[0].click();", checkBox);
			}
			WebElement checkBox1 = driver.findElement(By.xpath(
					".//div[@style='top:0px']//div[contains (@class, 'slick-cell l3 r3')]//input[@type='checkbox']"));
			j.executeScript("arguments[0].click();", checkBox1);

			WebElement storeReceiveQty = driver
					.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l4 r4')]"));
			j.executeScript("arguments[0].click();", storeReceiveQty);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", storeReceiveQty);
			} catch (StaleElementReferenceException e5) {
				storeReceiveQty = driver
						.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l4 r4')]"));
				j.executeScript("arguments[0].click();", storeReceiveQty);
			}
			WebElement storeReceiveQty1 = driver.findElement(
					By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l4 r4')]//input"));
			String storeReceiveQty1_string = getData("Samples Master Fields", 11, 10);
			storeReceiveQty1.sendKeys(storeReceiveQty1_string);

			WebElement unitPrice = driver
					.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l6 r6')]"));
			j.executeScript("arguments[0].click();", unitPrice);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", unitPrice);
			} catch (StaleElementReferenceException e5) {
				unitPrice = driver
						.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l6 r6')]"));
				j.executeScript("arguments[0].click();", unitPrice);
			}
			WebElement unitPrice1 = driver.findElement(
					By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l6 r6')]//input"));
			String unitPrice1_string = getData("Samples Master Fields", 11, 11);
			unitPrice1.sendKeys(unitPrice1_string);

			Add_Line_Item_for_Samples_GRN();

//2nd Line
			WebElement itemDesc2 = driver
					.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l2 r2')]"));
			j.executeScript("arguments[0].click();", itemDesc2);
			WebElement itemDesc3 = driver.findElement(
					By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l2 r2')]//input"));
			String itemDesc2_string = getData("Samples Master Fields", 12, 9);
			itemDesc3.sendKeys(itemDesc2_string);
			Thread.sleep(500);

			// Without IQC checkbox code
			WebElement checkBox2 = driver
					.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l3 r3')]"));
			j.executeScript("arguments[0].click();", checkBox2);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", checkBox2);
			} catch (StaleElementReferenceException e5) {
				checkBox2 = driver
						.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l3 r3')]"));
				j.executeScript("arguments[0].click();", checkBox2);
			}
			WebElement checkBox3 = driver.findElement(By.xpath(
					".//div[@style='top:25px']//div[contains (@class, 'slick-cell l3 r3')]//input[@type='checkbox']"));
			j.executeScript("arguments[0].click();", checkBox3);

			WebElement storeReceiveQty2 = driver
					.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l4 r4')]"));
			j.executeScript("arguments[0].click();", storeReceiveQty2);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", storeReceiveQty2);
			} catch (StaleElementReferenceException e5) {
				storeReceiveQty2 = driver
						.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l4 r4')]"));
				j.executeScript("arguments[0].click();", storeReceiveQty2);
			}
			WebElement storeReceiveQty3 = driver.findElement(
					By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l4 r4')]//input"));
			String storeReceiveQty2_string = getData("Samples Master Fields", 12, 10);
			storeReceiveQty3.sendKeys(storeReceiveQty2_string);

			WebElement unitPrice2 = driver
					.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l6 r6')]"));
			j.executeScript("arguments[0].click();", unitPrice2);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", unitPrice2);
			} catch (StaleElementReferenceException e5) {
				unitPrice2 = driver
						.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l6 r6')]"));
				j.executeScript("arguments[0].click();", unitPrice2);
			}
			WebElement unitPrice3 = driver.findElement(
					By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l6 r6')]//input"));
			String unitPrice2_string = getData("Samples Master Fields", 12, 11);
			unitPrice3.sendKeys(unitPrice2_string);

			Add_Line_Item_for_Samples_GRN();

//3rd Line
			WebElement itemDesc4 = driver
					.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l2 r2')]"));
			j.executeScript("arguments[0].click();", itemDesc4);
			WebElement itemDesc5 = driver.findElement(
					By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l2 r2')]//input"));
			String itemDesc3_string = getData("Samples Master Fields", 13, 9);
			itemDesc5.sendKeys(itemDesc3_string);
			Thread.sleep(500);

			// Without IQC checkbox code
			WebElement checkBox4 = driver
					.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l3 r3')]"));
			j.executeScript("arguments[0].click();", checkBox4);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", checkBox4);
			} catch (StaleElementReferenceException e5) {
				checkBox4 = driver
						.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l3 r3')]"));
				j.executeScript("arguments[0].click();", checkBox4);
			}
			WebElement checkBox5 = driver.findElement(By.xpath(
					".//div[@style='top:50px']//div[contains (@class, 'slick-cell l3 r3')]//input[@type='checkbox']"));
			j.executeScript("arguments[0].click();", checkBox5);

			WebElement storeReceiveQty4 = driver
					.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l4 r4')]"));
			j.executeScript("arguments[0].click();", storeReceiveQty4);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", storeReceiveQty4);
			} catch (StaleElementReferenceException e5) {
				storeReceiveQty4 = driver
						.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l4 r4')]"));
				j.executeScript("arguments[0].click();", storeReceiveQty4);
			}
			WebElement storeReceiveQty5 = driver.findElement(
					By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l4 r4')]//input"));
			String storeReceiveQty3_string = getData("Samples Master Fields", 13, 10);
			storeReceiveQty5.sendKeys(storeReceiveQty3_string);

			WebElement unitPrice4 = driver
					.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l6 r6')]"));
			j.executeScript("arguments[0].click();", unitPrice4);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", unitPrice4);
			} catch (StaleElementReferenceException e5) {
				unitPrice4 = driver
						.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l6 r6')]"));
				j.executeScript("arguments[0].click();", unitPrice4);
			}
			WebElement unitPrice5 = driver.findElement(
					By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l6 r6')]//input"));
			String unitPrice3_string = getData("Samples Master Fields", 13, 11);
			unitPrice5.sendKeys(unitPrice3_string);

			Add_Line_Item_for_Samples_GRN();

//4th Line
			WebElement itemDesc6 = driver
					.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l2 r2')]"));
			j.executeScript("arguments[0].click();", itemDesc6);
			WebElement itemDesc7 = driver.findElement(
					By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l2 r2')]//input"));
			String itemDesc4_string = getData("Samples Master Fields", 14, 9);
			itemDesc7.sendKeys(itemDesc4_string);
			Thread.sleep(500);

			// Without IQC checkbox code
			WebElement checkBox6 = driver
					.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l3 r3')]"));
			j.executeScript("arguments[0].click();", checkBox6);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", checkBox6);
			} catch (StaleElementReferenceException e5) {
				checkBox6 = driver
						.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l3 r3')]"));
				j.executeScript("arguments[0].click();", checkBox6);
			}
			WebElement checkBox7 = driver.findElement(By.xpath(
					".//div[@style='top:75px']//div[contains (@class, 'slick-cell l3 r3')]//input[@type='checkbox']"));
			j.executeScript("arguments[0].click();", checkBox7);

			WebElement storeReceiveQty6 = driver
					.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l4 r4')]"));
			j.executeScript("arguments[0].click();", storeReceiveQty6);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", storeReceiveQty6);
			} catch (StaleElementReferenceException e5) {
				storeReceiveQty6 = driver
						.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l4 r4')]"));
				j.executeScript("arguments[0].click();", storeReceiveQty6);
			}
			WebElement storeReceiveQty7 = driver.findElement(
					By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l4 r4')]//input"));
			String storeReceiveQty4_string = getData("Samples Master Fields", 14, 10);
			storeReceiveQty7.sendKeys(storeReceiveQty4_string);

			WebElement unitPrice6 = driver
					.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l6 r6')]"));
			j.executeScript("arguments[0].click();", unitPrice6);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", unitPrice6);
			} catch (StaleElementReferenceException e5) {
				unitPrice6 = driver
						.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l6 r6')]"));
				j.executeScript("arguments[0].click();", unitPrice6);
			}
			WebElement unitPrice7 = driver.findElement(
					By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l6 r6')]//input"));
			String unitPrice4_string = getData("Samples Master Fields", 14, 11);
			unitPrice7.sendKeys(unitPrice4_string);

			Add_Line_Item_for_Samples_GRN();

//5th Line
			WebElement itemDesc8 = driver
					.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l2 r2')]"));
			j.executeScript("arguments[0].click();", itemDesc8);
			WebElement itemDesc9 = driver.findElement(
					By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l2 r2')]//input"));
			String itemDesc5_string = getData("Samples Master Fields", 15, 9);
			itemDesc9.sendKeys(itemDesc5_string);
			Thread.sleep(500);

			// Without IQC checkbox code
			WebElement checkBox8 = driver
					.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l3 r3')]"));
			j.executeScript("arguments[0].click();", checkBox8);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", checkBox8);
			} catch (StaleElementReferenceException e5) {
				checkBox8 = driver.findElement(
						By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l3 r3')]"));
				j.executeScript("arguments[0].click();", checkBox8);
			}
			WebElement checkBox9 = driver.findElement(By.xpath(
					".//div[@style='top:100px']//div[contains (@class, 'slick-cell l3 r3')]//input[@type='checkbox']"));
			j.executeScript("arguments[0].click();", checkBox9);

			WebElement storeReceiveQty8 = driver
					.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l4 r4')]"));
			j.executeScript("arguments[0].click();", storeReceiveQty8);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", storeReceiveQty8);
			} catch (StaleElementReferenceException e5) {
				storeReceiveQty8 = driver.findElement(
						By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l4 r4')]"));
				j.executeScript("arguments[0].click();", storeReceiveQty8);
			}
			WebElement storeReceiveQty9 = driver.findElement(
					By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l4 r4')]//input"));
			String storeReceiveQty5_string = getData("Samples Master Fields", 15, 10);
			storeReceiveQty9.sendKeys(storeReceiveQty5_string);

			WebElement unitPrice8 = driver
					.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l6 r6')]"));
			j.executeScript("arguments[0].click();", unitPrice8);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", unitPrice8);
			} catch (StaleElementReferenceException e5) {
				unitPrice8 = driver.findElement(
						By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l6 r6')]"));
				j.executeScript("arguments[0].click();", unitPrice8);
			}
			WebElement unitPrice9 = driver.findElement(
					By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l6 r6')]//input"));
			String unitPrice5_string = getData("Samples Master Fields", 15, 11);
			unitPrice9.sendKeys(unitPrice5_string);

			int maxretries = 3;
			for (int i = 0; i < maxretries; i++) {
				try {
					WebElement dummy = driver.findElement(
							By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l7 r7')]"));
					dummy.click();
					break;
				} catch (StaleElementReferenceException e) {
				}
			}

			String attribute = totalReceiptValue.getAttribute("value");
			WebElement invoiceValue = driver.findElement(
					By.xpath("(//app-form-text//div[1]//input [@pattern='^[+-]?((\\d+(\\.\\d*)?)|(\\.\\d+))$'])"));
			invoiceValue.sendKeys(attribute);

		} else {

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
					.findElement(By.xpath("(//app-form-dyna-select//div//select)[3]//option[@value='0: 1']"));
			if (purchaseCategory.isEnabled()) {
				System.out.println("Field is Enabled as Not Expected");
			} else {
				System.out.println("Field is Disabled as Expected");
				System.out.println("Purchase Category : " + purchaseCategory.getAttribute("text"));
			}

			WebElement customsRequestNo = driver
					.findElement(By.xpath("(//input[@pattern='[a-zA-Z0-9*-{}@()/\\s]+'])[3]"));
			customsRequestNo.sendKeys("12345");
			Thread.sleep(500);

			WebElement BOENo = driver.findElement(By.xpath("(//input[@pattern='[a-zA-Z0-9*-{}@()/\\s]+'])[4]"));
			BOENo.sendKeys("54321");
			Thread.sleep(500);

			WebElement BOEDate = driver.findElement(By.xpath("(//app-form-date[1]//div[1]//input[@type='date'])[2]"));
			String BOEDate_string = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			BOEDate.sendKeys(BOEDate_string);
			Thread.sleep(1000);

			WebElement trackingNo = driver.findElement(By.xpath("(//input[@pattern='[a-zA-Z0-9*-{}@()/\\s]+'])[5]"));
			trackingNo.sendKeys("12345");
			Thread.sleep(500);

			WebElement noOfPackages = driver.findElement(By.xpath("(//input[@pattern='[0-9]*'])[1]"));
			noOfPackages.sendKeys("10");
			Thread.sleep(500);

			WebElement exchangeRate = driver.findElement(By.xpath("(//app-form-text//div[1]//input)[8]"));
			exchangeRate.sendKeys("10");

			// Store Tile Drop-down Fields

			WebElement geDate = driver.findElement(By.xpath("(//app-form-date[1]//div[1]//input[@type='date'])[3]"));
			String date1 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			geDate.sendKeys(date1);
			Thread.sleep(1000);

			WebElement gateEntryNo = driver.findElement(By.xpath("(//input[@pattern='[a-zA-Z0-9*-{}@()/\\s]+'])[6]"));
			gateEntryNo.sendKeys("8267");

			WebElement paymentDueDate = driver
					.findElement(By.xpath("(//app-form-date[1]//div[1]//input[@type='date'])[4]"));
			String date2 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			paymentDueDate.sendKeys(date2);
			Thread.sleep(1000);

			WebElement totalReceiptValue = driver.findElement(
					By.xpath("(//app-form-text//div//input[@tooltipposition='bottom' and @type='text'])[11]"));
			if (totalReceiptValue.isEnabled()) {
				System.out.println("Field is Enabled as Not Expected");
			} else {
				System.out.println("Field is Disabled as Expected");
				System.out.println("Total Receipt Value : " + totalReceiptValue.getAttribute("value"));
			}

			WebElement additionalChargesTax = driver.findElement(
					By.xpath("(//app-form-text//div//input[@tooltipposition='bottom' and @type='text'])[12]"));
			additionalChargesTax.sendKeys("100");

			WebElement additionalChargesNonTax = driver.findElement(
					By.xpath("(//app-form-text//div//input[@tooltipposition='bottom' and @type='text'])[13]"));
			additionalChargesNonTax.sendKeys("50");

			WebElement remarks = driver
					.findElement(By.xpath("(//app-form-text[1]//div[1]//textarea[@type='textarea'])[1]"));
			remarks.sendKeys("Suresh : GRN Entry");
			Thread.sleep(1000);

			/* / Grid Fields / */

//1st Line
			WebElement itemDesc = driver
					.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l2 r2')]"));
			j.executeScript("arguments[0].click();", itemDesc);
			WebElement itemDesc1 = driver.findElement(
					By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l2 r2')]//input"));
			String itemDesc1_string = getData("Samples Master Fields", 11, 9);
			itemDesc1.sendKeys(itemDesc1_string);
			Thread.sleep(500);

			// Without IQC checkbox code
			WebElement checkBox = driver
					.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l3 r3')]"));
			j.executeScript("arguments[0].click();", checkBox);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", checkBox);
			} catch (StaleElementReferenceException e5) {
				checkBox = driver
						.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l3 r3')]"));
				j.executeScript("arguments[0].click();", checkBox);
			}
			WebElement checkBox1 = driver.findElement(By.xpath(
					".//div[@style='top:0px']//div[contains (@class, 'slick-cell l3 r3')]//input[@type='checkbox']"));
			j.executeScript("arguments[0].click();", checkBox1);

			WebElement storeReceiveQty = driver
					.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l4 r4')]"));
			j.executeScript("arguments[0].click();", storeReceiveQty);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", storeReceiveQty);
			} catch (StaleElementReferenceException e5) {
				storeReceiveQty = driver
						.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l4 r4')]"));
				j.executeScript("arguments[0].click();", storeReceiveQty);
			}
			WebElement storeReceiveQty1 = driver.findElement(
					By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l4 r4')]//input"));
			String storeReceiveQty1_string = getData("Samples Master Fields", 11, 10);
			storeReceiveQty1.sendKeys(storeReceiveQty1_string);

			WebElement unitPrice = driver
					.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l6 r6')]"));
			j.executeScript("arguments[0].click();", unitPrice);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", unitPrice);
			} catch (StaleElementReferenceException e5) {
				unitPrice = driver
						.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l6 r6')]"));
				j.executeScript("arguments[0].click();", unitPrice);
			}
			WebElement unitPrice1 = driver.findElement(
					By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l6 r6')]//input"));
			String unitPrice1_string = getData("Samples Master Fields", 11, 11);
			unitPrice1.sendKeys(unitPrice1_string);
			Thread.sleep(1000);

			Add_Line_Item_for_Samples_GRN();

//2nd Line
			WebElement itemDesc2 = driver
					.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l2 r2')]"));
			j.executeScript("arguments[0].click();", itemDesc2);
			WebElement itemDesc3 = driver.findElement(
					By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l2 r2')]//input"));
			String itemDesc2_string = getData("Samples Master Fields", 12, 9);
			itemDesc3.sendKeys(itemDesc2_string);
			Thread.sleep(500);

			// Without IQC checkbox code
			WebElement checkBox2 = driver
					.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l3 r3')]"));
			j.executeScript("arguments[0].click();", checkBox2);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", checkBox2);
			} catch (StaleElementReferenceException e5) {
				checkBox2 = driver
						.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l3 r3')]"));
				j.executeScript("arguments[0].click();", checkBox2);
			}
			WebElement checkBox3 = driver.findElement(By.xpath(
					".//div[@style='top:25px']//div[contains (@class, 'slick-cell l3 r3')]//input[@type='checkbox']"));
			j.executeScript("arguments[0].click();", checkBox3);

			WebElement storeReceiveQty2 = driver
					.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l4 r4')]"));
			j.executeScript("arguments[0].click();", storeReceiveQty2);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", storeReceiveQty2);
			} catch (StaleElementReferenceException e5) {
				storeReceiveQty2 = driver
						.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l4 r4')]"));
				j.executeScript("arguments[0].click();", storeReceiveQty2);
			}
			WebElement storeReceiveQty3 = driver.findElement(
					By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l4 r4')]//input"));
			String storeReceiveQty2_string = getData("Samples Master Fields", 12, 10);
			storeReceiveQty3.sendKeys(storeReceiveQty2_string);

			WebElement unitPrice2 = driver
					.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l6 r6')]"));
			j.executeScript("arguments[0].click();", unitPrice2);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", unitPrice2);
			} catch (StaleElementReferenceException e5) {
				unitPrice2 = driver
						.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l6 r6')]"));
				j.executeScript("arguments[0].click();", unitPrice2);
			}
			WebElement unitPrice3 = driver.findElement(
					By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l6 r6')]//input"));
			String unitPrice2_string = getData("Samples Master Fields", 12, 11);
			unitPrice3.sendKeys(unitPrice2_string);

			Add_Line_Item_for_Samples_GRN();

//3rd Line
			WebElement itemDesc4 = driver
					.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l2 r2')]"));
			j.executeScript("arguments[0].click();", itemDesc4);
			WebElement itemDesc5 = driver.findElement(
					By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l2 r2')]//input"));
			String itemDesc3_string = getData("Samples Master Fields", 13, 9);
			itemDesc5.sendKeys(itemDesc3_string);
			Thread.sleep(500);

			// Without IQC checkbox code
			WebElement checkBox4 = driver
					.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l3 r3')]"));
			j.executeScript("arguments[0].click();", checkBox4);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", checkBox4);
			} catch (StaleElementReferenceException e5) {
				checkBox4 = driver
						.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l3 r3')]"));
				j.executeScript("arguments[0].click();", checkBox4);
			}
			WebElement checkBox5 = driver.findElement(By.xpath(
					".//div[@style='top:50px']//div[contains (@class, 'slick-cell l3 r3')]//input[@type='checkbox']"));
			j.executeScript("arguments[0].click();", checkBox5);

			WebElement storeReceiveQty4 = driver
					.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l4 r4')]"));
			j.executeScript("arguments[0].click();", storeReceiveQty4);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", storeReceiveQty4);
			} catch (StaleElementReferenceException e5) {
				storeReceiveQty4 = driver
						.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l4 r4')]"));
				j.executeScript("arguments[0].click();", storeReceiveQty4);
			}
			WebElement storeReceiveQty5 = driver.findElement(
					By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l4 r4')]//input"));
			String storeReceiveQty3_string = getData("Samples Master Fields", 13, 10);
			storeReceiveQty5.sendKeys(storeReceiveQty3_string);

			WebElement unitPrice4 = driver
					.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l6 r6')]"));
			j.executeScript("arguments[0].click();", unitPrice4);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", unitPrice4);
			} catch (StaleElementReferenceException e5) {
				unitPrice4 = driver
						.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l6 r6')]"));
				j.executeScript("arguments[0].click();", unitPrice4);
			}
			WebElement unitPrice5 = driver.findElement(
					By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l6 r6')]//input"));
			String unitPrice3_string = getData("Samples Master Fields", 13, 11);
			unitPrice5.sendKeys(unitPrice3_string);

			Add_Line_Item_for_Samples_GRN();

//4th Line
			WebElement itemDesc6 = driver
					.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l2 r2')]"));
			j.executeScript("arguments[0].click();", itemDesc6);
			WebElement itemDesc7 = driver.findElement(
					By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l2 r2')]//input"));
			String itemDesc4_string = getData("Samples Master Fields", 14, 9);
			itemDesc7.sendKeys(itemDesc4_string);
			Thread.sleep(500);

			// Without IQC checkbox code
			WebElement checkBox6 = driver
					.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l3 r3')]"));
			j.executeScript("arguments[0].click();", checkBox6);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", checkBox6);
			} catch (StaleElementReferenceException e5) {
				checkBox6 = driver
						.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l3 r3')]"));
				j.executeScript("arguments[0].click();", checkBox6);
			}
			WebElement checkBox7 = driver.findElement(By.xpath(
					".//div[@style='top:75px']//div[contains (@class, 'slick-cell l3 r3')]//input[@type='checkbox']"));
			j.executeScript("arguments[0].click();", checkBox7);

			WebElement storeReceiveQty6 = driver
					.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l4 r4')]"));
			j.executeScript("arguments[0].click();", storeReceiveQty6);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", storeReceiveQty6);
			} catch (StaleElementReferenceException e5) {
				storeReceiveQty6 = driver
						.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l4 r4')]"));
				j.executeScript("arguments[0].click();", storeReceiveQty6);
			}
			WebElement storeReceiveQty7 = driver.findElement(
					By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l4 r4')]//input"));
			String storeReceiveQty4_string = getData("Samples Master Fields", 14, 10);
			storeReceiveQty7.sendKeys(storeReceiveQty4_string);

			WebElement unitPrice6 = driver
					.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l6 r6')]"));
			j.executeScript("arguments[0].click();", unitPrice6);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", unitPrice6);
			} catch (StaleElementReferenceException e5) {
				unitPrice6 = driver
						.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l6 r6')]"));
				j.executeScript("arguments[0].click();", unitPrice6);
			}
			WebElement unitPrice7 = driver.findElement(
					By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l6 r6')]//input"));
			String unitPrice4_string = getData("Samples Master Fields", 14, 11);
			unitPrice7.sendKeys(unitPrice4_string);

			Add_Line_Item_for_Samples_GRN();

//5th Line
			WebElement itemDesc8 = driver
					.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l2 r2')]"));
			j.executeScript("arguments[0].click();", itemDesc8);
			WebElement itemDesc9 = driver.findElement(
					By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l2 r2')]//input"));
			String itemDesc5_string = getData("Samples Master Fields", 15, 9);
			itemDesc9.sendKeys(itemDesc5_string);
			Thread.sleep(500);

			// Without IQC checkbox code
			WebElement checkBox8 = driver
					.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l3 r3')]"));
			j.executeScript("arguments[0].click();", checkBox8);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", checkBox8);
			} catch (StaleElementReferenceException e5) {
				checkBox8 = driver.findElement(
						By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l3 r3')]"));
				j.executeScript("arguments[0].click();", checkBox8);
			}
			WebElement checkBox9 = driver.findElement(By.xpath(
					".//div[@style='top:100px']//div[contains (@class, 'slick-cell l3 r3')]//input[@type='checkbox']"));
			j.executeScript("arguments[0].click();", checkBox9);

			WebElement storeReceiveQty8 = driver
					.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l4 r4')]"));
			j.executeScript("arguments[0].click();", storeReceiveQty8);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", storeReceiveQty8);
			} catch (StaleElementReferenceException e5) {
				storeReceiveQty8 = driver.findElement(
						By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l4 r4')]"));
				j.executeScript("arguments[0].click();", storeReceiveQty8);
			}
			WebElement storeReceiveQty9 = driver.findElement(
					By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l4 r4')]//input"));
			String storeReceiveQty5_string = getData("Samples Master Fields", 15, 10);
			storeReceiveQty9.sendKeys(storeReceiveQty5_string);

			WebElement unitPrice8 = driver
					.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l6 r6')]"));
			j.executeScript("arguments[0].click();", unitPrice8);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", unitPrice8);
			} catch (StaleElementReferenceException e5) {
				unitPrice8 = driver.findElement(
						By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l6 r6')]"));
				j.executeScript("arguments[0].click();", unitPrice8);
			}
			WebElement unitPrice9 = driver.findElement(
					By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l6 r6')]//input"));
			String unitPrice5_string = getData("Samples Master Fields", 15, 11);
			unitPrice9.sendKeys(unitPrice5_string);

			int maxretries = 3;
			for (int i = 0; i < maxretries; i++) {
				try {
					WebElement dummy = driver.findElement(
							By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l7 r7')]"));
					dummy.click();
					break;
				} catch (StaleElementReferenceException e) {
				}
			}

			String attribute = totalReceiptValue.getAttribute("value");
			WebElement invoiceValue = driver.findElement(
					By.xpath("(//app-form-text//div[1]//input [@pattern='^[+-]?((\\d+(\\.\\d*)?)|(\\.\\d+))$'])"));
			invoiceValue.sendKeys(attribute);
		}
	}

	@When("User select the Fully Received status from the filter for Samples")
	public void user_select_the_fully_received_status_from_the_filter_for_Samples() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement receiptBtn = driver.findElement(By.xpath("(//a[contains(text(),'Receipt')])[1]"));
		j.executeScript("window.scrollTo(0,0);", receiptBtn);
		wait.until(ExpectedConditions.elementToBeClickable(receiptBtn));
		j.executeScript("arguments[0].click();", receiptBtn);

		WebElement GRNStatus = driver.findElement(By.xpath("//select[@name='receiptstatusid']"));
		selectOptionByIndex(GRNStatus, 2);
		Thread.sleep(3000);
	}

	@When("User click on the Samples edit button")
	public void user_click_on_the_Samples_edit_button() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement issueModule = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollTo(0,0);", issueModule);
		wait.until(ExpectedConditions.elementToBeClickable(issueModule));
		j.executeScript("arguments[0].click();", issueModule);
		Thread.sleep(1000);

		WebElement editBtn = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@role='grid']//tbody//tr[1]//th//button[1]//i")));
		wait.until(ExpectedConditions.elementToBeClickable(editBtn));
		j.executeScript("arguments[0].click();", editBtn);
		Thread.sleep(2000);
	}

	@When("User click on the edit button for Samples")
	public void user_click_on_the_edit_button_for_Samples() throws InterruptedException {
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

	@When("User move the stock to the Store for Samples")
	public void user_move_the_stock_to_the_store_for_Samples() {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebElement checkBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		j.executeScript("arguments[0].click();", checkBox);

		WebElement btnMoveToStore = driver.findElement(By.xpath("//button[contains (text(), 'Move to Store')]"));
		btnMoveToStore.click();
	}

	@Then("User click on the signout button for Samples")
	public void user_click_on_the_signout_button_for_Samples() throws InterruptedException {
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

	@Given("User enters the PM Team Member {string} and {string} for Samples")
	public void user_enters_the_pm_team_member_and_for_Samples(String username, String password) {
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

	public void Add_Line_Item() throws InterruptedException {

		JavascriptExecutor j = (JavascriptExecutor) driver;

		int maxretries = 3;
		for (int i = 0; i < maxretries; i++) {
			try {
				WebElement dummy = driver
						.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l8 r8')]"));
				j.executeScript("arguments[0].click();", dummy);
				Thread.sleep(1000);
				WebElement add_btn = driver.findElement(By.xpath(".//div//button[@ptooltip='Add']//i"));
				j.executeScript("arguments[0].click();", add_btn);
				break;
			} catch (StaleElementReferenceException e) {
			}
		}
	}

	public void Add_Line_Item_for_Samples() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebElement add_btn = driver.findElement(By.xpath(".//div//button[@ptooltip='Add']//i"));
		wait.until(ExpectedConditions.elementToBeClickable(add_btn));
		j.executeScript("arguments[0].click();", add_btn);
		int maxretries = 3;
		for (int i = 0; i < maxretries; i++) {
			try {
				WebElement dummy = driver
						.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l4 r4')]"));
				dummy.click();
				add_btn = driver.findElement(By.xpath(".//div//button[@ptooltip='Add']//i"));
				j.executeScript("arguments[0].click();", add_btn);
				break;
			} catch (StaleElementReferenceException e) {
			}
		}
	}

	@When("User create the Samples Request")
	public void user_create_the_Samples_request() throws InterruptedException, IOException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebElement issueModule = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		issueModule.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement addBtn = driver.findElement(By.xpath("(//button[@title='Add' and @type='button'])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(addBtn));
		j.executeScript("arguments[0].click();", addBtn);
		Thread.sleep(2000);

		WebElement requestType = (driver.findElement(By.xpath("(.//div//select)[1]")));
		String request = getData("Samples Master Fields", 1, 0);
		select(requestType).selectByVisibleText(request);
		Thread.sleep(500);

		WebElement wareHouse = (driver.findElement(By.xpath("(.//div//select)[3]")));
		String warehouse_string = getData("Samples Master Fields", 1, 1);
		select(wareHouse).selectByVisibleText(warehouse_string);

		WebElement project_name = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
		String project_name_string = getData("PMG Master Fields", 1, 4);
		project_name.sendKeys(project_name_string);
		Thread.sleep(500);

		List<WebElement> project_name_list = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
		for (WebElement webElement : project_name_list) {
			String list = webElement.getText();
			if (list.contains(project_name_string)) {
				Thread.sleep(500);
				JavascriptExecutor k = (JavascriptExecutor) driver;
				k.executeScript("arguments[0].click();", webElement);
				System.out.println(webElement);
				break;
			}
			Thread.sleep(1000);
		}

		WebElement product_code = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		String product_code_string = getData("PMG Master Fields", 1, 3);
		product_code.sendKeys(product_code_string);
		Thread.sleep(500);

		List<WebElement> product_code_list = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
		for (WebElement webElement : product_code_list) {
			String list = webElement.getText();
			if (list.contains(product_code_string)) {
				Thread.sleep(500);
				JavascriptExecutor k = (JavascriptExecutor) driver;
				k.executeScript("arguments[0].click();", webElement);
				System.out.println(webElement);
				break;
			}
			Thread.sleep(1000);
		}

		// Grid Fields

//1st Line

		WebElement materialName = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", materialName);
		WebElement material_name = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l2 r2')]//input"));
		String material_name_string = getData("Samples Master Fields", 11, 9);
		wait.until(ExpectedConditions.visibilityOf(material_name));
		material_name.sendKeys(material_name_string);
		WebElement autoSuggestion = driver.findElement(By.xpath("//*[@class='ui-menu-item'][1]"));
		j.executeScript("arguments[0].click();", autoSuggestion);

		WebElement requiredQty = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", requiredQty);
		Thread.sleep(500);
		int maxretries = 3;
		for (int i = 0; i < maxretries; i++) {
			try {
				requiredQty = driver
						.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l3 r3')]"));
				j.executeScript("arguments[0].click();", requiredQty);
				break;
			} catch (StaleElementReferenceException e) {
			}
		}
		WebElement required_qty = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String required_qty_string = getData("Samples Master Fields", 1, 7);
		wait.until(ExpectedConditions.visibilityOf(required_qty));
		required_qty.sendKeys(required_qty_string);
		Thread.sleep(1000);

		Add_Line_Item_for_Samples();

//2nd Line

		WebElement materialName1 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", materialName1);
		for (int i = 0; i < maxretries; i++) {
			try {
				materialName1 = driver
						.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l2 r2')]"));
				j.executeScript("arguments[0].click();", materialName1);
				WebElement material_name1 = driver.findElement(
						By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l2 r2')]//input"));
				String material_name_string1 = getData("Samples Master Fields", 12, 9);
				material_name1.sendKeys(material_name_string1);
				WebElement autoSuggestion1 = driver.findElement(By.xpath("//*[@class='ui-menu-item'][1]"));
				j.executeScript("arguments[0].click();", autoSuggestion1);
				break;
			} catch (StaleElementReferenceException e) {
			}
		}

		WebElement requiredQty1 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", requiredQty1);
		Thread.sleep(500);
		for (int i = 0; i < maxretries; i++) {
			try {
				requiredQty1 = driver
						.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l3 r3')]"));
				j.executeScript("arguments[0].click();", requiredQty1);
				break;
			} catch (StaleElementReferenceException e) {
			}
		}
		WebElement required_qty1 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String required_qty_string1 = getData("Samples Master Fields", 1, 7);
		wait.until(ExpectedConditions.visibilityOf(required_qty1));
		required_qty1.sendKeys(required_qty_string1);
		Thread.sleep(1000);

		Add_Line_Item_for_Samples();

//3rd Line

		WebElement materialName2 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", materialName2);
		for (int i = 0; i < maxretries; i++) {
			try {
				materialName2 = driver
						.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l2 r2')]"));
				j.executeScript("arguments[0].click();", materialName2);
				WebElement material_name2 = driver.findElement(
						By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l2 r2')]//input"));
				String material_name_string2 = getData("Samples Master Fields", 13, 9);
				material_name2.sendKeys(material_name_string2);
				WebElement autoSuggestion1 = driver.findElement(By.xpath("//*[@class='ui-menu-item'][1]"));
				j.executeScript("arguments[0].click();", autoSuggestion1);
				break;
			} catch (StaleElementReferenceException e) {
			}
		}

		WebElement requiredQty2 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", requiredQty2);
		Thread.sleep(500);
		for (int i = 0; i < maxretries; i++) {
			try {
				requiredQty2 = driver
						.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l3 r3')]"));
				j.executeScript("arguments[0].click();", requiredQty2);
				break;
			} catch (StaleElementReferenceException e) {
			}
		}
		WebElement required_qty2 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String required_qty_string2 = getData("Samples Master Fields", 1, 7);
		wait.until(ExpectedConditions.visibilityOf(required_qty2));
		required_qty2.sendKeys(required_qty_string2);
		Thread.sleep(1000);

		Add_Line_Item_for_Samples();

//4th Line

		WebElement materialName3 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", materialName3);
		for (int i = 0; i < maxretries; i++) {
			try {
				materialName3 = driver
						.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l2 r2')]"));
				j.executeScript("arguments[0].click();", materialName3);
				WebElement material_name3 = driver.findElement(
						By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l2 r2')]//input"));
				String material_name_string3 = getData("Samples Master Fields", 14, 9);
				material_name3.sendKeys(material_name_string3);
				WebElement autoSuggestion1 = driver.findElement(By.xpath("//*[@class='ui-menu-item'][1]"));
				j.executeScript("arguments[0].click();", autoSuggestion1);
				break;
			} catch (StaleElementReferenceException e) {
			}
		}

		WebElement requiredQty3 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", requiredQty3);
		Thread.sleep(500);
		for (int i = 0; i < maxretries; i++) {
			try {
				requiredQty3 = driver
						.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l3 r3')]"));
				j.executeScript("arguments[0].click();", requiredQty3);
				break;
			} catch (StaleElementReferenceException e) {
			}
		}
		WebElement required_qty3 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String required_qty_string3 = getData("Samples Master Fields", 1, 7);
		wait.until(ExpectedConditions.visibilityOf(required_qty3));
		required_qty3.sendKeys(required_qty_string3);
		Thread.sleep(1000);

		Add_Line_Item_for_Samples();

//5th Line

		WebElement materialName4 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", materialName4);
		for (int i = 0; i < maxretries; i++) {
			try {
				materialName4 = driver.findElement(
						By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l2 r2')]"));
				j.executeScript("arguments[0].click();", materialName4);
				WebElement material_name4 = driver.findElement(
						By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l2 r2')]//input"));
				String material_name_string4 = getData("Samples Master Fields", 15, 9);
				material_name4.sendKeys(material_name_string4);
				WebElement autoSuggestion1 = driver.findElement(By.xpath("//*[@class='ui-menu-item'][1]"));
				j.executeScript("arguments[0].click();", autoSuggestion1);
				break;
			} catch (StaleElementReferenceException e) {
			}
		}

		WebElement requiredQty4 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", requiredQty4);
		Thread.sleep(500);
		for (int i = 0; i < maxretries; i++) {
			try {
				requiredQty4 = driver.findElement(
						By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l3 r3')]"));
				j.executeScript("arguments[0].click();", requiredQty4);
				break;
			} catch (StaleElementReferenceException e) {
			}
		}
		WebElement required_qty4 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String required_qty_string4 = getData("Samples Master Fields", 1, 7);
		wait.until(ExpectedConditions.visibilityOf(required_qty4));
		required_qty4.sendKeys(required_qty_string4);
		Thread.sleep(1000);
	}

	@When("User select the Samples Requested status from the filter for Samples")
	public void user_select_the_Samples_requested_status_from_the_filter_for_Samples()
			throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement issuesBtn = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(issuesBtn));
		j.executeScript("arguments[0].click();", issuesBtn);

		WebElement store = driver.findElement(By.xpath("//select[@name='requeststoreid']"));
		String store_string = getData("Samples Master Fields", 1, 10);
		select(store).selectByVisibleText(store_string);

		WebElement requestType = driver.findElement(By.xpath("//select[@name='requesttypeid']"));
		String requestType_string = getData("Samples Master Fields", 1, 11);
		select(requestType).selectByVisibleText(requestType_string);

		WebElement SamplesStatus = driver.findElement(By.xpath("//select[@name='csmissuestatusid']"));
		String SamplesStatus_string = getData("Samples Master Fields", 1, 12);
		select(SamplesStatus).selectByVisibleText(SamplesStatus_string);
		Thread.sleep(3000);
	}

	@When("User Approve the Samples Request")
	public void user_approve_the_Samples_request() throws IOException {
		WebElement approvalStatus = driver.findElement(By.xpath("(//select)[7]"));
		String approvalStatus_string = getData("Samples Master Fields", 1, 16);
		select(approvalStatus).selectByVisibleText(approvalStatus_string);
	}

	@When("User click on the Issue icon for Issue Module for Samples")
	public void user_click_on_the_issue_icon_for_issue_module_for_Samples() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement issuesBtn = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(issuesBtn));
		j.executeScript("arguments[0].click();", issuesBtn);
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
		Thread.sleep(3000);
	}

	@When("User select the Samples Issued status from the filter for Samples")
	public void user_select_the_Samples_issued_status_from_the_filter_for_Samples()
			throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement issuesBtn = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(issuesBtn));
		j.executeScript("arguments[0].click();", issuesBtn);

		WebElement store = driver.findElement(By.xpath("//select[@name='requeststoreid']"));
		String store_string = getData("Samples Master Fields", 3, 10);
		select(store).selectByVisibleText(store_string);

		WebElement requestType = driver.findElement(By.xpath("//select[@name='requesttypeid']"));
		String requestType_string = getData("Samples Master Fields", 3, 11);
		select(requestType).selectByVisibleText(requestType_string);

		WebElement SamplesStatus = driver.findElement(By.xpath("//select[@name='csmissuestatusid']"));
		String SamplesStatus_string = getData("Samples Master Fields", 3, 12);
		select(SamplesStatus).selectByVisibleText(SamplesStatus_string);
		Thread.sleep(3000);
	}

	@Then("User verifies the Samples Status has been changed to Issued and Signout for Samples")
	public void user_verifies_the_Samples_status_has_been_changed_to_issued_and_signout_for_Samples()
			throws InterruptedException {
		WebElement successfully_Issued = driver
				.findElement(By.xpath("//app-wstable//div[@class='ws-table-head']//table[@role='grid']//tbody//tr[1]"));
		System.out.println("Successfull Samples Issued : " + successfully_Issued.getText());
		Thread.sleep(1000);

		WebElement profileClick = driver.findElement(By.xpath("(//app-header//div//div//span[@class = 'd-block'])[1]"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollTo(0,0);", profileClick);
		Thread.sleep(1000);
		profileClick.click();
		WebElement signOutBtn = driver.findElement(
				By.xpath("//h3[contains (@class, 'dropdown-item-title') and contains (text(), 'Sign out ')][1]"));
		signOutBtn.click();
		driver.quit();
	}

	@When("User enters the Issue Qty Fully for Samples")
	public void user_enters_the_issue_qty_fully_for_samples() throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

//1st Line
		WebElement grnNumber = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l4 r4')]"));
		j.executeScript("arguments[0].click();", grnNumber);
		Thread.sleep(500);

		WebElement lineNumber = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l5 r5')]"));
		j.executeScript("arguments[0].click();", lineNumber);
		Thread.sleep(500);
		
		WebElement avlQty = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l7 r7')]"));
		j.executeScript("arguments[0].click();", avlQty);
		Thread.sleep(500);
		
		WebElement IssueQty = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l8 r8')]"));
		j.executeScript("arguments[0].click();", IssueQty);
		WebElement IssueQty1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l8 r8')]//input"));
		String IssueQty_string = getData("Samples Master Fields", 1, 16);
		IssueQty1.sendKeys(IssueQty_string);

//2nd Line
		WebElement grnNumber1 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l4 r4')]"));
		j.executeScript("arguments[0].click();", grnNumber1);
		Thread.sleep(500);
		
		WebElement lineNumber1 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l5 r5')]"));
		j.executeScript("arguments[0].click();", lineNumber1);
		Thread.sleep(500);
		
		WebElement avlQty1 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l7 r7')]"));
		j.executeScript("arguments[0].click();", avlQty1);
		Thread.sleep(500);
		
		WebElement IssueQty2 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l8 r8')]"));
		j.executeScript("arguments[0].click();", IssueQty2);
		WebElement IssueQty3 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l8 r8')]//input"));
		String IssueQty1_string = getData("Samples Master Fields", 1, 16);
		IssueQty3.sendKeys(IssueQty1_string);

//3rd Line
		WebElement grnNumber2 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l4 r4')]"));
		j.executeScript("arguments[0].click();", grnNumber2);
		Thread.sleep(500);
		
		WebElement lineNumber2 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l5 r5')]"));
		j.executeScript("arguments[0].click();", lineNumber2);
		Thread.sleep(500);
		
		WebElement avlQty2 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l7 r7')]"));
		j.executeScript("arguments[0].click();", avlQty2);
		Thread.sleep(500);
		
		WebElement IssueQty4 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l8 r8')]"));
		j.executeScript("arguments[0].click();", IssueQty4);
		WebElement IssueQty5 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l8 r8')]//input"));
		String IssueQty2_string = getData("Samples Master Fields", 1, 16);
		IssueQty5.sendKeys(IssueQty2_string);

//4th Line
		WebElement grnNumber3 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l4 r4')]"));
		j.executeScript("arguments[0].click();", grnNumber3);
		Thread.sleep(500);
		
		WebElement lineNumber3 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l5 r5')]"));
		j.executeScript("arguments[0].click();", lineNumber3);
		Thread.sleep(500);
		
		WebElement avlQty3 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l7 r7')]"));
		j.executeScript("arguments[0].click();", avlQty3);
		Thread.sleep(500);
		
		WebElement IssueQty6 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l8 r8')]"));
		j.executeScript("arguments[0].click();", IssueQty6);
		WebElement IssueQty7 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l8 r8')]//input"));
		String IssueQty3_string = getData("Samples Master Fields", 1, 16);
		IssueQty7.sendKeys(IssueQty3_string);

//5th Line
		WebElement grnNumber4 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l4 r4')]"));
		j.executeScript("arguments[0].click();", grnNumber4);
		Thread.sleep(500);
		
		WebElement lineNumber4 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l5 r5')]"));
		j.executeScript("arguments[0].click();", lineNumber4);
		Thread.sleep(500);
		
		WebElement avlQty4 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l7 r7')]"));
		j.executeScript("arguments[0].click();", avlQty4);
		Thread.sleep(500);
		
		WebElement IssueQty8 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l8 r8')]"));
		j.executeScript("arguments[0].click();", IssueQty8);
		WebElement IssueQty9 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l8 r8')]//input"));
		String IssueQty4_string = getData("Samples Master Fields", 1, 16);
		IssueQty9.sendKeys(IssueQty4_string);
	}

}
