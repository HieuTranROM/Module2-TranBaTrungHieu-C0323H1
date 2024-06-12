package Case_Study.view;

import Case_Study.common.InvalidInputException;
import Case_Study.models.Booking;
import Case_Study.models.Contract;
import Case_Study.models.Customer;
import Case_Study.models.Employee;
import Case_Study.service.CustomerService;
import Case_Study.service.EmployeeService;
import Case_Study.service.impl.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ResortView {
    private static EmployeeService employeeService = new EmployeeServiceImpl();
    private static CustomerService customerService = new CustomerServiceImpl();
    private static BookingServiceImpl bookingService = new BookingServiceImpl();
    private static ContractServiceImpl contractService = new ContractServiceImpl();
    private static FacilityServiceImpl facilityService = new FacilityServiceImpl();

    public void renderView() throws IOException, InvalidInputException {
        System.out.println("RESORT MANAGEMENT");
        this.displayMainMenu();
    }

    public static void displayMainMenu() throws IOException, InvalidInputException {
        Scanner input = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("╔═══════════════════════════════════════════════════╗");
            System.out.println("║            MENU QUẢN LÝ RESORT CỦA HIẾU           ║");
            System.out.println("╠═══════════════════════════════════════════════════╣");
            System.out.println("║ Options:                                          ║");
            System.out.println("║  ▶ 1. Employee Management                         ║");
            System.out.println("║  ▶ 2. Customer Management                         ║");
            System.out.println("║  ▶ 3. Facility Management                         ║");
            System.out.println("║  ▶ 4. Booking Management                          ║");
            System.out.println("║  ▶ 5. Contract Management                         ║");
            System.out.println("║  ▶ 6. Exit                                        ║");
            System.out.println("╚═══════════════════════════════════════════════════╝");
            System.out.print("▶ Select function: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    displayEmployeeMenu();
                    break;
                case 2:
                    displayCustomerMenu();
                    break;
                case 3:
                    displayFacilityMenu();
                    break;
                case 4:
                    displayBookingMenu();
                    break;
                case 5:
                    displayContractMenu();
                    break;
                case 6:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                default:
                    System.out.println("Please select a valid number from the menu.");
            }
        }
    }

    public static void displayEmployeeMenu() throws IOException, InvalidInputException {
        boolean check = true;
        while (check) {
            System.out.println("╔═══════════════════════════════════════════════════╗");
            System.out.println("║            EMPLOYEE MANAGEMENT MENU               ║");
            System.out.println("╠═══════════════════════════════════════════════════╣");
            System.out.println("║ Options:                                          ║");
            System.out.println("║  ▶ 1. Display list of employees                   ║");
            System.out.println("║  ▶ 2. Add new employee                            ║");
            System.out.println("║  ▶ 3. Delete employee                             ║");
            System.out.println("║  ▶ 4. Return to main menu                         ║");
            System.out.println("╚═══════════════════════════════════════════════════╝");
            System.out.print("▶ Select function: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    List<Employee> employees = employeeService.getAllEmployees();
                    for (Employee employee : employees) {
                        System.out.println(employee);
                    }
                    break;
                case 2:
                    employeeService.addEmployee();
                    break;
                case 3:
                    System.out.print("Enter the ID of the employee to be deleted: ");
                    String id = scanner.nextLine();
                    employeeService.deleteEmployee(id);
                    break;
                case 4:
                    check = false;
                    break;
                default:
                    System.out.println("Please select a valid number from the menu.");
            }
        }
    }

    public static void displayCustomerMenu() throws InvalidInputException, IOException {
        boolean check = true;
        while (check) {
            System.out.println("╔═══════════════════════════════════════════════════╗");
            System.out.println("║            CUSTOMER MANAGEMENT MENU               ║");
            System.out.println("╠═══════════════════════════════════════════════════╣");
            System.out.println("║ Options:                                          ║");
            System.out.println("║  ▶ 1. Display list of customers                   ║");
            System.out.println("║  ▶ 2. Add new customer                            ║");
            System.out.println("║  ▶ 3. Delete customer                             ║");
            System.out.println("║  ▶ 4. Return to main menu                         ║");
            System.out.println("╚═══════════════════════════════════════════════════╝");
            System.out.print("▶ Select function: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    List<Customer> customers = customerService.getAllCustomers();
                    for (Customer customer : customers) {
                        System.out.println(customer);
                    }
                    break;
                case 2:
                    customerService.addCustomer();
                    break;
                case 3:
                    System.out.print("Enter the ID of the customer to delete: ");
                    String id = scanner.nextLine();
                    customerService.deleteCustomer(id);
                    break;
                case 4:
                    check = false;
                    break;
                default:
                    System.out.println("Please select a valid number from the menu.");
            }
        }
    }

    public static void displayFacilityMenu() throws IOException {
        boolean check = true;
        while (check) {
            System.out.println("╔═══════════════════════════════════════════════════╗");
            System.out.println("║            FACILITY MANAGEMENT MENU               ║");
            System.out.println("╠═══════════════════════════════════════════════════╣");
            System.out.println("║ Options:                                          ║");
            System.out.println("║  ▶ 1. Display list of facilities                  ║");
            System.out.println("║  ▶ 2. Add new facility                            ║");
            System.out.println("║  ▶ 3. Delete facility                             ║");
            System.out.println("║  ▶ 4. Return to main menu                         ║");
            System.out.println("╚═══════════════════════════════════════════════════╝");
            System.out.print("▶ Select function: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    facilityService.displayAllFacilities();
                    break;
                case 2:
                    displayAddFacilityMenu();
                    break;
                case 3:
                    // Delete facility
                    System.out.print("Enter the ID of the facility to be deleted: ");
                    String id = scanner.nextLine();
                    facilityService.deleteFacility(id);
                    break;
                case 4:
                    check = false;
                    break;
                default:
                    System.out.println("Please select a valid number from the menu.");
            }
        }
    }

    public static void displayAddFacilityMenu() throws IOException {
        System.out.println("╔═══════════════════════════════════════════════════╗");
        System.out.println("║            FACILITY MANAGEMENT MENU               ║");
        System.out.println("╠═══════════════════════════════════════════════════╣");
        System.out.println("║ Add New Facility:                                 ║");
        System.out.println("║  ▶ 1. Add New House                               ║");
        System.out.println("║  ▶ 2. Add New Villa                               ║");
        System.out.println("║  ▶ 4. Return to main menu                         ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");
        System.out.println("▶ Select option: ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option) {
            case 1: {
                try {
                    facilityService.addHouse();
                } catch (InvalidInputException e) {
                    System.out.println("Invalid input: " + e.getMessage());
                }
                break;
            }
            case 2: {
                try {
                    facilityService.addVilla();
                } catch (InvalidInputException e) {
                    System.out.println("Invalid input: " + e.getMessage());
                }
                break;
            }
            case 3: {
                displayAddFacilityMenu();
                break;
            }
            default:
                System.out.println("Invalid option. Please select again.");
        }
    }

    public static void displayBookingMenu() throws InvalidInputException, IOException {
        boolean check = true;
        while (check) {
            System.out.println("╔═══════════════════════════════════════════════════╗");
            System.out.println("║                 BOOKING MANAGEMENT MENU           ║");
            System.out.println("╠═══════════════════════════════════════════════════╣");
            System.out.println("║ Options:                                          ║");
            System.out.println("║  ▶ 1. Display list of bookings                    ║");
            System.out.println("║  ▶ 2. Add new booking                             ║");
            System.out.println("║  ▶ 3. Delete booking                              ║");
            System.out.println("║  ▶ 4. Return to main menu                         ║");
            System.out.println("╚═══════════════════════════════════════════════════╝");
            System.out.print("▶ Select function: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    List<Booking> bookings = bookingService.getAllBookings();
                    for (Booking booking : bookings) {
                        System.out.println(booking);
                    }
                    break;
                case 2:
                    bookingService.addBooking();
                    break;
                case 3:
                    System.out.print("Enter the ID of the booking to be deleted: ");
                    String id = scanner.nextLine();
                    bookingService.deleteBooking(id);
                    break;
                case 4:
                    check = false;
                    break;
                default:
                    System.out.println("Please select a valid number from the menu.");
            }
        }
    }

    public static void displayContractMenu() throws IOException, InvalidInputException {
        boolean check = true;
        while (check) {
            System.out.println("╔═══════════════════════════════════════════════════╗");
            System.out.println("║            CONTRACT MANAGEMENT MENU               ║");
            System.out.println("╠═══════════════════════════════════════════════════╣");
            System.out.println("║ Options:                                          ║");
            System.out.println("║  ▶ 1. Create new contracts                        ║");
            System.out.println("║  ▶ 2. Display list of contracts                   ║");
            System.out.println("║  ▶ 3. Delete contracts                            ║");
            System.out.println("║  ▶ 4. Return to main menu                         ║");
            System.out.println("╚═══════════════════════════════════════════════════╝");
            System.out.print("▶ Select function: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    contractService.addContract();
                    break;
                case 2:
                    List<Contract> contracts = contractService.getAllContracts();
                    for (Contract contract : contracts) {
                        System.out.println(contract);
                    }
                    break;
                case 3:
                    System.out.print("Enter the ID of the contract to be deleted: ");
                    String id = scanner.nextLine();
                    contractService.deleteContract(id);
                    break;
                case 4:
                    check = false;
                    break;
                default:
                    System.out.println("Please select a valid number from the menu.");
            }
        }
    }
}
