package gmail.testing.page.objects;

import gmail.testing.page.objects.base.BaseGmailPage;
import gmail.testing.page.objects.enums.Users;
import gmail.testing.page.objects.message.EmailMessage;
import gmail.testing.page.objects.utills.GmailTestUtills;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.TestException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by HP on 1/31/2018.
 */
public class AccountPage extends BaseGmailPage{

    @FindBy(xpath = "//a[contains (@title, 'Google Account: ')]")
    private WebElement userIcon;

    @FindBy(xpath = "//span[@email]")
    private List<WebElement> emailAddressList;

    @FindBy(xpath = "//span[@class = 'bog']/following-sibling::span")
    private List<WebElement> messageContentList;

    @FindBy(xpath = "//span[@class = 'bog']")
    private List<WebElement> subjectContentList;

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

    public UserProfilePopUp openUserProfilePopUp() {
        userIcon.click();
        return new UserProfilePopUp(driver);
    }

    public void sendEmail(EmailMessage emailMessage) {
        openNewMessageDialog();
        enterRecipientAddress(emailMessage.getReceiverAddress());
        enterSubject(emailMessage.getSubject());
        enterBody(emailMessage.getBody());
        clickSendButton(emailMessage);
    }

    private void openNewMessageDialog() {
        logger.info("Open new message dialog");
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

    public boolean getIncommingEmailList() {
        return emailAddressList.stream().map(e -> e.getAttribute("email"))
                .collect(Collectors.toList())
                .contains(Users.MAIN_USER.getEmailAddress().toLowerCase())
                &&
                messageContentList.stream().map(e -> e.getAttribute("class"))
                        .collect(Collectors.toList())
                        .contains(Users.MAIN_USER.getEmailAddress().toLowerCase());
    }
}
