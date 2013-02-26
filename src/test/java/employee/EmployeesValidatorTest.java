package employee;

import org.junit.Before;
import org.junit.Test;
import validation.Message;
import validation.ValidationException;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class EmployeesValidatorTest {

    private EmployeesValidator validator;

    @Before
    public void setUp() {
        validator = new EmployeesValidator();
    }

    @Test
    public void should_validate_form() {
        validator.validateAndThrow(new Employees(asList(new Employee("Gunnar"), new Employee("Ola"))));
    }

    @Test
    public void should_not_validate_employee_with_funky_name() {
        try {
            validator.validateAndThrow(new Employees(asList(new Employee("Gunnar"), new Employee("$"))));

            fail();
        } catch (ValidationException e) {
            List<Message> messages = e.getMessages();

            assertEquals(1, messages.size());
            assertEquals("employees[1].name",
                         messages.get(0).getField());
        }
    }

    @Test
    public void should_not_validate_multiple_funky_names() {
        try {
            validator.validateAndThrow(new Employees(asList(new Employee("$"), new Employee("$"))));

            fail();
        } catch (ValidationException e) {
            List<Message> messages = e.getMessages();

            assertEquals(2, messages.size());
            assertEquals("employees[0].name",
                         messages.get(0).getField());
            assertEquals("employees[1].name",
                         messages.get(1).getField());
        }
    }
}
