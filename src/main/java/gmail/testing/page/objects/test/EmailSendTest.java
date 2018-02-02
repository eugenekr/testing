package gmail.testing.page.objects.test;

import gmail.testing.page.objects.AccountPage;
import gmail.testing.page.objects.LoginPage;
import gmail.testing.page.objects.base.BaseGmailTest;
import gmail.testing.page.objects.enums.Users;
import gmail.testing.page.objects.message.EmailMessage;
import gmail.testing.page.objects.message.FormalMessage;
import gmail.testing.page.objects.message.SpamMessage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by HP on 2/1/2018.
 */
public class EmailSendTest extends BaseGmailTest {

    private AccountPage accountPage;
    private EmailMessage emailMessage = new SpamMessage();

    @BeforeMethod
    public void logIn() {
        emailMessage.setReceiverAddress(Users.ALTERNATIVE_USER.getEmailAddress());
        accountPage = loginPage.loginToGmail(Users.MAIN_USER);
    }

    @Test
    public void isEmailSent() {
        accountPage.sendEmail(emailMessage);
        Assert.assertTrue(accountPage.isViewMessageLinkDisplayed(), "Message was not sent");
    }
}
