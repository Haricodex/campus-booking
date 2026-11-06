package com.cia2.campus_booking;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api")
public class BookingController {

    private final AtomicLong counter = new AtomicLong();
    private final List<Booking> bookings = new CopyOnWriteArrayList<>();

    @GetMapping("/status")
    public Map<String, String> status() {
        return Map.of(
            "application", "Campus Booking System",
            "status", "running",
            "message", "CIA 2 CI/CD deployment successful!"
        );
    }

    @GetMapping("/bookings")
    public List<Booking> getBookings() {
        return bookings;
    }

    @PostMapping("/bookings")
    public Booking createBooking(@RequestBody BookingRequest request) {
        Booking booking = new Booking(
            counter.incrementAndGet(),
            request.studentName(),
            request.room(),
            request.date()
        );
        bookings.add(booking);
        return booking;
    }

    public record Booking(
        Long id,
        String studentName,
        String room,
        String date
    ) {}

    public record BookingRequest(
        String studentName,
        String room,
        String date
    ) {}
}
