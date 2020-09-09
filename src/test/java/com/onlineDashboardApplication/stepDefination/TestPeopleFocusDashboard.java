package com.onlineDashboardApplication.stepDefination;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.onlineDashboardApplication.pom.pages.PeopleFocusDashboard;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestPeopleFocusDashboard 
{
  
	public static WebDriver driver;
	public PeopleFocusDashboard pDashboard;; 
	
	@After("@PeopleFocusDashboard")
    public void afterScenario()
    {
		if (driver != null) 
		{
          driver.close(); 
		}  
	 } 

	
		
		  @Given("^Admin in Dashboard Login Page$") 
		  public void admin_is_in_Dashboard_Login_Page() throws Throwable
		  { 
			  driver = new ChromeDriver(); 
			  driver.manage().window().maximize();
		      driver.get("http://localhost:8080/login");
		      pDashboard =PageFactory.initElements(driver, PeopleFocusDashboard.class); 
		   }
		  
		  @When("^Admin enters valid login id password$") 
		  public void admin_user_enters_valid_login_id_password() throws Throwable 
		  {
		     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		     pDashboard.username("admin1"); 
		     pDashboard.password("pass1"); 
		  }
		  
		  @And("^submits a login button$") 
		  public void submit_login_button() throws Throwable 
		  {
			  pDashboard.login_button.click();
		  }
		 
		  @And("^Admin clicks on People Focus week$")
		    public void admin_click_on_people_focus_week() throws InterruptedException 
		    {
			    Thread.sleep(1000);
			    pDashboard.people_Focus_Link();
		    }

		   @And("^clicks on Report Link under people focus week$")
		    public void click_on_report_link_under_people_focus_week() throws InterruptedException
		    {
			   Thread.sleep(1000);
			   pDashboard.report_Link();
		    }
		   @Then("^Checks Same set of data should be displayed in the people focus table$")
		    public void check_same_set_of_data_should_be_displayed_in_the_people_focus_table()
		    {
			   
			   WebElement table_element =driver.findElement(By.xpath("//*[@id=\"example2\"]"));
			      List<WebElement> tablerows=table_element .findElements(By.tagName("tr"));
			      for(int i=0;i<tablerows.size();i++)
			      {
			    	  List<WebElement>columnrow=tablerows.get(i).findElements(By.tagName("td"));
			    	  for(int j=0;j<columnrow.size();j++)
			          {
			    		  if(columnrow.get(0).getText().equals("2"))
			        	  {
			    			  Assert.assertEquals(columnrow.get(1).getText(),"Rohit Ware");
			    			  Assert.assertEquals(columnrow.get(2).getText(),"Associate Consultant");
			    			  Assert.assertEquals(columnrow.get(3).getText(),"Rohit W");
			    			  Assert.assertEquals(columnrow.get(4).getText(),"Yes");
			    			  Assert.assertEquals(columnrow.get(5).getText(),"09-02-2020");
			    			  Assert.assertEquals(columnrow.get(6).getText(),"Issues");
			    			  Assert.assertEquals(columnrow.get(7).getText(),"Appreciation");
			    			  Assert.assertEquals(columnrow.get(8).getText(),"Escalation");
			    			  Assert.assertEquals(columnrow.get(9).getText(),"Remarks");
			        	  }  
			          }
			      }
		    }
		 
		   @And("^Send a Value in Search Box$")
		    public void send_a_value_in_search_box() throws InterruptedException
		    {
			   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		        String val = "Rohit Ware";
		        for (int i = 0; i < val.length(); i++) {
		            char c = val.charAt(i);
		            String s = new StringBuilder().append(c).toString();
		            Thread.sleep(1000);
			       pDashboard.search_Box_People_Focus(s);
		        } 
		    }
		   
	
}
