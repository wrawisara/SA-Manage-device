package ku.sa.managerthpost.models;

import java.util.ArrayList;

public class Customer extends User{

    private String cus_department;
    private ArrayList<Equipment> equipmentArrayList;

    public Customer(String name, String lastname, String username, String password
           , String cus_department, ArrayList<Equipment> equipmentArrayList) {
        super(name, lastname, username, password);
        this.cus_department = cus_department;
        this.equipmentArrayList = equipmentArrayList;
    }

    public String getCus_department() {
        return cus_department;
    }

    public void setCus_department(String cus_department) {
        this.cus_department = cus_department;
    }

    public ArrayList<Equipment> getEquipmentArrayList() {
        return equipmentArrayList;
    }
}
