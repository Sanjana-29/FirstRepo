package breport.page.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import breport.config.CommonActions;
import breport.objects.ReportsObjects;
import breport.objects.RecordsObjects;

public class ReportsActions extends CommonActions {

	public static void goToReports() {
		click(breport.objects.NavigationObjects.reports_menu);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void reportsUrl() {
		verifyUrl("https://webbgm.bauer.de/testbreport/resources/dashboard.html#/");
	}

	public static void filterByPileNo(String filterText) throws Exception {
		verifyElement(ReportsObjects.filter, "Filter is present");
		verifyTexts(ReportsObjects.filelist_title, "File List", "File table header present");
		//		Assert.assertEquals(ReportsObjects.fileTable_info.getText(), RecordsActions.fileRecords);
		//		RecordsActions.pagination();

		click(ReportsObjects.filter);

		sendKeys(ReportsObjects.filter_pileno, filterText);

		List<WebElement> table = ReportsObjects.fileTable.findElements(By.tagName("tr"));
		int count = 1;
		for (int row= 1; row<table.size(); row++) {
			String rowdata = table.get(row).getText();
			System.out.println(rowdata);

			boolean result = StringUtils.containsIgnoreCase(rowdata, filterText);
			if(result == true) {
				System.out.println("Filter result matched");
				count++;
			}else {
				Assert.assertEquals(rowdata, "No matching records found");
				System.out.println("No records found");
			}
		}	
	}

	public static void filterByDate() throws Exception {
		Thread.sleep(1000);

		click(ReportsObjects.filter);
		click(ReportsObjects.filter_daterange);
		List<WebElement> range = ReportsObjects.daterange_list.findElements(By.tagName("li"));
		for(int date=1; date<range.size(); date++) {
			System.out.println(range.get(date).getText());
		}
		range.get(0).click();
		String dt = getDate("today");
		System.out.println(dt+" - "+ dt);
		Assert.assertEquals(ReportsObjects.filter_daterange.getText(), (dt+" - "+ dt));

		click(ReportsObjects.filter_daterange);
		range.get(1).click();
		String yesterday = getDate("yesterday");
		Assert.assertEquals(ReportsObjects.filter_daterange.getText(), (yesterday+" - "+ yesterday));

		click(ReportsObjects.filter_daterange);
		range.get(2).click();
		String sday = getDate("7Days");
		System.out.println(sday);
		Assert.assertEquals(ReportsObjects.filter_daterange.getText(), (sday+" - "+ dt));

		click(ReportsObjects.filter_daterange);
		range.get(3).click();
		String tday = getDate("30Days");
		System.out.println(tday);
		Assert.assertEquals(ReportsObjects.filter_daterange.getText(), (tday+" - "+ dt));

		Thread.sleep(3000);
		click(ReportsObjects.filter_reset);

		//			click(ReportsObjects.filter_daterange);
		//			range.get(7).click();
		//			
		//			while(ReportsObjects.leftCalendar_header.getText().equals("Jan 2019")) {
		//				ReportsObjects.leftCalendar_next.click();
		//				System.out.println("Pagination verified");
		//			}

	}


	public static void reportHeader() throws InterruptedException {

		verifyElement(ReportsObjects.report_header, "Report header is present");

		click(ReportsObjects.edit_reportHeader);
		sendKeys(ReportsObjects.editHeader_textbox, "");
		click(ReportsObjects.editHeader_submitButton);
		verifyTexts(ReportsObjects.header_errorMessage, "This field is required", "Error message verified");

		sendKeys(ReportsObjects.editHeader_textbox, "This is new report header");
		click(ReportsObjects.editHeader_cancelButton);

		//		Thread.sleep(5000);
		//		click(ReportsObjects.edit_reportHeader);
		//		sendKeys(ReportsObjects.editPopup_textbox, "RSV REPORT");
		//		click(ReportsObjects.Popup_submitButton);

		//		verifyTexts(ReportsObjects.report_header, "CUT Report", "Report header edited");
	}

	public static void printReport() throws InterruptedException {
		verifyElement(ReportsObjects.print_report, "Print icon is present");
		ReportsObjects.print_report.click();
		Thread.sleep(1000);
		verifyTexts(RecordsObjects.printPreview_heading, "Print Preview", "Print preview header is present");
		verifyElement(RecordsObjects.printPreview_export, "Export option is present");
		verifyElement(RecordsObjects.printPage, "Print option is present");

		//		String reportHeading =ReportsObjects.reportHeading.getText();
		//		String header = ReportsObjects.report_header.getText();

		//		Assert.assertEquals(header, reportHeading);
		moveToElement(RecordsObjects.print_close);
		//		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		click(RecordsObjects.print_close);
		Thread.sleep(5000);
	}

	public static void comments() throws InterruptedException {
		verifyElement(ReportsObjects.comments, "Comments icon is present");
		click(ReportsObjects.comments);
		Thread.sleep(4000);
		sendKeys(ReportsObjects.comments_textbox, "This is test comment");
		click(ReportsObjects.editHeader_submitButton);
	}

	public static void reportsSettings_timeChart() throws InterruptedException {
		verifyElement(ReportsObjects.settings, "Settings button is present");
		click(ReportsObjects.settings);
		Thread.sleep(2000);
		//Reports Setting

		String[] tab = {"Time Chart", "Depth Chart", "Report Parameters", "Header/Footer", "Language"};
		List<WebElement> settingsTabs = ReportsObjects.settingsTab.findElements(By.tagName("li"));
		for (WebElement tabs : settingsTabs) {
			for(int i = 0; i<tab.length; i++) {
				if(tabs.getText().equals(tab[i])) {

					System.out.println("tabs:" + tabs.getText());
					Assert.assertTrue(true);
					System.out.println(tab[i] + " is present");
				}
			}
		}

		//Verify Autoscale setting
		click(settingsTabs.get(0));
		driver.findElement(By.xpath("//tr[1]//td[6]//button[1]")).click();
		boolean isChecked = ReportsObjects.timeAutoScale_checkbox.isSelected();
		Thread.sleep(2000);
		click(ReportsObjects.autoScale_closeButton);
		Thread.sleep(2000);

		WebElement scaleButton = driver.findElement(By.xpath("//tr[1]//td[6]//button[1]"));

		if(isChecked == true) {

			verifyColor(scaleButton, "background-color", "#5cb85c");
			System.out.println("Autoscale is enabled");

			click(scaleButton);
			click(ReportsObjects.timeAutoScale_checkbox);
			click(ReportsObjects.autoScale_saveButton);
			Thread.sleep(2000);
			System.out.println("Autoscale is now disabled");
			WebElement scaleButton1 = driver.findElement(By.xpath("//tr[1]//td[6]//button[1]"));
			verifyColor(scaleButton1, "background-color", "#004477");			

		} else {

			verifyColor(scaleButton, "background-color", "#004477");
			System.out.println("Autoscale is disabled");

			click(scaleButton);
			click(ReportsObjects.timeAutoScale_checkbox);
			click(ReportsObjects.autoScale_saveButton);

			System.out.println("Autoscale is now enabled");
			Thread.sleep(2000);
			WebElement scaleButton1 = driver.findElement(By.xpath("//tr[1]//td[6]//button[1]"));
			verifyColor(scaleButton1, "background-color", "#5cb85c");
		}	

		//Get the Time series chart titles
		Thread.sleep(3000);

		boolean checked = ReportsObjects.timechart_checkbox.isSelected(); // Get the checkbox status
		String channelName = ReportsObjects.timeChannelName.getText();  // Get channel name of first row
		
		sendKeys(ReportsObjects.timechart_graphPosition, "0");  // Set Grapgh poition
		
		sendKeys(ReportsObjects.timechart_factor, randomNumber(100));  //Send random value for Factor in timechart
		String factorSetting = ReportsObjects.timechart_factor.getText();

		Thread.sleep(4000);
		
		//Select random color from dropdown in timechart
		List<WebElement> colorsInDropdown = ReportsObjects.timechart_color.findElements(By.tagName("option"));
		int size = colorsInDropdown.size();
		Thread.sleep(4000);
		int randmNumber = ThreadLocalRandom.current().nextInt(0, size);
		colorsInDropdown.get(randmNumber).click();

		Select graphColor = new Select(ReportsObjects.timechart_color);
		WebElement selectedOption = graphColor.getFirstSelectedOption();
		String color = selectedOption.getText();		
		System.out.println(color);

		//Save the settings
		click(ReportsObjects.saveReportSetting);
		Thread.sleep(4000);
		click(ReportsObjects.timeTab);
		String 	timeTitle = ReportsObjects.timeChart_graphTitle.getText();
		boolean match = timeTitle.contains(channelName);
		
//		List<WebElement> timeChartList = ReportsObjects.timeChart_graphTitle;
//		List<String> timeTitles = new ArrayList<>();
//		for(int i = 0; i<timeChartList.size(); i++) {
//			timeTitles.add(timeChartList.get(i).getText());
//			System.out.println(timeChartList.get(i).getText());
//		}

		//Verify graph 
		
		if(checked == true) {

			System.out.println("checkbox is selected ");

			if(match== true) {
				System.out.println("Graph is present");
				Assert.assertTrue(true);
			}else {
				System.out.println("Graph is not present");
				Assert.assertTrue(false);
			}
		}
		else {
			System.out.println("checkbox is not selected");
			click(ReportsObjects.timechart_checkbox);
			click(ReportsObjects.saveReportSetting);
			Thread.sleep(5000);

			WebElement timeGraph = driver.findElement(By.xpath("(//div[@class='legendLabel'])[1]"));
			String graphLable = timeGraph.getText();
			System.out.println("graphtitle:" +graphLable);
			System.out.println("cahnneltitle" +channelName);
			if(graphLable.contains(channelName)) {
				System.out.println("Graph is added");
				click(ReportsObjects.settings);
			}else {
				System.out.println("Error! Failed to add graph");
				Assert.assertTrue(false);
			}
		}

		//Verify Factor in timechart
		if(timeTitle.contains(factorSetting)) {
			System.out.println("Graph factor values matched");
		}else {
			System.out.println("Factor values did not match");
			Assert.assertTrue(false);
		}

		//Verify color in timechart
		String timeColorBox = ReportsObjects.timechart_colorbox.getAttribute("data-color");
		System.out.println(timeColorBox);

		boolean result = StringUtils.containsIgnoreCase(color, timeColorBox);
		if(result == true){
			System.out.println("Graph color matched");
		} else {
			System.out.println("Graph color not matched");
			Assert.assertTrue(false);
		}
	}

	//		boolean allChecked = ReportsObjects.checkbox.isSelected();

	/*
	 * String xpath1 = "//input[@id='visible";
		String xpath2 = "']";
		int num = 501;

		int j=0 ;
		for (int i = 1; i<timeChart.size()-3; i++) {
			String final_xpath1 = xpath1+num+xpath2;
			WebElement checkbox1 = driver.findElement(By.xpath(final_xpath1));

			boolean checked1 = checkbox.isSelected();
			List<WebElement> para = driver.findElements(By.xpath("//div[@id='timeChartSettingView']//tr//td[3]"));

			if(checked == true) {

				System.out.println("checkbox is selected ");
				System.out.println(para.get(j).getText());
				boolean match = titles.get(j).contains(para.get(j).getText());
				if(match== true) {
					System.out.println("Graph is present");
				}else {
					System.out.println("Graph is not present");
				}
			}
			else {
				System.out.println("checkbox is not selected");
			}
			num++;
			j++;
		}
	 */
	
	public static void reportsSettings_depthChart() throws InterruptedException {

		click(ReportsObjects.settings);
		Thread.sleep(3000);

		click(ReportsObjects.depthChart_tab);

		//Verify Autoscale setting

		driver.findElement(By.xpath("//tr[1]//td[7]//button[1]")).click();
		boolean isChecked = ReportsObjects.depthAutoScale_checkbox.isSelected();
		Thread.sleep(2000);
		click(ReportsObjects.autoScale_closeButton);
		Thread.sleep(2000);
		click(ReportsObjects.depthChart_tab);

		WebElement scaleButton = driver.findElement(By.xpath("//tr[1]//td[7]//button[1]"));

		if(isChecked == true) {

			verifyColor(scaleButton, "background-color", "#5cb85c");
			System.out.println("Autoscale is enabled");

			click(scaleButton);
			click(ReportsObjects.depthAutoScale_checkbox);
			click(ReportsObjects.autoScale_saveButton);
			Thread.sleep(2000);
			click(ReportsObjects.depthChart_tab);

			WebElement scaleButton1 = driver.findElement(By.xpath("//tr[1]//td[7]//button[1]"));
			verifyColor(scaleButton1, "background-color", "#004477");			
			System.out.println("Autoscale is now disabled");
		} else {

			verifyColor(scaleButton, "background-color", "#004477");
			System.out.println("Autoscale is disabled");

			click(scaleButton);
			click(ReportsObjects.depthAutoScale_checkbox);
			click(ReportsObjects.autoScale_saveButton);
			Thread.sleep(2000);
			click(ReportsObjects.depthChart_tab);

			WebElement scaleButton1 = driver.findElement(By.xpath("//tr[1]//td[7]//button[1]"));
			verifyColor(scaleButton1, "background-color", "#5cb85c");
			System.out.println("Autoscale is now enabled");
		}	

		//Verify graph 
		boolean checked = ReportsObjects.depthChartCheckbox.isSelected();  // Verify checkbox status
		String channelName = ReportsObjects.depthChannelName.getText();     // Get channel name from first row

		sendKeys(ReportsObjects.depthchart_graphPosition, "0");  // Set the graph position
		
		//Send random value for Factor in depthchart
		sendKeys(ReportsObjects.depthChart_factor, randomNumber(100));
		String factorSetting = ReportsObjects.depthChart_factor.getText();

		Thread.sleep(4000);
		
		//Select random color from dropdown in depthchart
		List<WebElement> colorsInDropdown = ReportsObjects.depthChart_color.findElements(By.tagName("option"));
		int size = colorsInDropdown.size();
		Thread.sleep(4000);
		int randmNumber = ThreadLocalRandom.current().nextInt(0, size);
		colorsInDropdown.get(randmNumber).click();

		Select graphColor = new Select(ReportsObjects.depthChart_color);
		WebElement selectedOption = graphColor.getFirstSelectedOption();
		String color = selectedOption.getText();		
		System.out.println(color);
		
		//Save the settings
		click(ReportsObjects.saveReportSetting);
		Thread.sleep(3000);
		click(ReportsObjects.depthTab);
		Thread.sleep(4000);
		
		String depthTitle = ReportsObjects.depthChart_graphTitle.getText();
		boolean match = depthTitle.contains(channelName);

		System.out.println("Arrray title:" +depthTitle);
		System.out.println("channelName:" + channelName);

		if(checked == true) {

			System.out.println("checkbox is selected");
			if(match == true) {
				System.out.println("Graph is present");
				Assert.assertTrue(true);
			} else {
				System.out.println("Graph is not present");
				Assert.assertTrue(false);
			}
		} else {

			System.out.println("checkbox is not selected");
			click(ReportsObjects.settings);
			Thread.sleep(2000);
//			click(ReportsObjects.depthChart_tab);
			click(ReportsObjects.depthChartCheckbox);
			click(ReportsObjects.saveReportSetting);
			Thread.sleep(3000);
			click(ReportsObjects.depthTab);
			Thread.sleep(4000);

			WebElement depthGraph1 = driver.findElement(By.xpath("(//td[@class='legendLabel'])[1]"));
			String graphLable = depthGraph1.getText();
			System.out.println("graphtitle:" +graphLable);
			System.out.println("channeltitle" +channelName);
			if(graphLable.contains(channelName)) {
				System.out.println("Graph is added");
//				click(ReportsObjects.settings);
			} else {
				System.out.println("Error! Failed to add graph");
				Assert.assertTrue(false);
			}
		}
				
		//Verify Factor in timechart
		if(depthTitle.contains(factorSetting)) {
			System.out.println("Graph factor values matched");
		}else {
			System.out.println("Factor values did not match");
			Assert.assertTrue(false);
		}

		//Verify color in timechart
		String depthColorBox = ReportsObjects.depthChart_colorbox.getAttribute("data-color");
		System.out.println(depthColorBox);

		boolean result = StringUtils.containsIgnoreCase(color,depthColorBox);
		if(result == true){
			System.out.println("Graph color matched");
		} else {
			System.out.println("Graph color not matched");
			Assert.assertTrue(false);
		}
	}

	public static void reportsSettings_parameters() throws InterruptedException {
		click(ReportsObjects.report_header);
		String paramName = driver.findElement(By.xpath("//table[@class = 'table']/tbody/tr[1]/td[1]")).getText();
		String paramValue = driver.findElement(By.xpath("//table[@class = 'table']/tbody/tr[1]/td[2]")).getText();
		
		click(ReportsObjects.settings);
		Thread.sleep(2000);
		click(ReportsObjects.reportsParameter_tab);
		boolean paramSetting = driver.findElement(By.xpath("//table[@class = 'table table-striped']/tbody/tr[1]/td[1]//input[@type = 'checkbox']")).isSelected();
		if (paramSetting == true) {
			System.out.println("Checkbox is selected");
			
			String channelName = driver.findElement(By.xpath("//table[@class = 'table table-striped']/tbody/tr[1]/td[2]")).getText();
			System.out.println("parameter name: " +paramName);
			System.out.println("channel name: " + channelName);
			
			Assert.assertEquals(paramName, channelName);
			
			driver.findElement(By.xpath("//table[@class = 'table table-striped']/tbody/tr[1]/td[3]")).sendKeys("Bauer");
			click(ReportsObjects.saveReportSetting);
			
		} else {
			System.out.println("Checkbox is not selected");
		}
		
	}

	public static void localeSettings() throws InterruptedException {
		click(ReportsObjects.settings);
		click(ReportsObjects.localSettings);

		int count = 0;
		String[] languages = {"Deutsch","English",""};
		List<WebElement> options = ReportsObjects.locale_selectLanguage.findElements(By.tagName("option"));

		for(WebElement locale : options) {
			for(int i= 0; i<languages.length; i++) {
				if(locale.getText().equals(languages[i])) {
					System.out.println(locale.getText() + " and " + languages[i] + " matched");
					Assert.assertEquals(locale.getText(), languages[i], "Languages matched");

					count++;
				} else {
					Assert.assertFalse(false);
				}
			}
		}

		String[] unit = {"Metric System", "Imperial System"};
		Select unit_drpdwn = new Select(ReportsObjects.locale_selectUnit);
		List<WebElement> unit_options = unit_drpdwn.getOptions();

		for(WebElement units : unit_options) {
			for(int j= 0; j<unit.length; j++) {
				if (units.getText().equals(unit[j])) {
					System.out.println(units.getText() + " and " + unit[j] + " matched");
					Assert.assertTrue(true);
					count++;
				} else {
					System.out.println(units.getText() + " and " + unit[j] + " not matched");
					Assert.assertFalse(false);
				}
			}
			Assert.assertTrue(true);
		}

		String[] separator = {",", "."};
		Select sep_drpdwn = new Select(ReportsObjects.locale_selectSeparator);
		List<WebElement> sep_options = sep_drpdwn.getOptions();

		for(WebElement sep : sep_options) {
			for(int k= 0; k<separator.length; k++) {
				if (sep.getText().equals(unit[k])) {
					System.out.println(sep.getText() + " and " + separator[k] + " matched");
					Assert.assertTrue(true);
					count++;
				} else {
					System.out.println(sep.getText() + " and " + separator[k] + " not matched");
					Assert.assertFalse(false);
				}
			}
		}

		String[] zoomAxis = {" No", " Yes"};
		Select zoom_drpdwn = new Select(ReportsObjects.locale_zoomYaxis);
		List<WebElement> zoom_options = zoom_drpdwn.getOptions();

		for(WebElement zoom : zoom_options) {
			for(int k= 0; k<separator.length; k++) {
				boolean match = zoom.getText().equals(zoomAxis[k]);
				if (match == true) {
					System.out.println(zoom.getText() + " and " + zoomAxis[k] + " matched");
					Assert.assertTrue(true);
					count++;
				} else {
					System.out.println(zoom.getText() + " and " + zoomAxis[k] + " not matched");
					Assert.assertFalse(false);
				}
			}
			//			Assert.assertTrue(true);
		}
	}

	public static void systemSettings() throws InterruptedException {
		//System settings
		click(ReportsObjects.systemSettings);
		List<WebElement> params = driver.findElements(By.xpath("//table[@id='sysSettingTable']/tbody/tr/td[1]"));
		for(WebElement par : params) {
			System.out.println(par.getText());
		}
		click(ReportsObjects.saveSystemSettings);
		Thread.sleep(2000);
	}


	public static void zoom() {
		verifyTexts(ReportsObjects.zoomInfo, "Zoom Info", "Zoom is present");
		moveToElement(ReportsObjects.zoomInfo);
		String tooltip = ReportsObjects.zoomInfo.getAttribute("title");
		Assert.assertEquals(tooltip, "For zoom, drag a rectangle in diagram.");
	}
}
