package ecERP.ISSUE;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
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

public class REP_FA_StepDefinition extends LibGlobal {

	public static WebDriver driver;
	public String popup1;
	public int lastAppearedIndex;

	@Given("User on the login page for FA")
	public void user_on_the_login_page_for_fa() {
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

	@Given("User enters the SCM Team Member {string} and {string} for FA")
	public void user_enters_the_scm_team_member_and_for_fa(String username, String password) {
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

	@When("User create the PO Request for PO ORDER \\(RM-Domestic) for FA")
	public void user_create_the_po_request_for_po_order_rm_domestic_for_fa() throws InterruptedException, IOException {
		WebElement purchaseOrderBtn = driver.findElement(By.xpath("(//a[contains(text(),'Purchase Order')])[1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(purchaseOrderBtn,
				By.xpath("(//a[contains(text(),'Purchase Order')])[1]")));
		purchaseOrderBtn.click();

		WebElement addBtn = driver.findElement(By.xpath("(//button[@title='Add' and @type='button'])[1]"));
		addBtn.click();
		Thread.sleep(1000);

		WebElement branch = (driver.findElement(By.xpath("(//select)[1]")));
		String mas_data = getData("MRI Master Fields", 11, 0);
		select(branch).selectByVisibleText(mas_data);
		Thread.sleep(500);

		WebElement wareHouse = (driver.findElement(By.xpath("(//select)[2]")));
		String mas_data1 = getData("MRI Master Fields", 11, 1);
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
		String mas_data2 = getData("MRI Master Fields", 11, 3);
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
		String mas_data3 = getData("MRI Master Fields", 11, 4);
		selectOptionByText(orderType, mas_data3);

		WebElement materialType = driver.findElement(By.xpath("(//select)[6]"));
		String mas_data4 = getData("MRI Master Fields", 11, 5);
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

	@When("User click on the save button for FA")
	public void user_click_on_the_save_button_for_fa() throws InterruptedException {
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

	@When("User click on the Edit button for FA")
	public void user_click_on_the_Edit_button_for_fa() {
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

	@When("User verify the PO and providing Pre-Approval for FA")
	public void user_verify_the_po_and_providing_pre_approval_for_fa() throws InterruptedException {
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

	@When("User click on the Save button for FA")
	public void user_click_on_the_Save_button_for_fa() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		WebElement saveButton = driver.findElement(By.xpath("(//button[@id='submitbutton' and @type='submit'])"));
		j.executeScript("arguments[0].scrollIntoView(true);", saveButton);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));

		if (saveButton.isEnabled()) {
			j.executeScript("arguments[0].click();", saveButton);
			System.out.println("Save Button Enabled");
		} else {
			System.out.println("Save Button Disabled");
			driver.quit();
		}
		Thread.sleep(2000);
	}

	@Then("User verifies the PO Status has been changed and Signout for FA")
	public void user_verifies_the_po_status_has_been_changed_and_signout_for_fa() throws InterruptedException {
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
		js.executeScript("arguments[0].click();", signOutBtn);
		driver.quit();
	}

	@Given("User enters the Operations Head {string} and {string} for FA")
	public void user_enters_the_operations_head_and_for_fa(String username, String password) {
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

	@Given("User verify the PO and providing Final-Approval for FA")
	public void user_verify_the_po_and_providing_final_approval_for_fa() throws InterruptedException {
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

	@Given("User click on the Issue icon for FA")
	public void user_click_on_the_issue_icon_for_fa() throws InterruptedException {
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

	@When("User click on the Issue button for FA")
	public void user_click_on_the_issue_button_for_fa() throws InterruptedException {
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

	@Then("User verifies the PO Status has been changed to Issued and Signout for FA")
	public void user_verifies_the_po_status_has_been_changed_to_issued_and_signout_for_fa()
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

	@Given("User enters the Store Team Member {string} and {string} for FA")
	public void user_enters_the_store_team_member_and_for_fa(String username, String password) {
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

	@When("User create the GRN Request for Fully Received - \\(PO Order - RM - Domestic) for FA")
	public void user_create_the_grn_request_for_fully_received_po_order_rm_domestic_for_fa()
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
		String mas_data = getData("MRI Master Fields", 11, 0);
		select(branch).selectByVisibleText(mas_data);
		Thread.sleep(300);

		WebElement store = (driver
				.findElement(By.xpath("//*[@id='collapseOne']/div/div[2]/app-form-dyna-select/div/select")));
		String mas_data1 = getData("MRI Master Fields", 11, 2);
		select(store).selectByVisibleText(mas_data1);
		Thread.sleep(300);

		WebElement orderType = (driver
				.findElement(By.xpath("//*[@id='collapseOne']/div/div[3]/app-form-dyna-select/div/select")));
		String mas_data2 = getData("MRI Master Fields", 11, 4);
		select(orderType).selectByVisibleText(mas_data2);
		Thread.sleep(300);

		WebElement materialType = (driver
				.findElement(By.xpath("//*[@id='collapseOne']/div/div[4]/app-form-dyna-select/div/select")));
		String mas_data3 = getData("MRI Master Fields", 11, 5);
		select(materialType).selectByVisibleText(mas_data3);
		Thread.sleep(300);

		WebElement vendorField = driver.findElement(By.xpath("(//input[@type='text' and @role='combobox'])[1]"));
		String vendorField_string = getData("MRI Master Fields", 11, 3);
		vendorField.sendKeys(vendorField_string);
		Thread.sleep(400);

		List<WebElement> vendorList = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
		for (WebElement webElement : vendorList) {
			String list = webElement.getText();
			if (list.contains(vendorField_string)) {
				Thread.sleep(500);
				j.executeScript("arguments[0].click();", webElement);
				System.out.println(vendorField_string);
				break;
			}
			Thread.sleep(1000);
		}

		WebElement multiPO = driver
				.findElement(By.xpath("//*[@id='collapseOne']/div/div[6]/app-form-dyna-select/div/select"));
		select(multiPO);
		int lastIndex = getOptions(multiPO).size()-1;
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
			gateEntryNo.sendKeys("4292");

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
			gateEntryNo.sendKeys("4292");

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

	@When("User select the Fully Received status from the filter - \\(PO Order - RM - Domestic) for FA")
	public void user_select_the_fully_received_status_from_the_filter_po_order_rm_domestic_for_fa()
			throws InterruptedException {
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

	@When("User click on the edit button for FA")
	public void user_click_on_the_edit_button_for_fa() throws InterruptedException {
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

	@When("User move the stock to the Store for FA")
	public void user_move_the_stock_to_the_store_for_fa() {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebElement checkBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		j.executeScript("arguments[0].click();", checkBox);

		WebElement btnMoveToStore = driver.findElement(By.xpath("//button[contains (text(), 'Move to Store')]"));
		btnMoveToStore.click();
	}

	@Then("User click on the signout button for FA")
	public void user_click_on_the_signout_button_for_fa() throws InterruptedException {
		WebElement profileClick = driver.findElement(By.xpath("(//app-header//div//div//span[@class = 'd-block'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,0);", profileClick);
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", profileClick);
		WebElement signOutBtn = driver.findElement(
				By.xpath("//h3[contains (@class, 'dropdown-item-title') and contains (text(), 'Sign out ')][1]"));
		js.executeScript("arguments[0].click();", signOutBtn);
		driver.quit();
	}

	@Given("User enters the PM Team Member {string} and {string} for FA")
	public void user_enters_the_pm_team_member_and_for_fa(String username, String password) {
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

	@When("User create the MRI Request for FA")
	public void user_create_the_mri_request_for_fa() throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebElement issueModule = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		issueModule.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement addBtn = driver.findElement(By.xpath("(//button[@title='Add' and @type='button'])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(addBtn));
		j.executeScript("arguments[0].click();", addBtn);
		Thread.sleep(2000);

		WebElement requestType = (driver.findElement(By.xpath("(.//div//select)[1]")));
		String request = getData("MRI Master Fields", 1, 0);
		select(requestType).selectByVisibleText(request);
		Thread.sleep(500);

		WebElement wareHouse = (driver.findElement(By.xpath("(.//div//select)[3]")));
		String warehouse_string = getData("MRI Master Fields", 1, 1);
		select(wareHouse).selectByVisibleText(warehouse_string);

		WebElement costCenter = (driver.findElement(By.xpath("(.//div//select)[5]")));
		String costcenter_string = getData("MRI Master Fields", 1, 2);
		select(costCenter).selectByVisibleText(costcenter_string);

		WebElement product_code_input = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		String product_input = getData("MRI Master Fields", 1, 3);
		product_code_input.sendKeys(product_input);
		Thread.sleep(500);

		List<WebElement> product_code_inputlist = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
		for (WebElement webElement : product_code_inputlist) {
			String list = webElement.getText();
			if (list.contains("See3CAM_CU135_CH_TC")) {
				Thread.sleep(500);
				JavascriptExecutor k = (JavascriptExecutor) driver;
				k.executeScript("arguments[0].click();", webElement);
				System.out.println(webElement);
				break;
			}
			Thread.sleep(1000);
		}

		WebElement product_code_output = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
		String product_output = getData("MRI Master Fields", 1, 4);
		product_code_output.sendKeys(product_output);
		Thread.sleep(500);

		List<WebElement> product_code_outputlist = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
		for (WebElement webElement : product_code_outputlist) {
			String list = webElement.getText();
			if (list.contains("ACC-IMX53-GRYPHIA-CUMI1335-ADP")) {
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

		WebElement bomcheckbox = driver.findElement(By.xpath("//div//p-multiselectitem[2]/li/div/div"));
		j.executeScript("arguments[0].click();", bomcheckbox);

		WebElement bom_rev_no = (driver.findElement(By.xpath("(.//div//select)[6]")));
		String bomrev_string = getData("MRI Master Fields", 1, 6);
		select(bom_rev_no).selectByVisibleText(bomrev_string);

		WebElement MR_Qty = driver.findElement(By.xpath("(//div//app-form-text//div//input [@type='text'])[1]"));
		String MRQty_string = getData("MRI Master Fields", 1, 7);
		MR_Qty.sendKeys(MRQty_string);
		Thread.sleep(3000);
	}

	@When("User select the MRI Requested status from the filter for FA")
	public void user_select_the_mri_requested_status_from_the_filter_for_fa() throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement issuesBtn = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(issuesBtn));
		j.executeScript("arguments[0].click();", issuesBtn);

		WebElement store = driver.findElement(By.xpath("//select[@name='requeststoreid']"));
		String store_string = getData("MRI Master Fields", 1, 10);
		select(store).selectByVisibleText(store_string);

		WebElement requestType = driver.findElement(By.xpath("//select[@name='requesttypeid']"));
		String requestType_string = getData("MRI Master Fields", 1, 11);
		select(requestType).selectByVisibleText(requestType_string);

		WebElement MRIStatus = driver.findElement(By.xpath("//select[@name='mriissuestatusid']"));
		String MRIStatus_string = getData("MRI Master Fields", 1, 12);
		select(MRIStatus).selectByVisibleText(MRIStatus_string);
		Thread.sleep(3000);
	}

	@When("User click on the Issue icon for Issue Module for FA")
	public void user_click_on_the_issue_icon_for_issue_module_for_fa() throws InterruptedException {
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

	@Given("User enters the Production Team Member {string} and {string} for FA")
	public void user_enters_the_production_team_member_and_for_fa(String username, String password) {
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

	@When("User click on the Dispatch icon for Issue Module for FA")
	public void user_click_on_the_dispatch_icon_for_issue_module_for_fa() throws InterruptedException {
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

	@When("User select the MRI Issued status from the filter for FA")
	public void user_select_the_mri_issued_status_from_the_filter_for_fa() throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement issuesBtn = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(issuesBtn));
		j.executeScript("arguments[0].click();", issuesBtn);

		WebElement store = driver.findElement(By.xpath("//select[@name='requeststoreid']"));
		String store_string = getData("MRI Master Fields", 2, 10);
		select(store).selectByVisibleText(store_string);

		WebElement requestType = driver.findElement(By.xpath("//select[@name='requesttypeid']"));
		String requestType_string = getData("MRI Master Fields", 2, 11);
		select(requestType).selectByVisibleText(requestType_string);

		WebElement MRIStatus = driver.findElement(By.xpath("//select[@name='mriissuestatusid']"));
		String MRIStatus_string = getData("MRI Master Fields", 2, 12);
		select(MRIStatus).selectByVisibleText(MRIStatus_string);
		Thread.sleep(3000);
	}

	@When("User click on the edit button for Issue Module for FA")
	public void user_click_on_the_edit_button_for_issue_module_for_fa() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement editBtn = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@role='grid']//tbody//tr[1]//th//button[1]//i")));
		wait.until(ExpectedConditions.elementToBeClickable(editBtn));
//		WebElement editBtn = driver.findElement(By.xpath("//table[@role='grid']//tbody//tr[1]//th//button[1]//i"));
		j.executeScript("arguments[0].click();", editBtn);
		Thread.sleep(2000);
	}

	@When("User enters the Failure Qty for FA")
	public void user_enters_the_failure_qty_for_fa() throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebElement form_title = driver.findElement(By.xpath(".//div//div//h3[@class='card-title']"));
		String form_title_text = form_title.getText();

		if (form_title_text.contains("MRI - Edit")) {
//MRI
			int maxretries = 3;
			for (int i = 0; i < maxretries; i++) {
				try {
					WebElement failure_qty = driver
							.findElement(By.xpath("(.//div[contains (@class, 'slick-cell l10 r10')])[1]"));
					j.executeScript("arguments[0].click();", failure_qty);
				} catch (StaleElementReferenceException e) {
					System.out.println("Maximum Retry Failed");
				}
			}
			WebElement failure_qty1 = driver
					.findElement(By.xpath("(.//div[contains (@class, 'slick-cell l10 r10')])[1]//input"));
			String failure_qty_string = getData("REP_FA Master Fields", 1, 13);
			failure_qty1.sendKeys(failure_qty_string);
//MRD & CR
		} else {
			int maxretries = 3;
			for (int i = 0; i < maxretries; i++) {
				try {
					WebElement failure_qty = driver
							.findElement(By.xpath("(.//div[contains (@class, 'slick-cell l11 r11')])[1]"));
					j.executeScript("arguments[0].click();", failure_qty);
				} catch (StaleElementReferenceException e) {
					System.out.println("Maximum Retry Failed");
				}
			}
			WebElement failure_qty1 = driver
					.findElement(By.xpath("(.//div[contains (@class, 'slick-cell l11 r11')])[1]//input"));
			String failure_qty_string = getData("REP_FA Master Fields", 1, 13);
			failure_qty1.sendKeys(failure_qty_string);
		}
	}

	@When("User create the Replacement Request for FA")
	public void user_create_the_replacement_request_for_fa() throws InterruptedException, IOException {
		WebElement MRI_number = driver.findElement(By.xpath("(.//div//app-wstable//div//table//tbody//tr//td)[1]"));
		String MRI_number_text = MRI_number.getText();

		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement addBtn = driver.findElement(By.xpath("(//button[@title='Add' and @type='button'])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(addBtn));
		j.executeScript("arguments[0].click();", addBtn);
		Thread.sleep(2000);

		WebElement requestType = (driver.findElement(By.xpath("(.//div//select)[1]")));
		String request = getData("REP_FA Master Fields", 1, 0);
		select(requestType).selectByVisibleText(request);
		Thread.sleep(500);

		WebElement issue_ref_no = driver
				.findElement(By.xpath(".//div//app-form-autocomplete//input[@role='combobox']"));
		j.executeScript("arguments[0].click();", issue_ref_no);
		issue_ref_no.sendKeys(MRI_number_text);
		WebElement autoSuggestion = driver.findElement(By.xpath(".//div//app-form-autocomplete//ul//li[1]"));
		autoSuggestion.click();
	}

	@When("User select the FA Requested status from the filter for FA")
	public void user_select_the_fa_requested_status_from_the_filter_for_fa() throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement issuesBtn = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(issuesBtn));
		j.executeScript("arguments[0].click();", issuesBtn);

		WebElement store = driver.findElement(By.xpath("//select[@name='requeststoreid']"));
		String store_string = getData("REP_FA Master Fields", 1, 10);
		select(store).selectByVisibleText(store_string);

		WebElement requestType = driver.findElement(By.xpath("//select[@name='requesttypeid']"));
		String requestType_string = getData("REP_FA Master Fields", 1, 11);
		select(requestType).selectByVisibleText(requestType_string);

		WebElement FAStatus = driver.findElement(By.xpath("//select[@name='faissuestatusid']"));
		String FAStatus_string = getData("REP_FA Master Fields", 1, 12);
		select(FAStatus).selectByVisibleText(FAStatus_string);
		Thread.sleep(3000);
	}

	@When("User enters the Failure Reason and Unit Serial Number for FA")
	public void user_enters_the_failure_reason_and_unit_serial_number_for_fa()
			throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebElement issue_ref_no = driver
				.findElement(By.xpath("(.//div//app-form-autocomplete)[1]//div//input[@role='combobox']"));
		String issue_ref_no_text = issue_ref_no.getText();

		WebElement MRI_number = driver.findElement(By.xpath("(.//div//app-form-text)[7]//div//input[@type='text']"));
		String MRI_number_text = MRI_number.getText();

		assertEquals(issue_ref_no_text, MRI_number_text);

//1st Line
		WebElement failure_reason = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l9 r9')]"));
		j.executeScript("arguments[0].click();", failure_reason);
		WebElement failure_reason1 = driver.findElement(By.xpath("(.//div//textarea[@id='remarktext'])[2]"));
		String failure_reason_string = getData("REP_FA Master Fields", 1, 14);
		failure_reason1.sendKeys(failure_reason_string);
		Thread.sleep(500);
		WebElement ok_btn = driver.findElement(By.xpath("(.//div//app-fa-form//div//button[@id='remarkok'])[2]"));
		j.executeScript("arguments[0].click();", ok_btn);
		Thread.sleep(500);

		WebElement unit_serialNo = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l10 r10')]"));
		j.executeScript("arguments[0].click();", unit_serialNo);
		WebElement unit_serialNo1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l10 r10')]//input"));
		String unit_serialNo_string = getData("REP_FA Master Fields", 1, 15);
		unit_serialNo1.sendKeys(unit_serialNo_string);

//2nd Line
		WebElement failure_reason2 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l9 r9')]"));
		j.executeScript("arguments[0].click();", failure_reason2);
		WebElement failure_reason3 = driver.findElement(By.xpath("(.//div//textarea[@id='remarktext'])[2]"));
		String failure_reason_string1 = getData("REP_FA Master Fields", 2, 14);
		failure_reason3.sendKeys(failure_reason_string1);
		Thread.sleep(500);
		WebElement ok_btn1 = driver.findElement(By.xpath("(.//div//app-fa-form//div//button[@id='remarkok'])[2]"));
		j.executeScript("arguments[0].click();", ok_btn1);
		Thread.sleep(500);

		WebElement unit_serialNo2 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l10 r10')]"));
		j.executeScript("arguments[0].click();", unit_serialNo2);
		WebElement unit_serialNo3 = driver.findElement(
				By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l10 r10')]//input"));
		String unit_serialNo_string1 = getData("REP_FA Master Fields", 2, 15);
		unit_serialNo3.sendKeys(unit_serialNo_string1);

//3rd Line
		WebElement failure_reason4 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l9 r9')]"));
		j.executeScript("arguments[0].click();", failure_reason4);
		WebElement failure_reason5 = driver.findElement(By.xpath("(.//div//textarea[@id='remarktext'])[2]"));
		String failure_reason_string2 = getData("REP_FA Master Fields", 3, 14);
		failure_reason5.sendKeys(failure_reason_string2);
		Thread.sleep(500);
		WebElement ok_btn2 = driver.findElement(By.xpath("(.//div//app-fa-form//div//button[@id='remarkok'])[2]"));
		j.executeScript("arguments[0].click();", ok_btn2);
		Thread.sleep(500);

		WebElement unit_serialNo4 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l10 r10')]"));
		j.executeScript("arguments[0].click();", unit_serialNo4);
		WebElement unit_serialNo5 = driver.findElement(
				By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l10 r10')]//input"));
		String unit_serialNo_string2 = getData("REP_FA Master Fields", 3, 15);
		unit_serialNo5.sendKeys(unit_serialNo_string2);
	}

	@Given("User enters the FA Team Member {string} and {string} for FA")
	public void user_enters_the_fa_team_member_and_for_fa(String username, String password) {
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

	@When("User select the FA Issued status from the filter for FA")
	public void user_select_the_fa_issued_status_from_the_filter_for_fa() throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement issuesBtn = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(issuesBtn));
		j.executeScript("arguments[0].click();", issuesBtn);

		WebElement store = driver.findElement(By.xpath("//select[@name='requeststoreid']"));
		String store_string = getData("REP_FA Master Fields", 2, 10);
		select(store).selectByVisibleText(store_string);

		WebElement requestType = driver.findElement(By.xpath("//select[@name='requesttypeid']"));
		String requestType_string = getData("REP_FA Master Fields", 2, 11);
		select(requestType).selectByVisibleText(requestType_string);

		WebElement FAStatus = driver.findElement(By.xpath("//select[@name='faissuestatusid']"));
		String FAStatus_string = getData("REP_FA Master Fields", 2, 12);
		select(FAStatus).selectByVisibleText(FAStatus_string);
		Thread.sleep(3000);
	}

	@When("User enters the Dependent Team and Dependent Qty for FA")
	public void user_enters_the_dependent_team_and_dependent_qty_for_fa() throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

//1st Line
		WebElement dependency_team = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l11 r11')]"));
		j.executeScript("arguments[0].click();", dependency_team);
		WebElement dependency_team1 = driver.findElement(
				By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l11 r11')]//select"));
		String dependency_team_string = getData("REP_FA Master Fields", 1, 17);
		select(dependency_team1).selectByVisibleText(dependency_team_string);

		WebElement dependent_qty = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", dependent_qty);
		String dependent_qty_string = getData("REP_FA Master Fields", 1, 18);
		Alert a = driver.switchTo().alert();
		a.sendKeys(dependent_qty_string);
		a.accept();
		Thread.sleep(500);

//2nd Line
		WebElement dependency_team2 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l11 r11')]"));
		j.executeScript("arguments[0].click();", dependency_team2);
		WebElement dependency_team3 = driver.findElement(
				By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l11 r11')]//select"));
		String dependency_team_string1 = getData("REP_FA Master Fields", 2, 17);
		select(dependency_team3).selectByVisibleText(dependency_team_string1);

		WebElement dependent_qty1 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", dependent_qty1);
		String dependent_qty_string1 = getData("REP_FA Master Fields", 1, 18);
		a.sendKeys(dependent_qty_string1);
		a.accept();
		Thread.sleep(500);

//3rd Line
		WebElement dependency_team4 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l11 r11')]"));
		j.executeScript("arguments[0].click();", dependency_team4);
		WebElement dependency_team5 = driver.findElement(
				By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l11 r11')]//select"));
		String dependency_team_string2 = getData("REP_FA Master Fields", 3, 17);
		select(dependency_team5).selectByVisibleText(dependency_team_string2);

		WebElement dependent_qty2 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", dependent_qty2);
		String dependent_qty_string2 = getData("REP_FA Master Fields", 1, 18);
		a.sendKeys(dependent_qty_string2);
		a.accept();
		Thread.sleep(500);
	}

	@Given("User enters the MET Team Member {string} and {string} for FA")
	public void user_enters_the_met_team_member_and_for_fa(String username, String password) {
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

	@When("User select the FA Under Progress status from the filter for FA")
	public void user_select_the_fa_under_progress_status_from_the_filter_for_fa()
			throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement issuesBtn = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(issuesBtn));
		j.executeScript("arguments[0].click();", issuesBtn);

		WebElement store = driver.findElement(By.xpath("//select[@name='requeststoreid']"));
		String store_string = getData("REP_FA Master Fields", 3, 10);
		select(store).selectByVisibleText(store_string);

		WebElement requestType = driver.findElement(By.xpath("//select[@name='requesttypeid']"));
		String requestType_string = getData("REP_FA Master Fields", 3, 11);
		select(requestType).selectByVisibleText(requestType_string);

		WebElement FAStatus = driver.findElement(By.xpath("//select[@name='faissuestatusid']"));
		String FAStatus_string = getData("REP_FA Master Fields", 3, 12);
		select(FAStatus).selectByVisibleText(FAStatus_string);
		Thread.sleep(3000);
	}

	@When("User enters the FA Qty for MET for FA")
	public void user_enters_the_fa_qty_for_met_for_fa() throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebElement FA_qty = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l8 r8')]"));
		j.executeScript("arguments[0].click();", FA_qty);
		String FA_qty_string = getData("REP_FA Master Fields", 1, 19);
		Alert a = driver.switchTo().alert();
		a.sendKeys(FA_qty_string);
		a.accept();
		Thread.sleep(500);
	}

	@Given("User enters the PQ Team Member {string} and {string} for FA")
	public void user_enters_the_pq_team_member_and_for_fa(String username, String password) {
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

	@When("User enters the FA Qty for PQ for FA")
	public void user_enters_the_fa_qty_for_pq_for_fa() throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebElement FA_qty = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l8 r8')]"));
		j.executeScript("arguments[0].click();", FA_qty);
		String FA_qty_string = getData("REP_FA Master Fields", 1, 19);
		Alert a = driver.switchTo().alert();
		a.sendKeys(FA_qty_string);
		a.accept();
		Thread.sleep(500);
	}

	@Given("User enters the Design Team Member {string} and {string} for FA")
	public void user_enters_the_design_team_member_and_for_fa(String username, String password) {
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

	@When("User enters the FA Qty for Design for FA")
	public void user_enters_the_fa_qty_for_design_for_fa() throws InterruptedException, IOException {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebElement FA_qty = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l8 r8')]"));
		j.executeScript("arguments[0].click();", FA_qty);
		String FA_qty_string = getData("REP_FA Master Fields", 1, 19);
		Alert a = driver.switchTo().alert();
		a.sendKeys(FA_qty_string);
		a.accept();
		Thread.sleep(500);
	}

	@When("User enters the Working Qty for FA")
	public void user_enters_the_working_qty_for_fa() throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

//1st Line
		WebElement working_qty = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l9 r9')]"));
		j.executeScript("arguments[0].click();", working_qty);
		String working_qty_string = getData("REP_FA Master Fields", 1, 16);
		Alert a = driver.switchTo().alert();
		a.sendKeys(working_qty_string);
		a.accept();
		Thread.sleep(500);

//2nd Line
		WebElement working_qty1 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l9 r9')]"));
		j.executeScript("arguments[0].click();", working_qty1);
		String working_qty_string1 = getData("REP_FA Master Fields", 1, 16);
		a.sendKeys(working_qty_string1);
		a.accept();
		Thread.sleep(500);

//3rd Line
		WebElement working_qty2 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l9 r9')]"));
		j.executeScript("arguments[0].click();", working_qty2);
		String working_qty_string2 = getData("REP_FA Master Fields", 1, 16);
		a.sendKeys(working_qty_string2);
		a.accept();
		Thread.sleep(500);
	}

	@Given("User enters the FQC Team Member {string} and {string} for FA")
	public void user_enters_the_fqc_team_member_and_for_fa(String username, String password) {
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

	@When("User enters the FQC Qty for FA")
	public void user_enters_the_fqc_qty_for_fa() throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

//1st Line
		WebElement fqc_qty = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", fqc_qty);
		String fqc_qty_string = getData("REP_FA Master Fields", 1, 20);
		Alert a = driver.switchTo().alert();
		a.sendKeys(fqc_qty_string);
		a.accept();
		Thread.sleep(500);

//2nd Line
		WebElement fqc_qty1 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", fqc_qty1);
		String fqc_qty_string1 = getData("REP_FA Master Fields", 1, 20);
		a.sendKeys(fqc_qty_string1);
		a.accept();
		Thread.sleep(500);

//3rd Line
		WebElement fqc_qty2 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", fqc_qty2);
		String fqc_qty_string2 = getData("REP_FA Master Fields", 1, 20);
		a.sendKeys(fqc_qty_string2);
		a.accept();
		Thread.sleep(500);
	}

	@When("User select the FA Completed status from the filter for FA")
	public void user_select_the_fa_completed_status_from_the_filter_for_fa() throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement issuesBtn = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(issuesBtn));
		j.executeScript("arguments[0].click();", issuesBtn);

		WebElement store = driver.findElement(By.xpath("//select[@name='requeststoreid']"));
		String store_string = getData("REP_FA Master Fields", 4, 10);
		select(store).selectByVisibleText(store_string);

		WebElement requestType = driver.findElement(By.xpath("//select[@name='requesttypeid']"));
		String requestType_string = getData("REP_FA Master Fields", 4, 11);
		select(requestType).selectByVisibleText(requestType_string);

		WebElement FAStatus = driver.findElement(By.xpath("//select[@name='faissuestatusid']"));
		String FAStatus_string = getData("REP_FA Master Fields", 4, 12);
		select(FAStatus).selectByVisibleText(FAStatus_string);
		Thread.sleep(3000);
	}

	@Then("User verifies the FA Status has been changed to FA Completed and Signout for FA")
	public void user_verifies_the_fa_status_has_been_changed_to_fa_completed_and_signout_for_fa()
			throws InterruptedException {
		WebElement fa_completed = driver
				.findElement(By.xpath("//app-wstable//div[@class='ws-table-head']//table[@role='grid']//tbody//tr[1]"));
		System.out.println("Received Status : " + fa_completed.getText());
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

	@When("User create the MRD Request for FA")
	public void user_create_the_mrd_request_for_fa() throws InterruptedException, IOException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebElement issueModule = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		issueModule.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement addBtn = driver.findElement(By.xpath("(//button[@title='Add' and @type='button'])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(addBtn));
		j.executeScript("arguments[0].click();", addBtn);
		Thread.sleep(2000);

		WebElement requestType = (driver.findElement(By.xpath("(.//div//select)[1]")));
		String request = getData("MRD Master Fields", 1, 0);
		select(requestType).selectByVisibleText(request);
		Thread.sleep(500);

		WebElement wareHouse = (driver.findElement(By.xpath("(.//div//select)[3]")));
		String warehouse_string = getData("MRD Master Fields", 1, 1);
		select(wareHouse).selectByVisibleText(warehouse_string);

		WebElement costCenter = (driver.findElement(By.xpath("(.//div//select)[5]")));
		String costcenter_string = getData("MRD Master Fields", 1, 2);
		select(costCenter).selectByVisibleText(costcenter_string);

		WebElement product_code_input = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		String product_input = getData("MRD Master Fields", 1, 3);
		product_code_input.sendKeys(product_input);
		Thread.sleep(500);

		List<WebElement> product_code_inputlist = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
		for (WebElement webElement : product_code_inputlist) {
			String list = webElement.getText();
			if (list.contains("See3CAM_CU135_CH_TC")) {
				Thread.sleep(500);
				JavascriptExecutor k = (JavascriptExecutor) driver;
				k.executeScript("arguments[0].click();", webElement);
				System.out.println(webElement);
				break;
			}
			Thread.sleep(1000);
		}

		WebElement product_code_output = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
		String product_output = getData("MRD Master Fields", 1, 4);
		product_code_output.sendKeys(product_output);
		Thread.sleep(500);

		List<WebElement> product_code_outputlist = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
		for (WebElement webElement : product_code_outputlist) {
			String list = webElement.getText();
			if (list.contains("ACC-IMX53-GRYPHIA-CUMI1335-ADP")) {
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
//		WebElement bomselection = driver.findElement(By.xpath("//*[@id='multi']/div/div[4]/div[1]/div/input"));
//		String BOM = getData("MRI Master Fields", 1, 5);
//		bomselection.sendKeys(BOM);

		WebElement bomcheckbox = driver.findElement(By.xpath("//div//p-multiselectitem[2]/li/div/div"));
		j.executeScript("arguments[0].click();", bomcheckbox);

		WebElement bom_rev_no = (driver.findElement(By.xpath("(.//div//select)[6]")));
		String bomrev_string = getData("MRD Master Fields", 1, 6);
		select(bom_rev_no).selectByVisibleText(bomrev_string);

		WebElement customer_name = driver.findElement(By.xpath("(//input[@type='text'])[5]"));
		String customer_name_String = getData("MRD Master Fields", 1, 13);
		Boolean stale = wait.until(ExpectedConditions.stalenessOf(customer_name));
		if (stale == true) {
			int maxretries = 3;
			for (int i = 0; i < maxretries; i++) {
				try {
					customer_name = driver.findElement(By.xpath("(//input[@type='text'])[5]"));
					customer_name.sendKeys(customer_name_String);
					break;
				} catch (StaleElementReferenceException e) {
					System.out.println("Maximum Retry Failed");
				}
			}

		} else {
			System.out.println("Stale Element");
		}

		Thread.sleep(500);

		List<WebElement> customer_name_list = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
		for (WebElement webElement : customer_name_list) {
			String list = webElement.getText();
			if (list.contains(customer_name_String)) {
				Thread.sleep(500);
				JavascriptExecutor k = (JavascriptExecutor) driver;
				k.executeScript("arguments[0].click();", webElement);
				System.out.println(webElement);
				break;
			}
			Thread.sleep(1000);
		}

		WebElement so_number = (driver.findElement(By.xpath("(//div//app-form-text//div//input [@type='text'])[1]")));
		String so_number_string = getData("MRD Master Fields", 1, 14);
		so_number.sendKeys(so_number_string);

		WebElement CRM_Qty = (driver.findElement(By.xpath("(//div//app-form-text//div//input [@type='text'])[2]")));
		String CRM_Qty_string = getData("MRD Master Fields", 1, 15);
		CRM_Qty.sendKeys(CRM_Qty_string);

		WebElement MR_Qty = driver.findElement(By.xpath("(//div//app-form-text//div//input [@type='text'])[3]"));
		String MRQty_string = getData("MRD Master Fields", 1, 7);
		MR_Qty.sendKeys(MRQty_string);
		Thread.sleep(3000);
	}

	@When("User select the MRD Requested status from the filter for FA")
	public void user_select_the_mrd_requested_status_from_the_filter_for_fa() throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement issuesBtn = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(issuesBtn));
		j.executeScript("arguments[0].click();", issuesBtn);

		WebElement store = driver.findElement(By.xpath("//select[@name='requeststoreid']"));
		String store_string = getData("MRD Master Fields", 1, 10);
		select(store).selectByVisibleText(store_string);

		WebElement requestType = driver.findElement(By.xpath("//select[@name='requesttypeid']"));
		String requestType_string = getData("MRD Master Fields", 1, 11);
		select(requestType).selectByVisibleText(requestType_string);

		WebElement MRDStatus = driver.findElement(By.xpath("//select[@name='issuestatusid']"));
		String MRDStatus_string = getData("MRD Master Fields", 1, 12);
		select(MRDStatus).selectByVisibleText(MRDStatus_string);
		Thread.sleep(3000);
	}

	@When("User select the MRD Issued status from the filter for FA")
	public void user_select_the_mrd_issued_status_from_the_filter_for_fa() throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement issuesBtn = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(issuesBtn));
		j.executeScript("arguments[0].click();", issuesBtn);

		WebElement store = driver.findElement(By.xpath("//select[@name='requeststoreid']"));
		String store_string = getData("MRD Master Fields", 2, 10);
		select(store).selectByVisibleText(store_string);

		WebElement requestType = driver.findElement(By.xpath("//select[@name='requesttypeid']"));
		String requestType_string = getData("MRD Master Fields", 2, 11);
		select(requestType).selectByVisibleText(requestType_string);

		WebElement MRDStatus = driver.findElement(By.xpath("//select[@name='issuestatusid']"));
		String MRDStatus_string = getData("MRD Master Fields", 2, 12);
		select(MRDStatus).selectByVisibleText(MRDStatus_string);
		Thread.sleep(3000);
	}
	
	@When("User create the CR Request for FA")
	public void user_create_the_cr_request_for_fa() throws InterruptedException, IOException {
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
	
	@When("User select the CR Requested status from the filter for FA")
	public void user_select_the_cr_requested_status_from_the_filter_for_fa() throws IOException, InterruptedException {
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
	
	@When("User select the CR Issued status from the filter for FA")
	public void user_select_the_cr_issued_status_from_the_filter_for_fa() throws IOException, InterruptedException {
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

}
