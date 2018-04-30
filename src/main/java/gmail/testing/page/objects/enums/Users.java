package gmail.testing.page.objects.enums;

/**
 * Created by HP on 2/1/2018.
 */
public enum Users {
    MAIN_USER("eugeneTestUserNumberOne@gmail.com", "11235813f"),
    ALTERNATIVE_USER("eugeneTestUserNumberTwo@gmail.com", "11235813f");

    private String emailAddress;
    private String password;

    Users(String emailAddress, String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }
}
