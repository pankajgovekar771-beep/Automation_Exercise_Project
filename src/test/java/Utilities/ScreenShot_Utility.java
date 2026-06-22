package Utilities;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

public class ScreenShot_Utility {
	public static void capture(WebDriver driver,String name)
            throws Exception {

        TakesScreenshot ts=(TakesScreenshot) driver;

        File src=ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(src,
                new File("./Screenshots/"+name+".png"));
    }
}