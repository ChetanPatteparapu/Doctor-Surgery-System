import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Patient implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String patientName;
	private boolean isMale;
	private int age;
	private List<Appoinment> previousAppoinments = new ArrayList<>();
	private String allergies;
	
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public boolean isMale() {
		return isMale;
	}
	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Appoinment> getPreviousAppoinments() {
		return previousAppoinments;
	}
	public void setPreviousAppoinments(List<Appoinment> previousAppoinments) {
		this.previousAppoinments = previousAppoinments;
	}
	public String getAllergies() {
		return allergies;
	}
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	
	@Override
	public String toString() {
		return patientName;
	}
	
}
