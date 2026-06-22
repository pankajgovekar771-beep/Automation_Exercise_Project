package POM_Pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helper.BasePage;

public class HomePage_ProductPage_POM extends BasePage {

    WebDriverWait wait;

    public HomePage_ProductPage_POM(WebDriver driver) {
        super(driver);

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(xpath="//a[@href='#Men']")
    WebElement menCategory;

    @FindBy(xpath="//a[contains(text(),'Tshirts')]")
    WebElement tshirtCategory;

    @FindBy(xpath="(//div[@class='product-image-wrapper'])[1]")
    WebElement firstProduct;

    @FindBy(xpath="(//a[contains(text(),'Add to cart')])[1]")
    WebElement addToCart;

    @FindBy(xpath="//u[text()='View Cart']")
    WebElement viewCart;

    By popupClose =
            By.xpath("//div[contains(@id,'dismiss-button')]");

    public void clickMenCategory() {

        wait.until(ExpectedConditions.elementToBeClickable(menCategory));

        ((JavascriptExecutor)driver)
                .executeScript("arguments[0].click();",
                        menCategory);
    }

    public void clickTshirtCategory() {

        wait.until(ExpectedConditions.elementToBeClickable(tshirtCategory));

        ((JavascriptExecutor)driver)
                .executeScript("arguments[0].click();",
                        tshirtCategory);
    }

    public void closeAdvertisementPopup() {

        try {

            driver.switchTo().frame(
                    driver.findElement(
                            By.xpath("//iframe[contains(@id,'aswift')]")));

            driver.findElement(popupClose).click();

            driver.switchTo().defaultContent();

        }
        catch(Exception e) {

            driver.switchTo().defaultContent();
        }
    }

    public void selectProduct() {

        wait.until(
                ExpectedConditions.visibilityOf(firstProduct));

        ((JavascriptExecutor)driver)
                .executeScript(
                        "arguments[0].scrollIntoView(true);",
                        firstProduct);

        ((JavascriptExecutor)driver)
                .executeScript(
                        "arguments[0].click();",
                        firstProduct);
    }

    public void addToCart() {

        wait.until(
                ExpectedConditions.elementToBeClickable(addToCart));

        ((JavascriptExecutor)driver)
                .executeScript(
                        "arguments[0].click();",
                        addToCart);
    }

    public void viewCart() {

        wait.until(
                ExpectedConditions.elementToBeClickable(viewCart));

        viewCart.click();
    }
}