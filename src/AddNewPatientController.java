import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class AddNewPatientController {
	@FXML
	private Button btnSave, btnCancel;

	@FXML
	private TextField txtName, txtAge;
	
	@FXML
	private TextArea txtAllergies;
	
	@FXML
	private RadioButton radMale,radFemale;
	private boolean isSaved = false;
	private Patient patient;

	@FXML
	public void initialize() {
		ToggleGroup radioGroup = new ToggleGroup();
		radMale.setToggleGroup(radioGroup);
		radFemale.setToggleGroup(radioGroup);
		radMale.setSelected(true);
	}
	
	@FXML
	private void handleMainAction(ActionEvent event) {
		 if(event.getSource() == btnSave) {  
			 patient = new Patient();
			 patient.setPatientName(txtName.getText());
			 patient.setMale(radMale.isSelected());
			 patient.setAge(Integer.parseInt(txtAge.getText()));
			 patient.setAllergies(txtAllergies.getText());
	
			 isSaved = true;
			 Stage stage = (Stage) btnSave.getScene().getWindow();
		     stage.close();
		 }else if(event.getSource() == btnCancel) {
			 isSaved = false;
			 Stage stage = (Stage) btnSave.getScene().getWindow();
		     stage.close();
		 }
	}

	public boolean isSaved() {
		return isSaved;
	}

	public Patient getPatient() {
		return patient;
	}
}
