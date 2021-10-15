package ku.sa.managerthpost.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class THPostAppController {

    @FXML
    private Button cusLogin;
    @FXML
    private Button managerLogin;
    @FXML
    private Button employLogin;

    public void handleCusLoginOnAction (ActionEvent event) throws IOException {
        Button login1 = (Button) event.getSource();
        Stage stage = (Stage) login1.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/loginAsCustomer.fxml"));

        stage.setScene(new Scene(loader.load(), 800, 600));

        stage.show();
    }

    public void handleEmployLoginOnAction (ActionEvent event) throws IOException {
        Button login2 = (Button) event.getSource();
        Stage stage = (Stage) login2.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/loginAsEmployee.fxml"));

        stage.setScene(new Scene(loader.load(), 800, 600));

        stage.show();
    }

    public void handleManagerLoginOnAction (ActionEvent event) throws IOException {
        Button login3 = (Button) event.getSource();
        Stage stage = (Stage) login3.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/loginAsManager.fxml"));

        stage.setScene(new Scene(loader.load(), 800, 600));

        stage.show();
    }
}
