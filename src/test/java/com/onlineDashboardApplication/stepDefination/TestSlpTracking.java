package com.onlineDashboardApplication.stepDefination;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.onlineDashboardApplication.pom.pages.SLPTracking;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.After;
import cucumber.api.java.en.And;

public class TestSlpTracking {
	public static WebDriver driver=null;
	public SLPTracking SlpTrack=null;
	
	@After("@SLp")
    public void afterScenario()
    {
		if (driver != null) 
		{
          driver.close(); 
		}  
	 } 
	
	@Given("^user is on the SLP status tracking page$")
	public void user_is_on_the_slp_status_tracking_page() {
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8080/status");
	    SlpTrack = PageFactory.initElements(driver, SLPTracking.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String abc = SlpTrack.Slp_status_text();
		Assert.assertEquals(abc, "SLP status tracking");
	}
	
	@When("^user enter incorrect employee Id$")
public void user_enter_incorrect_employee_id() throws InterruptedException {
	
	HighElement.highlightElement(SlpTrack.empId);
	SlpTrack.empId("1733");
}

@Then("^Pop up box appears, Invalid Employee id$")
public void pop_up_box_appears_invalid_employee_id() throws InterruptedException {
	Thread.sleep(500);
	String getstatus = driver.switchTo().alert().getText();
	Thread.sleep(500);
	driver.switchTo().alert().accept();
	Assert.assertEquals(getstatus, "Invalid Employee Id !");

}

@When("^user enters valid employee id$")
public void user_enters_valid_employee_id() throws InterruptedException {
	//driver.navigate().refresh();
	Thread.sleep(1000);
	HighElement.highlightElement(SlpTrack.empId);
	SlpTrack.empId("13");
}

@And("^user click check status button$")
public void user_checks_status() {
	HighElement.highlightElement(SlpTrack.submitbbtn);
	SlpTrack.SubmitButton();
}

@Then("^message will be shown Thank you for the update$")
public void message_will_be_shown_Thank_you_for_the_update() throws InterruptedException {
	Thread.sleep(500);
	Assert.assertEquals("Thank You",SlpTrack.ThanksMessage());
}

@And("^user selects course dropdown$")
public void user_selects_course_dropdown() throws InterruptedException {
	
	String course_Text=SlpTrack.Course_Text.getText();
	SlpTrack.Selenium_Outer();
	 List<WebElement> allElements = driver.findElements(By.tagName("a"));
     for(WebElement element: allElements)
     {
        String abc=element.getAttribute("aria-selected");
        if(!abc.equals("true"))
        {
        	if(course_Text.equals("Selenium"))
        	{	
        	  if(element.getText().equals("Locating Elements By Name"))
        	   {
        		  element.click();	
        	   }
        	}
        	if(course_Text.equals("API"))
        	{
        		if(element.getText().equals("HTTP Methods - CRUD"))
	        	   {
	        		  element.click();	
	        	   }
        	}
        	if(course_Text.equals("Appium"))
        	{
        		if(element.getText().equals("Mobile app inspect element"))
	        	   {
	        		  element.click();	
	        	   }
        	}
        	if(course_Text.equals("Tosca"))
        	{
        		if(element.getText().equals("Parent Control; Dynamic ID and Dynamic Comparison"))
	        	   {
	        		  element.click();	
	        	   }
        	}
        }
       
    }	
    SlpTrack.Selenium_Outer();
    System.out.println(!course_Text.equals("Tosca"));
	if (!course_Text.equals("Tosca")) 
	{
		Thread.sleep(500);
		SlpTrack.Java_Outer();
		List<WebElement> allElements1 = driver.findElements(By.tagName("a"));
		for (WebElement element : allElements1) {
			String abc = element.getAttribute("aria-selected");
			if (!abc.equals("true")) {
				if (element.getText().equals("Switch")) {
					Thread.sleep(500);
					element.click();
				}
			}

		}

		Thread.sleep(500);
		SlpTrack.Cucumber_Outer();
		List<WebElement> allElements2 = driver.findElements(By.tagName("a"));
		for (WebElement element : allElements2) {
			String abc = element.getAttribute("aria-selected");
			if (!abc.equals("true")) {
				if (element.getText().equals("Junit Test Runner Class")) {
					Thread.sleep(500);
					element.click();
				}
			}

		}
	}
}




@And("^user click updates button$")
public void user_click_updates_button() throws InterruptedException {
	Thread.sleep(1000);
    HighElement.highlightElement(SlpTrack.Updatebbtn);
	SlpTrack.Update_Button();
}

@Then("^user will be displayed with employee id,supervisor,slp track,selenium dropdown,java dropdown,cucumber dropdown$")
public void user_will_be_displayed_with_employee_idsupervisorslp_trackselenium_dropdownjava_dropdowncucumber_dropdown() {

	WebElement Supervisor = HighElement.highlightElement(SlpTrack.supervisor);
	Assert.assertTrue(Supervisor.isDisplayed());

	WebElement slp_Track = HighElement.highlightElement(SlpTrack.slp_track);
	Assert.assertTrue(slp_Track.isDisplayed());

	WebElement Selenium = HighElement.highlightElement(SlpTrack.selenium_outer);
	Assert.assertTrue(Selenium.isDisplayed());

	String course_Text=SlpTrack.Course_Text.getText();
	if(!course_Text.equals("Tosca"))
    {	
	  WebElement Java = HighElement.highlightElement(SlpTrack.java_outer);
	  Assert.assertTrue(Java.isDisplayed());

	  WebElement cucumber = HighElement.highlightElement(SlpTrack.cucumber_outer);
	  Assert.assertTrue(cucumber.isDisplayed());
    } 
}

@Then("^user check priviously updated courses are checked$")
public void user_check_priviously_updated_courses_are_checked() throws InterruptedException 
{	
	String course_Text=SlpTrack.Course_Text.getText();
	SlpTrack.Selenium_Outer();
	 List<WebElement> allElements = driver.findElements(By.tagName("a"));
     for(WebElement element: allElements)
      {
    	 if(course_Text.equals("Selenium"))
    	 {
    		 if(element.getText().equals("Locating Elements By Name"))
	    	    {
	              String abc=element.getAttribute("aria-selected");
	              Assert.assertEquals("true",abc);
	    	    } 
    	 }
    	 if(course_Text.equals("API"))
    	 {
    	   if(element.getText().equals("HTTP Methods - CRUD"))
    	    {
              String abc=element.getAttribute("aria-selected");
              Assert.assertEquals("true",abc);
    	    }
    	 }
    	 if(course_Text.equals("Appium"))
    	 {
    	   if(element.getText().equals("Mobile app inspect element"))
    	    {
              String abc=element.getAttribute("aria-selected");
              Assert.assertEquals("true",abc);
    	    }
    	 }
    	 if(course_Text.equals("Tosca"))
    	 {
    	   if(element.getText().equals("Parent Control; Dynamic ID and Dynamic Comparison"))
    	    {
              String abc=element.getAttribute("aria-selected");
              Assert.assertEquals("true",abc);
    	    }
    	 }
       
       }	
	SlpTrack.Selenium_Outer();
	if(!course_Text.equals("Tosca"))
    {
	SlpTrack.Java_Outer();
	List<WebElement> allElements1 = driver.findElements(By.tagName("a"));
     for(WebElement element: allElements1)
      {
    	 if(element.getText().equals("Switch"))
    	 {
            String abc=element.getAttribute("aria-selected");
            Assert.assertEquals("true",abc);
    	 }  
       
       }
   
	
	SlpTrack.Cucumber_Outer();
	List<WebElement> allElements3 = driver.findElements(By.tagName("a"));
     for(WebElement element: allElements3)
      {
    	 if(element.getText().equals("Junit Test Runner Class"))
    	 {
            String abc=element.getAttribute("aria-selected");
            Assert.assertEquals("true",abc);
    	 }  
       
       }
    }  
}

@And("^user update one course$")
public void user_update_one_course() throws InterruptedException {
	String course_Text=SlpTrack.Course_Text.getText();
	if(!course_Text.equals("Tosca"))
    {
	SlpTrack.Java_Outer(); 
	List<WebElement> allElements1 = driver.findElements(By.tagName("a"));
     for(WebElement element: allElements1)
    {
        String abc=element.getAttribute("aria-selected");
        if(!abc.equals("true"))
        {
        	if(element.getText().equals("If Else"))
        	{
        		Thread.sleep(200);
        		element.click();	
        	}
        }
       
    }
     SlpTrack.Java_Outer(); 
     Thread.sleep(500);
    } 
}

@Then("^user check corrrect supervisor is populated$")
public void user_check_corrrect_supervisor_is_populated() throws InterruptedException {
	Thread.sleep(500);
	Assert.assertEquals("Sujay Rahane",SlpTrack.Supervisor_name());
}

 @Then("^Check User cannot change Supervisor or SLP Track$")
public void check_user_cannot_change_supervisor_or_slp_track() 
 {
	 String check=SlpTrack.supervisor.getAttribute("aria-disabled");
	 Assert.assertEquals("true",check);
	 
	 String check1=SlpTrack.slp_track.getAttribute("aria-disabled");
	 Assert.assertEquals("true",check1); 
 }

@Then("^Courses Dropdown are based on SLP Track$")
public void courses_dropdown_are_based_on_slp_track() 
{
	  String check=SlpTrack.slp_value.getText();
	  check=check.trim();
	  String check1=SlpTrack.Course_Text.getText();
	  
	  if(check.contains(check1)){ 
            int y = check.indexOf(check1); 
            check = check.substring(y , y+(check1.length()));   
           
        }
	  Assert.assertEquals(check,check1);
}

	}
