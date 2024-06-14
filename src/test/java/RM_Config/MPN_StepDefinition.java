package RM_Config;

import java.io.IOException;
import java.time.Duration;
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
import org.openqa.selenium.support.ui.WebDriverWait;

import ecERP.libglobal.LibGlobal;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MPN_StepDefinition extends LibGlobal {

	public static WebDriver driver;

	@Given("User on the login page")
	public void user_on_the_login_page() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
//		driver.get("https://qa-erp.e-consystems.net");
//		driver.get("https://stage-erp.e-consystems.net");
//		driver.get("http://192.168.8.119:8080/#/login");
		driver.get("http://localhost:8080/#/");
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

	@Given("User enters the Sustanance Team Member {string} and {string}")
	public void user_enters_the_sustanance_team_member_and(String username, String password) {
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

	@When("User create the MPN Request and Save")
	public void user_create_the_mpn_request_and_save() throws InterruptedException, IOException {

			JavascriptExecutor j = (JavascriptExecutor) driver;

			WebElement RM_config = driver.findElement(By
					.xpath("/html/body/app-root/div/app-main/div/app-header/div/aside/app-sidebar/div/nav/ul/li[3]/a"));
			j.executeScript("arguments[0].click();", RM_config);

			WebElement NPM = driver.findElement(By.xpath(
					"/html/body/app-root/div/app-main/div/app-header/div/aside/app-sidebar/div/nav/ul/li[3]/ul/li[5]/a"));
			j.executeScript("arguments[0].click();", NPM);
			
			for (int i = 0; i < 12001; i++) {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement addBtn = driver.findElement(By.xpath("(//button[@title='Add' and @type='button'])//i[1]"));
			wait.until(ExpectedConditions.elementToBeClickable(addBtn));
			j.executeScript("arguments[0].click();", addBtn);
//			Thread.sleep(1000);

			WebElement econPartNo = (driver.findElement(By.xpath("(.//app-form-text//div//input)[1]")));
			String econPartNo_string = getData("Master_Data", (i+2), 0);
			econPartNo.sendKeys(econPartNo_string);
//			Thread.sleep(200);

			WebElement MPN = (driver.findElement(By.xpath("(.//app-form-text//div//input)[2]")));
			String MPN_string = getData("Master_Data", (i+2), 1);
			MPN.sendKeys(MPN_string);
//			Thread.sleep(200);

			WebElement Revision = (driver.findElement(By.xpath("(.//app-form-text//div//input)[3]")));
			String Revision_string = getData("Master_Data", (i+2), 2);
			Revision.sendKeys(Revision_string);
//			Thread.sleep(200);

			WebElement manufacturer = (driver.findElement(By.xpath("(.//app-form-autocomplete//div//input)[1]")));
			String manufacturer_string = getData("Master_Data", (i+2), 3);
			manufacturer.sendKeys(manufacturer_string);
			Thread.sleep(200);

			List<WebElement> manufacturer_list = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
			for (WebElement webElement : manufacturer_list) {
				String list = webElement.getText();
				if (list.contains(manufacturer_string)) {
//					Thread.sleep(500);
					JavascriptExecutor k = (JavascriptExecutor) driver;
					k.executeScript("arguments[0].click();", webElement);
					System.out.println(webElement);
					break;
				}
				Thread.sleep(500);
			}

			WebElement commodity = (driver.findElement(By.xpath("(.//app-form-autocomplete//div//input)[2]")));
			String commodity_string = getData("Master_Data", (i+2), 4);
			commodity.sendKeys(commodity_string);
			Thread.sleep(200);

			List<WebElement> commodity_list = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
			for (WebElement webElement : commodity_list) {
				String list = webElement.getText();
				if (list.contains(commodity_string)) {
//					Thread.sleep(500);
					JavascriptExecutor k = (JavascriptExecutor) driver;
					k.executeScript("arguments[0].click();", webElement);
					System.out.println(webElement);
					break;
				}Thread.sleep(200);
			}

			WebElement subCategory = (driver.findElement(By.xpath("(.//app-form-autocomplete//div//input)[3]")));
			String subCategory_string = getData("Master_Data", (i+2), 5);
			subCategory.sendKeys(subCategory_string);
			Thread.sleep(200);

			List<WebElement> subCategory_list = driver.findElements(By.xpath("(//ul[@role='listbox'])[1]//li"));
			for (WebElement webElement : subCategory_list) {
				String list = webElement.getText();
				if (list.contains(subCategory_string)) {
//					Thread.sleep(500);
					JavascriptExecutor k = (JavascriptExecutor) driver;
					k.executeScript("arguments[0].click();", webElement);
					System.out.println(webElement);
					break;
				}Thread.sleep(200);
			}

			WebElement value = (driver.findElement(By.xpath("(.//app-form-text//div//input)[4]")));
			String value_string = getData("Master_Data", (i+2), 6);
//			Thread.sleep(200);
			value.sendKeys(value_string);
			
			WebElement description = (driver.findElement(By.xpath("(.//app-form-text//div//input)[5]")));
			String description_string = getData("Master_Data", (i+2), 7);
//			Thread.sleep(200);
			description.sendKeys(description_string);	

			WebElement type = (driver.findElement(By.xpath("(.//app-form-dyna-select//div//select)[1]")));
			String type_string = getData("Master_Data", (i+2), 8);
//			Thread.sleep(200);
			select(type).selectByVisibleText(type_string);

			WebElement Class = (driver.findElement(By.xpath("(.//app-form-select//div//select)[1]")));
			String Class_string = getData("Master_Data", (i+2), 9);
//			Thread.sleep(200);
			select(Class).selectByVisibleText(Class_string);

			try {
				WebElement saveButton = driver
						.findElement(By.xpath("(//div//button[@id='submitbutton' and @type='submit'])"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", saveButton);
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
		}

	}

	@When("User Enter the Search By With MPN")
	public void user_enter_the_search_by_with_mpn() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("User verifies the MPN Status and Signout")
	public void user_verifies_the_mpn_status_and_signout() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
