package Assignment;
import java.util.*;

public class Truck{

	private Stack<Package> packageStack = new Stack<Package>();
	private int id;
	private int capacity;
	private int available_capacity;
	
	public Truck() {
		set_id(0);
		set_capacity(0);
		set_available_capacity(0);
	}
	
	public Truck(int id, int capacity) {
		set_id(id);
		set_capacity(capacity);
		set_available_capacity(capacity); // initial instance
	}
	
	public Truck(int id, int capacity, Package pack) {
		set_id(id);
		set_capacity(capacity);
		load(pack);
		set_available_capacity(capacity - pack.get_weight());
	}
	
	public void load(Package packageToLoad) {
		packageStack.push(packageToLoad);
	}
	public void unload() {
		packageStack.pop();
	}
	public int get_id() {
		return this.id;
	}
	public void set_id(int id) {
		this.id = id;
	}
	public int get_capacity() {
		return capacity;
	}
	public void set_capacity(int capacity) {
		this.capacity = capacity;
	}
	public int get_available_capacity() {
		return available_capacity;
	}
	public void set_available_capacity(int available_capacity) {
		this.available_capacity = available_capacity;
	}
	public void update_available_capacity() {
		int tempCapacity = this.capacity;
		Iterator<Package> iterate = packageStack.iterator();
		while(iterate.hasNext()) {
			Package temp = (Package) iterate.next();
			tempCapacity -= temp.get_weight();
		}
		this.available_capacity = tempCapacity;
	}
	
	public Stack<Package> getPacakgeInTruck() {
		return this.packageStack;
	}
}
