import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class AddNewDoctorController {
	@FXML
	private Button btnSave, btnCancel;

	@FXML
	private TextField txtName, txtSpecialisedArea, txtQualifications, txtChannelingFee;
	@FXML
	private RadioButton radMale,radFemale;
	private boolean isSaved = false;
	private Doctor doctor;

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
			 doctor = new Doctor();
			 doctor.setDoctorName(txtName.getText());
			 doctor.setMale(radMale.isSelected());
			 doctor.setQualifications(txtQualifications.getText());
			 doctor.setSpecialisedArea(txtSpecialisedArea.getText());
			 doctor.setChannelingFee(Integer.parseInt(txtChannelingFee.getText()));
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

	public Doctor getDoctor() {
		return doctor;
	}
	
	
}
