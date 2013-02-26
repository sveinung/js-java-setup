package employee;

import validation.FormValidator;
import validation.Messages;

public class EmployeesValidator extends FormValidator<Employees> {

    private final EmployeeValidator employeeValidator;

    public EmployeesValidator() {
        employeeValidator = new EmployeeValidator();
    }

    @Override
    public Messages validate(Employees employees) {
        Messages messages = new Messages();

        int index = 0;
        for (Employee employee : employees.getEmployees()) {
            messages.addAll(employeeValidator.validate(employee), "employees[" + index + "]");
            index++;
        }

        return messages;
    }
}
