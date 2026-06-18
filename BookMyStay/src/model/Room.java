
package model;

public class Room {

    private String roomType;
    private int availableCount;
    private double pricePerNight;

    public Room(String roomType, int availableCount, double pricePerNight) {
        this.roomType = roomType;
        this.availableCount = availableCount;
        this.pricePerNight = pricePerNight;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    @Override
    public String toString() {
        return "Room Type : " + roomType +
                " | Available : " + availableCount +
                " | Price : ₹" + pricePerNight;
    }
}