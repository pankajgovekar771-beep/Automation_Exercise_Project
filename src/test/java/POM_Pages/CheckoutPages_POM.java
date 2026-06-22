package POM_Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helper.BasePage;

public class CheckoutPages_POM extends BasePage {

    WebDriverWait wait;

    public CheckoutPages_POM(WebDriver driver) {

        super(driver);

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @FindBy(xpath="//a[contains(text(),'Place Order')]")
    WebElement placeOrderBtn;

    @FindBy(name="name_on_card")
    WebElement nameOnCard;

    @FindBy(name="card_number")
    WebElement cardNumber;

    @FindBy(name="cvc")
    WebElement cvc;

    @FindBy(name="expiry_month")
    WebElement expiryMonth;

    @FindBy(name="expiry_year")
    WebElement expiryYear;

    @FindBy(id="submit")
    WebElement payAndConfirmBtn;

    public void placeOrder() {

        wait.until(
                ExpectedConditions.elementToBeClickable(placeOrderBtn));

        placeOrderBtn.click();
    }

    public void payment(
            String name,
            String card,
            String cvv,
            String month,
            String year) {

        wait.until(
                ExpectedConditions.visibilityOf(nameOnCard));

        nameOnCard.clear();
        nameOnCard.sendKeys(name);

        cardNumber.clear();
        cardNumber.sendKeys(card);

        cvc.clear();
        cvc.sendKeys(cvv);

        expiryMonth.clear();
        expiryMonth.sendKeys(month);

        expiryYear.clear();
        expiryYear.sendKeys(year);
    }

    public void payAndConfirm() {

        wait.until(
                ExpectedConditions.elementToBeClickable(payAndConfirmBtn));

        payAndConfirmBtn.click();
    }
}