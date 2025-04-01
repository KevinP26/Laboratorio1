package Entities;
import java.time.LocalDateTime;
import java.util.List;


 public abstract class Event{

    private int eventId;
    private String eventCode;
    private String EventName;
    private double price;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int maxCapacity;
    private int minCapacity;
    private String eventStatus;
    private FoodMenu foodMenu;
    private List<Drink> drinks;
    
    public Event(int eventId, String eventCode, String eventName, double price, LocalDateTime startTime,
            LocalDateTime endTime, int maxCapacity, int minCapacity, String eventStatus, FoodMenu foodMenu,
            List<Drink> drinks) {
        this.eventId = eventId;
        this.eventCode = eventCode;
        EventName = eventName;
        this.price = price;
        this.startTime = startTime;
        this.endTime = endTime;
        this.maxCapacity = maxCapacity;
        this.minCapacity = minCapacity;
        this.eventStatus = eventStatus;
        this.foodMenu = foodMenu;
        this.drinks = drinks;
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

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
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

     
  
}




