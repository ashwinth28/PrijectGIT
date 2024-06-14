package ecERP.Alloc_Proto;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import javax.swing.text.AbstractDocument.Content;

import org.apache.velocity.app.event.implement.EscapeJavaScriptReference;
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

import com.google.gson.annotations.Until;

import dev.failsafe.TimeoutExceededException;
import ecERP.libglobal.LibGlobal;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class Alloc_Proto_RM_StepDefinition extends LibGlobal {

	public static WebDriver driver;
	public String popup1;
	public int lastAppearedIndex;

	@Given("User on the login page")
	public void user_on_the_login_page() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
//		driver.get("https://qa-erp.e-consystems.net");
		driver.get("http://localhost:8080/#/login");
//		driver.get("https://stage-erp.e-consystems.net/#/login");
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

	@Given("User enters the PM Team Member {string} and {string}")
	public void user_enters_the_PM_Team_Member_and(String username, String password) {
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

	@When("User create the Allocation Proto-RM Request")
	public void user_create_the_allocation_proto_rm_request() throws InterruptedException {

		WebElement issuesBtn = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(issuesBtn,
				By.xpath("(//a[contains(text(),'Issues')])[1]")));
		issuesBtn.click();

		WebElement addBtn = driver.findElement(By.xpath("(//button[@title='Add' and @type='button'])[1]"));
		addBtn.click();
		Thread.sleep(1000);

		WebElement requestType = (driver.findElement(By.xpath("(//select)[1]")));
		select(requestType).selectByIndex(11);
		Thread.sleep(500);

		WebElement allocationRefNo = driver.findElement(
				By.xpath("(//div//app-form-text//div//input[@tooltipposition='bottom' and @type='text'])[1]"));
		if (allocationRefNo.isEnabled()) {
			System.out.println("Allocation Reference No Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Allocation Reference No : " + allocationRefNo.getAttribute("value"));
		}

		WebElement branch = driver.findElement(By.xpath("(//select)[2]"));
		if (branch.isEnabled()) {
			System.out.println("Branch Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Branch : " + branch.getAttribute("value"));
		}

		WebElement wareHouse = (driver.findElement(By.xpath("(//select)[3]")));
		select(wareHouse).selectByIndex(0);

		WebElement store = driver.findElement(By.xpath("(//select)[4]"));
		if (store.isEnabled()) {
			System.out.println("Store Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Store : " + store.getAttribute("value"));
		}

		WebElement costCenter = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		costCenter.sendKeys("P");
		Thread.sleep(500);

		List<WebElement> costCenterList = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
		for (WebElement webElement : costCenterList) {
			String list = webElement.getText();
			if (list.contains("Production")) {
				Thread.sleep(500);
				JavascriptExecutor k = (JavascriptExecutor) driver;
				k.executeScript("arguments[0].click();", webElement);
				System.out.println(webElement);
				break;
			}
			Thread.sleep(1000);
		}

		WebElement subCostCenter = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
		subCostCenter.sendKeys("P");
		Thread.sleep(500);

		List<WebElement> subCostCenterList = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
		for (WebElement webElement : subCostCenterList) {
			String list = webElement.getText();
			if (list.contains("Production Materials")) {
				Thread.sleep(500);
				JavascriptExecutor k = (JavascriptExecutor) driver;
				k.executeScript("arguments[0].click();", webElement);
				System.out.println(webElement);
				break;
			}
			Thread.sleep(1000);
		}

		WebElement projectName = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
		projectName.sendKeys("S");
		Thread.sleep(500);

		List<WebElement> projectNameList = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
		for (WebElement webElement : projectNameList) {
			String list = webElement.getText();
			if (list.contains("Sabik")) {
				Thread.sleep(500);
				JavascriptExecutor k = (JavascriptExecutor) driver;
				k.executeScript("arguments[0].click();", webElement);
				System.out.println(webElement);
				break;
			}
			Thread.sleep(1000);
		}

		WebElement productCode = driver.findElement(By.xpath("(//input[@type='text'])[5]"));
		productCode.sendKeys("S");
		Thread.sleep(500);

		List<WebElement> productCodeList = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
		for (WebElement webElement : productCodeList) {
			String list = webElement.getText();
			if (list.contains("See3CAM_160")) {
				Thread.sleep(500);
				JavascriptExecutor k = (JavascriptExecutor) driver;
				k.executeScript("arguments[0].click();", webElement);
				System.out.println(webElement);
				break;
			}
			Thread.sleep(1000);
		}

		WebElement customerName = driver.findElement(By.xpath("(//input[@type='text'])[6]"));
		customerName.sendKeys("A");
		Thread.sleep(500);

		List<WebElement> customerNameList = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
		for (WebElement webElement : customerNameList) {
			String list = webElement.getText();
			if (list.contains("A La Carte Media")) {
				Thread.sleep(500);
				JavascriptExecutor k = (JavascriptExecutor) driver;
				k.executeScript("arguments[0].click();", webElement);
				System.out.println(webElement);
				break;
			}
			Thread.sleep(1000);
		}

		WebElement jiraNumber = driver.findElement(By.xpath("(//input[@id='JiraNo' and @type='text'])[1]"));
		jiraNumber.sendKeys("12345");

		WebElement consumptionDate = driver.findElement(By.xpath("(//input [@type='date'])[1]"));
		String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		consumptionDate.sendKeys(date);

		WebElement protoProductCode = driver.findElement(By.xpath("(//app-form-text//div//input[@type='text'])[3]"));
		if (protoProductCode.isEnabled()) {
			System.out.println("Proto Product Code Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Proto Product Code : Field is Disabled as Expected");
		}

		WebElement initialFGQty = driver.findElement(By.xpath("(//app-form-text//div//input[@type='text'])[4]"));
		if (initialFGQty.isEnabled()) {
			System.out.println("Initial FG Quantity Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Initial FG Quantity : Field is Disabled as Expected");
		}

		WebElement currentFGQty = driver.findElement(By.xpath("(//app-form-text//div//input[@type='text'])[5]"));
		if (currentFGQty.isEnabled()) {
			System.out.println("Current FG Quantity Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Current FG Quantity : Field is Disabled as Expected");
		}

		WebElement requestor = driver.findElement(By.xpath("(//select)[5]"));
		if (requestor.isEnabled()) {
			System.out.println("Requestor Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Requestor : " + requestor.getAttribute("value"));
		}

		WebElement initialRequestDate = driver.findElement(By.xpath("(//app-form-text//div//input[@type='text'])[6]"));
		if (initialRequestDate.isEnabled()) {
			System.out.println("Initial Request Date Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Initial Request Date : " + initialRequestDate.getAttribute("value"));
		}

		WebElement initialRequestTime = driver.findElement(By.xpath("(//app-form-text//div//input[@type='text'])[7]"));
		if (initialRequestTime.isEnabled()) {
			System.out.println("Initial Request Time Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Initial Request Time : " + initialRequestTime.getAttribute("value"));
		}

		WebElement revisionNo = driver.findElement(By.xpath("(//app-form-text//div//input[@type='text'])[8]"));
		if (revisionNo.isEnabled()) {
			System.out.println("Revision No Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Revision No : Field is Disabled as Expected");
		}

		WebElement issueStatus = driver.findElement(By.xpath("(//app-form-text//div//input[@type='text'])[9]"));
		if (issueStatus.isEnabled()) {
			System.out.println("Issue Status Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Issue Status : " + issueStatus.getAttribute("value"));
		}

	}

	@When("User click on the Import button")
	public void user_click_on_the_import_button() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement importBtn = driver.findElement(By.id("importbutton"));
		wait.until(ExpectedConditions.elementToBeClickable(importBtn));
		importBtn.click();
		Thread.sleep(1500);
	}

	@When("User enters the BOM1 Name")
	public void user_enters_the_bom1_name() throws InterruptedException, AWTException {
//		try {
//			Robot robot = new Robot();
//			
//			typeSentence(robot, "e-CAM30");
//
//		} catch (AWTException e) {
//			e.printStackTrace();
//		}
//		robotKeyDown();

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_B);
		r.keyRelease(KeyEvent.VK_B);
		r.keyPress(KeyEvent.VK_O);
		r.keyRelease(KeyEvent.VK_O);
		r.keyPress(KeyEvent.VK_M);
		r.keyRelease(KeyEvent.VK_M);
		r.keyPress(KeyEvent.VK_1);
		r.keyRelease(KeyEvent.VK_1);
		Thread.sleep(500);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(500);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1200);

		WebElement msg = driver.findElement(By.xpath("(//app-alert//div)[1]"));
		System.out.println("PopUp Msg : " + msg.getText().toString());
		String popup = msg.getText().toString().trim();
		Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		if (popup.contentEquals("Importing in progress ... Please Wait ...")) {
			Thread.sleep(3000);
		}
		wait.until(ExpectedConditions.textToBe(By.xpath("(//app-alert//div)[1]"), "   Imported Successfully"));
		if (popup.contentEquals("Imported Successfully")) {
			System.out.println("Matched Successfully");
			Thread.sleep(1000);
		} else {
			System.out.println("Not Matching");
		}

//		// Set the maximum number of popups to check
//		int maxPopups = 2;
//		int popupCount = 0;
//
//		// Continuously check for error popups
//		while (popupCount < maxPopups) {
//			// Check if the error popup is present
//			List<WebElement> errorPopups = driver.findElements(msg);
//
//			if (!errorPopups.isEmpty()) {
//				for (WebElement errorPopup : errorPopups) {
//					String popupText = errorPopup.getText();
//					System.out.println("Error popup #" + (popupCount + 1) + " text" + popupText);
//
//					// Increment the popup count
//					popupCount++;
//				}
//			} else {
//				// Error popup is not present
//				System.out.println("No error popup found. Waiting...");
//
//				// You may want to add a wait here to avoid constant checking and reduce
//				// resource usage
//				try {
//					Thread.sleep(1000); // Sleep for 1 second
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
	}

	@When("User accepts the Alert")
	public void user_accepts_the_alert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	@When("User click on the Save button")
	public void user_click_on_the_Save_button() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebElement saveButton = driver.findElement(By.xpath("(//button[@id='submitbutton' and @type='submit'])"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		j.executeScript("arguments[0].scrollIntoView(true);", saveButton);
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

	@When("User select the Production status from the filter")
	public void user_select_the_production_status_from_the_filter() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement issuesBtn = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		j.executeScript("window.scrollTo(0,0);", issuesBtn);
		wait.until(ExpectedConditions.elementToBeClickable(issuesBtn));
		j.executeScript("arguments[0].click();", issuesBtn);
		WebElement store = driver.findElement(By.xpath("//select[@name='requeststoreid']"));
		selectOptionByIndex(store, 0);
		Thread.sleep(500);
	}

	@When("User select the Allocation Proto - RM status from the filter")
	public void user_select_the_allocation_proto_rm_status_from_the_filter() throws InterruptedException {
		WebElement requestType = driver.findElement(By.xpath("//select[@name='requesttypeid']"));
		selectOptionByIndex(requestType, 13);
		Thread.sleep(500);
	}

	@When("User select the Requested status from the filter")
	public void user_select_the_requested_status_from_the_filter() throws InterruptedException {
		WebElement status = driver.findElement(By.xpath("//select[@name='allocationprotostatusid']"));
		selectOptionByIndex(status, 0);
		Thread.sleep(500);
	}

	@When("User click on the edit button")
	public void user_click_on_the_edit_button() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement issuesBtn = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollTo(0,0);", issuesBtn);
		wait.until(ExpectedConditions.elementToBeClickable(issuesBtn));
		j.executeScript("arguments[0].click();", issuesBtn);
		Thread.sleep(1000);

		WebElement editBtn = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@role='grid']//tbody//tr[1]//th//button[1]//i")));
		wait.until(ExpectedConditions.elementToBeClickable(editBtn));
		j.executeScript("arguments[0].click();", editBtn);
		Thread.sleep(2000);
	}

	@When("User verify the Master Fields")
	public void user_verify_the_master_fields() throws InterruptedException {
		WebElement requestType = (driver.findElement(By.xpath("(//select)[1]")));
		if (requestType.isEnabled()) {
			System.out.println("Request Type Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Request Type : " + requestType.getAttribute("value"));
		}

		WebElement allocationRefNo = driver.findElement(
				By.xpath("(//div//app-form-text//div//input[@tooltipposition='bottom' and @type='text'])[1]"));
		if (allocationRefNo.isEnabled()) {
			System.out.println("Allocation Reference No Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Allocation Reference No : " + allocationRefNo.getAttribute("value"));
		}

		WebElement branch = driver.findElement(By.xpath("(//select)[2]"));
		if (branch.isEnabled()) {
			System.out.println("Branch Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Branch : " + branch.getAttribute("value"));
		}

		WebElement wareHouse = (driver.findElement(By.xpath("(//select)[3]")));
		if (wareHouse.isEnabled()) {
			System.out.println("Warehouse Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Warehouse : " + wareHouse.getAttribute("value"));
		}

		WebElement store = driver.findElement(By.xpath("(//select)[4]"));
		if (store.isEnabled()) {
			System.out.println("Store Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Store : " + store.getAttribute("value"));
		}

		WebElement costCenter = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		if (costCenter.isEnabled()) {
			System.out.println("Cost Center Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Cost Center : " + costCenter.getAttribute("value"));
		}

		WebElement subCostCenter = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
		if (subCostCenter.isEnabled()) {
			System.out.println("Sub Cost Center Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Sub Cost Center : " + subCostCenter.getAttribute("value"));
		}

		WebElement projectName = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
		if (projectName.isEnabled()) {
			System.out.println("Project Name Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Project Name : " + projectName.getAttribute("value"));
		}

		WebElement productCode = driver.findElement(By.xpath("(//input[@type='text'])[5]"));
		if (productCode.isEnabled()) {
			System.out.println("Product Code Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Product Code : " + productCode.getAttribute("value"));
		}

		WebElement customerName = driver.findElement(By.xpath("(//input[@type='text'])[6]"));
		if (customerName.isEnabled()) {
			System.out.println("Customer Name Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Customer Name : " + customerName.getAttribute("value"));
		}

		WebElement jiraNumber = driver.findElement(By.xpath("(//input[@id='JiraNo' and @type='text'])[1]"));
		if (jiraNumber.isEnabled()) {
			System.out.println("Jira No Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Jira No : " + jiraNumber.getAttribute("value"));
		}

		WebElement consumptionDate = driver.findElement(By.xpath("(//input [@type='date'])[1]"));
		if (consumptionDate.isEnabled()) {
			String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			consumptionDate.clear();
			consumptionDate.sendKeys(date);
		} else {
			System.out.println("Consumption Date Field : Field is Disabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		}

		WebElement protoProductCode = driver.findElement(By.xpath("(//app-form-text//div//input[@type='text'])[3]"));
		if (protoProductCode.isEnabled()) {
			System.out.println("Proto Product Code Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Proto Product Code : " + protoProductCode.getAttribute("value"));
		}

		WebElement initialFGQty = driver.findElement(By.xpath("(//app-form-text//div//input[@type='text'])[4]"));
		if (initialFGQty.isEnabled()) {
			System.out.println("Initial FG Quantity Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Initial FG Quantity : " + initialFGQty.getAttribute("value"));
		}

		WebElement currentFGQty = driver.findElement(By.xpath("(//app-form-text//div//input[@type='text'])[5]"));
		if (currentFGQty.isEnabled()) {
			System.out.println("Current FG Quantity Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Current FG Quantity : " + currentFGQty.getAttribute("value"));
		}

		WebElement availableFGQty = driver.findElement(By.xpath("(//app-form-text//div//input[@type='text'])[6]"));
		if (availableFGQty.isEnabled()) {
			System.out.println("Available FG Quantity Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Available FG Quantity : " + availableFGQty.getAttribute("value"));
		}

		WebElement requestor = driver.findElement(By.xpath("(//select)[5]"));
		if (requestor.isEnabled()) {
			System.out.println("Requestor Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Requestor : " + requestor.getAttribute("value"));
		}

		WebElement initialRequestDate = driver.findElement(By.xpath("(//app-form-text//div//input[@type='text'])[7]"));
		if (initialRequestDate.isEnabled()) {
			System.out.println("Initial Request Date Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Initial Request Date : " + initialRequestDate.getAttribute("value"));
		}

		WebElement initialRequestTime = driver.findElement(By.xpath("(//app-form-text//div//input[@type='text'])[8]"));
		if (initialRequestTime.isEnabled()) {
			System.out.println("Initial Request Time Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Initial Request Time : " + initialRequestTime.getAttribute("value"));
		}

		WebElement updatedDate = driver.findElement(By.xpath("(//app-form-text//div//input[@type='text'])[9]"));
		if (updatedDate.isEnabled()) {
			System.out.println("Updated Date Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Updated Date : " + updatedDate.getAttribute("value"));
		}

		WebElement updatedTime = driver.findElement(By.xpath("(//app-form-text//div//input[@type='text'])[10]"));
		if (updatedTime.isEnabled()) {
			System.out.println("Updated Time Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Updated Time : " + updatedTime.getAttribute("value"));
		}

		WebElement revisionNo = driver.findElement(By.xpath("(//select)[6]"));
		if (revisionNo.isEnabled()) {
			System.out.println("Revision No : " + revisionNo.getAttribute("value"));
		} else {
			System.out.println("Revision No Field : Field is Disabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		}

		WebElement issueStatus = driver.findElement(By.xpath("(//app-form-text//div//input[@type='text'])[11]"));
		if (issueStatus.isEnabled()) {
			System.out.println("Issue Status Field : Field is Enabled as Not Expected");
			System.out.println("Case Failed");
			driver.quit();
		} else {
			System.out.println("Issue Status : " + issueStatus.getAttribute("value"));
		}
	}

	@When("User enters the Same BOM1 Name")
	public void user_enters_the_same_bom1_name() throws InterruptedException, AWTException {
//		try {
//			Robot robot = new Robot();
//			
//			typeSentence(robot, "e-CAM30");
//
//		} catch (AWTException e) {
//			e.printStackTrace();
//		}
//		robotKeyDown();

		Robot r = new Robot();
		robotKeyPress();
		r.keyPress(KeyEvent.VK_1);
		r.keyRelease(KeyEvent.VK_1);
		Thread.sleep(500);
		robotKeyDown();

		WebElement msg = driver.findElement(By.xpath("(//app-alert//div)[1]"));
		System.out.println("PopUp Msg : " + msg.getText().toString());
		String popup = msg.getText().toString().trim();

		if (popup.contentEquals("Importing in progress ... Please Wait ...")) {
			Thread.sleep(3000);
			try {
				msg = driver.findElement(By.xpath("(//app-alert//div)[1]"));
				System.out.println("PopUp Msg : " + msg.getText().toString());
				String popup1 = msg.getText().toString().trim();
				if (popup1.contains("The Proto BoM imported is same as the current version!")) {
					System.out.println("Matched Successfully");
					Thread.sleep(1000);
				}
			} catch (TimeoutExceededException e) {
			}
		} else {
			System.out.println("Not Matching");
		}
	}

	@When("User click on the Cancel button")
	public void user_click_on_the_cancel_button() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement cancelBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//app-alloc-proto-form//section//div//div//div[3]//button[2][contains (text(), 'Cancel')]")));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView(true);", cancelBtn);
		wait.until(ExpectedConditions.elementToBeClickable(cancelBtn));
		j.executeScript("arguments[0].click();", cancelBtn);
		Thread.sleep(2000);
	}

	@When("User enters the BOM2 Name")
	public void user_enters_the_bom2_name() throws InterruptedException, AWTException {
		Robot r = new Robot();
		robotKeyPress();
		r.keyPress(KeyEvent.VK_2);
		r.keyRelease(KeyEvent.VK_2);
		Thread.sleep(500);
		robotKeyDown();

		WebElement msg = driver.findElement(By.xpath("(//app-alert//div)[1]"));
		System.out.println("PopUp Msg : " + msg.getText().toString());
		String popup = msg.getText().toString().trim();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		if (popup.contentEquals("Importing in progress ... Please Wait ...")) {
			Thread.sleep(3000);
			try {
				wait.until(ExpectedConditions.textToBe(By.xpath("(//app-alert//div)[1]"), "   Imported Successfully"));
				if (popup.contains("Imported Successfully")) {
					System.out.println("Matched Successfully");
					Thread.sleep(1000);
				}
			} catch (TimeoutExceededException e) {
			}
		} else {
			System.out.println("Not Matching");
		}
	}

	@When("User enters the BOM3 Name")
	public void user_enters_the_bom3_name() throws AWTException, InterruptedException {
		Robot r = new Robot();
		robotKeyPress();
		r.keyPress(KeyEvent.VK_3);
		r.keyRelease(KeyEvent.VK_3);
		Thread.sleep(500);
		robotKeyDown();

		WebElement msg = driver.findElement(By.xpath("(//app-alert//div)[1]"));
		System.out.println("PopUp Msg : " + msg.getText().toString());
		String popup = msg.getText().toString().trim();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		if (popup.contentEquals("Importing in progress ... Please Wait ...")) {
			Thread.sleep(3000);
			try {
				wait.until(ExpectedConditions.textToBe(By.xpath("(//app-alert//div)[1]"), "   Imported Successfully"));
				if (popup.contains("Imported Successfully")) {
					System.out.println("Matched Successfully");
					Thread.sleep(1000);
				}
			} catch (TimeoutExceededException e) {
			}
		} else {
			System.out.println("Not Matching");
		}
	}

	@When("User enters the BOM4 Name")
	public void user_enters_the_bom4_name() throws InterruptedException, AWTException {
		Robot r = new Robot();
		robotKeyPress();
		r.keyPress(KeyEvent.VK_4);
		r.keyRelease(KeyEvent.VK_4);
		Thread.sleep(500);
		robotKeyDown();

		WebElement msg = driver.findElement(By.xpath("(//app-alert//div)[1]"));
		System.out.println("PopUp Msg : " + msg.getText().toString());
		String popup = msg.getText().toString().trim();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		if (popup.contentEquals("Importing in progress ... Please Wait ...")) {
			Thread.sleep(3000);
			try {
				wait.until(ExpectedConditions.textToBe(By.xpath("(//app-alert//div)[1]"), "   Imported Successfully"));
				if (popup.contains("Imported Successfully")) {
					System.out.println("Matched Successfully");
					Thread.sleep(1000);
				}
			} catch (TimeoutExceededException e) {
			}
		} else {
			System.out.println("Not Matching");
		}
	}

	@When("User enters the BOM5 Name")
	public void user_enters_the_bom5_name() throws AWTException, InterruptedException {
		Robot r = new Robot();
		robotKeyPress();
		r.keyPress(KeyEvent.VK_5);
		r.keyRelease(KeyEvent.VK_5);
		Thread.sleep(500);
		robotKeyDown();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement msg = driver.findElement(By.xpath("(//app-alert//div)[1]"));
		System.out.println("PopUp Msg : " + msg.getText().toString());
		String popup = msg.getText().toString().trim();
		Thread.sleep(1000);

		if (popup.contentEquals("Importing in progress ... Please Wait ...")) {
			Thread.sleep(3000);
			try {
				wait.until(ExpectedConditions.textToBe(By.xpath("(//app-alert//div)[1]"), "   Imported Successfully"));
				if (popup.contains("Imported Successfully")) {
					System.out.println("Matched Successfully");
					Thread.sleep(1000);
				}
			} catch (TimeoutExceededException e) {
			}
		} else {
			System.out.println("Not Matching");
		}
	}

	@When("User enters the BOM6 Name \\(Negative Kit Qty)")
	public void user_enters_the_bom6_name_negative_kit_qty() throws InterruptedException, AWTException {
		Robot r = new Robot();
		robotKeyPress();
		r.keyPress(KeyEvent.VK_6);
		r.keyRelease(KeyEvent.VK_6);
		Thread.sleep(500);
		robotKeyDown();

		WebElement msg = driver.findElement(By.xpath("(//app-alert//div)[1]"));
		System.out.println("PopUp Msg : " + msg.getText().toString());
		String popup = msg.getText().toString().trim();
		Thread.sleep(1000);

		if (popup.contentEquals("Please Enter a Valid Kit Qty in the imported excel sheet!")) {
			System.out.println("Matched Successfully");
			Thread.sleep(3000);
		} else {
			System.out.println("Not Matching");
		}
	}

	@When("User enters the BOM7 Name \\(Wrong Product Code)")
	public void user_enters_the_bom7_name_wrong_product_code() throws AWTException, InterruptedException {
		Robot r = new Robot();
		robotKeyPress();
		r.keyPress(KeyEvent.VK_7);
		r.keyRelease(KeyEvent.VK_7);
		Thread.sleep(500);
		robotKeyDown();

		WebElement msg = driver.findElement(By.xpath("(//app-alert//div)[1]"));
		System.out.println("PopUp Msg : " + msg.getText().toString());
		String popup = msg.getText().toString().trim();
		Thread.sleep(1000);

		if (popup.contentEquals(
				"The Proto Product Code imported through excel sheet is not listed in the FG! Please add it through ERP tool and try again!")) {
			System.out.println("Matched Successfully");
			Thread.sleep(3000);
		} else {
			System.out.println("Not Matching");
		}
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

	@When("User enters the Store Team Member {string} and {string}")
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

	@When("User click on the Edit button")
	public void user_click_on_the_Edit_button() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement issuesBtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(),'Issues')])[1]")));
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait1.until(ExpectedConditions.elementToBeClickable(issuesBtn));
		issuesBtn.click();

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement editBtn = wait2.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//table[@role='grid']//tbody//tr[1]//th//button[1]//i")));
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait3.until(ExpectedConditions.elementToBeClickable(editBtn));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", editBtn);
		Thread.sleep(2000);
	}

	@When("User enters the BOM8 Name")
	public void user_enters_the_bom8_name() throws InterruptedException, AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_B);
		r.keyRelease(KeyEvent.VK_B);
		r.keyPress(KeyEvent.VK_O);
		r.keyRelease(KeyEvent.VK_O);
		r.keyPress(KeyEvent.VK_M);
		r.keyRelease(KeyEvent.VK_M);
		r.keyPress(KeyEvent.VK_8);
		r.keyRelease(KeyEvent.VK_8);
		Thread.sleep(500);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(500);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(100);

		WebElement msg = driver.findElement(By.xpath("(//app-alert//div)[1]"));
		System.out.println("PopUp Msg : " + msg.getText().toString());
		String popup = msg.getText().toString().trim();
//		Thread.sleep(200);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.textToBe(By.xpath("(//app-alert//div)[1]"),
				"   Importing in progress ... Please Wait ..."));
		if (popup.contentEquals("Importing in progress ... Please Wait ...")) {
			System.out.println("Matched Successfully");
//			Thread.sleep(3000);
		}

		WebElement msg1 = driver.findElement(By.xpath("(//app-alert//div)[1]"));
		System.out.println("PopUp Msg : " + msg1.getText().toString());
		String popup1 = msg1.getText().toString().trim();
//		Thread.sleep(200);

		wait.until(ExpectedConditions.textToBe(By.xpath("(//app-alert//div)[1]"), "   Imported Successfully"));
		if (popup1.contentEquals("Imported Successfully")) {
			System.out.println("Matched Successfully");
			Thread.sleep(1000);
		} else {
			System.out.println("Not Matching");
		}
	}

	@When("User enters the Allocation Qty")
	public void user_enters_the_allocation_qty() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement kitLocation = driver.findElement(By.xpath("(//app-form-text//div//input [@type='text'])[8]"));
		wait.until(ExpectedConditions.visibilityOf(kitLocation));
		kitLocation.sendKeys("12");
		Thread.sleep(1000);

		/* / Grid Values / */

		WebElement parentElement = driver.findElement(
				By.xpath("(//div[@class='grid-canvas grid-canvas-top grid-canvas-left'] [@tabindex='0'])"));

		List<WebElement> childElements = parentElement.findElements(By.xpath("./*"));
		int columnIndex = 2;

		for (int i = 0; i < childElements.size(); i++) {
			Thread.sleep(1000);
			// Get the current element
			WebElement element = childElements.get(i);
			//System.out.println(element.getText());

			WebElement grnNumber = element.findElement(By.xpath(".//div[@class='slick-cell l10 r10']"));
			j.executeScript("arguments[0].click();", grnNumber);
			try {
				j.executeScript("arguments[0].click();", grnNumber);
				Thread.sleep(500);
			} catch (StaleElementReferenceException e) {
				element.findElement(By.xpath(".//div[@class='slick-cell l10 r10']"));
				j.executeScript("arguments[0].click();", grnNumber);
			}
			WebElement grnNumber1 = element
					.findElement(By.xpath(".//div[@class='slick-cell l10 r10 active editable selected']//select"));
//			wait.until(ExpectedConditions.elementSelectionStateToBe(grnNumber1, true));
			WebElement grnNumber2 = element
					.findElement(By.xpath(".//div[@class='slick-cell l10 r10 active editable selected']//select"));
			selectOptionByIndex(grnNumber2, 0);

			WebElement lineNumber = element.findElement(By.xpath(".//div[@class='slick-cell l11 r11 selected']"));
			j.executeScript("arguments[0].click();", lineNumber);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", lineNumber);
			} catch (StaleElementReferenceException e) {
				driver.findElement(By.xpath(".//div[@class='slick-cell l11 r11 selected active editable']//select"));
				WebElement lineNumber1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(".//div[@class='slick-cell l11 r11 selected active editable']//select")));
				selectOptionByIndex(lineNumber1, 0);
			}
//			Thread.sleep(500);

//			WebElement lineNumber1 = element.findElement(By.xpath(".//div[@class='slick-cell l11 r11 active editable selected']//select"));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='slick-cell l11 r11 active editable selected']//select")));
//			WebElement lineNumber2 = element.findElement(By.xpath(".//div[@class='slick-cell l11 r11 active editable selected']//select"));
//			selectOptionByIndex(lineNumber2, 0);

			WebElement dummyclick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='slick-cell l12 r12 selected']")));
//			WebElement dummyclick = element.findElement(By.xpath(".//div[@class='slick-cell l12 r12 selected']"));
			j.executeScript("arguments[0].click();", dummyclick);
			Thread.sleep(500);
			try {
				j.executeScript("arguments[0].click();", dummyclick);
			} catch (Exception e) {
			}

			WebElement partNo_ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[contains(@class='slick-cell l3 r3 selected']")));
//			j.executeScript("arguments[0].click();", partNo_ele);
			String partNo = partNo_ele.getText();
			Thread.sleep(500);
//			try {
//				j.executeScript("arguments[0].click();", partNo_ele);
//			} catch (StaleElementReferenceException e) {
//				element.findElement(By.xpath(".//div[@class='slick-cell l3 r3 selected']"));
//				j.executeScript("arguments[0].click();", partNo_ele);
//				partNo = partNo_ele.getText();
//			}

			System.out.println("Part No " + partNo);
			WebElement avl_qty_ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[contains(@class, 'slick-cell l12 r12')]")));
			int avl_qty = Integer.parseInt(avl_qty_ele.getText());
			WebElement alloc_qty_ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[contains(@class, 'slick-cell l13 r13')]")));
			int alloc_qty = 0;
			if (!alloc_qty_ele.getText().isEmpty()) {
				alloc_qty =  Integer.parseInt(alloc_qty_ele.getText());
			}
			WebElement req_qty_ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[contains(@class, 'slick-cell l9 r9')]")));
			int req_qty = Integer.parseInt(req_qty_ele.getText());
			System.out.println(avl_qty + " - " + alloc_qty);
			// Get the index
			int index = i;
			int set_alloc_qty = 0;
			if (index > 0) {
				// run the allocate function
				//childElements = parentElement.findElements(By.xpath("./*"));
				int curr_req_qty = chk_tot_aloc_qty(index, partNo, req_qty, childElements);
				if (avl_qty >= curr_req_qty) {
					set_alloc_qty = req_qty;
				} else if (avl_qty < curr_req_qty) {
					set_alloc_qty = avl_qty;
				}
				System.out.println("Element at index " + index);
			} else {
				// run the allocate function
				//childElements = parentElement.findElements(By.xpath("./*"));
				if (avl_qty >= req_qty) {
					set_alloc_qty = req_qty;
				} else if (avl_qty < req_qty) {
					set_alloc_qty = avl_qty;
				}
			}
			WebElement allocationQty = driver.findElement(By.xpath(".//div[@class='slick-cell l13 r13 selected']"));
			j.executeScript("arguments[0].click();", allocationQty);
			try {
				j.executeScript("arguments[0].click();", allocationQty);
			} catch (Exception e) {
				allocationQty = driver
						.findElement(By.xpath("//div[@style='top:0px']//div[@class='slick-cell l13 r13 selected']"));
				j.executeScript("arguments[0].click();", allocationQty);
			}
			WebElement refreshedallocationQty1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(".//div[@class='slick-cell l13 r13 selected active editable']//input")));
			String setallocqty = String.valueOf(set_alloc_qty);
			refreshedallocationQty1.sendKeys(setallocqty);
		}

//        ganesh(){

//        }

//		WebElement totalRequiredQty1 = driver
//				.findElement(By.xpath("//div[@style='top:0px']//div[@class='slick-cell l9 r9']"));
//		j.executeScript("arguments[0].click();", totalRequiredQty1);
//		try {
//			j.executeScript("arguments[0].click();", totalRequiredQty1);
//		} catch (Exception e) {
//			totalRequiredQty1 = driver.findElement(By.xpath("//div[@style='top:0px']//div[@class='slick-cell l9 r9']"));
//			j.executeScript("arguments[0].click();", totalRequiredQty1);
//		}
//		WebElement refreshedtotalRequiredQty1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//div[@style='top:0px']//div[@class='slick-cell l9 r9 selected active']")));
//		String totalRequiredQty1Attribute = refreshedtotalRequiredQty1.getText();
//
//		WebElement availableQty1 = driver.findElement(By.xpath("//div[@style='top:0px']//div[@class='slick-cell l12 r12 selected']"));
//		j.executeScript("arguments[0].click();", availableQty1);
//		try {
//			j.executeScript("arguments[0].click();", availableQty1);
//		} catch (Exception e) {
//			availableQty1 = driver
//					.findElement(By.xpath("//div[@style='top:0px']//div[@class='slick-cell l12 r12 selected']"));
//			j.executeScript("arguments[0].click();", totalRequiredQty1);
//		}
//		WebElement refreshedavailableQty1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//div[@style='top:0px']//div[@class='slick-cell l12 r12 selected active']")));
//		String availableQty1Attribute = refreshedavailableQty1.getText();
//
//		int totalRQty = Integer.parseInt(totalRequiredQty1Attribute);
//		int availableQty = Integer.parseInt(availableQty1Attribute);
//
//		if (availableQty > totalRQty) {
//			
//			String value = String.valueOf(totalRQty);
//			
//			WebElement allocationQty1 = driver
//					.findElement(By.xpath("//div[@style='top:0px']//div[@class='slick-cell l13 r13 selected']"));
//			j.executeScript("arguments[0].click();", allocationQty1);
//			try {
//				j.executeScript("arguments[0].click();", allocationQty1);
//			} catch (Exception e) {
//				allocationQty1 = driver
//						.findElement(By.xpath("//div[@style='top:0px']//div[@class='slick-cell l13 r13 selected']"));
//				j.executeScript("arguments[0].click();", allocationQty1);
//			}
//			WebElement refreshedallocationQty1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
//					By.xpath("//div[@style='top:0px']//div[@class='slick-cell l13 r13 selected active editable']//input")));
//			refreshedallocationQty1.sendKeys(value);
//			
//		}else if (availableQty < totalRQty) {
//			
//			WebElement grnNumber = driver.findElement(By.xpath("//div[@style='top:0px']//div[@class='slick-cell l10 r10 selected']"));
//			j.executeScript("arguments[0].click();", grnNumber);
//			WebElement grnNumber1 = driver.findElement(By.xpath("//div[@style='top:0px']//div[@class='slick-cell l10 r10 selected active editable']//select"));
//			selectOptionByIndex(grnNumber1, 1);
//			
//			WebElement lineNumber = driver.findElement(By.xpath("//div[@style='top:0px']//div[@class='slick-cell l11 r11 selected']"));
//			j.executeScript("arguments[0].click();", lineNumber);
//			Thread.sleep(500);
//			try {
//				j.executeScript("arguments[0].click();", lineNumber);
//			} catch (StaleElementReferenceException e1) {
//				driver.findElement(By.xpath("//div[@style='top:0px']//div[@class='slick-cell l11 r11 selected active editable']//select"));
//				WebElement lineNumber1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@style='top:0px']//div[@class='slick-cell l11 r11 selected active editable']//select")));
//				selectOptionByIndex(lineNumber1, 0);
//			}			
//			
//			WebElement dummyclick = driver.findElement(By.xpath("//div[@style='top:0px']//div[@class='slick-cell l12 r12 selected']"));
//			j.executeScript("arguments[0].click();", dummyclick);
//			Thread.sleep(500);

//	}

//Need to Calculate the Allocation values with popup
//		if (value.) {
//			System.out.println();
//		}

//		
		WebElement totalRequiredQty2 = driver.findElement(
				By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[@class='slick-cell l9 r9'])[1]"));
		j.executeScript("arguments[0].click();", totalRequiredQty2);
		try {
			j.executeScript("arguments[0].click();", totalRequiredQty2);
		} catch (Exception e) {
			totalRequiredQty2 = driver.findElement(
					By.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[@class='slick-cell l9 r9'])[1]"));
			j.executeScript("arguments[0].click();", totalRequiredQty2);
		}
		WebElement refreshedtotalRequiredQty2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[@class='slick-cell l9 r9 selected active'])[1]")));
		String totalRequiredQty2Attribute = refreshedtotalRequiredQty2.getText();
//		
		WebElement allocationQty2 = driver.findElement(By
				.xpath("(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[@class='slick-cell l13 r13 selected'])[1]"));
		j.executeScript("arguments[0].click();", allocationQty2);
		try {
			j.executeScript("arguments[0].click();", allocationQty2);
		} catch (Exception e) {
			allocationQty2 = driver.findElement(By.xpath(
					"(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[@class='slick-cell l13 r13 selected'])[1]"));
			j.executeScript("arguments[0].click();", allocationQty2);
		}
		WebElement refreshedallocationQty2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"(//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[@class='slick-cell l13 r13 selected active editable'])[1]//input")));
		refreshedallocationQty2.sendKeys(totalRequiredQty2Attribute);
	}
}
