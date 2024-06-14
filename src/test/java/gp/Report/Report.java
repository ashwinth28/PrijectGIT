package gp.Report;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Report {

	public static void generateJVMReport(String jsonFile) {

		File reportDirectory = new File("D:\\Automation Data\\GIT Scripts\\Login Page Automation Script\\erp_automation\\target");

		Configuration configuration = new Configuration(reportDirectory, "ecERPApplication");

		configuration.addClassifications("platformName", "Windows");
		configuration.addClassifications("platformVersion", "11 Pro");
		configuration.addClassifications("buildNo", "[V-1.16-1963]");

		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);

		ReportBuilder reportbuilder = new ReportBuilder(jsonFiles, configuration);
		reportbuilder.generateReports();

	}
}
