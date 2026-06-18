package service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import model.Reservation;

public class BookingService {

    // Prevent duplicate room IDs

    private Set<String> bookedRoomIds;

    // Room Type -> Assigned Room IDs

    private HashMap<String, Set<String>> assignedRooms;

    private InventoryManager inventoryManager;

    private int roomNumberCounter;

    public BookingService(InventoryManager inventoryManager) {

        this.inventoryManager = inventoryManager;

        bookedRoomIds = new HashSet<>();

        assignedRooms = new HashMap<>();

        roomNumberCounter = 101;

    }

    public void confirmReservation(Reservation reservation) {

        String roomType = reservation.getRoomType();

        boolean allocated =
                inventoryManager.allocateRoom(roomType);

        if (!allocated) {

            System.out.println(
                    "No rooms available for "
                            + roomType);

            return;

        }

        String roomId =
                roomType.substring(0,1).toUpperCase()
                        + roomNumberCounter++;

        bookedRoomIds.add(roomId);

        assignedRooms
                .computeIfAbsent(
                        roomType,
                        key -> new HashSet<>())
                .add(roomId);

        System.out.println();

        System.out.println(
                "Reservation Confirmed");

        System.out.println(
                "Guest : "
                        + reservation.getGuestName());

        System.out.println(
                "Room Type : "
                        + roomType);

        System.out.println(
                "Assigned Room ID : "
                        + roomId);

    }

    public void displayAllocatedRooms() {

        System.out.println();

        System.out.println(
                "===== ROOM ALLOCATION =====");

        for (String roomType :
                assignedRooms.keySet()) {

            System.out.println(

                    roomType +

                            " -> "

                            + assignedRooms.get(roomType));

        }

    }

}