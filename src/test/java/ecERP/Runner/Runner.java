package ecERP.Runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import ecERP.Report.Report;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(publish = false, features = { "src/test/resources/feature/GP.feature" }, glue = "gp.Step", dryRun = false, monochrome = false, plugin = {
				"pretty", "junit:target\\sample.xml", "html:target\\html-reports",
				"json:target\\json-reports\\output.json" }, tags = "")

public class Runner {

	@AfterClass
	public static void afterScenario() {

		Report.generateJVMReport(
				"D:\\Automation Data\\GIT Scripts\\Login Page Automation Script\\erp_automation\\target\\json-reports\\output.json");
	}

	public static void main(String[] args) {
		String[] featureFilePaths = {
				"D:\\Automation Data\\GIT Scripts\\Login Page Automation Script\\erp_automation\\src\\test\\resources\\feature\\GP.feature"};

		for (String featureFilePath : featureFilePaths) {

//		String featureFilePath = "D:/Automation Data/GIT Scripts/Login Page Automation Script/erp_automation/src/test/resources/feature";
//		System.out.println("Feature File Path: " + featureFilePath);

			String[] cucumberArgs = { featureFilePath, "--glue", "gp.Step", "--plugin", "pretty", "--plugin",
					"junit:result\\sample.xml", "--strict" };
			io.cucumber.core.cli.Main.run(cucumberArgs, Thread.currentThread().getContextClassLoader());
		}
	}
}

/*
 * Ashwin
 * 
 * String featureFilePath =
 * "D:/Automation Data/GIT Scripts/Login Page Automation Script/erp_automation/src/test/resources/feature/PO Approval and Issue.feature"
 * ; System.out.println("Feature File Path: " + featureFilePath);
 * 
 * String[] cucumberArgs = { featureFilePath, "--glue", "ecERP.PO", "--plugin",
 * "pretty", "--plugin", "junit:target\\sample.xml", "--tags",
 * "@Scenario-1-PoOrder:RM", "--strict"
 * 
 * }; io.cucumber.core.cli.Main.run(cucumberArgs,
 * Thread.currentThread().getContextClassLoader()); } /
 */
