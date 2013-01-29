package validation;

import dto.FormDTO;

import java.util.ArrayList;
import java.util.List;

public class ConcreteFormValidator extends FormValidator<FormDTO> {
    private NumericStringValidator numericStringValidator;

    public ConcreteFormValidator(NumericStringValidator numericStringValidator) {
        this.numericStringValidator = numericStringValidator;
    }

    @Override
    public List<Message> validate(FormDTO form) {
        return collectMessages(this.numericStringValidator.validate(form.getA(), "first"),
                               this.numericStringValidator.validate(form.getB(), "second"));
    }
}
