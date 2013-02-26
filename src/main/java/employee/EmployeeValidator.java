package employee;

import validation.FormValidator;
import validation.Message;
import validation.Messages;

public class EmployeeValidator extends FormValidator<Employee> {

    @Override
    public Messages validate(Employee employee) {
        Messages messages = new Messages();

        if ("$".equals(employee.getName())) {
            messages.add(new Message("name", "NAME_EQUALS_DOLLAR_SIGN"), "name");
        }

        return messages;
    }
}
