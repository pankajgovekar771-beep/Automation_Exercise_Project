package POM_Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import Helper.BasePage;

public class CartPage_POM extends BasePage{
	public CartPage_POM(WebDriver driver) {
        super(driver);
    }

	@FindBy(xpath="//a[contains(text(),'Proceed To Checkout')]")
	WebElement proceedCheckout;

	public void proceedCheckout() {
	    proceedCheckout.click();
	}
}