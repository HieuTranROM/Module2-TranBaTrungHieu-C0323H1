package Case_Study.repositories;

import Case_Study.models.Employee;
import Case_Study.utils.CSVUltils;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo {
    private final String filePath = "D:\\CodegymFT\\module2\\src\\Case_Study\\data\\employee.csv";

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        List<String> lines = CSVUltils.read(filePath);
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length == 9) {
                Employee employee = new Employee(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], Integer.parseInt(parts[8]));
                employees.add(employee);
            } else {
                System.err.println("Invalid line format: " + line);
            }
        }
        return employees;
    }

    public void saveEmployees(List<Employee> employees) {
        List<String> lines = new ArrayList<>();
        for (Employee employee : employees) {
            String line = String.join(",", employee.getId(), employee.getName(), employee.getBirthDate(), employee.getGender(),
                    employee.getIdCard(), employee.getPhoneNumber(), employee.getEmail(), employee.getPosition(),
                    String.valueOf(employee.getSalary()));
            lines.add(line);
        }
        CSVUltils.write(filePath, lines);
    }

    public boolean isDuplicateId(String id) {
        List<Employee> employees = getAllEmployees(); // Ensure employees list is initialized
        return employees.stream().anyMatch(employee -> employee.getId().equals(id));
    }
}
