package ecERP.PO;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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

public class PO_StepDefinition extends LibGlobal {

	public static WebDriver driver;

	@Given("User on the login page")
	public void user_on_the_login_page() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
//		driver.get("https://qa-erp.e-consystems.net/#/login");
		driver.get("https://stage-erp.e-consystems.net/#/login");
//		driver.get("http://localhost:8080/#/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement appTitle = driver.findElement(By.xpath("//h2[@class = 'heading-erp'][1]"));
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

	// Happy Flow For PO Creation and Issue

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

	@When("User create the PO Request for PO ORDER \\(RM)")
	public void user_create_the_PO_Request() throws InterruptedException, AWTException {

		WebElement purchaseOrderBtn = driver.findElement(By.xpath("(//a[contains(text(),'Purchase Order')])[1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(purchaseOrderBtn,
				By.xpath("(//a[contains(text(),'Purchase Order')])[1]")));
		purchaseOrderBtn.click();

		WebElement addBtn = driver.findElement(By.xpath("(//button[@title='Add' and @type='button'])[1]"));
		addBtn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='button'])[1]")));

		WebElement branch = (driver.findElement(By.xpath("(//select)[1]")));
		select(branch).selectByIndex(1);
		Thread.sleep(500);

		WebElement wareHouse = (driver.findElement(By.xpath("(//select)[2]")));
		select(wareHouse).selectByIndex(0);
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
		vendorField.sendKeys("A");
		Thread.sleep(500);

		List<WebElement> vendorList = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
		for (WebElement webElement : vendorList) {
			String list = webElement.getText();
			if (list.contains("A.K.INDUSTRIES")) {
				Thread.sleep(500);
				JavascriptExecutor k = (JavascriptExecutor) driver;
				k.executeScript("arguments[0].click();", webElement);
				System.out.println(webElement);
				break;
			}
			Thread.sleep(1000);
		}
//		try {
//			List<WebElement> vendorList1 = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
//			for (WebElement webElement1 : vendorList1) {
//				String list1 = webElement1.getText();
//				if (list1.contains("A.K.INDUSTRIES")) {
//					Thread.sleep(500);
//					JavascriptExecutor g1 = (JavascriptExecutor) driver;
//					g1.executeScript("arguments[0].click();", webElement1);
//					System.out.println(webElement1);
//					break;
//				}
//				Thread.sleep(1000);
//			}
//		} catch (StaleElementReferenceException|NoSuchElementException e) {
//		}

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

		WebElement orderType = driver.findElement(By.xpath("(//select)[5]"));
		selectOptionByIndex(orderType, 0);

		WebElement materialType = driver.findElement(By.xpath("(//select)[6]"));
		selectOptionByIndex(materialType, 0);

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

		WebElement costCenter = driver.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[2]"));
		JavascriptExecutor c = (JavascriptExecutor) driver;
		c.executeScript("arguments[0].click();", costCenter);
		WebElement costCenter1 = driver
				.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[2]//select"));
		selectOptionByIndex(costCenter1, 0);

		WebElement expenseCategory = driver
				.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[3]"));
		JavascriptExecutor e = (JavascriptExecutor) driver;
		e.executeScript("arguments[0].click();", expenseCategory);
		WebElement expenseCategory1 = driver
				.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[3]//select"));
		selectOptionByIndex(expenseCategory1, 1);

		WebElement partNo = driver.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[4]"));
		JavascriptExecutor p = (JavascriptExecutor) driver;
		p.executeScript("arguments[0].click();", partNo);
		WebElement partNo1 = driver
				.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[4]//input"));
		partNo1.sendKeys("A");
		WebElement autoSuggestion = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
		autoSuggestion.click();

		WebElement packingType = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[5]"));
		JavascriptExecutor p1 = (JavascriptExecutor) driver;
		p1.executeScript("arguments[0].click();", packingType);
		WebElement packingType1 = driver
				.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[5]//select"));
		selectOptionByIndex(packingType1, 0);

		WebElement workType = driver.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[6]"));
		JavascriptExecutor w = (JavascriptExecutor) driver;
		w.executeScript("arguments[0].click();", workType);
		WebElement workType1 = driver
				.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[6]//select"));
		selectOptionByIndex(workType1, 0);

		WebElement name = driver.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[7]"));
		JavascriptExecutor n = (JavascriptExecutor) driver;
		n.executeScript("arguments[0].click();", name);
		WebElement name1 = driver.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[7]//input"));
		name1.sendKeys("A");
		WebElement autoSuggestion1 = driver.findElement(By.xpath("//*[@class=\"ui-menu-item\"][1]"));
		autoSuggestion1.click();

		WebElement qty = driver.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[8]"));
		JavascriptExecutor q = (JavascriptExecutor) driver;
		q.executeScript("arguments[0].click();", qty);
		WebElement qty1 = driver.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[8]//input"));
		qty1.sendKeys("100");

		WebElement unitPrice = driver.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[9]"));
		JavascriptExecutor u = (JavascriptExecutor) driver;
		u.executeScript("arguments[0].click();", unitPrice);
		WebElement unitPrice1 = driver
				.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[9]//input"));
		unitPrice1.sendKeys("10");

		WebElement UOM = driver.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[13]"));
		JavascriptExecutor U = (JavascriptExecutor) driver;
		U.executeScript("arguments[0].click();", UOM);
		WebElement UOM1 = driver
				.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[13]//select"));
		selectOptionByIndex(UOM1, 0);

		WebElement deliveryDate = driver
				.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[14]"));
		JavascriptExecutor d = (JavascriptExecutor) driver;
		d.executeScript("arguments[0].click();", deliveryDate);
		WebElement deliverDate1 = driver
				.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[14]//input"));
		String date1 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		deliverDate1.sendKeys(date1);

		// With IQC checkbox code

		WebElement checkBox = driver
				.findElement(By.xpath("(//div[@id='form_grid_0']//div[@style='top:0px']//div)[15]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", checkBox);
		WebElement checkBox1 = driver.findElement(
				By.xpath("(//div[@id='form_grid_0']//div[@style='top:0px']//div)[15]//input[@type='checkbox']"));
		JavascriptExecutor j1 = (JavascriptExecutor) driver;
		j1.executeScript("arguments[0].click();", checkBox1);
		JavascriptExecutor j2 = (JavascriptExecutor) driver;
		j2.executeScript("arguments[0].click();", checkBox1);

		/*
		 *//*
			 * Withot IQC Checkbox code // WebElement insReason = driver
			 * .findElement(By.xpath(
			 * "//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[15]"));
			 * JavascriptExecutor j2 = (JavascriptExecutor) driver;
			 * j2.executeScript("arguments[0].click();", insReason); WebElement reasonText =
			 * driver.findElement( By.xpath(
			 * "//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[15]//input[@type='text']"
			 * )); reasonText.sendKeys("Not Required");
			 */

	}

	@Then("User click on the Save button and Signout")
	public void user_click_on_the_Save_button_and_Signout() throws InterruptedException {
		Thread.sleep(1000);
		WebElement saveButton = driver.findElement(By.xpath("(//button[@id='submitbutton' and @type='submit'])"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", saveButton);
		Thread.sleep(1000);
		saveButton.click();
		Thread.sleep(3000);

		WebElement msg = driver.findElement(By.xpath("(//app-alert//div)[1]"));
		System.out.println("PopUp Msg : " + msg.getText().toString());
		String popup = msg.getText().toString().trim().substring(0, 19);
		Thread.sleep(1000);

		WebElement successfullPoCreation = driver
				.findElement(By.xpath("//app-wstable//div[@class='ws-table-head']//table[@role='grid']//tbody//tr[1]"));
		System.out.println("Successfull PO Creation : " + successfullPoCreation.getText().toString());
		String table = successfullPoCreation.getText().toString().trim().substring(0, 19);

		if (popup.equals(table)) {// only true this executes
			System.out.println("Two Values are Equal");
			WebElement profileClick = driver.findElement(By.xpath("//span[@class = 'd-block'][1]"));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollTo(0,0);", profileClick);
			Thread.sleep(1000);
			profileClick.click();
			WebElement signOutBtn = driver.findElement(
					By.xpath("//h3[contains (@class, 'dropdown-item-title') and contains (text(), 'Sign out ')][1]"));
			signOutBtn.click();
			driver.quit();
		} else {
			System.out.println("Not Matching");
		}

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
	public void user_click_on_the_Edit_button() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement purchaseOrderBtn = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(),'Purchase Order')])[1]")));
		wait.until(ExpectedConditions.elementToBeClickable(purchaseOrderBtn));
		j.executeScript("window.scrollTo(0,0)", purchaseOrderBtn);
		purchaseOrderBtn.click();

		WebElement editBtn = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@role='grid']//tbody//tr[1]//th//button[1]//i")));
//		wait.until(ExpectedConditions.elementToBeClickable(editBtn));
		j.executeScript("arguments[0].click();", editBtn);
		try {
			j.executeScript("arguments[0].click();", editBtn);
		} catch (StaleElementReferenceException e) {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//table[@role='grid']//tbody//tr[1]//th//button[1]//i")));
//			wait.until(ExpectedConditions.elementToBeClickable(editBtn));
			j.executeScript("arguments[0].click();", editBtn);
		}

		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-main/div/app-submenu/div/app-tab/section/div/app-gridwrapper/div/div/div/app-form/section/div")));

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(
//				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(),'Purchase Order')])[1]")));
//		WebElement purchaseOrderBtn = driver.findElement(By.xpath("(//a[contains(text(),'Purchase Order')])[1]"));
//		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait1.until(ExpectedConditions.elementToBeClickable(purchaseOrderBtn));
//		purchaseOrderBtn.click();
//
//		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait2.until(
//				ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@role='grid']//tbody//tr[1]//th//button[1]//i")));
//		WebElement editBtn = driver.findElement(By.xpath("//table[@role='grid']//tbody//tr[1]//th//button[1]//i"));
//		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait3.until(ExpectedConditions.elementToBeClickable(editBtn));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", editBtn);
//		
//		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
//				"/html/body/app-root/div/app-main/div/app-submenu/div/app-tab/section/div/app-gridwrapper/div/div/div/app-form/section/div")));
	}

	@Given("User verify the PO and providing Pre-Approval")
	public void user_verify_the_PO_and_providing_Pre_Approval() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement dropdown = driver.findElement(By.xpath("(//div//app-form-select//select)"));
		if (dropdown.isEnabled()) {
			Select s = new Select(dropdown);
			Thread.sleep(500);
			selectOptionByIndex(dropdown, 1);
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		if (saveButton.isEnabled()) {
			js.executeScript("arguments[0].scrollIntoView(true);", saveButton);
			js.executeScript("arguments[0].click();", saveButton);
			System.out.println("Save Button Enabled");
		} else {
			System.out.println("Save Button Disabled");
			driver.quit();
		}
	}

	@Then("User verifies the PO Status has been changed and Signout")
	public void user_verifies_the_PO_Status_has_been_changed_and_Signout() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement poStatusFilter = driver.findElement(By.xpath("//select[@name='postatusid']"));
		wait.until(ExpectedConditions.elementSelectionStateToBe(poStatusFilter, false));
		selectOptionByIndex(poStatusFilter, 0);
		Thread.sleep(1000);

		WebElement poStatus = driver
				.findElement(By.xpath("//app-wstable//div[@class='ws-table-head']//table[@role='grid']//tbody//tr[1]"));
		System.out.println("Approval Status : " + poStatus.getText());
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

	@Given("User enters the Operations Head {string} and {string}")
	public void user_enters_the_Operations_Head_and(String username, String password) {
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
	public void user_verify_the_PO_and_providing_Final_Approval() throws InterruptedException {
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
	public void user_click_on_the_Issue_icon() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement purchaseOrderBtn = driver.findElement(By.xpath("(//a[contains(text(),'Purchase Order')])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(purchaseOrderBtn));
		j.executeScript("window.scrollTo(0,0)",purchaseOrderBtn);
		purchaseOrderBtn.click();
		Thread.sleep(1000);

		WebElement issueIcon = driver
				.findElement(By.xpath("(//table[@role='grid']//tbody//tr[1]//th//button[2]//i)[1]"));
		try {
			j.executeScript("arguments[0].click();", issueIcon);
		} catch (StaleElementReferenceException | NoSuchElementException e) {
			driver.findElement(By.xpath("(//table[@role='grid']//tbody//tr[1]//th//button[2]//i)[1]"));
			j.executeScript("arguments[0].click();", issueIcon);
		}
		Thread.sleep(5000);
	}

	@When("User click on the Issue button")
	public void user_click_on_the_Issue_button() throws InterruptedException {
		Select s = new Select(driver.findElement(By.xpath("(//select)[11]")));
		List<WebElement> options = s.getOptions();
		WebElement poApprovalStatus = s.getFirstSelectedOption();
		System.out.println("Approval Status : " + poApprovalStatus.getText());

		WebElement issueButton = driver.findElement(By.xpath("(//button[@id='submitbutton' and @type='submit'])"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", issueButton);
//		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(issueButton));
		js.executeScript("arguments[0].click();", issueButton);
		Thread.sleep(2000);
	}

	@Then("User verifies the PO Status has been changed to Issued and Signout")
	public void user_verifies_the_PO_Status_has_been_changed_to_Issued_and_Signout() throws InterruptedException {
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

	// *** To Be Revised and Rejection Flow ***\\

	@Given("User verify the PO and providing To-Be Revised")
	public void user_verify_the_PO_and_providing_To_Be_Revised() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.xpath("(//div//app-form-select//select)"));
		if (dropdown.isEnabled()) {
			Select s = new Select(dropdown);
			Thread.sleep(500);
			s.selectByIndex(2);
			Thread.sleep(500);
		} else {
			System.out.println("Dropdown is disabled. Cannot select an option.");
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[1]//input[@pattern='[a-zA-Z0-9*/\\s]+' and @type='text'])[1]")));
		WebElement remarks = driver
				.findElement(By.xpath("(//div[1]//input[@pattern='[a-zA-Z0-9*/\\s]+' and @type='text'])[1]"));
		remarks.sendKeys("Siva Pradeep : Revise the PO");
		Thread.sleep(1000);
	}

	@Given("User made the changes accordingly")
	public void user_made_the_changes_accordingly() throws InterruptedException {
		WebElement remarks = driver
				.findElement(By.xpath("(//div[1]//input[@pattern='[a-zA-Z0-9*/\\s]+' and @type='text'])[1]"));
		remarks.sendKeys("Raja Vijay : Changes Made Accordingly");
		Thread.sleep(1000);
	}

	@Then("User click the Save and Signout button")
	public void user_click_the_Save_and_Signout_button() throws InterruptedException {
		Thread.sleep(1000);
		WebElement saveButton = driver.findElement(By.xpath("(//button[@id='submitbutton' and @type='submit'])"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", saveButton);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		js.executeScript("arguments[0].click();", saveButton);
		Thread.sleep(1000);

		WebElement successfullPoCreation = driver
				.findElement(By.xpath("//app-wstable//div[@class='ws-table-head']//table[@role='grid']//tbody//tr[1]"));
		System.out.println("Successfull PO Creation : " + successfullPoCreation.getText());

		WebElement profileClick = driver.findElement(By.xpath("//span[@class = 'd-block'][1]"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollTo(0,0);", profileClick);
		Thread.sleep(1000);
		profileClick.click();
		WebElement signOutBtn = driver.findElement(
				By.xpath("//h3[contains (@class, 'dropdown-item-title') and contains (text(), 'Sign out ')][1]"));
		signOutBtn.click();
		driver.quit();

	}

	@Given("User verify the PO and providing Pre-Approved")
	public void user_verify_the_PO_and_providing_Pre_Approved() throws InterruptedException {
		Thread.sleep(500);
		WebElement filter = driver.findElement(By.xpath("(//div//app-form-select//select)"));
		selectOptionByIndex(filter, 1);
		Thread.sleep(500);

		WebElement remarks = driver
				.findElement(By.xpath("(//div[1]//input[@pattern='[a-zA-Z0-9*/\\s]+' and @type='text'])[1]"));
		remarks.sendKeys("Siva Pradeep : Looking Perfect");
		Thread.sleep(1000);
	}

	@Given("User verify the PO and providing Final-Approval Reject")
	public void user_verify_the_PO_and_providing_Final_Approval_Reject() throws InterruptedException {
		Thread.sleep(500);
		WebElement filter = driver.findElement(By.xpath("(//div//app-form-select//select)"));
		selectOptionByIndex(filter, 3);
		Thread.sleep(500);

		WebElement remarks = driver
				.findElement(By.xpath("(//div[1]//input[@pattern='[a-zA-Z0-9*/\\s]+' and @type='text'])[1]"));
		remarks.sendKeys("Salim : Looking Perfect");
		Thread.sleep(1000);
	}
	// *** PDF Download Option

	@When("User click on the save button")
	public void user_click_on_the_save_button() throws InterruptedException {
		try {
			Thread.sleep(500);
			WebElement saveButton = driver
					.findElement(By.xpath("(//div//button[@id='submitbutton' and @type='submit'])"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", saveButton);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(saveButton));
			if (saveButton.isEnabled()) {
				System.out.println("Save Button Enabled");
				js.executeScript("arguments[0].click();", saveButton);
//				saveButton.click();
			} else {
				wait.until(ExpectedConditions.visibilityOf(saveButton));
				js.executeScript("arguments[0].click();", saveButton);
//				saveButton.click();
				System.out.println("Save Button Enabled");
			}

			Thread.sleep(2000);
			WebElement successfullPoCreation = driver.findElement(
					By.xpath("//app-wstable//div[@class='ws-table-head']//table[@role='grid']//tbody//tr[1]"));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollTo(0,0);", successfullPoCreation);

			System.out.println("Successfull PO Creation : " + successfullPoCreation.getText());
//			WebElement alertDismiss = driver.findElement(By.xpath("(//app-alert//div)[1]//i[@style='font-size:15px']"));
//			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
//			wait2.until(ExpectedConditions.elementToBeClickable(alertDismiss));
//			alertDismiss.click();
			Thread.sleep(5000);
		} catch (StaleElementReferenceException | NoSuchElementException e) {
		}
	}

	@When("User click on the Download and Cancel button")
	public void user_click_on_the_Download_and_Cancel_button() throws InterruptedException {

//		Thread.sleep(1000);
		WebElement pdfButton = driver.findElement(By.xpath("//div//button[2]//i"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(pdfButton));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", pdfButton);

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//app-form//section//div//div//div[6]//button[2][contains (text(), 'Cancel')]")));

		WebElement cancelBtn = driver
				.findElement(By.xpath("//app-form//section//div//div//div[6]//button[2][contains (text(), 'Cancel')]"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView(true);", cancelBtn);
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.elementToBeClickable(cancelBtn));
		js1.executeScript("arguments[0].click();", cancelBtn);
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
		Thread.sleep(1000);
	}

	@When("User click on the Force Closure")
	public void user_click_on_the_Force_Closure() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div//div//app-form-checkbox//div//input[@type='checkbox']")));
		Thread.sleep(800);
		WebElement forceClosureBtn = driver
				.findElement(By.xpath("//div//div//app-form-checkbox//div//input[@type='checkbox']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		wait.until(ExpectedConditions.elementToBeClickable(forceClosureBtn));
		js.executeScript("arguments[0].click();", forceClosureBtn);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div//input[@pattern='[a-zA-Z0-9*/\\s]+' and @type='text'])[1]")));
		WebElement remarks = driver
				.findElement(By.xpath("(//div//input[@pattern='[a-zA-Z0-9*/\\s]+' and @type='text'])[1]"));
		remarks.sendKeys("Wrongly Created By Rajha Vijay");
		Thread.sleep(1000);
	}

	// *** Amended Flow ***//

	@Given("User click the Edit button and do the Unimportant changes \\(RM)")
	public void user_click_the_edit_button_and_do_the_unimportant_changes_rm() throws InterruptedException {
		try {
			Thread.sleep(500);
			WebElement editBtn = driver.findElement(By.xpath("//table[@role='grid']//tbody//tr[1]//th//button[1]//i"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", editBtn);
			try {
				js.executeScript("arguments[0].click();", editBtn);
			} catch (StaleElementReferenceException e) {
				js.executeScript("arguments[0].click();", editBtn);
				editBtn = driver.findElement(By.xpath("//table[@role='grid']//tbody//tr[1]//th//button[1]//i"));
			}
			Thread.sleep(2000);

			WebElement remarks = driver
					.findElement(By.xpath("(//div[1]//input[@pattern='[a-zA-Z0-9*/\\s]+' and @type='text'])[1]"));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].scrollIntoView(true);", remarks);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(remarks));
			remarks.sendKeys("Changed Part Number, Unit Price, Quantity and Delivery Date");
//		Thread.sleep(1000);

			// Grid Values
			WebElement costCenter = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l1 r1')]"));
			JavascriptExecutor c = (JavascriptExecutor) driver;
			c.executeScript("arguments[0].click();", costCenter);
			WebElement costCenter1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l1 r1')]//select"));
			selectOptionByIndex(costCenter1, 0);

			WebElement expenseCategory = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l2 r2')]"));
			JavascriptExecutor e = (JavascriptExecutor) driver;
			e.executeScript("arguments[0].click();", expenseCategory);
			WebElement expenseCategory1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l2 r2')]//select"));
			selectOptionByIndex(expenseCategory1, 0);

			WebElement workType = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l5 r5')]"));
			JavascriptExecutor w = (JavascriptExecutor) driver;
			w.executeScript("arguments[0].click();", workType);
			WebElement workType1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l5 r5')]//select"));
			selectOptionByIndex(workType1, 0);

			WebElement name = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l6 r6')]"));
			JavascriptExecutor n = (JavascriptExecutor) driver;
			n.executeScript("arguments[0].click();", name);
			WebElement name1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l6 r6')]//input"));
			name1.sendKeys("S");
			WebElement autoSuggestion1 = driver.findElement(By.xpath("//*[@class=\"ui-menu-item\"][1]"));
			autoSuggestion1.click();

			WebElement UOM = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l13 r13')]"));
			JavascriptExecutor U = (JavascriptExecutor) driver;
			U.executeScript("arguments[0].click();", UOM);
			WebElement UOM1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l13 r13')]//select"));
			selectOptionByIndex(UOM1, 1);
		} catch (StaleElementReferenceException w2) {
		}
	}

	@Given("User click the Edit button and do the Unimportant changes \\(FG)")
	public void user_click_the_edit_button_and_do_the_unimportant_changes_fg()
			throws InterruptedException, AWTException {
		try {
			Thread.sleep(500);
			WebElement editBtn = driver.findElement(By.xpath("//table[@role='grid']//tbody//tr[1]//th//button[1]//i"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", editBtn);
			try {
				js.executeScript("arguments[0].click();", editBtn);
			} catch (StaleElementReferenceException e) {
				js.executeScript("arguments[0].click();", editBtn);
				editBtn = driver.findElement(By.xpath("//table[@role='grid']//tbody//tr[1]//th//button[1]//i"));
			}
			Thread.sleep(2000);

			WebElement remarks = driver
					.findElement(By.xpath("(//div[1]//input[@pattern='[a-zA-Z0-9*/\\s]+' and @type='text'])[1]"));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].scrollIntoView(true);", remarks);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("(//div[1]//input[@pattern='[a-zA-Z0-9*/\\s]+' and @type='text'])[1]")));
			remarks.sendKeys("Changed Part Number, Unit Price, Quantity and Delivery Date");
//		Thread.sleep(1000);

			// Grid Values
			WebElement costCenter = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l1 r1')]"));
			JavascriptExecutor c = (JavascriptExecutor) driver;
			c.executeScript("arguments[0].click();", costCenter);
			WebElement costCenter1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l1 r1')]//select"));
			selectOptionByIndex(costCenter1, 1);

			WebElement expenseCategory = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l2 r2')]"));
			JavascriptExecutor e = (JavascriptExecutor) driver;
			e.executeScript("arguments[0].click();", expenseCategory);
			WebElement expenseCategory1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l2 r2')]//select"));
			selectOptionByIndex(expenseCategory1, 0);

			WebElement workType = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l5 r5')]"));
			JavascriptExecutor w = (JavascriptExecutor) driver;
			w.executeScript("arguments[0].click();", workType);
			WebElement workType1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l5 r5')]//select"));
			selectOptionByIndex(workType1, 0);

			WebElement name = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l6 r6')]"));
			JavascriptExecutor n = (JavascriptExecutor) driver;
			n.executeScript("arguments[0].click();", name);
			WebElement name1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l6 r6')]//input"));
			name1.sendKeys("S");
			WebElement autoSuggestion1 = driver.findElement(By.xpath("//*[@class='ui-menu-item'][1]"));
			autoSuggestion1.click();

			WebElement UOM = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l13 r13')]"));
			JavascriptExecutor U = (JavascriptExecutor) driver;
			U.executeScript("arguments[0].click();", UOM);
			WebElement UOM1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l13 r13')]//select"));
			selectOptionByIndex(UOM1, 1);
		} catch (StaleElementReferenceException w3) {
		}
	}

	@Then("User verifies the Issued PO Status by filter and Signout")
	public void user_verifies_the_Issued_PO_Status_by_filter_and_Signout() throws InterruptedException {
		WebElement purchaseOrderBtn = driver.findElement(By.xpath("(//a[contains(text(),'Purchase Order')])[1]"));
		purchaseOrderBtn.click();
		Thread.sleep(400);

		WebElement poStatusFilter = driver.findElement(By.xpath("//select[@name='postatusid']"));
		selectOptionByIndex(poStatusFilter, 5);
		Thread.sleep(500);

		WebElement poStatus = driver
				.findElement(By.xpath("//app-wstable//div[@class='ws-table-head']//table[@role='grid']//tbody//tr[1]"));
		System.out.println("PO Status : " + poStatus.getText());
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

	@Given("User select the Issued PO from the filter")
	public void user_select_the_Issued_PO_from_the_filter() throws InterruptedException {
		WebElement purchaseOrderBtn = driver.findElement(By.xpath("(//a[contains(text(),'Purchase Order')])[1]"));
		purchaseOrderBtn.click();
		Thread.sleep(400);

		WebElement poStatusFilter = driver.findElement(By.xpath("//select[@name='postatusid']"));
		selectOptionByIndex(poStatusFilter, 5);
		Thread.sleep(3000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf(poStatusFilter));
	}

	@Given("User click the Edit button and do the Required changes \\(RM)")
	public void user_click_the_edit_button_and_do_the_required_changes_rm() throws InterruptedException {
		try {
			Thread.sleep(500);
			WebElement editBtn = driver.findElement(By.xpath("//table[@role='grid']//tbody//tr[1]//th//button[1]//i"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", editBtn);
			try {
				js.executeScript("arguments[0].click();", editBtn);
			} catch (StaleElementReferenceException q) {
				editBtn = driver.findElement(By.xpath("//table[@role='grid']//tbody//tr[1]//th//button[1]//i"));
				js.executeScript("arguments[0].click();", editBtn);
			}
			Thread.sleep(2000);

			WebElement remarks = driver
					.findElement(By.xpath("(//div[1]//input[@pattern='[a-zA-Z0-9*/\\s]+' and @type='text'])[1]"));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].scrollIntoView(true);", remarks);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("(//div[1]//input[@pattern='[a-zA-Z0-9*/\\s]+' and @type='text'])[1]")));
			remarks.sendKeys("Changed Part Number, Unit Price, Quantity and Delivery Date");
//		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"form_grid_0\\\"]/div[4]/div[3]/div/div/div[2]")));

			WebElement costCenter = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l1 r1')]"));
			JavascriptExecutor c = (JavascriptExecutor) driver;
			c.executeScript("arguments[0].click();", costCenter);
			WebElement costCenter1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l1 r1')]//select"));
			selectOptionByIndex(costCenter1, 1);

			WebElement expenseCategory = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l2 r2')]"));
			JavascriptExecutor e = (JavascriptExecutor) driver;
			e.executeScript("arguments[0].click();", expenseCategory);
			WebElement expenseCategory1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l2 r2')]//select"));
			selectOptionByIndex(expenseCategory1, 0);

			WebElement partNo = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l3 r3')]"));
			JavascriptExecutor p = (JavascriptExecutor) driver;
			p.executeScript("arguments[0].click();", partNo);
			WebElement partNo1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l3 r3')]//input"));
			partNo1.sendKeys("A");
			WebElement autoSuggestion = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
			autoSuggestion.click();

			WebElement packingType = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l4 r4')]"));
			JavascriptExecutor p1 = (JavascriptExecutor) driver;
			p1.executeScript("arguments[0].click();", packingType);
			Thread.sleep(500);
			try {
				p1.executeScript("arguments[0].click();", packingType);
			} catch (StaleElementReferenceException a) {
				packingType = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l4 r4')]"));
				p1.executeScript("arguments[0].click();", packingType);
			}
			WebElement packingType1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l4 r4')]//select"));
			selectOptionByIndex(packingType1, 0);

			WebElement workType = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l5 r5')]"));
			JavascriptExecutor w = (JavascriptExecutor) driver;
			w.executeScript("arguments[0].click();", workType);
			Thread.sleep(500);
			try {
				w.executeScript("arguments[0].click();", workType);
			} catch (StaleElementReferenceException b) {
				workType = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l5 r5')]"));
				w.executeScript("arguments[0].click();", workType);
			}
			WebElement workType1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l5 r5')]//select"));
			selectOptionByIndex(workType1, 1);

			WebElement name = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l6 r6')]"));
			JavascriptExecutor n = (JavascriptExecutor) driver;
			n.executeScript("arguments[0].click();", name);
			Thread.sleep(500);
			try {
				n.executeScript("arguments[0].click();", name);
			} catch (StaleElementReferenceException d) {
				name = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l6 r6')]"));
				n.executeScript("arguments[0].click();", name);
			}
			WebElement name1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l6 r6')]//input"));
			name1.sendKeys("A");
			WebElement autoSuggestion1 = driver.findElement(By.xpath("//*[@class=\"ui-menu-item\"][1]"));
			autoSuggestion1.click();

			WebElement qty = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l7 r7')]"));
			JavascriptExecutor q = (JavascriptExecutor) driver;
			q.executeScript("arguments[0].click();", qty);
			Thread.sleep(500);
			try {
				q.executeScript("arguments[0].click();", qty);
			} catch (StaleElementReferenceException f) {
				qty = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l7 r7')]"));
				q.executeScript("arguments[0].click();", qty);
			}
			WebElement qty1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l7 r7')]//input"));
			qty1.sendKeys("50");

			WebElement unitPrice = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l9 r9')]"));
			JavascriptExecutor u = (JavascriptExecutor) driver;
			u.executeScript("arguments[0].click();", unitPrice);
			Thread.sleep(500);
			try {
				u.executeScript("arguments[0].click();", unitPrice);
			} catch (StaleElementReferenceException g) {
				unitPrice = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l9 r9')]"));
				u.executeScript("arguments[0].click();", unitPrice);
			}
			WebElement unitPrice1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l9 r9')]//input"));
			unitPrice1.sendKeys("5");

			WebElement UOM = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l13 r13')]"));
			JavascriptExecutor U = (JavascriptExecutor) driver;
			U.executeScript("arguments[0].click();", UOM);
			Thread.sleep(500);
			try {
				U.executeScript("arguments[0].click();", UOM);
			} catch (StaleElementReferenceException h) {
				UOM = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l13 r13')]"));
				U.executeScript("arguments[0].click();", UOM);
			}
			WebElement UOM1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l13 r13')]//select"));
			selectOptionByIndex(UOM1, 1);

			WebElement deliveryDate = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l14 r14')]"));
			JavascriptExecutor d = (JavascriptExecutor) driver;
			d.executeScript("arguments[0].click();", deliveryDate);
			Thread.sleep(500);
			try {
				d.executeScript("arguments[0].click();", deliveryDate);
			} catch (StaleElementReferenceException i) {
				deliveryDate = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l14 r14')]"));
				d.executeScript("arguments[0].click();", deliveryDate);
			}
			WebElement deliverDate1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l14 r14')]//input"));
			String date1 = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			deliverDate1.sendKeys(date1);
		} catch (StaleElementReferenceException w1) {
		}
	}

	@Given("User click the Edit button and do the Required changes \\(FG)")
	public void user_click_the_edit_button_and_do_the_required_changes_fg() throws InterruptedException, AWTException {
		try {

			Thread.sleep(500);
			JavascriptExecutor j = (JavascriptExecutor) driver;
			WebElement editBtn = driver.findElement(By.xpath("//table[@role='grid']//tbody//tr[1]//th//button[1]//i"));	
			j.executeScript("arguments[0].click();", editBtn);
			try {
				j.executeScript("arguments[0].click();", editBtn);
			} catch (StaleElementReferenceException q) {
				editBtn = driver.findElement(By.xpath("//table[@role='grid']//tbody//tr[1]//th//button[1]//i"));
				j.executeScript("arguments[0].click();", editBtn);
			}
			Thread.sleep(2000);

			WebElement remarks = driver
					.findElement(By.xpath("(//div[1]//input[@pattern='[a-zA-Z0-9*/\\s]+' and @type='text'])[1]"));
			j.executeScript("arguments[0].scrollIntoView(true);", remarks);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("(//div[1]//input[@pattern='[a-zA-Z0-9*/\\s]+' and @type='text'])[1]")));
			remarks.sendKeys("Changed Part Number, Unit Price, Quantity and Delivery Date");
//		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"form_grid_0\\\"]/div[4]/div[3]/div/div/div[2]")));

			WebElement costCenter = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l1 r1')]"));
			j.executeScript("arguments[0].click();", costCenter);
			WebElement costCenter1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l1 r1')]//select"));
			selectOptionByIndex(costCenter1, 1);

			WebElement expenseCategory = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l2 r2')]"));
			j.executeScript("arguments[0].click();", expenseCategory);
			WebElement expenseCategory1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l2 r2')]//select"));
			selectOptionByIndex(expenseCategory1, 0);

			WebElement partNo = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l3 r3')]"));
			j.executeScript("arguments[0].click();", partNo);
			WebElement partNo1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l3 r3')]//input"));
			partNo1.sendKeys("A");
			WebElement autoSuggestion = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
			autoSuggestion.click();
			
			WebElement orig_Mater_Type = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l4 r4')]"));
			j.executeScript("arguments[0].click();", orig_Mater_Type);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", orig_Mater_Type);
			} catch (Exception e2) {
				orig_Mater_Type = driver
						.findElement(By.xpath(".//div[contains (@class, 'slick-cell l4 r4')]"));
				j.executeScript("arguments[0].click();", orig_Mater_Type);
			}
			WebElement orig_Mater_Type1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l4 r4')]//select"));
			selectOptionByIndex(orig_Mater_Type1, 0);

			WebElement workType = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l5 r5')]"));
			j.executeScript("arguments[0].click();", workType);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", workType);
			} catch (StaleElementReferenceException e6) {
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
				driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l6 r6')]"));
				j.executeScript("arguments[0].click();", name);
			} catch (StaleElementReferenceException | NoSuchElementException e7) {
				driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l6 r6')]"));
				j.executeScript("arguments[0].click();", name);
			}
			WebElement name1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l6 r6')]//input"));
			name1.sendKeys("A");
			WebElement autoSuggestion1 = driver.findElement(By.xpath("//*[@class=\"ui-menu-item\"][1]"));
			autoSuggestion1.click();

			WebElement qty = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l7 r7')]"));
			j.executeScript("arguments[0].click();", qty);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", qty);
			} catch (StaleElementReferenceException e8) {
				qty = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l7 r7')]"));
				j.executeScript("arguments[0].click();", qty);
			}
			WebElement qty1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l7 r7')]//input"));
			qty1.sendKeys("50");

			WebElement unitPrice = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l9 r9')]"));
			j.executeScript("arguments[0].click();", unitPrice);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", unitPrice);
			} catch (StaleElementReferenceException e9) {
				unitPrice = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l9 r9')]"));
				j.executeScript("arguments[0].click();", unitPrice);
			}
			WebElement unitPrice1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l9 r9')]//input"));
			unitPrice1.sendKeys("5");

			WebElement UOM = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l13 r13')]"));
			j.executeScript("arguments[0].click();", UOM);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", UOM);
			} catch (StaleElementReferenceException e10) {
				UOM = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l13 r13')]"));
				j.executeScript("arguments[0].click();", UOM);
			}
			WebElement UOM1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l13 r13')]//select"));
			selectOptionByIndex(UOM1, 1);

			WebElement deliveryDate = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l14 r14')]"));
			j.executeScript("arguments[0].click();", deliveryDate);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", deliveryDate);
			} catch (StaleElementReferenceException e11) {
				deliveryDate = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l14 r14')]"));
				j.executeScript("arguments[0].click();", deliveryDate);
			}
			WebElement deliverDate1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l14 r14')]//input"));
			String date1 = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			deliverDate1.sendKeys(date1);
		} catch (StaleElementReferenceException w) {
		}
	}

	@Then("User verifies the PO Status by filter and Signout")
	public void user_verifies_the_PO_Status_by_filter_and_Signout() throws InterruptedException {
		WebElement purchaseOrderBtn = driver.findElement(By.xpath("(//a[contains(text(),'Purchase Order')])[1]"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollTo(0,0);", purchaseOrderBtn);
		Thread.sleep(500);
		purchaseOrderBtn.click();
		Thread.sleep(400);

		WebElement poStatusFilter = driver.findElement(By.xpath("//select[@name='postatusid']"));
		selectOptionByIndex(poStatusFilter, 0);
		Thread.sleep(2000);

		WebElement poStatus = driver
				.findElement(By.xpath("//app-wstable//div[@class='ws-table-head']//table[@role='grid']//tbody//tr[1]"));
		String text = poStatus.getText().toString().trim().substring(0, 20);

		WebElement searchBy = driver.findElement(By.xpath("(//div//div//div//div//input[@type='text'])[1]"));
		Thread.sleep(1000);
		searchBy.sendKeys(text);
		WebElement searchBtn = driver
				.findElement(By.xpath("(//div//div//div//div//div//div//button[@type='button']//i)[2]"));
		searchBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/app-root/div/app-main/div/app-submenu/div/app-tab/section/div/app-gridwrapper/div/div/div/div[2]/app-wstable/div/table")));
		try {
			WebElement overallStatus = driver.findElement(
					By.xpath("//app-wstable//div[@class='ws-table-head']//table[@role='grid']//tbody//tr[1]"));
			System.out.println("PO Status Amended: " + overallStatus.getText());
		} catch (StaleElementReferenceException e2) {
			WebElement overallStatus = driver.findElement(
					By.xpath("//app-wstable//div[@class='ws-table-head']//table[@role='grid']//tbody//tr[1]"));
			System.out.println("PO Status Amended: " + overallStatus.getText());
		}
		try {
			WebElement overallStatus1 = driver.findElement(
					By.xpath("//app-wstable//div[@class='ws-table-head']//table[@role='grid']//tbody//tr[2]"));
			System.out.println("PO Status AMD Closed: " + overallStatus1.getText());
		} catch (StaleElementReferenceException e3) {
			WebElement overallStatus1 = driver.findElement(
					By.xpath("//app-wstable//div[@class='ws-table-head']//table[@role='grid']//tbody//tr[2]"));
			System.out.println("PO Status AMD Closed: " + overallStatus1.getText());
		}
		Thread.sleep(500);
		WebElement profileClick = driver.findElement(By.xpath("(//app-header//div//div//span[@class = 'd-block'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,0);", profileClick);
		Thread.sleep(1000);
		profileClick.click();
		Thread.sleep(1000);
		WebElement signOutBtn = driver.findElement(
				By.xpath("//h3[contains (@class, 'dropdown-item-title') and contains (text(), 'Sign out')][1]"));
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//h3[contains (@class, 'dropdown-item-title') and contains (text(), 'Sign out')][1]")));
		signOutBtn.click();
		driver.quit();
	}

	@Given("User select the Amended PO from the filter")
	public void user_select_the_Amended_PO_from_the_filter() throws InterruptedException {
		WebElement purchaseOrderBtn = driver.findElement(By.xpath("(//a[contains(text(),'Purchase Order')])[1]"));
		purchaseOrderBtn.click();
		Thread.sleep(400);

		WebElement poStatusFilter = driver.findElement(By.xpath("//select[@name='postatusid']"));
		selectOptionByIndex(poStatusFilter, 6);
		Thread.sleep(1000);
	}

	@Given("User select the Pre-Approved PO from the filter")
	public void user_select_the_Pre_Approved_PO_from_the_filter() throws InterruptedException {
		WebElement purchaseOrderBtn = driver.findElement(By.xpath("(//a[contains(text(),'Purchase Order')])[1]"));
		purchaseOrderBtn.click();
		Thread.sleep(400);

		WebElement poStatusFilter = driver.findElement(By.xpath("//select[@name='postatusid']"));
		selectOptionByIndex(poStatusFilter, 2);
		Thread.sleep(1000);
	}

	@Given("User select the Final-Approved PO from the filter")
	public void user_select_the_Final_Approved_PO_from_the_filter() throws InterruptedException {
		WebElement purchaseOrderBtn = driver.findElement(By.xpath("(//a[contains(text(),'Purchase Order')])[1]"));
		purchaseOrderBtn.click();
		Thread.sleep(400);

		WebElement poStatusFilter = driver.findElement(By.xpath("//select[@name='postatusid']"));
		selectOptionByIndex(poStatusFilter, 3);
		Thread.sleep(1000);
	}

	@When("User create the PO Request for PO ORDER \\(FG)")
	public void user_create_the_po_request_for_po_order_fg() throws AWTException, InterruptedException {
		try {
			JavascriptExecutor j = (JavascriptExecutor)driver;
			WebElement purchaseOrderBtn = driver.findElement(By.xpath("(//a[contains(text(),'Purchase Order')])[1]"));
			purchaseOrderBtn.click();

			WebElement addBtn = driver.findElement(By.xpath("(//button[@title='Add' and @type='button'])[1]"));
			addBtn.click();
			Thread.sleep(1000);

			WebElement branch = (driver.findElement(By.xpath("(//select)[1]")));
			select(branch).selectByIndex(1);
			Thread.sleep(500);

			WebElement wareHouse = (driver.findElement(By.xpath("(//select)[2]")));
			select(wareHouse).selectByIndex(0);
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
			vendorField.sendKeys("A");
			Thread.sleep(500);

			List<WebElement> vendorList = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
			for (WebElement webElement : vendorList) {
				String list = webElement.getText();
				if (list.contains("A.K.INDUSTRIES")) {
					Thread.sleep(500);
					JavascriptExecutor k = (JavascriptExecutor) driver;
					k.executeScript("arguments[0].click();", webElement);
					System.out.println(webElement);
					break;
				}
				Thread.sleep(1000);
			}
//			try {
//				List<WebElement> vendorList1 = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
//				for (WebElement webElement1 : vendorList1) {
//					String list1 = webElement1.getText();
//					if (list1.contains("A.K.INDUSTRIES")) {
//						Thread.sleep(500);
//						webElement1.click();
//						System.out.println(webElement1);
//						break;
//					}
//					Thread.sleep(1000);
//				}
//			} catch (StaleElementReferenceException e) {
//			}

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

			// PO Order - FG Type

			WebElement orderType = driver.findElement(By.xpath("(//select)[5]"));
			selectOptionByIndex(orderType, 0);

			WebElement materialType = driver.findElement(By.xpath("(//select)[6]"));
			selectOptionByIndex(materialType, 1);

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

			WebElement costCenter = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l1 r1')]"));
			j.executeScript("arguments[0].click();", costCenter);
			WebElement costCenter1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l1 r1')]//select"));
			selectOptionByIndex(costCenter1, 0);

			WebElement expenseCategory = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l2 r2')]"));
			j.executeScript("arguments[0].click();", expenseCategory);
			WebElement expenseCategory1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l2 r2')]//select"));
			selectOptionByIndex(expenseCategory1, 0);

			WebElement partNo = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l3 r3')]"));
			j.executeScript("arguments[0].click();", partNo);
			WebElement partNo1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l3 r3')]//input"));
			partNo1.sendKeys("A");
			WebElement autoSuggestion = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
			autoSuggestion.click();

			WebElement orig_Mater_Type = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l4 r4')]"));
			j.executeScript("arguments[0].click();", orig_Mater_Type);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", orig_Mater_Type);
			} catch (Exception e2) {
				orig_Mater_Type = driver
						.findElement(By.xpath(".//div[contains (@class, 'slick-cell l4 r4')]"));
				j.executeScript("arguments[0].click();", orig_Mater_Type);
			}
			WebElement orig_Mater_Type1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l4 r4')]//select"));
			selectOptionByIndex(orig_Mater_Type1, 0);

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
			WebElement name1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l6 r6')]//input"));
			name1.sendKeys("A");
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
			WebElement qty1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l7 r7')]//input"));
			qty1.sendKeys("100");

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
			unitPrice1.sendKeys("10");

			WebElement UOM = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l12 r12')]"));
			j.executeScript("arguments[0].click();", UOM);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", UOM);
			} catch (StaleElementReferenceException e5) {
				UOM = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l12 r12')]"));
				j.executeScript("arguments[0].click();", UOM);
			}
			WebElement UOM1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l12 r12')]//select"));
			selectOptionByIndex(UOM1, 0);

			WebElement deliveryDate = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l13 r13')]"));
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

			WebElement checkBox = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l14 r14')]"));
			j.executeScript("arguments[0].click();", checkBox);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", checkBox);
			} catch (StaleElementReferenceException e5) {
				checkBox = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l14 r14')]"));
				j.executeScript("arguments[0].click();", checkBox);
			}
			WebElement checkBox1 = driver.findElement(
					By.xpath(".//div[contains (@class, 'slick-cell l14 r14')]//input[@type='checkbox']"));
			j.executeScript("arguments[0].click();", checkBox1);
			j.executeScript("arguments[0].click();", checkBox1);

			/*
			 *//*
				 * Withot IQC Checkbox code // WebElement insReason = driver
				 * .findElement(By.xpath(
				 * "//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[15]"));
				 * JavascriptExecutor j2 = (JavascriptExecutor) driver;
				 * j2.executeScript("arguments[0].click();", insReason); WebElement reasonText =
				 * driver.findElement( By.xpath(
				 * "//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[15]//input[@type='text']"
				 * )); reasonText.sendKeys("Not Required");
				 */
		}

		catch (StaleElementReferenceException e) {
		}
	}

	@When("User create the PO Request for PO ORDER \\(NPM)")
	public void user_create_the_po_request_for_po_order_npm() throws InterruptedException {
		try {

			WebElement purchaseOrderBtn = driver.findElement(By.xpath("(//a[contains(text(),'Purchase Order')])[1]"));
			purchaseOrderBtn.click();

			WebElement addBtn = driver.findElement(By.xpath("(//button[@title='Add' and @type='button'])[1]"));
			addBtn.click();
			Thread.sleep(1000);

			WebElement branch = (driver.findElement(By.xpath("(//select)[1]")));
			select(branch).selectByIndex(1);
			Thread.sleep(500);

			WebElement wareHouse = (driver.findElement(By.xpath("(//select)[2]")));
			select(wareHouse).selectByIndex(0);
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
			vendorField.sendKeys("A");
			Thread.sleep(500);

			List<WebElement> vendorList = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
			for (WebElement webElement : vendorList) {
				String list = webElement.getText();
				if (list.contains("A.K.INDUSTRIES")) {
					Thread.sleep(500);
					JavascriptExecutor k = (JavascriptExecutor) driver;
					k.executeScript("arguments[0].click();", webElement);
					System.out.println(webElement);
					break;
				}
				Thread.sleep(1000);
			}
//			try {
//				List<WebElement> vendorList1 = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
//				for (WebElement webElement1 : vendorList1) {
//					String list1 = webElement1.getText();
//					if (list1.contains("A.K.INDUSTRIES")) {
//						Thread.sleep(500);
//						JavascriptExecutor k = (JavascriptExecutor) driver;
//						k.executeScript("arguments[0].click();", webElement1);
//						System.out.println(webElement1);
//						break;
//					}
//					Thread.sleep(1000);
//				}
//			} catch (StaleElementReferenceException e) {
//			}

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

			// PO Order - NPM Type

			WebElement orderType = driver.findElement(By.xpath("(//select)[5]"));
			selectOptionByIndex(orderType, 0);

			WebElement materialType = driver.findElement(By.xpath("(//select)[6]"));
			selectOptionByIndex(materialType, 2);

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
			partNo1.sendKeys("A");
			WebElement autoSuggestion = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
			autoSuggestion.click();

			WebElement qty = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[5]"));
			JavascriptExecutor q = (JavascriptExecutor) driver;
			q.executeScript("arguments[0].click();", qty);
			Thread.sleep(500);
			try {
				q.executeScript("arguments[0].click();", qty);
			} catch (StaleElementReferenceException e3) {
				qty = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[5]"));
				q.executeScript("arguments[0].click();", qty);
			}
			WebElement qty1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[5]//input"));
			qty1.sendKeys("100");

			WebElement unitPrice = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[6]"));
			JavascriptExecutor u = (JavascriptExecutor) driver;
			u.executeScript("arguments[0].click();", unitPrice);
			Thread.sleep(500);
			try {
				u.executeScript("arguments[0].click();", unitPrice);
				Thread.sleep(500);
			} catch (StaleElementReferenceException e4) {
				unitPrice = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[6]"));
				u.executeScript("arguments[0].click();", unitPrice);
			}
			WebElement unitPrice1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[6]//input"));
			unitPrice1.sendKeys("10");

			WebElement UOM = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[10]"));
			JavascriptExecutor U = (JavascriptExecutor) driver;
			U.executeScript("arguments[0].click();", UOM);
			Thread.sleep(500);
			try {
				U.executeScript("arguments[0].click();", UOM);
			} catch (StaleElementReferenceException e5) {
				UOM = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[10]"));
				U.executeScript("arguments[0].click();", UOM);
			}
			WebElement UOM1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[10]//select"));
			selectOptionByIndex(UOM1, 0);

			WebElement deliveryDate = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[11]"));
			JavascriptExecutor d = (JavascriptExecutor) driver;
			d.executeScript("arguments[0].click();", deliveryDate);
			Thread.sleep(500);
			try {
				d.executeScript("arguments[0].click();", deliveryDate);
			} catch (StaleElementReferenceException e5) {
				deliveryDate = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[11]"));
				d.executeScript("arguments[0].click();", deliveryDate);
			}
			WebElement deliverDate1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[11]//input"));
			String date1 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			deliverDate1.sendKeys(date1);

			// With IQC checkbox code

			WebElement checkBox = driver
					.findElement(By.xpath("(//div[@id='form_grid_0']//div[@style='top:0px']//div)[12]"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", checkBox);
			Thread.sleep(500);
			try {
				js.executeScript("arguments[0].click();", checkBox);
			} catch (StaleElementReferenceException e5) {
				checkBox = driver.findElement(By.xpath("(//div[@id='form_grid_0']//div[@style='top:0px']//div)[12]"));
				js.executeScript("arguments[0].click();", checkBox);
			}
			WebElement checkBox1 = driver.findElement(
					By.xpath("(//div[@id='form_grid_0']//div[@style='top:0px']//div)[12]//input[@type='checkbox']"));
			JavascriptExecutor j1 = (JavascriptExecutor) driver;
			j1.executeScript("arguments[0].click();", checkBox1);
			JavascriptExecutor j2 = (JavascriptExecutor) driver;
			j2.executeScript("arguments[0].click();", checkBox1);

			/*
			 *//*
				 * Without IQC Checkbox code // WebElement insReason = driver
				 * .findElement(By.xpath(
				 * "//*(//div[@id='form_grid_0']//div[@style='top:0px']//div)[12]"));
				 * JavascriptExecutor j2 = (JavascriptExecutor) driver;
				 * j2.executeScript("arguments[0].click();", insReason); WebElement reasonText =
				 * driver.findElement( By.xpath(
				 * "//*(//div[@id='form_grid_0']//div[@style='top:0px']//div)[12]//input[@type='text']"
				 * )); reasonText.sendKeys("Not Required");
				 */
		}

		catch (StaleElementReferenceException e) {
		}
	}

	@Given("User click the Edit button and do the Unimportant changes \\(NPM)")
	public void user_click_the_edit_button_and_do_the_unimportant_changes_npm() throws InterruptedException {
		try {
			Thread.sleep(500);
			WebElement editBtn = driver.findElement(By.xpath("//table[@role='grid']//tbody//tr[1]//th//button[1]//i"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", editBtn);
			try {
				js.executeScript("arguments[0].click();", editBtn);
			} catch (StaleElementReferenceException e) {
				js.executeScript("arguments[0].click();", editBtn);
				editBtn = driver.findElement(By.xpath("//table[@role='grid']//tbody//tr[1]//th//button[1]//i"));
			}
			Thread.sleep(2000);

			WebElement remarks = driver
					.findElement(By.xpath("(//div[1]//input[@pattern='[a-zA-Z0-9*/\\s]+' and @type='text'])[1]"));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].scrollIntoView(true);", remarks);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("(//div[1]//input[@pattern='[a-zA-Z0-9*/\\s]+' and @type='text'])[1]")));
			remarks.sendKeys("Changed Part Number, Unit Price, Quantity and Delivery Date");
//		Thread.sleep(1000);

			// Grid Values
			WebElement costCenter = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l1 r1')]"));
			JavascriptExecutor c = (JavascriptExecutor) driver;
			c.executeScript("arguments[0].click();", costCenter);
			WebElement costCenter1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l1 r1')]//select"));
			selectOptionByIndex(costCenter1, 1);

			WebElement expenseCategory = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l2 r2')]"));
			JavascriptExecutor e = (JavascriptExecutor) driver;
			e.executeScript("arguments[0].click();", expenseCategory);
			WebElement expenseCategory1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l2 r2')]//select"));
			selectOptionByIndex(expenseCategory1, 0);

			WebElement UOM = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l10 r10')]"));
			JavascriptExecutor U = (JavascriptExecutor) driver;
			U.executeScript("arguments[0].click();", UOM);
			WebElement UOM1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l10 r10')]//select"));
			selectOptionByIndex(UOM1, 1);
		} catch (StaleElementReferenceException w3) {
		}
	}

	@Given("User click the Edit button and do the Required changes \\(NPM)")
	public void user_click_the_edit_button_and_do_the_required_changes_npm() throws InterruptedException {
		try {

			Thread.sleep(500);
			WebElement editBtn = driver.findElement(By.xpath("//table[@role='grid']//tbody//tr[1]//th//button[1]//i"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", editBtn);
			try {
				js.executeScript("arguments[0].click();", editBtn);
			} catch (StaleElementReferenceException q) {
				editBtn = driver.findElement(By.xpath("//table[@role='grid']//tbody//tr[1]//th//button[1]//i"));
				js.executeScript("arguments[0].click();", editBtn);
			}
			Thread.sleep(2000);

			WebElement remarks = driver
					.findElement(By.xpath("(//div[1]//input[@pattern='[a-zA-Z0-9*/\\s]+' and @type='text'])[1]"));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].scrollIntoView(true);", remarks);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("(//div[1]//input[@pattern='[a-zA-Z0-9*/\\s]+' and @type='text'])[1]")));
			remarks.sendKeys("Changed Part Number, Unit Price, Quantity and Delivery Date");
//		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"form_grid_0\\\"]/div[4]/div[3]/div/div/div[2]")));

			WebElement costCenter = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l1 r1')]"));
			JavascriptExecutor c = (JavascriptExecutor) driver;
			c.executeScript("arguments[0].click();", costCenter);
			WebElement costCenter1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l1 r1')]//select"));
			selectOptionByIndex(costCenter1, 1);

			WebElement expenseCategory = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l2 r2')]"));
			JavascriptExecutor e = (JavascriptExecutor) driver;
			e.executeScript("arguments[0].click();", expenseCategory);
			WebElement expenseCategory1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l2 r2')]//select"));
			selectOptionByIndex(expenseCategory1, 0);

			WebElement partNo = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l3 r3')]"));
			JavascriptExecutor p = (JavascriptExecutor) driver;
			p.executeScript("arguments[0].click();", partNo);
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement partNo1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l3 r3')]//input"));
			wait1.until(ExpectedConditions.visibilityOf(partNo1));
			partNo1.sendKeys("A");
			WebElement autoSuggestion = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
			p.executeScript("arguments[0].click();", autoSuggestion);

			WebElement qty = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l4 r4')]"));
			JavascriptExecutor q = (JavascriptExecutor) driver;
			q.executeScript("arguments[0].click();", qty);
			Thread.sleep(500);
			try {
				driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l4 r4')]"));
				q.executeScript("arguments[0].click();", qty);
			} catch (StaleElementReferenceException e8) {
				driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l4 r4')]"));
				q.executeScript("arguments[0].click();", qty);
			}
			WebElement qty1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l4 r4')]//input"));
			qty1.sendKeys("50");

			WebElement unitPrice = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l6 r6')]"));
			JavascriptExecutor u = (JavascriptExecutor) driver;
			u.executeScript("arguments[0].click();", unitPrice);
			Thread.sleep(500);
			try {
				driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l6 r6')]"));
				u.executeScript("arguments[0].click();", unitPrice);
			} catch (StaleElementReferenceException e9) {
				unitPrice = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l6 r6')]"));
				u.executeScript("arguments[0].click();", unitPrice);
			}
			WebElement unitPrice1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l6 r6')]//input"));
			unitPrice1.sendKeys("5");

			WebElement UOM = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l10 r10')]"));
			JavascriptExecutor U = (JavascriptExecutor) driver;
			U.executeScript("arguments[0].click();", UOM);
			Thread.sleep(500);
			try {
				driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l10 r10')]"));
				U.executeScript("arguments[0].click();", UOM);
			} catch (StaleElementReferenceException e10) {
				UOM = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l10 r10')]"));
				U.executeScript("arguments[0].click();", UOM);
			}
			WebElement UOM1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l10 r10')]//select"));
			selectOptionByIndex(UOM1, 1);

			WebElement deliveryDate = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l11 r11')]"));
			JavascriptExecutor d = (JavascriptExecutor) driver;
			d.executeScript("arguments[0].click();", deliveryDate);
			Thread.sleep(500);
			try {
				driver
				.findElement(By.xpath(".//div[contains (@class, 'slick-cell l11 r11')]"));
				d.executeScript("arguments[0].click();", deliveryDate);
			} catch (StaleElementReferenceException e11) {
				deliveryDate = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l11 r11')]"));
				d.executeScript("arguments[0].click();", deliveryDate);
			}
			WebElement deliverDate1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l11 r11')]//input"));
			String date1 = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			deliverDate1.sendKeys(date1);
		} catch (StaleElementReferenceException w) {
		}
	}

//	*************************************************************************************************************

	@When("User create the PO Request for WEB ORDER \\(RM)")
	public void user_create_the_po_request_for_web_order_rm() throws AWTException, InterruptedException {
		Robot r = new Robot();

		try {
			WebElement purchaseOrderBtn = driver.findElement(By.xpath("(//a[contains(text(),'Purchase Order')])[1]"));
			purchaseOrderBtn.click();

			WebElement addBtn = driver.findElement(By.xpath("(//button[@title='Add' and @type='button'])[1]"));
			addBtn.click();
			Thread.sleep(1000);

			WebElement branch = (driver.findElement(By.xpath("(//select)[1]")));
			select(branch).selectByIndex(1);
			Thread.sleep(500);

			WebElement wareHouse = (driver.findElement(By.xpath("(//select)[2]")));
			select(wareHouse).selectByIndex(0);
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
			vendorField.sendKeys("A");
			Thread.sleep(500);

			List<WebElement> vendorList = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
			for (WebElement webElement : vendorList) {
				String list = webElement.getText();
				if (list.contains("A.K.INDUSTRIES")) {
					Thread.sleep(500);
					JavascriptExecutor k = (JavascriptExecutor) driver;
					k.executeScript("arguments[0].click();", webElement);
					System.out.println(webElement);
					break;
				}
				Thread.sleep(1000);
			}
//			try {
//				List<WebElement> vendorList1 = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
//				for (WebElement webElement1 : vendorList1) {
//					String list1 = webElement1.getText();
//					if (list1.contains("A.K.INDUSTRIES")) {
//						Thread.sleep(500);
//						JavascriptExecutor k = (JavascriptExecutor) driver;
//						k.executeScript("arguments[0].click();", webElement1);
//						System.out.println(webElement1);
//						break;
//					}
//					Thread.sleep(1000);
//				}
//			} catch (StaleElementReferenceException e) {
//			}

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

			// Web Order - RM Type

			WebElement orderType = driver.findElement(By.xpath("(//select)[5]"));
			selectOptionByIndex(orderType, 1);

			WebElement materialType1 = driver.findElement(By.xpath("(//select)[6]"));
			selectOptionByIndex(materialType1, 0);

			WebElement jiraNumber2 = driver.findElement(By.xpath("(//input[@id='QuoteNo' and @type='text'])[1]"));
			jiraNumber2.sendKeys("12345");

			WebElement quoteNumber2 = driver.findElement(By.xpath("(//input[@id='JiraNo' and @type='text'])[1]"));
			quoteNumber2.sendKeys("54321");

			WebElement quoteDate2 = driver.findElement(By.xpath("(//input [@type='date'])[1]"));
			String quotedate3 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			quoteDate2.sendKeys(quotedate3);

			Select s6 = new Select(driver.findElement(By.xpath("(//select)[10]")));
			List<WebElement> options6 = s6.getOptions();
			WebElement approvalStatus2 = s6.getFirstSelectedOption();
			System.out.println("Approval Status : " + approvalStatus2.getText());
			Thread.sleep(1000);

			WebElement importBtn = driver.findElement(By.xpath("//button[@id='importbutton' and @type='button']"));
			importBtn.click();
			Thread.sleep(1000);
			r.keyPress(KeyEvent.VK_R);
			r.keyRelease(KeyEvent.VK_R);
			Thread.sleep(1000);
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(1000);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1200);
			WebElement msg = driver.findElement(By.xpath("(//app-alert//div)[1]"));
			System.out.println("PopUp Msg : " + msg.getText().toString());
			String popup = msg.getText().toString().trim();
			Thread.sleep(1000);

			if (popup.contentEquals("Importing in progress ... Please Wait ...")) {
				Thread.sleep(2000);
			}
			if (popup.contentEquals("Imported Successfully ...")) {
				System.out.println("Matched Successfully");
				Thread.sleep(1000);
			} else {
				System.out.println("Not Matching");
			}
		} catch (StaleElementReferenceException e) {
		}
	}

	@When("User create the PO Request for WEB ORDER \\(FG)")
	public void user_create_the_po_request_for_web_order_fg() throws AWTException, InterruptedException {
		Robot r = new Robot();

		try {
			WebElement purchaseOrderBtn = driver.findElement(By.xpath("(//a[contains(text(),'Purchase Order')])[1]"));
			purchaseOrderBtn.click();

			WebElement addBtn = driver.findElement(By.xpath("(//button[@title='Add' and @type='button'])[1]"));
			addBtn.click();
			Thread.sleep(1000);

			WebElement branch = (driver.findElement(By.xpath("(//select)[1]")));
			select(branch).selectByIndex(1);
			Thread.sleep(500);

			WebElement wareHouse = (driver.findElement(By.xpath("(//select)[2]")));
			select(wareHouse).selectByIndex(0);
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
			vendorField.sendKeys("A");
			Thread.sleep(500);

			List<WebElement> vendorList = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
			for (WebElement webElement : vendorList) {
				String list = webElement.getText();
				if (list.contains("A.K.INDUSTRIES")) {
					Thread.sleep(500);
					JavascriptExecutor k = (JavascriptExecutor) driver;
					k.executeScript("arguments[0].click();", webElement);
					System.out.println(webElement);
					break;
				}
				Thread.sleep(1000);
			}
//			try {
//				List<WebElement> vendorList1 = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
//				for (WebElement webElement1 : vendorList1) {
//					String list1 = webElement1.getText();
//					if (list1.contains("A.K.INDUSTRIES")) {
//						Thread.sleep(500);
//						JavascriptExecutor k = (JavascriptExecutor) driver;
//						k.executeScript("arguments[0].click();", webElement1);
//						System.out.println(webElement1);
//						break;
//					}
//					Thread.sleep(1000);
//				}
//			} catch (StaleElementReferenceException e) {
//			}

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

			// Web Order - FG Type

			WebElement orderType = driver.findElement(By.xpath("(//select)[5]"));
			selectOptionByIndex(orderType, 1);

			WebElement materialType1 = driver.findElement(By.xpath("(//select)[6]"));
			selectOptionByIndex(materialType1, 1);

			WebElement jiraNumber2 = driver.findElement(By.xpath("(//input[@id='QuoteNo' and @type='text'])[1]"));
			jiraNumber2.sendKeys("12345");

			WebElement quoteNumber2 = driver.findElement(By.xpath("(//input[@id='JiraNo' and @type='text'])[1]"));
			quoteNumber2.sendKeys("54321");

			WebElement quoteDate2 = driver.findElement(By.xpath("(//input [@type='date'])[1]"));
			String quotedate3 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			quoteDate2.sendKeys(quotedate3);

			Select s6 = new Select(driver.findElement(By.xpath("(//select)[10]")));
			List<WebElement> options6 = s6.getOptions();
			WebElement approvalStatus2 = s6.getFirstSelectedOption();
			System.out.println("Approval Status : " + approvalStatus2.getText());
			Thread.sleep(1000);

			WebElement importBtn = driver.findElement(By.xpath("//button[@id='importbutton' and @type='button']"));
			importBtn.click();
			Thread.sleep(1000);
			r.keyPress(KeyEvent.VK_F);
			r.keyRelease(KeyEvent.VK_F);
			r.keyPress(KeyEvent.VK_G);
			r.keyRelease(KeyEvent.VK_G);
			Thread.sleep(1000);
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(1000);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1200);
			WebElement msg = driver.findElement(By.xpath("(//app-alert//div)[1]"));
			System.out.println("PopUp Msg : " + msg.getText().toString());
			String popup = msg.getText().toString().trim();
			Thread.sleep(1000);

			if (popup.contentEquals("Importing in progress ... Please Wait ...")) {
				Thread.sleep(2000);
			}
			if (popup.contentEquals("Imported Successfully ...")) {
				System.out.println("Matched Successfully");
				Thread.sleep(1000);
			} else {
				System.out.println("Not Matching");
			}
		} catch (StaleElementReferenceException e1) {
		}
	}

	@When("User create the PO Request for WEB ORDER \\(NPM)")
	public void user_create_the_po_request_for_web_order_npm() throws InterruptedException {
		try {

			WebElement purchaseOrderBtn = driver.findElement(By.xpath("(//a[contains(text(),'Purchase Order')])[1]"));
			purchaseOrderBtn.click();

			WebElement addBtn = driver.findElement(By.xpath("(//button[@title='Add' and @type='button'])[1]"));
			addBtn.click();
			Thread.sleep(1000);

			WebElement branch = (driver.findElement(By.xpath("(//select)[1]")));
			select(branch).selectByIndex(1);
			Thread.sleep(500);

			WebElement wareHouse = (driver.findElement(By.xpath("(//select)[2]")));
			select(wareHouse).selectByIndex(0);
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
			vendorField.sendKeys("A");
			Thread.sleep(500);

			List<WebElement> vendorList = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
			for (WebElement webElement : vendorList) {
				String list = webElement.getText();
				if (list.contains("A.K.INDUSTRIES")) {
					Thread.sleep(500);
					JavascriptExecutor k = (JavascriptExecutor) driver;
					k.executeScript("arguments[0].click();", webElement);
					System.out.println(webElement);
					break;
				}
				Thread.sleep(1000);
			}
//			try {
//				List<WebElement> vendorList1 = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
//				for (WebElement webElement1 : vendorList1) {
//					String list1 = webElement1.getText();
//					if (list1.contains("A.K.INDUSTRIES")) {
//						Thread.sleep(500);
//						JavascriptExecutor k = (JavascriptExecutor) driver;
//						k.executeScript("arguments[0].click();", webElement1);
//						System.out.println(webElement1);
//						break;
//					}
//					Thread.sleep(1000);
//				}
//			} catch (StaleElementReferenceException e) {
//			}

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

			// PO Order - NPM Type

			WebElement orderType = driver.findElement(By.xpath("(//select)[5]"));
			selectOptionByIndex(orderType, 1);

			WebElement materialType = driver.findElement(By.xpath("(//select)[6]"));
			selectOptionByIndex(materialType, 2);

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
			partNo1.sendKeys("A");
			WebElement autoSuggestion = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
			autoSuggestion.click();

			WebElement qty = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[5]"));
			JavascriptExecutor q = (JavascriptExecutor) driver;
			q.executeScript("arguments[0].click();", qty);
			Thread.sleep(500);
			try {
				q.executeScript("arguments[0].click();", qty);
				Thread.sleep(500);
			} catch (StaleElementReferenceException e3) {
				qty = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[5]"));
				q.executeScript("arguments[0].click();", qty);
			}
			WebElement qty1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[5]//input"));
			qty1.sendKeys("100");

			WebElement unitPrice = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[6]"));
			JavascriptExecutor u = (JavascriptExecutor) driver;
			u.executeScript("arguments[0].click();", unitPrice);
			Thread.sleep(500);
			try {
				u.executeScript("arguments[0].click();", unitPrice);
				Thread.sleep(500);
			} catch (StaleElementReferenceException e4) {
				unitPrice = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[6]"));
				u.executeScript("arguments[0].click();", unitPrice);
			}
			WebElement unitPrice1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[6]//input"));
			unitPrice1.sendKeys("10");

			WebElement UOM = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[10]"));
			JavascriptExecutor U = (JavascriptExecutor) driver;
			U.executeScript("arguments[0].click();", UOM);
			Thread.sleep(500);
			try {
				U.executeScript("arguments[0].click();", UOM);
				Thread.sleep(500);
			} catch (StaleElementReferenceException e5) {
				UOM = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[10]"));
				U.executeScript("arguments[0].click();", UOM);
			}
			WebElement UOM1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[10]//select"));
			selectOptionByIndex(UOM1, 0);

			WebElement deliveryDate = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[11]"));
			JavascriptExecutor d = (JavascriptExecutor) driver;
			d.executeScript("arguments[0].click();", deliveryDate);
			Thread.sleep(500);
			try {
				d.executeScript("arguments[0].click();", deliveryDate);
				Thread.sleep(500);
			} catch (StaleElementReferenceException e5) {
				deliveryDate = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[11]"));
				d.executeScript("arguments[0].click();", deliveryDate);
			}
			WebElement deliverDate1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[11]//input"));
			String date1 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			deliverDate1.sendKeys(date1);

			// With IQC checkbox code

			WebElement checkBox = driver
					.findElement(By.xpath("(//div[@id='form_grid_0']//div[@style='top:0px']//div)[12]"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", checkBox);
			Thread.sleep(500);
			try {
				js.executeScript("arguments[0].click();", checkBox);
			} catch (StaleElementReferenceException e5) {
				checkBox = driver.findElement(By.xpath("(//div[@id='form_grid_0']//div[@style='top:0px']//div)[12]"));
				js.executeScript("arguments[0].click();", checkBox);
			}
			WebElement checkBox1 = driver.findElement(
					By.xpath("(//div[@id='form_grid_0']//div[@style='top:0px']//div)[12]//input[@type='checkbox']"));
			JavascriptExecutor j1 = (JavascriptExecutor) driver;
			j1.executeScript("arguments[0].click();", checkBox1);
			JavascriptExecutor j2 = (JavascriptExecutor) driver;
			j2.executeScript("arguments[0].click();", checkBox1);

			/*
			 *//*
				 * Without IQC Checkbox code // WebElement insReason = driver
				 * .findElement(By.xpath(
				 * "//*(//div[@id='form_grid_0']//div[@style='top:0px']//div)[12]"));
				 * JavascriptExecutor j2 = (JavascriptExecutor) driver;
				 * j2.executeScript("arguments[0].click();", insReason); WebElement reasonText =
				 * driver.findElement( By.xpath(
				 * "//*(//div[@id='form_grid_0']//div[@style='top:0px']//div)[12]//input[@type='text']"
				 * )); reasonText.sendKeys("Not Required");
				 */
		}

		catch (StaleElementReferenceException e) {
		}
	}

	@When("User create the PO Request for Testing and Services")
	public void user_create_the_po_request_for_testing_and_services() throws InterruptedException {
		try {

			WebElement purchaseOrderBtn = driver.findElement(By.xpath("(//a[contains(text(),'Purchase Order')])[1]"));
			purchaseOrderBtn.click();

			WebElement addBtn = driver.findElement(By.xpath("(//button[@title='Add' and @type='button'])[1]"));
			addBtn.click();
			Thread.sleep(1000);

			WebElement branch = (driver.findElement(By.xpath("(//select)[1]")));
			select(branch).selectByIndex(1);
			Thread.sleep(500);

			WebElement wareHouse = (driver.findElement(By.xpath("(//select)[2]")));
			select(wareHouse).selectByIndex(0);
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
			vendorField.sendKeys("A");
			Thread.sleep(500);

			List<WebElement> vendorList = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
			for (WebElement webElement : vendorList) {
				String list = webElement.getText();
				if (list.contains("A.K.INDUSTRIES")) {
					Thread.sleep(500);
					JavascriptExecutor k = (JavascriptExecutor) driver;
					k.executeScript("arguments[0].click();", webElement);
					System.out.println(webElement);
					break;
				}
				Thread.sleep(1000);
			}
//			try {
//				List<WebElement> vendorList1 = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
//				for (WebElement webElement1 : vendorList1) {
//					String list1 = webElement1.getText();
//					if (list1.contains("A.K.INDUSTRIES")) {
//						Thread.sleep(500);
//						JavascriptExecutor k = (JavascriptExecutor) driver;
//						k.executeScript("arguments[0].click();", webElement1);
//						System.out.println(webElement1);
//						break;
//					}
//					Thread.sleep(1000);
//				}
//			} catch (StaleElementReferenceException e) {
//			}

			Select s1 = new Select(driver.findElement(By.xpath("(//select)[6]")));
			List<WebElement> options1 = s1.getOptions();
			WebElement paymentTerms = s1.getFirstSelectedOption();
			System.out.println("Payment Terms : " + paymentTerms.getText());

			Select s2 = new Select(driver.findElement(By.xpath("(//select)[7]")));
			List<WebElement> options2 = s2.getOptions();
			WebElement paymentMode = s2.getFirstSelectedOption();
			System.out.println("Payment Mode : " + paymentMode.getText());

			Select s3 = new Select(driver.findElement(By.xpath("(//select)[8]")));
			List<WebElement> options3 = s3.getOptions();
			WebElement poOwner = s3.getFirstSelectedOption();
			System.out.println("PO Owner : " + poOwner.getText());

			// Testing & Services

			WebElement orderType = driver.findElement(By.xpath("(//select)[5]"));
			selectOptionByIndex(orderType, 2);

			WebElement jiraNumber = driver.findElement(By.xpath("(//input[@id='JiraNo' and @type='text'])[1]"));
			jiraNumber.sendKeys("12345");

			WebElement quoteNumber = driver.findElement(By.xpath("(//input[@id='QuoteNo' and @type='text'])[1]"));
			quoteNumber.sendKeys("54321");

			WebElement quoteDate = driver.findElement(By.xpath("(//input [@type='date'])[1]"));
			String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			quoteDate.sendKeys(date);

			Select s4 = new Select(driver.findElement(By.xpath("(//select)[9]")));
			List<WebElement> options4 = s4.getOptions();
			WebElement approvalStatus = s4.getFirstSelectedOption();
			System.out.println("Approval Status : " + approvalStatus.getText());
			Thread.sleep(1000);

			// Grid Values

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

			WebElement workType = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[4]"));
			JavascriptExecutor w = (JavascriptExecutor) driver;
			w.executeScript("arguments[0].click();", workType);
			Thread.sleep(500);
			try {
				w.executeScript("arguments[0].click();", workType);
			} catch (StaleElementReferenceException e1) {
				workType = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[4]"));
				w.executeScript("arguments[0].click();", workType);
			}
			WebElement workType1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[4]//select"));
			selectOptionByIndex(workType1, 0);

			WebElement name = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[5]"));
			JavascriptExecutor n = (JavascriptExecutor) driver;
			n.executeScript("arguments[0].click();", name);
			Thread.sleep(500);
			try {
				n.executeScript("arguments[0].click();", name);
			} catch (StaleElementReferenceException e2) {
				name = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[5]"));
				n.executeScript("arguments[0].click();", name);
			}
			Thread.sleep(1000);
			WebElement name1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[5]//input"));
			name1.sendKeys("A");
			WebElement autoSuggestion1 = driver.findElement(By.xpath("//*[@class='ui-menu-item'][1]"));
			autoSuggestion1.click();

			WebElement serviceDesc = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[6]"));
			JavascriptExecutor se = (JavascriptExecutor) driver;
			se.executeScript("arguments[0].click();", serviceDesc);
			Thread.sleep(500);
			try {
				se.executeScript("arguments[0].click();", serviceDesc);
			} catch (StaleElementReferenceException e2) {
				serviceDesc = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[6]"));
				se.executeScript("arguments[0].click();", serviceDesc);
			}
			Thread.sleep(1000);
			WebElement serviceDesc1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[6]//input"));
			serviceDesc1.sendKeys("Testing and Services");

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
			qty1.sendKeys("100");

			WebElement unitPrice = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[8]"));
			JavascriptExecutor u = (JavascriptExecutor) driver;
			u.executeScript("arguments[0].click();", unitPrice);
			Thread.sleep(500);
			try {
				u.executeScript("arguments[0].click();", unitPrice);
			} catch (StaleElementReferenceException e4) {
				unitPrice = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[8]"));
				u.executeScript("arguments[0].click();", unitPrice);
			}
			WebElement unitPrice1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[8]//input"));
			unitPrice1.sendKeys("10");

			WebElement UOM = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[10]"));
			JavascriptExecutor U = (JavascriptExecutor) driver;
			U.executeScript("arguments[0].click();", UOM);
			Thread.sleep(500);
			try {
				U.executeScript("arguments[0].click();", UOM);
			} catch (StaleElementReferenceException e5) {
				UOM = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[10]"));
				U.executeScript("arguments[0].click();", UOM);
			}
			WebElement UOM1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[10]//select"));
			selectOptionByIndex(UOM1, 0);

			WebElement deliveryDate = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[11]"));
			JavascriptExecutor d = (JavascriptExecutor) driver;
			d.executeScript("arguments[0].click();", deliveryDate);
			Thread.sleep(500);
			try {
				d.executeScript("arguments[0].click();", deliveryDate);
			} catch (StaleElementReferenceException e5) {
				deliveryDate = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[11]"));
				d.executeScript("arguments[0].click();", deliveryDate);
			}
			WebElement deliverDate1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[11]//input"));
			String date1 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			deliverDate1.sendKeys(date1);

			// With IQC checkbox code

			WebElement checkBox = driver
					.findElement(By.xpath("(//div[@id='form_grid_0']//div[@style='top:0px']//div)[12]"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", checkBox);
			Thread.sleep(500);
			try {
				js.executeScript("arguments[0].click();", checkBox);
			} catch (StaleElementReferenceException e5) {
				checkBox = driver.findElement(By.xpath("(//div[@id='form_grid_0']//div[@style='top:0px']//div)[12]"));
				js.executeScript("arguments[0].click();", checkBox);
			}
			WebElement checkBox1 = driver.findElement(
					By.xpath("(//div[@id='form_grid_0']//div[@style='top:0px']//div)[12]//input[@type='checkbox']"));
			JavascriptExecutor j1 = (JavascriptExecutor) driver;
			j1.executeScript("arguments[0].click();", checkBox1);
			JavascriptExecutor j2 = (JavascriptExecutor) driver;
			j2.executeScript("arguments[0].click();", checkBox1);

			/*
			 *//*
				 * Withot IQC Checkbox code // WebElement insReason = driver
				 * .findElement(By.xpath(
				 * "//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[15]"));
				 * JavascriptExecutor j2 = (JavascriptExecutor) driver;
				 * j2.executeScript("arguments[0].click();", insReason); WebElement reasonText =
				 * driver.findElement( By.xpath(
				 * "//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[15]//input[@type='text']"
				 * )); reasonText.sendKeys("Not Required");
				 */
		}

		catch (StaleElementReferenceException e) {
		}
	}

	@Given("User click the Edit button and do the Unimportant changes for Testing and Services")
	public void user_click_the_edit_button_and_do_the_unimportant_changes_for_testing_and_services()
			throws InterruptedException {
		try {
			Thread.sleep(500);
			WebElement editBtn = driver.findElement(By.xpath("//table[@role='grid']//tbody//tr[1]//th//button[1]//i"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", editBtn);
			try {
				js.executeScript("arguments[0].click();", editBtn);
			} catch (StaleElementReferenceException e) {
				js.executeScript("arguments[0].click();", editBtn);
				editBtn = driver.findElement(By.xpath("//table[@role='grid']//tbody//tr[1]//th//button[1]//i"));
			}
			Thread.sleep(2000);

			WebElement remarks = driver
					.findElement(By.xpath("(//div[1]//input[@pattern='[a-zA-Z0-9*/\\s]+' and @type='text'])[1]"));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].scrollIntoView(true);", remarks);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("(//div[1]//input[@pattern='[a-zA-Z0-9*/\\s]+' and @type='text'])[1]")));
			remarks.sendKeys("Changed Part Number, Unit Price, Quantity and Delivery Date");

			// Grid Fields
			WebElement costCenter = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[2]"));
			JavascriptExecutor c = (JavascriptExecutor) driver;
			c.executeScript("arguments[0].click();", costCenter);
			WebElement costCenter1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[2]//select"));
			selectOptionByIndex(costCenter1, 1);

			WebElement expenseCategory = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[3]"));
			JavascriptExecutor e = (JavascriptExecutor) driver;
			e.executeScript("arguments[0].click();", expenseCategory);
			WebElement expenseCategory1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[3]//select"));
			selectOptionByIndex(expenseCategory1, 1);

			WebElement UOM = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[10]"));
			JavascriptExecutor U = (JavascriptExecutor) driver;
			U.executeScript("arguments[0].click();", UOM);
			WebElement UOM1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[10]//select"));
			selectOptionByIndex(UOM1, 1);
		} catch (StaleElementReferenceException w3) {
		}
	}

	@Given("User click the Edit button and do the Required changes for Testing and Services")
	public void user_click_the_edit_button_and_do_the_required_changes_for_testing_and_services()
			throws InterruptedException {
		try {

			Thread.sleep(500);
			WebElement editBtn = driver.findElement(By.xpath("//table[@role='grid']//tbody//tr[1]//th//button[1]//i"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", editBtn);
			try {
				js.executeScript("arguments[0].click();", editBtn);
			} catch (StaleElementReferenceException q) {
				editBtn = driver.findElement(By.xpath("//table[@role='grid']//tbody//tr[1]//th//button[1]//i"));
				js.executeScript("arguments[0].click();", editBtn);
			}
			Thread.sleep(2000);

			WebElement remarks = driver
					.findElement(By.xpath("(//div[1]//input[@pattern='[a-zA-Z0-9*/\\s]+' and @type='text'])[1]"));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].scrollIntoView(true);", remarks);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("(//div[1]//input[@pattern='[a-zA-Z0-9*/\\s]+' and @type='text'])[1]")));
			remarks.sendKeys("Changed Part Number, Unit Price, Quantity and Delivery Date");

			// Grid Fields
			WebElement costCenter = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[2]"));
			JavascriptExecutor c = (JavascriptExecutor) driver;
			c.executeScript("arguments[0].click();", costCenter);
			WebElement costCenter1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[2]//select"));
			selectOptionByIndex(costCenter1, 0);

			WebElement expenseCategory = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[3]"));
			JavascriptExecutor e = (JavascriptExecutor) driver;
			e.executeScript("arguments[0].click();", expenseCategory);
			WebElement expenseCategory1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[3]//select"));
			selectOptionByIndex(expenseCategory1, 0);

			WebElement workType = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[4]"));
			JavascriptExecutor w = (JavascriptExecutor) driver;
			w.executeScript("arguments[0].click();", workType);
			Thread.sleep(500);
			try {
				w.executeScript("arguments[0].click();", workType);
			} catch (StaleElementReferenceException e1) {
				workType = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[4]"));
				w.executeScript("arguments[0].click();", workType);
			}
			WebElement workType1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[4]//select"));
			selectOptionByIndex(workType1, 1);

			WebElement name = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[5]"));
			JavascriptExecutor n = (JavascriptExecutor) driver;
			n.executeScript("arguments[0].click();", name);
			Thread.sleep(500);
			try {
				n.executeScript("arguments[0].click();", name);
			} catch (StaleElementReferenceException e2) {
				name = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[5]"));
				n.executeScript("arguments[0].click();", name);
			}
			Thread.sleep(1000);
			WebElement name1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[5]//input"));
			name1.sendKeys("S");
			WebElement autoSuggestion1 = driver.findElement(By.xpath("//*[@class='ui-menu-item'][1]"));
			autoSuggestion1.click();

			WebElement qty = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[7]"));
			JavascriptExecutor q = (JavascriptExecutor) driver;
			q.executeScript("arguments[0].click();", qty);
			Thread.sleep(500);
			try {
				q.executeScript("arguments[0].click();", qty);
			} catch (StaleElementReferenceException e8) {
				qty = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[7]"));
				q.executeScript("arguments[0].click();", qty);
			}
			WebElement qty1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[7]//input"));
			qty1.sendKeys("50");

			WebElement unitPrice = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[8]"));
			JavascriptExecutor u = (JavascriptExecutor) driver;
			u.executeScript("arguments[0].click();", unitPrice);
			Thread.sleep(500);
			try {
				u.executeScript("arguments[0].click();", unitPrice);
			} catch (StaleElementReferenceException e9) {
				unitPrice = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[8]"));
				u.executeScript("arguments[0].click();", unitPrice);
			}
			WebElement unitPrice1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[8]//input"));
			unitPrice1.sendKeys("5");

			WebElement UOM = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[10]"));
			JavascriptExecutor U = (JavascriptExecutor) driver;
			U.executeScript("arguments[0].click();", UOM);
			Thread.sleep(500);
			try {
				U.executeScript("arguments[0].click();", UOM);
			} catch (StaleElementReferenceException e10) {
				UOM = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[10]"));
				U.executeScript("arguments[0].click();", UOM);
			}
			WebElement UOM1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[10]//select"));
			selectOptionByIndex(UOM1, 1);

			WebElement deliveryDate = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[11]"));
			JavascriptExecutor d = (JavascriptExecutor) driver;
			d.executeScript("arguments[0].click();", deliveryDate);
			Thread.sleep(500);
			try {
				d.executeScript("arguments[0].click();", deliveryDate);
			} catch (StaleElementReferenceException e11) {
				deliveryDate = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[11]"));
				d.executeScript("arguments[0].click();", deliveryDate);
			}
			WebElement deliverDate1 = driver
					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[11]//input"));
			String date1 = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			deliverDate1.sendKeys(date1);
		} catch (StaleElementReferenceException w) {
		}
	}

}
