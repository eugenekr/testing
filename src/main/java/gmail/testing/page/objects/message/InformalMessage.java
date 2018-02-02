package gmail.testing.page.objects.message;

import gmail.testing.page.objects.message.body.InformalBody;
import gmail.testing.page.objects.message.subject.InformalSubject;

/**
 * Created by HP on 2/1/2018.
 */
public class InformalMessage extends EmailMessage {

    public InformalMessage() {
        bodyType = new InformalBody();
        subjectType = new InformalSubject();
    }
}
