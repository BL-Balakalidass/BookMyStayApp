package service;

import java.util.LinkedList;
import java.util.Queue;

import model.Reservation;

public class BookingQueueService {

    private Queue<Reservation> bookingQueue;

    public BookingQueueService() {

        bookingQueue = new LinkedList<>();

    }

    // Accept Booking Request

    public void addBookingRequest(Reservation reservation) {

        bookingQueue.offer(reservation);

        System.out.println(
                reservation.getGuestName() +
                        " added to booking queue.");

    }

    // Process Next Booking

    public Reservation processNextBooking() {

        if (bookingQueue.isEmpty()) {

            System.out.println("No booking requests available.");

            return null;

        }

        Reservation reservation = bookingQueue.poll();

        System.out.println(
                reservation.getGuestName() +
                        " booking is now being processed.");

        return reservation;

    }

    // Display Queue

    public void displayBookingQueue() {

        System.out.println("\n===== BOOKING QUEUE =====");

        if (bookingQueue.isEmpty()) {

            System.out.println("Queue is Empty.");

            return;

        }

        for (Reservation reservation : bookingQueue) {

            System.out.println(reservation);

        }

    }

}