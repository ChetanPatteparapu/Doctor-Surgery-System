import java.io.Serializable;
import java.util.Date;

public class Appoinment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Patient patient;
	private Doctor doctor;
	private String status;
	private String diagnosis;
	private String treatment;
	private String appoinmentDate;
	
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public String getAppoinmentDate() {
		return appoinmentDate;
	}
	public void setAppoinmentDate(String appoinmentDate) {
		this.appoinmentDate = appoinmentDate;
	}

	
}
