package Entities;

public class Employee extends Custumer {
    private String workPlace;

    public Employee(int custumerId, String name, String dUI, int age, String phone, String workPlace) {
        super(custumerId, name, dUI, age, phone);
        this.workPlace = workPlace;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }


    
    
}
