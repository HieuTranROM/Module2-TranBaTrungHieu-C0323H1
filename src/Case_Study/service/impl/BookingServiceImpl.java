package Case_Study.service.impl;

import Case_Study.common.InvalidInputException;
import Case_Study.common.RegexPartern;
import Case_Study.models.Booking;
import Case_Study.models.Customer;
import Case_Study.repositories.BookingRepo;
import Case_Study.repositories.CustomerRepo;
import Case_Study.service.BookingService;

import java.io.IOException;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BookingServiceImpl implements BookingService {
    private BookingRepo bookingRepo = new BookingRepo();
    private CustomerRepo customerRepo = new CustomerRepo();
    private static final String DATE_FORMAT = "dd/MM/yyyy";

    @Override
    public void addBooking(){
        Scanner scanner = new Scanner(System.in);
        String id;
        String customerId;
        String serviceId;
        String startDate;
        String endDate;
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.setLenient(false);
        String currentDate = sdf.format(new Date());

        while (true) {
            System.out.print("Enter booking ID: ");
            id = scanner.nextLine();
            if (!RegexPartern.validateBookingId(id)) {
                System.out.println("Invalid booking ID format. Must be in the format B-XXX.");
                continue;
            }
            if (bookingRepo.isDuplicateId(id)) {
                System.out.println("Booking already exists. Please enter a unique ID.");
            }

            while (true) {
                System.out.print("Enter customer ID: ");
                customerId = scanner.nextLine();
                if (!isValidCustomerId(customerId)) {
                    System.out.println("Invalid customer ID. Please enter a valid customer ID.");
                } else {
                    break;
                }
            }

            System.out.print("Enter service ID: ");
            serviceId = scanner.nextLine();

            while (true) {
                System.out.print("Enter start date (dd/MM/yyyy): ");
                startDate = scanner.nextLine();
                if (!isValidDate(startDate)) {
                    System.out.println("Invalid date format. Please enter a valid date in the format dd/MM/yyyy.");
                    continue;
                }
                if (!startDate.equals(currentDate)) {
                    System.out.println("Start date must be today's date: " + currentDate);
                    continue;
                }
                System.out.println("Start date entered: " + startDate);
                break;
            }

            System.out.print("Enter end date (dd/MM/yyyy): ");
            endDate = scanner.nextLine();
            if (!isValidDate(endDate)) {
                System.out.println("Invalid date format. Please enter a valid date in the format dd/MM/yyyy.");
                continue;
            }

            try {
                Date endDateParsed = sdf.parse(endDate);
                Date startDateParsed = sdf.parse(startDate);
                if (!endDateParsed.after(startDateParsed)) {
                    System.out.println("End date must be after the start date.");
                    continue;
                }
                System.out.println("End date entered: " + endDate);
            } catch (ParseException e) {
                System.out.println("Error parsing end date.");
                continue;
            }

            break;
        }

        Booking booking = new Booking(id, customerId, serviceId, startDate, endDate);
        List<Booking> bookings = bookingRepo.getAllBookings();
        bookings.add(booking);
        bookingRepo.saveBookings(bookings);
        System.out.println("New booking added successfully.");
    }

    private boolean isValidCustomerId(String customerId) {
        List<Customer> customers = customerRepo.getAllCustomers();
        return customers.stream().anyMatch(customer -> customer.getId().equals(customerId));
    }

    private boolean isValidDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.setLenient(false);
        try {
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    @Override
    public void deleteBooking(String id) throws IOException {
        List<Booking> bookings = bookingRepo.getAllBookings();
        bookings.removeIf(booking -> booking.getBookingId().equals(id));
        bookingRepo.saveBookings(bookings);
        System.out.println("Booking with ID " + id + " deleted successfully.");
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepo.getAllBookings();
    }
}
