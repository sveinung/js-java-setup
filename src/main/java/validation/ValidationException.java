package validation;

import java.util.List;

public class ValidationException extends RuntimeException {
    private List<Message> messages;

    public ValidationException(List<Message> messages) {
        this.messages = messages;
    }

    public List<Message> getMessages() {
        return messages;
    }
}
