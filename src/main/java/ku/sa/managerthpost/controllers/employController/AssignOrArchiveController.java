package ku.sa.managerthpost.controllers.employController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AssignOrArchiveController {

    @FXML
    private DatePicker dateGetCost;
    @FXML
    private TextField costTextField;
    @FXML
    private DatePicker dateTurnBack;
    @FXML
    private TableView tableView;
    @FXML
    private Button BackSignupBtn;

    public void handleBackBtnOnAction (ActionEvent event) throws IOException {
        Button back = (Button) event.getSource();
        Stage stage = (Stage) back.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/loginAsEmployee.fxml"));

        stage.setScene(new Scene(loader.load(), 800, 600));

        stage.show();
    }
}
