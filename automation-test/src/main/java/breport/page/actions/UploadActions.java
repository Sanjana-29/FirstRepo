package breport.page.actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import breport.config.CommonActions;
import breport.data.TestData;
import breport.objects.NavigationObjects;
import breport.objects.RecordsObjects;
import breport.objects.UploadObjects;
import junit.framework.Assert;

public class UploadActions extends CommonActions {

	public static void uploadFileWithRobot(String string) throws AWTException, InterruptedException {
		//StringSelection is a class that can be used for copy and paste operations.
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(2000);  
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);  
		
	}

	public static void uploadFile() throws InterruptedException, AWTException {
		click(NavigationObjects.upload_menu);
		Thread.sleep(2000);
		verifyTexts(UploadObjects.upload_title,"Upload Files", "Title is present");
		verifyElement(UploadObjects.upload_addFiles, "Add files button is present");
		verifyElement(UploadObjects.upload_startUpload, "Start upload button is present");
		verifyElement(UploadObjects.upload_delete, "Delete button is present");
		
//		click(breport.objects.UploadObjects.upload_addFiles);
//		switchTab(1);
//		breport.objects.UploadObjects.upload_addFiles.sendKeys("D:\\Data\\Downloads\\TestFileUpload");
		
		click(UploadObjects.upload_addFiles);
		uploadFileWithRobot(TestData.upload_file);
		
		verifyTexts(UploadObjects.upload_fileName, "TestFileUpload.dat", "Uploade filename verified");
		verifyElement(UploadObjects.upload_startButton, "Start button is present");
		verifyElement(UploadObjects.upload_cancelButton, "Cancel button is present");
		verifyElement(UploadObjects.upload_close_cancelButton, "Close/Cancel button is present");

		click(UploadObjects.upload_startButton);
		Thread.sleep(3000);
		verifyElement(UploadObjects.upload_success, "Success lable is present");
//		verifyTexts(UploadObjects.upload_success_message, "Success File Uploaded Successfully", "Success message verified");
//		click(UploadObjects.upload_close_cancelButton);
		
	}

	public static void uploadFile_duplicate() throws InterruptedException, AWTException {
		click(UploadObjects.upload_addFiles);
		uploadFileWithRobot(TestData.upload_file);
		Thread.sleep(3000);
		click(breport.objects.UploadObjects.upload_startButton);
		verifyElement(breport.objects.UploadObjects.upload_error, "Failure lable present");
//		verifyTexts(UploadObjects.upload_failure_message, "File Exists On Server", "Failure message verified");
		verifyElement(UploadObjects.upload_failure_cancelButton, "Cancel button is present");
		click(UploadObjects.upload_close_cancelButton);
		
//		Assert.assertEquals(driver.findElement(By.xpath("//table[@id='file-records']/tbody/tr[1]/td[1]")).getText(), "TestFileUpload.dat");
	}
	
	public static void deleteUploadedFile() throws InterruptedException {
		sendKeys(RecordsObjects.searchBox, "TestFileUpload");
		click(driver.findElement(By.xpath("//tr[@class='odd']//span[4]//button[1]")));
		click(RecordsObjects.dialog_okButton);
		Thread.sleep(2000);
		verifyTexts(RecordsObjects.dialog_title, "File is successfully deleted", "Delete file success message verified");
		click(RecordsObjects.dialog_okButton);
	}
	
}
