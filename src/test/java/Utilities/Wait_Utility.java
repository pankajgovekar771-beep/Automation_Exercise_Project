package Utilities;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;


public class Wait_Utility {

	 public static void waitForElement(WebDriver driver, WebElement element) {

	        WebDriverWait wait =
	                new WebDriverWait(driver, Duration.ofSeconds(15));

	        wait.until(ExpectedConditions.visibilityOf(element));
	    }
	}