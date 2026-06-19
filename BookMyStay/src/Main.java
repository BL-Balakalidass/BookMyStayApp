import model.Reservation;
import service.ReportService;

public class Main {

    public static void main(String[] args) {

        ReportService reportService =
                new ReportService();

        Reservation reservation1 =
                new Reservation(
                        "R101",
                        "Arun",
                        "Single");

        Reservation reservation2 =
                new Reservation(
                        "R102",
                        "Priya",
                        "Double");

        Reservation reservation3 =
                new Reservation(
                        "R103",
                        "Rahul",
                        "Suite");

        // Store confirmed reservations

        reportService.addReservation(
                reservation1);

        reportService.addReservation(
                reservation2);

        reportService.addReservation(
                reservation3);

        // Display booking history

        reportService.displayBookingHistory();

        // Cancel reservation

        reportService.cancelReservation(
                "R102");

        // Display updated history

        reportService.displayBookingHistory();

        // Generate report

        reportService.generateReport();

    }

}