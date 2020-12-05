import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AppoinmentList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<Appoinment> appoinmentList = new ArrayList<>();

	public List<Appoinment> getAppoinmentList() {
		return appoinmentList;
	}

	public void setAppoinmentList(List<Appoinment> appoinmentList) {
		this.appoinmentList = appoinmentList;
	}
	
	
}
