package Assignment;
import java.util.*;

public interface DataListInterface{
	public ArrayList<Package> getAllPackages();
	public ArrayList<Truck> getAllTrucks();
	public void add(Package tempPackage);
	public void add(Truck tempTruck);
	public void clearAllPackages();
	public void clearAllTrucks();
	public int getTotalNumOfPackages();
	public int getTotalNumOfTrucks();
	public void loadTruck(int truckID, Package pack, int capacity);
}
