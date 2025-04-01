package Entities;

import java.time.LocalTime;
import java.util.List;

public class BussinesEvent extends Event{
    private String companyName;
    private String colorTheme;
    private String dressCode;
    private double advancePayment;
    private boolean dessert;
    
   

    public BussinesEvent(int eventId, String eventCode, String eventName, double price, LocalTime endTime,
            int maxCapacity, int minCapacity, String eventStatus, FoodMenu foodMenu, List<Drink> drinks,
            Customer client, String companyName, String colorTheme, String dressCode, double advancePayment,
            boolean dessert) {
        super(eventId, eventCode, eventName, price, endTime, maxCapacity, minCapacity, eventStatus, foodMenu, drinks,
                client);
        this.companyName = companyName;
        this.colorTheme = colorTheme;
        this.dressCode = dressCode;
        this.advancePayment = advancePayment;
        this.dessert = dessert;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(String colorTheme) {
        this.colorTheme = colorTheme;
    }

    public String getDressCode() {
        return dressCode;
    }

    public void setDressCode(String dressCode) {
        this.dressCode = dressCode;
    }

    public double getAdvancePayment() {
        return advancePayment;
    }

    public void setAdvancePayment(double advancePayment) {
        this.advancePayment = advancePayment;
    }

    public boolean isDessert() {
        return dessert;
    }

    public void setDessert(boolean dessert) {
        this.dessert = dessert;
    }      

}
