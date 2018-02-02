package gmail.testing.page.objects.test;

import gmail.testing.page.objects.AccountPage;
import gmail.testing.page.objects.LoginPage;
import gmail.testing.page.objects.base.BaseGmailTest;
import gmail.testing.page.objects.enums.Users;
import gmail.testing.page.objects.message.EmailMessage;
import gmail.testing.page.objects.message.FormalMessage;
import gmail.testing.page.objects.message.InformalMessage;
import gmail.testing.page.objects.message.SpamMessage;
import gmail.testing.page.objects.user.User;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by HP on 1/31/2018.
 */
public class LoginTest extends BaseGmailTest {

    private AccountPage accountPage = new AccountPage(driver);

    @Test
    public void login() {
        accountPage = loginPage.loginToGmail(Users.MAIN_USER);
        Assert.assertTrue(accountPage.isUserIconPresent(), "Login failed");
    }
}
