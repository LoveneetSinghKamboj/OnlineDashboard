package com.onlineDashboardApplication.stepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.onlineDashboardApplication.pom.pages.PeopleFocus;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestPeopleFocus {

	public static WebDriver driver;
	public PeopleFocus pfPeople;

	@After("@PeopleFocusUI")
	public void afterScenario() {
		if (driver != null) {
			driver.close();
		}
	}

	@Given("^user is in the People Focus Week form$")
	public void user_is_in_the_People_Focus_Week_form() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		pfPeople = PageFactory.initElements(driver, PeopleFocus.class);
		driver.get("http://localhost:8080/pfw");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^user enters a correct employee id$")
	public void user_enters_correct_employeeId() {
		pfPeople.empID("13");
	}

	@When("^user enters another correct employee id$")
	public void user_enters_another_correct_employeeId() {
		pfPeople.empID("14");
	}

	@When("^user selects designation dropdown,supervisor dropdown,f2fdone dropdown,f2f date$")
	public void user_select_designation_dropdown_supervisor_dropdown_f2fdone_dropdown_f2f_date()
			throws InterruptedException {
		pfPeople.Designation("Consultant");
		pfPeople.Supervisor("Rohit W");
		pfPeople.F2FDone("Yes");
		WebElement date = driver
				.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/form/div[1]/div[2]/div[2]/input"));
		date.sendKeys("08/09/2020");

	}

	@When("^user enters issues,appreciation,escalation,remarks$")
	public void user_enters_issues_appreciation_escalation_remarks() {
		pfPeople.Issues("Appreciation");
		pfPeople.Appreciation("Good Content");
		pfPeople.Escalation("escalation content");
		pfPeople.Remarks("Nice Work");
	}

	@When("^user clicks on the register button$")
	public void user_clicks_on_register_button() {
		pfPeople.ClickRegister();
	}

	@Then("^user is registered and confirmation page opens displaying message \"([^\"]*)\"$")
	public void user_is_registered_and_confirmation_page_opens_displaying_message(String arg1) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String display = pfPeople.MessageDisplay();
		System.out.println(display);
		Assert.assertEquals("Thank You", display);
	}

	@When("^user selects designation dropdown,supervisor dropdown$")
	public void user_selects_designation_dropdown_supervisor_dropdown() {
		pfPeople.Designation("Consultant");
		pfPeople.Supervisor("Nilesh Y");
	}

	@When("^user selects f2fdone as No$")
	public void user_selects_f2fdone_as_No() {
		pfPeople.F2FDone("No");
	}

	@Then("^Alert popups message shows \"([^\"]*)\"$")
	public void error_alert_popups_message_shows(String value) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.alertIsPresent());
		String alert2 = driver.switchTo().alert().getText();
		System.out.println(alert2);
		Assert.assertEquals(
				"Please try to create your profile after 6 months from your registration date as this employee Id is already registered !",
				alert2);
		driver.switchTo().alert().accept();
	}

	@When("^user enters a correct employee id\\[(\\d+)\\]$")
	public void user_enters_a_correct_employee_id(int arg1) throws Throwable {
		pfPeople.empID("15");
	}

		@Then("^alert message showing \"([^\"]*)\"$")
		public void alert_message_showing_desn(String strg1)
		{
			String	alertMessage= driver.switchTo().alert().getText();
			System.out.println(alertMessage);
			Assert.assertEquals("Please select designation !",alertMessage);
		    driver.switchTo().alert().accept();
		
		}
		
		@When("^user selects only designation$")
		public void user_selects_only_designation()
		{
			pfPeople.Designation("Consultant");
		}
		
		@When("^user selects only supervisor$")
		public void user_selects_only_supervisor()
		{
		  pfPeople.Supervisor("Nilesh Y");
		}
		
		@When("^user selects only F2F done$")
		public void user_selects_only_F2F_done()
		{
			pfPeople.F2FDone("Yes");
		}
		
		@Then("^alert message popups \"([^\"]*)\"$")
		public void alert_message_popups(String arg1) throws Throwable {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.alertIsPresent());
			String alertvalue1 = driver.switchTo().alert().getText();		
			Assert.assertEquals("Please enter valid employee Id !", alertvalue1);
			driver.switchTo().alert().accept();

		}
		
		@When("^user entering invalid employeeid$")
		public void user_entering_invalid_employeeid()
		{
			pfPeople.empID("0");
		}
		@Then("^error message showing \"([^\"]*)\"$")
		public void error_message_showing(String arg4)
		{
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.alertIsPresent());
			String alert6= driver.switchTo().alert().getText();
			System.out.println(alert6);
			Assert.assertEquals("Invalid employee Id !",alert6);
			driver.switchTo().alert().accept();
		}
		
		@When("^user enters characters as employeeID_char$")
		public void user_enters_characters_as_employeeID()
		{
			pfPeople.empID("abc"); 
		}
		
		@When("^user selects supervisor dropdown,f2fdone dropdown,f2f date$")
		public void user_selects_supervisor_dropdown_f2fdone_dropdown_f2f_date()throws InterruptedException
		{
			pfPeople.Supervisor("Nilesh Y");
			pfPeople.F2FDone("Yes");
			WebElement date = driver
					.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/form/div[1]/div[2]/div[2]/input"));
			date.sendKeys("02/09/2020");
			
		}
		
		@When("^user selects designation dropdown,f2fdone dropdown,f2f date$")
		public void user_selects_designation_dropdown_f2fdone_dropdown_f2f_date()throws InterruptedException
		{
			pfPeople.Designation("Consultant");
			pfPeople.F2FDone("Yes");
			WebElement date = driver
					.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/form/div[1]/div[2]/div[2]/input"));
			date.sendKeys("02/09/2020");
			}
		@Then("^alert popup message displaying \"([^\"]*)\"$")
		public void alert_popup_message_displaying(String arg1)
		{
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			String alert9 = driver.switchTo().alert().getText();
			Assert.assertEquals("Please select supervisor !", alert9);
			driver.switchTo().alert().accept();
		}
		@When("^user selects desigantion dropdwon,supervisor dropdown")
		public void user_selects_desigantion_dropdwon_supervisor_dropdown()
		{
			pfPeople.Designation("Consultant");
			pfPeople.Supervisor("Nilesh Y");
		}
		
		@Then("^alert message box displaying \"([^\"]*)\"$")
		public void alert_message_box_display(String arg1)
		{
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			String alert10 = driver.switchTo().alert().getText();
			Assert.assertEquals("Please select f2f Done !", alert10);
			driver.switchTo().alert().accept();
		}
		
		@When("^user selects only desigantion dropdwon,supervisor dropdown,f2f done$")
		public void user_selects_only_desigantion_dropdwon_supervisor_dropdown_f2f_done()
		{
			pfPeople.Designation("Consultant");
			pfPeople.Supervisor("Nilesh Y");
			pfPeople.F2FDone("Yes");
		}
		
		@Then("^alert popup message box displaying message as Please select f2f Date!$")
		public void alert_popup_message_box_displaying()
		{
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			String alert11 = driver.switchTo().alert().getText();
			Assert.assertEquals("Please select f2f Date !", alert11);
			driver.switchTo().alert().accept();
		}

}