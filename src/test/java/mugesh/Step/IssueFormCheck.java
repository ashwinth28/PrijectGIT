package mugesh.Step;

import java.time.Duration;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ecERP.libglobal.LibGlobal;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class IssueFormCheck extends LibGlobal {

	public static WebDriver driver;

	@When("User Open the MO Allocation Form {string} and {string}")
	public void user_open_the_mo_allocation_form(String username, String password) {

		for (int i = 0; i < 50; i++) {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			driver.get("https://qa-erp.e-consystems.net/#/login");
//		driver.get("https://stage-erp.e-consystems.net/#/login");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement appTitle = driver.findElement(By.xpath("//h2[@class = 'heading-erp'][1]"));
			String title = appTitle.getText();
			System.out.println("Title of the Application: " + title);

			String pageTitle = driver.getTitle();
			System.out.println("Page Title: " + pageTitle);

			WebElement logo = driver.findElement(By.xpath("//img[@class = 'logo-src'][1]"));
			Boolean l = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete "
					+ "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0",
					logo);
			// verify if status is true
			if (l) {
				System.out.println("Logo present");
			} else {
				System.out.println("Logo not present");
			}
			try {
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

				JavascriptExecutor j = (JavascriptExecutor) driver;
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
				WebElement issuesBtn = driver.findElement(By.xpath("(//a[contains(text(),'Issues')])[1]"));
				wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(),'Issues')])[1]")));
				j.executeScript("arguments[0].click();", issuesBtn);

				WebElement addBtn = driver.findElement(By.xpath("(//button[@title='Add' and @type='button'])[1]"));
				wait.until(ExpectedConditions.elementToBeClickable(addBtn));
				j.executeScript("arguments[0].click();", addBtn);

				WebElement requestType = driver.findElement(By.xpath("(//app-form-dyna-select//div)[1]//select"));
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("(//app-form-dyna-select//div)[1]//select")));
				selectOptionByIndex(requestType, 8);

				WebElement form = driver.findElement(By.xpath(
						"//app-allocfg-form//div//div//div[@class='card-header']//h3[contains(text(),'Mass Order Allocation - Request')]"));

				if (form.isDisplayed()) {
					System.out.println("Form Displayed Case PASS");

					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
							"//app-allocfg-form//section//div//div//div[3]//button[2][contains (text(), 'Cancel')]")));

					WebElement cancelBtn = driver.findElement(By.xpath(
							"//app-allocfg-form//section//div//div//div[3]//button[2][contains (text(), 'Cancel')]"));
					j.executeScript("arguments[0].scrollIntoView(true);", cancelBtn);
					wait.until(ExpectedConditions.elementToBeClickable(cancelBtn));
					j.executeScript("arguments[0].click();", cancelBtn);

					WebElement profileClick = driver
							.findElement(By.xpath("(//app-header//div//div//span[@class = 'd-block'])[1]"));
					wait.until(ExpectedConditions.visibilityOf(profileClick));
					j.executeScript("window.scrollTo(0,0);", profileClick);
					wait.until(ExpectedConditions.elementToBeClickable(profileClick));
					j.executeScript("arguments[0].click();", profileClick);
					WebElement signOutBtn = driver.findElement(By.xpath(
							"//h3[contains (@class, 'dropdown-item-title') and contains (text(), 'Sign out ')][1]"));
					signOutBtn.click();
				} else {
					System.out.println("Form Not Displayed Case FAILED");
				}
			} finally {
				if (driver != null) {
					driver.quit();
				}
			}

		}

	}

}
