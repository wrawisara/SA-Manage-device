package ku.sa.managerthpost.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController {
    public void handleBackBtnOnAction (ActionEvent event) throws IOException {
        Button back = (Button) event.getSource();
        Stage stage = (Stage) back.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/loginAsCustomer.fxml"));

        stage.setScene(new Scene(loader.load(), 800, 600));

        stage.show();
    }
}
