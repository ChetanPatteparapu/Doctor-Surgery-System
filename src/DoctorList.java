import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DoctorList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<Doctor> doctorList = new ArrayList<>();

	public List<Doctor> getDoctorList() {
		return doctorList;
	}

	public void setDoctorList(List<Doctor> doctorList) {
		this.doctorList = doctorList;
	}
	
	
}
