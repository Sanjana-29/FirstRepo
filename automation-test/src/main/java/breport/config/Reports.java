package breport.config;


import java.text.ParseException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import breport.config.CommonActions;
public class Reports {
//	static String today = CommonActions.getCurrentDate();
	public static String report_name = "B-Report_";
	public static ExtentReports report=null;
	public static ExtentTest test;
	
	
	public static ExtentReports getReport(String reportPath) throws ParseException {
		if(report == null) {
//			ExtentHtmlReporter reporter = new ExtentHtmlReporter(reportPath + report_name);
//			report.attachReporter(reporter);
			
//			String today =  report_name + CommonActions.getDateTime() + ".html";
//			report_name = today;
			report = new ExtentReports(reportPath + report_name+ CommonActions.getDateTime()+ ".html");

			report.addSystemInfo("Browser", "Chrome");
			report.addSystemInfo("Selenium Version", "3.141.59");
			report.addSystemInfo("Author", "Sanjana");
//			report.loadConfig(configFile);
			
	}
		return report;
}
}
