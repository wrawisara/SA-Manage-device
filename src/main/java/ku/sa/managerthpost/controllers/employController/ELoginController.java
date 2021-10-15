package ku.sa.managerthpost.controllers.employController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ELoginController {
    @FXML
    private Button loginBtn;
    @FXML
    private Button loginBtn1;
    @FXML
    private Button loginBtn11;
    @FXML
    private TextField employUsername;
    @FXML
    private PasswordField employPassword;


    public void handleLoginBtnOnAction (ActionEvent event) throws IOException {
        // check username and password
        //          ..
        //          ..
        //          ..
        Button login = (Button) event.getSource();
        Stage stage = (Stage) login.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AssignOrArchive.fxml"));

        stage.setScene(new Scene(loader.load(), 800, 600));

        stage.show();
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
