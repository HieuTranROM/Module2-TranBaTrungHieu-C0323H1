package Case_Study.service;

import Case_Study.common.InvalidInputException;
import Case_Study.models.Booking;

import java.io.IOException;
import java.util.List;

public interface BookingService {
    void addBooking() throws InvalidInputException, IOException;

    void deleteBooking(String id) throws IOException;

    List<Booking> getAllBookings();
}

