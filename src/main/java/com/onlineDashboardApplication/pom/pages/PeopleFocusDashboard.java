package com.onlineDashboardApplication.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PeopleFocusDashboard 
{

	   @FindBy(how=How.XPATH,using="//*[@id=\"example2_filter\"]/label/input")
	   public WebElement search_box_people_focus;
		
		@FindBy(how=How.XPATH,using="/html/body/div/aside/section/ul/li[4]/a")
		public WebElement people_focus_link;
		
		@FindBy(how = How.XPATH, using ="/html/body/div/div[2]/div/div/div/form/div[1]/input")
		  public WebElement username;
		  
		  @FindBy(how = How.XPATH, using ="/html/body/div/div[2]/div/div/div/form/div[2]/input")
		  public WebElement password;
		  
		  @FindBy(how = How.XPATH, using ="/html/body/div/div[2]/div/div/div/form/div[3]/input")
		  public WebElement login_button;
		  
		  @FindBy(how=How.XPATH,using="/html/body/div/aside/section/ul/li[4]/ul/li/a")
			public WebElement report_link;
		  
		  public void search_Box_People_Focus(String searchText) 
		  {
		      search_box_people_focus.sendKeys(searchText);
		  }
		  
		  public void people_Focus_Link() {
		      people_focus_link.click();
		  }
		  
		  public void username(String username1)
		  {
		      username.sendKeys(username1);
		  }
		  
		  public void password(String password1)
		  {
		      password.sendKeys(password1);
		  }
		  
		  public void login_button_click() {
		      login_button.click();
		  }
		  
		  public void report_Link() {
		      report_link.click();
		  }

		
		  
}
