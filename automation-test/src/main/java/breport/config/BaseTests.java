package breport.config;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import breport.objects.LoginObjects;
import breport.objects.NavigationObjects;
import breport.objects.RecordsObjects;
import breport.objects.ReportsObjects;
import breport.objects.UploadObjects;

public class BaseTests {

	public static WebDriver driver;
	public static String baseurl;

	public static ExtentReports report = null;
	public static ExtentTest test;
	public static String reportPath = ".\\Reports\\";

	@BeforeSuite
	@Parameters({"BrowserName"})
	public static void setup(String browser) throws Exception {

		report = Reports.getReport(reportPath);

		driver = Drivers.getDriver(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		baseurl = "https://webbgm.bauer.de";
		driver.get(baseurl);
		Thread.sleep(5000);
	}

	@BeforeClass
	public static void initElements() {
		PageFactory.initElements(driver, LoginObjects.class);
		PageFactory.initElements(driver, RecordsObjects.class);
		PageFactory.initElements(driver, NavigationObjects.class);
		PageFactory.initElements(driver, UploadObjects.class);
		PageFactory.initElements(driver, ReportsObjects.class);
	}

	@BeforeMethod
	public void printMethodName(Method method) {
		test = report.startTest(method.getName(), method.getAnnotation(org.testng.annotations.Test.class).description())
				.assignCategory(this.getClass().getSimpleName());


		System.out.println("Executing testcase: "+ this.getClass().getSimpleName() + "." + method.getName()); 
	} 

	@AfterMethod
	public static void getResult(ITestResult result) throws InterruptedException {

		if (result.getStatus() == ITestResult.FAILURE) {
			Thread.sleep(2000);
			String image = test.addScreenCapture(CommonActions.getScreenshot());	
			test.log(LogStatus.FAIL, result.getName()+" test failed", image);
		} else if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, result.getName() +" test passed");
		} else {
			test.log(LogStatus.SKIP, result.getName() +" test skipped");
		}

		report.endTest(test);
	}	

	@AfterTest
	public static void endReport() {
		report.flush();
	}

	@AfterSuite
	public static void tearDown() {
		report.close();
		//		driver.quit();
	}
}

