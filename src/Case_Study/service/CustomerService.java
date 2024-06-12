package Case_Study.service;

import Case_Study.common.InvalidInputException;
import Case_Study.models.Customer;

import java.io.IOException;
import java.util.List;

public interface CustomerService {
    void addCustomer() throws InvalidInputException, IOException;

    void deleteCustomer(String id) throws IOException;

    List<Customer> getAllCustomers();
}

