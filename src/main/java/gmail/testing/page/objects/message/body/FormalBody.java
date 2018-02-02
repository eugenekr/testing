package gmail.testing.page.objects.message.body;

import gmail.testing.page.objects.message.BodyType;
import org.apache.commons.lang3.text.StrBuilder;

/**
 * Created by HP on 2/1/2018.
 */
public class FormalBody implements BodyType {

    public String setBody() {
        StrBuilder builder = new StrBuilder();
        builder.append("Dear receiver," + "\n");
        builder.append("\n");
        builder.append("You've received formal email" + "\n");
        builder.append("\n");
        builder.append("Best regards," + "\n");
        builder.append("GmailTest" + "\n");
        return builder.toString();
    }

}
