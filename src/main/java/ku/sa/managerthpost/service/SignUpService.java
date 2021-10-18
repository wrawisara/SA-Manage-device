package ku.sa.managerthpost.service;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import ku.sa.managerthpost.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SignUpService {

    private String usernameTextField;
    private String lastnameTextField;
    private String nameTextField;
    private String idTextField;
    private String department;

    public SignUpService(String usernameTextField, String lastnameTextField, String nameTextField, String idTextField, String department) {
        this.usernameTextField = usernameTextField;
        this.lastnameTextField = lastnameTextField;
        this.nameTextField = nameTextField;
        this.idTextField = idTextField;
        this.department = department;
    }

    public String verifySignUpData (User register) {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionDB = connection.getConnection();
        String checkDuplicate = "SELECT count(1) FROM Customer " +
                "WHERE username = '" + usernameTextField + "'";
        try {
            Statement statement = connectionDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(checkDuplicate);
            boolean check = false;
            while (queryOutput.next()) {
                if (queryOutput.getInt(1) == 1) {
                    return "Username is already used.";
                } else {
                    check = true;
                }
            }
            if (check) {
                Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
                confirm.setTitle("Confirm?");
                confirm.setContentText("Are you sure?");
                confirm.setHeaderText(null);
                if (confirm.showAndWait().get() == ButtonType.OK) {
                    String signUp =
                            "INSERT INTO customer (firstname, lastname, username, cpassword, cus_ID, department) VALUES ('";
                    String signUp2 = register.getName() + "','" + register.getLastname() + "','"
                            + register.getUsername() + "','" + register.getPassword() + "','" + register.getId() + "','"
                            + register.getDepartment() + "')";
                    String x = signUp + signUp2;
                    Statement statement2 = connectionDB.createStatement();
                    statement2.executeUpdate(x);
                    return "Successfully register.";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
        return "Successfully register.";
    }
}
