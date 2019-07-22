package breport.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Drivers {

	public static WebDriver driver;

	public static WebDriver getDriver(String type) throws Exception {

		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--disable-features=EnableEphemeralFlashPermission");
		options.addArguments("--disable-infobars");
		options.addArguments("--ppapi-flash-version=32.0.0.192");
		options.addArguments("--ppapi-flash-path=/usr/lib/pepperflashplugin-nonfree/libpepflashplayer.so");

		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.content_settings.exceptions.plugins.*,*.per_resource.adobe-flash-player", "true");
		prefs.put("profile.default_content_setting_values.plugins", "true");
		prefs.put("profile.content_settings.plugin_whitelist.adobe-flash-player", "true");
		prefs.put("profile.default_content_setting_values.notifications", "true");
		
		// Enable Flash for this site
		prefs.put("PluginsAllowedForUrls", "https://webbgm.bauer.de/"); 
		prefs.put("PopupsAllowedForUrls", "https://webbgm.bauer.de/");
		prefs.put("NotificationsAllowedForUrls", "https://webbgm.bauer.de/");
		
		prefs.put("PluginsAllowedForUrls", "https://webbgm.bauer.de/testbreport/resources/dashboard.html"); 
		prefs.put("PopupsAllowedForUrls", "https://webbgm.bauer.de/testbreport/resources/dashboard.html");
		prefs.put("NotificationsAllowedForUrls", "https://webbgm.bauer.de/testbreport/resources/dashboard.html/#records");
		
		options.setExperimentalOption("prefs", prefs);
		
		if(type.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver(options);
			return driver;
		}
		
		else if(type.equalsIgnoreCase("Firefox")){
			
//			DesiredCapabilities capability = DesiredCapabilities.firefox(); 
			
			FirefoxProfile ffProfile = new FirefoxProfile(); 
			ffProfile.setPreference("dom.ipc.plugins.enabled.libflashplayer.so","true"); 
			ffProfile.setPreference("plugin.state.flash", 2); 
			
			FirefoxOptions ffOptions = new FirefoxOptions();
			ffOptions.setCapability("marionette", true); 
			ffOptions.setCapability(FirefoxDriver.PROFILE, ffProfile);
			
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			return driver;
		}

		throw new Exception(type + "driver not found");
	}
}

