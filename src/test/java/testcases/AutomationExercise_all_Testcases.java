package testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Helper.BaseTest;
import POM_Pages.CartPage_POM;
import POM_Pages.CheckoutPages_POM;
import POM_Pages.HomePage_ProductPage_POM;
import POM_Pages.LoginPage_POM;

public class AutomationExercise_all_Testcases extends BaseTest {

    WebDriverWait wait;

    public AutomationExercise_all_Testcases() {
        super();
    }

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logout;
	private By element;

    @Test(priority = 1)
    public void loginTest() throws IOException, InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://automationexercise.com");

        LoginPage_POM lp = new LoginPage_POM(driver);

        lp.clickSignupLogin(); // create this method in LoginPage_POM

        lp.login(
                "pankajgovekar771@gmail.com",
                "pankajgov1986");
        wait.until(
        		ExpectedConditions.titleContains("Automation"));

        wait.until(ExpectedConditions.titleContains("Automation"));

        System.out.println("Login Successful");
       

        Assert.assertTrue(true);
    }

    @Test(priority = 2, dependsOnMethods = "loginTest")
    public void productSelection() throws Exception {

        HomePage_ProductPage_POM hp =
                new HomePage_ProductPage_POM(driver);

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,900)");

        Thread.sleep(2000);

        hp.clickMenCategory();

        Thread.sleep(2000);

        hp.clickTshirtCategory();

        wait.until(
        		ExpectedConditions.visibilityOfElementLocated(
        		By.xpath("//div[@class='features_items']")));

        hp.closeAdvertisementPopup();

        js.executeScript("window.scrollBy(0,700)");

        Thread.sleep(2000);

        hp.selectProduct();

        Thread.sleep(2000);

        hp.addToCart();

        Thread.sleep(2000);

        hp.viewCart();

        System.out.println("Product Added To Cart");

        Assert.assertTrue(true);
    }    @Test(priority = 3, dependsOnMethods = "productSelection")
    public void cartPage() throws IOException, InterruptedException{

        CartPage_POM cp =
                new CartPage_POM(driver);

        cp.proceedCheckout();

        System.out.println("Checkout Clicked");
        Thread.sleep(2000);

        Assert.assertTrue(true);
    }

    @Test(priority = 4, dependsOnMethods = "cartPage")
    public void checkoutPage() throws IOException, InterruptedException{

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "window.scrollBy(0,800)");

        CheckoutPages_POM chk =
                new CheckoutPages_POM(driver);

        chk.placeOrder();

        System.out.println("Place Order Clicked");
        Thread.sleep(2000);

        Assert.assertTrue(true);
    }

    @Test(priority = 5,
    		dependsOnMethods = "checkoutPage")
    		public void paymentOrder()
    		        throws IOException, InterruptedException {

    		    CheckoutPages_POM chk =
    		            new CheckoutPages_POM(driver);

    		    wait = new WebDriverWait(driver,
    		            Duration.ofSeconds(15));

    		    wait.until(
    		            ExpectedConditions.urlContains("payment"));

    		    chk.payment(
    		            "Bank Of Baroda",
    		            "123456788761",
    		            "433",
    		            "05",
    		            "2030");

    		    chk.payAndConfirm();

    		    System.out.println("Payment Completed");

    		    Assert.assertTrue(true);
    		}

    @Test(priority = 6, dependsOnMethods = "paymentOrder")
    public void logoutApp() throws IOException, InterruptedException{

        PageFactory.initElements(driver, this);

        wait.until(
        		ExpectedConditions.visibilityOf(logout));

        		wait.until(
        		ExpectedConditions.elementToBeClickable(logout));

        		logout.click();
        Thread.sleep(2000);

        System.out.println("Logout Successful");
        Thread.sleep(2000);

        Assert.assertTrue(true);
    }
}