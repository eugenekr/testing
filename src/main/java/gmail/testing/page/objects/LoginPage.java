package gmail.testing.page.objects;

import gmail.testing.page.objects.base.BaseGmailPage;
import gmail.testing.page.objects.enums.Users;
import gmail.testing.page.objects.utills.GmailTestUtills;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by HP on 1/31/2018.
 */
public class LoginPage extends BaseGmailPage{

    @FindBy(xpath = "//div[@aria-label = 'Switch account']")
    private WebElement switchAccountButton;

    @FindBy(xpath = "//div[@id = 'identifierLink']/child::div[not(@aria-hidden = 'true')]/p")
    private WebElement useAnotherAccountButton;

    @FindBy(id = "identifierId")
    private WebElement emailAddressInput;

    @FindBy(xpath = "//*[contains (@id, 'Next')]")
    private WebElement nextButton;

    @FindBy(id = "passwordNext")
    private WebElement passwordNextButton;

    @FindBy(name = "password")
    private WebElement passwordInput;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage switchAccount() {
        switchAccountButton.click();
        GmailTestUtills.waitForElementToBeVisible(driver, useAnotherAccountButton);
        useAnotherAccountButton.click();
        return this;
    }

    private void enterEmailAddress(String password) {
        emailAddressInput.sendKeys(password);
        nextButton.click();
    }

    private void enterPassword(String password) {
        passwordInput.sendKeys(password);
        GmailTestUtills.waitForElementToBeVisible(driver, nextButton);
        passwordNextButton.click();
    }

    public AccountPage loginToGmail(Users user) {
        enterEmailAddress(user.getEmailAddress());
        enterPassword(user.getPassword());
        GmailTestUtills.waitForPageLoadIsComplete();
        return new AccountPage(driver);
    }
}
