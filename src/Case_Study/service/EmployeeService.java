package Case_Study.service;

import Case_Study.common.InvalidInputException;
import Case_Study.models.Employee;

import java.io.IOException;
import java.util.List;

public interface EmployeeService {
    void addEmployee() throws InvalidInputException, IOException;

    void deleteEmployee(String id) throws IOException;

    List<Employee> getAllEmployees() throws IOException;
}



