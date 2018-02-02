package gmail.testing.page.objects.utills;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by HP on 2/2/2018.
 */
public class Screenshot {


    public static void takeScreenshot(WebDriver driver, String screenshotName) {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source, new File("./Screenshots/"+screenshotName+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
