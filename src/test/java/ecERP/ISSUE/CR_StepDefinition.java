package ecERP.ISSUE;

import static org.junit.Assert.assertEquals;

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

public class CR_StepDefinition extends LibGlobal {

	public static WebDriver driver;

	@Given("User on the login page for CR")
	public void user_on_the_login_page_for_CR() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.get("https://qa-erp.e-consystems.net");
//		driver.get("https://stage-erp.e-consystems.net");
//		driver.get("http://192.168.8.119:8080/#/login");
//		driver.get("http://localhost:8080/#/");
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

	@Given("User enters the SCM Team Member {string} and {string} for CR")
	public void user_enters_the_scm_team_member_and_for_CR(String username, String password) {
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

	@When("User create the PO Request for PO ORDER for CR")
	public void user_create_the_po_request_for_po_order_for_CR() throws InterruptedException, IOException {
		WebElement purchaseOrderBtn = driver.findElement(By.xpath("(//a[contains(text(),'Purchase Order')])[1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(purchaseOrderBtn,
				By.xpath("(//a[contains(text(),'Purchase Order')])[1]")));
		purchaseOrderBtn.click();

		WebElement addBtn = driver.findElement(By.xpath("(//button[@title='Add' and @type='button'])[1]"));
		addBtn.click();
		Thread.sleep(1000);

		WebElement branch = (driver.findElement(By.xpath("(//select)[1]")));
		String mas_data = getData("CR Master Fields", 11, 0);
		select(branch).selectByVisibleText(mas_data);
		Thread.sleep(500);

		WebElement wareHouse = (driver.findElement(By.xpath("(//select)[2]")));
		String mas_data1 = getData("CR Master Fields", 11, 1);
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
		String mas_data2 = getData("CR Master Fields", 11, 3);
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
		String mas_data3 = getData("CR Master Fields", 11, 4);
		selectOptionByText(orderType, mas_data3);

		WebElement materialType = driver.findElement(By.xpath("(//select)[6]"));
		String mas_data4 = getData("CR Master Fields", 11, 5);
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
			JavascriptExecutor j = (JavascriptExecutor) driver;
			WebElement costCenter = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l1 r1')]"));
			j.executeScript("arguments[0].click();", costCenter);
			WebElement costCenter1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l1 r1')]//select"));
			String costcenter_string = getData("Grid_Data", 2, 12);

			int maxretries = 3;
			for (int i = 0; i < maxretries; i++) {
				try {
					costCenter1 = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l1 r1')]//select"));
					select(costCenter1).selectByVisibleText(costcenter_string);
					break;
				} catch (StaleElementReferenceException e) {
					System.out.println("Maximum Retry Failed");
				}
			}

			Thread.sleep(500);

			WebElement expenseCategory = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l2 r2')]"));
			j.executeScript("arguments[0].click();", expenseCategory);
			WebElement expenseCategory1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l2 r2')]//select"));
			String expensecategory_string = getData("Grid_Data", 2, 13);
			select(expenseCategory1).selectByVisibleText(expensecategory_string);

			WebElement partNo = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l3 r3')]"));
			j.executeScript("arguments[0].click();", partNo);
			WebElement partNo1 = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l3 r3')]//input"));
			String grid_data = getData("Grid_Data", 2, 7);
			partNo1.sendKeys(grid_data);
			WebElement autoSuggestion = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
			autoSuggestion.click();

			WebElement originalMaterialType = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l4 r4')]"));
			j.executeScript("arguments[0].click();", originalMaterialType);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", originalMaterialType);
			} catch (StaleElementReferenceException e) {
				originalMaterialType = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l4 r4')]"));
				j.executeScript("arguments[0].click();", originalMaterialType);
			}
			WebElement originalMaterialType1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l4 r4')]//select"));
			String Original_Mat_Type_data = getData("Grid_Data", 2, 11);
			select(originalMaterialType1).selectByVisibleText(Original_Mat_Type_data);

			WebElement workType = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l5 r5')]"));
			j.executeScript("arguments[0].click();", workType);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", workType);
			} catch (StaleElementReferenceException e1) {
				workType = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l5 r5')]"));
				j.executeScript("arguments[0].click();", workType);
			}
			WebElement workType1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l5 r5')]//select"));
			selectOptionByIndex(workType1, 0);

			WebElement name = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l6 r6')]"));
			j.executeScript("arguments[0].click();", name);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", name);
			} catch (StaleElementReferenceException e2) {
				name = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l6 r6')]"));
				j.executeScript("arguments[0].click();", name);
			}
			Thread.sleep(1000);
			WebElement name1 = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l6 r6')]//input"));
			String grid_data2 = getData("Grid_Data", 2, 8);
			name1.sendKeys(grid_data2);
			WebElement autoSuggestion1 = driver.findElement(By.xpath("//*[@class='ui-menu-item'][1]"));
			autoSuggestion1.click();

			WebElement qty = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l7 r7')]"));
			j.executeScript("arguments[0].click();", qty);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", qty);
			} catch (StaleElementReferenceException e3) {
				qty = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l7 r7')]"));
				j.executeScript("arguments[0].click();", qty);
			}
			WebElement qty1 = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l7 r7')]//input"));
			String grid_data3 = getData("Grid_Data", 2, 9);
			qty1.sendKeys(grid_data3);

			WebElement unitPrice = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l8 r8')]"));
			j.executeScript("arguments[0].click();", unitPrice);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", unitPrice);
				Thread.sleep(500);
			} catch (StaleElementReferenceException e4) {
				unitPrice = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l8 r8')]"));
				j.executeScript("arguments[0].click();", unitPrice);
			}
			WebElement unitPrice1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l8 r8')]//input"));
			String grid_data4 = getData("Grid_Data", 2, 10);
			unitPrice1.sendKeys(grid_data4);

			WebElement UOM = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l12 r12')]"));
			j.executeScript("arguments[0].click();", UOM);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", UOM);
			} catch (StaleElementReferenceException e5) {
				UOM = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l12 r12')]"));
				j.executeScript("arguments[0].click();", UOM);
			}
			WebElement UOM1 = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l12 r12')]//select"));
			selectOptionByIndex(UOM1, 0);

			WebElement deliveryDate = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l13 r13')]"));
			j.executeScript("arguments[0].click();", deliveryDate);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", deliveryDate);
			} catch (StaleElementReferenceException e5) {
				deliveryDate = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l13 r13')]"));
				j.executeScript("arguments[0].click();", deliveryDate);
			}
			WebElement deliverDate1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l13 r13')]//input"));
			String date1 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			deliverDate1.sendKeys(date1);

			// With IQC checkbox code

			WebElement checkBox = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l14 r14')]"));
			j.executeScript("arguments[0].click();", checkBox);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", checkBox);
			} catch (StaleElementReferenceException e5) {
				checkBox = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l14 r14')]"));
				j.executeScript("arguments[0].click();", checkBox);
			}
			WebElement checkBox1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l14 r14')]//input[@type='checkbox']"));
			j.executeScript("arguments[0].click();", checkBox1);
//				j.executeScript("arguments[0].click();", checkBox1);

			// Withot IQC Checkbox code
			WebElement insReason = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l15 r15')]"));
			j.executeScript("arguments[0].click();", insReason);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", insReason);
			} catch (StaleElementReferenceException e5) {
				insReason = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l15 r15')]"));
				j.executeScript("arguments[0].click();", insReason);
			}
			WebElement reasonText = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l15 r15')]//input[@type='text']"));
			reasonText.sendKeys("Not Required");
			Thread.sleep(500);
			driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l14 r14')]")).click();
		}
	}

	@When("User click on the save button for CR")
	public void user_click_on_the_save_button_for_CR() throws InterruptedException {
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

	@When("User click on the Edit button for CR")
	public void user_click_on_the_Edit_button_for_CR() {
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

	@When("User verify the PO and providing Pre-Approval for CR")
	public void user_verify_the_po_and_providing_pre_approval_for_CR() throws InterruptedException {
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

	@When("User click on the Save button for CR")
	public void user_click_on_the_Save_button_for_CR() throws InterruptedException {
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

	@Then("User verifies the PO Status has been changed and Signout for CR")
	public void user_verifies_the_po_status_has_been_changed_and_signout_for_CR() throws InterruptedException {
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

	@Given("User enters the Operations Head {string} and {string} for CR")
	public void user_enters_the_operations_head_and_for_CR(String username, String password) {
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

	@Given("User verify the PO and providing Final-Approval for CR")
	public void user_verify_the_po_and_providing_final_approval_for_CR() throws InterruptedException {
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

	@Given("User click on the Issue icon for CR")
	public void user_click_on_the_issue_icon_for_CR() throws InterruptedException {
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

	@When("User click on the Issue button for CR")
	public void user_click_on_the_issue_button_for_CR() throws InterruptedException {
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

	@Then("User verifies the PO Status has been changed to Issued and Signout for CR")
	public void user_verifies_the_po_status_has_been_changed_to_issued_and_signout_for_CR()
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

	@Given("User enters the PM Team Member {string} and {string} for CR")
	public void user_enters_the_pm_team_member_and_for_cr(String username, String password) {
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

	@Given("User enters the Store Team Member {string} and {string} for CR")
	public void user_enters_the_store_team_member_and_for_CR(String username, String password) {
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

	@Given("User enters the Production Team Member {string} and {string} for CR")
	public void user_enters_the_production_team_member_and_for_cr(String username, String password) {
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

	@When("User create the GRN Request for Fully Received for CR")
	public void user_create_the_grn_request_for_fully_received_for_CR() throws InterruptedException, IOException {
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
		String mas_data = getData("CR Master Fields", 11, 0);
		select(branch).selectByVisibleText(mas_data);
		Thread.sleep(300);

		WebElement store = (driver
				.findElement(By.xpath("//*[@id='collapseOne']/div/div[2]/app-form-dyna-select/div/select")));
		String mas_data1 = getData("CR Master Fields", 11, 2);
		select(store).selectByVisibleText(mas_data1);
		Thread.sleep(300);

		WebElement orderType = (driver
				.findElement(By.xpath("//*[@id='collapseOne']/div/div[3]/app-form-dyna-select/div/select")));
		String mas_data2 = getData("CR Master Fields", 11, 4);
		select(orderType).selectByVisibleText(mas_data2);
		Thread.sleep(300);

		WebElement materialType = (driver
				.findElement(By.xpath("//*[@id='collapseOne']/div/div[4]/app-form-dyna-select/div/select")));
		String mas_data3 = getData("CR Master Fields", 11, 5);
		select(materialType).selectByVisibleText(mas_data3);
		Thread.sleep(300);

		WebElement vendorField = driver.findElement(By.xpath("(//input[@type='text' and @role='combobox'])[1]"));
		String mas_data4 = getData("CR Master Fields", 11, 3);
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
			gateEntryNo.sendKeys("5432");

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
			gateEntryNo.sendKeys("5432");

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

	@When("User select the Fully Received status from the filter for CR")
	public void user_select_the_fully_received_status_from_the_filter_for_CR() throws InterruptedException {
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

	@When("User click on the CR edit button")
	public void user_click_on_the_CR_edit_button() throws InterruptedException {
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

	@When("User click on the edit button for CR")
	public void user_click_on_the_edit_button_for_CR() throws InterruptedException {
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

	@When("User move the stock to the Store for CR")
	public void user_move_the_stock_to_the_store_for_CR() {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebElement checkBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		j.executeScript("arguments[0].click();", checkBox);

		WebElement btnMoveToStore = driver.findElement(By.xpath("//button[contains (text(), 'Move to Store')]"));
		btnMoveToStore.click();
	}

	@Then("User click on the signout button for CR")
	public void user_click_on_the_signout_button_for_CR() throws InterruptedException {
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

	@Given("User enters the Camera Products Team Member {string} and {string} for CR")
	public void user_enters_the_camera_products_team_member_and_for_CR(String username, String password) {
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

	@When("User create the CR Request")
	public void user_create_the_CR_request() throws InterruptedException, IOException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebElement issueModule = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		issueModule.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement addBtn = driver.findElement(By.xpath("(//button[@title='Add' and @type='button'])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(addBtn));
		j.executeScript("arguments[0].click();", addBtn);
		Thread.sleep(2000);

		WebElement requestType = (driver.findElement(By.xpath("(.//div//select)[1]")));
		String request = getData("CR Master Fields", 1, 0);
		select(requestType).selectByVisibleText(request);
		Thread.sleep(500);

		WebElement wareHouse = (driver.findElement(By.xpath("(.//div//select)[3]")));
		String warehouse_string = getData("CR Master Fields", 1, 1);
		select(wareHouse).selectByVisibleText(warehouse_string);

		WebElement cost_center = (driver.findElement(By.xpath("(.//div//select)[5]")));
		String cost_center_string = getData("CR Master Fields", 1, 2);
		select(cost_center).selectByVisibleText(cost_center_string);

		WebElement product_code = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
		String product_code_string = getData("CR Master Fields", 1, 3);
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

		WebElement bomType = driver.findElement(By.xpath("//*[@id='multi']/div/div[2]/span"));
		j.executeScript("arguments[0].click();", bomType);
		Thread.sleep(500);

		WebElement bomcheckbox = driver.findElement(By.xpath("//div//p-multiselectitem[2]/li/div/div"));
		j.executeScript("arguments[0].click();", bomcheckbox);
		Thread.sleep(500);

		WebElement cancelBtn = driver.findElement(By.xpath("//*[@id='multi']/div/div[4]/div[1]/a/span"));
		j.executeScript("arguments[0].click();", cancelBtn);
		Thread.sleep(500);

		WebElement bom_rev_no = (driver.findElement(By.xpath("(.//div//select)[6]")));
		String bomrev_string = getData("CR Master Fields", 1, 6);
		select(bom_rev_no).selectByVisibleText(bomrev_string);
		Thread.sleep(500);

		WebElement productcode_output = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
		String productcode_output_string = getData("CR Master Fields", 1, 4);
		productcode_output.sendKeys(productcode_output_string);
		Thread.sleep(500);

		List<WebElement> productcode_output_list = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
		for (WebElement webElement : productcode_output_list) {
			String list = webElement.getText();
			if (list.contains(productcode_output_string)) {
				Thread.sleep(500);
				JavascriptExecutor k = (JavascriptExecutor) driver;
				k.executeScript("arguments[0].click();", webElement);
				System.out.println(webElement);
				break;
			}
			Thread.sleep(1000);
		}

		WebElement MR_qty = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
		String MR_qty_string = getData("CR Master Fields", 1, 7);
		Thread.sleep(500);
		MR_qty.sendKeys(MR_qty_string);

		WebElement typeof_rework = (driver.findElement(By.xpath("(.//div//select)[7]")));
		String typeof_rework_string = getData("CR Master Fields", 1, 13);
		select(typeof_rework).selectByVisibleText(typeof_rework_string);

		WebElement vendor_type = (driver.findElement(By.xpath("(.//div//select)[8]")));
		String vendor_type_string = getData("CR Master Fields", 1, 14);
		select(vendor_type).selectByVisibleText(vendor_type_string);
	}

	@When("User select the CR Requested status from the filter")
	public void user_select_the_CR_requested_status_from_the_filter() throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement issuesBtn = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(issuesBtn));
		j.executeScript("arguments[0].click();", issuesBtn);

		WebElement store = driver.findElement(By.xpath("//select[@name='requeststoreid']"));
		String store_string = getData("CR Master Fields", 1, 10);
		select(store).selectByVisibleText(store_string);

		WebElement requestType = driver.findElement(By.xpath("//select[@name='requesttypeid']"));
		String requestType_string = getData("CR Master Fields", 1, 11);
		select(requestType).selectByVisibleText(requestType_string);

		WebElement CRStatus = driver.findElement(By.xpath("//select[@name='crissuestatusid']"));
		String CRStatus_string = getData("CR Master Fields", 1, 12);
		select(CRStatus).selectByVisibleText(CRStatus_string);
		Thread.sleep(3000);
	}

	@When("User click on the Issue icon for Issue Module for CR")
	public void user_click_on_the_issue_icon_for_issue_module_for_CR() throws InterruptedException {
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

	@When("User select the CR Issued status from the filter for CR")
	public void user_select_the_CR_issued_status_from_the_filter_for_CR() throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement issuesBtn = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(issuesBtn));
		j.executeScript("arguments[0].click();", issuesBtn);

		WebElement store = driver.findElement(By.xpath("//select[@name='requeststoreid']"));
		String store_string = getData("CR Master Fields", 2, 10);
		select(store).selectByVisibleText(store_string);

		WebElement requestType = driver.findElement(By.xpath("//select[@name='requesttypeid']"));
		String requestType_string = getData("CR Master Fields", 2, 11);
		select(requestType).selectByVisibleText(requestType_string);

		WebElement CRStatus = driver.findElement(By.xpath("//select[@name='crissuestatusid']"));
		String CRStatus_string = getData("CR Master Fields", 2, 12);
		select(CRStatus).selectByVisibleText(CRStatus_string);
		Thread.sleep(3000);
	}

	@Then("User verifies the CR Status has been changed to Issued and Signout for CR")
	public void user_verifies_the_CR_status_has_been_changed_to_issued_and_signout_for_CR()
			throws InterruptedException {
		WebElement successfully_Issued = driver
				.findElement(By.xpath("//app-wstable//div[@class='ws-table-head']//table[@role='grid']//tbody//tr[1]"));
		System.out.println("Successfull CR Issued : " + successfully_Issued.getText());
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

	@When("User enter the Partially Issued Qty for CR")
	public void user_enter_the_partially_issued_qty_for_CR() throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebElement fifo_checkbox = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l14 r14')]"));
		j.executeScript("arguments[0].click();", fifo_checkbox);
		WebElement fifo_checkbox1 = driver
				.findElement(By.xpath(".//div[contains (@class, 'slick-cell l14 r14')]//input"));
		j.executeScript("arguments[0].click();", fifo_checkbox1);
		Thread.sleep(300);

		WebElement partiallyIssueQty = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", partiallyIssueQty);
		WebElement partiallyIssueQty1 = driver
				.findElement(By.xpath(".//div[contains (@class, 'slick-cell l13 r13')]//input"));
		String partiallyIssueQty_string = getData("CR Master Fields", 1, 17);
		partiallyIssueQty1.sendKeys(partiallyIssueQty_string);
	}

	@When("User select the Partialy Issued status from the filter for CR")
	public void user_select_the_partialy_issued_status_from_the_filter_for_CR()
			throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement issuesBtn = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(issuesBtn));
		j.executeScript("arguments[0].click();", issuesBtn);

		WebElement store = driver.findElement(By.xpath("//select[@name='requeststoreid']"));
		String store_string = getData("CR Master Fields", 3, 10);
		select(store).selectByVisibleText(store_string);

		WebElement requestType = driver.findElement(By.xpath("//select[@name='requesttypeid']"));
		String requestType_string = getData("CR Master Fields", 3, 11);
		select(requestType).selectByVisibleText(requestType_string);

		WebElement CRStatus = driver.findElement(By.xpath("//select[@name='crissuestatusid']"));
		String CRStatus_string = getData("CR Master Fields", 3, 12);
		select(CRStatus).selectByVisibleText(CRStatus_string);
		Thread.sleep(3000);
	}

	@When("User click on the Dispatch icon for Issue Module for CR")
	public void user_click_on_the_dispatch_icon_for_issue_module_for_cr() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement issuesBtn = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(issuesBtn));
		j.executeScript("arguments[0].click();", issuesBtn);
		Thread.sleep(1000);

		int maxretries = 3;
		for (int i = 0; i < maxretries; i++) {
			try {
				WebElement dispatchIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(
						(By.xpath("(//table[@role='grid']//tbody//tr[1]//th//button[3]//i)[1]"))));
				j.executeScript("arguments[0].click();", dispatchIcon);
				break;
			} catch (StaleElementReferenceException | NoSuchElementException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		Thread.sleep(3000);
	}

	@When("User enters the Completed Qty for CR")
	public void user_enters_the_completed_qty_for_cr() throws IOException, InterruptedException {
		WebElement completed_Qty = driver.findElement(By.xpath("(//div//app-form-text//div//input [@type='text'])[2]"));
		String completedQty_string = getData("CR Master Fields", 1, 8);
		completed_Qty.sendKeys(completedQty_string);
		Thread.sleep(1000);
	}

	@When("User select the CR Production Completed status from the filter")
	public void user_select_the_cr_production_completed_status_from_the_filter()
			throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement issuesBtn = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(issuesBtn));
		j.executeScript("arguments[0].click();", issuesBtn);

		WebElement store = driver.findElement(By.xpath("//select[@name='requeststoreid']"));
		String store_string = getData("CR Master Fields", 4, 10);
		select(store).selectByVisibleText(store_string);

		WebElement requestType = driver.findElement(By.xpath("//select[@name='requesttypeid']"));
		String requestType_string = getData("CR Master Fields", 4, 11);
		select(requestType).selectByVisibleText(requestType_string);

		WebElement CRStatus = driver.findElement(By.xpath("//select[@name='crissuestatusid']"));
		String CRStatus_string = getData("CR Master Fields", 4, 12);
		select(CRStatus).selectByVisibleText(CRStatus_string);
		Thread.sleep(3000);
	}

	@When("User enter the Received Qty and Item Location for CR")
	public void user_enter_the_received_qty_and_item_location_for_cr() throws IOException {
		WebElement received_Qty = driver.findElement(By.xpath("(//div//app-form-text//div//input [@type='text'])[3]"));
		String receivedQty_string = getData("CR Master Fields", 1, 9);
		received_Qty.sendKeys(receivedQty_string);

		WebElement item_Location = driver.findElement(By.xpath("(//div//app-form-text//div//input [@type='text'])[4]"));
		item_Location.sendKeys("Unit 35 & 36");
	}

	@When("User select the CR Received status from the filter for CR")
	public void user_select_the_cr_received_status_from_the_filter_for_cr() throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement issuesBtn = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(issuesBtn));
		j.executeScript("arguments[0].click();", issuesBtn);

		WebElement store = driver.findElement(By.xpath("//select[@name='requeststoreid']"));
		String store_string = getData("CR Master Fields", 5, 10);
		select(store).selectByVisibleText(store_string);

		WebElement requestType = driver.findElement(By.xpath("//select[@name='requesttypeid']"));
		String requestType_string = getData("CR Master Fields", 5, 11);
		select(requestType).selectByVisibleText(requestType_string);

		WebElement CRStatus = driver.findElement(By.xpath("//select[@name='crissuestatusid']"));
		String CRStatus_string = getData("CR Master Fields", 5, 12);
		select(CRStatus).selectByVisibleText(CRStatus_string);
		Thread.sleep(3000);
	}

	@Then("User verifies the CR Status has been changed to Received and Signout for CR")
	public void user_verifies_the_cr_status_has_been_changed_to_received_and_signout_for_cr()
			throws InterruptedException {
		WebElement successfully_received = driver
				.findElement(By.xpath("//app-wstable//div[@class='ws-table-head']//table[@role='grid']//tbody//tr[1]"));
		System.out.println("Successfull CR Issued : " + successfully_received.getText());
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

	@When("User enters the Partially Completed Qty for CR")
	public void user_enters_the_partially_completed_qty_for_cr() throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement partially_completed_Qty = driver
				.findElement(By.xpath("(//div//app-form-text//div//input [@type='text'])[2]"));
		String partially_completedQty_string = getData("CR Master Fields", 1, 15);

		int maxretries = 3;
		for (int i = 0; i < maxretries; i++) {
			try {
				partially_completed_Qty = driver
						.findElement(By.xpath("(//div//app-form-text//div//input [@type='text'])[2]"));
				Thread.sleep(500);
				partially_completed_Qty.sendKeys(partially_completedQty_string);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
	}

	@When("User select the CR Partially Production Completed status from the filter")
	public void user_select_the_cr_partially_production_completed_status_from_the_filter()
			throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement issuesBtn = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(issuesBtn));
		j.executeScript("arguments[0].click();", issuesBtn);

		WebElement store = driver.findElement(By.xpath("//select[@name='requeststoreid']"));
		String store_string = getData("CR Master Fields", 6, 10);
		select(store).selectByVisibleText(store_string);

		WebElement requestType = driver.findElement(By.xpath("//select[@name='requesttypeid']"));
		String requestType_string = getData("CR Master Fields", 6, 11);
		select(requestType).selectByVisibleText(requestType_string);

		WebElement CRStatus = driver.findElement(By.xpath("//select[@name='crissuestatusid']"));
		String CRStatus_string = getData("CR Master Fields", 6, 12);
		select(CRStatus).selectByVisibleText(CRStatus_string);
		Thread.sleep(3000);
	}

	@When("User enter the Partially Production Completed Received Qty and Item Location for CR")
	public void user_enter_the_partially_production_completed_received_qty_and_item_location_for_cr()
			throws IOException {
		WebElement received_Qty = driver.findElement(By.xpath("(//div//app-form-text//div//input [@type='text'])[3]"));
		String receivedQty_string = getData("CR Master Fields", 1, 16);
		received_Qty.sendKeys(receivedQty_string);

		WebElement item_Location = driver.findElement(By.xpath("(//div//app-form-text//div//input [@type='text'])[4]"));
		item_Location.sendKeys("Unit 35 & 36");
	}

	@Then("User verifies the CR Status has been Remain the same as Partially Production Completed Status and Signout for CR")
	public void user_verifies_the_cr_status_has_been_remain_the_same_as_partially_production_completed_status_and_signout_for_cr()
			throws InterruptedException {
		WebElement partially_production_completed = driver
				.findElement(By.xpath("//app-wstable//div[@class='ws-table-head']//table[@role='grid']//tbody//tr[1]"));
		System.out.println("Partially Production Completed : " + partially_production_completed.getText());
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
		Thread.sleep(1000);
	}

	@When("User enters the Balance Completed Qty for CR")
	public void user_enters_the_balance_completed_qty_for_cr() throws IOException {
		WebElement balance_completed_Qty = driver
				.findElement(By.xpath("(//div//app-form-text//div//input [@type='text'])[3]"));
		String completedQty_string = getData("CR Master Fields", 1, 17);

		int maxretries = 3;
		for (int i = 0; i < maxretries; i++) {
			try {
				balance_completed_Qty = driver
						.findElement(By.xpath("(//div//app-form-text//div//input [@type='text'])[3]"));
				balance_completed_Qty.sendKeys(completedQty_string);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
	}

	@When("User enter the Partially Received Qty and Item Location for CR")
	public void user_enter_the_partially_received_qty_and_item_location_for_cr() throws IOException {
		WebElement partially_received_Qty = driver
				.findElement(By.xpath("(//div//app-form-text//div//input [@type='text'])[4]"));
		String receivedQty_string = getData("CR Master Fields", 1, 18);
		partially_received_Qty.sendKeys(receivedQty_string);

		WebElement item_Location = driver.findElement(By.xpath("(//div//app-form-text//div//input [@type='text'])[5]"));
		item_Location.sendKeys("Unit 35 & 36");
	}

	@When("User select the CR Partially Received status from the filter")
	public void user_select_the_cr_partially_received_status_from_the_filter()
			throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement issuesBtn = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(issuesBtn));
		j.executeScript("arguments[0].click();", issuesBtn);

		WebElement store = driver.findElement(By.xpath("//select[@name='requeststoreid']"));
		String store_string = getData("CR Master Fields", 7, 10);
		select(store).selectByVisibleText(store_string);

		WebElement requestType = driver.findElement(By.xpath("//select[@name='requesttypeid']"));
		String requestType_string = getData("CR Master Fields", 7, 11);
		select(requestType).selectByVisibleText(requestType_string);

		WebElement CRStatus = driver.findElement(By.xpath("//select[@name='crissuestatusid']"));
		String CRStatus_string = getData("CR Master Fields", 7, 12);
		select(CRStatus).selectByVisibleText(CRStatus_string);
		Thread.sleep(3000);
	}

	@When("User enter the Balance Received Qty and Item Location for CR")
	public void user_enter_the_balance_received_qty_and_item_location_for_cr() throws IOException {
		WebElement balance_received_Qty = driver
				.findElement(By.xpath("(//div//app-form-text//div//input [@type='text'])[4]"));
		String receivedQty_string = getData("CR Master Fields", 1, 19);
		balance_received_Qty.sendKeys(receivedQty_string);

		WebElement item_Location = driver.findElement(By.xpath("(//div//app-form-text//div//input [@type='text'])[5]"));
		item_Location.sendKeys("Unit 35 & 36");
	}

	@When("User create the CR Request with Elimination")
	public void user_create_the_cr_request_with_elimination() throws InterruptedException, IOException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebElement issueModule = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		issueModule.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement addBtn = driver.findElement(By.xpath("(//button[@title='Add' and @type='button'])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(addBtn));
		j.executeScript("arguments[0].click();", addBtn);
		Thread.sleep(2000);

		WebElement requestType = (driver.findElement(By.xpath("(.//div//select)[1]")));
		String request = getData("CR Master Fields", 1, 0);
		select(requestType).selectByVisibleText(request);
		Thread.sleep(500);

		WebElement wareHouse = (driver.findElement(By.xpath("(.//div//select)[3]")));
		String warehouse_string = getData("CR Master Fields", 1, 1);
		select(wareHouse).selectByVisibleText(warehouse_string);

		WebElement cost_center = (driver.findElement(By.xpath("(.//div//select)[5]")));
		String cost_center_string = getData("CR Master Fields", 1, 2);
		select(cost_center).selectByVisibleText(cost_center_string);

		WebElement product_code = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
		String product_code_string = getData("CR Master Fields", 1, 3);
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

		WebElement bomType = driver.findElement(By.xpath("//*[@id='multi']/div/div[2]/span"));
		j.executeScript("arguments[0].click();", bomType);
		Thread.sleep(500);

		WebElement bomcheckbox = driver.findElement(By.xpath("//div//p-multiselectitem[2]/li/div/div"));
		j.executeScript("arguments[0].click();", bomcheckbox);
		Thread.sleep(500);

		WebElement cancelBtn = driver.findElement(By.xpath("//*[@id='multi']/div/div[4]/div[1]/a/span"));
		j.executeScript("arguments[0].click();", cancelBtn);
		Thread.sleep(500);

		WebElement bom_rev_no = (driver.findElement(By.xpath("(.//div//select)[6]")));
		String bomrev_string = getData("CR Master Fields", 1, 6);
		select(bom_rev_no).selectByVisibleText(bomrev_string);
		Thread.sleep(500);

		WebElement productcode_output = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
		String productcode_output_string = getData("CR Master Fields", 1, 4);
		productcode_output.sendKeys(productcode_output_string);
		Thread.sleep(500);

		List<WebElement> productcode_output_list = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
		for (WebElement webElement : productcode_output_list) {
			String list = webElement.getText();
			if (list.contains(productcode_output_string)) {
				Thread.sleep(500);
				JavascriptExecutor k = (JavascriptExecutor) driver;
				k.executeScript("arguments[0].click();", webElement);
				System.out.println(webElement);
				break;
			}
			Thread.sleep(1000);
		}

		WebElement MR_qty = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
		String MR_qty_string = getData("CR Master Fields", 1, 7);
		Thread.sleep(500);
		MR_qty.sendKeys(MR_qty_string);

		WebElement typeof_rework = (driver.findElement(By.xpath("(.//div//select)[7]")));
		String typeof_rework_string = getData("CR Master Fields", 1, 13);
		select(typeof_rework).selectByVisibleText(typeof_rework_string);

		WebElement vendor_type = (driver.findElement(By.xpath("(.//div//select)[8]")));
		String vendor_type_string = getData("CR Master Fields", 2, 14);
		select(vendor_type).selectByVisibleText(vendor_type_string);

		WebElement eliminate_btn = driver.findElement(By.xpath("(.//div//button [@ptooltip='Eliminate']//i)[1]"));
		j.executeScript("arguments[0].click();", eliminate_btn);

		WebElement dummy_click = driver.findElement(By.xpath("(.//div[contains (@class, 'slick-cell l3 r3')])[1]"));
		j.executeScript("arguments[0].click();", dummy_click);
		j.executeScript("arguments[0].click();", eliminate_btn);
	}

	@When("User enter the Cost Value for the Eliminated items")
	public void user_enter_the_cost_value_for_the_eliminated_items() throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

//1st Line
//		WebElement INR_cost = driver
//				.findElement(By.xpath("(.//div[@style='top:0px']//div[contains (@class, 'slick-cell l9 r9')])[3]"));
//		j.executeScript("window.scrollIntoView", INR_cost);
//		j.executeScript("arguments[0].click();", INR_cost);
//		Thread.sleep(300);
//		WebElement INR_value = driver.findElement(
//				By.xpath("(.//div[@style='top:0px']//div[contains (@class, 'slick-cell l9 r9')])[3]//input"));
//		j.executeScript("arguments[0].click();", INR_value);
//		String INR_value_string = getData("CR Master Fields", 1, 20);
		int maxretries = 3;
//		for (int i = 0; i < maxretries; i++) {
//			try {
//				INR_value = driver.findElement(
//						By.xpath("(.//div[@style='top:0px']//div[contains (@class, 'slick-cell l9 r9')])[3]//input"));
//				INR_value.sendKeys(INR_value_string);
//				break;
//			} catch (StaleElementReferenceException e) {
//				System.out.println("Maximum Retry Failed");
//			}
//		}
//		Thread.sleep(300);

		WebElement USD_cost = driver
				.findElement(By.xpath("(.//div[@style='top:0px']//div[contains (@class, 'slick-cell l10 r10')])[3]"));
		j.executeScript("arguments[0].click();", USD_cost);
		WebElement USD_value = driver.findElement(
				By.xpath("(.//div[@style='top:0px']//div[contains (@class, 'slick-cell l10 r10')])[3]//input"));
		j.executeScript("arguments[0].click();", USD_value);
		String USD_value_string = getData("CR Master Fields", 1, 21);
		for (int i = 0; i < maxretries; i++) {
			try {
				USD_value = driver.findElement(
						By.xpath("(.//div[@style='top:0px']//div[contains (@class, 'slick-cell l10 r10')])[3]//input"));
				USD_value.sendKeys(USD_value_string);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		Thread.sleep(300);

//2nd Line
//		WebElement INR_cost1 = driver
//				.findElement(By.xpath("(.//div[@style='top:25px']//div[contains (@class, 'slick-cell l9 r9')])[2]"));
//		j.executeScript("arguments[0].click();", INR_cost1);
//		WebElement INR_value1 = driver.findElement(
//				By.xpath("(.//div[@style='top:25px']//div[contains (@class, 'slick-cell l9 r9')])[2]//input"));
//		j.executeScript("arguments[0].click();", INR_value1);
//		String INR_value_string1 = getData("CR Master Fields", 2, 20);
//		for (int i = 0; i < maxretries; i++) {
//			try {
//				INR_value1 = driver.findElement(
//						By.xpath("(.//div[@style='top:25px']//div[contains (@class, 'slick-cell l9 r9')])[2]//input"));
//				INR_value1.sendKeys(INR_value_string1);
//				break;
//			} catch (StaleElementReferenceException e) {
//				System.out.println("Maximum Retry Failed");
//			}
//		}
//		Thread.sleep(300);

		WebElement USD_cost1 = driver
				.findElement(By.xpath("(.//div[@style='top:25px']//div[contains (@class, 'slick-cell l10 r10')])[2]"));
		j.executeScript("arguments[0].click();", USD_cost1);
		WebElement USD_value1 = driver.findElement(
				By.xpath("(.//div[@style='top:25px']//div[contains (@class, 'slick-cell l10 r10')])[2]//input"));
		j.executeScript("arguments[0].click();", USD_value1);
		String USD_value_string1 = getData("CR Master Fields", 2, 21);

		for (int i = 0; i < maxretries; i++) {
			try {
				USD_value1 = driver.findElement(By
						.xpath("(.//div[@style='top:25px']//div[contains (@class, 'slick-cell l10 r10')])[2]//input"));
				USD_value1.sendKeys(USD_value_string1);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
	}

	@When("User enter the Received Qty with Eliminated Items and Item Location for CR")
	public void user_enter_the_received_qty_with_eliminated_items_and_item_location_for_cr()
			throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebElement received_Qty = driver.findElement(By.xpath("(//div//app-form-text//div//input [@type='text'])[3]"));
		String receivedQty_string = getData("CR Master Fields", 1, 9);
		received_Qty.sendKeys(receivedQty_string);

		WebElement item_Location = driver.findElement(By.xpath("(//div//app-form-text//div//input [@type='text'])[4]"));
		item_Location.sendKeys("Unit 35 & 36");

//1st Line
		WebElement TBR_qty = driver
				.findElement(By.xpath("(.//div[@style='top:0px']//div[contains (@class, 'slick-cell l11 r11')])[3]"));
		j.executeScript("window.scrollIntoView", TBR_qty);
		j.executeScript("arguments[0].click();", TBR_qty);
		Thread.sleep(300);
		WebElement TBR_qty1 = driver.findElement(
				By.xpath("(.//div[@style='top:0px']//div[contains (@class, 'slick-cell l11 r11')])[3]//input"));
		j.executeScript("arguments[0].click();", TBR_qty1);
		String TBR_qty_string = getData("CR Master Fields", 1, 9);
		int maxretries = 3;
		for (int i = 0; i < maxretries; i++) {
			try {
				TBR_qty1 = driver.findElement(
						By.xpath("(.//div[@style='top:0px']//div[contains (@class, 'slick-cell l11 r11')])[3]//input"));
				TBR_qty1.sendKeys(TBR_qty_string);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		Thread.sleep(300);

//2nd Line
		WebElement TBR_qty2 = driver
				.findElement(By.xpath("(.//div[@style='top:25px']//div[contains (@class, 'slick-cell l11 r11')])[3]"));
		j.executeScript("arguments[0].click();", TBR_qty2);
		Thread.sleep(300);
		WebElement TBR_qty3 = driver.findElement(
				By.xpath("(.//div[@style='top:25px']//div[contains (@class, 'slick-cell l11 r11')])[3]//input"));
		j.executeScript("arguments[0].click();", TBR_qty3);
		String TBR_qty_string1 = getData("CR Master Fields", 1, 9);
		for (int i = 0; i < maxretries; i++) {
			try {
				TBR_qty3 = driver.findElement(
						By.xpath("(.//div[@style='top:25px']//div[contains (@class, 'slick-cell l11 r11')])[3]//input"));
				TBR_qty3.sendKeys(TBR_qty_string1);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		Thread.sleep(300);
	}
	
	@When("User create the CR Request without Output Product Code")
	public void user_create_the_cr_request_without_output_product_code() throws InterruptedException, IOException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebElement issueModule = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		issueModule.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement addBtn = driver.findElement(By.xpath("(//button[@title='Add' and @type='button'])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(addBtn));
		j.executeScript("arguments[0].click();", addBtn);
		Thread.sleep(2000);

		WebElement requestType = (driver.findElement(By.xpath("(.//div//select)[1]")));
		String request = getData("CR Master Fields", 1, 0);
		select(requestType).selectByVisibleText(request);
		Thread.sleep(500);

		WebElement wareHouse = (driver.findElement(By.xpath("(.//div//select)[3]")));
		String warehouse_string = getData("CR Master Fields", 1, 1);
		select(wareHouse).selectByVisibleText(warehouse_string);

		WebElement cost_center = (driver.findElement(By.xpath("(.//div//select)[5]")));
		String cost_center_string = getData("CR Master Fields", 1, 2);
		select(cost_center).selectByVisibleText(cost_center_string);

		WebElement product_code = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
		String product_code_string = getData("CR Master Fields", 1, 3);
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

		WebElement bomType = driver.findElement(By.xpath("//*[@id='multi']/div/div[2]/span"));
		j.executeScript("arguments[0].click();", bomType);
		Thread.sleep(500);

		WebElement bomcheckbox = driver.findElement(By.xpath("//div//p-multiselectitem[2]/li/div/div"));
		j.executeScript("arguments[0].click();", bomcheckbox);
		Thread.sleep(500);

		WebElement cancelBtn = driver.findElement(By.xpath("//*[@id='multi']/div/div[4]/div[1]/a/span"));
		j.executeScript("arguments[0].click();", cancelBtn);
		Thread.sleep(500);

		WebElement bom_rev_no = (driver.findElement(By.xpath("(.//div//select)[6]")));
		String bomrev_string = getData("CR Master Fields", 1, 6);
		select(bom_rev_no).selectByVisibleText(bomrev_string);
		Thread.sleep(500);

		WebElement MR_qty = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
		String MR_qty_string = getData("CR Master Fields", 1, 7);
		Thread.sleep(500);
		MR_qty.sendKeys(MR_qty_string);

		WebElement typeof_rework = (driver.findElement(By.xpath("(.//div//select)[7]")));
		String typeof_rework_string = getData("CR Master Fields", 1, 13);
		select(typeof_rework).selectByVisibleText(typeof_rework_string);

		WebElement vendor_type = (driver.findElement(By.xpath("(.//div//select)[8]")));
		String vendor_type_string = getData("CR Master Fields", 2, 14);
		select(vendor_type).selectByVisibleText(vendor_type_string);
		
		WebElement delete_btn = driver.findElement(By.xpath("(//app-form-grid)[2]//button[@ptooltip='Delete']"));
		j.executeScript("arguments[0].click();", delete_btn);
	}
	
	@When("User select the WIP status from the product category filter")
	public void user_select_the_wip_status_from_the_product_category_filter() throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebElement issueModule = driver.findElement(By.xpath("//a[contains(text(),'Stock')]"));
		issueModule.click();
		Thread.sleep(500);
		
		WebElement store = driver.findElement(By.xpath("(//select[@name='materialtype'])[1]"));
		String store_string = getData("CR Master Fields", 1, 23);
		select(store).selectByVisibleText(store_string);
		
		WebElement stock_category = driver.findElement(By.xpath("//select[@name='st_catergory']"));
		String stock_category_string = getData("CR Master Fields", 1, 24);
		select(stock_category).selectByVisibleText(stock_category_string);
		Thread.sleep(500);
		
		WebElement WIP_Type = driver.findElement(By.xpath("//select[@name='stock']"));
		String WIP_Type_string = getData("CR Master Fields", 1, 25);
		select(WIP_Type).selectByVisibleText(WIP_Type_string);
		Thread.sleep(500);
	}
	
	@When("User verifies the expected results in the dashboard")
	public void user_verifies_the_expected_results_in_the_dashboard() throws InterruptedException {
		WebElement dashboard_productcode = driver.findElement(By.xpath("//app-wstable//div//table//tbody//tr[1]/td[1][contains (text(), 'Product disassemble')]"));
		String text = dashboard_productcode.getText().trim();
		assertEquals("Product disassemble", text);
		System.out.println(text);
		Thread.sleep(500);
	}

}
