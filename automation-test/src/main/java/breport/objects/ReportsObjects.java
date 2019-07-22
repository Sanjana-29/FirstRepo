package breport.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReportsObjects {
	
	//Filter
	@FindBy (xpath = "//a[contains(text(),'Filter By')]")
	public static WebElement filter;
	
	@FindBy (id="pile-input")
	public static WebElement filter_pileno;
	
	@FindBy (xpath = "//span[@class='form-control']")
	public static WebElement filter_daterange;
	
	@FindBy (xpath = "//div[@class='ranges']//ul")
	public static WebElement daterange_list;
	
	@FindBy (id="resetFilter")
	public static WebElement filter_reset;
	
	//File table
	@FindBy (xpath = "//div[contains(text(),'File List')]")
	public static WebElement filelist_title;
	
	@FindBy (id = "file_table")
	public static WebElement fileTable;
	
	@FindBy (id = "file_table_info")
	public static WebElement fileTable_info;
	
	@FindBy (id = "file_table_paginate")
	public static WebElement fileTable_paginate;
	
	@FindBy (xpath = "//div[7]//div[2]//tr[1]//th[1]")
	public static WebElement leftCalendar_prev;
	
	@FindBy (xpath = "/html[1]/body[1]/div[5]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[2]")
	public static WebElement leftCalendar_header;
	
	@FindBy (xpath = "//div[7]//div[2]//tr[1]//th[3]")
	public static WebElement leftCalendar_next;
	
	@FindBy (xpath = "//div[7]//div[1]//div[1]//tr[1]//th[1]")
	public static WebElement rightCalendar_prev;
	
	@FindBy (xpath = "//div[7]//div[1]//div[1]//tr[1]//th[3]")
	public static WebElement rightCalendar_next;
	
	//Main panel
	@FindBy (id = "reportHeaderSpanId")
	public static WebElement report_header;
	
	@FindBy (xpath = "//a[@title='Edit Header']")
	public static WebElement edit_reportHeader;
	
	@FindBy (xpath = "//div[@class='editable-error-block help-block']")
	public static WebElement header_errorMessage;
	
	@FindBy (id = "editHeaderDyanamic")
	public static WebElement editHeader_title;
	
	@FindBy (xpath = "//div[@class='editable-input']//input[@class='form-control input-sm']")
	public static WebElement editHeader_textbox;
	
	@FindBy (xpath = "(//button[@type='submit'])[2]")
	public static WebElement editHeader_submitButton;
	
	@FindBy (xpath = "//button[@class='btn btn-default btn-sm editable-cancel']")
	public static WebElement editHeader_cancelButton;
	
	@FindBy (id = "printPreview")
	public static WebElement print_report;
	
	@FindBy (xpath = "/html[1]/body[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[4]/a[1]")
	public static WebElement comments;
	
	@FindBy (xpath = "//h3[@class='popover-title']")
	public static WebElement comments_title;
	
	@FindBy (xpath = "//textarea[contains(@class,'form-control input-large')]")
	public static WebElement comments_textbox;
	
	@FindBy(xpath = "//a[@title='Settings']")
	public static WebElement settings; 
	
	@FindBy(id = "reportLogo")
	public static WebElement reportLogo;
	
	@FindBy(id = "zoomon")
	public static WebElement zoomInfo;
	
	//Settings dialog box
	@FindBy(xpath = "//div[@id='settingsModal']")
	public static WebElement settings_header;
	
	@FindBy (xpath = "//a[@id='systemSettings']")
	public static WebElement systemSettings;
	
	@FindBy(id = "reportSettings")
	public static WebElement reportSettings;
	
	@FindBy(id = "localSettings")
	public static WebElement localSettings;
	
	//System settings 
	
	@FindBy(id = "sysSettingTable")
	public static WebElement systemSettings_table;
	
	@FindBy(xpath = "//button[@id='saveSystemSettings']")
	public static WebElement saveSystemSettings;
	
	@FindBy(xpath = "//button[@id='resetAll']")
	public static WebElement resetSystemSettings;
	
	@FindBy(xpath = "//div[@id='settingsModal']//a[@class='btn btn-primary']")
	public static WebElement cancelSystemSettings;
	
	//Reports- Timechart settings
	@FindBy (xpath = "//ul[@id='settingTab']")
	public static WebElement settingsTab;
	
	@FindBy (xpath = "//a[@id='time']")
	public static WebElement timeTab;
	
	@FindBy (id = "graphConfigTable2")
	public static WebElement timeChart_table;
	
	@FindBy (xpath = "//div[@id='timeChartSettingView']//tr//td[1]")
	public static List<WebElement> timeChart_col1;
	
	@FindBy (xpath = "(//div[contains(@class,'legendLabel')])[1]")
	public static WebElement timeChart_graphTitle;
	
	@FindBy (id = "exportMode")
	public static WebElement exportMode_button;
	
	@FindBy (xpath = "//input[contains(@name,'autoscale_time')]")
	public static WebElement timeAutoScale_checkbox;
	
	@FindBy (xpath = "//div[@id='scaleAuto']//button[contains(@class,'close')]")
	public static WebElement autoScale_closeButton;
	
	@FindBy (id = "saveScaleSetting")
	public static WebElement autoScale_saveButton;
	
	@FindBy (id="saveReportSetting")
	public static WebElement saveReportSetting;
	
	@FindBy (xpath= "//tbody[@id='timeChartSettingModal']/tr[1]/td[1]//input[@type = 'checkbox']")
	public static WebElement timechart_checkbox;
	
	@FindBy (xpath= "//div[@id='timeChartSettingView']//tr//td[3]")
	public static WebElement timeChannelName;
	
	@FindBy (xpath = "(//input[@name='factor'])[1]")
	public static WebElement timechart_factor;
	
	@FindBy (xpath = "(//select[@name='color'])[1]")
    public static WebElement timechart_color;
	
	@FindBy (xpath = "//div[@id='legendContainerTime0']//div[@class='legendColorBox']")
	public static WebElement timechart_colorbox;
	
	@FindBy (xpath = "(//input[@name='position'])[1]")
	public static WebElement timechart_graphPosition;
	
	@FindBy (id= "tristateBoxInput2")
	public static WebElement checkbox; 
	
	//Depth chart
	@FindBy (xpath = "//a[@id='depth']")
	public static WebElement depthTab;
	
	@FindBy (xpath = "//a[@href='#depthChartSettingView']")
	public static WebElement depthChart_tab;
	
	@FindBy (xpath = "//input[contains(@name,'autoscale')]")
	public static WebElement depthAutoScale_checkbox;
	
	@FindBy (xpath = "(//td[@class='legendLabel'])[1]")
	public static WebElement depthChart_graphTitle;
	
	@FindBy (xpath = "//div[@id='depthChartSettingView']//tr//td[3]")
	public static WebElement depthChannelName;
	
	@FindBy (xpath = "//tbody[@id='depthChartSettingModal']/tr[1]/td[1]//input[@type = 'checkbox']")
	public static WebElement depthChartCheckbox;
	
	@FindBy (xpath = "(//input[@name='factor'])[61]")
	public static WebElement depthChart_factor;
	
	@FindBy (xpath = "(//select[@name='color'])[61]")
	public static WebElement depthChart_color;
	
	@FindBy (xpath = "//div[@id='legendContainerDepth0']//td[@class='legendColorBox']")
	public static WebElement depthChart_colorbox;
	
	@FindBy (xpath = "(//input[@name='position'])[61]")
	public static WebElement depthchart_graphPosition;
	
	//Locale Settings
	@FindBy (id = "selectLanguage")
	public static WebElement locale_selectLanguage;
	
	@FindBy (id = "selectUnit")
	public static WebElement locale_selectUnit;
	
	@FindBy (id="selectSeparator")
	public static WebElement locale_selectSeparator;
	
	@FindBy (id = "zoomYaxis")
	public static WebElement locale_zoomYaxis;
	
    //	Reports parameter 
		
	@FindBy (xpath = "//a[@href='#paramSettingView']")
	public static WebElement reportsParameter_tab;
	
    //	Print preview page
	@FindBy(xpath = "//b[contains(text(),'RSV Report')]")
	public static WebElement report_Heading;
	
	@FindBy(xpath = "//td[contains(text(),'This is test comment')]")
	public static WebElement report_comment;
	
	
	
}
