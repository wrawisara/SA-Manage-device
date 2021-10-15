package ku.sa.managerthpost.controllers.customerController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CCreateOrConfirmController {

    @FXML
    private Button BackSignupBtn;
    @FXML
    private Button confirmCost;
    @FXML
    private Button createRepairOrder;

    public void handleBackUpBtnOnAction (ActionEvent event) throws IOException {
        Button BackSignUp = (Button) event.getSource();
        Stage stage = (Stage) BackSignUp.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/loginAsCustomer.fxml"));

        stage.setScene(new Scene(loader.load(), 800, 600));

        stage.show();
    }

    public void handleCreateRepairOrderBtnOnAction (ActionEvent event) throws IOException {
        Button repair = (Button) event.getSource();
        Stage stage = (Stage) repair.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/CusCreateRepairOrder.fxml"));

        stage.setScene(new Scene(loader.load(), 800, 600));

        stage.show();
    }
}
