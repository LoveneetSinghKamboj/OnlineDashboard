package com.onlineDashboardApplication.stepDefination;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.onlineDashboardApplication.pom.pages.Registration;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestRegistration {

	public static WebDriver driver = null;
	public Registration registration;

	@After("@Registration")
	public void afterScenario() {
		if (driver != null) {
			driver.close();
		}
	}

	@Given("^user is in the Registration form$")
	public void user_is_in_the_Registration_form() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		registration = PageFactory.initElements(driver, Registration.class);
		driver.get("http://localhost:8080/register");
	}

	@When("^user enters correct employee Id$")
	public void user_enters_correct_employee_Id() {
		registration.employee_Id("13");
	}

	@When("^user selects Supervisor dropdown, SLP Track dropdown$")
	public void user_selects_Supervisor_dropdown_SLP_Track_dropdown() {
		registration.supervisor_Dropdown("Sujay Rahane");
		registration.slp_Track_Dropdown(4);
	}

	@When("^user click on register button$")
	public void user_click_on_register_button() {
		registration.register_Button();
	}

	@Then("^user is registered and confirmation page opens saying \"([^\"]*)\"$")
	public void user_is_registered_and_confirmation_page_opens_saying(String arg1) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String Display = registration.message_Display();
		System.out.println(Display);
		Assert.assertEquals("Thank You", Display);
	}

	@When("^user enters an existing employeeID$")
	public void user_enters_an_existing_employeeID() {
		registration.employee_Id("8");
	}

	@Then("^Error message showing \"([^\"]*)\"$")
	public void error_message_showing(String value) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.alertIsPresent());
		String alert1 = driver.switchTo().alert().getText();
		System.out.println(alert1);
		Assert.assertEquals("This employee is already registered !", alert1);
		Thread.sleep(500);
		driver.switchTo().alert().accept();
	}

	@When("^user enter correct Employee id$")
	public void user_enter_correct_Employee_id() {
		registration.employee_Id("2");

	}

	@Then("^alert message shows \"([^\"]*)\"$")
	public void alert_message_shows(String string) throws InterruptedException {
		String alertMessage = driver.switchTo().alert().getText();
		Assert.assertEquals("Please select supervisor !", alertMessage);
		System.out.println("Scenario two is executed successffuly");
		Thread.sleep(500);
		driver.switchTo().alert().accept();
	}

	@When("^user selects supervisor$")
	public void user_selects_supervisor() {
		registration.supervisor_Dropdown("Sujay Rahane");
	}

	@Then("^alert message popup \"([^\"]*)\"$")
	public void alert_message_popup(String arg1) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String alertvalue = driver.switchTo().alert().getText();
		System.out.println(alertvalue);
		Assert.assertEquals("Please enter valid employee Id !", alertvalue);
		Thread.sleep(500);
		driver.switchTo().alert().accept();
	}

	@When("^user selects SLP Track$")
	public void user_selects_SLP_Track() {
		registration.slp_Track_Dropdown(2);
	}

	@When("^user enter invalid employee id$")
	public void user_enter_invalid_employee_id() {
		registration.employee_Id("1222");
	}

	@Then("^error message \"([^\"]*)\"$")
	public void error_message(String arg1) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.alertIsPresent());

		String alertvalue = driver.switchTo().alert().getText();
		Assert.assertEquals("Invalid employee Id !", alertvalue);
		Thread.sleep(500);
		driver.switchTo().alert().accept();
	}

	@When("^user enters characters as employeeID$")
	public void user_enters_characters_as_employeeID() {
		registration.employee_Id("slpa");
	}

	@Then("^alert box message display \"([^\"]*)\"$")
	public void alert_box_message_display(String arg1) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String alertSlp = driver.switchTo().alert().getText();
		Assert.assertEquals("Please select track !", alertSlp);
		Thread.sleep(500);
		driver.switchTo().alert().accept();

	}

}
