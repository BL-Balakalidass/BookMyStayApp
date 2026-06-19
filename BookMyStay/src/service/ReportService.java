package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Reservation;

public class ReportService {

    // Booking History

    private List<Reservation> bookingHistory;

    public ReportService() {

        bookingHistory = new ArrayList<>();

    }

    // Store Confirmed Reservation

    public void addReservation(Reservation reservation) {

        bookingHistory.add(reservation);

        System.out.println(

                reservation.getReservationId()

                        + " stored successfully.");

    }

    // Cancel Reservation

    public void cancelReservation(String reservationId) {

        Iterator<Reservation> iterator =
                bookingHistory.iterator();

        while (iterator.hasNext()) {

            Reservation reservation =
                    iterator.next();

            if (reservation.getReservationId()
                    .equals(reservationId)) {

                iterator.remove();

                System.out.println(

                        reservationId +

                                " cancelled successfully.");

                return;

            }

        }

        System.out.println("Reservation not found.");

    }

    // Review Booking History

    public void displayBookingHistory() {

        System.out.println();

        System.out.println(
                "===== BOOKING HISTORY =====");

        if (bookingHistory.isEmpty()) {

            System.out.println(
                    "No Reservations Available.");

            return;

        }

        for (Reservation reservation :
                bookingHistory) {

            System.out.println(reservation);

        }

    }

    // Generate Report

    public void generateReport() {

        System.out.println();

        System.out.println(
                "===== REPORT =====");

        System.out.println(
                "Total Confirmed Reservations : "

                        + bookingHistory.size());

    }

}