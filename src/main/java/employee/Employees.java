package employee;

import java.util.List;

public class Employees {

    private final List<Employee> employees;

    public Employees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
