package breport.testcases;

import java.awt.AWTException;

import org.testng.annotations.Test;
import breport.page.actions.RecordsActions;


public class RecordsTestcases extends RecordsActions {

	@Test (priority = 0)
	public static void click_on_breport() throws InterruptedException {
		brecords();	
	}
	
	@Test (priority = 1)
	public static void verify_pagetitle() {
		pageTitle();
	}
	
	@Test (priority = 2)
	public static void verify_breport_url() throws InterruptedException {
		url();	
	}

	@Test (priority = 3)
	public static void verify_logo() {
		logo();
	}
	
	@Test (priority = 4)
	public static void verify_navigation() {
		navigation();
	}
	
	@Test (priority = 5)
	public static void verify_header() {
		header();
	}

	@Test (priority = 6)
	public static void verify_selectmachine_dropdown() throws InterruptedException, AWTException {
		selectMachine();
	}

	@Test (priority = 7)
	public static void verify_invalid_date() throws InterruptedException {
		selectInvalidDate();
	}
	
	@Test (priority = 8)
	public static void verify_valid_date() throws InterruptedException {
		selectValidDate();
	}
	
	@Test (priority = 9)
	public static void verify_fileRecordsLength() throws InterruptedException {
		fileRecordsLength();
	}
	
	@Test (priority = 10)
	public static void verify_footer_panel() throws InterruptedException {
		footer();
	}
	
	@Test (priority = 11)
	public static void verify_pagination() throws InterruptedException {
		pagination();		
		scrollUp();
	}
		
	@Test (priority = 12)
	public static void verify_togglecolumn_buttons() throws InterruptedException {
		toggleColumns();
	}

	@Test (priority = 13)
	public static void verify_enabling_allColumns() throws InterruptedException {
		enableAllColumns();
	}
	
	@Test (priority = 14)
	public static void verify_buttonGroup() throws InterruptedException {
		buttonGroup();
	}
	
	@Test (priority = 15)
	public static void verify_columnFilters() throws InterruptedException {
		columnFilters();
	}
	
	@Test (priority = 16)
	public static void verify_disabling_AllColumns() throws InterruptedException {
		disableColumns();
	}
	
	@Test (priority = 17)
	public static void verify_ActionIcons() throws InterruptedException {
		actionIcons();
	}
	
//	@Test (priority = 16)
	public static void verify_saveFile() throws InterruptedException {
		saveFile();
	}
	
	@Test (priority = 18)
	public static void verify_selectAll() throws InterruptedException {
		selectAll();
	}
	
	@Test (priority = 19, dependsOnMethods="verify_selectAll")
	public static void verify_selectNone() throws InterruptedException {
		selectNone();
	}
	
	@Test (priority = 20)
	public static void verify_mergeFile() throws InterruptedException {
		mergeFile();
	}
	
	@Test (priority = 21)
	public static void verify_exportToIFC() throws InterruptedException {
		exportToIFC();
	}
	
	@Test (priority = 22)
	public static void verify_transferToReport() throws InterruptedException {
		transferToReport();
	}
	
	@Test (priority = 23)
	public static void verify_invalidSearch() throws InterruptedException {
		invalidSearch();
	}
	
	@Test (priority = 24)
	public static void verify_search() throws InterruptedException {
		search("data");
	}
		
	@Test (priority = 25)
	public static void verify_delete() throws InterruptedException {
		delete();
	}
	
	@Test (priority = 26)
	public static void verify_printSelected() throws InterruptedException {
		printSelected();
	}
	
}
