package Entities;
import java.util.List;
import java.time.LocalTime;


 public abstract class Event{

    private int eventId;
    private String eventCode;
    private String EventName;
    private double price;
    private LocalTime endTime;
    private int maxCapacity;
    private int minCapacity;
    private String eventStatus;
    private FoodMenu foodMenu;
    private List<Drink> drinks;
    private Customer client;

    public Event(int eventId, String eventCode, String eventName, double price, LocalTime endTime, int maxCapacity,
            int minCapacity, String eventStatus, FoodMenu foodMenu, List<Drink> drinks, Customer client) {
        this.eventId = eventId;
        this.eventCode = eventCode;
        EventName = eventName;
        this.price = price;
        this.endTime = endTime;
        this.maxCapacity = maxCapacity;
        this.minCapacity = minCapacity;
        this.eventStatus = eventStatus;
        this.foodMenu = foodMenu;
        this.drinks = drinks;
        this.client = client;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getMinCapacity() {
        return minCapacity;
    }

    public void setMinCapacity(int minCapacity) {
        this.minCapacity = minCapacity;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    public FoodMenu getFoodMenu() {
        return foodMenu;
    }

    public void setFoodMenu(FoodMenu foodMenu) {
        this.foodMenu = foodMenu;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public Customer getClient() {
        return client;
    }

    public void setClient(Customer client) {
        this.client = client;
    }

    

    
    
  
}




