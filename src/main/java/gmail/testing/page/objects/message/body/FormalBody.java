package gmail.testing.page.objects.message.body;

import gmail.testing.page.objects.message.BodyType;

/**
 * Created by HP on 2/1/2018.
 */
public class FormalBody implements BodyType {

    public String setBody() {
        StringBuilder builder = new StringBuilder();
        builder.append("Dear receiver," + "\n");
        builder.append("\n");
        builder.append("You've received formal email" + "\n");
        builder.append("\n");
        builder.append("Best regards," + "\n");
        builder.append("GmailTest" + "\n");
        return builder.toString();
    }

}
