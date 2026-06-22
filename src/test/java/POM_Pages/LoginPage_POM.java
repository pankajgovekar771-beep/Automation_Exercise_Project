package POM_Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import Helper.BasePage;

public class LoginPage_POM extends BasePage{
	public LoginPage_POM(WebDriver driver) {
        super(driver);
    }

	@FindBy(xpath = "//a[contains(text(),'Signup / Login')]")
	WebElement signupLogin;

	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")
	WebElement email;

	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")
	WebElement password;

	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/button")
	WebElement loginBtn;

	public void clickSignupLogin() {
	    signupLogin.click();
	}

	public void login(String user, String pass) {

	    email.clear();
	    email.sendKeys(user);

	    password.clear();
	    password.sendKeys(pass);

	    loginBtn.click();
	}
}