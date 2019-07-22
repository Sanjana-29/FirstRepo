package breport.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecordsObjects {

	@FindBy(xpath = "//a[contains(text(),'B-Report')]")
	public static WebElement breports_tab;
	
	@FindBy(xpath = "//img[@src='images/bauer-b-report.png']")
	public static WebElement logo;
	
	@FindBy(xpath = "//a[contains(text(),'File Records')]")
	public static WebElement header;
	
	@FindBy(xpath = "//div[@class='footer panel-footer copyright']//p[1]")
	public static WebElement footer;
	
	//Select machine & date
	@FindBy(xpath = "//label[contains(text(),'Select Machine:')]")
	public static WebElement sm_lable;
	
	@FindBy(id="select2-selectMachine-container")
	public static WebElement sm_dropdown;
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	public static WebElement sm_month;
	
	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	public static WebElement sm_year;
	
	@FindBy(id="getFilesButton")
	public static WebElement getFiles_button;
	
	@FindBy(xpath = "(//li[contains(@role,'treeitem')])[5]")
	public static WebElement sm_dropdown_list;
	
	@FindBy(xpath= "//input[@role='textbox']")
	public static WebElement sm_dropdown_searchbox;
	
	@FindBy(xpath = "//label[contains(text(),'Begin Date:')]")
	public static WebElement startDateCalander_lable;
	
	@FindBy(xpath = "//label[contains(text(),'End Date:')]")
	public static WebElement endDateCalander_lable;
	
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']")
	public static WebElement datePicker;
	
	@FindBy(id="datePickerInputFromFiles")
	public static WebElement startDateCalander;
	
	@FindBy(id="datePickerInputToFiles")
	public static WebElement endDateCalander;
	
	@FindBy(xpath="//a[@title='Next']")
	public static WebElement cal_nextButton;
	
	@FindBy(xpath="//a[@title='Prev']")
	public static WebElement cal_prevButton;
	
	@FindBy(id="file-records_info")
	public static WebElement file_record_info;
	
	@FindBy(xpath="//td[@colspan='6']")
	public static WebElement emptyTable;
	
	
	//Toggle column buttons
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[8]/div[1]")
	public static WebElement toggleColumn;
	
	@FindBy(xpath="//a[contains(@data-column,'1')]")
	public static WebElement pile;
	
	@FindBy(xpath="//a[contains(@data-column,'2')]")
	public static WebElement startDateTime;
	
	@FindBy(xpath="//a[contains(text(),'Data Length')]")
	public static WebElement dataLength;
	
	@FindBy(xpath="//a[contains(text(),'Client')]")
	public static WebElement client;
	
	@FindBy(xpath="//a[contains(text(),'Jobsite')]")
	public static WebElement jobsite;
	
	@FindBy(xpath="//a[contains(text(),'Machine')]")
	public static WebElement machine;
	
	@FindBy(xpath= "//a[contains(text(),'Operator')]")
	public static WebElement operator;
	
		
	//Column filters
	@FindBy(className= "col-xs-8")
	public static WebElement columnFilters;
		
	@FindBy(xpath= "//th[contains(text(),'File Name')]")
	public static WebElement colFilename;
	
	@FindBy(xpath= "//th[contains(text(),'Pile no')]")
	public static WebElement colPileno;
	
	@FindBy(xpath= "//th[contains(text(),'Start Date Time')]")
	public static WebElement colStartDateTime;
	
	@FindBy(xpath= "//th[contains(text(),'Jobsite')]")
	public static WebElement colJobsite;
	
	@FindBy(xpath= "//th[contains(text(),'Operator')]")
	public static WebElement colOperator;
	
	@FindBy(xpath= "//th[contains(text(),'Action')]")
	public static WebElement colAction;
	
	@FindBy(xpath= "//th[contains(text(),'Data Length')]")
	public static WebElement colDatalength;
	
	@FindBy(xpath= "//th[contains(text(),'Machine')]")
	public static WebElement colMachine;
	
	@FindBy(xpath= "//th[contains(text(),'Client')]")
	public static WebElement colClient;
	
	
	//Table
	@FindBy(xpath= "//table[@id='file-records']")
	public static WebElement fileRecordsTable;
		
	@FindBy(xpath = "//tr[@class='odd']")
	public static WebElement row_odd;
	
	@FindBy(xpath = "//tr[@class='even']")
	public static WebElement row_even;
	
	
	//Button group
	@FindBy(xpath = "//div[@class='DTTT btn-group']")
	public static WebElement buttons;
	
	@FindBy(id= "ToolTables_file-records_0")
	public static WebElement saveButton;
	
	@FindBy(id= "ToolTables_file-records_1")
	public static WebElement excelButton;
	
	@FindBy(id= "ToolTables_file-records_2")
	public static WebElement selectallButton;
	
	@FindBy(id= "ToolTables_file-records_3")
	public static WebElement selectnoneButton;
	
	@FindBy(id= "ToolTables_file-records_4")
	public static WebElement deleteButton;
	
	@FindBy(id= "ToolTables_file-records_5")
	public static WebElement printButton;
	
	@FindBy(css ="#ToolTables_file-records_6")
	public static WebElement transferToReport;;
	
	@FindBy(id= "ToolTables_file-records_7")
	public static WebElement mergeButton;
	
	@FindBy(id= "ToolTables_file-records_8")
	public static WebElement exportToIFCButton;
	
	@FindBy(id= "ToolTables_file-records_9")
	public static WebElement filterbyButton;

//	@FindBy(id= "file-records_filter")
//	public static WebElement searchBox;
	
	@FindBy(className = "input-group-sm")
	public static WebElement getactionIcons;
	
	
	
	@FindBy(xpath = "//div[@class='bootbox-body']")
	public static WebElement dialog_title;
	
	@FindBy(xpath ="//button[@class='bootbox-close-button close']")
	public static WebElement dialog_closeButton;
	
	@FindBy(xpath ="//button[contains(text(),'OK')]")
	public static WebElement dialog_okButton;
	
	@FindBy(xpath ="//button[@class='btn btn-default'][contains(text(),'Cancel')]")
	public static WebElement dialog_cancelButton;
	
	
	//Pagination
	@FindBy(id ="file-records_paginate")
	public static WebElement pagination;
	
	@FindBy(partialLinkText = "Next")
	public static WebElement paginate_nextButton;
	
	@FindBy(partialLinkText = "Previous")
	public static WebElement paginate_preButton;
	
	@FindBy(name = "file-records_length")
	public static WebElement filerecords_dropdown;
	
	
	//Search
	@FindBy(xpath="//input[@type='search']")
	public static WebElement searchBox;
	
	
	//Print record
	@FindBy(xpath ="//h4[contains(text(),'Print Preview settings')]")
	public static WebElement print_title;
	
	@FindBy(className ="close")
	public static WebElement print_closeButton;
	
	@FindBy(xpath= "//label[contains(text(),'Select type of diagrams :')]")
	public static WebElement print_dropdownLable;
	
	@FindBy(id="diagramType")
	public static WebElement print_dropdown;
	
	@FindBy(id="confirmPrintConfig")
	public static WebElement print_button;
	
	@FindBy(xpath = "//div[@id='printPreviewModal']//button[@class='close']")
	public static WebElement print_close;
	
	@FindBy(id = "widgetHeading")
	public static WebElement printPreview_heading;
	
	@FindBy(id = "exportDiagram")
	public static WebElement printPreview_export;
	
	@FindBy(xpath = "//a[contains(text(),'PRINT')]")
	public static WebElement printPage;
	
	
	//Merge files
	@FindBy(xpath = "//h4[contains(text(),'File Merge Confirmation')]")
	public static WebElement merge_dialoge_title;
	
	@FindBy(xpath = "//p[contains(text(),'Are you sure you wish to merge the selected files?')]")
	public static WebElement merge_dialoge_message;
	
	@FindBy(xpath = "//button[@id='mergeYes']")
	public static WebElement mergeYes_button;
	
	@FindBy(xpath = "//button[@id='mergeNo']")
	public static WebElement mergeNo_button;
	
	
	//Export to IFC
	@FindBy(xpath = "//h4[contains(text(),'Export to IFC confirmation')]")
	public static WebElement export_dialoge_title;
	
	@FindBy(xpath = "//p[contains(text(),'Do you wish to export the selected files to IFC?')]")
	public static WebElement export_dialoge_message;
	
	@FindBy(id = "exportToIFCYes")
	public static WebElement exportYes_button;
	
	@FindBy(id = "exportToIFCNo")
	public static WebElement exportNo_button;
}
