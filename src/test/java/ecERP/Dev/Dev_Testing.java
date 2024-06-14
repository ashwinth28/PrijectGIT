package ecERP.Dev;

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

public class Dev_Testing extends LibGlobal {

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

			WebElement costCenter = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l1 r1')]"));
			JavascriptExecutor c = (JavascriptExecutor) driver;
			c.executeScript("arguments[0].click();", costCenter);
			WebElement costCenter1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l1 r1')]//select"));
			String costcenter_string = getData("Grid_Data", 2, 0);
			select(costCenter1).selectByVisibleText(costcenter_string);

			WebElement expenseCategory = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l2 r2')]"));
			JavascriptExecutor e = (JavascriptExecutor) driver;
			e.executeScript("arguments[0].click();", expenseCategory);
			WebElement expenseCategory1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l2 r2')]//select"));
			String expensecategory_string = getData("Grid_Data", 2, 1);
			select(expenseCategory1).selectByVisibleText(expensecategory_string);

			WebElement partNo = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l3 r3')]"));
			JavascriptExecutor p = (JavascriptExecutor) driver;
			p.executeScript("arguments[0].click();", partNo);
			WebElement partNo1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l3 r3')]//input"));
			String grid_data = getData("Grid_Data", 2, 7);
			partNo1.sendKeys(grid_data);
			WebElement autoSuggestion = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
			autoSuggestion.click();
			
			WebElement orig_Mater_Type = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l4 r4')]"));
			JavascriptExecutor j = (JavascriptExecutor) driver;
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
			JavascriptExecutor w = (JavascriptExecutor) driver;
			w.executeScript("arguments[0].click();", workType);
			Thread.sleep(500);
			try {
				w.executeScript("arguments[0].click();", workType);
			} catch (StaleElementReferenceException e1) {
				workType = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l5 r5')]"));
				w.executeScript("arguments[0].click();", workType);
			}
			WebElement workType1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l5 r5')]//select"));
			selectOptionByIndex(workType1, 0);

			WebElement name = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l6 r6')]"));
			JavascriptExecutor n = (JavascriptExecutor) driver;
			n.executeScript("arguments[0].click();", name);
			Thread.sleep(500);
			try {
				n.executeScript("arguments[0].click();", name);
			} catch (StaleElementReferenceException e2) {
				name = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l6 r6')]"));
				n.executeScript("arguments[0].click();", name);
			}
			Thread.sleep(1000);
			WebElement name1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l6 r6')]//input"));
			String grid_data2 = getData("Grid_Data", 2, 8);
			name1.sendKeys(grid_data2);
			WebElement autoSuggestion1 = driver.findElement(By.xpath("//*[@class='ui-menu-item'][1]"));
			autoSuggestion1.click();

			WebElement qty = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l7 r7')]"));
			JavascriptExecutor q = (JavascriptExecutor) driver;
			q.executeScript("arguments[0].click();", qty);
			Thread.sleep(500);
			try {
				q.executeScript("arguments[0].click();", qty);
			} catch (StaleElementReferenceException e3) {
				qty = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l7 r7')]"));
				q.executeScript("arguments[0].click();", qty);
			}
			WebElement qty1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l7 r7')]//input"));
			String grid_data3 = getData("Grid_Data", 2, 9);
			qty1.sendKeys(grid_data3);

			WebElement unitPrice = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l8 r8')]"));
			JavascriptExecutor u = (JavascriptExecutor) driver;
			u.executeScript("arguments[0].click();", unitPrice);
			Thread.sleep(500);
			try {
				u.executeScript("arguments[0].click();", unitPrice);
				Thread.sleep(500);
			} catch (StaleElementReferenceException e4) {
				unitPrice = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l8 r8')]"));
				u.executeScript("arguments[0].click();", unitPrice);
			}
			WebElement unitPrice1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l8 r8')]//input"));
			String grid_data4 = getData("Grid_Data", 2, 10);
			unitPrice1.sendKeys(grid_data4);

			WebElement UOM = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l12 r12')]"));
			JavascriptExecutor U = (JavascriptExecutor) driver;
			U.executeScript("arguments[0].click();", UOM);
			Thread.sleep(500);
			try {
				U.executeScript("arguments[0].click();", UOM);
			} catch (StaleElementReferenceException e5) {
				UOM = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l12 r12')]"));
				U.executeScript("arguments[0].click();", UOM);
			}
			WebElement UOM1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l12 r12')]//select"));
			selectOptionByIndex(UOM1, 0);

			WebElement deliveryDate = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l13 r13')]"));
			JavascriptExecutor d = (JavascriptExecutor) driver;
			d.executeScript("arguments[0].click();", deliveryDate);
			Thread.sleep(500);
			try {
				d.executeScript("arguments[0].click();", deliveryDate);
			} catch (StaleElementReferenceException e5) {
				deliveryDate = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l13 r13')]"));
				d.executeScript("arguments[0].click();", deliveryDate);
			}
			WebElement deliverDate1 = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l13 r13')]//input"));
			String date1 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			deliverDate1.sendKeys(date1);

			// With IQC checkbox code

			WebElement checkBox = driver
					.findElement(By.xpath(".//div[contains (@class, 'slick-cell l14 r14')]"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", checkBox);
			Thread.sleep(500);
			try {
				js.executeScript("arguments[0].click();", checkBox);
			} catch (StaleElementReferenceException e5) {
				checkBox = driver.findElement(By.xpath(".//div[contains (@class, 'slick-cell l14 r14')]"));
				js.executeScript("arguments[0].click();", checkBox);
			}
			WebElement checkBox1 = driver.findElement(
					By.xpath(".//div[contains (@class, 'slick-cell l14 r14')]//input[@type='checkbox']"));
			j.executeScript("arguments[0].click();", checkBox1);
//			j.executeScript("arguments[0].click();", checkBox1);

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

		// RM Grid Fields
		else {
			
			MRI_Multiple_Lineitems_POGridFields_RM(driver);

//			WebElement costCenter = driver
//					.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[2]"));
//			JavascriptExecutor c = (JavascriptExecutor) driver;
//			c.executeScript("arguments[0].click();", costCenter);
//			WebElement costCenter1 = driver
//					.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[2]//select"));
//			String costcenter_data = getData("Master_Data", 1, 7);
//			select(costCenter1).selectByVisibleText(costcenter_data);
//
//			WebElement expenseCategory = driver
//					.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[3]"));
//			JavascriptExecutor e = (JavascriptExecutor) driver;
//			e.executeScript("arguments[0].click();", expenseCategory);
//			WebElement expenseCategory1 = driver
//					.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[3]//select"));
//			String expensecategory_data = getData("Master_Data", 1, 8);
//			select(expenseCategory1).selectByVisibleText(expensecategory_data);
//
//			WebElement partNo = driver.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[4]"));
//			JavascriptExecutor p = (JavascriptExecutor) driver;
//			p.executeScript("arguments[0].click();", partNo);
//			WebElement partNo1 = driver
//					.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[4]//input"));
//			String grid_data = getData("Grid_Data", 1, 0);
//			partNo1.sendKeys(grid_data);
//			WebElement autoSuggestion = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
//			autoSuggestion.click();
//
//			WebElement packingType = driver
//					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[5]"));
//			JavascriptExecutor p1 = (JavascriptExecutor) driver;
//			p1.executeScript("arguments[0].click();", packingType);
//			WebElement packingType1 = driver
//					.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]/div/div/div[5]//select"));
//			selectOptionByIndex(packingType1, 0);
//
//			WebElement workType = driver.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[6]"));
//			JavascriptExecutor w = (JavascriptExecutor) driver;
//			w.executeScript("arguments[0].click();", workType);
//			WebElement workType1 = driver
//					.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[6]//select"));
//			selectOptionByIndex(workType1, 0);
//
//			WebElement name = driver.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[7]"));
//			JavascriptExecutor n = (JavascriptExecutor) driver;
//			n.executeScript("arguments[0].click();", name);
//			WebElement name1 = driver
//					.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[7]//input"));
//			String grid_data1 = getData("Grid_Data", 1, 1);
//			name1.sendKeys(grid_data1);
//			WebElement autoSuggestion1 = driver.findElement(By.xpath("//*[@class=\"ui-menu-item\"][1]"));
//			autoSuggestion1.click();
//
//			WebElement qty = driver.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[8]"));
//			JavascriptExecutor q = (JavascriptExecutor) driver;
//			q.executeScript("arguments[0].click();", qty);
//			WebElement qty1 = driver
//					.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[8]//input"));
//			String grid_data2 = getData("Grid_Data", 1, 2);
//			qty1.sendKeys(grid_data2);
//
//			WebElement unitPrice = driver
//					.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[9]"));
//			JavascriptExecutor u = (JavascriptExecutor) driver;
//			u.executeScript("arguments[0].click();", unitPrice);
//			WebElement unitPrice1 = driver
//					.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[9]//input"));
//			String grid_data3 = getData("Grid_Data", 1, 3);
//			unitPrice1.sendKeys(grid_data3);
//
//			WebElement UOM = driver.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[13]"));
//			JavascriptExecutor U = (JavascriptExecutor) driver;
//			U.executeScript("arguments[0].click();", UOM);
//			WebElement UOM1 = driver
//					.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[13]//select"));
//			selectOptionByIndex(UOM1, 0);
//
//			WebElement deliveryDate = driver
//					.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[14]"));
//			JavascriptExecutor d = (JavascriptExecutor) driver;
//			d.executeScript("arguments[0].click();", deliveryDate);
//			WebElement deliverDate1 = driver
//					.findElement(By.xpath("//*[@id=\"form_grid_0\"]/div[4]/div[3]/div/div/div[14]//input"));
//			String date1 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//			deliverDate1.sendKeys(date1);
//
//			// With IQC checkbox code
//
//			WebElement checkBox = driver
//					.findElement(By.xpath("(//div[@id='form_grid_0']//div[@style='top:0px']//div)[15]"));
//			JavascriptExecutor j = (JavascriptExecutor) driver;
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

			WebElement successfullPoCreation = wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//app-wstable//div[@class='ws-table-head']//table[@role='grid']//tbody//tr[1]")));
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
		js.executeScript("arguments[0].scrollIntoView();", issueButton);
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
//			String invoicenumber_string = getData("Master_Data", 1, 6);
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
//			String trackingNo_string = getData("Master_Data", 1, 9);
			trackingNo.sendKeys(UUID());
			Thread.sleep(500);

			WebElement noOfPackages = driver.findElement(By.xpath("(//input[@pattern='[0-9]*'])[1]"));
			noOfPackages.sendKeys("2");

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
			additionalChargesTax.sendKeys("0");

			WebElement additionalChargesNonTax = driver.findElement(
					By.xpath("(//div//app-form-text//div//input[@tooltipposition='bottom' and @type='text'])[11]"));
			additionalChargesNonTax.sendKeys("0");

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
			String invoicenumber_string = getData("Master_Data", 1, 6);
			invoiceNumber.sendKeys(invoicenumber_string);

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
			String customerRequestNo_string = getData("Master_Data", 1, 10);
			customerRequestNo.sendKeys(customerRequestNo_string);

			WebElement BOENo = driver.findElement(By.xpath("(//input[@pattern='[a-zA-Z0-9*-{}@()/\\s]+'])[4]"));
			String BOENo_string = getData("Master_Data", 1, 11);
			BOENo.sendKeys(BOENo_string);

			WebElement BOEDate = driver.findElement(By.xpath("(//app-form-date[1]//div[1]//input[@type='date'])[2]"));
			String date1 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			BOEDate.sendKeys(date1);
			Thread.sleep(1000);

			WebElement trackingNo = driver.findElement(By.xpath("(//input[@pattern='[a-zA-Z0-9*-{}@()/\\s]+'])[5]"));
			String trackingNo_string = getData("Master_Data", 1, 9);
			trackingNo.sendKeys(trackingNo_string);

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
			additionalChargesTax.sendKeys("");

			WebElement additionalChargesNonTax = driver.findElement(
					By.xpath("(//app-form-text//div//input[@tooltipposition='bottom' and @type='text'])[14]"));
			additionalChargesNonTax.sendKeys("");

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
