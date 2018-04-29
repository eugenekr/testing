package gmail.testing.page.objects.message.body;

import gmail.testing.page.objects.message.BodyType;

/**
 * Created by HP on 2/1/2018.
 */
public class InformalBody implements BodyType {

    public String setBody() {
        StringBuilder builder = new StringBuilder();
        builder.append("How ur doing?," + "\n");
        builder.append("\n");
        builder.append("Wanna hangout tmr? What u say" + "\n");
        builder.append("\n");
        builder.append("See ya man," + "\n");
        builder.append("bb" + "\n");
        return builder.toString();
    }

}
