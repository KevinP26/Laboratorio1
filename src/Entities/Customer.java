package Entities;

public class Customer {
    private String name;
    private String dui;
    private int age;
    private String phone;

    public Customer(String name, String dui, int age, String phone) {
        this.name = name;
        this.dui = dui;
        this.age = age;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getDui() {
        return dui;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }
}
