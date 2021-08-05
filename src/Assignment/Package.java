package Assignment;

public class Package {

	private int id;
	private int weight;
	
	public Package(int id, int weight) {
		set_id(id);
		set_weight(weight);
	}
	public int get_id() {
		return id;
	}
	public void set_id(int id) {
		this.id = id;
	}
	public int get_weight() {
		return weight;
	}
	public void set_weight(int weight) {
		this.weight = weight;
	}
}
