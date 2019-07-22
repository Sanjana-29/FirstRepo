package breport.testcases;

import java.awt.AWTException;

import org.testng.annotations.Test;

import breport.page.actions.UploadActions;


public class UploadTestcases extends UploadActions{

	@Test(priority = 0)
	public static void verify_upload_file() throws InterruptedException, AWTException {
		uploadFile();
	}
	
	@Test(priority = 1)
	public static void verify_upload_duplicate_file() throws InterruptedException, AWTException{
		uploadFile_duplicate();
	}
	
	@Test(priority = 3)
	public static void delete_uploaded_file() throws InterruptedException {
		deleteUploadedFile();
	}
}
