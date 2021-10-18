package ku.sa.managerthpost.models;

import java.util.UUID;

public class User {

    private String name;
    private String lastname;
    private String username;
    private String password;
    private String id;

    public User(String name, String lastname, String username, String password, String id) {
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartment () {
         return "";
    }

    public String getEquipment (){
        return "";
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
