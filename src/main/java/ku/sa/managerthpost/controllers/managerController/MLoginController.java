package ku.sa.managerthpost.controllers.managerController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ku.sa.managerthpost.models.Employee;
import ku.sa.managerthpost.models.User;
import ku.sa.managerthpost.service.DatabaseConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MLoginController {
    private User manager;

    @FXML
    private TextField managerUsername;
    @FXML
    private TextField managerPassword;
    @FXML
    private Button loginBtn;

    @FXML
    public void initialize () throws SQLException {
        createManager();

    }

    public void createManager () throws SQLException {
        manager = new User("Rawisara", "Mawilerd", "admin", "1", "1");
        createManagerSQL(manager);
    }

    public void createManagerSQL (User manager) throws SQLException {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionDB = connection.getConnection();
        String showManager = "SELECT count(*) FROM User " +
                "WHERE username = '" + manager.getUsername() +"'";
        Statement statement = connectionDB.createStatement();
        ResultSet resultset = statement.executeQuery(showManager);
        while (resultset.next()) {
            if (resultset.getInt(1) == 0) {
                String signUp =
                        "INSERT INTO User (name, lastname, username, upassword, user_ID) VALUES ('";
                String signUp2 = manager.getName() + "','" + manager.getLastname() + "','"
                        + manager.getUsername() + "','" + manager.getPassword() + "','" + manager.getId() + "')";
                String x = signUp + signUp2;
                Statement statement2 = connectionDB.createStatement();
                statement2.executeUpdate(x);
            }
        }
    }

    public boolean checkNull (String username, String password) {
        return username.equals("") || password.equals("");
    }

    public void handleLoginBtnOnAction (ActionEvent event) throws IOException {
        if (checkNull(managerUsername.getText(), managerPassword.getText())) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error");
            error.setContentText("Please fill in the information.");
            error.setHeaderText(null);
            error.showAndWait();
        } else {
            DatabaseConnection connection = new DatabaseConnection();
            Connection connectionDB = connection.getConnection();

            String verifyLogin =
                    "SELECT count(1) FROM User " +
                            "WHERE username = '" + managerUsername.getText() + "' AND upassword = '" + managerPassword.getText() + "'";
            try {
                Statement statement = connectionDB.createStatement();
                ResultSet queryOutput = statement.executeQuery(verifyLogin);
                while (queryOutput.next()) {
                    if (queryOutput.getInt(1) == 1) {
                        Button login = (Button) event.getSource();
                        Stage stage = (Stage) login.getScene().getWindow();

                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/manaConfirmOrEndRepair.fxml"));

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

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/loginAsEmployee.fxml"));

        stage.setScene(new Scene(loader.load(), 800, 600));

        stage.show();
    }
}
