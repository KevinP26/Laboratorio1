package Entities;
import java.util.List;

public class FoodMenu {
    private int idCatalog;
    private String name;
    private List<Food> food;
    private Event evento;
    
    public FoodMenu(int idCatalog, String name, List<Food> comida, Event evento) {
        this.idCatalog = idCatalog;
        this.name = name;
        this.food = comida;
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

    public List<Food> getComida() {
        return food;
    }

    public void setComida(List<Food> comida) {
        this.food = comida;
    }

    public Event getEvento() {
        return evento;
    }

    public void setEvento(Event evento) {
        this.evento = evento;
    }

    
    
}
