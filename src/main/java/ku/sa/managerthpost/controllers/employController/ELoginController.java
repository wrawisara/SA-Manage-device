package ku.sa.managerthpost.controllers.employController;

import com.mysql.cj.protocol.Resultset;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ku.sa.managerthpost.models.Employee;
import ku.sa.managerthpost.service.DatabaseConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ELoginController {
    @FXML
    private Button loginBtn;
    @FXML
    private Button loginBtn1;
    @FXML
    private Button loginBtn11;
    @FXML
    private TextField employeeUsername;
    @FXML
    private PasswordField employeePassword;


    @FXML
    public void initialize () throws SQLException {
        createEmployee();
    }

    public void createEmployee () throws SQLException {
        Employee employee1 = new Employee("John", "Mairu", "employee1", "1111", "E001");
        createEmployeeSQL(employee1);
        Employee employee2 = new Employee("Carter", "Konichiwa", "employee2", "1111", "E002");
        createEmployeeSQL(employee2);
        Employee employee3 = new Employee("Olsen", "Irasshaimase", "employee3", "1111", "E003");
        createEmployeeSQL(employee3);
        Employee employee4 = new Employee("James", "Omakasae", "employee4", "1111", "E004");
        createEmployeeSQL(employee4);
        Employee employee5 = new Employee("Scarlet", "Tuna", "employee5", "1111", "E005");
        createEmployeeSQL(employee5);
    }

    public void createEmployeeSQL (Employee employee) throws SQLException {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionDB = connection.getConnection();
        String showEmployee = "SELECT count(*) FROM Employee " +
                "WHERE username = '" + employee.getUsername() +"'";
        Statement statement = connectionDB.createStatement();
        ResultSet resultset = statement.executeQuery(showEmployee);
        while (resultset.next()) {
            if (resultset.getInt(1) == 0) {
                String signUp =
                        "INSERT INTO Employee (name, lastname, username, epassword, employ_ID) VALUES ('";
                String signUp2 = employee.getName() + "','" + employee.getLastname() + "','"
                        + employee.getUsername() + "','" + employee.getPassword() + "','" + employee.getEmploy_ID() + "')";
                String x = signUp + signUp2;
                Statement statement2 = connectionDB.createStatement();
                statement2.executeUpdate(x);
            }
        }
    }

    public boolean checkNull(String username, String password) {
        return username.equals("") || password.equals("");
    }

    public void handleLoginBtnOnAction(ActionEvent event) throws IOException {
        if (checkNull(employeeUsername.getText(), employeePassword.getText())) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error");
            error.setContentText("Please fill in the information.");
            error.setHeaderText(null);
            error.showAndWait();
        } else {
            DatabaseConnection connection = new DatabaseConnection();
            Connection connectionDB = connection.getConnection();

            String verifyLogin =
                    "SELECT count(1) FROM Employee " +
                            "WHERE username = '" + employeeUsername.getText() + "' AND epassword = '" + employeePassword.getText() + "'";
            try {
                Statement statement = connectionDB.createStatement();
                ResultSet queryOutput = statement.executeQuery(verifyLogin);
                while (queryOutput.next()) {
                    if (queryOutput.getInt(1) == 1) {
                        Button login = (Button) event.getSource();
                        Stage stage = (Stage) login.getScene().getWindow();

                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AssignOrArchive.fxml"));

                        stage.setScene(new Scene(loader.load(), 800, 600));

                        stage.show();
                    } else {
                        Alert error = new Alert(Alert.AlertType.ERROR);
                        error.setTitle("Error");
                        error.setContentText("Invalid username or password.");
                        error.setHeaderText(null);
                        error.showAndWait();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                e.getCause();
            }
        }
    }


    public void handleLoginBtn1OnAction (ActionEvent event) throws IOException {
        Button employBtn = (Button) event.getSource();
        Stage stage = (Stage) employBtn.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/loginAsCustomer.fxml"));

        stage.setScene(new Scene(loader.load(), 800, 600));

        stage.show();
    }

    public void handleLoginBtn11OnAction (ActionEvent event) throws IOException {
        Button managerBtn = (Button) event.getSource();
        Stage stage = (Stage) managerBtn.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/loginAsManager.fxml"));

        stage.setScene(new Scene(loader.load(), 800, 600));

        stage.show();
    }
}
