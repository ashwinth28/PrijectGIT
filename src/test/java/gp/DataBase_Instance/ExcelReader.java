package gp.DataBase_Instance;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static List<CRMData> readExcel(String filePath) {
		List<CRMData> crmDataList = new ArrayList<>();

		try (FileInputStream fis = new FileInputStream(new File(filePath))) {

			Workbook workbook = new XSSFWorkbook(fis);
			FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
			Sheet sheet = workbook.getSheetAt(6); // Get the first sheet
			Iterator<Row> rowIterator = sheet.iterator();

			for (int i = 0; i < 3 && rowIterator.hasNext(); i++) {
				rowIterator.next();
			}

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				CRMData crmData = new CRMData();

				crmData.setInvoice_no(getCellValue(row.getCell(0), evaluator));
//				crmData.setInvoice_date(Date.parse(filePath) getDateCellValue(row.getCell(1)));
				crmData.setCrm_typeof_orderl(getCellValue(row.getCell(2), evaluator));
				crmData.setOwner_name(getCellValue(row.getCell(3), evaluator));
				crmData.setAccount_name(getCellValue(row.getCell(4), evaluator));
				crmData.setMarket_area(getCellValue(row.getCell(5), evaluator));
				crmData.setProduct_code(getCellValue(row.getCell(6), evaluator));
				crmData.setQty(getIntCellValue(row.getCell(7)));
				crmData.setMat_value_realized_usd(getCellValue(row.getCell(9), evaluator));
				crmData.setMat_value_incurred_usd(getCellValue(row.getCell(12), evaluator));
				crmData.setInward_frieght_incurred_usd(getCellValue(row.getCell(17), evaluator));
				crmData.setPacking_material(getCellValue(row.getCell(18), evaluator));
				crmData.setOthers_incurred(getCellValue(row.getCell(19), evaluator));
				crmData.setCost_incurred(getCellValue(row.getCell(21), evaluator));
				crmData.setGp_excluding_freight(getCellValue(row.getCell(22), evaluator));
				crmData.setGp_excluding_freight_inpercentage(getCellValue(row.getCell(23), evaluator));
				crmData.setFreight_realized(getCellValue(row.getCell(24), evaluator));
				crmData.setInvoice_value(getCellValue(row.getCell(25), evaluator));
				crmData.setFreight_incurred(getCellValue(row.getCell(26), evaluator));
				crmData.setCost_incurred_incl_freight(getCellValue(row.getCell(27), evaluator));
				crmData.setGross_profit(getCellValue(row.getCell(28), evaluator));
				crmData.setGross_profit_percentage((getDisplayedCellValue(row.getCell(29), evaluator)));

				crmDataList.add(crmData);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return crmDataList;
	}

	public static String getDisplayedCellValue(Cell cell, FormulaEvaluator evaluator) {
		// Create a DataFormatter to format the cell's value as it is displayed
		DataFormatter dataFormatter = new DataFormatter();

		// Evaluate the cell if it contains a formula
		return String.valueOf(roundUp(cell.getNumericCellValue()*100)+"%");
//		evaluator.evaluateInCell(cell);
//
//		// Get the formatted value as a string
//		return dataFormatter.formatCellValue(cell, evaluator);
	}
	
	public static Double roundUp(Double input) {
		if(input != 0) {
			DecimalFormat decimalFormat = new DecimalFormat("#.##; -#.##");
			String inputWith2DecimalPlaces = decimalFormat.format(input);
			return Double.parseDouble(inputWith2DecimalPlaces);	
		}else {
			return 0D;
		}
	}

	private static int getIntCellValue(Cell cell) {
		if (cell == null) {
	        return 0; // or any default value
	    }
	    try {
	        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
	            return (int) cell.getNumericCellValue();
	        } else if (cell.getCellType() == cell.CELL_TYPE_STRING) {
	            String cellValue = cell.getStringCellValue();
	            return Integer.parseInt(cellValue.trim());
	        } else {
	            // Handle other cell types if needed
	            System.out.println("Unexpected cell type: " + cell.getCellType());
	            return 0; // or any default value
	        }
	    } catch (NumberFormatException e) {
	        System.err.println("Error parsing cell value as integer: " + cell.toString());
	        return 0; // or any default value
	    }
	}

	private static Date getDateCellValue(Cell cell) {
//		return cell != null ? 
//				Date.valueOf(LocalDate.parse(cell.getDateCellValue().toString(), DateTimeFormatter.ofPattern("dd-MMM-yy"))) : 
//			Date.valueOf(LocalDate.parse(cell.getStringCellValue(), DateTimeFormatter.ofPattern("dd-MMM-yy")));
//	}

//		if (cell == null) {
		return null;
//	    }
//
//	    if (DateUtil.isCellDateFormatted(cell)) {
//	        Date date = cell.getDateCellValue();
//	        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//	    } else {
//	        // In case the date is stored as a string, attempt to parse it
//	        String dateString = cell.getStringCellValue();
//	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yy");
//	        return Date.valueOf(LocalDate.parse(dateString, formatter));
//	    }
	}

	private static String getCellValue(Cell cell, FormulaEvaluator evaluator) {
		try {
			CellValue cellValue = evaluator.evaluate(cell);
			if (cellValue != null) {
				switch (cellValue.getCellType()) {
				case Cell.CELL_TYPE_BOOLEAN:
					return String.valueOf(cellValue.getBooleanValue());
				case Cell.CELL_TYPE_NUMERIC:
					return String.valueOf(cellValue.getNumberValue());
				case Cell.CELL_TYPE_STRING:
					return cellValue.getStringValue();
				case Cell.CELL_TYPE_BLANK:
					return "";
				case Cell.CELL_TYPE_ERROR:
					return String.valueOf(cellValue.getErrorValue());
				default:
					return "Unknown cell type";
				}
			} else {
				return "";
			}
		} catch (Exception e) {
			// Fallback: Read the cell value directly if the formula evaluation fails
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_BOOLEAN:
				return String.valueOf(cell.getBooleanCellValue());
			case Cell.CELL_TYPE_NUMERIC:
				return String.valueOf(cell.getNumericCellValue());
			case Cell.CELL_TYPE_STRING:
				return cell.getStringCellValue();
			case Cell.CELL_TYPE_BLANK:
				return "";
			case Cell.CELL_TYPE_ERROR:
				return String.valueOf(cell.getErrorCellValue());
			case Cell.CELL_TYPE_FORMULA:
				return getCachedFormulaValue(cell); // This will return the formula string itself
			default:
				return "Unknown cell type";
			}
		}
	}

	private static String getCachedFormulaValue(Cell cell) {
		switch (cell.getCachedFormulaResultType()) {
		case Cell.CELL_TYPE_BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case Cell.CELL_TYPE_NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();
		case Cell.CELL_TYPE_ERROR:
			return "Error: " + cell.getErrorCellValue();
		case Cell.CELL_TYPE_BLANK:
			return "";
		default:
			return "Unknown catched formula result type";
		}
	}

	private static int getIntCellValue(Cell cell, FormulaEvaluator evaluator) {
		String cellValue = getCellValue(cell, evaluator);
		return cellValue != null ? Integer.parseInt(cellValue) : 0;
	}

//	private static Date getDateCellValue(Cell cell, FormulaEvaluator evaluator) {
//		if (cell == null)
//			return null;
//		if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
//			CellValue cellValue = evaluator.evaluate(cell);
//			if (cellValue.getCellType() == Cell.CELL_TYPE_NUMERIC && DateUtil.isCellDateFormatted(cell)) {
//				return DateUtil.getJavaDate(cellValue.getNumberValue());
//			}
//		}
//		return cell.getDateCellValue();
//	}

	public static void main(String[] args) {
		
		String filePath = "C:\\Users\\AntonyAshwinthAR\\Desktop\\Final GP\\24-25_GrossProfit.xlsx";
//		String filePath = "C:\\Users\\AntonyAshwinthAR\\Desktop\\Gross_Profit_(Ponrajan).xlsx";
		List<CRMData> excelData = readExcel(filePath);
	}
}