package com.onlineDashboardApplication.stepDefination;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class abc {
  @Test
  public void f() throws InterruptedException
  {
	  WebDriver driver;
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://localhost:8080/login");
	  driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/form/div[1]/input")).sendKeys("admin1");
	  driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/form/div[2]/input")).sendKeys("pass1");
	  driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/form/div[3]/input")).click();
	  
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
		
		
		
		
		double selenium_courses=(double) seleniumCount/count;
		double rest_courses=(double) restassuredCount/count1;
		double tosca_courses=(double) toscaCount/count2;
		double appium_courses=(double) appiumCount/count3;
		
		double percentage_selenium_courses =(selenium_courses*100)/50;
		double percentage_rest_courses =(rest_courses*100)/45;
		double percentage_appium_courses =(appium_courses*100)/43;
		double percentage_tosca_courses =(tosca_courses*100)/26;
		
		driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/ul/li[2]/a")).click();
		
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
}
