package Entities;

public class Custumer {
    private int custumerId;
    private String Name;
    private String DUI;
    private int age;
    private String phone;
    
    public Custumer(int custumerId, String name, String dUI, int age, String phone) {
        this.custumerId = custumerId;
        Name = name;
        DUI = dUI;
        this.age = age;
        this.phone = phone;
    }

    public int getCustumerId() {
        return custumerId;
    }

    public void setCustumerId(int custumerId) {
        this.custumerId = custumerId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDUI() {
        return DUI;
    }

    public void setDUI(String dUI) {
        DUI = dUI;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    
    
}
