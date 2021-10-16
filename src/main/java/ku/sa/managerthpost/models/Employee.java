package ku.sa.managerthpost.models;

public class Employee extends User{

    private String employ_ID;

    public Employee(String name, String lastname, String username, String password, String employ_ID) {
        super(name, lastname, username, password);
        this.employ_ID = employ_ID;
    }

    public String getEmploy_ID() {
        return employ_ID;
    }

    public void setEmploy_ID(String employ_ID) {
        this.employ_ID = employ_ID;
    }
}
