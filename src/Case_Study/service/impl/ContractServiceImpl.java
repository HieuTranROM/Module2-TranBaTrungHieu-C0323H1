package Case_Study.service.impl;

import Case_Study.common.InvalidInputException;
import Case_Study.models.Contract;
import Case_Study.repositories.BookingRepo;
import Case_Study.repositories.ContractRepo;
import Case_Study.service.ContractService;
import Case_Study.common.RegexPartern;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ContractServiceImpl implements ContractService {
    private ContractRepo contractRepo;
    private BookingRepo bookingRepo = new BookingRepo();

    public ContractServiceImpl() {
        this.contractRepo = new ContractRepo();
    }

    @Override
    public void addContract() throws InvalidInputException, IOException {
        Scanner scanner = new Scanner(System.in);
        String contractId;

        while (true) {
            System.out.println("Enter contract ID: ");
            contractId = scanner.nextLine();
            if (!RegexPartern.validateContractId(contractId)) {
                System.out.println("Invalid contract ID. Must be in the format CT-XXX");
                continue;
            }
            if (contractRepo.isDuplicateId(contractId)) {
                System.out.println("Contract ID already exists. Please enter a unique ID.");
            } else {
                break;
            }
        }

        String bookingId;
        while (true) {
            System.out.print("Enter booking ID: ");
            bookingId = scanner.nextLine();
            if (!isValidBookingId(bookingId)) {
                System.out.println("Invalid booking ID. Please enter a valid booking ID.");
            } else {
                break;
            }
        }

        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();

        System.out.print("Enter deposit amount: ");
        double depositAmount = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter total amount: ");
        double totalAmount = Double.parseDouble(scanner.nextLine());

        Contract contract = new Contract(contractId, bookingId, customerId, depositAmount, totalAmount);
        List<Contract> contracts = contractRepo.getAllContracts();
        contracts.add(contract);
        contractRepo.saveContracts(contracts);
        System.out.println("New contract added successfully.");
    }

    private boolean isValidBookingId(String bookingId) {
        return bookingRepo.getAllBookings().stream().anyMatch(booking -> booking.getBookingId().equals(bookingId));
    }

    @Override
    public void deleteContract(String id) throws IOException {
        List<Contract> contracts = contractRepo.getAllContracts();
        boolean removed = contracts.removeIf(contract -> contract.getContractId().equals(id));
        if (removed) {
            contractRepo.saveContracts(contracts);
            System.out.println("Contract with ID " + id + " deleted successfully.");
        } else {
            System.out.println("Contract with ID " + id + " not found.");
        }
    }

    @Override
    public List<Contract> getAllContracts() {
        return contractRepo.getAllContracts();
    }
}
