package validation;

import java.util.ArrayList;
import java.util.List;

public abstract class FormValidator<T> {
    public abstract List<Message> validate(T t);

    public void validateAndThrow(T t) {
        List<Message> messages = validate(t);
        if (!messages.isEmpty()) {
            throw new ValidationException(messages);
        }
    }

    protected List<Message> collectMessages(Message... messages) {
        List<Message> collected = new ArrayList<Message>();
        for (Message message : messages) {
            if (message != null) {
                collected.add(message);
            }
        }
        return collected;
    }
}
