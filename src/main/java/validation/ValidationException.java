package validation;

import java.util.List;

public class ValidationException extends RuntimeException {
    private List<Message> messages;

    public ValidationException(Messages messages) {
        this.messages = messages.getMessages();
    }

    public List<Message> getMessages() {
        return messages;
    }
}
