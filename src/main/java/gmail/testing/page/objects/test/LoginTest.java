package gmail.testing.page.objects.test;

import gmail.testing.page.objects.AccountPage;
import gmail.testing.page.objects.base.BaseGmailTest;
import gmail.testing.page.objects.enums.Users;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by HP on 1/31/2018.
 */
public class LoginTest extends BaseGmailTest {

    @Test
    public void login() {
        AccountPage accountPage = loginPage.loginToGmail(Users.MAIN_USER);
        Assert.assertTrue(accountPage.isUserIconPresent(), "Login failed");
    }
}
