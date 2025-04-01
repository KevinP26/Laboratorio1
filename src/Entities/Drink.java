package Entities;
import java.util.List;

public class Drink {
    private int idDrink;
    private String name;
    private String description;
    private List<Event> events;
    
    public Drink(int idDrink, String name, String description, List<Event> events) {
        this.idDrink = idDrink;
        this.name = name;
        this.description = description;
        this.events = events;
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

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

   
    
}
