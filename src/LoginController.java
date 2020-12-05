import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	@FXML
	private Button btnLogin;
	@FXML
	private TextField txtUsername;
	@FXML
	private PasswordField txtPassword;

	@FXML
	private void handleLoginButtonAction(ActionEvent event) {
		if (event.getSource() == btnLogin) {
			if ("admin".equals(txtUsername.getText()) && "admin".equals(txtPassword.getText())) {
				System.out.println("Loggein");
				 try {
				     
				      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainView.fxml"));
				      Parent root =fxmlLoader.load();
				      Scene scene = new Scene(root);
				      Stage stage = new Stage(); 
				      stage.setScene(scene);
				
				      stage.show();
				      Stage stage2 = (Stage) btnLogin.getScene().getWindow();
						stage2.close();
				    } catch (IOException e) {
				      e.printStackTrace();
				    }
			} else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
			    alert.setTitle("Error");
			    alert.setHeaderText("Login Error");
			    alert.setContentText("Invalid username or password");
			    alert.showAndWait();
			}
		}
	}
}
