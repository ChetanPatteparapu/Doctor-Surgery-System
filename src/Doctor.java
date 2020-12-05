import java.io.Serializable;

public class Doctor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String doctorName;
	private boolean isMale;
	private String specialisedArea;
	private String qualifications;
	private int channelingFee;
	
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public boolean isMale() {
		return isMale;
	}
	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}
	public String getSpecialisedArea() {
		return specialisedArea;
	}
	public void setSpecialisedArea(String specialisedArea) {
		this.specialisedArea = specialisedArea;
	}
	public String getQualifications() {
		return qualifications;
	}
	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}
	public int getChannelingFee() {
		return channelingFee;
	}
	public void setChannelingFee(int channelingFee) {
		this.channelingFee = channelingFee;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return doctorName;
	}
}
