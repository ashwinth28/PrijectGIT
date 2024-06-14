package ecERP.ISSUE;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;
import ecERP.libglobal.LibGlobal;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MOA_StepDefinition extends LibGlobal {

	// public class Hooks {
	public static WebDriver driver;

	// @Before
	@Given("User on the login page for MOA")
	public void user_on_the_login_page_for_moa() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.get("https://qa-erp.e-consystems.net");
		driver.manage().window().maximize();
	}

	@Given("User enters the PM Team Member {string} and {string} for MOA")
	public void user_enters_the_pm_team_member_and_for_moa(String username, String password)
			throws InterruptedException {
		WebElement loginID = driver.findElement(By.xpath("//input[@id='loginkey'][1]"));
		loginID.sendKeys(username);
		WebElement loginPassword = driver.findElement(By.xpath("//input[@id='password'][1]"));
		loginPassword.sendKeys(password);
		WebElement btnClick = driver.findElement(By.xpath("//input[@id='remembermeCheck'][1]"));
		btnClick.click();
		WebElement btnUnclick = driver.findElement(By.xpath("//input[@id='remembermeCheck'][1]"));
		btnUnclick.click();
		Thread.sleep(500);
		WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit'][1]"));
		signInButton.click();
		Thread.sleep(500);
	}

	@When("User create the MOA Request for MOA")
	public void user_create_the_moa_request_for_moa() throws IOException, InterruptedException {

		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebElement issueModule = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(issueModule,
				By.xpath("(//a[contains(text(),'Issues')])[1]")));
		j.executeScript("arguments[0].click();", issueModule);
		Thread.sleep(1000);

		WebElement addBtn = driver.findElement(By.xpath("(//button[@title='Add' and @type='button'])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(addBtn));
		j.executeScript("arguments[0].click();", addBtn);
		Thread.sleep(2000);

		WebElement requestType = (driver.findElement(By.xpath("(.//div//select)[1]")));
		String request = getData("MOA Master Fields", 1, 0);
		select(requestType).selectByVisibleText(request);
		Thread.sleep(1000);

		WebElement wareHouse = (driver.findElement(By.xpath("(.//div//select)[3]")));
		String warehouse_string = getData("MOA Master Fields", 1, 1);
		select(wareHouse).selectByVisibleText(warehouse_string);

		WebElement costCenter = (driver.findElement(By.xpath("(.//div//select)[4]")));
		String costcenter_string = getData("MOA Master Fields", 1, 2);
		select(costCenter).selectByVisibleText(costcenter_string);

		WebElement Basetype = (driver.findElement(By.xpath("(.//div//select)[5]")));
		String Basetype_string = getData("MOA Master Fields", 1, 22);
		select(Basetype).selectByVisibleText(Basetype_string);

		WebElement product_code_input = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		String product_input = getData("MOA Master Fields", 1, 3);
		product_code_input.sendKeys(product_input);
		Thread.sleep(500);

		List<WebElement> product_code_inputlist = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
		for (WebElement webElement : product_code_inputlist) {
			String list = webElement.getText();
			if (list.contains(product_input)) {
				Thread.sleep(500);
				JavascriptExecutor k = (JavascriptExecutor) driver;
				k.executeScript("arguments[0].click();", webElement);

				System.out.println("Product Code " + list);
				break;
			}
		}
		Thread.sleep(1000);

		WebElement FG_quantity = (driver.findElement(By.xpath("(//div//app-form-text//div//input [@type='text'])[2]")));
		String FG_quantity_string = getData("MOA Master Fields", 1, 7);
		Thread.sleep(500);
		FG_quantity.sendKeys(FG_quantity_string);

		WebElement customer_name = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
		String customer_name_String = getData("MOA Master Fields", 1, 13);
		customer_name.sendKeys(customer_name_String);
		Thread.sleep(500);

		List<WebElement> customer_name_list = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
		for (WebElement webElement : customer_name_list) {
			String list = webElement.getText();
			if (list.contains(customer_name_String)) {
				JavascriptExecutor k = (JavascriptExecutor) driver;
				wait.until(ExpectedConditions.elementToBeClickable(webElement));
				k.executeScript("arguments[0].click();", webElement);
				System.out.println("Customer Name " + list);
				break;
			}
			Thread.sleep(1000);
		}

		WebElement so_number = (driver.findElement(By.xpath("(//input[@type='text'])[5]")));
		String seventeenDigit = generateRandom17DigitNumber();
		so_number.sendKeys(seventeenDigit);

		WebElement AllocationAgainstProduct = (driver.findElement(By.xpath("(//input[@type='text'])[6]")));
		String AllocationAgainstProduct_string = getData("MOA Master Fields", 1, 23);
		AllocationAgainstProduct.sendKeys(AllocationAgainstProduct_string);
		Thread.sleep(500);

		List<WebElement> AllocationAgainstProductlist = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
		for (WebElement webElement : AllocationAgainstProductlist) {
			String list = webElement.getText();
			if (list.contains(AllocationAgainstProduct_string)) {
				Thread.sleep(500);
				JavascriptExecutor k = (JavascriptExecutor) driver;
				k.executeScript("arguments[0].click();", webElement);
				System.out.println("Allocation Against Product " + list);
				break;
			}
		}
		Thread.sleep(1000);

		WebElement AllocationAgainstProject = (driver.findElement(By.xpath("(//input[@type='text'])[7]")));
		String AllocationAgainstProject_string = getData("MOA Master Fields", 1, 24);
		AllocationAgainstProject.sendKeys(AllocationAgainstProject_string);
		Thread.sleep(500);

		List<WebElement> AllocationAgainstProjectlist = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
		for (WebElement webElement : AllocationAgainstProjectlist) {
			String list = webElement.getText();
			if (list.contains(AllocationAgainstProject_string)) {
				Thread.sleep(500);
				JavascriptExecutor k = (JavascriptExecutor) driver;
				k.executeScript("arguments[0].click();", webElement);
				System.out.println("Allocation Against Project " + list);
				break;
			}
		}
		Thread.sleep(1000);

		WebElement Consumption_Due_Date = driver.findElement(By.xpath("(//input [@type='date'])[1]"));
		String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Consumption_Due_Date.sendKeys(date);
	}

	@When("User click on the Save button for MOA")
	public void user_click_on_the_save_button_for_moa() throws InterruptedException {

		try {
			Thread.sleep(500);
			WebElement saveButton = driver
					.findElement(By.xpath("(//div//button[@id='submitbutton' and @type='submit'])"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", saveButton);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(saveButton));
			if (saveButton.isEnabled()) {
				System.out.println("MOA Entry Saved Successfully");
				js.executeScript("arguments[0].click();", saveButton);
			} else {
				wait.until(ExpectedConditions.visibilityOf(saveButton));
				js.executeScript("arguments[0].click();", saveButton);
				System.out.println("Save not enabled");
			}
		} catch (StaleElementReferenceException | NoSuchElementException e) {
		}
		Thread.sleep(2000);
	}

	@Then("User click on the signout button for MOA")
	public void user_click_on_the_signout_button_for_moa() throws InterruptedException {

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

	@Given("User enters the Store Team Member {string} and {string} for MOA")
	public void user_enters_the_store_team_member_and_for_moa(String username, String password)
			throws InterruptedException {

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
		Thread.sleep(500);
	}

	@When("User select the MOA Requested status from the filter for MOA")
	public void user_select_the_moa_requested_status_from_the_filter_for_moa()
			throws IOException, InterruptedException {
		Thread.sleep(500);
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebElement issueModule = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(issueModule,
				By.xpath("(//a[contains(text(),'Issues')])[1]")));
		j.executeScript("arguments[0].click();", issueModule);
		Thread.sleep(500);

		WebElement store = driver.findElement(By.xpath("//select[@name='requeststoreid']"));
		String store_string = getData("MOA Master Fields", 1, 10);
		select(store).selectByVisibleText(store_string);

		WebElement requestType = driver.findElement(By.xpath("//select[@name='requesttypeid']"));
		String requestType_string = getData("MOA Master Fields", 1, 11);
		select(requestType).selectByVisibleText(requestType_string);

		WebElement MOAStatus = driver.findElement(By.xpath("//select[@name='allocationfgstatusid']"));
		String MOAStatus_string = getData("MOA Master Fields", 1, 12);
		select(MOAStatus).selectByVisibleText(MOAStatus_string);
		Thread.sleep(2000);
	}

	@When("User click on the edit icon for MOA")
	public void user_click_on_the_edit_icon_for_issue_module_for_moa() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement issuesBtn = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(issuesBtn));
		j.executeScript("arguments[0].click();", issuesBtn);
		Thread.sleep(2000);

		int maxretries = 3;
		for (int i = 0; i < maxretries; i++) {
			try {
				WebElement issueIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(
						(By.xpath("(//table[@role='grid']//tbody//tr[1]//th//button[1]//i)[1]"))));
				j.executeScript("arguments[0].click();", issueIcon);
				break;
			} catch (StaleElementReferenceException | NoSuchElementException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		Thread.sleep(2000);
	}

	@When("User Should be Allocate the Entry for MOA")
	public void user_should_be_allocate_the_entry_for_moa() throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement Kit_location = driver.findElement(By.xpath("(//div//input[@type='text'])[4]"));
		wait.until(ExpectedConditions.visibilityOf(Kit_location));
		String Kit_location_string = getData("MOA Master Fields", 1, 25);
		Kit_location.sendKeys(Kit_location_string);
		Thread.sleep(500);

		WebElement Alloc_Qty_checkbox = driver.findElement(By.xpath("(//div//input[@type='checkbox'])[1]"));
		j.executeScript("arguments[0].click();", Alloc_Qty_checkbox);
		Thread.sleep(2000);

		WebElement Click_Alloc_qty = driver
				.findElement(By.xpath("//div//button[contains (text(), 'Move to Alloc Qty')][1]"));
		j.executeScript("arguments[0].click();", Click_Alloc_qty);
	}
	
	@When("User select the MOA Allocated status from the filter for Realloc the for MOA")
	public void user_select_the_moa_allocated_status_from_the_filter_for_realloc_the_for_moa() throws InterruptedException, IOException {
		
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebElement issueModule = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(issueModule,
				By.xpath("(//a[contains(text(),'Issues')])[1]")));
		j.executeScript("arguments[0].click();", issueModule);
		Thread.sleep(500);

		WebElement store = driver.findElement(By.xpath("//select[@name='requeststoreid']"));
		String store_string = getData("MOA Master Fields", 1, 10);
		select(store).selectByVisibleText(store_string);

		WebElement requestType = driver.findElement(By.xpath("//select[@name='requesttypeid']"));
		String requestType_string = getData("MOA Master Fields", 3, 11);
		select(requestType).selectByVisibleText(requestType_string);

		WebElement MOAStatus = driver.findElement(By.xpath("//select[@name='allocationfgstatusid']"));
		String MOAStatus_string = getData("MOA Master Fields", 3, 12);
		select(MOAStatus).selectByVisibleText(MOAStatus_string);
		Thread.sleep(2000);
	}
	@When("User enter the Release Qty for MOA")
	public void user_enter_the_release_qty_for_moa() throws IOException, InterruptedException {
		
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebElement Reallocation = driver.findElement(By.xpath(".//div//div[contains (@class, 'slick-cell l14 r14')]"));
		j.executeScript("arguments[0].click();", Reallocation);					
		WebElement ReallocationValue = driver.findElement(By.xpath(".//div//div[contains (@class, 'slick-cell l14 r14')]//input"));
		String Reallocation_string = getData("MOA Master Fields", 1, 26 );
		ReallocationValue.sendKeys(Reallocation_string);
		
//		int maxretries = 3;
//		for (int i = 0; i < maxretries; i++) {
//			try {
//				ReallocationValue = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l1 r1')]//select"));
//				select(ReallocationValue).selectByVisibleText(Reallocation_string);
//				break;
//			} catch (StaleElementReferenceException e) {
//				System.out.println("Maximum Retry Failed");
//			}
//		}

		Thread.sleep(500);
	}
	
	@When("User select the MOA Req for Reallocation status from the filter for MOA")
	public void user_select_the_moa_req_for_reallocation_status_from_the_filter_for_moa() throws InterruptedException, IOException {

		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebElement issueModule = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(issueModule,
				By.xpath("(//a[contains(text(),'Issues')])[1]")));
		j.executeScript("arguments[0].click();", issueModule);
		Thread.sleep(500);

		WebElement store = driver.findElement(By.xpath("//select[@name='requeststoreid']"));
		String store_string = getData("MOA Master Fields", 1, 10);
		select(store).selectByVisibleText(store_string);

		WebElement requestType = driver.findElement(By.xpath("//select[@name='requesttypeid']"));
		String requestType_string = getData("MOA Master Fields", 7, 11);
		select(requestType).selectByVisibleText(requestType_string);

		WebElement MOAStatus = driver.findElement(By.xpath("//select[@name='allocationfgstatusid']"));
		String MOAStatus_string = getData("MOA Master Fields", 7, 12);
		select(MOAStatus).selectByVisibleText(MOAStatus_string);
		Thread.sleep(1000);
	}

	@When("User create the MOA Partially Request for MOA")
	public void user_create_the_moa_partially_request_for_moa() throws InterruptedException, IOException {

		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebElement issueModule = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(issueModule,
				By.xpath("(//a[contains(text(),'Issues')])[1]")));
		j.executeScript("arguments[0].click();", issueModule);
		Thread.sleep(500);

		WebElement addBtn = driver.findElement(By.xpath("(//button[@title='Add' and @type='button'])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(addBtn));
		j.executeScript("arguments[0].click();", addBtn);
		Thread.sleep(2000);

		WebElement requestType = (driver.findElement(By.xpath("(.//div//select)[1]")));
		String request = getData("MOA Master Fields", 2, 0);
		select(requestType).selectByVisibleText(request);
		Thread.sleep(500);

		WebElement wareHouse = (driver.findElement(By.xpath("(.//div//select)[3]")));
		String warehouse_string = getData("MOA Master Fields", 2, 1);
		select(wareHouse).selectByVisibleText(warehouse_string);

		WebElement costCenter = (driver.findElement(By.xpath("(.//div//select)[4]")));
		String costcenter_string = getData("MOA Master Fields", 2, 2);
		select(costCenter).selectByVisibleText(costcenter_string);

		WebElement Basetype = (driver.findElement(By.xpath("(.//div//select)[5]")));
		String Basetype_string = getData("MOA Master Fields", 2, 22);
		select(Basetype).selectByVisibleText(Basetype_string);
		Thread.sleep(500);

		WebElement product_code_input = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		String product_input = getData("MOA Master Fields", 2, 3);
		product_code_input.sendKeys(product_input);
		Thread.sleep(500);

		List<WebElement> product_code_inputlist = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
		for (WebElement webElement : product_code_inputlist) {
			String list = webElement.getText();
			if (list.contains(product_input)) {
				Thread.sleep(500);
				JavascriptExecutor k = (JavascriptExecutor) driver;
				k.executeScript("arguments[0].click();", webElement);

				System.out.println("Product Code " + list);
				break;
			}
		}
		Thread.sleep(1000);

		WebElement bomType = driver.findElement(By.xpath("//*[@id='multi']/div/div[2]/span"));
		j.executeScript("arguments[0].click();", bomType);
		Thread.sleep(500);

		WebElement bomcheckbox = driver.findElement(By.xpath("//div//p-multiselectitem[1]/li/div/div"));
		j.executeScript("arguments[0].click();", bomcheckbox);
		Thread.sleep(500);

		WebElement bom_rev_no = (driver.findElement(By.xpath("(.//div//select)[6]")));
		String bomrev_string = getData("MOA Master Fields", 2, 6);
		select(bom_rev_no).selectByVisibleText(bomrev_string);

		WebElement FG_quantity = (driver.findElement(By.xpath("(//div//app-form-text//div//input [@type='text'])[2]")));
		String FG_quantity_string = getData("MOA Master Fields", 2, 7);
		Thread.sleep(500);
		FG_quantity.sendKeys(FG_quantity_string);

		WebElement customer_name = driver.findElement(By.xpath("(//input[@type='text'])[5]"));
		String customer_name_String = getData("MOA Master Fields", 2, 13);
		customer_name.sendKeys(customer_name_String);
		Thread.sleep(500);

		List<WebElement> customer_name_list = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
		for (WebElement webElement : customer_name_list) {
			String list = webElement.getText();
			if (list.contains(customer_name_String)) {
				JavascriptExecutor k = (JavascriptExecutor) driver;
				wait.until(ExpectedConditions.elementToBeClickable(webElement));
				k.executeScript("arguments[0].click();", webElement);
				System.out.println("Customer Name " + list);
				break;
			}
		}
		Thread.sleep(1000);
		WebElement so_number = (driver.findElement(By.xpath("(//input[@type='text'])[6]")));
		String so_number_string = getData("MOA Master Fields", 2, 14);
		so_number.sendKeys(so_number_string);

		WebElement AllocationAgainstProduct = (driver.findElement(By.xpath("(//input[@type='text'])[7]")));
		String AllocationAgainstProduct_string = getData("MOA Master Fields", 2, 23);
		AllocationAgainstProduct.sendKeys(AllocationAgainstProduct_string);
		Thread.sleep(500);

		List<WebElement> AllocationAgainstProductlist = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
		for (WebElement webElement : AllocationAgainstProductlist) {
			String list = webElement.getText();
			if (list.contains(AllocationAgainstProduct_string)) {
				Thread.sleep(500);
				JavascriptExecutor k = (JavascriptExecutor) driver;
				k.executeScript("arguments[0].click();", webElement);
				System.out.println("Allocation Against Product " + list);
				break;
			}
		}
		Thread.sleep(1000);

		WebElement AllocationAgainstProject = (driver.findElement(By.xpath("(//input[@type='text'])[8]")));
		String AllocationAgainstProject_string = getData("MOA Master Fields", 2, 24);
		AllocationAgainstProject.sendKeys(AllocationAgainstProject_string);
		Thread.sleep(500);

		List<WebElement> AllocationAgainstProjectlist = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
		for (WebElement webElement : AllocationAgainstProjectlist) {
			String list = webElement.getText();
			if (list.contains(AllocationAgainstProject_string)) {
				Thread.sleep(500);
				JavascriptExecutor k = (JavascriptExecutor) driver;
				k.executeScript("arguments[0].click();", webElement);
				System.out.println("Allocation Against Project " + list);
				break;
			}
		}
		Thread.sleep(1000);

		WebElement Consumption_Due_Date = driver.findElement(By.xpath("(//input [@type='date'])[1]"));
		String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Consumption_Due_Date.sendKeys(date);

	}

	@When("User select the MOA Partially Requested status from the filter for MOA")
	public void user_select_the_moa_partially_requested_status_from_the_filter_for_moa()
			throws IOException, InterruptedException {
		Thread.sleep(500);
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebElement issueModule = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(issueModule,
				By.xpath("(//a[contains(text(),'Issues')])[1]")));
		j.executeScript("arguments[0].click();", issueModule);
		Thread.sleep(500);

		WebElement store = driver.findElement(By.xpath("//select[@name='requeststoreid']"));
		String store_string = getData("MOA Master Fields", 1, 10);
		select(store).selectByVisibleText(store_string);

		WebElement requestType = driver.findElement(By.xpath("//select[@name='requesttypeid']"));
		String requestType_string = getData("MOA Master Fields", 2, 11);
		select(requestType).selectByVisibleText(requestType_string);

		WebElement MOAStatus = driver.findElement(By.xpath("//select[@name='allocationfgstatusid']"));
		String MOAStatus_string = getData("MOA Master Fields", 2, 12);
		select(MOAStatus).selectByVisibleText(MOAStatus_string);
		Thread.sleep(1000);

	}

	@When("User should be allocate the Entry")
	public void user_should_be_allocate_the_entry() throws IOException, InterruptedException {

		JavascriptExecutor j = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement Kit_location = driver.findElement(By.xpath("(//div//input[@type='text'])[4]"));
		wait.until(ExpectedConditions.visibilityOf(Kit_location));
		String Kit_location_string = getData("MOA Master Fields", 2, 25);
		Kit_location.sendKeys(Kit_location_string);
		Thread.sleep(500);

		WebElement Alloc_Qty_checkbox = driver.findElement(By.xpath("(//div//input[@type='checkbox'])[1]"));
		j.executeScript("arguments[0].click();", Alloc_Qty_checkbox);
		Thread.sleep(1000);

		WebElement Click_Alloc_qty = driver
				.findElement(By.xpath("//div//button[contains (text(), 'Move to Alloc Qty')][1]"));
		j.executeScript("arguments[0].click();", Click_Alloc_qty);
		Thread.sleep(1000);
	}

	@When("Click on the Cancel icon for MOA")
	public void click_on_the_cancel_icon_for_moa() throws IOException, InterruptedException {

		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement deallocIcon = wait.until(ExpectedConditions
				.visibilityOfElementLocated((By.xpath("(//table[@role='grid']//tbody//tr[1]//th//button[2]//i)[1]"))));
		j.executeScript("arguments[0].click();", deallocIcon);
		Thread.sleep(2000);

	}

	@When("Click on the Req for Deallocate button and Click ok on the alert for MOA")
	public void click_on_the_req_for_deallocate_button_and_click_ok_on_the_alert_for_moa() throws InterruptedException {

		Thread.sleep(500);
		String RequestNumber = driver.findElement(By.xpath("(//input[@type='text'])[1]")).getText();
		System.out.println(RequestNumber);

		try {
			Thread.sleep(500);
			WebElement Dealloc_button = driver.findElement(By.xpath("(//button[@type='submit'])"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", Dealloc_button);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(Dealloc_button));
			if (Dealloc_button.isEnabled()) {
				System.out.println("Deallocated Successfully");
				js.executeScript("arguments[0].click();", Dealloc_button);
			} else {
				wait.until(ExpectedConditions.visibilityOf(Dealloc_button));
				js.executeScript("arguments[0].click();", Dealloc_button);
				System.out.println("Dealloc Button Check Retry");
			}
		} catch (StaleElementReferenceException | NoSuchElementException e) {
		}
		Thread.sleep(1000);

		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(1000);

	}

	@When("User select the MOA Partially Requested status from the filter for dealloc the for MOA")
	public void user_select_the_moa_partially_requested_status_from_the_filter_for_dealloc_the_for_moa()
			throws IOException, InterruptedException {
		WebElement store = driver.findElement(By.xpath("//select[@name='requeststoreid']"));
		String store_string = getData("MOA Master Fields", 1, 10);
		select(store).selectByVisibleText(store_string);

		WebElement requestType = driver.findElement(By.xpath("//select[@name='requesttypeid']"));
		String requestType_string = getData("MOA Master Fields", 2, 11);
		select(requestType).selectByVisibleText(requestType_string);

		WebElement MOAStatus = driver.findElement(By.xpath("//select[@name='allocationfgstatusid']"));
		String MOAStatus_string = getData("MOA Master Fields", 2, 12);
		select(MOAStatus).selectByVisibleText(MOAStatus_string);
		Thread.sleep(2000);
	}

	@When("User select the MOA Allocated status from the filter for dealloc the for MOA")
	public void user_select_the_moa_allocated_status_from_the_filter_for_dealloc_the_for_moa()
			throws IOException, InterruptedException {
		
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebElement issueModule = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(issueModule,
				By.xpath("(//a[contains(text(),'Issues')])[1]")));
		j.executeScript("arguments[0].click();", issueModule);
		Thread.sleep(500);
		
		WebElement store = driver.findElement(By.xpath("//select[@name='requeststoreid']"));
		String store_string = getData("MOA Master Fields", 3, 10);
		select(store).selectByVisibleText(store_string);

		WebElement requestType = driver.findElement(By.xpath("//select[@name='requesttypeid']"));
		String requestType_string = getData("MOA Master Fields", 3, 11);
		select(requestType).selectByVisibleText(requestType_string);

		WebElement MOAStatus = driver.findElement(By.xpath("//select[@name='allocationfgstatusid']"));
		String MOAStatus_string = getData("MOA Master Fields", 3, 12);
		select(MOAStatus).selectByVisibleText(MOAStatus_string);
		Thread.sleep(2000);

	}

	@When("User select the MOA Req for Deallocation status from the filter for dealloc the for MOA")
	public void user_select_the_moa_req_for_deallocation_status_from_the_filter_for_dealloc_the_for_moa()
			throws IOException, InterruptedException {
		
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebElement issueModule = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(issueModule,
				By.xpath("(//a[contains(text(),'Issues')])[1]")));
		j.executeScript("arguments[0].click();", issueModule);
		Thread.sleep(500);

		WebElement store = driver.findElement(By.xpath("//select[@name='requeststoreid']"));
		String store_string = getData("MOA Master Fields", 5, 10);
		select(store).selectByVisibleText(store_string);

		WebElement requestType = driver.findElement(By.xpath("//select[@name='requesttypeid']"));
		String requestType_string = getData("MOA Master Fields", 5, 11);
		select(requestType).selectByVisibleText(requestType_string);

		WebElement MOAStatus = driver.findElement(By.xpath("//select[@name='allocationfgstatusid']"));
		String MOAStatus_string = getData("MOA Master Fields", 5, 12);
		select(MOAStatus).selectByVisibleText(MOAStatus_string);
		Thread.sleep(2000);
	}
	
	@When("User select the MOA Partially Allocated status from the filter for the MOA")
	public void user_select_the_moa_partially_allocated_status_from_the_filter_for_dealloc_the_for_moa() throws IOException, InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebElement issueModule = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(issueModule,
				By.xpath("(//a[contains(text(),'Issues')])[1]")));
		j.executeScript("arguments[0].click();", issueModule);
		Thread.sleep(500);

		WebElement store = driver.findElement(By.xpath("//select[@name='requeststoreid']"));
		String store_string = getData("MOA Master Fields", 6, 10);
		select(store).selectByVisibleText(store_string);

		WebElement requestType = driver.findElement(By.xpath("//select[@name='requesttypeid']"));
		String requestType_string = getData("MOA Master Fields", 6, 11);
		select(requestType).selectByVisibleText(requestType_string);

		WebElement MOAStatus = driver.findElement(By.xpath("//select[@name='allocationfgstatusid']"));
		String MOAStatus_string = getData("MOA Master Fields", 6, 12);
		select(MOAStatus).selectByVisibleText(MOAStatus_string);
		Thread.sleep(2000);
	}
	@When("User select the MOA Dellocated status from the filter for MOA")
	public void user_select_the_moa_dellocated_status_from_the_filter_for_moa() throws IOException, InterruptedException {
		
		WebElement store = driver.findElement(By.xpath("//select[@name='requeststoreid']"));
		String store_string = getData("MOA Master Fields", 1, 10);
		select(store).selectByVisibleText(store_string);

		WebElement requestType = driver.findElement(By.xpath("//select[@name='requesttypeid']"));
		String requestType_string = getData("MOA Master Fields", 4, 11);
		select(requestType).selectByVisibleText(requestType_string);

		WebElement MOAStatus = driver.findElement(By.xpath("//select[@name='allocationfgstatusid']"));
		String MOAStatus_string = getData("MOA Master Fields", 4, 12);
		select(MOAStatus).selectByVisibleText(MOAStatus_string);
		Thread.sleep(1000);
	}


}
