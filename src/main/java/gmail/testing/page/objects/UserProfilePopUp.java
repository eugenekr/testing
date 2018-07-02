package gmail.testing.page.objects;

import gmail.testing.page.objects.base.BaseGmailPage;
import gmail.testing.page.objects.utills.GmailTestUtills;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by HP on 5/6/2018.
 */
public class UserProfilePopUp extends BaseGmailPage {

    @FindBy(xpath = "//a[contains (@href, 'Logout')]")
    private WebElement signOutButton;

    @FindBy(xpath = "//a[contains (@href, 'AddSession')]")
    private WebElement addAccountButton;

    public LoginPage signOut() {
        signOutButton.click();
        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present. Exception: " + e.getMessage());
        }
        GmailTestUtills.waitForPageLoadIsComplete();
        return new LoginPage(driver);
    }

    public UserProfilePopUp(WebDriver driver) {
        super(driver);
    }
}
