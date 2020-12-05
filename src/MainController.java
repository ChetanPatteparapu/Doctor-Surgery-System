import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainController {

	@FXML
	private Button btnViewDoctor, btnViewPatient, btnViewAppoinment, btnAddDoctor, btnAddPatient, btnAddAppoinment,
	btndocEdit, btndocSave,	btndocCancel,btnPatientEdit,btnPatientCancel,btnPatientSave,btnApSave;
	@FXML
	private Pane paneDoctor, panePatient, paneAppoinment;
	
	@FXML
	private TextField txtDoctorName, txtSpecialisedArea, txtQualifications, txtChannelingFee, txtPatientName,txtPatientAge
	,txtApPatientName,txtApAppoinmentDate,txtApAge;
	
	@FXML
	private TextArea txtApDiagnosis,txtApTreatment;

	@FXML
	private RadioButton radMale,radFemale,radPatientMale,radPatientFemale,radApMale,radApFemale;
	
	@FXML
	private ComboBox<Doctor> cmbDoctor ;
	
	@FXML
	private ComboBox<Patient> cmbPatient ;
	
	@FXML
	private ComboBox<Appoinment> cmbAppoinment ;
	
	@FXML
	private MenuItem menuAddDoctor,menuAddPatient,menuMakeAnAppoinment;
	
	private DoctorList doctorList;
	private PatientList patientList;
	private AppoinmentList appoinmentList;
	
	public MainController() {
		try {
			doctorList = (DoctorList) CommonUtil.getList("DoctorList");
			
			
		}catch(Exception e) {
			doctorList = new DoctorList();
		}
		try {
			patientList = (PatientList) CommonUtil.getList("PatientList");
		}catch(Exception e) {
			patientList = new PatientList();
		}
		try {
			appoinmentList = (AppoinmentList) CommonUtil.getList("AppoinmentList");
		}catch(Exception e) {
			appoinmentList = new AppoinmentList();
		}
	
	}
	
	@FXML
	public void initialize() {
		
		cmbDoctor.getItems().addAll(doctorList.getDoctorList());
		cmbPatient.getItems().addAll(patientList.getPatientList());
		cmbAppoinment.getItems().addAll(appoinmentList.getAppoinmentList());
		
		ToggleGroup radioGroup = new ToggleGroup();
		radApFemale.setToggleGroup(radioGroup);
		radApMale.setToggleGroup(radioGroup);
		radApMale.setSelected(true);
	}
	
	@FXML
	public void onDropDownChanged(ActionEvent event) {
		if (event.getSource() == cmbDoctor) {
			Doctor doctor = cmbDoctor.getSelectionModel().getSelectedItem();
			setDoctorData(doctor);
			
		}else if(event.getSource() == cmbPatient) {
			Patient patient = cmbPatient.getSelectionModel().getSelectedItem();
			setPatientData(patient);
		}else if(event.getSource() == cmbAppoinment) {
			Appoinment appoinment = cmbAppoinment.getSelectionModel().getSelectedItem();
			setAppoinmentData(appoinment);
		}
	}
	
	@FXML
	public void onEditAction(ActionEvent event) {
		if (event.getSource() == btndocEdit) {
			docEdit();
		}else if (event.getSource() == btndocSave) {
			docSave();
		}else if (event.getSource() == btndocCancel) {
			docCancel();
		}else if (event.getSource() == btnPatientEdit) {
			patientEdit();
		}else if (event.getSource() == btnPatientSave) {
			patientSave();
		}else if (event.getSource() == btnPatientCancel) {
			patientCancel();
		}else if (event.getSource() == btnApSave) {
			Appoinment appoinment = cmbAppoinment.getSelectionModel().getSelectedItem();
			appoinmentList.getAppoinmentList().remove(appoinment);
			appoinment.setDiagnosis(txtApDiagnosis.getText());
			appoinment.setTreatment(txtApTreatment.getText());
			appoinmentList.getAppoinmentList().add(appoinment);
			CommonUtil.saveDoctorList(appoinmentList, "AppoinmentList");
		}
	}
	
	private void docEdit() {
		btndocEdit.setVisible(false);
		btndocSave.setVisible(true);
		btndocCancel.setVisible(true);
		txtChannelingFee.setEditable(true);
		txtQualifications.setEditable(true);
		txtSpecialisedArea.setEditable(true);
	}
	
	private void patientEdit() {
		btnPatientEdit.setVisible(false);
		btnPatientSave.setVisible(true);
		btnPatientCancel.setVisible(true);
		txtPatientAge.setEditable(true);
		
	}
	
	
	private void docSave() {
		Doctor doctor = cmbDoctor.getSelectionModel().getSelectedItem();
		doctorList.getDoctorList().remove(doctor);
		doctor.setChannelingFee(Integer.parseInt(txtChannelingFee.getText()));
		doctor.setQualifications(txtQualifications.getText());
		doctor.setSpecialisedArea(txtSpecialisedArea.getText());
		doctorList.getDoctorList().add(doctor);
		CommonUtil.saveDoctorList(doctorList, "DoctorList");
		btndocEdit.setVisible(true);
		btndocSave.setVisible(false);
		btndocCancel.setVisible(false);
		txtChannelingFee.setEditable(false);
		txtQualifications.setEditable(false);
		txtSpecialisedArea.setEditable(false);
	}
	
	private void patientSave() {
		Patient patient = cmbPatient.getSelectionModel().getSelectedItem();
		patientList.getPatientList().remove(patient);
		patient.setAge(Integer.parseInt(txtPatientAge.getText()));
		patientList.getPatientList().add(patient);
		CommonUtil.saveDoctorList(patientList, "PatientList");
		btnPatientEdit.setVisible(true);
		btnPatientSave.setVisible(false);
		btnPatientCancel.setVisible(false);
		txtPatientAge.setEditable(false);
	}
	
	private void docCancel() {
		btndocEdit.setVisible(true);
		btndocSave.setVisible(false);
		btndocCancel.setVisible(false);
		txtChannelingFee.setEditable(false);
		txtQualifications.setEditable(false);
		txtSpecialisedArea.setEditable(false);
	}
	private void patientCancel() {
		btnPatientEdit.setVisible(true);
		btnPatientSave.setVisible(false);
		btnPatientCancel.setVisible(false);
		txtPatientAge.setEditable(false);
	}
	
	public void setDoctorData(Doctor doctor) {
		txtDoctorName.setText(doctor.getDoctorName());
		txtQualifications.setText(doctor.getQualifications());
		txtSpecialisedArea.setText(doctor.getSpecialisedArea());
		txtChannelingFee.setText(Integer.toString(doctor.getChannelingFee()));
		radMale.setSelected(doctor.isMale());
		radFemale.setSelected(!doctor.isMale());
	}
	
	public void setPatientData(Patient patient) {
		txtPatientName.setText(patient.getPatientName());
		txtPatientAge.setText(Integer.toString(patient.getAge()));
		radPatientFemale.setSelected(!patient.isMale());
		radPatientMale.setSelected(patient.isMale());
		
	}
	
	private void setAppoinmentData(Appoinment appoinment) {
		txtApPatientName.setText(appoinment.getPatient().getPatientName());
		txtApAppoinmentDate.setText(appoinment.getAppoinmentDate());
		txtApDiagnosis.setText(appoinment.getDiagnosis());
		txtApTreatment.setText(appoinment.getTreatment());
		txtApAge.setText(Integer.toString(appoinment.getPatient().getAge()));
		radApFemale.setSelected(!appoinment.getPatient().isMale());
		radApMale.setSelected(appoinment.getPatient().isMale());

	}

	@FXML
	private void handleMainMenuButtonAction(ActionEvent event) {
		if (event.getSource() == btnViewDoctor) {
			disableAllPanes();
			paneDoctor.setVisible(true);
		}else if(event.getSource() == btnViewPatient) {
			disableAllPanes();
			panePatient.setVisible(true);
		}else if(event.getSource() == btnViewAppoinment) {
			disableAllPanes();
			paneAppoinment.setVisible(true);
		}else if(event.getSource() == btnAddDoctor || event.getSource() == menuAddDoctor) {
			addNewDoctor();
		}else if(event.getSource() == btnAddPatient || event.getSource() == menuAddPatient) {
			addNewPatient();
		}else if(event.getSource() == btnAddAppoinment || event.getSource() == menuMakeAnAppoinment) {
			addAppoinment();
		}
	}
	private void disableAllPanes() {
		paneDoctor.setVisible(false);
		panePatient.setVisible(false);
		paneAppoinment.setVisible(false);

	}
	
	
	
	private void addNewDoctor() {
	    try {
	        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("AddNewDocter.fxml"));
	        Parent root =fxmlLoader.load();
	        Scene scene = new Scene(root);
	        Stage stage = new Stage();    
	        stage.setScene(scene);
	        AddNewDoctorController controller = fxmlLoader.<AddNewDoctorController>getController();
	        stage.showAndWait();
	        if(controller.isSaved() ) {
	          doctorList.getDoctorList().add(controller.getDoctor());
	          CommonUtil.saveDoctorList(doctorList, "DoctorList");
	          cmbDoctor.getItems().add(controller.getDoctor());
	          
	        }
	       
	       
	      } catch (IOException e) {
	        e.printStackTrace();
	       
	      }
	}
	
	private void addNewPatient() {
	    try {
	        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("AddNewPatient.fxml"));
	        Parent root =fxmlLoader.load();
	        Scene scene = new Scene(root);
	        Stage stage = new Stage();    
	        stage.setScene(scene);
	        AddNewPatientController controller = fxmlLoader.<AddNewPatientController>getController();
	        stage.showAndWait();
	        if(controller.isSaved() ) {
	          patientList.getPatientList().add(controller.getPatient());
	          CommonUtil.saveDoctorList(patientList, "PatientList");
	          cmbPatient.getItems().add(controller.getPatient());
	          
	        }
	       
	       
	      } catch (IOException e) {
	        e.printStackTrace();
	       
	      }
	}
	
	private void addAppoinment() {
	    try {
	        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("AddAppoinment.fxml"));
	        Parent root =fxmlLoader.load();
	        Scene scene = new Scene(root);
	        Stage stage = new Stage();    
	        stage.setScene(scene);
	        AddAppoinmentController controller = fxmlLoader.<AddAppoinmentController>getController();
	        controller.setDoctorList(doctorList);
	        controller.setPatientList(patientList);
	        stage.showAndWait();
	        if(controller.isSaved() ) {
	        	Patient patient = controller.getPatient();
	          patientList.getPatientList().remove(patient);
	          if(patient.getPreviousAppoinments() == null) {
	        	  ArrayList<Appoinment> list = new ArrayList<>();
	        	  list.add(controller.getAppoinment());
	        	  patient.setPreviousAppoinments(list);
	          }else {
	        	  patient.getPreviousAppoinments().add(controller.getAppoinment());
	          }
	          
	          patientList.getPatientList().add(patient);
	          CommonUtil.saveDoctorList(patientList, "PatientList");
	          cmbPatient.getItems().add(patient);
	          appoinmentList.getAppoinmentList().add(controller.getAppoinment());
	          CommonUtil.saveDoctorList(appoinmentList, "AppoinmentList");
	          cmbAppoinment.getItems().add(controller.getAppoinment());
	        }
	       
	       
	      } catch (IOException e) {
	        e.printStackTrace();
	       
	      }
	}

}
