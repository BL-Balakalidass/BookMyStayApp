package service;

import java.util.Map;

public class SearchService {

    private InventoryManager inventoryManager;

    public SearchService(InventoryManager inventoryManager) {

        this.inventoryManager = inventoryManager;

    }

    // Display all available rooms

    public void displayAvailableRooms() {

        Map<String, Integer> roomCountMap =
                inventoryManager.getRoomCountMap();

        Map<String, Double> roomPriceMap =
                inventoryManager.getRoomPriceMap();

        System.out.println("\n===== AVAILABLE ROOMS =====");

        for (String roomType : roomCountMap.keySet()) {

            if (roomCountMap.get(roomType) > 0) {

                System.out.println(
                        roomType +
                                " | Available : " +
                                roomCountMap.get(roomType) +
                                " | Price : ₹" +
                                roomPriceMap.get(roomType)
                );

            }

        }

    }

    // Search a particular room

    public void searchRoom(String roomType) {

        Map<String, Integer> roomCountMap =
                inventoryManager.getRoomCountMap();

        Map<String, Double> roomPriceMap =
                inventoryManager.getRoomPriceMap();

        System.out.println("\n===== SEARCH RESULT =====");

        // Defensive check

        if (!roomCountMap.containsKey(roomType)) {

            System.out.println("Room Type does not exist.");

            return;

        }

        // Availability validation

        if (roomCountMap.get(roomType) <= 0) {

            System.out.println(roomType +
                    " is currently unavailable.");

            return;

        }

        System.out.println("Room Type : " + roomType);

        System.out.println("Available Rooms : "
                + roomCountMap.get(roomType));

        System.out.println("Price per Night : ₹"
                + roomPriceMap.get(roomType));

        // Static amenities

        System.out.println("Amenities : WiFi, AC, TV");

    }

}