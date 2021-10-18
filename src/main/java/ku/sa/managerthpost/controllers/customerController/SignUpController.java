package ku.sa.managerthpost.controllers.customerController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import ku.sa.managerthpost.models.Customer;
import ku.sa.managerthpost.models.User;
import ku.sa.managerthpost.service.SignUpService;

import java.io.IOException;

public class SignUpController {

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
    private SignUpService service;

    @FXML
    public void initialize () {
        department.getItems().addAll("กรุงเทพมหานคร", "กำแพงเพชร", "ชัยนาท", "นครนายก", "นครปฐม", "ปทุมธานี", "พระนครศรีอยุธยา");
    }

    public boolean checkNull (String username, String password, String firstname, String lastname, String ID, String department) {
        return username.equals("") || password.equals("") || firstname.equals("") || lastname.equals("")
                || ID.equals("") || department.equals("");
    }

    public void handleBackBtnOnAction (ActionEvent event) throws IOException {
        Button back = (Button) event.getSource();
        Stage stage = (Stage) back.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/loginAsCustomer.fxml"));

        stage.setScene(new Scene(loader.load(), 800, 600));

        stage.show();
    }

    public void doneSignUpBtnOnAction (ActionEvent event) {
        String tmp1 = (String)department.getValue();
        service = new SignUpService(usernameTextField.getText(), lastnameTextField.getText(),
                firstnameTextField.getText(), idTextField.getText(), tmp1);
        if (!(checkNull(firstnameTextField.getText(), lastnameTextField.getText(),
                usernameTextField.getText(), passwordTextField.getText(), idTextField.getText(), tmp1))){
            User register = new Customer(firstnameTextField.getText(), lastnameTextField.getText(),
                    usernameTextField.getText(), passwordTextField.getText(), idTextField.getText(), tmp1);
            String tmp2 = service.verifySignUpData(register);
            if (tmp2.equals("Username is already used.")){
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Error");
                error.setContentText("Username is already used.");
                error.setHeaderText(null);
                error.showAndWait();
            } else if (tmp2.equals("Successfully register.")){
                Alert information = new Alert(Alert.AlertType.INFORMATION);
                information.setTitle("Information");
                information.setContentText("Success!");
                information.setHeaderText(null);
                information.showAndWait();
            }
        } else {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error");
            error.setContentText("Please fill in the information.");
            error.setHeaderText(null);
            error.showAndWait();
        }
    }
}
