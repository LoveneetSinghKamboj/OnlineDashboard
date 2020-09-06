package com.onlineDashboardApplication.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class Registration
{
	  @FindBy(how = How.NAME, using ="empId")
	  public WebElement empId;
	  
	  @FindBy(how = How.ID, using ="supervisor")
	  public WebElement supervisor_Drop;
	  
	  @FindBy(how = How.ID, using ="track")
	  public WebElement slp_Track_Dropdown;
	  
	  @FindBy(how = How.XPATH, using ="//*[@id=\"registration-box\"]/div/input")
	  public WebElement register_bbtn;
	  
	  @FindBy(how = How.XPATH, using ="/html/body/div/h1")
	  public WebElement message_display;
	  
	  public void employee_Id(String emp)
	  {
		  empId.sendKeys(emp);
	  }
	  
	  public void supervisor_Dropdown(String supervisor)
	  {
		  Select sl1 = new Select(supervisor_Drop);
		  sl1.selectByVisibleText(supervisor); 
	  }
	  
	  public void slp_Track_Dropdown(int track)
	  {
		  Select sl2=new Select(slp_Track_Dropdown);
		  sl2.selectByIndex(track);
	  }
	  
	  public void register_Button()
	  {
		  register_bbtn.click();
	  }
	  
	  public String message_Display()
	  {
		 return  message_display.getText();
	  }
}
