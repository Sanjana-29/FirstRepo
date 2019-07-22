package breport.testcases;

import org.testng.annotations.Test;
import breport.page.actions.LoginActions;

public class LoginTestcases extends LoginActions{

	@Test (priority = 0)
	public static void enter_username() {
		username();
	}
	
	@Test (priority = 1)
	public static void enter_password() {
		password();
	}
	
	@Test (priority = 3)
	public static void click_on_submit() throws InterruptedException {
		submit();	
	}
	
	@Test (priority = 4)
	public static void verify_pagetitle_on_dashboardpage() throws InterruptedException {
		pagetitle();
	}
	
	@Test (priority = 5)
	public static void verify_navbar_header_on_dashboardpage() throws InterruptedException {
		homepage();
	}
	
}
