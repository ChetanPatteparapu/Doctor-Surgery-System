import java.util.List;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddAppoinmentController {

	@FXML
	private ComboBox<Doctor> cmbDoctor;

	@FXML
	private ComboBox<Patient> cmbPatient;

	private DoctorList doctorList;
	private PatientList patientList;
	private boolean isSaved = false;
	private Doctor doctor;
	private Patient patient;
	private Appoinment appoinment;

	@FXML
	private TextField txtStatus, txtDate, txtChannelingFee;

	@FXML
	private Button btnAdd, btnCancel;

	@FXML
	public void initialize() {
		Platform.runLater(() -> {
			cmbDoctor.getItems().addAll(doctorList.getDoctorList());
			cmbPatient.getItems().addAll(patientList.getPatientList());

		});
	}

	@FXML
	public void onDropDownChanged(ActionEvent event) {
		if (event.getSource() == cmbDoctor) {
			doctor = cmbDoctor.getSelectionModel().getSelectedItem();
			txtChannelingFee.setText(Integer.toString(doctor.getChannelingFee()));

		} else if (event.getSource() == cmbPatient) {
			patient = cmbPatient.getSelectionModel().getSelectedItem();
		}
	}

	@FXML
	private void handleMainAction(ActionEvent event) {
		if (event.getSource() == btnAdd) {
			appoinment = new Appoinment();
			appoinment.setAppoinmentDate(txtDate.getText());
			appoinment.setDoctor(doctor);
			appoinment.setStatus(txtStatus.getText());
			appoinment.setPatient(patient);
			//patient.getPreviousAppoinments().add(appoinment);
			isSaved = true;
			Stage stage = (Stage) btnAdd.getScene().getWindow();
			stage.close();
		} else if (event.getSource() == btnCancel) {
			isSaved = false;
			Stage stage = (Stage) btnAdd.getScene().getWindow();
			stage.close();
		}
	}

	public DoctorList getDoctorList() {
		return doctorList;
	}

	public void setDoctorList(DoctorList doctorList) {
		this.doctorList = doctorList;
	}

	public PatientList getPatientList() {
		return patientList;
	}

	public void setPatientList(PatientList patientList) {
		this.patientList = patientList;
	}

	public boolean isSaved() {
		return isSaved;
	}

	public void setSaved(boolean isSaved) {
		this.isSaved = isSaved;
	}

	public Patient getPatient() {
		return patient;
	}

	public Appoinment getAppoinment() {
		return appoinment;
	}
	

}
