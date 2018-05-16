package gmail.testing.page.objects.utills;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by HP on 2/1/2018.
 */
public class GmailTestUtills {

    public static void waitForElementToBeVisible(WebDriver webdriver, WebElement element) {

        Wait<WebDriver> wait = new FluentWait<WebDriver>(webdriver)
                .withTimeout(Duration.ofSeconds(20, 10))
                .pollingEvery(Duration.ofSeconds(1,10))
                .ignoring(ElementNotVisibleException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(WebDriverException.class)
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementToBeNotVisible(WebDriver webdriver, List<WebElement> elementList) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(webdriver)
                .withTimeout(Duration.ofSeconds(20, 10))
                .pollingEvery(Duration.ofSeconds(1, 10));

        wait.until(ExpectedConditions.invisibilityOfAllElements(elementList));
    }

    public static void waitForPageLoadIsComplete() {
        ExpectedCondition<Boolean> pageLoadFinished = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .equals("complete");
            }
        };

    }
}
