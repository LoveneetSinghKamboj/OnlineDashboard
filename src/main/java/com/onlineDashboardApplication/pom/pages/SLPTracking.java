package com.onlineDashboardApplication.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SLPTracking 
{
	private WebDriver driver;

	  public SLPTracking(WebDriver driver) {
	    this.driver = driver;
	  }
	
	  @FindBy(how = How.XPATH, using ="//h3[@class='text-center text-info']")
	  public WebElement Slp_status_text;
	  
	  @FindBy(how = How.XPATH, using ="//input[@id='empId']")
	  public WebElement empId;
	  
	  @FindBy(how = How.XPATH, using ="//*[@id=\"statusBTN\"]")
	  public WebElement submitbbtn;
	  
	  @FindBy(how = How.XPATH, using ="//h1[@class='display-3']")
	  public WebElement thanksMessage;
	  
	  @FindBy(how = How.XPATH, using ="//*[@id=\"form-part2\"]/div[1]/div/div/button")
	  public WebElement supervisor;
	  
	  @FindBy(how = How.XPATH, using ="//*[@id=\"form-part2\"]/div[2]/div/div/button")
	  public WebElement slp_track;
	  
	  @FindBy(how = How.XPATH, using ="//*[@id=\"form-part2\"]/div[2]/div/div/button/div/div/div")
	  public WebElement slp_value;
	  
	  @FindBy(how = How.XPATH, using ="//*[@id=\"updateBTN\"]")
	  public WebElement Updatebbtn;
	  
	  @FindBy(how = How.XPATH, using ="//*[@id=\"multiSelect\"]/div[1]/div/div/button")
	  public WebElement selenium_outer;
	  
	  @FindBy(how = How.XPATH, using ="//*[@id=\"bs-select-3-1\"]/span[2]")
	  public WebElement selenium_inner;
	  
	  @FindBy(how = How.XPATH, using ="//*[@id=\"multiSelect\"]/div[2]/div/div/button")
	  public WebElement java_outer;
	  
	  @FindBy(how = How.XPATH, using ="//*[@id=\"bs-select-4-1\"]/span[2]")
	  public WebElement java_inner;
	  
	  @FindBy(how = How.XPATH, using ="//*[@id=\"multiSelect\"]/div[3]/div/div/button")
	  public WebElement cucumber_outer;
	  
	  @FindBy(how = How.XPATH, using ="//*[@id=\"bs-select-5-1\"]/span[2]")
	  public WebElement cucumber_inner;
	  
	  @FindBy(how = How.XPATH, using ="//*[@id=\"multiSelect\"]/div[1]/div/label")
	  public WebElement Course_Text;
	  
	
	  
	  public void Update_Button()
	  {
		  Updatebbtn.click();
	  }
	  
	  public void SLP_Track()
	  {
		  slp_track.click();
	  }
	  
	  public void Selenium_Outer()
	  {
		  selenium_outer.click();
	  }
	  
	  public void Selenium_Inner()
	  {
		  selenium_inner.click();
	  }
	  
	  public void Java_Outer()
	  {
		  java_outer.click();
	  }
	  
	  public void Java_Inner()
	  {
		  java_inner.click();
	  }
	  
	  public void Cucumber_Outer()
	  {
		  cucumber_outer.click();
	  }
	  
	  public void Cucumber_Inner()
	  {
		  cucumber_inner.click();
	  }
	  
	  public String Slp_status_text()
	  {
		  return Slp_status_text.getText();
	  }
	  
	  public void empId(String emp)
	  {
		  empId.sendKeys(emp);
	  }
	  
	  public String ThanksMessage()
	  {
		  return thanksMessage.getText();
	  }
	  
	  public void  SubmitButton()
	  {
		  submitbbtn.click();
	  }
	  public String Supervisor_name()
	  {
		return supervisor.getAttribute("title");
	  }
	  
}
