package gmail.testing.page.objects.message;

import gmail.testing.page.objects.message.body.SpamBody;
import gmail.testing.page.objects.message.subject.SpamSubject;

/**
 * Created by HP on 2/1/2018.
 */
public class SpamMessage extends EmailMessage {

    public SpamMessage() {
        bodyType = new SpamBody();
        subjectType = new SpamSubject();
    }

}
