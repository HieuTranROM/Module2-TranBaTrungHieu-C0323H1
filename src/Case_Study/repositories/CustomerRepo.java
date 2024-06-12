package Case_Study.repositories;

import Case_Study.models.Customer;
import Case_Study.utils.CSVUltils;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepo {
    private final String filePath = "D:\\CodegymFT\\module2\\src\\Case_Study\\data\\customer.csv";

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        List<String> lines = CSVUltils.read(filePath);
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length == 9) {
                Customer customer = new Customer(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], parts[8]);
                customers.add(customer);
            } else {
                System.err.println("Invalid line format: " + line);
            }
        }
        return customers;
    }

    public void saveCustomers(List<Customer> customers) {
        List<String> lines = new ArrayList<>();
        for (Customer customer : customers) {
            String line = String.join(",", customer.getId(), customer.getName(), customer.getBirthDate(), customer.getGender(),
                    customer.getIdCard(), customer.getPhoneNumber(), customer.getEmail(), customer.getType(), customer.getAddress());
            lines.add(line);
        }
        CSVUltils.write(filePath, lines);
    }

    public boolean isDuplicateId(String id) {
        List<Customer> customers = getAllCustomers();
        return customers.stream().anyMatch(customer -> customer.getId().equals(id));
    }
}
