package ku.sa.managerthpost.controllers.managerController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ManaConfirmOrEndRepair {
    @FXML
    private Button backBtn;


    public void handleBackBtnOnAction (ActionEvent event) throws IOException {
        Button back = (Button) event.getSource();
        Stage stage = (Stage) back.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/loginAsManager.fxml"));

        stage.setScene(new Scene(loader.load(), 800, 600));

        stage.show();
    }
}
