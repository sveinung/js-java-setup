package dto;

import org.junit.Before;
import org.junit.Test;
import validation.Message;
import validation.MessageType;
import validation.ResourceValidationException;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

public class ConcreteFormValidatorTest {

    private ConcreteFormValidator formValidator;

    @Before
    public void setUp() {
        formValidator = new ConcreteFormValidator(new NumericStringValidator());
    }

    @Test
    public void should_validate() {
        List<Message> messages = formValidator.validate(new FormDTO("a", "1"));

        assertEquals(messages.size(), 1);

        assertEquals(messages.get(0).getField(), "first");
        assertEquals(messages.get(0).getKey(), "some.error.string");
        assertEquals(messages.get(0).getValue(), "a");
        assertEquals(messages.get(0).getType(), MessageType.FAILED);
    }

    @Test
    public void should_throw() {
        try {
            formValidator.validateAndThrow(new FormDTO("a", "1"));

            fail();
        } catch (ResourceValidationException e) {
            List<Message> messages = e.getMessages();
            assertEquals(messages.size(), 1);

            assertEquals(messages.get(0).getField(), "first");
            assertEquals(messages.get(0).getKey(), "some.error.string");
            assertEquals(messages.get(0).getValue(), "a");
            assertEquals(messages.get(0).getType(), MessageType.FAILED);
        }
    }

    @Test
    public void should_pass() {
        formValidator.validateAndThrow(new FormDTO("1", "3"));
    }
}
