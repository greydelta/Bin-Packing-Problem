package Assignment;
import java.util.*;

public class Controller {

	// ----------------------------------- [ VARIABLES ]
	private DataListInterface DataLists;
	
	// ----------------------------------- [ CONSTRUCTOR ]
	public Controller(DataListInterface DataLists) {
		this.DataLists = DataLists;
	}

	// ----------------------------------- [ ACCESSOR METHODS ]
	public ArrayList<Package> getAllPackages() {
		return DataLists.getAllPackages();
	}
	
	public ArrayList<Truck> getAllTrucks() {
		return DataLists.getAllTrucks();
	}
	
	// ----------------------------------- [ METHODS ]
	public void add(Package tempPackage) {
		DataLists.add(tempPackage);
	}
	
	public void add(Truck tempTruck) {
		DataLists.add(tempTruck);
	}
	
	public void clearAllPackages() {
		DataLists.clearAllPackages();
	}
	
	public void clearAllTrucks() {
		DataLists.clearAllTrucks();
	}
	
	public int getTotalNumOfPackages() {
		return DataLists.getTotalNumOfPackages();
	}
	
	public int getTotalNumOfTrucks() {
		return DataLists.getTotalNumOfTrucks();
	}
	
	public void loadTruck(int truckID, Package pack, int capacity) {
		DataLists.loadTruck(truckID, pack, capacity);
	}
}
