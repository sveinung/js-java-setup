package employee;

import validation.FormValidator;
import validation.Message;

import java.util.ArrayList;
import java.util.List;

public class EmployeeValidator extends FormValidator<Employee> {

    @Override
    public List<Message> validate(Employee employee) {
        List<Message> messages = new ArrayList<Message>();

        System.out.println(employee.getName());

        if ("$".equals(employee.getName())) {
            messages.add(new Message("name", "NAME_EQUALS_DOLLAR_SIGN"));
        }

        return messages;
    }
}
