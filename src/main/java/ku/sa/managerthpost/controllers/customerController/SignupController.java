package ku.sa.managerthpost.controllers.customerController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import ku.sa.managerthpost.service.DatabaseConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SignupController {

    @FXML
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextField idTextField;
    @FXML
    private ChoiceBox department;
    @FXML
    private Button doneSignUpBtn;
    @FXML
    private Button backSignupBtn;

    @FXML
    public void initialize () {
        department.getItems().addAll("BKK", "Pattaya", "Chiang Mai");
    }

    public void handleBackBtnOnAction (ActionEvent event) throws IOException {
        Button back = (Button) event.getSource();
        Stage stage = (Stage) back.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/loginAsCustomer.fxml"));

        stage.setScene(new Scene(loader.load(), 800, 600));

        stage.show();
    }

    public void doneSignUpBtnOnAction (ActionEvent event) {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connectionDB = connection.getConnection();
        String checkDuplicate = "SELECT count(1) FROM Customer " +
                "WHERE username = '" + usernameTextField.getText() + "'";
        try {
            Statement statement = connectionDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(checkDuplicate);
            boolean check = false;
            while(queryOutput.next()){
                if (queryOutput.getInt(1) == 1) {
                    check = false;
                    Alert error = new Alert(Alert.AlertType.ERROR);
                    error.setTitle("Sorry");
                    error.setContentText("Username is already used.");
                    error.setHeaderText(null);
                    error.showAndWait();
                    break;
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
                            "INSERT INTO customer (name, lastname, username, cpassword, cus_ID, cus_department, equipment) VALUES ("
                                    + "'" + firstnameTextField.getText() + "','" + lastnameTextField.getText() + "','" + usernameTextField.getText() + "','"
                                    + passwordTextField.getText() + "','" + idTextField.getText() + "','" + department.getValue() + "')";
                    Statement statement2 = connectionDB.createStatement();
                    ResultSet queryOutput2 = statement2.executeQuery(signUp);
                    Alert information = new Alert(Alert.AlertType.INFORMATION);
                    information.setTitle("Information");
                    information.setContentText("Success!");
                    information.setHeaderText(null);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
    }

//                         "INSERT INTO customer (name, lastname, username, cpassword, cus_ID, cus_department, equipment) VALUES ("
//                                 + "'" + + "','" + lastnameTextField.getText() + "','" + usernameTextField.getText() + "','"
//                                 + passwordTextField.getText() + "','" + idTextField.getText() + "','" + department.getValue() + "')";

}
