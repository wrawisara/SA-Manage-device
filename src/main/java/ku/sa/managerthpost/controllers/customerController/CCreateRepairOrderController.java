package ku.sa.managerthpost.controllers.customerController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class CCreateRepairOrderController {
    @FXML
    private ComboBox deviceNameBtn;
    @FXML
    private DatePicker DateField;
    @FXML
    private ComboBox typeField;
    @FXML
    private Label repairID;
    @FXML
    private Button createBtn;
    @FXML
    private Button back;

    public void handleBackBtnOnAction (ActionEvent event) throws IOException {
        Button back = (Button) event.getSource();
        Stage stage = (Stage) back.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/CusCreateOrConfirm.fxml"));

        stage.setScene(new Scene(loader.load(), 800, 600));

        stage.show();
    }


}
