package breport.config;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.TimeZone;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.google.common.io.Files;
import com.relevantcodes.extentreports.LogStatus;

public class CommonActions extends BaseTests {
	
	// public static String image = test.addScreenCapture(getScreenshot());
	static DateTimeFormatter sdf;

	public static void verifyUrl(String expected) {
		try {
			String actual = driver.getCurrentUrl();
			Assert.assertEquals(expected, actual);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void click(WebElement element) {
		try {
			highlightElement(element);
			element.click();
//			test.log(LogStatus.PASS, "Click test passed");
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			System.out.println("Error! Element not found");
//			test.log(LogStatus.FAIL, "Click test failed");
		}
	}

	public static void sendKeys(WebElement element, String value) {
		try {
			element.clear();
			element.sendKeys(value);
//			test.log(LogStatus.PASS, "Data entered successfully");
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			System.out.println("Error! Element no found");
//			test.log(LogStatus.FAIL, "Error! Element no found");
		}
	}

	public static void verifyTexts(WebElement element, String expected, String message) {
		try {
			highlightElement(element);
			String actual = element.getText();
			Assert.assertEquals(expected, actual);
			
			if (actual.equals(expected)) {
				System.out.println(message);
//				test.log(LogStatus.PASS, "text verification passed");
			} else {
				System.out.println("Text verification failed");
//				test.log(LogStatus.FAIL, "text verification failed");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static WebElement highlightElement(WebElement element) {
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='2px solid lime'", element);
		}
		return element;
	}

	public static void verifyPageTitle(String expected, String preport_desc, String freport_desc) {
		try {
			String actual = driver.getTitle();
			if (actual.equals(expected)) {
				System.out.println("Title matched");
//				test.log(LogStatus.PASS, preport_desc);
			} else {
				System.out.println("Title did not match");
//				test.log(LogStatus.FAIL, "Title did not match");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			test.log(LogStatus.FAIL, freport_desc);
		}
	}

	public static void verifyElement(WebElement element, String message) {
		highlightElement(element);
		boolean logo = element.isDisplayed();
		if (logo = true) {
			System.out.println(message);
			test.log(LogStatus.PASS, "Element verification passed");
		} else {
			System.out.println("Error! Image is not displayed");
			test.log(LogStatus.FAIL, "Error! Image is not displayed");
		}
	}

	public static void enableFlash() {

		Map<String, Object> chromeOptions = new HashMap<>();
		// chromeOptions.put("args", getDefaultFlagList());

		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.default_content_setting_values.plugins", 1);
		prefs.put("profile.content_settings.plugin_whitelist.adobe-flash-player", 1);
		prefs.put("profile.content_settings.exceptions.plugins.*,*.per_resource.adobe-flash-player", 1);
		chromeOptions.put("prefs", prefs);

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
	}

	public static void switchTab(int window) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("Number of open tabs:" + tabs.size());
		driver.switchTo().window(tabs.get(window));
	}

	public static void explicitWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	public static void datePicker(WebElement element, String date) {
		List<WebElement> columns = element.findElements(By.tagName("td"));

		for (WebElement cell : columns) {

			if (cell.getText().equals(date)) {
				cell.findElement(By.linkText(date)).click();
				break;
			}
		}
	}

	public static void verifyColor(WebElement element, String attribute, String value) {
		String actual = element.getCssValue(attribute);
		String hex = Color.fromString(actual).asHex();
		Assert.assertEquals(value, hex);
	}

	public static void moveToElement(WebElement element) {
		Actions move = new Actions(driver);
		move.moveToElement(element).build().perform();
	}

	public static void dropdown(WebElement element, String type, String data, int index) {

		Select d = new Select(element);
		switch (type) {
		case "value":
			d.selectByValue(data);
			break;
		case "text":
			d.selectByVisibleText(data);
			break;
		case "index":
			d.selectByIndex(index);
			break;
		}
	}

	public static boolean isbuttonEnabled(WebElement locator, String message) {
		boolean active = locator.isEnabled();
		Assert.assertTrue(message, true);
		return true;
	}

	public static void acceptAlert() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	public static void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// This will scroll the web page till end.
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public static void scrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, -250)");
	}

	public static String getScreenshot() {
		TakesScreenshot ts = (TakesScreenshot) Drivers.driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		String path = "D:\\B-Report\\Screenshots\\" + ".png";

		File destination = new File(path);

		try {
			Files.copy(src, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
		return path;

	}
	
/*	public static String getCurrentDate() {
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//		Date date = new Date();
//		String currentDate = sdf.format(date);
		
		Calendar cal = Calendar.getInstance();
        String currentDate = sdf.format(cal.getTime());
               
        return currentDate;
        
//        String prevDate = sdf.format(cal.getTime));
	}
	*/
	
	public static String getDate(String range) throws Exception{
		sdf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate today = LocalDate.now();

		if(range=="today") {
			String to = today.format(sdf);
			return to;
			
		}else if(range == "yesterday") {
			LocalDate yesterday = today.minusDays(1);
			String yes = yesterday.format(sdf);
			return yes;
			
		}else if(range == "7Days") {
			LocalDate yesterday = today.minusDays(6);
			String seven = yesterday.format(sdf);
			return seven;
			
		}else if(range == "30Days") {
			LocalDate tday = today.minusDays(29);
			String thirty = tday.format(sdf);
			return thirty;
		}
		throw new Exception ("Date not found");
	}

	public static String getYesterday() {
		sdf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate today = LocalDate.now();
		LocalDate yesterday = today.minusDays(1);
		String yes = yesterday.format(sdf);
		
		return yes;
	}
	
	public static String getDateTime() throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("E-yyyy-MM-dd-'at'-hh-mma");
		// get current date time with Date()
		Date date = new Date();

//		dateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
		String report_date = dateFormat.format(date);
//		String report_date = report_date1.toLowerCase();
		System.out.println("current time is " + report_date);
		return report_date;
	}
	
	public static void expliciteWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static String randomNumber(int num) {
		Random number = new Random();
		int random_num = number.nextInt(100);
		Integer obj = new Integer(random_num);
		String value = obj.toString();
		return value;
	}
}
