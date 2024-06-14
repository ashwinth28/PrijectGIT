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

public class FOC_StepDefinition extends LibGlobal {

	public static WebDriver driver;

	@Given("User on the login page for FOC")
	public void user_on_the_login_page_for_FOC() {
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

	@Given("User enters the SCM Team Member {string} and {string} for FOC")
	public void user_enters_the_scm_team_member_and_for_FOC(String username, String password) {
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

	@When("User create the PO Request for PO ORDER for FOC")
	public void user_create_the_po_request_for_po_order_for_FOC() throws InterruptedException, IOException {
		WebElement purchaseOrderBtn = driver.findElement(By.xpath("(//a[contains(text(),'Purchase Order')])[1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(purchaseOrderBtn,
				By.xpath("(//a[contains(text(),'Purchase Order')])[1]")));
		purchaseOrderBtn.click();

		WebElement addBtn = driver.findElement(By.xpath("(//button[@title='Add' and @type='button'])[1]"));
		addBtn.click();
		Thread.sleep(1000);

		WebElement branch = (driver.findElement(By.xpath("(//select)[1]")));
		String mas_data = getData("FOC Master Fields", 11, 0);
		select(branch).selectByVisibleText(mas_data);
		Thread.sleep(500);

		WebElement wareHouse = (driver.findElement(By.xpath("(//select)[2]")));
		String mas_data1 = getData("FOC Master Fields", 11, 1);
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
		String mas_data2 = getData("FOC Master Fields", 11, 3);
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
		String mas_data3 = getData("FOC Master Fields", 11, 4);
		selectOptionByText(orderType, mas_data3);

		WebElement materialType = driver.findElement(By.xpath("(//select)[6]"));
		String mas_data4 = getData("FOC Master Fields", 11, 5);
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

		// FG Grid Fields
		else {
			FG_Multiple_Line_Items(driver);
		}
	}

	@When("User click on the save button for FOC")
	public void user_click_on_the_save_button_for_FOC() throws InterruptedException {
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

	@When("User click on the Edit button for FOC")
	public void user_click_on_the_Edit_button_for_FOC() {
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

	@When("User verify the PO and providing Pre-Approval for FOC")
	public void user_verify_the_po_and_providing_pre_approval_for_FOC() throws InterruptedException {
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

	@When("User click on the Save button for FOC")
	public void user_click_on_the_Save_button_for_FOC() throws InterruptedException {
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

	@Then("User verifies the PO Status has been changed and Signout for FOC")
	public void user_verifies_the_po_status_has_been_changed_and_signout_for_FOC() throws InterruptedException {
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

	@Given("User enters the Operations Head {string} and {string} for FOC")
	public void user_enters_the_operations_head_and_for_FOC(String username, String password) {
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

	@Given("User verify the PO and providing Final-Approval for FOC")
	public void user_verify_the_po_and_providing_final_approval_for_FOC() throws InterruptedException {
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

	@Given("User click on the Issue icon for FOC")
	public void user_click_on_the_issue_icon_for_FOC() throws InterruptedException {
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

	@When("User click on the Issue button for FOC")
	public void user_click_on_the_issue_button_for_FOC() throws InterruptedException {
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

	@Then("User verifies the PO Status has been changed to Issued and Signout for FOC")
	public void user_verifies_the_po_status_has_been_changed_to_issued_and_signout_for_FOC()
			throws InterruptedException {
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

	@Given("User enters the Store Team Member {string} and {string} for FOC")
	public void user_enters_the_store_team_member_and_for_FOC(String username, String password) {
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

	@When("User click on the FOC edit button")
	public void user_click_on_the_FOC_edit_button() throws InterruptedException {
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

	@When("User click on the edit button for FOC")
	public void user_click_on_the_edit_button_for_FOC() throws InterruptedException {
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

	@Then("User click on the signout button for FOC")
	public void user_click_on_the_signout_button_for_FOC() throws InterruptedException {
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

	@Given("User enters the PM Team Member {string} and {string} for FOC")
	public void user_enters_the_pm_team_member_and_for_FOC(String username, String password) {
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

	public void Add_Line_Item() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebElement add_btn = driver.findElement(By.xpath(".//div//button[@ptooltip='Add']//i"));
		wait.until(ExpectedConditions.elementToBeClickable(add_btn));
		j.executeScript("arguments[0].click();", add_btn);
		int maxretries = 3;
		for (int i = 0; i < maxretries; i++) {
			try {
				WebElement dummy = driver
						.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l8 r8')]"));
				dummy.click();
				add_btn = driver.findElement(By.xpath(".//div//button[@ptooltip='Add']//i"));
				j.executeScript("arguments[0].click();", add_btn);
				break;
			} catch (StaleElementReferenceException e) {
			}
		}
	}

	@When("User create the FOC Request")
	public void user_create_the_FOC_request() throws InterruptedException, IOException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement purchaseOrderBtn = driver.findElement(By.xpath("(//a[contains(text(),'Purchase Order')])[1]"));
		wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(purchaseOrderBtn,
				By.xpath("(//a[contains(text(),'Purchase Order')])[1]")));
		purchaseOrderBtn.click();
		Thread.sleep(500);

		WebElement PO_number = driver.findElement(By.xpath("(.//div//app-wstable//div//table//tbody//tr//td)[1]"));
		String PO_number_text = PO_number.getText();
		Thread.sleep(500);

		WebElement issueModule = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		issueModule.click();

		WebElement addBtn = driver.findElement(By.xpath("(//button[@title='Add' and @type='button'])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(addBtn));
		j.executeScript("arguments[0].click();", addBtn);
		Thread.sleep(2000);

		WebElement requestType = (driver.findElement(By.xpath("(.//div//select)[1]")));
		String request = getData("FOC Master Fields", 1, 0);
		select(requestType).selectByVisibleText(request);
		Thread.sleep(500);

		WebElement wareHouse = (driver.findElement(By.xpath("(.//div//select)[3]")));
		String warehouse_string = getData("FOC Master Fields", 1, 1);
		select(wareHouse).selectByVisibleText(warehouse_string);

		WebElement po_number = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
		po_number.sendKeys(PO_number_text);
		Thread.sleep(500);

		List<WebElement> po_number_list = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
		for (WebElement webElement : po_number_list) {
			String list = webElement.getText();
			if (list.contains(PO_number_text)) {
				Thread.sleep(500);
				j.executeScript("arguments[0].click();", webElement);
				System.out.println(webElement);
				break;
			}
			Thread.sleep(1000);
		}
		
		WebElement vendor_name = (driver.findElement(By.xpath("(.//div//select)[5]")));
		String vendor_name_string = getData("FOC Master Fields", 1, 13);
		select(vendor_name).selectByVisibleText(vendor_name_string);
		Thread.sleep(500);

		// Grid Fields

//1st Line
		WebElement material_type = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", material_type);
		WebElement material_type1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
		String material_type_string = getData("FOC Grid Fields", 1, 2);
		select(material_type1).selectByVisibleText(material_type_string);

		WebElement material_name = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", material_name);
		WebElement material_name1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String material_name_string = getData("FOC Grid Fields", 1, 3);
		material_name1.sendKeys(material_name_string);
		Thread.sleep(500);
		WebElement autoSuggestion = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
		j.executeScript("arguments[0].click();", autoSuggestion);
		Thread.sleep(500);

		WebElement required_qty = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l6 r6')]"));
		j.executeScript("arguments[0].click();", required_qty);
		Thread.sleep(500);

		int maxretries = 3;
		for (int i = 0; i < maxretries; i++) {
			try {
				required_qty = driver
						.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l6 r6')]"));
				j.executeScript("arguments[0].click();", required_qty);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		WebElement required_qty1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l6 r6')]//input"));
		String required_qty_string = getData("FOC Grid Fields", 1, 4);
		wait.until(ExpectedConditions.visibilityOf(required_qty1));
		required_qty1.sendKeys(required_qty_string);

		Add_Line_Item();

//2nd Line
		WebElement material_type2 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", material_type2);
		WebElement material_type3 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
		String material_type_string1 = getData("FOC Grid Fields", 2, 2);
		select(material_type3).selectByVisibleText(material_type_string1);

		WebElement material_name2 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", material_name2);
		WebElement material_name3 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String material_name_string1 = getData("FOC Grid Fields", 2, 3);
		material_name3.sendKeys(material_name_string1);
		Thread.sleep(500);
		WebElement autoSuggestion1 = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
		j.executeScript("arguments[0].click();", autoSuggestion1);

		WebElement required_qty2 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l6 r6')]"));
		j.executeScript("arguments[0].click();", required_qty2);
		Thread.sleep(500);

		for (int i = 0; i < maxretries; i++) {
			try {
				required_qty2 = driver
						.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l6 r6')]"));
				j.executeScript("arguments[0].click();", required_qty2);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		WebElement required_qty3 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l6 r6')]//input"));
		String required_qty_string1 = getData("FOC Grid Fields", 2, 4);
		wait.until(ExpectedConditions.visibilityOf(required_qty3));
		required_qty3.sendKeys(required_qty_string1);

		Add_Line_Item();

//3rd Line
		WebElement material_type4 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", material_type4);
		WebElement material_type5 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
		String material_type_string2 = getData("FOC Grid Fields", 3, 2);
		select(material_type5).selectByVisibleText(material_type_string2);

		WebElement material_name4 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", material_name4);
		WebElement material_name5 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String material_name_string2 = getData("FOC Grid Fields", 3, 3);
		material_name5.sendKeys(material_name_string2);
		Thread.sleep(500);
		WebElement autoSuggestion2 = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
		j.executeScript("arguments[0].click();", autoSuggestion2);

		WebElement required_qty4 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l6 r6')]"));
		j.executeScript("arguments[0].click();", required_qty4);
		Thread.sleep(500);

		for (int i = 0; i < maxretries; i++) {
			try {
				required_qty4 = driver
						.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l6 r6')]"));
				j.executeScript("arguments[0].click();", required_qty4);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		WebElement required_qty5 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l6 r6')]//input"));
		String required_qty_string2 = getData("FOC Grid Fields", 3, 4);
		wait.until(ExpectedConditions.visibilityOf(required_qty5));
		required_qty5.sendKeys(required_qty_string2);

		Add_Line_Item();

//4th Line
		WebElement material_type6 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", material_type6);
		WebElement material_type7 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
		String material_type_string3 = getData("FOC Grid Fields", 4, 2);
		select(material_type7).selectByVisibleText(material_type_string3);

		WebElement material_name6 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", material_name6);
		WebElement material_name7 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String material_name_string3 = getData("FOC Grid Fields", 4, 3);
		material_name7.sendKeys(material_name_string3);
		Thread.sleep(500);
		WebElement autoSuggestion3 = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
		j.executeScript("arguments[0].click();", autoSuggestion3);

		WebElement required_qty6 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l6 r6')]"));
		j.executeScript("arguments[0].click();", required_qty6);
		Thread.sleep(500);

		for (int i = 0; i < maxretries; i++) {
			try {
				required_qty6 = driver
						.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l6 r6')]"));
				j.executeScript("arguments[0].click();", required_qty6);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		WebElement required_qty7 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l6 r6')]//input"));
		String required_qty_string3 = getData("FOC Grid Fields", 4, 4);
		wait.until(ExpectedConditions.visibilityOf(required_qty7));
		required_qty7.sendKeys(required_qty_string3);

		Add_Line_Item();

//5th Line
		WebElement material_type8 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", material_type8);
		WebElement material_type9 = driver.findElement(
				By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
		String material_type_string4 = getData("FOC Grid Fields", 5, 2);
		select(material_type9).selectByVisibleText(material_type_string4);

		WebElement material_name8 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", material_name8);
		WebElement material_name9 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String material_name_string4 = getData("FOC Grid Fields", 5, 3);
		material_name9.sendKeys(material_name_string4);
		Thread.sleep(500);
		WebElement autoSuggestion4 = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
		j.executeScript("arguments[0].click();", autoSuggestion4);

		WebElement required_qty8 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l6 r6')]"));
		j.executeScript("arguments[0].click();", required_qty8);
		Thread.sleep(500);

		for (int i = 0; i < maxretries; i++) {
			try {
				required_qty8 = driver.findElement(
						By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l6 r6')]"));
				j.executeScript("arguments[0].click();", required_qty8);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		WebElement required_qty9 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l6 r6')]//input"));
		String required_qty_string4 = getData("FOC Grid Fields", 5, 4);
		wait.until(ExpectedConditions.visibilityOf(required_qty9));
		required_qty9.sendKeys(required_qty_string4);

		Add_Line_Item();

//6th Line
		WebElement material_type10 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", material_type10);
		WebElement material_type11 = driver.findElement(
				By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
		String material_type_string5 = getData("FOC Grid Fields", 6, 2);
		select(material_type11).selectByVisibleText(material_type_string5);

		WebElement material_name10 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", material_name10);
		WebElement material_name11 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String material_name_string5 = getData("FOC Grid Fields", 6, 3);
		material_name11.sendKeys(material_name_string5);
		Thread.sleep(500);
		WebElement autoSuggestion5 = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
		j.executeScript("arguments[0].click();", autoSuggestion5);

		WebElement required_qty10 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l6 r6')]"));
		j.executeScript("arguments[0].click();", required_qty10);
		Thread.sleep(500);

		for (int i = 0; i < maxretries; i++) {
			try {
				required_qty10 = driver
						.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l6 r6')]"));
				j.executeScript("arguments[0].click();", required_qty10);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		WebElement required_qty11 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l6 r6')]//input"));
		String required_qty_string5 = getData("FOC Grid Fields", 6, 4);
		wait.until(ExpectedConditions.visibilityOf(required_qty11));
		required_qty11.sendKeys(required_qty_string5);

		Add_Line_Item();

//7th Line
		WebElement material_type12 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", material_type12);
		WebElement material_type13 = driver.findElement(
				By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
		String material_type_string6 = getData("FOC Grid Fields", 7, 2);
		select(material_type13).selectByVisibleText(material_type_string6);

		WebElement material_name12 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", material_name12);
		WebElement material_name13 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String material_name_string6 = getData("FOC Grid Fields", 7, 3);
		material_name13.sendKeys(material_name_string6);
		Thread.sleep(500);
		WebElement autoSuggestion6 = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
		j.executeScript("arguments[0].click();", autoSuggestion6);

		WebElement required_qty12 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l6 r6')]"));
		j.executeScript("arguments[0].click();", required_qty12);
		Thread.sleep(500);

		for (int i = 0; i < maxretries; i++) {
			try {
				required_qty12 = driver
						.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l6 r6')]"));
				j.executeScript("arguments[0].click();", required_qty12);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		WebElement required_qty13 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l6 r6')]//input"));
		String required_qty_string6 = getData("FOC Grid Fields", 7, 4);
		wait.until(ExpectedConditions.visibilityOf(required_qty13));
		required_qty13.sendKeys(required_qty_string6);

		Add_Line_Item();

//8th Line
		WebElement material_type14 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", material_type14);
		WebElement material_type15 = driver.findElement(
				By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
		String material_type_string7 = getData("FOC Grid Fields", 8, 2);
		select(material_type15).selectByVisibleText(material_type_string7);

		WebElement material_name14 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", material_name14);
		WebElement material_name15 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String material_name_string7 = getData("FOC Grid Fields", 8, 3);
		material_name15.sendKeys(material_name_string7);
		Thread.sleep(500);
		WebElement autoSuggestion7 = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
		j.executeScript("arguments[0].click();", autoSuggestion7);

		WebElement required_qty14 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l6 r6')]"));
		j.executeScript("arguments[0].click();", required_qty14);
		Thread.sleep(500);

		for (int i = 0; i < maxretries; i++) {
			try {
				required_qty14 = driver
						.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l6 r6')]"));
				j.executeScript("arguments[0].click();", required_qty14);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		WebElement required_qty15 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l6 r6')]//input"));
		String required_qty_string7 = getData("FOC Grid Fields", 8, 4);
		wait.until(ExpectedConditions.visibilityOf(required_qty15));
		required_qty15.sendKeys(required_qty_string7);
	}

	@When("User select the FOC Requested status from the filter")
	public void user_select_the_FOC_requested_status_from_the_filter() throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement issuesBtn = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(issuesBtn));
		j.executeScript("arguments[0].click();", issuesBtn);

		WebElement store = driver.findElement(By.xpath("//select[@name='requeststoreid']"));
		String store_string = getData("FOC Master Fields", 1, 10);
		select(store).selectByVisibleText(store_string);

		WebElement requestType = driver.findElement(By.xpath("//select[@name='requesttypeid']"));
		String requestType_string = getData("FOC Master Fields", 1, 11);
		select(requestType).selectByVisibleText(requestType_string);

		WebElement FOCStatus = driver.findElement(By.xpath("//select[@name='focissuestatusid']"));
		String FOCStatus_string = getData("FOC Master Fields", 1, 12);
		select(FOCStatus).selectByVisibleText(FOCStatus_string);
		Thread.sleep(3000);
	}

	@When("User click on the Issue icon for Issue Module for FOC")
	public void user_click_on_the_issue_icon_for_issue_module_for_FOC() throws InterruptedException {
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

	@When("User select the FOC Issued status from the filter for FOC")
	public void user_select_the_FOC_issued_status_from_the_filter_for_FOC() throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement issuesBtn = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(issuesBtn));
		j.executeScript("arguments[0].click();", issuesBtn);

		WebElement store = driver.findElement(By.xpath("//select[@name='requeststoreid']"));
		String store_string = getData("FOC Master Fields", 2, 10);
		select(store).selectByVisibleText(store_string);

		WebElement requestType = driver.findElement(By.xpath("//select[@name='requesttypeid']"));
		String requestType_string = getData("FOC Master Fields", 2, 11);
		select(requestType).selectByVisibleText(requestType_string);

		WebElement FOCStatus = driver.findElement(By.xpath("//select[@name='focissuestatusid']"));
		String FOCStatus_string = getData("FOC Master Fields", 2, 12);
		select(FOCStatus).selectByVisibleText(FOCStatus_string);
		Thread.sleep(3000);
	}

	@Then("User verifies the FOC Status has been changed to Issued and Signout for FOC")
	public void user_verifies_the_FOC_status_has_been_changed_to_issued_and_signout_for_FOC()
			throws InterruptedException {
		WebElement successfully_Issued = driver
				.findElement(By.xpath("//app-wstable//div[@class='ws-table-head']//table[@role='grid']//tbody//tr[1]"));
		System.out.println("Successfull FOC Issued : " + successfully_Issued.getText());
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

	@When("User enter the Partially Issued Qty for FOC")
	public void user_enter_the_partially_issued_qty_for_FOC() throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebElement partiallyIssueQty = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l11 r11')]"));
		j.executeScript("arguments[0].click();", partiallyIssueQty);
		WebElement partiallyIssueQty1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l11 r11')]//input"));
		String partiallyIssueQty_string = getData("FOC Master Fields", 1, 17);
		partiallyIssueQty1.sendKeys(partiallyIssueQty_string);
	}

	@When("User select the Partialy Issued status from the filter for FOC")
	public void user_select_the_partialy_issued_status_from_the_filter_for_FOC()
			throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement issuesBtn = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(issuesBtn));
		j.executeScript("arguments[0].click();", issuesBtn);

		WebElement store = driver.findElement(By.xpath("//select[@name='requeststoreid']"));
		String store_string = getData("FOC Master Fields", 3, 10);
		select(store).selectByVisibleText(store_string);

		WebElement requestType = driver.findElement(By.xpath("//select[@name='requesttypeid']"));
		String requestType_string = getData("FOC Master Fields", 3, 11);
		select(requestType).selectByVisibleText(requestType_string);

		WebElement FOCStatus = driver.findElement(By.xpath("//select[@name='focissuestatusid']"));
		String FOCStatus_string = getData("FOC Master Fields", 3, 12);
		select(FOCStatus).selectByVisibleText(FOCStatus_string);
		Thread.sleep(3000);
	}

}
