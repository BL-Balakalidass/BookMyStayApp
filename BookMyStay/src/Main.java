import service.InventoryManager;

public class Main {

    public static void main(String[] args) {

        InventoryManager inventoryManager =
                new InventoryManager();

        // Initialize room inventory

        inventoryManager.addRoomType(
                "Single",
                15,
                2500.0);

        inventoryManager.addRoomType(
                "Double",
                10,
                4000.0);

        inventoryManager.addRoomType(
                "Suite",
                5,
                7000.0);

        // Display initial inventory

        inventoryManager.displayInventory();

        // Update room count

        inventoryManager.updateRoomCount(
                "Double",
                12);

        // Update room price

        inventoryManager.updateRoomPrice(
                "Suite",
                7500.0);

        // Display updated inventory

        inventoryManager.displayInventory();

    }

}