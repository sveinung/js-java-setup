package employee;

import validation.FormValidator;
import validation.Message;

import java.util.ArrayList;
import java.util.List;

public class EmployeesValidator extends FormValidator<Employees> {

    private final EmployeeValidator employeeValidator;

    public EmployeesValidator() {
        employeeValidator = new EmployeeValidator();
    }

    @Override
    public List<Message> validate(Employees employees) {
        List<Message> messages = new ArrayList<Message>();

        for (Employee employee : employees.getEmployees()) {
            messages.addAll(employeeValidator.validate(employee));
        }

        return messages;
    }
}
