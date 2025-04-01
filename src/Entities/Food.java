package Entities;

public class Food {
    private final int foodId;
    private final String foodName;
    private final String foodDescription;

    public Food(int foodId, String foodName, String foodDescription, int eventId) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodDescription = foodDescription;
    }

    public int getFoodId() {
        return foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodDescription() {
        return foodDescription;
    }
      

}
