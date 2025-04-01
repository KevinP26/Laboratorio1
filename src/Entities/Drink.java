package Entities;

public class Drink {
    private int idDrink;
    private String name;
    private String description;
    private DrinkMenu drinkMenu;
    
    public Drink(int idDrink, String name, String description, DrinkMenu drinkMenu) {
        this.idDrink = idDrink;
        this.name = name;
        this.description = description;
        this.drinkMenu = drinkMenu;
    }

    public int getIdDrink() {
        return idDrink;
    }

    public void setIdDrink(int idDrink) {
        this.idDrink = idDrink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DrinkMenu getDrinkMenu() {
        return drinkMenu;
    }

    public void setDrinkMenu(DrinkMenu drinkMenu) {
        this.drinkMenu = drinkMenu;
    }
 
    
}
