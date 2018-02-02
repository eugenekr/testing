package gmail.testing.page.objects.message.subject;

import gmail.testing.page.objects.message.FormalMessage;
import gmail.testing.page.objects.message.SubjectType;

/**
 * Created by HP on 2/1/2018.
 */
public class FormalSubject implements SubjectType{

    public String setSubject() {
        return "Dear Receiver. This is formal subject";
    }
}
