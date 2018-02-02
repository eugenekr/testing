package gmail.testing.page.objects.base;

import gmail.testing.page.objects.AccountPage;
import gmail.testing.page.objects.LoginPage;
import gmail.testing.page.objects.driver.DriverDecorator;
import gmail.testing.page.objects.driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by HP on 1/31/2018.
 */
public class BaseGmailTest {

    protected AccountPage accountPage;
    protected LoginPage loginPage;
    protected final String MAIN_URL = "https://gmail.com/";
    protected WebDriver driver;


    @BeforeClass()
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/chromedriver.exe");
        //decorated driver
        driver= WebDriverSingleton.getWebDriver();
        driver = new DriverDecorator(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(MAIN_URL);
        loginPage = new LoginPage(driver);
    }

    @AfterClass()
    public void tearDown() {
        driver.close();
    }
}
