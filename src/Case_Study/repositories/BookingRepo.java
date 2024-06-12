package Case_Study.repositories;

import Case_Study.models.Booking;
import Case_Study.models.Employee;
import Case_Study.utils.CSVUltils;
import java.util.ArrayList;
import java.util.List;

public class BookingRepo {

    private final String filePath = "D:\\CodegymFT\\module2\\src\\Case_Study\\data\\booking.csv";

    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        List<String> lines = CSVUltils.read(filePath);
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length == 5) {
                Booking booking = new Booking(parts[0], parts[1], parts[2], parts[3], parts[4]);
                bookings.add(booking);
            } else {
                System.out.println("Invalid line format: " + line);
            }
        }
        return bookings;
    }

    public void saveBookings(List<Booking> bookings) {
        List<String> lines = new ArrayList<>();
        for (Booking booking : bookings) {
            String line = String.join(",", booking.getBookingId(), booking.getCustomerId(), booking.getFacilityId(), booking.getStartDate(), booking.getEndDate());
            lines.add(line);
        }
        CSVUltils.write(filePath, lines);
    }

    public boolean isDuplicateId(String id) {
        List<Booking> bookings = getAllBookings();
        return bookings.stream().anyMatch(booking -> booking.getBookingId().equals(id));
    }
}

