package com.onlineDashboardApplication.pom.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class PeopleFocus {
	
	  
	  @FindBy(how=How.XPATH,using="/html/body/div/div[2]/div/div/div[2]/div/form/div[1]/div[1]/div[1]/input")
		public WebElement employeeId;
	  
	  @FindBy(how=How.XPATH,using="/html/body/div/div[2]/div/div/div[2]/div/form/div[1]/div[1]/div[2]/select")
		public WebElement designation_drop;
		
		@FindBy(how=How.XPATH,using="/html/body/div/div[2]/div/div/div[2]/div/form/div[1]/div[1]/div[3]/select")
		public WebElement supervisor_drop;
		
		@FindBy(how=How.XPATH,using="/html/body/div/div[2]/div/div/div[2]/div/form/div[1]/div[2]/div[1]/select")
		public WebElement f2f;
		
	    @FindBy(how=How.XPATH,using="/html/body/div/div[2]/div/div/div[2]/div/form/div[1]/div[3]/div/textarea")
	    public WebElement issues;
		
	    @FindBy(how=How.XPATH,using="/html/body/div/div[2]/div/div/div[2]/div/form/div[1]/div[4]/div/textarea")
	    public WebElement apprc;
	    
	    @FindBy(how=How.XPATH,using="/html/body/div/div[2]/div/div/div[2]/div/form/div[1]/div[5]/div/textarea")
	    public WebElement esc;
	    
	    @FindBy(how=How.XPATH,using="/html/body/div/div[2]/div/div/div[2]/div/form/div[1]/div[6]/div/textarea")
	    public WebElement remarks;
	    
	    @FindBy(how=How.XPATH,using="/html/body/div/div[2]/div/div/div[2]/div/input")
	    public WebElement register;
	    
	    @FindBy(how=How.XPATH,using="/html/body/div/h1")
	    public WebElement mess_display;
	  
	  public void empID(String emp) {
		  employeeId.sendKeys(emp);
	  }
	  
		public void Designation(String desig)
		{
			Select s1=new Select(designation_drop);
			s1.selectByVisibleText(desig);
		}
		public void Supervisor(String supervisor)
		{
			Select s2=new Select(supervisor_drop);
			s2.selectByVisibleText(supervisor);
		}
		public void F2FDone(String f2fdone)
		{
			Select s3=new Select(f2f);
			s3.selectByVisibleText(f2fdone);
		}
		public void Issues(String Issue)
		{
			issues.sendKeys(Issue);
		}
		public void Appreciation(String appreciation)
		{
			apprc.sendKeys(appreciation);
		}
		public void Escalation(String escalation)
		{
			esc.sendKeys(escalation);
		}
		public void Remarks(String rmk)
		{
			remarks.sendKeys(rmk);
		}
		public void ClickRegister()
		{
			register.click();
		}
		public String MessageDisplay()
		{
			return mess_display.getText();
		}

}