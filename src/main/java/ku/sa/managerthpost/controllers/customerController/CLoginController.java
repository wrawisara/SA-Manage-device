package ku.sa.managerthpost.controllers.customerController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ku.sa.managerthpost.models.Customer;
import ku.sa.managerthpost.service.DatabaseConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CLoginController {

    @FXML
    private Button loginBtn;
    @FXML
    private Button signUpBtn;
    @FXML
    private Button loginBtn1;
    @FXML
    private Button loginBtn11;
    @FXML
    private TextField cusUsername;
    @FXML
    private PasswordField cusPassword;

    private Customer customer;

    public void handleLoginBtnOnAction (ActionEvent event) throws IOException {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionDB = connection.getConnection();

        String verifyLogin =
                "SELECT count(1) FROM Customer " +
                        "WHERE username = '" + cusUsername.getText() +"' AND cpassword = '" + cusPassword.getText() + "'";
        try {
            Statement statement = connectionDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(verifyLogin);
            while (queryOutput.next()){
                if (queryOutput.getInt(1) == 1){
                    Button login = (Button) event.getSource();
                    Stage stage = (Stage) login.getScene().getWindow();

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/CusCreateOrConfirm.fxml"));

                    stage.setScene(new Scene(loader.load(), 800, 600));

                    stage.show();
                } else {
                    Alert error = new Alert(Alert.AlertType.ERROR);
                    error.setTitle("Error!");
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

    public void handleSignUpBtnOnAction (ActionEvent event) throws IOException{
        Button signup = (Button) event.getSource();
        Stage stage = (Stage) signup.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Signup.fxml"));

        stage.setScene(new Scene(loader.load(), 800, 600));

        stage.show();
    }

    public void handleLoginBtn1OnAction (ActionEvent event) throws IOException {
        Button employBtn = (Button) event.getSource();
        Stage stage = (Stage) employBtn.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/loginAsEmployee.fxml"));

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
