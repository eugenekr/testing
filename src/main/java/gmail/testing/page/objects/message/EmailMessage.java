package gmail.testing.page.objects.message;

/**
 * Created by HP on 2/1/2018.
 */
public abstract class EmailMessage {

    private String receiverAddress;
    protected BodyType bodyType;
    protected SubjectType subjectType;

    public EmailMessage() {
    }

    public String getBody() {
        return bodyType.setBody();
    }

    public String getSubject() {
        return subjectType.setSubject();
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }
}
