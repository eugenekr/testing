package gmail.testing.page.objects.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.ws.handler.LogicalHandler;

/**
 * Created by HP on 2/2/2018.
 */
public class WebDriverSingleton {

    private static volatile ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();

    private WebDriverSingleton() {
    }

    public static WebDriver getWebDriver() {

        if (threadLocalDriver.get() == null) {
            synchronized (WebDriverSingleton.class) {
                if (threadLocalDriver.get() == null) {
                    threadLocalDriver.set(new ChromeDriver());
                }
            }
        }
        return threadLocalDriver.get();
    }
}
