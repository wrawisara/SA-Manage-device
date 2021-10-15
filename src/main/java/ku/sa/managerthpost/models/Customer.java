package ku.sa.managerthpost.models;

import java.util.ArrayList;

public class Customer extends User{

    private String cus_department;
    private String cus_ID;
    private ArrayList<Equipment> equipmentArrayList;

    public Customer(String name, String lastname, String username, String password, String cus_department, String cus_ID) {
        super(name, lastname, username, password);
        this.cus_department = cus_department;
        this.cus_ID = cus_ID;
        this.equipmentArrayList = new ArrayList<>();
    }

    public String getCus_department() {
        return cus_department;
    }

    public String getCus_ID() {
        return cus_ID;
    }

    public ArrayList<Equipment> getEquipmentArrayList() {
        return equipmentArrayList;
    }
}
