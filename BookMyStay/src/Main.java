import model.Reservation;
import service.BookingQueueService;
import service.BookingService;
import service.InventoryManager;
import service.SearchService;

public class Main {

    public static void main(String[] args) {

        InventoryManager inventory =
                new InventoryManager();

        inventory.addRoomType(
                "Single",
                2,
                2500);

        inventory.addRoomType(
                "Double",
                2,
                4000);

        inventory.addRoomType(
                "Suite",
                1,
                7000);

        SearchService search =
                new SearchService(inventory);

        search.displayAvailableRooms();

        BookingQueueService bookingQueue =
                new BookingQueueService();

        bookingQueue.addBookingRequest(

                new Reservation(
                        "R101",
                        "Arun",
                        "Single"));

        bookingQueue.addBookingRequest(

                new Reservation(
                        "R102",
                        "Priya",
                        "Single"));

        bookingQueue.addBookingRequest(

                new Reservation(
                        "R103",
                        "Rahul",
                        "Suite"));

        BookingService bookingService =
                new BookingService(inventory);

        Reservation reservation;

        while ((reservation =
                bookingQueue.processNextBooking()) != null) {

            bookingService.confirmReservation(
                    reservation);

        }

        bookingService.displayAllocatedRooms();

        System.out.println();

        inventory.displayInventory();

    }

}