import model.Reservation;
import service.BookingQueueService;
import service.InventoryManager;
import service.SearchService;

public class Main {

    public static void main(String[] args) {

        InventoryManager inventoryManager =
                new InventoryManager();

        inventoryManager.addRoomType(
                "Single",
                15,
                2500);

        inventoryManager.addRoomType(
                "Double",
                10,
                4000);

        inventoryManager.addRoomType(
                "Suite",
                5,
                7000);

        SearchService searchService =
                new SearchService(inventoryManager);

        searchService.displayAvailableRooms();

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
                        "Double"));

        bookingQueue.addBookingRequest(

                new Reservation(
                        "R103",
                        "Rahul",
                        "Suite"));

        bookingQueue.displayBookingQueue();

        bookingQueue.processNextBooking();

        bookingQueue.displayBookingQueue();

    }

}