package service;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {

    private Map<String, Integer> roomCountMap;
    private Map<String, Double> roomPriceMap;

    public InventoryManager() {

        roomCountMap = new HashMap<>();
        roomPriceMap = new HashMap<>();

    }

    // Add new room type
    public void addRoomType(String roomType,
                            int count,
                            double price) {

        roomCountMap.put(roomType, count);
        roomPriceMap.put(roomType, price);

        System.out.println(roomType + " added successfully.");

    }

    // Update available room count
    public void updateRoomCount(String roomType,
                                int newCount) {

        if (roomCountMap.containsKey(roomType)) {

            roomCountMap.put(roomType, newCount);

            System.out.println(roomType +
                    " count updated successfully.");

        } else {

            System.out.println("Room type not found.");

        }

    }

    // Update room price
    public void updateRoomPrice(String roomType,
                                double newPrice) {

        if (roomPriceMap.containsKey(roomType)) {

            roomPriceMap.put(roomType, newPrice);

            System.out.println(roomType +
                    " price updated successfully.");

        } else {

            System.out.println("Room type not found.");

        }

    }

    // Display complete inventory
    public void displayInventory() {

        System.out.println("\n========== HOTEL ROOM INVENTORY ==========");

        for (Map.Entry<String, Integer> entry :
                roomCountMap.entrySet()) {

            String roomType = entry.getKey();

            System.out.println(
                    "Room Type : " + roomType +
                            " | Available : " +
                            roomCountMap.get(roomType) +
                            " | Price/Night : ₹" +
                            roomPriceMap.get(roomType)
            );

        }

        System.out.println("==========================================");

    }

    // Getter for UC2 Search Module
    public Map<String, Integer> getRoomCountMap() {
        return roomCountMap;
    }

    // Getter for UC2 Search Module
    public Map<String, Double> getRoomPriceMap() {
        return roomPriceMap;
    }

    // Decrement room count after successful booking

    public boolean allocateRoom(String roomType) {

        if (!roomCountMap.containsKey(roomType)) {

            return false;

        }

        int availableRooms = roomCountMap.get(roomType);

        if (availableRooms <= 0) {

            return false;

        }

        roomCountMap.put(roomType, availableRooms - 1);

        return true;

    }
}