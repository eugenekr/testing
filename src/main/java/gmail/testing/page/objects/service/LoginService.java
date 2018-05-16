package gmail.testing.page.objects.service;

import gmail.testing.page.objects.AccountPage;
import gmail.testing.page.objects.LoginPage;
import gmail.testing.page.objects.UserProfilePopUp;
import gmail.testing.page.objects.base.BaseGmailTest;
import gmail.testing.page.objects.enums.Users;

/**
 * Created by HP on 5/6/2018.
 */
public class LoginService extends BaseGmailTest {

    public static AccountPage reLoginAsUser(Users user, AccountPage accountPage) {
        UserProfilePopUp userProfilePopUp = accountPage.openUserProfilePopUp();
        LoginPage loginPage = userProfilePopUp.signOut();
        loginPage.switchAccount();
        loginPage.loginToGmail(user);
        return accountPage;
    }
}
