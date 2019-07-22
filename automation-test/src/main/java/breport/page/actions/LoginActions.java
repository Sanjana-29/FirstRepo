package breport.page.actions;

import breport.config.CommonActions;
import breport.data.TestData;
import breport.objects.*;


public class LoginActions extends CommonActions{

	public static void username() {
		click(LoginObjects.uname);
		sendKeys(LoginObjects.uname, TestData.username);
	}
	
	public static void password() {
		click(LoginObjects.password);
		sendKeys(LoginObjects.password, TestData.password);
	}
	
	public static void submit() throws InterruptedException {
		click(LoginObjects.login);
		Thread.sleep(10000);
	}
	
	public static void pagetitle() {
		verifyPageTitle("WEB-BGM Dashboard", "Page title on Dashboard page is passed", "page title did not match");
	}
	
	public static void homepage() {
		verifyTexts(LoginObjects.pageheader, "Bauer WEB-BGM", "Header- 'Bauer WEB-BGM' is present");
	}
}
