package validation;

import java.util.ArrayList;
import java.util.List;

public abstract class FormValidator<T> {
    public abstract Messages validate(T t);

    public void validateAndThrow(T t) {
        Messages messages = validate(t);
        if (!messages.getMessages().isEmpty()) {
            throw new ValidationException(messages);
        }
    }
}
