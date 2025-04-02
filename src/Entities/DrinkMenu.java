package Entities;

import java.util.List;

public class DrinkMenu {
    private String nombre;
    private List<Drink> items;

    public DrinkMenu(String nombre, List<Drink> items) {
        this.nombre = nombre;
        this.items = items;
    }

    public List<Drink> getItems() {
        return items;
    }

    public String getNombre() {
        return nombre;
    }
}
