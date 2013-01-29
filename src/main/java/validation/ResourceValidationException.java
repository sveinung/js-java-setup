package validation;

import java.util.List;

public class ResourceValidationException extends RuntimeException {
    private List<Message> messages;

    public ResourceValidationException(List<Message> messages) {
        this.messages = messages;
    }

    public List<Message> getMessages() {
        return messages;
    }
}
