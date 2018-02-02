package gmail.testing.page.objects.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by HP on 2/2/2018.
 */
public class WebDriverSingleton {
    private static WebDriver driver;


    private WebDriverSingleton() {
    }

    public static WebDriver getWebDriver() {
        if (driver==null){
            System.setProperty("webdriver.chrome.driver", "./src/chromedriver.exe");
            driver = new ChromeDriver();

        }
        return driver;
    }
}
