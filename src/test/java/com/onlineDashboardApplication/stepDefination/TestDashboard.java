package com.onlineDashboardApplication.stepDefination;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.onlineDashboardApplication.pom.pages.Dashboard;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestDashboard {
	public static WebDriver driver;
	public Dashboard pfDashboard;;

	@After("@Dashboard")
	public void afterScenario() {
		if (driver != null) {
			driver.close();
		}
	}

	@Given("^Admin is in Dashboard Login Page$")
	public void admin_is_in_Dashboard_Login_Page() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8080/login");
		pfDashboard = PageFactory.initElements(driver, Dashboard.class);
	}

	@When("^Admin user enters valid login id password$")
	public void admin_user_enters_valid_login_id_password() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		pfDashboard.username("admin1");
		pfDashboard.password("pass1");
	}

	@And("^submit login button$")
	public void submit_login_button() throws Throwable {
		pfDashboard.login_button.click();
	}

	@Then("^Admin should be logged in into the dashboard$")
	public void admin_should_be_logged_in_into_the_dashboard() throws Throwable {
		String title = driver.findElement(By.xpath("/html/body/div/header/a/span[2]/b")).getText();
		Assert.assertEquals(title, "Dashboard");
	}

	@When("^Admin user enters invalid login id password$")
	public void admin_user_enters_invalid_login_id_password() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		pfDashboard.username("admin");
		pfDashboard.password("pass1");
	}

	@Then("^message will be displayed Invalid credentials$")
	public void message_will_be_displayed_Invalid_credentials() throws Throwable {
		String errMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/form/font")).getText();
		Assert.assertEquals(errMessage, "Invalid Credentials!");
	}

	@Given("^Admin user is in the slp report page$")
	public void admin_user_is_in_the_slp_report_page() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8080/slpList");
		pfDashboard = PageFactory.initElements(driver, Dashboard.class);

	}

	@When("^user searches for employee id  in search employee id bar$")
	public void user_searches_for_employee_id_in_search_employee_id_bar() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String val = "1";
		for (int i = 0; i < val.length(); i++) {
			char c = val.charAt(i);
			String s = new StringBuilder().append(c).toString();
			Thread.sleep(1000);
			pfDashboard.search_empid(s);
		}
	}

	@Then("^slp report shows all suitable search for that employee id$")
	public void slp_report_shows_all_suitable_search_for_that_employee_id() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> allRows = driver
				.findElements(By.xpath("/html/body/div/div/div/div/div/div/div/div[2]/div/table/tbody/tr"));
		System.out.println("No of rows" + allRows.size());
		for (WebElement row : allRows) {
			List<WebElement> cells = row
					.findElements(By.xpath("/html/body/div/div/div/div/div/div/div/div[2]/div/table/tbody/tr/td[1]"));
			for (WebElement cell : cells) {
				String emp_id = cell.getText();
				Assert.assertEquals(emp_id.contains("1"), true);

			}
		}
	}

	@When("^user searches for employee name  in search employee name bar$")
	public void user_searches_for_employee_name_in_search_employee_name_bar() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String val = "emp4";
		for (int i = 0; i < val.length(); i++) {
			char c = val.charAt(i);
			String s = new StringBuilder().append(c).toString();
			Thread.sleep(1000);
			pfDashboard.search_empname(s);
		}
	}

	@Then("^slp report shows all suitable search for that employee name$")
	public void slp_report_shows_all_suitable_search_for_that_employee_name() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> allRows = driver
				.findElements(By.xpath("/html/body/div/div/div/div/div/div/div/div[2]/div/table/tbody/tr"));
		System.out.println("No of rows" + allRows.size());
		for (WebElement row : allRows) {
			List<WebElement> cells = row
					.findElements(By.xpath("/html/body/div/div/div/div/div/div/div/div[2]/div/table/tbody/tr/td[2]"));
			for (WebElement cell : cells) {
				String emp_id = cell.getText();
				Assert.assertEquals(emp_id.contains("Emp4"), true);
			}
		}

	}

	@When("^user searches for registration date  in search registration date bar$")
	public void user_searches_for_registration_date_in_search_registration_date_bar() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String val = "28-08-2020";
		for (int i = 0; i < val.length(); i++) {
			char c = val.charAt(i);
			String s = new StringBuilder().append(c).toString();
			Thread.sleep(1000);
			pfDashboard.page_searchbox(s);
		}
	}

	@Then("^slp report shows all suitable search for that registration date$")
	public void slp_report_shows_all_suitable_search_for_that_registration_date() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		List<WebElement> allRows = driver
				.findElements(By.xpath("/html/body/div/div/div/div/div/div/div/div[2]/div/table/tbody/tr"));
		System.out.println("No of rows" + allRows.size());
		for (WebElement row : allRows) {
			List<WebElement> cells = row
					.findElements(By.xpath("/html/body/div/div/div/div/div/div/div/div[2]/div/table/tbody/tr/td[3]"));
			for (WebElement cell : cells) {
				String emp_id = cell.getText();
				Assert.assertEquals(emp_id.contains("28-08-2020"), true);
			}
		}
	}

	@When("^user searches for superviser name in search supervisor name bar$")
	public void user_searches_for_superviser_name_in_search_supervisor_name_bar() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String val = "Rohit W";
		for (int i = 0; i < val.length(); i++) {
			char c = val.charAt(i);
			String s = new StringBuilder().append(c).toString();
			Thread.sleep(1000);
			pfDashboard.search_supervisorname(s);
		}
	}

	@Then("^slp report shows all suitable search for that superviser name$")
	public void slp_report_shows_all_suitable_search_for_that_superviser_name() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		List<WebElement> allRows = driver
				.findElements(By.xpath("/html/body/div/div/div/div/div/div/div/div[2]/div/table/tbody/tr"));
		System.out.println("No of rows" + allRows.size());

		for (WebElement row : allRows) {
			List<WebElement> cells = row
					.findElements(By.xpath("/html/body/div/div/div/div/div/div/div/div[2]/div/table/tbody/tr/td[4]"));
			for (WebElement cell : cells) {
				String emp_id = cell.getText();
				Assert.assertEquals(emp_id.contains("Rohit W"), true);

			}
		}

	}

	@When("^user searches for track name in search track name bar$")
	public void user_searches_for_track_name_in_search_track_name_bar() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String val = "API automation - Rest Assured";
		for (int i = 0; i < val.length(); i++) {
			char c = val.charAt(i);
			String s = new StringBuilder().append(c).toString();
			pfDashboard.search_trackname(s);
		}
	}

	@Then("^slp report shows all suitable search for that track name$")
	public void slp_report_shows_all_suitable_search_for_that_track_name() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> allRows = driver
				.findElements(By.xpath("/html/body/div/div/div/div/div/div/div/div[2]/div/table/tbody/tr"));
		System.out.println("No of rows" + allRows.size());
		for (WebElement row : allRows) {
			List<WebElement> cells = row
					.findElements(By.xpath("/html/body/div/div/div/div/div/div/div/div[2]/div/table/tbody/tr/td[5]"));
			for (WebElement cell : cells) {
				String emp_id = cell.getText();
				Assert.assertEquals(emp_id.contains("API automation - Rest Assured"), true);
			}
		}
	}

	@When("^user searches for course  in search course bar$")
	public void user_searches_for_course_in_search_course_bar() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String val = "API,Java,Cucumber";
		for (int i = 0; i < val.length(); i++) {
			char c = val.charAt(i);
			String s = new StringBuilder().append(c).toString();
			pfDashboard.search_course(s);
		}
	}

	@Then("^slp report shows all suitable search for that course$")
	public void slp_report_shows_all_suitable_search_for_that_course() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> allRows = driver
				.findElements(By.xpath("/html/body/div/div/div/div/div/div/div/div[2]/div/table/tbody/tr"));
		System.out.println("No of rows" + allRows.size());
		for (WebElement row : allRows) {
			List<WebElement> cells = row
					.findElements(By.xpath("/html/body/div/div/div/div/div/div/div/div[2]/div/table/tbody/tr/td[6]"));
			for (WebElement cell : cells) {
				String emp_id = cell.getText();
				Assert.assertEquals(emp_id.contains("API,Java,Cucumber"), true);

			}
		}
	}

	@When("^user searches for topic completed in search topic completed bar$")
	public void user_searches_for_topic_completed_in_search_topic_completed_bar() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String val = "api";
		for (int i = 0; i < val.length(); i++) {
			char c = val.charAt(i);
			String s = new StringBuilder().append(c).toString();
			Thread.sleep(1000);
			pfDashboard.search_topiccompleted(s);

		}
	}

	@Then("^slp report shows all suitable search for that topic completed$")
	public void slp_report_shows_all_suitable_search_for_that_topic_completed() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> allRows = driver
				.findElements(By.xpath("/html/body/div/div/div/div/div/div/div/div[2]/div/table/tbody/tr"));
		System.out.println("No of rows" + allRows.size());
		for (WebElement row : allRows) {
			List<WebElement> cells = row
					.findElements(By.xpath("/html/body/div/div/div/div/div/div/div/div[2]/div/table/tbody/tr/td[7]"));
			System.out.println("No of rows found" + cells.size());
			for (WebElement cell : cells) {
				String emp_id = cell.getText();
				Assert.assertEquals(emp_id.contains("api"), true);
			}
		}

	}

	@When("^admin searches for topic completed in search topic completed bar$")
	public void admin_searches_for_topic_completed_in_search_topic_completed_bar() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String val = "UI";
		for (int i = 0; i < val.length(); i++) {
			char c = val.charAt(i);
			String s = new StringBuilder().append(c).toString();
			Thread.sleep(1000);
			pfDashboard.page_searchbox(s);
		}

	}

	@Then("^search box shows all suitable searched data$")
	public void search_box_shows_all_suitable_searched_data() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> getallrows = driver
				.findElements(By.xpath("/html/body/div/div/div/div/div/div/div/div[2]/div/table/tbody/tr"));
		for (WebElement row : getallrows) {
			System.out.println(row.getText());
			String rowcheck = row.getText();
			Assert.assertEquals(rowcheck.contains("UI"), true);

		}
	}

	@SuppressWarnings("null")
	@Then("^Match data with excel file to table$")
	public void match_data_with_excel_file_to_table() throws IOException {
		String entriesTxt = pfDashboard.Count_Entries().trim();
		String[] aEntriesText = entriesTxt.split(" ");
		String totalEntriesText = aEntriesText[aEntriesText.length - 2];
		int row = Integer.parseInt(totalEntriesText);

		File dir = new File("C:\\Users\\DELL\\Downloads");
		File lastModifiedFile = null;
		File[] files = dir.listFiles();
		if (files != null || files.length != 0) {
			lastModifiedFile = files[0];
			for (int i = 1; i < files.length; i++) {
				if (lastModifiedFile.lastModified() < files[i].lastModified()) {
					lastModifiedFile = files[i];
				}
			}
		}
		String File_Name = lastModifiedFile.toString();
		FileInputStream fis = new FileInputStream(File_Name);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int rowNum = sheet.getLastRowNum() + 1;
		rowNum = rowNum - 2;
		Assert.assertEquals(row, rowNum);

	}

	@And("^click on Export to Excel button$")
	public void click_on_export_to_excel_button() throws InterruptedException {
		// Thread.sleep(1000);
		pfDashboard.Export_Excel();
		Thread.sleep(10000);
	}

	@And("^Slp Report file is downloaded$")
	public void slp_report_file_is_downloaded() throws InterruptedException {
		Thread.sleep(1000);
		String downloadPath = "C:\\Users\\DELL\\Downloads";
		File dir = new File(downloadPath);
		boolean file = false;
		Thread.sleep(1000);
		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().equals("Dashboard  Capgemini.xlsx")) {
				file = true;
			}
		}
		Assert.assertTrue(file);
	}

	@And("^Track Report file is downloaded$")
	public void track_report_file_is_downloaded() throws InterruptedException {
		Thread.sleep(1000);
		String downloadPath = "C:\\Users\\DELL\\Downloads";
		File dir = new File(downloadPath);
		boolean file = false;
		Thread.sleep(1000);
		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().equals("Dashboard  Capgemini (1).xlsx")) {
				file = true;
			}
		}
		Assert.assertTrue(file);
	}

	@And("^Admin click on Chart link$")
	public void admin_click_on_chart_link() {
		pfDashboard.chart_Link();
	}

	@And("^click on Track Report$")
	public void click_on_track_report() {
		pfDashboard.track_Report_Link();
	}

	@And("^Admin click on People Focus week$")
	public void admin_click_on_people_focus_week() throws InterruptedException {
		Thread.sleep(1000);
		pfDashboard.people_Focus_Link();
	}

	@And("^click on Report Link under people focus week$")
	public void click_on_report_link_under_people_focus_week() throws InterruptedException {
		Thread.sleep(1000);
		pfDashboard.report_Link();
	}

	@And("^Focus People Report File is downloaded$")
	public void focus_people_report_file_is_downloaded() throws InterruptedException {
		Thread.sleep(1000);
		String downloadPath = "C:\\Users\\DELL\\Downloads";
		File dir = new File(downloadPath);
		boolean file = false;
		Thread.sleep(1000);
		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().equals("Dashboard  Capgemini (2).xlsx")) {
				file = true;
			}
		}
		Assert.assertTrue(file);
	}

	@Then("^verify Dashboard page for supervisor upload$")
	public void verify_Dashboard_page_for_supervisor_upload() throws Throwable {
		String title = driver.findElement(By.xpath("/html/body/div/header/a/span[2]/b")).getText();
		System.out.println();
		Assert.assertEquals(title, "Dashboard");

	}

	@When("^admin clicks on supervisor Page for supervisor upload$")
	public void admin_clicks_on_supervisor_Page_for_supervisor_upload() {
		pfDashboard.click_supervisorMenubar();
		pfDashboard.click_super_upload_link();
	}

	@When("^chooses the excelfile from location for supervisor upload$")
	public void chooses_the_excelfile_from_location_for_supervisor_upload() throws Throwable {
		Thread.sleep(2000);
		pfDashboard.choose_file_get("C:\\dashboard\\dashborad08092020\\supervisors.xlsx");
	}

	@When("^admin clicks on upload button for supervisor upload$")
	public void admin_clicks_on_upload_button_for_supervisor_upload() throws Throwable {
		pfDashboard.upload_click();
	}

	@Then("^file is successfully uploaded$")
	public void file_is_successfully_unploaded_for_supervisor_upload() throws Throwable {
		Assert.assertEquals("Records added successfully", pfDashboard.label_msg_get());
	}

	@Then("^Verify Data from excel file is imported in the table for supervisor upload$")
	public void verify_Data_from_excel_file_is_imported_in_the_table_for_supervisor_upload() throws Throwable {

		FileInputStream fs = new FileInputStream("C:\\dashboard\\dashborad08092020\\supervisors.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Thread.sleep(1000);
		int data = (int) sheet.getRow(1).getCell(0).getNumericCellValue();
		System.out.println(data);

		String data1 = sheet.getRow(1).getCell(1).getStringCellValue();
		System.out.println(data1);

		int cell_val = Integer.parseInt(
				driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div[3]/div/table/tbody/tr[1]/td[1]"))
						.getText());
		System.out.println(cell_val);
		Assert.assertEquals(data, cell_val);

		String cell_val1 = driver
				.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div[3]/div/table/tbody/tr[1]/td[2]"))
				.getText();
		System.out.println(cell_val1);
		Assert.assertEquals(data1, cell_val1);
	}

	@When("^admin searches for particular data for supervisor upload$")
	public void admin_searches_for_particular_data_for_supervisor_upload() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String val = "Ni";
		for (int i = 0; i < val.length(); i++) {
			char c = val.charAt(i);
			String s = new StringBuilder().append(c).toString();
			pfDashboard.supervisor_searchbox(s);
		}

	}

	@Then("^search box shows all suitable searched result for supervisor upload$")
	public void search_box_shows_all_suitable_searched_result_for_supervisor_upload() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> getallrows = driver
				.findElements(By.xpath("/html/body/div/div/div/div/div/div/div/div[2]/div/table/tbody/tr"));
		for (WebElement row : getallrows) {
			System.out.println(row.getText());
			String rowcheck = row.getText();
			Assert.assertEquals(rowcheck.contains("Ni"), true);
		}
	}

	@And("^Supervisor Data Report File is downloaded$")
	public void supervisor_data_report_file_is_downloaded() throws InterruptedException {
		Thread.sleep(1000);
		String downloadPath = "C:\\Users\\DELL\\Downloads";
		File dir = new File(downloadPath);
		boolean file = false;
		Thread.sleep(1000);
		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().equals("Dashboard  Capgemini (3).xlsx")) {
				file = true;
			}
		}
		Assert.assertTrue(file);
	}

	@Then("^verify Dashboard page$")
	public void verify_Dashboard_page() throws Throwable {
		String title = driver.findElement(By.xpath("/html/body/div/header/a/span[2]/b")).getText();
		System.out.println();
		Assert.assertEquals(title, "Dashboard");
	}

	@When("^admin clicks on Employee Page$")
	public void admin_clicks_on_Employee_Page() throws Throwable {
		pfDashboard.click_employeeMenubar();
		pfDashboard.click_employee_link();
	}

	@When("choose the excelfile from location for emp upload")
	public void choose_the_excelfile_from_location_for_emp_upload() throws Throwable {
		Thread.sleep(2000);
		pfDashboard.choose_file_get("C:\\dashboard\\dashborad08092020\\empList.xlsx");
	}

	@When("^admin clicks on upload button$")
	public void admin_clicks_on_upload_button() {
		pfDashboard.upload_click();
	}

	@Then("^Verifies the Data from excel file is imported in the table$")
	public void verify_Data_from_excel_file_is_imported_in_the_table() throws Throwable {

		FileInputStream fs = new FileInputStream("C:\\dashboard\\dashborad08092020\\empList.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);

		int data = (int) sheet.getRow(1).getCell(0).getNumericCellValue();
		System.out.println(data);

		String data1 = sheet.getRow(1).getCell(1).getStringCellValue();
		System.out.println(data1);

		int cell_val = Integer.parseInt(
				driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div[3]/div/table/tbody/tr[1]/td[1]"))
						.getText());
		System.out.println(cell_val);
		Assert.assertEquals(data, cell_val);

		String cell_val1 = driver
				.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div[3]/div/table/tbody/tr[1]/td[2]"))
				.getText();
		System.out.println(cell_val1);
		Assert.assertEquals(data1, cell_val1);
	}

	@When("^admin searches for particular data$")
	public void admin_searches_for_particular_data() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String val = "emp1";
		for (int i = 0; i < val.length(); i++) {
			char c = val.charAt(i);
			String s = new StringBuilder().append(c).toString();
			pfDashboard.super_searchbox(s);
		}

	}

	@Then("^search box shows all suitable searched result$")
	public void search_box_shows_all_suitable_searched_result() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> getallrows = driver
				.findElements(By.xpath("/html/body/div/div/div/div/div/div/div/div[2]/div/table/tbody/tr"));
		for (WebElement row : getallrows) {
			System.out.println(row.getText());
			String rowcheck = row.getText();
			Assert.assertEquals(rowcheck.contains("Emp1"), true);
		}
	}

	@And("^Employee Data Report File is downloaded$")
	public void employee_data_report_file_is_downloaded() throws Throwable {
		Thread.sleep(1000);
		String downloadPath = "C:\\Users\\DELL\\Downloads";
		File dir = new File(downloadPath);
		boolean file = false;
		Thread.sleep(1000);
		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().equals("Dashboard  Capgemini (4).xlsx")) {
				file = true;
			}
		}
		Assert.assertTrue(file);
	}
	
	
	
	
	
	
	 @Then("^Table track report matches couses values from slp report$")
	 public void Table_track_report_matches_couses_values_from_slp_report ()
	 {
		 
		 WebElement table_element = driver.findElement(By.xpath("//*[@id=\"example2\"]"));
			List<WebElement> tablerows = table_element.findElements(By.tagName("tr"));
			String s1="",s2="",s3="",s4="";
			int count=0;
			int count1=0;
			int count2=0;
			int count3=0;
			for (int i = 0; i < tablerows.size(); i++) 
			{
				List<WebElement> columnrow = tablerows.get(i).findElements(By.tagName("td"));
				for (int j = 0; j < columnrow.size(); j++) 
				{
					if (columnrow.get(j).getText().equals("UI automation - Selenium")) 
					{
						s1=s1+columnrow.get(6).getText();
						count=count+1;
						if(!columnrow.get(6).getText().equals(""))
						{
						   s1=s1+",";
						}  
					}
					if (columnrow.get(j).getText().equals("API automation - Rest Assured")) 
					{
						s2=s2+columnrow.get(6).getText();
						count1=count1+1;
						if(!columnrow.get(6).getText().equals(""))
						{
						   s2=s2+",";
						}  
					}
					if (columnrow.get(j).getText().equals("UI automation - Tosca")) 
					{
						s3=s3+columnrow.get(6).getText();
						count2=count2+1;
						if(!columnrow.get(6).getText().equals(""))
						{
						   s3=s3+",";
						}  
					}
					if (columnrow.get(j).getText().equals("Mobile automation - Appium")) 
					{
						s4=s4+columnrow.get(6).getText();
						count3=count3+1;
						if(!columnrow.get(6).getText().equals(""))
						{
						   s4=s4+",";
						}  
					}
				}
			}
			
			driver.findElement(By.xpath("//*[@id=\"example2_next\"]")).click();
			tablerows = table_element.findElements(By.tagName("tr"));
			for (int i = 0; i < tablerows.size(); i++) 
			{
				List<WebElement> columnrow = tablerows.get(i).findElements(By.tagName("td"));
				for (int j = 0; j < columnrow.size(); j++) 
				{
					if (columnrow.get(j).getText().equals("UI automation - Selenium")) 
					{
						s1=s1+columnrow.get(6).getText();
						count=count+1;
						if(!columnrow.get(6).getText().equals(""))
						{
						   s1=s1+",";
						}  
					}
					if (columnrow.get(j).getText().equals("API automation - Rest Assured")) 
					{
						s2=s2+columnrow.get(6).getText();
						count1=count1+1;
						if(!columnrow.get(6).getText().equals(""))
						{
						   s2=s2+",";
						}  
					}
					if (columnrow.get(j).getText().equals("UI automation - Tosca")) 
					{
						s3=s3+columnrow.get(6).getText();
						count2=count2+1;
						if(!columnrow.get(6).getText().equals(""))
						{
						   s3=s3+",";
						}  
					}
					if (columnrow.get(j).getText().equals("Mobile automation - Appium")) 
					{
						s4=s4+columnrow.get(6).getText();
						count3=count3+1;
						if(!columnrow.get(6).getText().equals(""))
						{
						   s4=s4+",";
						} 
					}
				}
			}
			String[] selenium = s1.split(",");
			int seleniumCount = selenium.length;
			
			String[] restassured = s2.split(",");
			int restassuredCount= restassured.length;
			
			String[] tosca = s3.split(",");
			int toscaCount = tosca.length;
			
			String[] appium = s4.split(",");
			int appiumCount = appium.length;
			
			
			pfDashboard.chart_Link();
			pfDashboard.track_Report_Link();
			
			double selenium_courses=(double) seleniumCount/count;
			double rest_courses=(double) restassuredCount/count1;
			double tosca_courses=(double) toscaCount/count2;
			double appium_courses=(double) appiumCount/count3;
			
			double percentage_selenium_courses =(selenium_courses*100)/50;
			double percentage_rest_courses =(rest_courses*100)/45;
			double percentage_appium_courses =(appium_courses*100)/43;
			double percentage_tosca_courses =(tosca_courses*100)/26;
			
			percentage_selenium_courses=Math.round(percentage_selenium_courses *100.0)/100.0;
			percentage_rest_courses=Math.round(percentage_rest_courses *100.0)/100.0;
			percentage_appium_courses=Math.round(percentage_appium_courses *100.0)/100.0;
			percentage_tosca_courses=Math.round(percentage_tosca_courses*100.0)/100.0;
			
			if(Double.compare(percentage_selenium_courses,100.00)==0)
			{
				Assert.assertEquals(percentage_selenium_courses,driver.findElement(By.xpath("//*[@id=\"example2\"]/tbody/tr[3]/td[2]")).getText());
			}
			else
			{
				Assert.assertEquals(Double.toString(percentage_selenium_courses),driver.findElement(By.xpath("//*[@id=\"example2\"]/tbody/tr[3]/td[3]")).getText());
				percentage_selenium_courses=100-percentage_selenium_courses;
				Assert.assertEquals(Double.toString(percentage_selenium_courses),driver.findElement(By.xpath("//*[@id=\"example2\"]/tbody/tr[3]/td[4]")).getText());
			}
			if(Double.compare(percentage_rest_courses,100.00)==0)
			{
				Assert.assertEquals(Double.toString(percentage_rest_courses),driver.findElement(By.xpath("//*[@id=\"example2\"]/tbody/tr[1]/td[2]")).getText());
			}
			else
			{
				Assert.assertEquals(Double.toString(percentage_rest_courses),driver.findElement(By.xpath("//*[@id=\"example2\"]/tbody/tr[1]/td[3]")).getText());
				percentage_rest_courses=100-percentage_rest_courses;
				Assert.assertEquals(Double.toString(percentage_rest_courses),driver.findElement(By.xpath("//*[@id=\"example2\"]/tbody/tr[1]/td[4]")).getText());			
			}
			double b=percentage_appium_courses;
			System.out.println(percentage_appium_courses);
			if(Double.compare(percentage_appium_courses,b)== 0)
			{
				Assert.assertEquals(Double.toString(percentage_appium_courses),driver.findElement(By.xpath("//*[@id=\"example2\"]/tbody/tr[2]/td[2]")).getText());
				
			}
			else
			{
				Assert.assertEquals(Double.toString(percentage_appium_courses),driver.findElement(By.xpath("//*[@id=\"example2\"]/tbody/tr[2]/td[3]")).getText());
				percentage_appium_courses=100-percentage_appium_courses;
				Assert.assertEquals(Double.toString(percentage_appium_courses),driver.findElement(By.xpath("//*[@id=\"example2\"]/tbody/tr[2]/td[4]")).getText());
			}
			if(Double.compare(percentage_tosca_courses,100.00)==0)
			{
				Assert.assertEquals(Double.toString(percentage_appium_courses),driver.findElement(By.xpath("//*[@id=\"example2\"]/tbody/tr[4]/td[2]")).getText());
			}
			else
			{	
				Assert.assertEquals(Double.toString(percentage_tosca_courses),driver.findElement(By.xpath("//*[@id=\"example2\"]/tbody/tr[4]/td[3]")).getText());
				percentage_tosca_courses=100-percentage_tosca_courses;
				Assert.assertEquals(Double.toString(percentage_tosca_courses),driver.findElement(By.xpath("//*[@id=\"example2\"]/tbody/tr[4]/td[4]")).getText());
			}
	 }
	 
	 
	    @Then("^Check data are reflect on dashboard that have register on registration page$")
	    public void check_data_are_reflect_on_dashboard_that_have_register_on_registration_page() throws Throwable 
	    {
	    	WebElement table_element = driver.findElement(By.xpath("//*[@id=\"example2\"]"));
			List<WebElement> tablerows = table_element.findElements(By.tagName("tr"));
			for (int i = 0; i < tablerows.size(); i++) {
				List<WebElement> columnrow = tablerows.get(i).findElements(By.tagName("td"));
				for (int j = 0; j < columnrow.size(); j++) {
					if (columnrow.get(0).getText().equals("13")) {
						Assert.assertEquals(columnrow.get(1).getText(), "Emp13");
						Assert.assertEquals(columnrow.get(2).getText(), "11-09-2020");
						Assert.assertEquals(columnrow.get(3).getText(), "Sujay Rahane");
						Assert.assertEquals(columnrow.get(4).getText(), "UI automation - Selenium");
						Assert.assertEquals(columnrow.get(5).getText(), "Selenium,Java,Cucumber");
					}
				}
			}
	    	
	    }
	 
	 
	 
	 
	 
	 
}