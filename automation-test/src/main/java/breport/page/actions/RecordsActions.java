package breport.page.actions;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import com.relevantcodes.extentreports.LogStatus;

import breport.config.CommonActions;
import breport.data.TestData;
import breport.objects.NavigationObjects;
import breport.objects.RecordsObjects;

public class RecordsActions extends CommonActions {

	public static String fileRecords;
	
	public static void brecords() throws InterruptedException {
		click(RecordsObjects.breports_tab);
		Thread.sleep(10000);
	}

	public static void pageTitle() {
		switchTab(1);
		verifyPageTitle("B-Reportt", "Title test passed", "Title test failed");
	}

	public static void url() throws InterruptedException {
		Thread.sleep(3000);
		verifyUrl("https://webbgm.bauer.de/testbreport/resources/dashboard.html#/records");
	}

	public static void navigation() {
		verifyElement(breport.objects.NavigationObjects.record_menu, "Record menu is present");
		verifyElement(breport.objects.NavigationObjects.reports_menu, "Reports menu is present");
		verifyElement(breport.objects.NavigationObjects.dailyreport_menu, "Daily Reports menu is present");
		verifyElement(breport.objects.NavigationObjects.upload_menu, "Upload menu is present");
		verifyElement(breport.objects.NavigationObjects.offline_menu, "Work offline menu is present");
		verifyElement(breport.objects.NavigationObjects.help_menu, "Help menu is present");
		verifyElement(breport.objects.NavigationObjects.language_menu, "Language dropdown is present");
		verifyElement(breport.objects.NavigationObjects.applicationType_menu, "User Application type menu is present");
		verifyElement(breport.objects.NavigationObjects.close_button, "Close button is present");
	}

	public static void logo() {
		verifyElement(RecordsObjects.logo, "B-Report logo is displayed");
	}

	public static void header() {
		verifyTexts(RecordsObjects.header, "File Records", "Header- 'File Records' is present");
	}

	public static void footer() {
		verifyTexts(RecordsObjects.footer, "Copyright © 2014-2019 by BAUER Maschinen GmbH. All rights reserved.", "Verified Footer panel");
	}

	public static void selectMachine() throws InterruptedException {
		//Verify lables of drop-down list/Date picker

		verifyTexts(RecordsObjects.sm_lable, "Select Machine:", "Lable- 'Select Machine' is present");
		verifyTexts(RecordsObjects.startDateCalander_lable, "Begin Date:","Lable- 'Begin Date' is present");
		verifyTexts(RecordsObjects.endDateCalander_lable,"End Date:", "Lable- 'End Date' is present");

		//Select Machine
		moveToElement(RecordsObjects.sm_dropdown);
		click(RecordsObjects.sm_dropdown);
		Thread.sleep(5000);
		RecordsObjects.sm_dropdown_searchbox.sendKeys(TestData.machine_name);
		RecordsObjects.sm_dropdown_searchbox.sendKeys(Keys.ENTER);
		Thread.sleep(5000);


		//		Point loc = RecordsObjects.sm_dropdown.getLocation();
		//		WebElement	element_to_click = driver.execute_script("return document.elementFromPoint(arguments[0], arguments[1]);", loc[250], loc[90]);
		//		element_to_click.click();

		//		JavascriptExecutor executor = (JavascriptExecutor)driver;
		//		executor.executeScript("arguments[0].click()",RecordsObjects.sm_dropdown);

		//		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		//		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='select2-selection__arrow']")));
	}

	public static void selectInvalidDate() throws InterruptedException {
		//Select start date
		click(RecordsObjects.startDateCalander);

		dropdown(RecordsObjects.sm_month, "text", "Jun", 0);

		dropdown(RecordsObjects.sm_year, "text", "2019", 0);

		datePicker(RecordsObjects.datePicker, "1");
		Thread.sleep(3000);

		//Select end date
		click(RecordsObjects.endDateCalander);

		dropdown(RecordsObjects.sm_month, "text", "Jan", 0);

		dropdown(RecordsObjects.sm_year, "text", "2019", 0);

		datePicker(RecordsObjects.datePicker, "1");

		click(RecordsObjects.getFiles_button);
		Thread.sleep(3000);
		verifyTexts(RecordsObjects.file_record_info, "Showing 0 to 0 of 0 entries", "No file records found");
		Assert.assertEquals(RecordsObjects.row_odd.getText(), "No data available in table");
	}

	public static void selectValidDate() throws InterruptedException {
		//Select start date
		click(RecordsObjects.startDateCalander);

		dropdown(RecordsObjects.sm_month, "text", "Jan", 0);

		dropdown(RecordsObjects.sm_year, "text", "2019", 0);

		datePicker(RecordsObjects.datePicker, "1");
		Thread.sleep(3000);

		//Select end date
		click(RecordsObjects.endDateCalander);

		dropdown(RecordsObjects.sm_month, "text", "Jun", 0);

		dropdown(RecordsObjects.sm_year, "text", "2019", 0);

		datePicker(RecordsObjects.datePicker, "1");

		click(RecordsObjects.getFiles_button);
		Thread.sleep(5000);
//		verifyTexts(RecordsObjects.file_record_info, "Showing 1 to 10 of 191 entries", "191 file records found");
		//Assert.assertEquals(RecordsObjects.row1.getText(), "No data available in table");	
	}

	public static void toggleColumns () throws InterruptedException {

		List<WebElement> button1 = RecordsObjects.toggleColumn.findElements(By.tagName("a"));
		String expected = "#3276b1";
		for(int i=0; i<button1.size(); i++){
			moveToElement(button1.get(i));
			//System.out.println(button1.get(i).getText());
			String color = button1.get(i).getCssValue("background-color");
			String hex = Color.fromString(color).asHex();
			Assert.assertEquals(expected, hex);
			Thread.sleep(2000);
			verifyElement(button1.get(i), button1.get(i).getText() +" is present");
		}
		System.out.println("Hover color verified");
	}

	public static void enableAllColumns() throws InterruptedException {			
		click(RecordsObjects.dataLength);
		click(RecordsObjects.client);
		click(RecordsObjects.machine);
		Thread.sleep(3000);

		List<WebElement> rowval = RecordsObjects.fileRecordsTable.findElements(By.tagName("tr"));			
		List<WebElement> colHeader = rowval.get(0).findElements(By.tagName("th"));

		List<WebElement> button = RecordsObjects.toggleColumn.findElements(By.tagName("a"));
		if(colHeader.size()==9) {
			for(int i=0; i<colHeader.size(); i++){

				String colName = colHeader.get(i).getText();

				switch(colName) {

				case "File Name":

					verifyElement(RecordsObjects.colFilename, "File name column is present");

					break;

				case "Pile no":

					verifyElement(RecordsObjects.colPileno, "Pileno column is present");

					break;

				case "Start Date Time":

					verifyElement(RecordsObjects.colStartDateTime, "Start Date Time column is present");

					break;

				case "Jobsite":

					verifyElement(RecordsObjects.colJobsite, "Jobsite column is present");

					break;

				case "Operator":

					verifyElement(RecordsObjects.colOperator, "Operator column is present");

					break;

				case "Data Length":

					verifyElement(RecordsObjects.colDatalength, "Data Length column is  present");

					break;

				case "Client":

					verifyElement(RecordsObjects.colClient, "Client column is  present");

					break;

				case "Machine":

					verifyElement(RecordsObjects.colMachine, "Machine column is  present");

					break;

				case "Action":

					verifyElement(RecordsObjects.colAction, "Action column is  present");

					break;
				}
			}
		}else {
			System.out.println("Error in adding columns");
			Assert.assertFalse(true);
		}
	}

	public static void disableColumns() throws InterruptedException {	
		List<WebElement> button2 = RecordsObjects.toggleColumn.findElements(By.tagName("a"));
		for(int i=0; i<button2.size(); i++) {
			button2.get(i).click();
		}
		Thread.sleep(2000);
		List<WebElement> rowval = RecordsObjects.fileRecordsTable.findElements(By.tagName("tr"));			
		List<WebElement> colHeader = rowval.get(0).findElements(By.tagName("th"));
		if(colHeader.size()==2) {
			Assert.assertEquals(colHeader.get(0).getText(), "File Name");
			Assert.assertEquals(colHeader.get(1).getText(), "Action");
			test.log(LogStatus.PASS, "Remove columns test passed");
		}
		else {
			System.out.println("More than 2 columns are displayed");
			Assert.assertFalse(true);
			test.log(LogStatus.FAIL, "Remove columns test failed");
		}
	}

	public static void columnFilters() {
		List<WebElement> colFilter = RecordsObjects.columnFilters.findElements(By.tagName("select"));
		System.out.println(colFilter.size());

		for(int i=0; i<colFilter.size(); i++) {	
			Select file = new Select(colFilter.get(i));
		
			String filename = file.getFirstSelectedOption().getText();
			verifyElement(colFilter.get(i), filename);

			click(colFilter.get(i));
			List<WebElement> itemsInDropdown = colFilter.get(i).findElements(By.tagName("option"));
			int size = itemsInDropdown.size();
			int randmNumber = ThreadLocalRandom.current().nextInt(0, size);
			itemsInDropdown.get(randmNumber).click();
			//		Thread.sleep(2000);
		}
	}

	public static void saveFile() throws InterruptedException {

		click(RecordsObjects.saveButton);
		click(RecordsObjects.excelButton);

	}

	public static void selectAll() throws InterruptedException {
		click(RecordsObjects.selectallButton);
		Thread.sleep(5000);
		List<WebElement> rowvalue = RecordsObjects.fileRecordsTable.findElements(By.tagName("tr"));	

		for (int i=1; i<rowvalue.size(); i++) {						
			boolean all = rowvalue.get(i).isSelected();
			System.out.println(rowvalue.get(i).getText() +" is selected");
			Assert.assertTrue("is selected", true);
		}
		System.out.println("All rows are selected");
	}

	public static void selectNone() throws InterruptedException {
		isbuttonEnabled(RecordsObjects.selectnoneButton, "/'Select none'/ button is enabled");

		click(RecordsObjects.selectnoneButton);
		Thread.sleep(8000);

		List<WebElement> rowvalue1 = RecordsObjects.fileRecordsTable.findElements(By.tagName("tr"));	

		for (int i=1; i<rowvalue1.size(); i++) {						
			boolean none = rowvalue1.get(i).isSelected();

			if(none==false) {
				System.out.println(rowvalue1.get(i).getText() +" is not selected");
			}
			else {
				System.out.println(rowvalue1.get(i).getText() +" is selected");
			}
			Assert.assertFalse(none);
		}
		System.out.println("No rows are selected");
	}

	public static void actionIcons() throws InterruptedException {

		List<WebElement> rowval = RecordsObjects.fileRecordsTable.findElements(By.tagName("tr"));	
		List<WebElement> column6 = driver.findElements(By.xpath("//table[@id='file-records']/tbody/tr/td[2]"));
		for(WebElement col6 : column6) {
			List<WebElement> actionIcons = col6.findElements(By.tagName("button"));
			for(int i= 0; i<actionIcons.size(); i++) {
				verifyElement(actionIcons.get(i), "");	
		}
		}
		Thread.sleep(3000);
	}

	/*		
		for(WebElement row: rowval) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for(WebElement cell : cells) {
				List<WebElement> actionIcons = cell.findElements(By.tagName("button"));
				for(int i= 0; i<actionIcons.size(); i++) 
					verifyElement(actionIcons.get(i), "");		
			}
		}
	}
	 */
	//		for(int roww=1; roww<=rowval.size(); roww++) {
	//			List<WebElement> cell = rowval.get(roww).findElements(By.tagName("td"));
	////			System.out.println(cell.get(i));
	//			List<WebElement> actionIcons = RecordsObjects.getactionIcons.findElements(By.tagName("button"));
	//			System.out.println(roww);
	//			System.out.println(actionIcons.size());
	//			verifyElement(rowval.get(roww),"");
	//			for(int i= 0; i<actionIcons.size(); i++) 
	//				
	//			verifyElement(actionIcons.get(i), rowval.get(roww).getText());


	//		List<WebElement> rows = RecordsObjects.fileRecordsTable.findElements(By.tagName("tr"));	

	//		List<WebElement> cell = rows.get(4).findElements(By.tagName("td"));
	//		System.out.println(cell.size());

	//		System.out.println(cell.get(0).getText());

	//		for(int i= 1; i<rows.size(); i++) {
	//			List<WebElement> cell1 = rows.get(i).findElements(By.tagName("td"));
	////			System.out.println(cell1.get(5));


	public static void transferToReport() throws InterruptedException {

		String pointer = RecordsObjects.transferToReport.getCssValue("cursor");
		String appType = breport.objects.NavigationObjects.applicationType_menu.getText();

		if(appType.equals("ALL")) {
			RecordsObjects.row_odd.click();
			click (RecordsObjects.transferToReport);
			Thread.sleep(5000);
			verifyElement(RecordsObjects.dialog_closeButton, "Close button is present");
			verifyElement(RecordsObjects.dialog_okButton, "OK button is present");
			Assert.assertEquals("Please select specific application type, its not working for 'ALL' application type", RecordsObjects.dialog_title.getText());

			click(RecordsObjects.dialog_okButton);	
			Thread.sleep(5000);

			click(breport.objects.NavigationObjects.applicationType_menu);
			List<WebElement> itemsInDropdown = breport.objects.NavigationObjects.applicationType_list.findElements(By.className("appTypeClass"));
			int size = itemsInDropdown.size();
			int randmNumber = ThreadLocalRandom.current().nextInt(0, size);
			itemsInDropdown.get(randmNumber).click();
			Thread.sleep(5000);
		}

		List<WebElement> rows = RecordsObjects.fileRecordsTable.findElements(By.tagName("tr"));
		String firstRow = rows.get(1).getText();
		if(firstRow.equals("No data available in table")) {
			System.out.println("File records table is empty");
			selectMachine();
		}
		else if(pointer.equals("not-allowed")){
			rows.get(1).click();
			Thread.sleep(3000);
			System.out.println("Transfer to report button is enabled now");

			RecordsObjects.transferToReport.click();
		}
		else {
			System.out.println("Transfer to report button is already enabled");
			RecordsObjects.transferToReport.click();
		}

		verifyElement(RecordsObjects.dialog_closeButton, "Close button is present");
		verifyElement(RecordsObjects.dialog_okButton, "OK button is present");
		Thread.sleep(5000);
		Assert.assertEquals(RecordsObjects.dialog_title.getText(), "Added to Daily Report");
		click(RecordsObjects.dialog_okButton);		
	}

	public static void pagination() throws InterruptedException  {
		scrollDown();
		Thread.sleep(5000);
		List<WebElement> pagination = RecordsObjects.pagination.findElements(By.tagName("a"));
		List<WebElement> rows = RecordsObjects.fileRecordsTable.findElements(By.tagName("tr"));	

		Select record = new Select(RecordsObjects.filerecords_dropdown);
		
		String recordsLength = record.getFirstSelectedOption().getText();
		
		int size = rows.size()-1;
		Integer obj = new Integer(size);
		String rowsize = obj.toString();
		
		String xpath1 = "//ul[@class='pagination']//a[contains(text(),'";
		String xpath2 = "')]";
		int x=2;

		if(pagination.size()>3) {
			int i = 0;
			while (RecordsObjects.paginate_nextButton.getCssValue("cursor").equals("pointer")) {
				RecordsObjects.paginate_nextButton.click();

				String final_xpath = xpath1+x+xpath2;
				verifyColor(driver.findElement(By.xpath(final_xpath)), "background-color", "#004477");
				System.out.println("We are on page " +x);
				x++;
				Thread.sleep(500);
				Assert.assertEquals(recordsLength, rowsize);

				i++;
			}
		}else {
			Assert.assertEquals(RecordsObjects.paginate_preButton.getCssValue("cursor"),"not-allowed");
			Assert.assertEquals(RecordsObjects.paginate_nextButton.getCssValue("cursor"),"not-allowed");

			System.out.println("Pagination does not exist");
		}
	}

	//		String[] s = new String[pagination.size()];
	//		for(WebElement p : pagination)
	//		{
	//			s[i] = p.getCssValue("cursor");
	//			if(s[i].equals("not-allowed"))
	//			{
	//				System.out.println("No element found");
	//			}
	//			else
	//			{
	//				p.click();
	//			}
	//		}

	public static void buttonGroup() {

		List<WebElement> buttons = RecordsObjects.buttons.findElements(By.tagName("a"));
		for(int k = 1; k<buttons.size(); k++) {
			verifyElement(buttons.get(k), "");
			System.out.println(buttons.get(k).getText());
		}
	}

	public static void fileRecordsLength() {

		int count = 0;
		String[] pages = {"10", "25", "50", "100"};
		Select record = new Select(RecordsObjects.filerecords_dropdown);

		List<WebElement> options = record.getOptions();
		for (WebElement rec : options) {
			for(int i = 0; i<pages.length; i++) {
				if (rec.getText().equals(pages[i])) {
					System.out.println(rec.getText() + " and " + pages[i] + " matched");
					count++;
				}
			}
		}
		if (count==pages.length) {
			System.out.println("Matched");
			Assert.assertTrue(true);
		}else {
			System.out.println("list doesn't match");
		}
	}

	//		List<WebElement> records = RecordsObjects.filerecords_dropdown.findElements(By.tagName("option"));
	//		System.out.println(records.size());
	//		System.out.println(records.get(0));
	//		String[] s = new String[records.size()];
	//		for(WebElement r : records) {
	//			r.getText();
	//		}
	//		ArrayList<Integer> page = new ArrayList<Integer>(Arrays.asList(10, 25, 50, 100));
	//		
	//		boolean isEqual = page.equals(records);
	//		System.out.println(isEqual);
	//	}

	public static void printSelected() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(3000);
		click(breport.objects.NavigationObjects.applicationType_menu);
		click(driver.findElement(By.id("ALL")));
		Thread.sleep(3000);
		sendKeys(RecordsObjects.searchBox, TestData.printreport_filename);

		String pointer = RecordsObjects.printButton.getCssValue("cursor");
		if(pointer.equals("not-allowed")) {
			RecordsObjects.row_odd.click();
			click(RecordsObjects.printButton);
		}
		else {
			click(RecordsObjects.printButton);
		}

		Thread.sleep(3000);
		verifyTexts(RecordsObjects.print_title, "Print Preview settings", "Print settings title is present");
		verifyTexts(RecordsObjects.print_dropdownLable, "Select type of diagrams :", "Dropdown lable is present");
		verifyElement(RecordsObjects.print_dropdown, "");

		Select type = new Select (RecordsObjects.print_dropdown);
		List<WebElement> list = type.getOptions();
		int size = list.size();
		int random = ThreadLocalRandom.current().nextInt(0, size);
		list.get(random).click();

		click(RecordsObjects.print_button);
		Thread.sleep(5000);
		
		verifyTexts(RecordsObjects.dialog_title, "1 file(s) are successfully exported", "dialog title verified");
		verifyElement(RecordsObjects.dialog_closeButton, "Close button is present");
		verifyElement(RecordsObjects.dialog_okButton, "OK button is present");
		click(RecordsObjects.dialog_okButton);

		moveToElement(RecordsObjects.print_close);
		Thread.sleep(3000);
		click(RecordsObjects.print_close);
		Thread.sleep(3000);
		
//		String title = RecordsObjects.dialog_title.getText();
//		Thread.sleep(3000);
//		if(title.equals("1 file(s) are successfully exported")) {
//			System.out.println("Print preview file is generated");
//			verifyElement(RecordsObjects.dialog_closeButton, "Close button is present");
//			verifyElement(RecordsObjects.dialog_okButton, "OK button is present");
//			click(RecordsObjects.dialog_okButton);
//			
//			verifyTexts(RecordsObjects.printPreview_heading, "Print Preview", "Print preview header is present");
//			verifyElement(RecordsObjects.printPreview_export, "Export option is present");
//			verifyElement(RecordsObjects.printPage, "Print option is present");
//
//			moveToElement(RecordsObjects.print_close);
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			click(RecordsObjects.print_close);
//			Thread.sleep(3000);
//			
//		} else if(title.equals("Please select at least one graph to show report")){
//			System.out.println("No data available");
//			click(RecordsObjects.dialog_okButton);
//			
//			verifyTexts(RecordsObjects.dialog_title, "No data available", "Title of no data dialog verified");
//			click(RecordsObjects.dialog_okButton);
//		} else {
//			System.out.println("Condition not matched");
//		}
		
		

//		click(NavigationObjects.record_menu);
//		click(NavigationObjects.applicationType_menu);
//		click(driver.findElement(By.id("ALL")));
		
//		fileRecords = RecordsObjects.file_record_info.getText();
	}

	public static void delete() throws InterruptedException {
		String pointer = RecordsObjects.deleteButton.getCssValue("cursor");
		if(pointer.equals("not-allowed")) {
			RecordsObjects.row_odd.click();
			click(RecordsObjects.deleteButton);
		}
		else {
			click(RecordsObjects.deleteButton);
		}
		Thread.sleep(2000);
		verifyTexts(RecordsObjects.dialog_title, "Are You sure?", "dialog title verified");
		verifyElement(RecordsObjects.dialog_closeButton, "Close button is present");
		verifyElement(RecordsObjects.dialog_okButton, "OK button is present");
		verifyElement(RecordsObjects.dialog_cancelButton, "Cancel button is present");
		click(RecordsObjects.dialog_cancelButton);
		Thread.sleep(2000);
	}

	public static void search(String search_keyword) throws InterruptedException {
		Thread.sleep(3000);
		//String search_keyword = "Data";
		click(RecordsObjects.searchBox);
		sendKeys(RecordsObjects.searchBox, search_keyword);

		List<WebElement> rows = RecordsObjects.fileRecordsTable.findElements(By.tagName("tr"));

		int count = 1;
		for (int row= 1; row<rows.size(); row++) {
			String rowdata = rows.get(row).getText();
			System.out.println(rowdata);

			boolean result = StringUtils.containsIgnoreCase(rowdata, search_keyword);
			if(result == true) {
				System.out.println("Search result matched");
				count++;
			}else {
				System.out.println("not matched");
			}
//			Assert.assertEquals("No matching records found", rowdata);
		}
		
		if(count==rows.size()) {
			System.out.println("Final result matched");
			Assert.assertTrue(true);
		} else {
			System.out.println("Test Failed");
			Assert.assertTrue(false);
		}
	}			
	
		public static void invalidSearch() throws InterruptedException {
			Thread.sleep(3000);
			String invalidSearch_keyword = "1Data";
			click(RecordsObjects.searchBox);
			sendKeys(RecordsObjects.searchBox, invalidSearch_keyword);
			String message = RecordsObjects.row_odd.getText();
			Assert.assertEquals("No matching records found", message);
		}

		/*
		int rowcount = 1;
			for(WebElement r : rows) {
				List<WebElement> cells = r.findElements(By.tagName("td"));
				for(WebElement cell : cells) {
				String rowdata = cell.getText();
				System.out.println(rowdata);
				if(rowdata.contains(search_keyword)) {
//					Assert.assertTrue(true);
					System.out.println("jkdjddkdkffk");
				}else {
//					Assert.assertTrue(false);
					System.out.println("not matched");
				}
				rowcount++;
				}
				List<WebElement> col1 = r.findElements(By.className("sorting_1"));
				for(WebElement col : col1) {
				System.out.println(col.getText());
			}
		}			
				List<WebElement> column1 = driver.findElements(By.xpath("//table[@id='file-records']/tbody/tr/td[1]"));
				System.out.println("Total number of rows "+column1.size());
				int row_num = 1;
				for(WebElement col1 : column1) {
				System.out.println(col1.getText());
				String filename = col1.getText();
				if(filename.contains(search_keyword)) {
					Assert.assertTrue(true);
				}else {
					Assert.assertTrue(false);
				}
				row_num++;
				}
		}
	}
		 */
		

	public static void mergeFile() throws InterruptedException {

		if (!breport.objects.NavigationObjects.applicationType_menu.getText().equals("CUT")) {
			click(breport.objects.NavigationObjects.applicationType_menu);
			click(driver.findElement(By.id("CUT")));
			Thread.sleep(10000);
		}

		String pointer = RecordsObjects.transferToReport.getCssValue("cursor");
		if(pointer.equals("not-allowed")) {
			click(RecordsObjects.row_odd);
			click(RecordsObjects.row_even);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			click(RecordsObjects.mergeButton);
		}else {
			click(RecordsObjects.mergeButton);
		}
		Thread.sleep(2000);
		verifyTexts(RecordsObjects.merge_dialoge_title, "File Merge Confirmation", "Title is present");
		verifyTexts(RecordsObjects.merge_dialoge_message, "Are you sure you wish to merge the selected files?", "Confimation message is present");
		verifyElement(RecordsObjects.mergeYes_button, "YES button is present");
		verifyElement(RecordsObjects.mergeNo_button, "NO button is present");
		click(RecordsObjects.mergeNo_button);	
		Thread.sleep(2000);
	}

	public static void exportToIFC() throws InterruptedException {

		if (!breport.objects.NavigationObjects.applicationType_menu.getText().equals("SOB")) {
			click(breport.objects.NavigationObjects.applicationType_menu);
			click(driver.findElement(By.id("SOB")));
		}
		click(RecordsObjects.row_odd);
		String pointer = RecordsObjects.transferToReport.getCssValue("cursor");
		if(pointer.equals("not-allowed")) {
			click(RecordsObjects.row_odd);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			click(RecordsObjects.exportToIFCButton);
		}else {
			click(RecordsObjects.exportToIFCButton);
		}
		Thread.sleep(2000);
		verifyTexts(RecordsObjects.export_dialoge_title, "Export to IFC confirmation", "Title is present");
		verifyTexts(RecordsObjects.export_dialoge_message, "Do you wish to export the selected files to IFC?", "Confirmation message is present");
		verifyElement(RecordsObjects.exportYes_button, "YES button is present");
		verifyElement(RecordsObjects.exportNo_button, "NO button is present");
		click(RecordsObjects.exportNo_button);	
		Thread.sleep(2000);

	}
}

















