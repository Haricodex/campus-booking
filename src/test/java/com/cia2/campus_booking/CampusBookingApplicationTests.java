package com.cia2.campus_booking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CampusBookingApplicationTests {

    @Test
    void applicationStatusShouldBeRunning() {
        BookingController controller = new BookingController();

        var result = controller.status();

        assertEquals("running", result.get("status"));
        assertEquals("Campus Booking System", result.get("application"));
    }

    @Test
    void shouldCreateAndRetrieveBooking() {
        BookingController controller = new BookingController();

        var request = new BookingController.BookingRequest(
            "Hari",
            "Seminar Hall",
            "2026-11-07"
        );

        var created = controller.createBooking(request);
        var bookings = controller.getBookings();

        assertEquals(1L, created.id());
        assertEquals("Hari", created.studentName());
        assertEquals(1, bookings.size());
    }
}
