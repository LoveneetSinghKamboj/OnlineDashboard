package com.onlineDashboardApplication.stepDefination;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class HighElement {

    public static WebElement highlightElement(WebElement element) {
            JavascriptExecutor js = (JavascriptExecutor) TestSlpTracking.driver;
            js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 2px solid red;');", element);
          //  js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
		return element;
        }
}