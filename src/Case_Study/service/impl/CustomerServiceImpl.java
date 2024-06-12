package Case_Study.service.impl;

import Case_Study.common.InvalidInputException;
import Case_Study.models.Customer;
import Case_Study.repositories.CustomerRepo;
import Case_Study.service.CustomerService;
import Case_Study.common.RegexPartern;

import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepo customerRepo = new CustomerRepo();

    @Override
    public void addCustomer() throws InvalidInputException {
        Scanner scanner = new Scanner(System.in);
        String id;
        while (true) {
            System.out.print("Enter customer ID: ");
            id = scanner.nextLine();
            if (!RegexPartern.validateCustomerId(id)) {
                System.out.println("Invalid Customer ID format. Must be in the format C-XXX");
                continue;
            }
            if (customerRepo.isDuplicateId(id)) {
                System.out.println("Customer ID already exists. Please enter a unique ID.");
            } else {
                break;
            }
        }

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        if (!RegexPartern.validateName(name)) {
            throw new InvalidInputException("Invalid name format.");
        }

        System.out.print("Enter customer date of birth (dd/MM/yyyy): ");
        String dob = scanner.nextLine();
        if (!RegexPartern.validateDate(dob)) {
            throw new InvalidInputException("Invalid date format.");
        }

        String gender;
        while (true) {
            System.out.print("Enter customer gender (F for Female, M for Male): ");
            gender = scanner.nextLine();
            if (gender.equalsIgnoreCase("F")) {
                gender = "Female";
                break;
            } else if (gender.equalsIgnoreCase("M")) {
                gender = "Male";
                break;
            } else {
                System.out.println("Invalid gender. Please enter 'F' for Female or 'M' for Male.");
            }
        }

        System.out.print("Enter customer ID card: ");
        String idCard = scanner.nextLine();
        if (!RegexPartern.validateIdCard(idCard)) {
            throw new InvalidInputException("Invalid ID card format.");
        }

        System.out.print("Enter customer phone number: ");
        String phoneNumber = scanner.nextLine();
        if (!RegexPartern.validatePhone(phoneNumber)) {
            throw new InvalidInputException("Invalid phone number format.");
        }

        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();
        if (!RegexPartern.validateEmail(email)) {
            throw new InvalidInputException("Invalid email format.");
        }

        System.out.print("Enter customer type: ");
        String customerType = scanner.nextLine();

        System.out.print("Enter customer address: ");
        String address = scanner.nextLine();

        Customer customer = new Customer(id, name, dob, gender, idCard, phoneNumber, email, customerType, address);
        List<Customer> customers = customerRepo.getAllCustomers();
        customers.add(customer);
        customerRepo.saveCustomers(customers);

        System.out.println("New customer added successfully.");
    }

    @Override
    public void deleteCustomer(String id) {
        List<Customer> customers = customerRepo.getAllCustomers();
        customers.removeIf(customer -> customer.getId().equals(id));
        customerRepo.saveCustomers(customers);
        System.out.println("Customer with ID " + id + " deleted successfully.");
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.getAllCustomers();
    }
}
