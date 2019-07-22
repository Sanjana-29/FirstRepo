package breport.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginObjects {

	@FindBy(name= "LoginForm[email]")
	public static WebElement uname;
	
	@FindBy(name="LoginForm[password]")
	public static WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement login;
	
	@FindBy(xpath = "//a[@class='navbar-brand'][contains(.,'Bauer WEB-BGM')]")
	public static WebElement pageheader;
	
	@FindBy(xpath = "//a[@class='navbar-brand'][contains(.,'Bauer WEB-BGM')]")
	public static WebElement pagetitle;
}
