package breport.testcases;

import org.testng.annotations.Test;

import breport.page.actions.ReportsActions;


public class ReportsTestcases extends ReportsActions{

	@Test (priority = 0)
	public static void click_on_breport() throws InterruptedException {
		breport.page.actions.RecordsActions.brecords();	
	}
	
	@Test (priority = 1)
	public static void verify_pagetitle() {
		breport.page.actions.RecordsActions.pageTitle();
	}
	
	@Test (priority = 2)
	public static void click_on_report() throws InterruptedException {
		goToReports();	
		Thread.sleep(2000);
	}
	
	@Test (priority = 3)
	public static void verify_reportsUrl() {
		reportsUrl();
	}
	
	@Test (priority = 4)
	public static void verify_filterby_date() throws Exception {
		filterByDate();
	}
	
	@Test (priority = 5)
	public static void verify_filterby_invalid_pileno() throws Exception {
		scrollUp();
		filterByPileNo("invalidpileno");
	}
	
	@Test (priority = 6)
	public static void verify_filterby_valid_pileno() throws Exception {
		filterByPileNo("g119");
	}
	
	@Test (priority = 7)
	public static void verify_reportHeader() throws InterruptedException {
		reportHeader();
	}
	
	@Test (priority = 8)
	public static void verify_comments() throws InterruptedException {
		comments();
	}
	
	@Test (priority = 9)
	public static void verify_zoomImage() throws InterruptedException {
		zoom();
	}
	
	@Test (priority = 15)
	public static void verify_printReport() throws InterruptedException {
		printReport();
	}
	
	@Test (priority = 11)
	public static void verify_timeChartReportsSettings() throws InterruptedException {
		reportsSettings_timeChart();
	}
	
	@Test (priority = 12)
	public static void verify_depthChartReportsSettings() throws InterruptedException {
		reportsSettings_depthChart();
	}
	
	@Test (priority = 13)
	public static void verify_reportParameterSettings() throws InterruptedException {
		reportsSettings_parameters();
	}
	
	@Test (priority = 14)
	public static void verify_localeSettings() throws InterruptedException {
		localeSettings();
	}
	
	@Test (priority = 15)
	public static void verify_systemSettings() throws InterruptedException {
		systemSettings();
	}

}
