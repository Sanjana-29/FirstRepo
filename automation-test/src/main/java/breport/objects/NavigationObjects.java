package breport.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationObjects {

	@FindBy (id="record-menu")
	public static WebElement record_menu;
	
	@FindBy (id="report-menu")
	public static WebElement reports_menu;
	
	@FindBy (id="dailyReportMenu")
	public static WebElement dailyreport_menu;
	
	@FindBy (xpath="//a[@href='#uploadFileModal']")
	public static WebElement upload_menu;
	
	@FindBy (id="downloadOffline")
	public static WebElement offline_menu;
	
	@FindBy (xpath="//a[@class='dropdown-toggle'][contains(.,'Help')]")
	public static WebElement help_menu;
	
	@FindBy (id="languageType")
	public static WebElement language_menu;
	
	@FindBy (id="userApplicationType")
	public static WebElement applicationType_menu;
	
	@FindBy (id="applicationTypeList")
	public static WebElement applicationType_list;
	
	@FindBy (className="back")
	public static WebElement close_button;

}
