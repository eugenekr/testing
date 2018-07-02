package gmail.testing.page.objects.test;

import gmail.testing.page.objects.AccountPage;
import gmail.testing.page.objects.base.BaseGmailTest;
import gmail.testing.page.objects.enums.Users;
import gmail.testing.page.objects.message.EmailMessage;
import gmail.testing.page.objects.message.FormalMessage;
import gmail.testing.page.objects.service.LoginService;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by HP on 5/16/2018.
 */
public class ReceiveEmailTest extends BaseGmailTest {

    private EmailMessage emailMessage = new FormalMessage();

    @Test()
    public void isEmailReceived() {
        emailMessage.setReceiverAddress(Users.ALTERNATIVE_USER.getEmailAddress());
        AccountPage accountPage = loginPage.loginToGmail(Users.MAIN_USER);
        accountPage.sendEmail(emailMessage);
        LoginService.reLoginAsUser(Users.ALTERNATIVE_USER, accountPage);
    }
}
