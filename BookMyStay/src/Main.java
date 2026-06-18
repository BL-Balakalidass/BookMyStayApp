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

        // Display available rooms

        searchService.displayAvailableRooms();

        // Search for Single room

        searchService.searchRoom("Single");

        // Search unavailable room

        inventoryManager.updateRoomCount(
                "Suite",
                0);

        searchService.searchRoom("Suite");

        // Search invalid room

        searchService.searchRoom("Deluxe");

    }

}