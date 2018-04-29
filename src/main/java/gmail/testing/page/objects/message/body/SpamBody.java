package gmail.testing.page.objects.message.body;

import gmail.testing.page.objects.message.BodyType;

/**
 * Created by HP on 2/1/2018.
 */
public class SpamBody implements BodyType {

    public String setBody() {
        StringBuilder builder = new StringBuilder();
        builder.append("Mr/Ms don't miss a change to get a discount at our new store," + "\n");
        builder.append("\n");
        builder.append("For more details please visit our website." + "\n");
        builder.append("\n");
        builder.append("Thank you," + "\n");
        builder.append("Regards" + "\n");
        return builder.toString();
    }
}
