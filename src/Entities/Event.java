package Entities;

public class Event {
    private String eventCode;
    private String name;
    private double price;

    public Event(String eventCode, String name, double price) {
        this.eventCode = eventCode;
        this.name = name;
        this.price = price;
    }

    public String getEventCode() {
        return eventCode;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
