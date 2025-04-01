package Entities;

public class Food {
    private final int foodId;
    private final String foodName;
    private final String foodDescription;
    private FoodMenu foodMenu;

    public Food(int foodId, String foodName, String foodDescription, FoodMenu foodMenu) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodDescription = foodDescription;
        this.foodMenu = foodMenu;
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
    public FoodMenu getFoodMenu() {
        return foodMenu;
    }
    public void setFoodMenu(FoodMenu foodMenu) {
        this.foodMenu = foodMenu;
    }


}
