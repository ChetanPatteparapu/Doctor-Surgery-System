import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CommonUtil {

	public static void saveDoctorList(Object list, String fileName) {
		try {
			FileOutputStream file = new FileOutputStream(fileName+".txt");
			ObjectOutputStream outputFile = new ObjectOutputStream(file);
			outputFile.writeObject(list);
			outputFile.close();
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public static Object getList(String list) {
		ObjectInputStream inputFile = null;
		try {
			FileInputStream file = new FileInputStream(list+".txt");
			inputFile = new ObjectInputStream(file);
			if(list.contains("DoctorList")) {
				return ((DoctorList) inputFile.readObject());
			}else if(list.contains("PatientList")) {
				return ((PatientList) inputFile.readObject());
			}else if(list.contains("AppoinmentList")) {
				return ((AppoinmentList) inputFile.readObject());
			}
			
		} catch (Exception f) {
			System.err.println(f);
		} finally {
			try {
				inputFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;

	}
}
