import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PatientList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Patient> patientList = new ArrayList<>();

	public List<Patient> getPatientList() {
		return patientList;
	}

	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}
	
	
}
