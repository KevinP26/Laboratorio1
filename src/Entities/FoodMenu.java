package Entities;

import java.util.List;

public class FoodMenu {
    private String nombre;
    private List<Food> items;

    public FoodMenu(String nombre, List<Food> items) {
        this.nombre = nombre;
        this.items = items;
    }

    public List<Food> getItems() {
        return items;
    }

    public String getNombre() {
        return nombre;
    }
}
