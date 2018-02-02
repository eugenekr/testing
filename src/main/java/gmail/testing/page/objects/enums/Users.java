package gmail.testing.page.objects.enums;

/**
 * Created by HP on 2/1/2018.
 */
public enum Users {
    MAIN_USER("eugene.krasotski@gmail.com", "11235813f"),
    ALTERNATIVE_USER("ykrasot11@students.lcc.lt", "5213420yauheni");

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
