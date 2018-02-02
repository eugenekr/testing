package gmail.testing.page.objects;

import gmail.testing.page.objects.base.BaseGmailPage;
import gmail.testing.page.objects.message.EmailMessage;
import gmail.testing.page.objects.utills.GmailTestUtills;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.TestException;

import java.util.Collections;

/**
 * Created by HP on 1/31/2018.
 */
public class AccountPage extends BaseGmailPage{

    @FindBy(xpath = "//a[contains (@title, 'Google Account: ')]")
    private WebElement userIcon;

    @FindBy(xpath = "//div[@gh= 'cm']")
    private WebElement composeButton;

    @FindBy(name = "to")
    private WebElement toInput;

    @FindBy(name = "subjectbox")
    private WebElement subjectInput;

    @FindBy(xpath = "//div[@aria-label = 'Message Body']")
    private WebElement bodyInput;

    @FindBy(xpath = "//div[contains (@data-tooltip, 'Send')]")
    private WebElement sendButton;

    @FindBy(id = "link_vsm")
    private WebElement viewSentMessageLink;

    @FindBy(xpath = "//div[@class = 'vh']//span[@class = 'v1']")
    private WebElement loadingNotification;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getUserIcon() {
        return userIcon;
    }

    public WebElement getViewMessageLink() {
        return viewSentMessageLink;
    }

    public boolean isViewMessageLinkDisplayed() {
        return viewSentMessageLink.isDisplayed();
    }

    public boolean isUserIconPresent() {
        return getUserIcon().isDisplayed();
    }

    public void sendEmail(EmailMessage emailMessage) {
        openNewMessageDialog();
        enterRecipientAddress(emailMessage.getReceiverAddress());
        enterSubject(emailMessage.getSubject());
        enterBody(emailMessage.getBody());
        clickSendButton(emailMessage);
    }

    private void openNewMessageDialog() {
        composeButton.click();
        GmailTestUtills.waitForElementToBeVisible(driver, toInput);
    }

    private void clickSendButton(EmailMessage message) {
        sendButton.click();
        if (message.getBody() == null && message.getSubject() == null) {
            driver.switchTo().alert().accept();
        }
    }

    private void enterBody(String body) {
        if (body != null) {
            bodyInput.sendKeys(body);
        }
    }

    private void enterSubject(String subject) {
        if (subject != null) {
            subjectInput.sendKeys(subject);
        }
    }

    private void enterRecipientAddress(String emailAddress) {
        GmailTestUtills.waitForElementToBeNotVisible(driver, Collections.singletonList(loadingNotification));
        if (emailAddress != null) {
            toInput.sendKeys(emailAddress);
        } else {
            throw new TestException("Email address cannot be null");
        }
    }
}
