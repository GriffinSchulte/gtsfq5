package gtsfq5foodlogger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Griffin Schulte
 */
public class LoginPageController extends SceneSwitch implements AlertInterface {
    
    @FXML
    private TextField username;
    
    @FXML
    private TextField password;
    
    String usernameString = "Griffin";
    String passwordString = "Password123";

    @FXML
    private void goToLog(ActionEvent event) {
        if(username.getText().equals(usernameString) && password.getText().equals(passwordString)) {
            SceneSwitch.switchTo("LogViewer");
        } else {
            showAlert();
            username.setText("");
            password.setText("");
        }
    }

    @Override
    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Wrong Credentials");
        alert.setContentText("Username: Griffin \n Password: Password123");
        alert.showAndWait();
    }
}
