package breport.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UploadObjects {

	@FindBy(xpath = "//b[contains(text(),'Upload Files')]")
	public static WebElement upload_title;
	
	@FindBy (xpath = "//div[@class='col-lg-12']//span[@class='btn btn-success fileinput-button']")
	public static WebElement upload_addFiles;
	
	@FindBy (xpath = "//span[contains(text(),'Start Upload')]")
	public static WebElement upload_startUpload;
	
	@FindBy (xpath = "//button[@class='btn btn-danger delete']")
	public static WebElement upload_delete;
	
	@FindBy (xpath = "//button[@class='close'][contains(text(),'×')]")
	public static WebElement upload_close;
	
	@FindBy (xpath = "//p[@class='name']")
	public static WebElement upload_fileName;
	
	@FindBy (xpath = "//td[@class='uploadBtns']//span[contains(text(),'Start')]")
	public static WebElement upload_startButton;
	
	@FindBy (xpath = "//td[@class='uploadBtns']//span[contains(text(),'Cancel')]")
	public static WebElement upload_cancelButton;
	
	@FindBy(xpath = "//button[@type='button'][contains(.,'Close / Cancel')]")
	public static WebElement upload_close_cancelButton;
	
	@FindBy(xpath = "(//div[contains(@class,'progress progress-striped active')])[2]")
	public static WebElement upload_progress;
	
	@FindBy(xpath = "//span[@class='label label-success']")
	public static WebElement upload_success;
	
	@FindBy(xpath = "//div[@data-type='DELETE']")
	public static WebElement upload_success_deleteButton;
	
	@FindBy(xpath = "//div[contains(text(),'File Uploaded Successfully')]")
	public static WebElement upload_success_message;
	
	@FindBy(xpath = "//span[@class='label label-danger'][contains(.,'Error')]")
	public static WebElement upload_error;
	
	@FindBy(xpath = "//td[@class='controlBtns']//span[contains(text(),'Cancel')]")
	public static WebElement upload_failure_cancelButton; 
	
	@FindBy(xpath = "//div[@xpath='1'][contains(.,'Error File Exists On Server')]")
	public static WebElement upload_failure_message;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	public static WebElement upload_checkbox;
	
}

