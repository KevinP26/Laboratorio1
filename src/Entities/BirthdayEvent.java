package Entities;
import java.time.LocalTime;
import java.util.List;

public class BirthdayEvent extends Event {
    private String celebrantName;
    private String celebrantAge;
    private String celebrantFavoriteColor;
    private String GiftMethod;
    private double advancePayment;
    
    public BirthdayEvent(int eventId, String eventCode, String eventName, double price, LocalTime endTime,
            int maxCapacity, int minCapacity, String eventStatus, FoodMenu foodMenu, List<Drink> drinks,
            Customer client, String celebrantName, String celebrantAge, String celebrantFavoriteColor,
            String giftMethod, double advancePayment) {
        super(eventId, eventCode, eventName, price, endTime, maxCapacity, minCapacity, eventStatus, foodMenu, drinks,
                client);
        this.celebrantName = celebrantName;
        this.celebrantAge = celebrantAge;
        this.celebrantFavoriteColor = celebrantFavoriteColor;
        GiftMethod = giftMethod;
        this.advancePayment = advancePayment;
    }

    public String getCelebrantName() {
        return celebrantName;
    }

    public void setCelebrantName(String celebrantName) {
        this.celebrantName = celebrantName;
    }

    public String getCelebrantAge() {
        return celebrantAge;
    }

    public void setCelebrantAge(String celebrantAge) {
        this.celebrantAge = celebrantAge;
    }

    public String getCelebrantFavoriteColor() {
        return celebrantFavoriteColor;
    }

    public void setCelebrantFavoriteColor(String celebrantFavoriteColor) {
        this.celebrantFavoriteColor = celebrantFavoriteColor;
    }

    public String getGiftMethod() {
        return GiftMethod;
    }

    public void setGiftMethod(String giftMethod) {
        GiftMethod = giftMethod;
    }

    public double getAdvancePayment() {
        return advancePayment;
    }

    public void setAdvancePayment(double advancePayment) {
        this.advancePayment = advancePayment;
    }

   
}
