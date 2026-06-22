package Helper;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseTest {
	public static WebDriver driver;

    @BeforeSuite
    public void setup() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        
        driver.manage().timeouts()
        .implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://automationexercise.com/");
    }

    @AfterSuite
    public void tearDown() {

        driver.quit();
    }
}
