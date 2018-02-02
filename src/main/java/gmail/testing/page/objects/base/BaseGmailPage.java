package gmail.testing.page.objects.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by HP on 1/31/2018.
 */
public class BaseGmailPage extends Assert{

    protected WebDriver driver;

    public BaseGmailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
