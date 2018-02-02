package gmail.testing.page.objects.message.body;

import gmail.testing.page.objects.message.BodyType;
import gmail.testing.page.objects.message.InformalMessage;
import org.apache.commons.lang3.text.StrBuilder;

/**
 * Created by HP on 2/1/2018.
 */
public class InformalBody implements BodyType {

    public String setBody() {
        StrBuilder builder = new StrBuilder();
        builder.append("How ur doing?," + "\n");
        builder.append("\n");
        builder.append("Wanna hangout tmr? What u say" + "\n");
        builder.append("\n");
        builder.append("See ya man," + "\n");
        builder.append("bb" + "\n");
        return builder.toString();
    }

}
