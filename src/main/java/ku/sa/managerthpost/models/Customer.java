package ku.sa.managerthpost.models;

import java.util.ArrayList;

public class Customer extends User{

    private String department;
    private ArrayList<String> equipment;

    public Customer(String name, String lastname, String username, String password, String id, String department) {
        super(name, lastname, username, password, id);
        this.department = department;
        equipment = new ArrayList<>();
        setEquipment();
    }

    public void setEquipment () {
        switch (this.department) {
            case "กรุงเทพมหานคร":
            case "ปทุมธานี":
            case "พระนครศรีอยุธยา":
                equipment.add("รถบรรทุก");
                equipment.add("ปั้นจั่น");
                equipment.add("สายพานลำเลียง");
                equipment.add("ห่วงโซ่สายพาน");
                equipment.add("พาเลท");
                equipment.add("โฟคลิป");
                break;
            case "กำแพงเพชร":
                equipment.add("รถบรรทุก");
                equipment.add("ปั้นจั่น");
                break;
            case "ชัยนาท":
                equipment.add("สายพานลำเลียง");
                equipment.add("ห่วงโซ่สายพาน");
                break;
            case "นครนายก":
                equipment.add("พาเลท");
                equipment.add("รถบรรทุก");
                break;
            case "นครปฐม":
                equipment.add("รถบรรทุก");
                equipment.add("โฟคลิป");
                equipment.add("ห่วงโซ่สายพาน");
                break;
            case "":
                break;
        }
    }

    @Override
    public String getDepartment(){
        return this.department;
    }

    @Override
    public String getEquipment(){
        String tmp = "";
        for(String s : equipment){
            tmp = tmp + s;
        }
        return tmp;
    }

}
