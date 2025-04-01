package Entities;
import java.time.LocalTime;
import java.util.List;

public class FamilyEvent extends Event {
    private String familyLastName;
    private String MealType;

    

    public FamilyEvent(int eventId, String eventCode, String eventName, double price, LocalTime endTime,
            int maxCapacity, int minCapacity, String eventStatus, FoodMenu foodMenu, List<Drink> drinks,
            Customer client, String familyLastName, String mealType) {
        super(eventId, eventCode, eventName, price, endTime, maxCapacity, minCapacity, eventStatus, foodMenu, drinks,
                client);
        this.familyLastName = familyLastName;
        MealType = mealType;
    }

    public String getFamilyLastName() {
        return familyLastName;
    }

    public void setFamilyLastName(String familyLastName) {
        this.familyLastName = familyLastName;
    }

    public String getMealType() {
        return MealType;
    }

    public void setMealType(String mealType) {
        MealType = mealType;
    }


}
