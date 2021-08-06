package Assignment;
import java.util.*;

public class DataList implements DataListInterface{

	// ----------------------------------- [ VARIABLES ]
	private ArrayList<Package> AllPackages; 		// to store all pre-processed packages for every method/algo (num of items)
	private ArrayList<Truck> AllTrucks; 		    // to store all filled trucks generated (bins used)
	
	// ----------------------------------- [ CONSTRUCTOR ]
	public DataList() {
		this.AllPackages = new ArrayList<>();
		this.AllTrucks = new ArrayList<>();
	}
	
	// ----------------------------------- [ ACCESSOR METHODS ]
	public ArrayList<Package> getAllPackages() {
		return this.AllPackages;
	}
	
	public ArrayList<Truck> getAllTrucks() {
		return this.AllTrucks;
	}
	
	// ----------------------------------- [ METHODS ]
	// ================================== 1) Add Methods ==================================
	public void add(Package tempPackage) {
		AllPackages.add(tempPackage);
	}
	
	public void add(Truck tempTruck) {
		AllTrucks.add(tempTruck);
	}
	
	// ================================== 2) Clear Methods ================================
	public void clearAllPackages() {
		AllPackages.clear();
	}
	
	public void clearAllTrucks() {
		AllTrucks.clear();
	}
	
	// ================================== 3)  Methods ====================================
	public int getTotalNumOfPackages() {
		return this.AllPackages.size();
	}
	
	public int getTotalNumOfTrucks() {
		return this.AllTrucks.size();
	}
	
	public void loadTruck(int truckID, Package pack, int capacity) {
		int count = -1;
		for (Truck tempTruck: this.AllTrucks) {
			++count;
			if(tempTruck.get_id() == truckID) {
				this.AllTrucks.get(count).load(pack);
				this.AllTrucks.get(count).set_available_capacity(capacity);
				break;
			}
		}
	}
}
