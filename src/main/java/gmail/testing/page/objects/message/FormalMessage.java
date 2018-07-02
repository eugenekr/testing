package gmail.testing.page.objects.message;

import gmail.testing.page.objects.message.body.FormalBody;
import gmail.testing.page.objects.message.subject.FormalSubject;

/**
 * Created by HP on 2/1/2018.
 */
public class FormalMessage extends EmailMessage {

    public FormalMessage() {
        bodyType = new FormalBody();
        subjectType = new FormalSubject();
    }
}
