package com.onlineDashboardApplication.stepDefination;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class abc 
{
	public static WebDriver driver;
@Test
  public void f() throws InterruptedException 
  {
	  
	  driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("http://localhost:8080/login");
      driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/form/div[1]/input")).sendKeys("admin1");
      driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/form/div[2]/input")).sendKeys("pass1");
      driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/form/div[3]/input")).click();
      driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[4]/a")).click();
      Thread.sleep(1000);
      driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[4]/ul/li/a")).click(); 
      
    }
		 
  }
