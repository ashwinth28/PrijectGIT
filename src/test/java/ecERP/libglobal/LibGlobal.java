package ecERP.libglobal;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibGlobal {

	WebDriver driver;

	public WebDriver launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}

	// WebDriver: I
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void openAppUrl(String url) {
		driver.get(url);
		;
	}

	public void closeBrowser() {
		driver.quit();
	}

	public String getPageUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public void closeDriver() {
		driver.close();
	}

	public WebDriver SwitchToWindow(WebDriver diver, String name) {
		WebDriver d = driver.switchTo().window(name);
		return d;
	}

	public String windowHandle() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	public Set<String> WindowHandles() {
		Set<String> handles = driver.getWindowHandles();
		return handles;
	}

	public Navigation navigate() {
		Navigation n = driver.navigate();
		return n;
	}

	// WebElement: I

	public void enterValue(WebElement e, String data) {
		e.sendKeys(data);
	}

	public void elementClick(WebElement element) {
		element.click();
	}

	public String getAttributeValue(WebElement e, String name) {
		String attribute = e.getAttribute(name);
		return attribute;
	}

	public String getTextValue(WebElement g, String textvalue) {
		String text = g.getText();
		return text;
	}

	public boolean enabled(WebElement e) {
		boolean b = e.isEnabled();
		return b;
	}

	public boolean selected(WebElement s) {
		boolean se = s.isSelected();
		return se;
	}

	public boolean displayed(WebElement element) {
		boolean d = element.isDisplayed();
		return d;
	}

	// Navigation: I

	public void refreshPage() {
		navigate().refresh();
	}

	public void forwardPage() {
		navigate().forward();
	}

	public void backPage() {
		navigate().back();
	}

	public void toPage(String url) {
		navigate().to(url);
	}

	// Alert: I

	public Alert switchTo() {
		Alert al = driver.switchTo().alert();
		return al;
	}

	public void acceptAlert() {
		switchTo().accept();
	}

	public void dismissAlert() {
		switchTo().dismiss();
	}

	public void sendKeys(String value) {
		switchTo().sendKeys(value);
	}

	public String getText() {
		String text = switchTo().getText();
		return text;
	}

	// Actions: C

	public Actions actions() {
		Actions action = new Actions(driver);
		return action;
	}

	public void performAction() {
		actions().perform();
	}

	public void dragAndDrop(WebElement source, WebElement target) {
		actions().dragAndDrop(source, target).perform();
	}

	public void moveToElement() {
		actions().moveToElement(null).perform();
	}

	public void contextClick(WebElement target) {
		actions().contextClick(target).perform();
	}

	public void doubleClick(WebElement target) {
		actions().doubleClick(target).perform();
	}

	// Select: C

	public Select select(WebElement element) {
		Select s = new Select(element);
		return s;
	}

	public void selectOptionByIndex(WebElement element, int index) {
		select(element).selectByIndex(index);
	}

	public void selectOptionByText(WebElement element, String text) {
		select(element).selectByVisibleText(text);
	}

	public void selectOptionByValue(WebElement e, String value) {
		select(e).selectByValue(value);
	}

	public void deselectByIndex(WebElement element, int index) {
		select(element).deselectByIndex(index);
	}

	public void deselectoptionByValue(WebElement d, String value) {
		select(d).deselectByValue(value);
	}

	public void deselectoptionByVisibleText(WebElement element, String text) {
		select(element).deselectByVisibleText(text);
	}

	public void deselectAllOption(WebElement element) {
		select(element).deselectAll();
	}

	public List<WebElement> getOptions(WebElement e) {
		List<WebElement> options = select(e).getOptions();
		return options;
	}

	public boolean isMultipleOption(WebElement element) {
		boolean b = select(element).isMultiple();
		return b;
	}

	public List<WebElement> getAllSelectedOptions(WebElement e) {
		List<WebElement> options = select(e).getAllSelectedOptions();
		return options;
	}

	public WebElement getFirstSelectedOption(WebElement e) {
		WebElement element = select(e).getFirstSelectedOption();
		return element;
	}

	public String getData(String name, int rownum, int cellnum) throws IOException {

//		String value = null;
//		File excelloc = new File(
//				"D:\\Automation Data\\GIT Scripts\\Login Page Automation Script\\erp_automation\\Excel\\Gross Profit.xlsx");
//		FileInputStream stream = new FileInputStream(excelloc);
//		Workbook w = new XSSFWorkbook(stream);
//		Sheet s = w.getSheet(name);
//		Row r = s.getRow(rownum);
//		Cell c = r.getCell(cellnum);
//		int type = c.getCellType();
//		if (type == 1) {
//			value = c.getStringCellValue();
//		}
//		if (type == 0) {
//			if (DateUtil.isCellDateFormatted(c)) {
//				Date dateCellValue = c.getDateCellValue();
//				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//				value = dateFormat.format(dateCellValue);
//			} else {
//				double d = c.getNumericCellValue();
//				long l = (long) d;
//				value = String.valueOf(l);
//			}
//		}
//		return value;

		String value = null;
		File excelloc = new File(
				"D:\\Automation Data\\GIT Scripts\\Login Page Automation Script\\erp_automation\\Excel\\Gross Profit.xlsx");
		FileInputStream stream = new FileInputStream(excelloc);
		Workbook workbook = new XSSFWorkbook(stream);

		try {
			Sheet sheet = workbook.getSheet(name);
			if (sheet != null) {
				Row row = sheet.getRow(rownum);
				if (row != null) {
					Cell cell = row.getCell(cellnum);
					if (cell != null) {
					int cellType = cell.getCellType();
						switch (cellType) {
						case Cell.CELL_TYPE_STRING:
							value = cell.getStringCellValue();
							break;
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(cell)) {
								SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
								value = dateFormat.format(cell.getDateCellValue());
							} else {
								value = String.valueOf(cell.getNumericCellValue());
							}
							break;
						case Cell.CELL_TYPE_BOOLEAN:
							value = String.valueOf(cell.getBooleanCellValue());
							break;
						case Cell.CELL_TYPE_FORMULA:
							value = cell.getCellFormula();
							break;
						case Cell.CELL_TYPE_BLANK:
							value = "";
							break;
						default:
							break;
						}
					} else {
						System.err.println("Cell is null");
					}
				} else {
					System.err.println("Row is null");
				}
			} else {
				System.err.println("Sheet is null");
			}
		} finally {
			stream.close();
		}

		return value;

	}

	public static List<String> gp_reader(String filePath, int sheetIndex, int columnIndex) throws IOException {

		List<String> columnData = new ArrayList<>();

		File filepath = new File("C:\\Users\\AntonyAshwinthAR\\Desktop\\23-24_GrossProfit.xlsx");
		try (FileInputStream fis = new FileInputStream(filePath)) {
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheetAt(sheetIndex);
			for (Row row : sheet) {
				Cell cell = row.getCell(columnIndex);
				if (cell != null) {
					columnData.add(cell.toString());
				}
			}
		}
		return columnData;
	}

	public static void main(String[] args) {
		String filePath = "path/to/your/excel/file.xlsx";
		int sheetIndex = 0; // Index of the sheet you want to read from
		int columnIndex = 1; // Index of the column you want to read

		try {
			List<String> columnData = gp_reader(filePath, sheetIndex, columnIndex);
			for (String data : columnData) {
				System.out.println(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// frames:

	public WebDriver frames(WebDriver e, String id) {
		WebDriver frame = driver.switchTo().frame(id);
		return frame;
	}

	public WebDriver frames2(WebDriver driver, int value) {
		WebDriver f = driver.switchTo().frame(value);
		return f;
	}

	public WebDriver frames3(WebDriver driver, String name) {
		WebDriver d = driver.switchTo().frame(name);
		return d;
	}

	public WebDriver frames4(WebElement element) {
		WebDriver el = driver.switchTo().frame(element);
		return el;
	}

	/* / Generating the Random Numbers / */

	public String UUID() {
		// Get the current timestamp in milliseconds
		long timestamp = System.currentTimeMillis();

		// Create a UUID using the timestamp
		UUID uuid = new UUID(timestamp, 0);
		String s = uuid.toString();

		// Print the generated UUID
		System.out.println("Generated UUID: " + uuid.toString());
		return s;
	}

	public void robotKeyPress() throws InterruptedException, AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_B);
		r.keyRelease(KeyEvent.VK_B);
		r.keyPress(KeyEvent.VK_O);
		r.keyRelease(KeyEvent.VK_O);
		r.keyPress(KeyEvent.VK_M);
		r.keyRelease(KeyEvent.VK_M);
	}

	public void robotKeyDown() throws InterruptedException, AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(500);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1200);
	}

	public static void typeSentence(Robot robot, String sentence) {
		sentence = sentence.toUpperCase();

		// Iterate through each character in the sentence
		for (int i = 0; i < sentence.length(); i++) {
			char c = sentence.charAt(i);

			// Check if the character is a letter or a space
			if (Character.isLetterOrDigit(c) || Character.isSpaceChar(c)) {
				// Get the KeyEvent constant for the corresponding character
				int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);

				// Simulate key press and release
				robot.keyPress(keyCode);
				robot.keyRelease(keyCode);

			} else if (c == '-') {
				// Simulate key press and release for Minus
				robot.keyPress(KeyEvent.VK_MINUS);
				robot.keyRelease(KeyEvent.VK_MINUS);

			} else if (c == '_') {
				// Simulate key press and release for Underscore
				robot.keyPress(KeyEvent.VK_UNDERSCORE);
				robot.keyRelease(KeyEvent.VK_UNDERSCORE);
			}
			// Introduce a small delay between key presses for readability
			robot.delay(50);
		}
	}

	public static int chk_tot_aloc_qty(int index, String check_partNo, int req_qty, List<WebElement> childElements) {
		int tot_alloc_qty = 0;
		for (int i = 0; i < childElements.size(); i++) {
			WebElement element = childElements.get(i);
			WebElement partNo_ele = element.findElement(By.xpath(".//div[@class='slick-cell l3 r3']"));
			String partNo = partNo_ele.getText();
			if (partNo.equals(check_partNo)) {
				WebElement alloc_qty_ele = element.findElement(By.xpath(".//div[@class='slick-cell l13 r13']"));
				int alloc_qty = Integer.parseInt(alloc_qty_ele.getText());
				if (alloc_qty != -1) {
					tot_alloc_qty = tot_alloc_qty + alloc_qty;
				}
			}
		}
		// check remaining qty
		int curr_req_qty = req_qty - tot_alloc_qty;
		return curr_req_qty;
	}

	public void excelwrite() {
		// Create a new workbook
		String filePath = "D:\\Automation Data\\GIT Scripts\\Login Page Automation Script\\erp_automation\\Excel\\Automation_Data_Issue.xlsx";

		// Define the row and column where you want to add the dynamic number
		int targetRow = 1; // Example: Row 3 (0-based index)
		int targetColumn = 14; // Example: Column B (0-based index)

		// Define the dynamic numbers
		long[] numbers = { 12345678901234567L, 23456789012345678L, 34567890123456789L };

		// Load the existing workbook
		Workbook workbook;
		try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
			workbook = new XSSFWorkbook(fileInputStream);

			// Get the sheet from the workbook
			Sheet sheet = workbook.getSheetAt(0); // Assuming it's the first sheet

			// Get or create the target row
			Row row = sheet.getRow(targetRow);
			if (row == null) {
				row = sheet.createRow(targetRow);
			}

			// Write the dynamic numbers to the specified column
			for (int i = 0; i < numbers.length; i++) {
				Cell cell = row.createCell(targetColumn + i, Cell.CELL_TYPE_NUMERIC);
				cell.setCellValue(numbers[i]);
			}

			// Write the changes back to the existing workbook
			try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
				workbook.write(fileOutputStream);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * public static void main(String[] args) { try { // Path to your VBScript file
	 * String vbsFilePath = "C:\\Users\\AntonyAshwinthAR\\Module1.vbs";
	 * 
	 * // Execute the VBScript file using cscript (Windows) or wscript (Windows GUI)
	 * // For example, using cscript: Process process =
	 * Runtime.getRuntime().exec("cscript " + vbsFilePath);
	 * 
	 * // Wait for the process to finish process.waitFor();
	 * 
	 * // Check the exit code (0 indicates success) int exitCode =
	 * process.exitValue(); if (exitCode == 0) {
	 * System.out.println("Excel file updated successfully."); } else {
	 * System.err.println("Error updating Excel file. Exit code: " + exitCode); } }
	 * catch (IOException | InterruptedException e) { e.printStackTrace(); } }
	 */

	public void MRI_Multiple_Lineitems_POGridFields_RM(WebDriver driver) throws IOException, InterruptedException {
		// RM Grid

//1st Line
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebElement costCenter = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l1 r1')]"));
		j.executeScript("arguments[0].click();", costCenter);
		WebElement costCenter1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
		String costcenter_String = getData("Grid_Data", 2, 0);
		select(costCenter1).selectByVisibleText(costcenter_String);

		WebElement expenseCategory = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", expenseCategory);
		WebElement expenseCategory1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
		String expensecategory_String = getData("Grid_Data", 2, 1);
		select(expenseCategory1).selectByVisibleText(expensecategory_String);

		WebElement partNo = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", partNo);
		WebElement partNo1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String grid_data = getData("Grid_Data", 2, 2);
		partNo1.sendKeys(grid_data);
		WebElement autoSuggestion = driver.findElement(By.xpath("//ul//li[3][@tabindex='-1']"));
		j.executeScript("window.scrollIntoView", autoSuggestion);
		j.executeScript("arguments[0].click();", autoSuggestion);

		WebElement packingType = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l4 r4')]"));
		j.executeScript("arguments[0].click();", packingType);
		Thread.sleep(500);
		int maxretries = 3;
		for (int i = 0; i < maxretries; i++) {
			try {
				packingType = driver
						.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l4 r4')]"));
				j.executeScript("arguments[0].click();", packingType);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		WebElement packingType1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l4 r4')]//select"));
		selectOptionByIndex(packingType1, 0);

		WebElement workType = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l5 r5')]"));
		j.executeScript("arguments[0].click();", workType);
		WebElement workType1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l5 r5')]//select"));
		selectOptionByIndex(workType1, 0);

		WebElement name = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l6 r6')]"));
		j.executeScript("arguments[0].click();", name);
		WebElement name1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l6 r6')]//input"));
		String grid_data1 = getData("Grid_Data", 2, 3);
		name1.sendKeys(grid_data1);
		WebElement autoSuggestion1 = driver.findElement(By.xpath("//*[@class=\"ui-menu-item\"][1]"));
		autoSuggestion1.click();

		WebElement qty = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l7 r7')]"));
		j.executeScript("arguments[0].click();", qty);
		WebElement qty1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l7 r7')]//input"));
		String grid_data2 = getData("Grid_Data", 2, 4);
		qty1.sendKeys(grid_data2);

		WebElement unitPrice = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l8 r8')]"));
		j.executeScript("arguments[0].click();", unitPrice);
		Thread.sleep(500);
		for (int i = 0; i < maxretries; i++) {
			try {
				unitPrice = driver
						.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l8 r8')]"));
				j.executeScript("arguments[0].click();", unitPrice);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		WebElement unitPrice1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l8 r8')]//input"));
		String grid_data3 = getData("Grid_Data", 2, 5);
		unitPrice1.sendKeys(grid_data3);

		WebElement UOM = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", UOM);
		WebElement UOM1 = driver.findElement(
				By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l12 r12')]//select"));
		selectOptionByIndex(UOM1, 0);

		WebElement deliveryDate = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", deliveryDate);
		WebElement deliverDate1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l13 r13')]//input"));
		String date1 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		deliverDate1.sendKeys(date1);

		// With IQC checkbox code

		WebElement checkBox = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l14 r14')]"));
		j.executeScript("arguments[0].click();", checkBox);
		WebElement checkBox1 = driver.findElement(By.xpath(
				".//div[@style='top:0px']//div[contains (@class, 'slick-cell l14 r14')]//input[@type='checkbox']"));
		j.executeScript("arguments[0].click();", checkBox1);
//			j.executeScript("arguments[0].click();", checkBox1);

		// Withot IQC Checkbox code

		WebElement insReason = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l15 r15')]"));
		j.executeScript("arguments[0].click();", insReason);
		WebElement reasonText = driver.findElement(By
				.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l15 r15')]//input[@type='text']"));
		reasonText.sendKeys("Not Required");
		driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l14 r14')]")).click();

		WebElement add_btn = driver.findElement(By.xpath("//div//button[@tooltipposition='bottom'][1]//i"));
		j.executeScript("arguments[0].click();", add_btn);

// 2nd Line

		int scrollAmount = 2000;
		WebElement slickGridScroll = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]"));
		j.executeScript("arguments[0].scrollLeft += arguments[1];", slickGridScroll, scrollAmount);
		Thread.sleep(1000);

		WebElement cost_Center = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l1 r1')]"));
		j.executeScript("arguments[0].click();", cost_Center);
		WebElement cost_Center1 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
		String cost_Center_String = getData("Grid_Data", 3, 0);
		select(cost_Center1).selectByVisibleText(cost_Center_String);

		WebElement expense_Category = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", expense_Category);
		WebElement expense_Category1 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
		String expense_Category_String = getData("Grid_Data", 3, 1);
		select(expense_Category1).selectByVisibleText(expense_Category_String);

		WebElement part_No = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", part_No);
		WebElement part_No1 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String part_No_String = getData("Grid_Data", 3, 2);
		part_No1.sendKeys(part_No_String);
		WebElement autoSuggestion2 = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
		j.executeScript("arguments[0].click();", autoSuggestion2);

		WebElement packing_Type = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l4 r4')]"));
		j.executeScript("arguments[0].click();", packing_Type);
		Thread.sleep(500);
		for (int i = 0; i < maxretries; i++) {
			try {
				packing_Type = driver
						.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l4 r4')]"));
				j.executeScript("arguments[0].click();", packing_Type);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		WebElement packing_Type1 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l4 r4')]//select"));
		selectOptionByIndex(packing_Type1, 0);

		WebElement work_Type = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l5 r5')]"));
		j.executeScript("arguments[0].click();", work_Type);
		WebElement work_Type1 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l5 r5')]//select"));
		selectOptionByIndex(work_Type1, 0);

		WebElement name2 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l6 r6')]"));
		j.executeScript("arguments[0].click();", name2);
		WebElement name3 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l6 r6')]//input"));
		String name2_string = getData("Grid_Data", 3, 3);
		name3.sendKeys(name2_string);
		WebElement autoSuggestion3 = driver.findElement(By.xpath("//*[@class=\"ui-menu-item\"][1]"));
		j.executeScript("arguments[0].click();", autoSuggestion3);

		WebElement qty2 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l7 r7')]"));
		j.executeScript("arguments[0].click();", qty2);
		WebElement qty3 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l7 r7')]//input"));
		String qty2_string = getData("Grid_Data", 3, 4);
		qty3.sendKeys(qty2_string);

		WebElement unit_Price = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l8 r8')]"));
		j.executeScript("arguments[0].click();", unit_Price);
		Thread.sleep(500);
		for (int i = 0; i < maxretries; i++) {
			try {
				unit_Price = driver
						.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l8 r8')]"));
				j.executeScript("arguments[0].click();", unit_Price);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		WebElement unit_Price1 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l8 r8')]//input"));
		String unit_Price_string = getData("Grid_Data", 3, 5);
		unit_Price1.sendKeys(unit_Price_string);

		WebElement UOM2 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", UOM2);
		WebElement UOM3 = driver.findElement(
				By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l12 r12')]//select"));
		selectOptionByIndex(UOM3, 0);

		WebElement delivery_Date = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", delivery_Date);
		WebElement delivery_Date1 = driver.findElement(
				By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l13 r13')]//input"));
		String delivery_Date_string = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		delivery_Date1.sendKeys(delivery_Date_string);

		// With IQC checkbox code

		WebElement check_Box = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l14 r14')]"));
		j.executeScript("arguments[0].click();", check_Box);
		WebElement check_Box1 = driver.findElement(By.xpath(
				".//div[@style='top:25px']//div[contains (@class, 'slick-cell l14 r14')]//input[@type='checkbox']"));
		j.executeScript("arguments[0].click();", check_Box1);

		// Withot IQC Checkbox code

		WebElement ins_Reason = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l15 r15')]"));
		j.executeScript("arguments[0].click();", ins_Reason);
		WebElement reason_Text = driver.findElement(By
				.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l15 r15')]//input[@type='text']"));
		reason_Text.sendKeys("Not Required");
		driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l14 r14')]")).click();

		j.executeScript("arguments[0].click();", add_btn);

// 3rd Line

		j.executeScript("arguments[0].scrollLeft += arguments[1];", slickGridScroll, scrollAmount);
		Thread.sleep(1000);

		WebElement cost_Center2 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l1 r1')]"));
		j.executeScript("arguments[0].click();", cost_Center2);
		WebElement cost_Center3 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
		String cost_Center1_String = getData("Grid_Data", 4, 0);
		select(cost_Center3).selectByVisibleText(cost_Center1_String);

		WebElement expense_Category2 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", expense_Category2);
		WebElement expense_Category3 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
		String expense_Category_String1 = getData("Grid_Data", 4, 1);
		select(expense_Category3).selectByVisibleText(expense_Category_String1);

		WebElement part_No2 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", part_No2);
		WebElement part_No3 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String part_No_String1 = getData("Grid_Data", 4, 2);
		part_No3.sendKeys(part_No_String1);
		WebElement autoSuggestion4 = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
		j.executeScript("arguments[0].click();", autoSuggestion4);

		WebElement packing_Type2 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l4 r4')]"));
		j.executeScript("arguments[0].click();", packing_Type2);
		Thread.sleep(500);
		for (int i = 0; i < maxretries; i++) {
			try {
				packing_Type2 = driver
						.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l4 r4')]"));
				j.executeScript("arguments[0].click();", packing_Type2);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		WebElement packing_Type3 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l4 r4')]//select"));
		selectOptionByIndex(packing_Type3, 0);

		WebElement work_Type2 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l5 r5')]"));
		j.executeScript("arguments[0].click();", work_Type2);
		WebElement work_Type3 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l5 r5')]//select"));
		selectOptionByIndex(work_Type3, 0);

		WebElement name4 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l6 r6')]"));
		j.executeScript("arguments[0].click();", name4);
		WebElement name5 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l6 r6')]//input"));
		String name2_string1 = getData("Grid_Data", 4, 3);
		name5.sendKeys(name2_string1);
		WebElement autoSuggestion5 = driver.findElement(By.xpath("//*[@class=\"ui-menu-item\"][1]"));
		j.executeScript("arguments[0].click();", autoSuggestion5);

		WebElement qty4 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l7 r7')]"));
		j.executeScript("arguments[0].click();", qty4);
		WebElement qty5 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l7 r7')]//input"));
		String qty2_string1 = getData("Grid_Data", 4, 4);
		qty5.sendKeys(qty2_string1);

		WebElement unit_Price2 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l8 r8')]"));
		j.executeScript("arguments[0].click();", unit_Price2);
		Thread.sleep(500);
		for (int i = 0; i < maxretries; i++) {
			try {
				unit_Price2 = driver
						.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l8 r8')]"));
				j.executeScript("arguments[0].click();", unit_Price2);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		WebElement unit_Price3 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l8 r8')]//input"));
		String unit_Price_string1 = getData("Grid_Data", 4, 5);
		unit_Price3.sendKeys(unit_Price_string1);

		WebElement UOM4 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", UOM4);
		WebElement UOM5 = driver.findElement(
				By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l12 r12')]//select"));
		selectOptionByIndex(UOM5, 0);

		WebElement delivery_Date2 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", delivery_Date2);
		WebElement delivery_Date3 = driver.findElement(
				By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l13 r13')]//input"));
		String delivery_Date_string1 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		delivery_Date3.sendKeys(delivery_Date_string1);

		// With IQC checkbox code

		WebElement check_Box2 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l14 r14')]"));
		j.executeScript("arguments[0].click();", check_Box2);
		WebElement check_Box3 = driver.findElement(By.xpath(
				".//div[@style='top:50px']//div[contains (@class, 'slick-cell l14 r14')]//input[@type='checkbox']"));
		j.executeScript("arguments[0].click();", check_Box3);

		// Withot IQC Checkbox code

		WebElement ins_Reason1 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l15 r15')]"));
		j.executeScript("arguments[0].click();", ins_Reason1);
		WebElement reason_Text1 = driver.findElement(By
				.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l15 r15')]//input[@type='text']"));
		reason_Text1.sendKeys("Not Required");
		driver.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l14 r14')]")).click();

		j.executeScript("arguments[0].click();", add_btn);

// 4th Line

		j.executeScript("arguments[0].scrollLeft += arguments[1];", slickGridScroll, scrollAmount);
		Thread.sleep(1000);

		WebElement cost_Center4 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l1 r1')]"));
		j.executeScript("arguments[0].click();", cost_Center4);
		WebElement cost_Center5 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
		String cost_Center_String1 = getData("Grid_Data", 5, 0);
		select(cost_Center5).selectByVisibleText(cost_Center_String1);

		WebElement expense_Category4 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", expense_Category4);
		WebElement expense_Category5 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
		String expense_Category_String2 = getData("Grid_Data", 5, 1);
		select(expense_Category5).selectByVisibleText(expense_Category_String2);

		WebElement part_No4 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", part_No4);
		WebElement part_No5 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String part_No_String2 = getData("Grid_Data", 5, 2);
		part_No5.sendKeys(part_No_String2);
		WebElement autoSuggestion6 = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
		j.executeScript("arguments[0].click();", autoSuggestion6);

		WebElement packing_Type4 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l4 r4')]"));
		j.executeScript("arguments[0].click();", packing_Type4);
		Thread.sleep(500);
		for (int i = 0; i < maxretries; i++) {
			try {
				packing_Type4 = driver
						.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l4 r4')]"));
				j.executeScript("arguments[0].click();", packing_Type4);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		WebElement packing_Type5 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l4 r4')]//select"));
		selectOptionByIndex(packing_Type5, 0);

		WebElement work_Type4 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l5 r5')]"));
		j.executeScript("arguments[0].click();", work_Type4);
		WebElement work_Type5 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l5 r5')]//select"));
		selectOptionByIndex(work_Type5, 0);

		WebElement name6 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l6 r6')]"));
		j.executeScript("arguments[0].click();", name6);
		WebElement name7 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l6 r6')]//input"));
		String name_string = getData("Grid_Data", 5, 3);
		name7.sendKeys(name_string);
		WebElement autoSuggestion7 = driver.findElement(By.xpath("//*[@class=\"ui-menu-item\"][1]"));
		j.executeScript("arguments[0].click();", autoSuggestion7);

		WebElement qty6 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l7 r7')]"));
		j.executeScript("arguments[0].click();", qty6);
		WebElement qty7 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l7 r7')]//input"));
		String qty_string = getData("Grid_Data", 5, 4);
		qty7.sendKeys(qty_string);

		WebElement unit_Price4 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l8 r8')]"));
		j.executeScript("arguments[0].click();", unit_Price4);
		Thread.sleep(500);
		for (int i = 0; i < maxretries; i++) {
			try {
				unit_Price4 = driver
						.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l8 r8')]"));
				j.executeScript("arguments[0].click();", unit_Price4);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		WebElement unit_Price5 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l8 r8')]//input"));
		String unit_Price_string2 = getData("Grid_Data", 5, 5);
		unit_Price5.sendKeys(unit_Price_string2);

		WebElement UOM6 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", UOM6);
		WebElement UOM7 = driver.findElement(
				By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l12 r12')]//select"));
		selectOptionByIndex(UOM7, 0);

		WebElement delivery_Date4 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", delivery_Date4);
		WebElement delivery_Date5 = driver.findElement(
				By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l13 r13')]//input"));
		String delivery_Date_string2 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		delivery_Date5.sendKeys(delivery_Date_string2);

		// With IQC checkbox code

		WebElement check_Box4 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l14 r14')]"));
		j.executeScript("arguments[0].click();", check_Box4);
		WebElement check_Box5 = driver.findElement(By.xpath(
				".//div[@style='top:75px']//div[contains (@class, 'slick-cell l14 r14')]//input[@type='checkbox']"));
		j.executeScript("arguments[0].click();", check_Box5);

		// Withot IQC Checkbox code

		WebElement ins_Reason2 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l15 r15')]"));
		j.executeScript("arguments[0].click();", ins_Reason2);
		WebElement reason_Text2 = driver.findElement(By
				.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l15 r15')]//input[@type='text']"));
		reason_Text2.sendKeys("Not Required");
		driver.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l14 r14')]")).click();

		j.executeScript("arguments[0].click();", add_btn);

// 5th Line

		j.executeScript("arguments[0].scrollLeft += arguments[1];", slickGridScroll, scrollAmount);
		Thread.sleep(1000);

		WebElement cost_Center6 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l1 r1')]"));
		j.executeScript("arguments[0].click();", cost_Center6);
		WebElement cost_Center7 = driver.findElement(
				By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
		String cost_Center_String2 = getData("Grid_Data", 6, 0);
		select(cost_Center7).selectByVisibleText(cost_Center_String2);

		WebElement expense_Category6 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", expense_Category6);
		WebElement expense_Category7 = driver.findElement(
				By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
		String expense_Category_String3 = getData("Grid_Data", 6, 1);
		select(expense_Category7).selectByVisibleText(expense_Category_String3);

		WebElement part_No6 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", part_No6);
		WebElement part_No7 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String part_No_String3 = getData("Grid_Data", 6, 2);
		part_No7.sendKeys(part_No_String3);
		WebElement autoSuggestion8 = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
		j.executeScript("arguments[0].click();", autoSuggestion8);

		WebElement packing_Type6 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l4 r4')]"));
		j.executeScript("arguments[0].click();", packing_Type6);
		Thread.sleep(500);
		for (int i = 0; i < maxretries; i++) {
			try {
				packing_Type6 = driver.findElement(
						By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l4 r4')]"));
				j.executeScript("arguments[0].click();", packing_Type6);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		WebElement packing_Type7 = driver.findElement(
				By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l4 r4')]//select"));
		selectOptionByIndex(packing_Type7, 0);

		WebElement work_Type6 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l5 r5')]"));
		j.executeScript("arguments[0].click();", work_Type6);
		WebElement work_Type7 = driver.findElement(
				By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l5 r5')]//select"));
		selectOptionByIndex(work_Type7, 0);

		WebElement name8 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l6 r6')]"));
		j.executeScript("arguments[0].click();", name8);
		WebElement name9 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l6 r6')]//input"));
		String name_string1 = getData("Grid_Data", 6, 3);
		name9.sendKeys(name_string1);
		WebElement autoSuggestion9 = driver.findElement(By.xpath("//*[@class=\"ui-menu-item\"][1]"));
		j.executeScript("arguments[0].click();", autoSuggestion9);

		WebElement qty8 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l7 r7')]"));
		j.executeScript("arguments[0].click();", qty8);
		WebElement qty9 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l7 r7')]//input"));
		String qty_string1 = getData("Grid_Data", 6, 4);
		qty9.sendKeys(qty_string1);

		WebElement unit_Price6 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l8 r8')]"));
		j.executeScript("arguments[0].click();", unit_Price6);
		Thread.sleep(500);
		for (int i = 0; i < maxretries; i++) {
			try {
				unit_Price6 = driver.findElement(
						By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l8 r8')]"));
				j.executeScript("arguments[0].click();", unit_Price6);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		WebElement unit_Price7 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l8 r8')]//input"));
		String unit_Price_string3 = getData("Grid_Data", 6, 5);
		unit_Price7.sendKeys(unit_Price_string3);

		WebElement UOM8 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", UOM8);
		WebElement UOM9 = driver.findElement(
				By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l12 r12')]//select"));
		selectOptionByIndex(UOM9, 0);

		WebElement delivery_Date6 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", delivery_Date6);
		WebElement delivery_Date7 = driver.findElement(
				By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l13 r13')]//input"));
		String delivery_Date_string3 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		delivery_Date7.sendKeys(delivery_Date_string3);

		// With IQC checkbox code

		WebElement check_Box6 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l14 r14')]"));
		j.executeScript("arguments[0].click();", check_Box6);
		WebElement check_Box7 = driver.findElement(By.xpath(
				".//div[@style='top:100px']//div[contains (@class, 'slick-cell l14 r14')]//input[@type='checkbox']"));
		j.executeScript("arguments[0].click();", check_Box7);

		// Withot IQC Checkbox code

		WebElement ins_Reason3 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l15 r15')]"));
		j.executeScript("arguments[0].click();", ins_Reason3);
		WebElement reason_Text3 = driver.findElement(By.xpath(
				".//div[@style='top:100px']//div[contains (@class, 'slick-cell l15 r15')]//input[@type='text']"));
		reason_Text3.sendKeys("Not Required");
		driver.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l14 r14')]"))
				.click();

		j.executeScript("arguments[0].click();", add_btn);

// 6th Line

		j.executeScript("arguments[0].scrollLeft += arguments[1];", slickGridScroll, scrollAmount);
		Thread.sleep(1000);

		WebElement cost_Center8 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l1 r1')]"));
		j.executeScript("arguments[0].click();", cost_Center8);
		WebElement cost_Center9 = driver.findElement(
				By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
		String cost_Center_String3 = getData("Grid_Data", 7, 0);
		select(cost_Center9).selectByVisibleText(cost_Center_String3);

		WebElement expense_Category8 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", expense_Category8);
		WebElement expense_Category9 = driver.findElement(
				By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
		String expense_Category_String4 = getData("Grid_Data", 7, 1);
		select(expense_Category9).selectByVisibleText(expense_Category_String4);

		WebElement part_No8 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", part_No8);
		WebElement part_No9 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String part_No_String4 = getData("Grid_Data", 7, 2);
		part_No9.sendKeys(part_No_String4);
		WebElement autoSuggestion10 = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
		j.executeScript("arguments[0].click();", autoSuggestion10);

		WebElement packing_Type8 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l4 r4')]"));
		j.executeScript("arguments[0].click();", packing_Type8);
		Thread.sleep(500);
		for (int i = 0; i < maxretries; i++) {
			try {
				packing_Type8 = driver.findElement(
						By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l4 r4')]"));
				j.executeScript("arguments[0].click();", packing_Type8);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		WebElement packing_Type9 = driver.findElement(
				By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l4 r4')]//select"));
		selectOptionByIndex(packing_Type9, 0);

		WebElement work_Type8 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l5 r5')]"));
		j.executeScript("arguments[0].click();", work_Type8);
		WebElement work_Type9 = driver.findElement(
				By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l5 r5')]//select"));
		selectOptionByIndex(work_Type9, 0);

		WebElement name10 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l6 r6')]"));
		j.executeScript("arguments[0].click();", name10);
		WebElement name11 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l6 r6')]//input"));
		String name_string2 = getData("Grid_Data", 7, 3);
		name11.sendKeys(name_string2);
		WebElement autoSuggestion11 = driver.findElement(By.xpath("//*[@class=\"ui-menu-item\"][1]"));
		j.executeScript("arguments[0].click();", autoSuggestion11);

		WebElement qty10 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l7 r7')]"));
		j.executeScript("arguments[0].click();", qty10);
		WebElement qty11 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l7 r7')]//input"));
		String qty_string2 = getData("Grid_Data", 7, 4);
		qty11.sendKeys(qty_string2);

		WebElement unit_Price8 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l8 r8')]"));
		j.executeScript("arguments[0].click();", unit_Price8);
		Thread.sleep(500);
		for (int i = 0; i < maxretries; i++) {
			try {
				unit_Price8 = driver.findElement(
						By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l8 r8')]"));
				j.executeScript("arguments[0].click();", unit_Price8);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		WebElement unit_Price9 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l8 r8')]//input"));
		String unit_Price_string4 = getData("Grid_Data", 7, 5);
		unit_Price9.sendKeys(unit_Price_string4);

		WebElement UOM10 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", UOM10);
		WebElement UOM11 = driver.findElement(
				By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l12 r12')]//select"));
		selectOptionByIndex(UOM11, 0);

		WebElement delivery_Date8 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", delivery_Date8);
		WebElement delivery_Date9 = driver.findElement(
				By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l13 r13')]//input"));
		String delivery_Date_string4 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		delivery_Date9.sendKeys(delivery_Date_string4);

		// With IQC checkbox code

		WebElement check_Box8 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l14 r14')]"));
		j.executeScript("arguments[0].click();", check_Box8);
		WebElement check_Box9 = driver.findElement(By.xpath(
				".//div[@style='top:125px']//div[contains (@class, 'slick-cell l14 r14')]//input[@type='checkbox']"));
		j.executeScript("arguments[0].click();", check_Box9);

		// Without IQC Checkbox code

		WebElement ins_Reason4 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l15 r15')]"));
		j.executeScript("arguments[0].click();", ins_Reason4);
		WebElement reason_Text4 = driver.findElement(By.xpath(
				".//div[@style='top:125px']//div[contains (@class, 'slick-cell l15 r15')]//input[@type='text']"));
		reason_Text4.sendKeys("Not Required");
		driver.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l14 r14')]"))
				.click();

		j.executeScript("arguments[0].click();", add_btn);

// 7th Line

		j.executeScript("arguments[0].scrollLeft += arguments[1];", slickGridScroll, scrollAmount);
		Thread.sleep(1000);

		WebElement cost_Center10 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l1 r1')]"));
		j.executeScript("arguments[0].click();", cost_Center10);
		WebElement cost_Center11 = driver.findElement(
				By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
		String cost_Center_String4 = getData("Grid_Data", 8, 0);
		select(cost_Center11).selectByVisibleText(cost_Center_String4);

		WebElement expense_Category10 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", expense_Category10);
		WebElement expense_Category11 = driver.findElement(
				By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
		String expense_Category_String5 = getData("Grid_Data", 8, 1);
		select(expense_Category11).selectByVisibleText(expense_Category_String5);

		WebElement part_No10 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", part_No10);
		WebElement part_No11 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String part_No_String5 = getData("Grid_Data", 8, 2);
		part_No11.sendKeys(part_No_String5);
		WebElement autoSuggestion12 = driver.findElement(By.xpath("//ul//li[2][@tabindex='-1']"));
		j.executeScript("window.scrollIntoView", autoSuggestion12);
		j.executeScript("arguments[0].click();", autoSuggestion12);

		WebElement packing_Type10 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l4 r4')]"));
		j.executeScript("arguments[0].click();", packing_Type10);
		Thread.sleep(500);
		for (int i = 0; i < maxretries; i++) {
			try {
				packing_Type10 = driver.findElement(
						By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l4 r4')]"));
				j.executeScript("arguments[0].click();", packing_Type10);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		WebElement packing_Type11 = driver.findElement(
				By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l4 r4')]//select"));
		selectOptionByIndex(packing_Type11, 0);

		WebElement work_Type10 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l5 r5')]"));
		j.executeScript("arguments[0].click();", work_Type10);
		WebElement work_Type11 = driver.findElement(
				By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l5 r5')]//select"));
		selectOptionByIndex(work_Type11, 0);

		WebElement name12 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l6 r6')]"));
		j.executeScript("arguments[0].click();", name12);
		WebElement name13 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l6 r6')]//input"));
		String name_string3 = getData("Grid_Data", 8, 3);
		name13.sendKeys(name_string3);
		WebElement autoSuggestion13 = driver.findElement(By.xpath("//*[@class=\"ui-menu-item\"][1]"));
		j.executeScript("arguments[0].click();", autoSuggestion13);

		WebElement qty12 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l7 r7')]"));
		j.executeScript("arguments[0].click();", qty12);
		WebElement qty13 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l7 r7')]//input"));
		String qty_string3 = getData("Grid_Data", 8, 4);
		qty13.sendKeys(qty_string3);

		WebElement unit_Price10 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l8 r8')]"));
		j.executeScript("arguments[0].click();", unit_Price10);
		Thread.sleep(500);
		for (int i = 0; i < maxretries; i++) {
			try {
				unit_Price10 = driver.findElement(
						By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l8 r8')]"));
				j.executeScript("arguments[0].click();", unit_Price10);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		WebElement unit_Price11 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l8 r8')]//input"));
		String unit_Price_string5 = getData("Grid_Data", 8, 5);
		unit_Price11.sendKeys(unit_Price_string5);

		WebElement UOM12 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", UOM12);
		WebElement UOM13 = driver.findElement(
				By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l12 r12')]//select"));
		selectOptionByIndex(UOM13, 0);

		WebElement delivery_Date10 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", delivery_Date10);
		WebElement delivery_Date11 = driver.findElement(
				By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l13 r13')]//input"));
		String delivery_Date_string5 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		delivery_Date11.sendKeys(delivery_Date_string5);

		// With IQC checkbox code

		WebElement check_Box10 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l14 r14')]"));
		j.executeScript("arguments[0].click();", check_Box10);
		WebElement check_Box11 = driver.findElement(By.xpath(
				".//div[@style='top:150px']//div[contains (@class, 'slick-cell l14 r14')]//input[@type='checkbox']"));
		j.executeScript("arguments[0].click();", check_Box11);

		// Withot IQC Checkbox code

		WebElement ins_Reason5 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l15 r15')]"));
		j.executeScript("arguments[0].click();", ins_Reason5);
		WebElement reason_Text5 = driver.findElement(By.xpath(
				".//div[@style='top:150px']//div[contains (@class, 'slick-cell l15 r15')]//input[@type='text']"));
		reason_Text5.sendKeys("Not Required");
		driver.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l14 r14')]"))
				.click();

		j.executeScript("arguments[0].click();", add_btn);

// 8th Line

		j.executeScript("arguments[0].scrollLeft += arguments[1];", slickGridScroll, scrollAmount);
		Thread.sleep(1000);

		WebElement cost_Center12 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l1 r1')]"));
		j.executeScript("arguments[0].click();", cost_Center12);
		WebElement cost_Center13 = driver.findElement(
				By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
		String cost_Center_String5 = getData("Grid_Data", 9, 0);
		select(cost_Center13).selectByVisibleText(cost_Center_String5);

		WebElement expense_Category12 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", expense_Category12);
		WebElement expense_Category13 = driver.findElement(
				By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
		String expense_Category_String6 = getData("Grid_Data", 9, 1);
		select(expense_Category13).selectByVisibleText(expense_Category_String6);

		WebElement part_No12 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", part_No12);
		WebElement part_No13 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String part_No_String6 = getData("Grid_Data", 9, 2);
		part_No13.sendKeys(part_No_String6);
		WebElement autoSuggestion14 = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
		j.executeScript("arguments[0].click();", autoSuggestion14);

		WebElement packing_Type12 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l4 r4')]"));
		j.executeScript("arguments[0].click();", packing_Type12);
		Thread.sleep(500);
		for (int i = 0; i < maxretries; i++) {
			try {
				packing_Type12 = driver.findElement(
						By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l4 r4')]"));
				j.executeScript("arguments[0].click();", packing_Type12);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		WebElement packing_Type13 = driver.findElement(
				By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l4 r4')]//select"));
		selectOptionByIndex(packing_Type13, 0);

		WebElement work_Type12 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l5 r5')]"));
		j.executeScript("arguments[0].click();", work_Type12);
		WebElement work_Type13 = driver.findElement(
				By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l5 r5')]//select"));
		selectOptionByIndex(work_Type13, 0);

		WebElement name14 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l6 r6')]"));
		j.executeScript("arguments[0].click();", name14);
		WebElement name15 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l6 r6')]//input"));
		String name_string4 = getData("Grid_Data", 9, 3);
		name15.sendKeys(name_string4);
		WebElement autoSuggestion15 = driver.findElement(By.xpath("//*[@class=\"ui-menu-item\"][1]"));
		j.executeScript("arguments[0].click();", autoSuggestion15);

		WebElement qty14 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l7 r7')]"));
		j.executeScript("arguments[0].click();", qty14);
		WebElement qty15 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l7 r7')]//input"));
		String qty_string4 = getData("Grid_Data", 9, 4);
		qty15.sendKeys(qty_string4);

		WebElement unit_Price12 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l8 r8')]"));
		j.executeScript("arguments[0].click();", unit_Price12);
		Thread.sleep(500);
		for (int i = 0; i < maxretries; i++) {
			try {
				unit_Price12 = driver.findElement(
						By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l8 r8')]"));
				j.executeScript("arguments[0].click();", unit_Price12);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		WebElement unit_Price13 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l8 r8')]//input"));
		String unit_Price_string6 = getData("Grid_Data", 9, 5);
		unit_Price13.sendKeys(unit_Price_string6);

		WebElement UOM14 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", UOM14);
		WebElement UOM15 = driver.findElement(
				By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l12 r12')]//select"));
		selectOptionByIndex(UOM15, 0);

		WebElement delivery_Date12 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", delivery_Date12);
		WebElement delivery_Date13 = driver.findElement(
				By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l13 r13')]//input"));
		String delivery_Date_string6 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		delivery_Date13.sendKeys(delivery_Date_string6);

		// With IQC checkbox code

		WebElement check_Box12 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l14 r14')]"));
		j.executeScript("arguments[0].click();", check_Box12);
		WebElement check_Box13 = driver.findElement(By.xpath(
				".//div[@style='top:175px']//div[contains (@class, 'slick-cell l14 r14')]//input[@type='checkbox']"));
		j.executeScript("arguments[0].click();", check_Box13);

		// Withot IQC Checkbox code

		WebElement ins_Reason6 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l15 r15')]"));
		j.executeScript("arguments[0].click();", ins_Reason6);
		WebElement reason_Text6 = driver.findElement(By.xpath(
				".//div[@style='top:175px']//div[contains (@class, 'slick-cell l15 r15')]//input[@type='text']"));
		reason_Text6.sendKeys("Not Required");
		driver.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l14 r14')]"))
				.click();

		j.executeScript("arguments[0].click();", add_btn);

// 9th Line

		j.executeScript("arguments[0].scrollLeft += arguments[1];", slickGridScroll, scrollAmount);
		Thread.sleep(1000);

		WebElement cost_Center14 = driver
				.findElement(By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l1 r1')]"));
		j.executeScript("arguments[0].click();", cost_Center14);
		WebElement cost_Center15 = driver.findElement(
				By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
		String cost_Center_String6 = getData("Grid_Data", 10, 0);
		select(cost_Center15).selectByVisibleText(cost_Center_String6);

		WebElement expense_Category14 = driver
				.findElement(By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", expense_Category14);
		WebElement expense_Category15 = driver.findElement(
				By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
		String expense_Category_String7 = getData("Grid_Data", 10, 1);
		select(expense_Category15).selectByVisibleText(expense_Category_String7);

		WebElement part_No14 = driver
				.findElement(By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", part_No14);
		WebElement part_No15 = driver
				.findElement(By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String part_No_String7 = getData("Grid_Data", 10, 2);
		part_No15.sendKeys(part_No_String7);
		WebElement autoSuggestion16 = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
		j.executeScript("arguments[0].click();", autoSuggestion16);

		WebElement packing_Type14 = driver
				.findElement(By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l4 r4')]"));
		j.executeScript("arguments[0].click();", packing_Type14);
		Thread.sleep(500);
		for (int i = 0; i < maxretries; i++) {
			try {
				packing_Type14 = driver.findElement(
						By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l4 r4')]"));
				j.executeScript("arguments[0].click();", packing_Type14);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		WebElement packing_Type15 = driver.findElement(
				By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l4 r4')]//select"));
		selectOptionByIndex(packing_Type15, 0);

		WebElement work_Type14 = driver
				.findElement(By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l5 r5')]"));
		j.executeScript("arguments[0].click();", work_Type14);
		WebElement work_Type15 = driver.findElement(
				By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l5 r5')]//select"));
		selectOptionByIndex(work_Type15, 0);

		WebElement name16 = driver
				.findElement(By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l6 r6')]"));
		j.executeScript("arguments[0].click();", name16);
		WebElement name17 = driver
				.findElement(By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l6 r6')]//input"));
		String name_string5 = getData("Grid_Data", 10, 3);
		name17.sendKeys(name_string5);
		WebElement autoSuggestion17 = driver.findElement(By.xpath("//*[@class=\"ui-menu-item\"][1]"));
		j.executeScript("arguments[0].click();", autoSuggestion17);

		WebElement qty16 = driver
				.findElement(By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l7 r7')]"));
		j.executeScript("arguments[0].click();", qty16);
		WebElement qty17 = driver
				.findElement(By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l7 r7')]//input"));
		String qty_string5 = getData("Grid_Data", 10, 4);
		qty17.sendKeys(qty_string5);

		WebElement unit_Price14 = driver
				.findElement(By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l8 r8')]"));
		j.executeScript("arguments[0].click();", unit_Price14);
		Thread.sleep(500);
		for (int i = 0; i < maxretries; i++) {
			try {
				unit_Price14 = driver.findElement(
						By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l8 r8')]"));
				j.executeScript("arguments[0].click();", unit_Price14);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		WebElement unit_Price15 = driver
				.findElement(By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l8 r8')]//input"));
		String unit_Price_string7 = getData("Grid_Data", 10, 5);
		unit_Price15.sendKeys(unit_Price_string7);

		WebElement UOM16 = driver
				.findElement(By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", UOM16);
		WebElement UOM17 = driver.findElement(
				By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l12 r12')]//select"));
		selectOptionByIndex(UOM17, 0);

		WebElement delivery_Date14 = driver
				.findElement(By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", delivery_Date14);
		WebElement delivery_Date15 = driver.findElement(
				By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l13 r13')]//input"));
		String delivery_Date_string7 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		delivery_Date15.sendKeys(delivery_Date_string7);

		// With IQC checkbox code

		WebElement check_Box14 = driver
				.findElement(By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l14 r14')]"));
		j.executeScript("arguments[0].click();", check_Box14);
		WebElement check_Box15 = driver.findElement(By.xpath(
				".//div[@style='top:200px']//div[contains (@class, 'slick-cell l14 r14')]//input[@type='checkbox']"));
		j.executeScript("arguments[0].click();", check_Box15);

		// Withot IQC Checkbox code

		WebElement ins_Reason7 = driver
				.findElement(By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l15 r15')]"));
		j.executeScript("arguments[0].click();", ins_Reason7);
		WebElement reason_Text7 = driver.findElement(By.xpath(
				".//div[@style='top:200px']//div[contains (@class, 'slick-cell l15 r15')]//input[@type='text']"));
		reason_Text7.sendKeys("Not Required");
		driver.findElement(By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l14 r14')]"))
				.click();

		j.executeScript("arguments[0].click();", add_btn);

// 10th Line

		j.executeScript("arguments[0].scrollLeft += arguments[1];", slickGridScroll, scrollAmount);
		Thread.sleep(1000);

		WebElement cost_Center16 = driver
				.findElement(By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l1 r1')]"));
		j.executeScript("arguments[0].click();", cost_Center16);
		WebElement cost_Center17 = driver.findElement(
				By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
		String cost_Center_String7 = getData("Grid_Data", 11, 0);
		select(cost_Center17).selectByVisibleText(cost_Center_String7);

		WebElement expense_Category16 = driver
				.findElement(By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", expense_Category16);
		WebElement expense_Category17 = driver.findElement(
				By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
		String expense_Category_String8 = getData("Grid_Data", 11, 1);
		select(expense_Category17).selectByVisibleText(expense_Category_String8);

		WebElement part_No16 = driver
				.findElement(By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", part_No16);
		WebElement part_No17 = driver
				.findElement(By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String part_No_String8 = getData("Grid_Data", 11, 2);
		part_No17.sendKeys(part_No_String8);
		WebElement autoSuggestion18 = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
		j.executeScript("arguments[0].click();", autoSuggestion18);

		WebElement packing_Type16 = driver
				.findElement(By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l4 r4')]"));
		j.executeScript("arguments[0].click();", packing_Type16);
		Thread.sleep(500);
		for (int i = 0; i < maxretries; i++) {
			try {
				packing_Type16 = driver.findElement(
						By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l4 r4')]"));
				j.executeScript("arguments[0].click();", packing_Type16);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		WebElement packing_Type17 = driver.findElement(
				By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l4 r4')]//select"));
		selectOptionByIndex(packing_Type17, 0);

		WebElement work_Type16 = driver
				.findElement(By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l5 r5')]"));
		j.executeScript("arguments[0].click();", work_Type16);
		WebElement work_Type17 = driver.findElement(
				By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l5 r5')]//select"));
		selectOptionByIndex(work_Type17, 0);

		WebElement name18 = driver
				.findElement(By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l6 r6')]"));
		j.executeScript("arguments[0].click();", name18);
		WebElement name19 = driver
				.findElement(By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l6 r6')]//input"));
		String name_string6 = getData("Grid_Data", 11, 3);
		name19.sendKeys(name_string6);
		WebElement autoSuggestion19 = driver.findElement(By.xpath("//*[@class=\"ui-menu-item\"][1]"));
		j.executeScript("arguments[0].click();", autoSuggestion19);

		WebElement qty18 = driver
				.findElement(By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l7 r7')]"));
		j.executeScript("arguments[0].click();", qty18);
		WebElement qty19 = driver
				.findElement(By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l7 r7')]//input"));
		String qty_string6 = getData("Grid_Data", 11, 4);
		qty19.sendKeys(qty_string6);

		WebElement unit_Price16 = driver
				.findElement(By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l8 r8')]"));
		j.executeScript("arguments[0].click();", unit_Price16);
		Thread.sleep(500);
		for (int i = 0; i < maxretries; i++) {
			try {
				unit_Price16 = driver.findElement(
						By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l8 r8')]"));
				j.executeScript("arguments[0].click();", unit_Price16);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}
		WebElement unit_Price17 = driver
				.findElement(By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l8 r8')]//input"));
		String unit_Price_string8 = getData("Grid_Data", 11, 5);
		unit_Price17.sendKeys(unit_Price_string8);

		WebElement UOM18 = driver
				.findElement(By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", UOM18);
		WebElement UOM19 = driver.findElement(
				By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l12 r12')]//select"));
		selectOptionByIndex(UOM19, 0);

		WebElement delivery_Date16 = driver
				.findElement(By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", delivery_Date16);
		WebElement delivery_Date17 = driver.findElement(
				By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l13 r13')]//input"));
		String delivery_Date_string8 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		delivery_Date17.sendKeys(delivery_Date_string8);

		// With IQC checkbox code

		WebElement check_Box16 = driver
				.findElement(By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l14 r14')]"));
		j.executeScript("arguments[0].click();", check_Box16);
		WebElement check_Box17 = driver.findElement(By.xpath(
				".//div[@style='top:225px']//div[contains (@class, 'slick-cell l14 r14')]//input[@type='checkbox']"));
		j.executeScript("arguments[0].click();", check_Box17);

		// Withot IQC Checkbox code

		WebElement ins_Reason8 = driver
				.findElement(By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l15 r15')]"));
		j.executeScript("arguments[0].click();", ins_Reason8);
		WebElement reason_Text8 = driver.findElement(By.xpath(
				".//div[@style='top:225px']//div[contains (@class, 'slick-cell l15 r15')]//input[@type='text']"));
		reason_Text8.sendKeys("Not Required");
		driver.findElement(By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l14 r14')]"))
				.click();
	}

	public void Multiple_Lineitems_POGridFields_NBM(WebDriver driver) throws IOException, InterruptedException {

//1st Line
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebElement costCenter = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l1 r1')]"));
		j.executeScript("arguments[0].click();", costCenter);
		WebElement costCenter1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
		String costcenter_String = getData("Grid_Data", 2, 15);
		select(costCenter1).selectByVisibleText(costcenter_String);

		WebElement expenseCategory = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", expenseCategory);
		WebElement expenseCategory1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
		String expensecategory_String = getData("Grid_Data", 2, 16);
		select(expenseCategory1).selectByVisibleText(expensecategory_String);

		WebElement partNo = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", partNo);
		WebElement partNo1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String grid_data = getData("Grid_Data", 2, 17);
		partNo1.sendKeys(grid_data);
		WebElement autoSuggestion = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
		autoSuggestion.click();

		WebElement qty = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l4 r4')]"));
		j.executeScript("arguments[0].click();", qty);
		WebElement qty1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l4 r4')]//input"));
		String grid_data2 = getData("Grid_Data", 2, 18);
		qty1.sendKeys(grid_data2);

		WebElement unitPrice = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l5 r5')]"));
		j.executeScript("arguments[0].click();", unitPrice);
		WebElement unitPrice1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l5 r5')]//input"));
		String grid_data3 = getData("Grid_Data", 2, 19);
		unitPrice1.sendKeys(grid_data3);

		WebElement UOM = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l9 r9')]"));
		j.executeScript("arguments[0].click();", UOM);
		WebElement UOM1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l9 r9')]//select"));
		selectOptionByIndex(UOM1, 0);

		WebElement deliveryDate = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l10 r10')]"));
		j.executeScript("arguments[0].click();", deliveryDate);
		WebElement deliverDate1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l10 r10')]//input"));
		String date1 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		deliverDate1.sendKeys(date1);

		// With IQC checkbox code

		WebElement checkBox = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l11 r11')]"));
		j.executeScript("arguments[0].click();", checkBox);
		WebElement checkBox1 = driver.findElement(By.xpath(
				".//div[@style='top:0px']//div[contains (@class, 'slick-cell l11 r11')]//input[@type='checkbox']"));
		j.executeScript("arguments[0].click();", checkBox1);
//		j.executeScript("arguments[0].click();", checkBox1);

		// Withot IQC Checkbox code

		WebElement insReason = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", insReason);
		WebElement reasonText = driver.findElement(By
				.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l12 r12')]//input[@type='text']"));
		reasonText.sendKeys("Not Required");
		driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l11 r11')]")).click();

		WebElement add_btn = driver.findElement(By.xpath("//div//button[@tooltipposition='bottom'][1]//i"));
		j.executeScript("arguments[0].click();", add_btn);

//2nd Line
		int scrollAmount = 2000;
		WebElement slickGridScroll = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]"));
		j.executeScript("arguments[0].scrollLeft += arguments[1];", slickGridScroll, scrollAmount);
		Thread.sleep(1000);

		WebElement cost_Center = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l1 r1')]"));
		j.executeScript("arguments[0].click();", cost_Center);
		WebElement cost_Center1 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
		String cost_Center_String = getData("Grid_Data", 3, 15);
		select(cost_Center1).selectByVisibleText(cost_Center_String);

		WebElement expense_Category = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", expense_Category);
		WebElement expense_Category1 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
		String expense_Category_String = getData("Grid_Data", 3, 16);
		select(expense_Category1).selectByVisibleText(expense_Category_String);

		WebElement part_No = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", part_No);
		WebElement part_No1 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String part_No_String = getData("Grid_Data", 3, 17);
		part_No1.sendKeys(part_No_String);
		WebElement autoSuggestion2 = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
		j.executeScript("arguments[0].click();", autoSuggestion2);

		WebElement qty2 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l4 r4')]"));
		j.executeScript("arguments[0].click();", qty2);
		WebElement qty3 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l4 r4')]//input"));
		String qty2_string = getData("Grid_Data", 3, 18);
		qty3.sendKeys(qty2_string);

		WebElement unit_Price = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l5 r5')]"));
		j.executeScript("arguments[0].click();", unit_Price);
		WebElement unit_Price1 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l5 r5')]//input"));
		String unit_Price_string = getData("Grid_Data", 3, 19);
		unit_Price1.sendKeys(unit_Price_string);

		WebElement UOM2 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l9 r9')]"));
		j.executeScript("arguments[0].click();", UOM2);
		WebElement UOM3 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l9 r9')]//select"));
		selectOptionByIndex(UOM3, 0);

		WebElement delivery_Date = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l10 r10')]"));
		j.executeScript("arguments[0].click();", delivery_Date);
		WebElement delivery_Date1 = driver.findElement(
				By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l10 r10')]//input"));
		String delivery_Date_string = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		delivery_Date1.sendKeys(delivery_Date_string);

		// With IQC checkbox code

		WebElement check_Box = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l11 r11')]"));
		j.executeScript("arguments[0].click();", check_Box);
		WebElement check_Box1 = driver.findElement(By.xpath(
				".//div[@style='top:25px']//div[contains (@class, 'slick-cell l11 r11')]//input[@type='checkbox']"));
		j.executeScript("arguments[0].click();", check_Box1);

		// Withot IQC Checkbox code

		WebElement ins_Reason = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", ins_Reason);
		WebElement reason_Text = driver.findElement(By
				.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l12 r12')]//input[@type='text']"));
		reason_Text.sendKeys("Not Required");
		driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l11 r11')]")).click();

		j.executeScript("arguments[0].click();", add_btn);

//3rd Line
		j.executeScript("arguments[0].scrollLeft += arguments[1];", slickGridScroll, scrollAmount);
		Thread.sleep(1000);

		WebElement cost_Center2 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l1 r1')]"));
		j.executeScript("arguments[0].click();", cost_Center2);
		WebElement cost_Center3 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
		String cost_Center1_String = getData("Grid_Data", 4, 15);
		select(cost_Center3).selectByVisibleText(cost_Center1_String);

		WebElement expense_Category2 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", expense_Category2);
		WebElement expense_Category3 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
		String expense_Category_String1 = getData("Grid_Data", 4, 16);
		select(expense_Category3).selectByVisibleText(expense_Category_String1);

		WebElement part_No2 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", part_No2);
		WebElement part_No3 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String part_No_String1 = getData("Grid_Data", 4, 17);
		part_No3.sendKeys(part_No_String1);
		WebElement autoSuggestion4 = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
		j.executeScript("arguments[0].click();", autoSuggestion4);

		WebElement qty4 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l4 r4')]"));
		j.executeScript("arguments[0].click();", qty4);
		WebElement qty5 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l4 r4')]//input"));
		String qty2_string1 = getData("Grid_Data", 4, 18);
		qty5.sendKeys(qty2_string1);

		WebElement unit_Price2 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l5 r5')]"));
		j.executeScript("arguments[0].click();", unit_Price2);
		WebElement unit_Price3 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l5 r5')]//input"));
		String unit_Price_string1 = getData("Grid_Data", 4, 19);
		unit_Price3.sendKeys(unit_Price_string1);

		WebElement UOM4 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l9 r9')]"));
		j.executeScript("arguments[0].click();", UOM4);
		WebElement UOM5 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l9 r9')]//select"));
		selectOptionByIndex(UOM5, 0);

		WebElement delivery_Date2 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l10 r10')]"));
		j.executeScript("arguments[0].click();", delivery_Date2);
		WebElement delivery_Date3 = driver.findElement(
				By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l10 r10')]//input"));
		String delivery_Date_string1 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		delivery_Date3.sendKeys(delivery_Date_string1);

		// With IQC checkbox code

		WebElement check_Box2 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l11 r11')]"));
		j.executeScript("arguments[0].click();", check_Box2);
		WebElement check_Box3 = driver.findElement(By.xpath(
				".//div[@style='top:50px']//div[contains (@class, 'slick-cell l11 r11')]//input[@type='checkbox']"));
		j.executeScript("arguments[0].click();", check_Box3);

		// Withot IQC Checkbox code

		WebElement ins_Reason1 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", ins_Reason1);
		WebElement reason_Text1 = driver.findElement(By
				.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l12 r12')]//input[@type='text']"));
		reason_Text1.sendKeys("Not Required");
		driver.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l11 r11')]")).click();

		j.executeScript("arguments[0].click();", add_btn);

//4th Line
		j.executeScript("arguments[0].scrollLeft += arguments[1];", slickGridScroll, scrollAmount);
		Thread.sleep(1000);

		WebElement cost_Center4 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l1 r1')]"));
		j.executeScript("arguments[0].click();", cost_Center4);
		WebElement cost_Center5 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
		String cost_Center_String1 = getData("Grid_Data", 5, 15);
		select(cost_Center5).selectByVisibleText(cost_Center_String1);

		WebElement expense_Category4 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", expense_Category4);
		WebElement expense_Category5 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
		String expense_Category_String2 = getData("Grid_Data", 5, 16);
		select(expense_Category5).selectByVisibleText(expense_Category_String2);

		WebElement part_No4 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", part_No4);
		WebElement part_No5 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String part_No_String2 = getData("Grid_Data", 5, 17);
		part_No5.sendKeys(part_No_String2);
		WebElement autoSuggestion6 = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
		j.executeScript("arguments[0].click();", autoSuggestion6);

		WebElement qty6 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l4 r4')]"));
		j.executeScript("arguments[0].click();", qty6);
		WebElement qty7 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l4 r4')]//input"));
		String qty_string = getData("Grid_Data", 5, 18);
		qty7.sendKeys(qty_string);

		WebElement unit_Price4 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l5 r5')]"));
		j.executeScript("arguments[0].click();", unit_Price4);
		WebElement unit_Price5 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l5 r5')]//input"));
		String unit_Price_string2 = getData("Grid_Data", 5, 19);
		unit_Price5.sendKeys(unit_Price_string2);

		WebElement UOM6 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l9 r9')]"));
		j.executeScript("arguments[0].click();", UOM6);
		WebElement UOM7 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l9 r9')]//select"));
		selectOptionByIndex(UOM7, 0);

		WebElement delivery_Date4 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l10 r10')]"));
		j.executeScript("arguments[0].click();", delivery_Date4);
		WebElement delivery_Date5 = driver.findElement(
				By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l10 r10')]//input"));
		String delivery_Date_string2 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		delivery_Date5.sendKeys(delivery_Date_string2);

		// With IQC checkbox code

		WebElement check_Box4 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l11 r11')]"));
		j.executeScript("arguments[0].click();", check_Box4);
		WebElement check_Box5 = driver.findElement(By.xpath(
				".//div[@style='top:75px']//div[contains (@class, 'slick-cell l11 r11')]//input[@type='checkbox']"));
		j.executeScript("arguments[0].click();", check_Box5);

		// Withot IQC Checkbox code

		WebElement ins_Reason2 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", ins_Reason2);
		WebElement reason_Text2 = driver.findElement(By
				.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l12 r12')]//input[@type='text']"));
		reason_Text2.sendKeys("Not Required");
		driver.findElement(By.xpath(".//div[@style='top:75px']//div[contains (@class, 'slick-cell l11 r11')]")).click();

		j.executeScript("arguments[0].click();", add_btn);

//5th Line
		j.executeScript("arguments[0].scrollLeft += arguments[1];", slickGridScroll, scrollAmount);
		Thread.sleep(1000);

		WebElement cost_Center6 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l1 r1')]"));
		j.executeScript("arguments[0].click();", cost_Center6);
		WebElement cost_Center7 = driver.findElement(
				By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
		String cost_Center_String2 = getData("Grid_Data", 6, 15);
		select(cost_Center7).selectByVisibleText(cost_Center_String2);

		WebElement expense_Category6 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", expense_Category6);
		WebElement expense_Category7 = driver.findElement(
				By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
		String expense_Category_String3 = getData("Grid_Data", 6, 16);
		select(expense_Category7).selectByVisibleText(expense_Category_String3);

		WebElement part_No6 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", part_No6);
		WebElement part_No7 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String part_No_String3 = getData("Grid_Data", 6, 17);
		part_No7.sendKeys(part_No_String3);
		WebElement autoSuggestion8 = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
		j.executeScript("arguments[0].click();", autoSuggestion8);

		WebElement qty8 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l4 r4')]"));
		j.executeScript("arguments[0].click();", qty8);
		WebElement qty9 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l4 r4')]//input"));
		String qty_string1 = getData("Grid_Data", 6, 18);
		qty9.sendKeys(qty_string1);

		WebElement unit_Price6 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l5 r5')]"));
		j.executeScript("arguments[0].click();", unit_Price6);
		WebElement unit_Price7 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l5 r5')]//input"));
		String unit_Price_string3 = getData("Grid_Data", 6, 19);
		unit_Price7.sendKeys(unit_Price_string3);

		WebElement UOM8 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l9 r9')]"));
		j.executeScript("arguments[0].click();", UOM8);
		WebElement UOM9 = driver.findElement(
				By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l9 r9')]//select"));
		selectOptionByIndex(UOM9, 0);

		WebElement delivery_Date6 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l10 r10')]"));
		j.executeScript("arguments[0].click();", delivery_Date6);
		WebElement delivery_Date7 = driver.findElement(
				By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l10 r10')]//input"));
		String delivery_Date_string3 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		delivery_Date7.sendKeys(delivery_Date_string3);

		// With IQC checkbox code

		WebElement check_Box6 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l11 r11')]"));
		j.executeScript("arguments[0].click();", check_Box6);
		WebElement check_Box7 = driver.findElement(By.xpath(
				".//div[@style='top:100px']//div[contains (@class, 'slick-cell l11 r11')]//input[@type='checkbox']"));
		j.executeScript("arguments[0].click();", check_Box7);

		// Withot IQC Checkbox code

		WebElement ins_Reason3 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", ins_Reason3);
		WebElement reason_Text3 = driver.findElement(By.xpath(
				".//div[@style='top:100px']//div[contains (@class, 'slick-cell l12 r12')]//input[@type='text']"));
		reason_Text3.sendKeys("Not Required");
		driver.findElement(By.xpath(".//div[@style='top:100px']//div[contains (@class, 'slick-cell l11 r11')]"))
				.click();

		j.executeScript("arguments[0].click();", add_btn);

//6th Line
		j.executeScript("arguments[0].scrollLeft += arguments[1];", slickGridScroll, scrollAmount);
		Thread.sleep(1000);

		WebElement cost_Center8 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l1 r1')]"));
		j.executeScript("arguments[0].click();", cost_Center8);
		WebElement cost_Center9 = driver.findElement(
				By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
		String cost_Center_String3 = getData("Grid_Data", 7, 15);
		select(cost_Center9).selectByVisibleText(cost_Center_String3);

		WebElement expense_Category8 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", expense_Category8);
		WebElement expense_Category9 = driver.findElement(
				By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
		String expense_Category_String4 = getData("Grid_Data", 7, 16);
		select(expense_Category9).selectByVisibleText(expense_Category_String4);

		WebElement part_No8 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", part_No8);
		WebElement part_No9 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String part_No_String4 = getData("Grid_Data", 7, 17);
		part_No9.sendKeys(part_No_String4);
		WebElement autoSuggestion10 = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
		j.executeScript("arguments[0].click();", autoSuggestion10);

		WebElement qty10 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l4 r4')]"));
		j.executeScript("arguments[0].click();", qty10);
		WebElement qty11 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l4 r4')]//input"));
		String qty_string2 = getData("Grid_Data", 7, 18);
		qty11.sendKeys(qty_string2);

		WebElement unit_Price8 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l5 r5')]"));
		j.executeScript("arguments[0].click();", unit_Price8);
		WebElement unit_Price9 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l5 r5')]//input"));
		String unit_Price_string4 = getData("Grid_Data", 7, 19);
		unit_Price9.sendKeys(unit_Price_string4);

		WebElement UOM10 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l9 r9')]"));
		j.executeScript("arguments[0].click();", UOM10);
		WebElement UOM11 = driver.findElement(
				By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l9 r9')]//select"));
		selectOptionByIndex(UOM11, 0);

		WebElement delivery_Date8 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l10 r10')]"));
		j.executeScript("arguments[0].click();", delivery_Date8);
		WebElement delivery_Date9 = driver.findElement(
				By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l10 r10')]//input"));
		String delivery_Date_string4 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		delivery_Date9.sendKeys(delivery_Date_string4);

		// With IQC checkbox code

		WebElement check_Box8 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l11 r11')]"));
		j.executeScript("arguments[0].click();", check_Box8);
		WebElement check_Box9 = driver.findElement(By.xpath(
				".//div[@style='top:125px']//div[contains (@class, 'slick-cell l11 r11')]//input[@type='checkbox']"));
		j.executeScript("arguments[0].click();", check_Box9);

		// Withot IQC Checkbox code

		WebElement ins_Reason4 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", ins_Reason4);
		WebElement reason_Text4 = driver.findElement(By.xpath(
				".//div[@style='top:125px']//div[contains (@class, 'slick-cell l12 r12')]//input[@type='text']"));
		reason_Text4.sendKeys("Not Required");
		driver.findElement(By.xpath(".//div[@style='top:125px']//div[contains (@class, 'slick-cell l11 r11')]"))
				.click();

		j.executeScript("arguments[0].click();", add_btn);

//7th Line
		j.executeScript("arguments[0].scrollLeft += arguments[1];", slickGridScroll, scrollAmount);
		Thread.sleep(1000);

		WebElement cost_Center10 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l1 r1')]"));
		j.executeScript("arguments[0].click();", cost_Center10);
		WebElement cost_Center11 = driver.findElement(
				By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
		String cost_Center_String4 = getData("Grid_Data", 8, 15);
		select(cost_Center11).selectByVisibleText(cost_Center_String4);

		WebElement expense_Category10 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", expense_Category10);
		WebElement expense_Category11 = driver.findElement(
				By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
		String expense_Category_String5 = getData("Grid_Data", 8, 16);
		select(expense_Category11).selectByVisibleText(expense_Category_String5);

		WebElement part_No10 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", part_No10);
		WebElement part_No11 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String part_No_String5 = getData("Grid_Data", 8, 17);
		part_No11.sendKeys(part_No_String5);
		WebElement autoSuggestion12 = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
		j.executeScript("arguments[0].click();", autoSuggestion12);

		WebElement qty12 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l4 r4')]"));
		j.executeScript("arguments[0].click();", qty12);
		WebElement qty13 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l4 r4')]//input"));
		String qty_string3 = getData("Grid_Data", 8, 18);
		qty13.sendKeys(qty_string3);

		WebElement unit_Price10 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l5 r5')]"));
		j.executeScript("arguments[0].click();", unit_Price10);
		WebElement unit_Price11 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l5 r5')]//input"));
		String unit_Price_string5 = getData("Grid_Data", 8, 19);
		unit_Price11.sendKeys(unit_Price_string5);

		WebElement UOM12 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l9 r9')]"));
		j.executeScript("arguments[0].click();", UOM12);
		WebElement UOM13 = driver.findElement(
				By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l9 r9')]//select"));
		selectOptionByIndex(UOM13, 0);

		WebElement delivery_Date10 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l10 r10')]"));
		j.executeScript("arguments[0].click();", delivery_Date10);
		WebElement delivery_Date11 = driver.findElement(
				By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l10 r10')]//input"));
		String delivery_Date_string5 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		delivery_Date11.sendKeys(delivery_Date_string5);

		// With IQC checkbox code

		WebElement check_Box10 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l11 r11')]"));
		j.executeScript("arguments[0].click();", check_Box10);
		WebElement check_Box11 = driver.findElement(By.xpath(
				".//div[@style='top:150px']//div[contains (@class, 'slick-cell l11 r11')]//input[@type='checkbox']"));
		j.executeScript("arguments[0].click();", check_Box11);

		// Withot IQC Checkbox code

		WebElement ins_Reason5 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", ins_Reason5);
		WebElement reason_Text5 = driver.findElement(By.xpath(
				".//div[@style='top:150px']//div[contains (@class, 'slick-cell l12 r12')]//input[@type='text']"));
		reason_Text5.sendKeys("Not Required");
		driver.findElement(By.xpath(".//div[@style='top:150px']//div[contains (@class, 'slick-cell l11 r11')]"))
				.click();

		j.executeScript("arguments[0].click();", add_btn);

//8th Line
		j.executeScript("arguments[0].scrollLeft += arguments[1];", slickGridScroll, scrollAmount);
		Thread.sleep(1000);

		WebElement cost_Center12 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l1 r1')]"));
		j.executeScript("arguments[0].click();", cost_Center12);
		WebElement cost_Center13 = driver.findElement(
				By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
		String cost_Center_String5 = getData("Grid_Data", 9, 15);
		select(cost_Center13).selectByVisibleText(cost_Center_String5);

		WebElement expense_Category12 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", expense_Category12);
		WebElement expense_Category13 = driver.findElement(
				By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
		String expense_Category_String6 = getData("Grid_Data", 9, 16);
		select(expense_Category13).selectByVisibleText(expense_Category_String6);

		WebElement part_No12 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", part_No12);
		WebElement part_No13 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String part_No_String6 = getData("Grid_Data", 9, 17);
		part_No13.sendKeys(part_No_String6);
		WebElement autoSuggestion14 = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
		j.executeScript("arguments[0].click();", autoSuggestion14);

		WebElement qty14 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l4 r4')]"));
		j.executeScript("arguments[0].click();", qty14);
		WebElement qty15 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l4 r4')]//input"));
		String qty_string4 = getData("Grid_Data", 9, 18);
		qty15.sendKeys(qty_string4);

		WebElement unit_Price12 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l5 r5')]"));
		j.executeScript("arguments[0].click();", unit_Price12);
		WebElement unit_Price13 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l5 r5')]//input"));
		String unit_Price_string6 = getData("Grid_Data", 9, 19);
		unit_Price13.sendKeys(unit_Price_string6);

		WebElement UOM14 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l9 r9')]"));
		j.executeScript("arguments[0].click();", UOM14);
		WebElement UOM15 = driver.findElement(
				By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l9 r9')]//select"));
		selectOptionByIndex(UOM15, 0);

		WebElement delivery_Date12 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l10 r10')]"));
		j.executeScript("arguments[0].click();", delivery_Date12);
		WebElement delivery_Date13 = driver.findElement(
				By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l10 r10')]//input"));
		String delivery_Date_string6 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		delivery_Date13.sendKeys(delivery_Date_string6);

		// With IQC checkbox code

		WebElement check_Box12 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l11 r11')]"));
		j.executeScript("arguments[0].click();", check_Box12);
		WebElement check_Box13 = driver.findElement(By.xpath(
				".//div[@style='top:175px']//div[contains (@class, 'slick-cell l11 r11')]//input[@type='checkbox']"));
		j.executeScript("arguments[0].click();", check_Box13);

		// Withot IQC Checkbox code

		WebElement ins_Reason6 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", ins_Reason6);
		WebElement reason_Text6 = driver.findElement(By.xpath(
				".//div[@style='top:175px']//div[contains (@class, 'slick-cell l12 r12')]//input[@type='text']"));
		reason_Text6.sendKeys("Not Required");
		driver.findElement(By.xpath(".//div[@style='top:175px']//div[contains (@class, 'slick-cell l11 r11')]"))
				.click();

		j.executeScript("arguments[0].click();", add_btn);

//9th Line
		j.executeScript("arguments[0].scrollLeft += arguments[1];", slickGridScroll, scrollAmount);
		Thread.sleep(1000);

		WebElement cost_Center14 = driver
				.findElement(By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l1 r1')]"));
		j.executeScript("arguments[0].click();", cost_Center14);
		WebElement cost_Center15 = driver.findElement(
				By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
		String cost_Center_String6 = getData("Grid_Data", 10, 15);
		select(cost_Center15).selectByVisibleText(cost_Center_String6);

		WebElement expense_Category14 = driver
				.findElement(By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", expense_Category14);
		WebElement expense_Category15 = driver.findElement(
				By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
		String expense_Category_String7 = getData("Grid_Data", 10, 16);
		select(expense_Category15).selectByVisibleText(expense_Category_String7);

		WebElement part_No14 = driver
				.findElement(By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", part_No14);
		WebElement part_No15 = driver
				.findElement(By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String part_No_String7 = getData("Grid_Data", 10, 17);
		part_No15.sendKeys(part_No_String7);
		WebElement autoSuggestion16 = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
		j.executeScript("arguments[0].click();", autoSuggestion16);

		WebElement qty16 = driver
				.findElement(By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l4 r4')]"));
		j.executeScript("arguments[0].click();", qty16);
		WebElement qty17 = driver
				.findElement(By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l4 r4')]//input"));
		String qty_string5 = getData("Grid_Data", 10, 18);
		qty17.sendKeys(qty_string5);

		WebElement unit_Price14 = driver
				.findElement(By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l5 r5')]"));
		j.executeScript("arguments[0].click();", unit_Price14);
		WebElement unit_Price15 = driver
				.findElement(By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l5 r5')]//input"));
		String unit_Price_string7 = getData("Grid_Data", 10, 19);
		unit_Price15.sendKeys(unit_Price_string7);

		WebElement UOM16 = driver
				.findElement(By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l9 r9')]"));
		j.executeScript("arguments[0].click();", UOM16);
		WebElement UOM17 = driver.findElement(
				By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l9 r9')]//select"));
		selectOptionByIndex(UOM17, 0);

		WebElement delivery_Date14 = driver
				.findElement(By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l10 r10')]"));
		j.executeScript("arguments[0].click();", delivery_Date14);
		WebElement delivery_Date15 = driver.findElement(
				By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l10 r10')]//input"));
		String delivery_Date_string7 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		delivery_Date15.sendKeys(delivery_Date_string7);

		// With IQC checkbox code

		WebElement check_Box14 = driver
				.findElement(By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l11 r11')]"));
		j.executeScript("arguments[0].click();", check_Box14);
		WebElement check_Box15 = driver.findElement(By.xpath(
				".//div[@style='top:200px']//div[contains (@class, 'slick-cell l11 r11')]//input[@type='checkbox']"));
		j.executeScript("arguments[0].click();", check_Box15);

		// Withot IQC Checkbox code

		WebElement ins_Reason7 = driver
				.findElement(By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", ins_Reason7);
		WebElement reason_Text7 = driver.findElement(By.xpath(
				".//div[@style='top:200px']//div[contains (@class, 'slick-cell l12 r12')]//input[@type='text']"));
		reason_Text7.sendKeys("Not Required");
		driver.findElement(By.xpath(".//div[@style='top:200px']//div[contains (@class, 'slick-cell l11 r11')]"))
				.click();

		j.executeScript("arguments[0].click();", add_btn);

//10th Line
		j.executeScript("arguments[0].scrollLeft += arguments[1];", slickGridScroll, scrollAmount);
		Thread.sleep(1000);

		WebElement cost_Center16 = driver
				.findElement(By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l1 r1')]"));
		j.executeScript("arguments[0].click();", cost_Center16);
		WebElement cost_Center17 = driver.findElement(
				By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
		String cost_Center_String7 = getData("Grid_Data", 11, 15);
		select(cost_Center17).selectByVisibleText(cost_Center_String7);

		WebElement expense_Category16 = driver
				.findElement(By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", expense_Category16);
		WebElement expense_Category17 = driver.findElement(
				By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
		String expense_Category_String8 = getData("Grid_Data", 11, 16);
		select(expense_Category17).selectByVisibleText(expense_Category_String8);

		WebElement part_No16 = driver
				.findElement(By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", part_No16);
		WebElement part_No17 = driver
				.findElement(By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String part_No_String8 = getData("Grid_Data", 11, 17);
		part_No17.sendKeys(part_No_String8);
		WebElement autoSuggestion18 = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
		j.executeScript("arguments[0].click();", autoSuggestion18);

		WebElement qty18 = driver
				.findElement(By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l4 r4')]"));
		j.executeScript("arguments[0].click();", qty18);
		WebElement qty19 = driver
				.findElement(By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l4 r4')]//input"));
		String qty_string6 = getData("Grid_Data", 11, 18);
		qty19.sendKeys(qty_string6);

		WebElement unit_Price16 = driver
				.findElement(By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l5 r5')]"));
		j.executeScript("arguments[0].click();", unit_Price16);
		WebElement unit_Price17 = driver
				.findElement(By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l5 r5')]//input"));
		String unit_Price_string8 = getData("Grid_Data", 11, 19);
		unit_Price17.sendKeys(unit_Price_string8);

		WebElement UOM18 = driver
				.findElement(By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l9 r9')]"));
		j.executeScript("arguments[0].click();", UOM18);
		WebElement UOM19 = driver.findElement(
				By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l9 r9')]//select"));
		selectOptionByIndex(UOM19, 0);

		WebElement delivery_Date16 = driver
				.findElement(By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l10 r10')]"));
		j.executeScript("arguments[0].click();", delivery_Date16);
		WebElement delivery_Date17 = driver.findElement(
				By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l10 r10')]//input"));
		String delivery_Date_string8 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		delivery_Date17.sendKeys(delivery_Date_string8);

		// With IQC checkbox code

		WebElement check_Box16 = driver
				.findElement(By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l11 r11')]"));
		j.executeScript("arguments[0].click();", check_Box16);
		WebElement check_Box17 = driver.findElement(By.xpath(
				".//div[@style='top:225px']//div[contains (@class, 'slick-cell l11 r11')]//input[@type='checkbox']"));
		j.executeScript("arguments[0].click();", check_Box17);

		// Withot IQC Checkbox code

		WebElement ins_Reason8 = driver
				.findElement(By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", ins_Reason8);
		WebElement reason_Text8 = driver.findElement(By.xpath(
				".//div[@style='top:225px']//div[contains (@class, 'slick-cell l12 r12')]//input[@type='text']"));
		reason_Text8.sendKeys("Not Required");
		driver.findElement(By.xpath(".//div[@style='top:225px']//div[contains (@class, 'slick-cell l11 r11')]"))
				.click();
	}

	public void FG_Multiple_Line_Items(WebDriver driver) throws InterruptedException, IOException {
		// FG Grid

//1st Line
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebElement costCenter = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l1 r1')]"));
		j.executeScript("arguments[0].click();", costCenter);
		WebElement costCenter1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
		String costcenter_string = getData("Grid_Data", 2, 12);

		int maxretries = 3;
		for (int i = 0; i < maxretries; i++) {
			try {
				costCenter1 = driver.findElement(
						By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
				select(costCenter1).selectByVisibleText(costcenter_string);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}

		Thread.sleep(500);

		WebElement expenseCategory = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", expenseCategory);
		WebElement expenseCategory1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
		String expensecategory_string = getData("Grid_Data", 2, 13);
		select(expenseCategory1).selectByVisibleText(expensecategory_string);

		WebElement partNo = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", partNo);
		WebElement partNo1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String grid_data = getData("Grid_Data", 2, 7);
		partNo1.sendKeys(grid_data);
		WebElement autoSuggestion = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
		autoSuggestion.click();

		WebElement originalMaterialType = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l4 r4')]"));
		j.executeScript("arguments[0].click();", originalMaterialType);
		Thread.sleep(500);
		try {
			j.executeScript("arguments[0].click();", originalMaterialType);
		} catch (StaleElementReferenceException e) {
			originalMaterialType = driver
					.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l4 r4')]"));
			j.executeScript("arguments[0].click();", originalMaterialType);
		}
		WebElement originalMaterialType1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l4 r4')]//select"));
		String Original_Mat_Type_data = getData("Grid_Data", 2, 11);
		select(originalMaterialType1).selectByVisibleText(Original_Mat_Type_data);

		WebElement workType = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l5 r5')]"));
		j.executeScript("arguments[0].click();", workType);
		Thread.sleep(500);
		try {
			j.executeScript("arguments[0].click();", workType);
		} catch (StaleElementReferenceException e1) {
			workType = driver
					.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l5 r5')]"));
			j.executeScript("arguments[0].click();", workType);
		}
		WebElement workType1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l5 r5')]//select"));
		selectOptionByIndex(workType1, 0);

		WebElement name = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l6 r6')]"));
		j.executeScript("arguments[0].click();", name);
		Thread.sleep(500);
		try {
			j.executeScript("arguments[0].click();", name);
		} catch (StaleElementReferenceException e2) {
			name = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l6 r6')]"));
			j.executeScript("arguments[0].click();", name);
		}
		Thread.sleep(1000);
		WebElement name1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l6 r6')]//input"));
		String grid_data2 = getData("Grid_Data", 2, 8);
		name1.sendKeys(grid_data2);
		WebElement autoSuggestion1 = driver.findElement(By.xpath("//*[@class='ui-menu-item'][1]"));
		autoSuggestion1.click();

		WebElement qty = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l7 r7')]"));
		j.executeScript("arguments[0].click();", qty);
		Thread.sleep(500);
		try {
			j.executeScript("arguments[0].click();", qty);
		} catch (StaleElementReferenceException e3) {
			qty = driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l7 r7')]"));
			j.executeScript("arguments[0].click();", qty);
		}
		WebElement qty1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l7 r7')]//input"));
		String grid_data3 = getData("Grid_Data", 2, 9);
		qty1.sendKeys(grid_data3);

		WebElement unitPrice = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l8 r8')]"));
		j.executeScript("arguments[0].click();", unitPrice);
		Thread.sleep(500);
		try {
			j.executeScript("arguments[0].click();", unitPrice);
			Thread.sleep(500);
		} catch (StaleElementReferenceException e4) {
			unitPrice = driver
					.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l8 r8')]"));
			j.executeScript("arguments[0].click();", unitPrice);
		}
		WebElement unitPrice1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l8 r8')]//input"));
		String grid_data4 = getData("Grid_Data", 2, 10);
		unitPrice1.sendKeys(grid_data4);

		WebElement UOM = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", UOM);
		Thread.sleep(500);
		try {
			j.executeScript("arguments[0].click();", UOM);
		} catch (StaleElementReferenceException e5) {
			UOM = driver
					.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l12 r12')]"));
			j.executeScript("arguments[0].click();", UOM);
		}
		WebElement UOM1 = driver.findElement(
				By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l12 r12')]//select"));
		selectOptionByIndex(UOM1, 0);

		WebElement deliveryDate = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", deliveryDate);
		Thread.sleep(500);
		try {
			j.executeScript("arguments[0].click();", deliveryDate);
		} catch (StaleElementReferenceException e5) {
			deliveryDate = driver
					.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l13 r13')]"));
			j.executeScript("arguments[0].click();", deliveryDate);
		}
		WebElement deliverDate1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l13 r13')]//input"));
		String date1 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		deliverDate1.sendKeys(date1);

		// With IQC checkbox code

		WebElement checkBox = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l14 r14')]"));
		j.executeScript("arguments[0].click();", checkBox);
		Thread.sleep(500);
		try {
			j.executeScript("arguments[0].click();", checkBox);
		} catch (StaleElementReferenceException e5) {
			checkBox = driver
					.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l14 r14')]"));
			j.executeScript("arguments[0].click();", checkBox);
		}
		WebElement checkBox1 = driver.findElement(By.xpath(
				".//div[@style='top:0px']//div[contains (@class, 'slick-cell l14 r14')]//input[@type='checkbox']"));
		j.executeScript("arguments[0].click();", checkBox1);
//			j.executeScript("arguments[0].click();", checkBox1);

		// Withot IQC Checkbox code
		WebElement insReason = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l15 r15')]"));
		j.executeScript("arguments[0].click();", insReason);
		Thread.sleep(500);
		try {
			j.executeScript("arguments[0].click();", insReason);
		} catch (StaleElementReferenceException e5) {
			insReason = driver
					.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l15 r15')]"));
			j.executeScript("arguments[0].click();", insReason);
		}
		WebElement reasonText = driver.findElement(By
				.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l15 r15')]//input[@type='text']"));
		reasonText.sendKeys("Not Required");
		Thread.sleep(500);
		driver.findElement(By.xpath(".//div[@style='top:0px']//div[contains (@class, 'slick-cell l14 r14')]")).click();

		WebElement add_btn = driver.findElement(By.xpath("//div//button[@tooltipposition='bottom'][1]//i"));
		j.executeScript("arguments[0].click();", add_btn);

//2nd Line
		int scrollAmount = 2000;
		WebElement slickGridScroll = driver.findElement(By.xpath("//*[@id='form_grid_0']/div[4]/div[3]"));
		j.executeScript("arguments[0].scrollLeft += arguments[1];", slickGridScroll, scrollAmount);
		Thread.sleep(1000);

		WebElement costCenter2 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l1 r1')]"));
		j.executeScript("arguments[0].click();", costCenter2);
		WebElement costCenter3 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
		String costcenter_string1 = getData("Grid_Data", 3, 12);

		for (int i = 0; i < maxretries; i++) {
			try {
				costCenter3 = driver.findElement(
						By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
				select(costCenter3).selectByVisibleText(costcenter_string1);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}

		Thread.sleep(500);

		WebElement expenseCategory2 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", expenseCategory2);
		WebElement expenseCategory3 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
		String expensecategory_string1 = getData("Grid_Data", 3, 13);
		select(expenseCategory3).selectByVisibleText(expensecategory_string1);

		WebElement partNo2 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", partNo2);
		WebElement partNo3 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String partNo_string = getData("Grid_Data", 3, 7);
		partNo3.sendKeys(partNo_string);
		WebElement autoSuggestion2 = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
		autoSuggestion2.click();

		WebElement originalMaterialType2 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l4 r4')]"));
		j.executeScript("arguments[0].click();", originalMaterialType2);
		Thread.sleep(500);
		try {
			j.executeScript("arguments[0].click();", originalMaterialType2);
		} catch (StaleElementReferenceException e) {
			originalMaterialType2 = driver
					.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l4 r4')]"));
			j.executeScript("arguments[0].click();", originalMaterialType2);
		}
		WebElement originalMaterialType3 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l4 r4')]//select"));
		String Original_Mat_Type_string = getData("Grid_Data", 3, 11);
		select(originalMaterialType3).selectByVisibleText(Original_Mat_Type_string);

		WebElement workType2 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l5 r5')]"));
		j.executeScript("arguments[0].click();", workType2);
		Thread.sleep(500);
		try {
			j.executeScript("arguments[0].click();", workType2);
		} catch (StaleElementReferenceException e1) {
			workType2 = driver
					.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l5 r5')]"));
			j.executeScript("arguments[0].click();", workType2);
		}
		WebElement workType3 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l5 r5')]//select"));
		selectOptionByIndex(workType3, 0);

		WebElement name2 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l6 r6')]"));
		j.executeScript("arguments[0].click();", name2);
		Thread.sleep(500);
		try {
			j.executeScript("arguments[0].click();", name2);
		} catch (StaleElementReferenceException e2) {
			name2 = driver
					.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l6 r6')]"));
			j.executeScript("arguments[0].click();", name2);
		}
		Thread.sleep(1000);
		WebElement name3 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l6 r6')]//input"));
		String name_string = getData("Grid_Data", 3, 8);
		name3.sendKeys(name_string);
		WebElement autoSuggestion3 = driver.findElement(By.xpath("//*[@class='ui-menu-item'][1]"));
		autoSuggestion3.click();

		WebElement qty2 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l7 r7')]"));
		j.executeScript("arguments[0].click();", qty2);
		Thread.sleep(500);
		try {
			j.executeScript("arguments[0].click();", qty2);
		} catch (StaleElementReferenceException e3) {
			qty2 = driver
					.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l7 r7')]"));
			j.executeScript("arguments[0].click();", qty2);
		}
		WebElement qty3 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l7 r7')]//input"));
		String qty_string = getData("Grid_Data", 3, 9);
		qty3.sendKeys(qty_string);

		WebElement unitPrice2 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l8 r8')]"));
		j.executeScript("arguments[0].click();", unitPrice2);
		Thread.sleep(500);
		try {
			j.executeScript("arguments[0].click();", unitPrice2);
			Thread.sleep(500);
		} catch (StaleElementReferenceException e4) {
			unitPrice2 = driver
					.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l8 r8')]"));
			j.executeScript("arguments[0].click();", unitPrice2);
		}
		WebElement unitPrice3 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l8 r8')]//input"));
		String unitprice_string = getData("Grid_Data", 3, 10);
		unitPrice3.sendKeys(unitprice_string);

		WebElement UOM2 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", UOM2);
		Thread.sleep(500);
		try {
			j.executeScript("arguments[0].click();", UOM2);
		} catch (StaleElementReferenceException e5) {
			UOM2 = driver
					.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l12 r12')]"));
			j.executeScript("arguments[0].click();", UOM2);
		}
		WebElement UOM3 = driver.findElement(
				By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l12 r12')]//select"));
		selectOptionByIndex(UOM3, 0);

		WebElement deliveryDate2 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", deliveryDate2);
		Thread.sleep(500);
		try {
			j.executeScript("arguments[0].click();", deliveryDate2);
		} catch (StaleElementReferenceException e5) {
			deliveryDate2 = driver
					.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l13 r13')]"));
			j.executeScript("arguments[0].click();", deliveryDate2);
		}
		WebElement deliverDate3 = driver.findElement(
				By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l13 r13')]//input"));
		String date2 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		deliverDate3.sendKeys(date2);

		// With IQC checkbox code

		WebElement checkBox2 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l14 r14')]"));
		j.executeScript("arguments[0].click();", checkBox2);
		Thread.sleep(500);
		try {
			j.executeScript("arguments[0].click();", checkBox2);
		} catch (StaleElementReferenceException e5) {
			checkBox2 = driver
					.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l14 r14')]"));
			j.executeScript("arguments[0].click();", checkBox2);
		}
		WebElement checkBox3 = driver.findElement(By.xpath(
				".//div[@style='top:25px']//div[contains (@class, 'slick-cell l14 r14')]//input[@type='checkbox']"));
		j.executeScript("arguments[0].click();", checkBox3);
//			j.executeScript("arguments[0].click();", checkBox1);

		// Withot IQC Checkbox code
		WebElement insReason1 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l15 r15')]"));
		j.executeScript("arguments[0].click();", insReason1);
		Thread.sleep(500);
		try {
			j.executeScript("arguments[0].click();", insReason1);
		} catch (StaleElementReferenceException e5) {
			insReason1 = driver
					.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l15 r15')]"));
			j.executeScript("arguments[0].click();", insReason1);
		}
		WebElement reasonText1 = driver.findElement(By
				.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l15 r15')]//input[@type='text']"));
		reasonText1.sendKeys("Not Required");
		Thread.sleep(500);
		driver.findElement(By.xpath(".//div[@style='top:25px']//div[contains (@class, 'slick-cell l14 r14')]")).click();

		j.executeScript("arguments[0].click();", add_btn);

//3rd Line
		j.executeScript("arguments[0].scrollLeft += arguments[1];", slickGridScroll, scrollAmount);
		Thread.sleep(1000);

		WebElement costCenter4 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l1 r1')]"));
		j.executeScript("arguments[0].click();", costCenter4);
		WebElement costCenter5 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
		String costcenter_string2 = getData("Grid_Data", 4, 12);

		for (int i = 0; i < maxretries; i++) {
			try {
				costCenter5 = driver.findElement(
						By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l1 r1')]//select"));
				select(costCenter5).selectByVisibleText(costcenter_string2);
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Maximum Retry Failed");
			}
		}

		Thread.sleep(500);

		WebElement expenseCategory4 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l2 r2')]"));
		j.executeScript("arguments[0].click();", expenseCategory4);
		WebElement expenseCategory5 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l2 r2')]//select"));
		String expensecategory_string2 = getData("Grid_Data", 4, 13);
		select(expenseCategory5).selectByVisibleText(expensecategory_string2);

		WebElement partNo4 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l3 r3')]"));
		j.executeScript("arguments[0].click();", partNo4);
		WebElement partNo5 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l3 r3')]//input"));
		String partNo_string1 = getData("Grid_Data", 4, 7);
		partNo5.sendKeys(partNo_string1);
		WebElement autoSuggestion4 = driver.findElement(By.xpath("//ul//li[1][@tabindex='-1']"));
		autoSuggestion4.click();

		WebElement originalMaterialType4 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l4 r4')]"));
		j.executeScript("arguments[0].click();", originalMaterialType4);
		Thread.sleep(500);
		try {
			j.executeScript("arguments[0].click();", originalMaterialType4);
		} catch (StaleElementReferenceException e) {
			originalMaterialType4 = driver
					.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l4 r4')]"));
			j.executeScript("arguments[0].click();", originalMaterialType4);
		}
		WebElement originalMaterialType5 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l4 r4')]//select"));
		String Original_Mat_Type_string1 = getData("Grid_Data", 4, 11);
		select(originalMaterialType5).selectByVisibleText(Original_Mat_Type_string1);

		WebElement workType4 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l5 r5')]"));
		j.executeScript("arguments[0].click();", workType4);
		Thread.sleep(500);
		try {
			j.executeScript("arguments[0].click();", workType4);
		} catch (StaleElementReferenceException e1) {
			workType4 = driver
					.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l5 r5')]"));
			j.executeScript("arguments[0].click();", workType4);
		}
		WebElement workType5 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l5 r5')]//select"));
		selectOptionByIndex(workType5, 0);

		WebElement name4 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l6 r6')]"));
		j.executeScript("arguments[0].click();", name4);
		Thread.sleep(500);
		try {
			j.executeScript("arguments[0].click();", name4);
		} catch (StaleElementReferenceException e2) {
			name4 = driver
					.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l6 r6')]"));
			j.executeScript("arguments[0].click();", name4);
		}
		Thread.sleep(1000);
		WebElement name5 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l6 r6')]//input"));
		String name_string1 = getData("Grid_Data", 4, 8);
		name5.sendKeys(name_string1);
		WebElement autoSuggestion5 = driver.findElement(By.xpath("//*[@class='ui-menu-item'][1]"));
		autoSuggestion5.click();

		WebElement qty4 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l7 r7')]"));
		j.executeScript("arguments[0].click();", qty4);
		Thread.sleep(500);
		try {
			j.executeScript("arguments[0].click();", qty4);
		} catch (StaleElementReferenceException e3) {
			qty4 = driver
					.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l7 r7')]"));
			j.executeScript("arguments[0].click();", qty4);
		}
		WebElement qty5 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l7 r7')]//input"));
		String qty_string1 = getData("Grid_Data", 4, 9);
		qty5.sendKeys(qty_string1);

		WebElement unitPrice4 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l8 r8')]"));
		j.executeScript("arguments[0].click();", unitPrice4);
		Thread.sleep(500);
		try {
			j.executeScript("arguments[0].click();", unitPrice4);
			Thread.sleep(500);
		} catch (StaleElementReferenceException e4) {
			unitPrice4 = driver
					.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l8 r8')]"));
			j.executeScript("arguments[0].click();", unitPrice4);
		}
		WebElement unitPrice5 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l8 r8')]//input"));
		String unitprice_string1 = getData("Grid_Data", 4, 10);
		unitPrice5.sendKeys(unitprice_string1);

		WebElement UOM4 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", UOM4);
		Thread.sleep(500);
		try {
			j.executeScript("arguments[0].click();", UOM4);
		} catch (StaleElementReferenceException e5) {
			UOM4 = driver
					.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l12 r12')]"));
			j.executeScript("arguments[0].click();", UOM4);
		}
		WebElement UOM5 = driver.findElement(
				By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l12 r12')]//select"));
		selectOptionByIndex(UOM5, 0);

		WebElement deliveryDate4 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", deliveryDate4);
		Thread.sleep(500);
		try {
			j.executeScript("arguments[0].click();", deliveryDate4);
		} catch (StaleElementReferenceException e5) {
			deliveryDate4 = driver
					.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l13 r13')]"));
			j.executeScript("arguments[0].click();", deliveryDate4);
		}
		WebElement deliverDate5 = driver.findElement(
				By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l13 r13')]//input"));
		String date3 = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		deliverDate5.sendKeys(date3);

		// With IQC checkbox code

		WebElement checkBox4 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l14 r14')]"));
		j.executeScript("arguments[0].click();", checkBox4);
		Thread.sleep(500);
		try {
			j.executeScript("arguments[0].click();", checkBox4);
		} catch (StaleElementReferenceException e5) {
			checkBox4 = driver
					.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l14 r14')]"));
			j.executeScript("arguments[0].click();", checkBox4);
		}
		WebElement checkBox5 = driver.findElement(By.xpath(
				".//div[@style='top:50px']//div[contains (@class, 'slick-cell l14 r14')]//input[@type='checkbox']"));
		j.executeScript("arguments[0].click();", checkBox5);
//						j.executeScript("arguments[0].click();", checkBox1);

		// Withot IQC Checkbox code
		WebElement insReason2 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l15 r15')]"));
		j.executeScript("arguments[0].click();", insReason2);
		Thread.sleep(500);
		try {
			j.executeScript("arguments[0].click();", insReason2);
		} catch (StaleElementReferenceException e5) {
			insReason2 = driver
					.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l15 r15')]"));
			j.executeScript("arguments[0].click();", insReason2);
		}
		WebElement reasonText2 = driver.findElement(By
				.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l15 r15')]//input[@type='text']"));
		reasonText2.sendKeys("Not Required");
		Thread.sleep(500);
		driver.findElement(By.xpath(".//div[@style='top:50px']//div[contains (@class, 'slick-cell l14 r14')]")).click();
	}

	// GRN Selection Code for Issue Module

	public void Alloc_Proto_GRN_Selection(WebDriver driver) throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;
//1st Line
		WebElement grn_no = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains(@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", grn_no);
		WebElement grn_no1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains(@class, 'slick-cell l12 r12')]//select"));

		int maxRetries = 3;
		for (int i = 0; i < maxRetries; i++) {
			try {
				Select dropdownSelect = new Select(grn_no1);
				java.util.List<WebElement> options = dropdownSelect.getOptions();
				dropdownSelect.selectByIndex(options.size() - 1);
				break;
			} catch (StaleElementReferenceException e) {
				grn_no = driver
						.findElement(By.xpath(".//div[@style='top:0px']//div[contains(@class, 'slick-cell l12 r12')]"));
				j.executeScript("arguments[0].click();", grn_no);
				grn_no1 = driver.findElement(
						By.xpath(".//div[@style='top:0px']//div[contains(@class, 'slick-cell l12 r12')]//select"));
			}
			Thread.sleep(500);
		}

		WebElement line_no = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains(@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", line_no);
		WebElement line_no1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains(@class, 'slick-cell l13 r13')]//select"));

		for (int i = 0; i < maxRetries; i++) {
			try {
				Select dropdownSelect = new Select(line_no1);
				java.util.List<WebElement> options = dropdownSelect.getOptions();
				dropdownSelect.selectByIndex(options.size() - 1);
				break;
			} catch (StaleElementReferenceException e) {
				line_no = driver
						.findElement(By.xpath(".//div[@style='top:0px']//div[contains(@class, 'slick-cell l13 r13')]"));
				j.executeScript("arguments[0].click();", line_no);
				line_no1 = driver.findElement(
						By.xpath(".//div[@style='top:0px']//div[contains(@class, 'slick-cell l13 r13')]//select"));
			}
			Thread.sleep(500);
		}

//2nd Line
		WebElement grn_no2 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains(@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", grn_no2);
		WebElement grn_no3 = driver.findElement(
				By.xpath(".//div[@style='top:25px']//div[contains(@class, 'slick-cell l12 r12')]//select"));

		for (int i = 0; i < maxRetries; i++) {
			try {
				Select dropdownSelect = new Select(grn_no3);
				java.util.List<WebElement> options = dropdownSelect.getOptions();
				dropdownSelect.selectByIndex(options.size() - 1);
				break;
			} catch (StaleElementReferenceException e) {
				grn_no2 = driver.findElement(
						By.xpath(".//div[@style='top:25px']//div[contains(@class, 'slick-cell l12 r12')]"));
				j.executeScript("arguments[0].click();", grn_no2);
				grn_no3 = driver.findElement(
						By.xpath(".//div[@style='top:25px']//div[contains(@class, 'slick-cell l12 r12')]//select"));
			}
			Thread.sleep(500);
		}

		WebElement line_no2 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains(@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", line_no2);
		WebElement line_no3 = driver.findElement(
				By.xpath(".//div[@style='top:25px']//div[contains(@class, 'slick-cell l13 r13')]//select"));

		for (int i = 0; i < maxRetries; i++) {
			try {
				Select dropdownSelect = new Select(line_no3);
				java.util.List<WebElement> options = dropdownSelect.getOptions();
				dropdownSelect.selectByIndex(options.size() - 1);
				break;
			} catch (StaleElementReferenceException e) {
				line_no2 = driver.findElement(
						By.xpath(".//div[@style='top:25px']//div[contains(@class, 'slick-cell l13 r13')]"));
				j.executeScript("arguments[0].click();", line_no2);
				line_no3 = driver.findElement(
						By.xpath(".//div[@style='top:25px']//div[contains(@class, 'slick-cell l13 r13')]//select"));
			}
			Thread.sleep(500);
		}

//3rd Line
		WebElement grn_no4 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains(@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", grn_no4);
		WebElement grn_no5 = driver.findElement(
				By.xpath(".//div[@style='top:50px']//div[contains(@class, 'slick-cell l12 r12')]//select"));

		for (int i = 0; i < maxRetries; i++) {
			try {
				Select dropdownSelect = new Select(grn_no5);
				java.util.List<WebElement> options = dropdownSelect.getOptions();
				dropdownSelect.selectByIndex(options.size() - 1);
				break;
			} catch (StaleElementReferenceException e) {
				grn_no4 = driver.findElement(
						By.xpath(".//div[@style='top:50px']//div[contains(@class, 'slick-cell l12 r12')]"));
				j.executeScript("arguments[0].click();", grn_no4);
				grn_no5 = driver.findElement(
						By.xpath(".//div[@style='top:50px']//div[contains(@class, 'slick-cell l12 r12')]//select"));
			}
			Thread.sleep(500);
		}

		WebElement line_no4 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains(@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", line_no4);
		WebElement line_no5 = driver.findElement(
				By.xpath(".//div[@style='top:50px']//div[contains(@class, 'slick-cell l13 r13')]//select"));

		for (int i = 0; i < maxRetries; i++) {
			try {
				Select dropdownSelect = new Select(line_no5);
				java.util.List<WebElement> options = dropdownSelect.getOptions();
				dropdownSelect.selectByIndex(options.size() - 1);
				break;
			} catch (StaleElementReferenceException e) {
				line_no4 = driver.findElement(
						By.xpath(".//div[@style='top:50px']//div[contains(@class, 'slick-cell l13 r13')]"));
				j.executeScript("arguments[0].click();", line_no4);
				line_no5 = driver.findElement(
						By.xpath(".//div[@style='top:50px']//div[contains(@class, 'slick-cell l13 r13')]//select"));
			}
			Thread.sleep(500);
		}

//4th Line
		WebElement grn_no6 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains(@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", grn_no6);
		WebElement grn_no7 = driver.findElement(
				By.xpath(".//div[@style='top:75px']//div[contains(@class, 'slick-cell l12 r12')]//select"));

		for (int i = 0; i < maxRetries; i++) {
			try {
				Select dropdownSelect = new Select(grn_no7);
				java.util.List<WebElement> options = dropdownSelect.getOptions();
				dropdownSelect.selectByIndex(options.size() - 1);
				break;
			} catch (StaleElementReferenceException e) {
				grn_no6 = driver.findElement(
						By.xpath(".//div[@style='top:75px']//div[contains(@class, 'slick-cell l12 r12')]"));
				j.executeScript("arguments[0].click();", grn_no6);
				grn_no7 = driver.findElement(
						By.xpath(".//div[@style='top:75px']//div[contains(@class, 'slick-cell l12 r12')]//select"));
			}
			Thread.sleep(500);
		}

		WebElement line_no6 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains(@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", line_no6);
		WebElement line_no7 = driver.findElement(
				By.xpath(".//div[@style='top:75px']//div[contains(@class, 'slick-cell l13 r13')]//select"));

		for (int i = 0; i < maxRetries; i++) {
			try {
				Select dropdownSelect = new Select(line_no7);
				java.util.List<WebElement> options = dropdownSelect.getOptions();
				dropdownSelect.selectByIndex(options.size() - 1);
				break;
			} catch (StaleElementReferenceException e) {
				line_no6 = driver.findElement(
						By.xpath(".//div[@style='top:75px']//div[contains(@class, 'slick-cell l13 r13')]"));
				j.executeScript("arguments[0].click();", line_no6);
				line_no7 = driver.findElement(
						By.xpath(".//div[@style='top:75px']//div[contains(@class, 'slick-cell l13 r13')]//select"));
			}
			Thread.sleep(500);
		}

//5th Line
		WebElement grn_no8 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains(@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", grn_no8);
		WebElement grn_no9 = driver.findElement(
				By.xpath(".//div[@style='top:100px']//div[contains(@class, 'slick-cell l12 r12')]//select"));

		for (int i = 0; i < maxRetries; i++) {
			try {
				Select dropdownSelect = new Select(grn_no9);
				java.util.List<WebElement> options = dropdownSelect.getOptions();
				dropdownSelect.selectByIndex(options.size() - 1);
				break;
			} catch (StaleElementReferenceException e) {
				grn_no8 = driver.findElement(
						By.xpath(".//div[@style='top:100px']//div[contains(@class, 'slick-cell l12 r12')]"));
				j.executeScript("arguments[0].click();", grn_no8);
				grn_no9 = driver.findElement(
						By.xpath(".//div[@style='top:100px']//div[contains(@class, 'slick-cell l12 r12')]//select"));
			}
			Thread.sleep(500);
		}

		WebElement line_no8 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains(@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", line_no8);
		WebElement line_no9 = driver.findElement(
				By.xpath(".//div[@style='top:100px']//div[contains(@class, 'slick-cell l13 r13')]//select"));

		for (int i = 0; i < maxRetries; i++) {
			try {
				Select dropdownSelect = new Select(line_no9);
				java.util.List<WebElement> options = dropdownSelect.getOptions();
				dropdownSelect.selectByIndex(options.size() - 1);
				break;
			} catch (StaleElementReferenceException e) {
				line_no8 = driver.findElement(
						By.xpath(".//div[@style='top:100px']//div[contains(@class, 'slick-cell l13 r13')]"));
				j.executeScript("arguments[0].click();", line_no8);
				line_no9 = driver.findElement(
						By.xpath(".//div[@style='top:100px']//div[contains(@class, 'slick-cell l13 r13')]//select"));
			}
			Thread.sleep(500);
		}

//6th Line
		WebElement grn_no10 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains(@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", grn_no10);
		WebElement grn_no11 = driver.findElement(
				By.xpath(".//div[@style='top:125px']//div[contains(@class, 'slick-cell l12 r12')]//select"));

		for (int i = 0; i < maxRetries; i++) {
			try {
				Select dropdownSelect = new Select(grn_no11);
				java.util.List<WebElement> options = dropdownSelect.getOptions();
				dropdownSelect.selectByIndex(options.size() - 1);
				break;
			} catch (StaleElementReferenceException e) {
				grn_no10 = driver.findElement(
						By.xpath(".//div[@style='top:125px']//div[contains(@class, 'slick-cell l12 r12')]"));
				j.executeScript("arguments[0].click();", grn_no10);
				grn_no11 = driver.findElement(
						By.xpath(".//div[@style='top:125px']//div[contains(@class, 'slick-cell l12 r12')]//select"));
			}
			Thread.sleep(500);
		}

		WebElement line_no10 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains(@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", line_no10);
		WebElement line_no11 = driver.findElement(
				By.xpath(".//div[@style='top:125px']//div[contains(@class, 'slick-cell l13 r13')]//select"));

		for (int i = 0; i < maxRetries; i++) {
			try {
				Select dropdownSelect = new Select(line_no11);
				java.util.List<WebElement> options = dropdownSelect.getOptions();
				dropdownSelect.selectByIndex(options.size() - 1);
				break;
			} catch (StaleElementReferenceException e) {
				line_no10 = driver.findElement(
						By.xpath(".//div[@style='top:125px']//div[contains(@class, 'slick-cell l13 r13')]"));
				j.executeScript("arguments[0].click();", line_no10);
				line_no11 = driver.findElement(
						By.xpath(".//div[@style='top:125px']//div[contains(@class, 'slick-cell l13 r13')]//select"));
			}
			Thread.sleep(500);
		}

//7th Line
		WebElement grn_no12 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains(@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", grn_no12);
		WebElement grn_no13 = driver.findElement(
				By.xpath(".//div[@style='top:150px']//div[contains(@class, 'slick-cell l12 r12')]//select"));

		for (int i = 0; i < maxRetries; i++) {
			try {
				Select dropdownSelect = new Select(grn_no13);
				java.util.List<WebElement> options = dropdownSelect.getOptions();
				dropdownSelect.selectByIndex(options.size() - 1);
				break;
			} catch (StaleElementReferenceException e) {
				grn_no12 = driver.findElement(
						By.xpath(".//div[@style='top:150px']//div[contains(@class, 'slick-cell l12 r12')]"));
				j.executeScript("arguments[0].click();", grn_no12);
				grn_no13 = driver.findElement(
						By.xpath(".//div[@style='top:150px']//div[contains(@class, 'slick-cell l12 r12')]//select"));
			}
			Thread.sleep(500);
		}

		WebElement line_no12 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains(@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", line_no12);
		WebElement line_no13 = driver.findElement(
				By.xpath(".//div[@style='top:150px']//div[contains(@class, 'slick-cell l13 r13')]//select"));

		for (int i = 0; i < maxRetries; i++) {
			try {
				Select dropdownSelect = new Select(line_no13);
				java.util.List<WebElement> options = dropdownSelect.getOptions();
				dropdownSelect.selectByIndex(options.size() - 1);
				break;
			} catch (StaleElementReferenceException e) {
				line_no12 = driver.findElement(
						By.xpath(".//div[@style='top:150px']//div[contains(@class, 'slick-cell l13 r13')]"));
				j.executeScript("arguments[0].click();", line_no12);
				line_no13 = driver.findElement(
						By.xpath(".//div[@style='top:150px']//div[contains(@class, 'slick-cell l13 r13')]//select"));
			}
			Thread.sleep(500);
		}

//8th Line
		WebElement grn_no14 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains(@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", grn_no14);
		WebElement grn_no15 = driver.findElement(
				By.xpath(".//div[@style='top:175px']//div[contains(@class, 'slick-cell l12 r12')]//select"));

		for (int i = 0; i < maxRetries; i++) {
			try {
				Select dropdownSelect = new Select(grn_no15);
				java.util.List<WebElement> options = dropdownSelect.getOptions();
				dropdownSelect.selectByIndex(options.size() - 1);
				break;
			} catch (StaleElementReferenceException e) {
				grn_no14 = driver.findElement(
						By.xpath(".//div[@style='top:175px']//div[contains(@class, 'slick-cell l12 r12')]"));
				j.executeScript("arguments[0].click();", grn_no14);
				grn_no15 = driver.findElement(
						By.xpath(".//div[@style='top:175px']//div[contains(@class, 'slick-cell l12 r12')]//select"));
			}
			Thread.sleep(500);
		}

		WebElement line_no14 = driver
				.findElement(By.xpath(".//div[@style='top:175px']//div[contains(@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", line_no14);
		WebElement line_no15 = driver.findElement(
				By.xpath(".//div[@style='top:175px']//div[contains(@class, 'slick-cell l13 r13')]//select"));

		for (int i = 0; i < maxRetries; i++) {
			try {
				Select dropdownSelect = new Select(line_no15);
				java.util.List<WebElement> options = dropdownSelect.getOptions();
				dropdownSelect.selectByIndex(options.size() - 1);
				break;
			} catch (StaleElementReferenceException e) {
				line_no14 = driver.findElement(
						By.xpath(".//div[@style='top:175px']//div[contains(@class, 'slick-cell l13 r13')]"));
				j.executeScript("arguments[0].click();", line_no14);
				line_no15 = driver.findElement(
						By.xpath(".//div[@style='top:175px']//div[contains(@class, 'slick-cell l13 r13')]//select"));
			}
		}
		Thread.sleep(500);

		driver.findElement(By.xpath(".//div[@style='top:175px']//div[contains(@class, 'slick-cell l14 r14')]")).click();

	}

	public void JW_Allocation_GRN_Selection(WebDriver driver) throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor) driver;
//1st Line
		WebElement grn_no = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains(@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", grn_no);
		WebElement grn_no1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains(@class, 'slick-cell l12 r12')]//select"));

		int maxRetries = 3;
		for (int i = 0; i < maxRetries; i++) {
			try {
				Select dropdownSelect = new Select(grn_no1);
				java.util.List<WebElement> options = dropdownSelect.getOptions();
				dropdownSelect.selectByIndex(options.size() - 1);
				break;
			} catch (StaleElementReferenceException e) {
				grn_no = driver
						.findElement(By.xpath(".//div[@style='top:0px']//div[contains(@class, 'slick-cell l12 r12')]"));
				j.executeScript("arguments[0].click();", grn_no);
				grn_no1 = driver.findElement(
						By.xpath(".//div[@style='top:0px']//div[contains(@class, 'slick-cell l12 r12')]//select"));
			}
			Thread.sleep(500);
		}

		WebElement line_no = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains(@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", line_no);
		WebElement line_no1 = driver
				.findElement(By.xpath(".//div[@style='top:0px']//div[contains(@class, 'slick-cell l13 r13')]//select"));

		for (int i = 0; i < maxRetries; i++) {
			try {
				Select dropdownSelect = new Select(line_no1);
				java.util.List<WebElement> options = dropdownSelect.getOptions();
				dropdownSelect.selectByIndex(options.size() - 1);
				break;
			} catch (StaleElementReferenceException e) {
				line_no = driver
						.findElement(By.xpath(".//div[@style='top:0px']//div[contains(@class, 'slick-cell l13 r13')]"));
				j.executeScript("arguments[0].click();", line_no);
				line_no1 = driver.findElement(
						By.xpath(".//div[@style='top:0px']//div[contains(@class, 'slick-cell l13 r13')]//select"));
			}
			Thread.sleep(500);
		}

//2nd Line
		WebElement grn_no2 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains(@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", grn_no2);
		WebElement grn_no3 = driver.findElement(
				By.xpath(".//div[@style='top:25px']//div[contains(@class, 'slick-cell l12 r12')]//select"));

		for (int i = 0; i < maxRetries; i++) {
			try {
				Select dropdownSelect = new Select(grn_no3);
				java.util.List<WebElement> options = dropdownSelect.getOptions();
				dropdownSelect.selectByIndex(options.size() - 1);
				break;
			} catch (StaleElementReferenceException e) {
				grn_no2 = driver.findElement(
						By.xpath(".//div[@style='top:25px']//div[contains(@class, 'slick-cell l12 r12')]"));
				j.executeScript("arguments[0].click();", grn_no2);
				grn_no3 = driver.findElement(
						By.xpath(".//div[@style='top:25px']//div[contains(@class, 'slick-cell l12 r12')]//select"));
			}
			Thread.sleep(500);
		}

		WebElement line_no2 = driver
				.findElement(By.xpath(".//div[@style='top:25px']//div[contains(@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", line_no2);
		WebElement line_no3 = driver.findElement(
				By.xpath(".//div[@style='top:25px']//div[contains(@class, 'slick-cell l13 r13')]//select"));

		for (int i = 0; i < maxRetries; i++) {
			try {
				Select dropdownSelect = new Select(line_no3);
				java.util.List<WebElement> options = dropdownSelect.getOptions();
				dropdownSelect.selectByIndex(options.size() - 1);
				break;
			} catch (StaleElementReferenceException e) {
				line_no2 = driver.findElement(
						By.xpath(".//div[@style='top:25px']//div[contains(@class, 'slick-cell l13 r13')]"));
				j.executeScript("arguments[0].click();", line_no2);
				line_no3 = driver.findElement(
						By.xpath(".//div[@style='top:25px']//div[contains(@class, 'slick-cell l13 r13')]//select"));
			}
			Thread.sleep(500);
		}

//3rd Line
		WebElement grn_no4 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains(@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", grn_no4);
		WebElement grn_no5 = driver.findElement(
				By.xpath(".//div[@style='top:50px']//div[contains(@class, 'slick-cell l12 r12')]//select"));

		for (int i = 0; i < maxRetries; i++) {
			try {
				Select dropdownSelect = new Select(grn_no5);
				java.util.List<WebElement> options = dropdownSelect.getOptions();
				dropdownSelect.selectByIndex(options.size() - 1);
				break;
			} catch (StaleElementReferenceException e) {
				grn_no4 = driver.findElement(
						By.xpath(".//div[@style='top:50px']//div[contains(@class, 'slick-cell l12 r12')]"));
				j.executeScript("arguments[0].click();", grn_no4);
				grn_no5 = driver.findElement(
						By.xpath(".//div[@style='top:50px']//div[contains(@class, 'slick-cell l12 r12')]//select"));
			}
			Thread.sleep(500);
		}

		WebElement line_no4 = driver
				.findElement(By.xpath(".//div[@style='top:50px']//div[contains(@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", line_no4);
		WebElement line_no5 = driver.findElement(
				By.xpath(".//div[@style='top:50px']//div[contains(@class, 'slick-cell l13 r13')]//select"));

		for (int i = 0; i < maxRetries; i++) {
			try {
				Select dropdownSelect = new Select(line_no5);
				java.util.List<WebElement> options = dropdownSelect.getOptions();
				dropdownSelect.selectByIndex(options.size() - 1);
				break;
			} catch (StaleElementReferenceException e) {
				line_no4 = driver.findElement(
						By.xpath(".//div[@style='top:50px']//div[contains(@class, 'slick-cell l13 r13')]"));
				j.executeScript("arguments[0].click();", line_no4);
				line_no5 = driver.findElement(
						By.xpath(".//div[@style='top:50px']//div[contains(@class, 'slick-cell l13 r13')]//select"));
			}
			Thread.sleep(500);
		}

//4th Line
		WebElement grn_no6 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains(@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", grn_no6);
		WebElement grn_no7 = driver.findElement(
				By.xpath(".//div[@style='top:75px']//div[contains(@class, 'slick-cell l12 r12')]//select"));

		for (int i = 0; i < maxRetries; i++) {
			try {
				Select dropdownSelect = new Select(grn_no7);
				java.util.List<WebElement> options = dropdownSelect.getOptions();
				dropdownSelect.selectByIndex(options.size() - 1);
				break;
			} catch (StaleElementReferenceException e) {
				grn_no6 = driver.findElement(
						By.xpath(".//div[@style='top:75px']//div[contains(@class, 'slick-cell l12 r12')]"));
				j.executeScript("arguments[0].click();", grn_no6);
				grn_no7 = driver.findElement(
						By.xpath(".//div[@style='top:75px']//div[contains(@class, 'slick-cell l12 r12')]//select"));
			}
			Thread.sleep(500);
		}

		WebElement line_no6 = driver
				.findElement(By.xpath(".//div[@style='top:75px']//div[contains(@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", line_no6);
		WebElement line_no7 = driver.findElement(
				By.xpath(".//div[@style='top:75px']//div[contains(@class, 'slick-cell l13 r13')]//select"));

		for (int i = 0; i < maxRetries; i++) {
			try {
				Select dropdownSelect = new Select(line_no7);
				java.util.List<WebElement> options = dropdownSelect.getOptions();
				dropdownSelect.selectByIndex(options.size() - 1);
				break;
			} catch (StaleElementReferenceException e) {
				line_no6 = driver.findElement(
						By.xpath(".//div[@style='top:75px']//div[contains(@class, 'slick-cell l13 r13')]"));
				j.executeScript("arguments[0].click();", line_no6);
				line_no7 = driver.findElement(
						By.xpath(".//div[@style='top:75px']//div[contains(@class, 'slick-cell l13 r13')]//select"));
			}
			Thread.sleep(500);
		}

//5th Line
		WebElement grn_no8 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains(@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", grn_no8);
		WebElement grn_no9 = driver.findElement(
				By.xpath(".//div[@style='top:100px']//div[contains(@class, 'slick-cell l12 r12')]//select"));

		for (int i = 0; i < maxRetries; i++) {
			try {
				Select dropdownSelect = new Select(grn_no9);
				java.util.List<WebElement> options = dropdownSelect.getOptions();
				dropdownSelect.selectByIndex(options.size() - 1);
				break;
			} catch (StaleElementReferenceException e) {
				grn_no8 = driver.findElement(
						By.xpath(".//div[@style='top:100px']//div[contains(@class, 'slick-cell l12 r12')]"));
				j.executeScript("arguments[0].click();", grn_no8);
				grn_no9 = driver.findElement(
						By.xpath(".//div[@style='top:100px']//div[contains(@class, 'slick-cell l12 r12')]//select"));
			}
			Thread.sleep(500);
		}

		WebElement line_no8 = driver
				.findElement(By.xpath(".//div[@style='top:100px']//div[contains(@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", line_no8);
		WebElement line_no9 = driver.findElement(
				By.xpath(".//div[@style='top:100px']//div[contains(@class, 'slick-cell l13 r13')]//select"));

		for (int i = 0; i < maxRetries; i++) {
			try {
				Select dropdownSelect = new Select(line_no9);
				java.util.List<WebElement> options = dropdownSelect.getOptions();
				dropdownSelect.selectByIndex(options.size() - 1);
				break;
			} catch (StaleElementReferenceException e) {
				line_no8 = driver.findElement(
						By.xpath(".//div[@style='top:100px']//div[contains(@class, 'slick-cell l13 r13')]"));
				j.executeScript("arguments[0].click();", line_no8);
				line_no9 = driver.findElement(
						By.xpath(".//div[@style='top:100px']//div[contains(@class, 'slick-cell l13 r13')]//select"));
			}
			Thread.sleep(500);
		}

//6th Line
		WebElement grn_no10 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains(@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", grn_no10);
		WebElement grn_no11 = driver.findElement(
				By.xpath(".//div[@style='top:125px']//div[contains(@class, 'slick-cell l12 r12')]//select"));

		for (int i = 0; i < maxRetries; i++) {
			try {
				Select dropdownSelect = new Select(grn_no11);
				java.util.List<WebElement> options = dropdownSelect.getOptions();
				dropdownSelect.selectByIndex(options.size() - 1);
				break;
			} catch (StaleElementReferenceException e) {
				grn_no10 = driver.findElement(
						By.xpath(".//div[@style='top:125px']//div[contains(@class, 'slick-cell l12 r12')]"));
				j.executeScript("arguments[0].click();", grn_no10);
				grn_no11 = driver.findElement(
						By.xpath(".//div[@style='top:125px']//div[contains(@class, 'slick-cell l12 r12')]//select"));
			}
			Thread.sleep(500);
		}

		WebElement line_no10 = driver
				.findElement(By.xpath(".//div[@style='top:125px']//div[contains(@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", line_no10);
		WebElement line_no11 = driver.findElement(
				By.xpath(".//div[@style='top:125px']//div[contains(@class, 'slick-cell l13 r13')]//select"));

		for (int i = 0; i < maxRetries; i++) {
			try {
				Select dropdownSelect = new Select(line_no11);
				java.util.List<WebElement> options = dropdownSelect.getOptions();
				dropdownSelect.selectByIndex(options.size() - 1);
				break;
			} catch (StaleElementReferenceException e) {
				line_no10 = driver.findElement(
						By.xpath(".//div[@style='top:125px']//div[contains(@class, 'slick-cell l13 r13')]"));
				j.executeScript("arguments[0].click();", line_no10);
				line_no11 = driver.findElement(
						By.xpath(".//div[@style='top:125px']//div[contains(@class, 'slick-cell l13 r13')]//select"));
			}
			Thread.sleep(500);
		}

//7th Line
		WebElement grn_no12 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains(@class, 'slick-cell l12 r12')]"));
		j.executeScript("arguments[0].click();", grn_no12);
		WebElement grn_no13 = driver.findElement(
				By.xpath(".//div[@style='top:150px']//div[contains(@class, 'slick-cell l12 r12')]//select"));

		for (int i = 0; i < maxRetries; i++) {
			try {
				Select dropdownSelect = new Select(grn_no13);
				java.util.List<WebElement> options = dropdownSelect.getOptions();
				dropdownSelect.selectByIndex(options.size() - 1);
				break;
			} catch (StaleElementReferenceException e) {
				grn_no12 = driver.findElement(
						By.xpath(".//div[@style='top:150px']//div[contains(@class, 'slick-cell l12 r12')]"));
				j.executeScript("arguments[0].click();", grn_no12);
				grn_no13 = driver.findElement(
						By.xpath(".//div[@style='top:150px']//div[contains(@class, 'slick-cell l12 r12')]//select"));
			}
			Thread.sleep(500);
		}

		WebElement line_no12 = driver
				.findElement(By.xpath(".//div[@style='top:150px']//div[contains(@class, 'slick-cell l13 r13')]"));
		j.executeScript("arguments[0].click();", line_no12);
		WebElement line_no13 = driver.findElement(
				By.xpath(".//div[@style='top:150px']//div[contains(@class, 'slick-cell l13 r13')]//select"));

		for (int i = 0; i < maxRetries; i++) {
			try {
				Select dropdownSelect = new Select(line_no13);
				java.util.List<WebElement> options = dropdownSelect.getOptions();
				dropdownSelect.selectByIndex(options.size() - 1);
				break;
			} catch (StaleElementReferenceException e) {
				line_no12 = driver.findElement(
						By.xpath(".//div[@style='top:150px']//div[contains(@class, 'slick-cell l13 r13')]"));
				j.executeScript("arguments[0].click();", line_no12);
				line_no13 = driver.findElement(
						By.xpath(".//div[@style='top:150px']//div[contains(@class, 'slick-cell l13 r13')]//select"));
			}
			Thread.sleep(500);
		}

		driver.findElement(By.xpath(".//div[@style='top:150px']//div[contains(@class, 'slick-cell l14 r14')]")).click();

	}

	public static String generateRandom17DigitNumber() {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 17; i++) {
			sb.append(random.nextInt(10)); // Generate a random digit (0-9) and append to the StringBuilder
		}
		return sb.toString();
	}

}
