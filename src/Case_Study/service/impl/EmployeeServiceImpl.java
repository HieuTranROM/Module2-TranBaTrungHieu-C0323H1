package Case_Study.service.impl;

import Case_Study.common.InvalidInputException;
import Case_Study.models.Employee;
import Case_Study.repositories.EmployeeRepo;
import Case_Study.service.EmployeeService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepo employeeRepo = new EmployeeRepo();

    @Override
    public void addEmployee() throws InvalidInputException, IOException {
        Scanner scanner = new Scanner(System.in);
        String id;
        while (true) {
            System.out.print("Enter employee ID: ");
            id = scanner.nextLine();
            if (employeeRepo.isDuplicateId(id)) {
                System.out.println("Employee ID already exists. Please enter a unique ID.");
            } else {
                break;
            }
        }

        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter employee birth date (dd/MM/yyyy): ");
        String birthDate = scanner.nextLine();

        System.out.print("Enter employee gender: ");
        String gender = scanner.nextLine();

        System.out.print("Enter employee ID card: ");
        String idCard = scanner.nextLine();

        System.out.print("Enter employee phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter employee email: ");
        String email = scanner.nextLine();

        System.out.print("Enter employee position: ");
        String position = scanner.nextLine();

        System.out.print("Enter employee salary: ");
        int salary = Integer.parseInt(scanner.nextLine());

        Employee employee = new Employee(id, name, birthDate, gender, idCard, phoneNumber, email, position, salary);
        List<Employee> employees = employeeRepo.getAllEmployees();
        employees.add(employee);
        employeeRepo.saveEmployees(employees);

        System.out.println("New employee added successfully.");
    }

    @Override
    public void deleteEmployee(String id) throws IOException {
        List<Employee> employees = employeeRepo.getAllEmployees();
        employees.removeIf(employee -> employee.getId().equals(id));
        employeeRepo.saveEmployees(employees);
        System.out.println("Employee with ID " + id + " deleted successfully.");
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.getAllEmployees();
    }
}
