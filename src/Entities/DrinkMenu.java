package Entities;

import java.util.List;

public class DrinkMenu {
    private int idCatalog;
    private String name;
    private List<Drink> drink;
    private Event evento;

    public DrinkMenu(int idCatalog, String name, List<Drink> drink, Event evento) {
        this.idCatalog = idCatalog;
        this.name = name;
        this.drink = drink;
        this.evento = evento;
    }

    public int getIdCatalog() {
        return idCatalog;
    }

    public void setIdCatalog(int idCatalog) {
        this.idCatalog = idCatalog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Drink> getDrink() {
        return drink;
    }

    public void setDrink(List<Drink> drink) {
        this.drink = drink;
    }

    public Event getEvento() {
        return evento;
    }

    public void setEvento(Event evento) {
        this.evento = evento;
    }
    
    
    
}
