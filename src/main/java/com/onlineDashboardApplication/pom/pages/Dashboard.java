package com.onlineDashboardApplication.pom.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class Dashboard
{
	WebDriver driver;
	
	 public Dashboard(WebDriver driver) {
	        this.driver = driver;
	    }
	 
   @FindBy(how=How.XPATH,using="//*[@id=\"example2_filter\"]/label/input")
   public WebElement search_box_people_focus;
	
	@FindBy(how=How.XPATH,using="/html/body/div/aside/section/ul/li[4]/a")
	public WebElement people_focus_link;
	
	@FindBy(how=How.XPATH,using="/html/body/div/aside/section/ul/li[4]/ul/li/a")
	public WebElement report_link;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"example2_wrapper\"]/div[1]/button")
	public WebElement export_excel;
	
	@FindBy(how=How.XPATH,using="/html/body/div/aside/section/ul/li[3]/a")
	public WebElement chart_link;
	
	@FindBy(how=How.XPATH,using="/html/body/div/aside/section/ul/li[3]/ul/li[2]/a")
	public WebElement track_report_link;
	
	@FindBy(how=How.ID,using="example2_info")
	public WebElement count_entries;
	
	@FindBy(how = How.XPATH, using ="/html/body/div/div[2]/div/div/div/form/div[1]/input")
	  public WebElement username;
	  
	  @FindBy(how = How.XPATH, using ="/html/body/div/div[2]/div/div/div/form/div[2]/input")
	  public WebElement password;
	  
	  @FindBy(how = How.XPATH, using ="/html/body/div/div[2]/div/div/div/form/div[3]/input")
	  public WebElement login_button;
	  
	  @FindBy(how = How.XPATH, using ="/html/body/div/div/div/div/div/div/div/div[2]/div/table/thead/tr[2]/th[1]/input")
	  public WebElement search_empid;
	  
	  @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div/div/div/div/div[2]/div/table/thead/tr[2]/th[2]/input")
	  public WebElement search_empname;
	  
	  @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div/div/div/div/div[2]/div/table/thead/tr[2]/th[3]/input")
	  public WebElement search_registrationdate;
	  
	  @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div/div/div/div/div[2]/div/table/thead/tr[2]/th[4]/input")
	  public WebElement search_supervisorname;
	  
	  @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div/div/div/div/div[2]/div/table/thead/tr[2]/th[5]/input")
	  public WebElement search_trackname;
	  
	  @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div/div/div/div/div[2]/div/table/thead/tr[2]/th[6]/input")
	  public WebElement search_course;
	  
	  @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div/div/div/div/div[2]/div/table/thead/tr[2]/th[7]/input")
	  public WebElement search_topiccompleted;
	  
	  @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div/div/div/div/div[2]/div/div[2]/label/input")
	  public WebElement page_searchbox;
	  
	  @FindBy(how = How.XPATH, using ="/html/body/div/div/div/div/div/div/div/div[2]/div/div[4]/a[2]")
	  public WebElement tablenext_button;
	  
	  
	  
	  
	  
	  @FindBy(how = How.XPATH, using = "/html/body/div/aside/section/ul/li[6]/a")
		public WebElement clicks_SupervisorPage;

		@FindBy(how = How.XPATH, using = "/html/body/div/aside/section/ul/li[6]/ul/li/a")
		public WebElement clicks_upload_SuperPage;

		@FindBy(how = How.XPATH, using = "/html/body/div/div/div/div/div[2]/form/div[2]/div[2]/input")
		public WebElement choose_file;

		@FindBy(how = How.XPATH, using = "/html/body/div/div/div/div/div[2]/form/div[2]/div[3]/input")
		public WebElement upload;

		@FindBy(how = How.XPATH, using = "/html/body/div/div/div/div/div[2]/div/div[1]")
		public WebElement label_msg;

		@FindBy(how = How.XPATH, using = "/html/body/div/div/div/div/div[2]/div/div[3]/div/div[2]/label/input")
		public WebElement supervisor_search_box;

		
		
		
		
		
		 @FindBy(how = How.XPATH, using ="/html/body/div/aside/section/ul/li[5]/a")
		  public WebElement clicks_EmployeePage;

		  @FindBy(how = How.XPATH, using ="/html/body/div/aside/section/ul/li[5]/ul/li/a")
		  public WebElement clicks_upload_empPage;
		  
		  
		 
	      
	      @FindBy(how = How.XPATH, using ="/html/body/div/div/div/div/div[2]/div/div[3]/div/div[2]/label/input")
		  public WebElement employee_search_box;
		
		
	      public void click_employeeMenubar() {
			  clicks_EmployeePage.click();
			 }
		 
			 public void click_employee_link() {
				 clicks_upload_empPage.click();
			 }
	      
			 public void super_searchbox(String employee_search)
			 {
			 employee_search_box.sendKeys(employee_search);
			 }
	  
	  
	  
	  public void search_Box_People_Focus(String searchText) 
	  {
	      search_box_people_focus.sendKeys(searchText);
	  }
	  
	  public void people_Focus_Link() {
	      people_focus_link.click();
	  }
	  
	  public void report_Link() {
	      report_link.click();
	  }
	  
	  public void tablenext_button(String nextbuttonclick)
	  {
		  tablenext_button.sendKeys(nextbuttonclick);
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
	  
	  public void search_empid(String empid)
	  {
	      search_empid.sendKeys(empid);
	  }
	  
	  public void search_empname(String empname)
	  {
		  search_empname.sendKeys(empname);
	  }
	  
	  public void search_registrationdate(String registdate)
	  {
		  search_registrationdate.sendKeys(registdate);
	  }
	  
	  public void search_supervisorname(String supervisorname)
	  {
		  search_supervisorname.sendKeys(supervisorname);
	  }
	  
	  public void search_trackname(String trackname)
	  {
		  search_trackname.sendKeys(trackname);
	  }
	  
	  public void search_course(String coursename)
	  {
		  search_course.sendKeys(coursename);
	  }
	  
	  public void search_topiccompleted(String topicsearch)
	  {
		  search_topiccompleted.sendKeys(topicsearch);
	  }
	   
	  public void page_searchbox(String pagesearchbox)
	  {
		  page_searchbox.sendKeys(pagesearchbox);
		  
	  }
	
	
	
	
	
	
	
	
	
	  
	  
	  public void click_supervisorMenubar() {
			clicks_SupervisorPage.click();
		}

		public void click_super_upload_link() {
			clicks_upload_SuperPage.click();
		}

		public void choose_file_get(String file) {
			choose_file.sendKeys(file);
		}

		public void upload_click() {
			upload.click();
		}

		public String label_msg_get() {
			return label_msg.getText();
		}

		public void supervisor_searchbox(String employee_search) {
			supervisor_search_box.sendKeys(employee_search);
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public void chart_Link() {
		chart_link.click();
	}
	
	public void track_Report_Link() {
		track_report_link.click();
	}

	public String Count_Entries() {
		return count_entries.getText();
	}
	
    public void Export_Excel() {
		export_excel.click();
	}


	

	
	
}