package Assignment;

public class Application {
	public static void main(String[] args) {
		DataListInterface dataLists = new DataList();
		Controller controller = new Controller(dataLists);
	    Main main = new Main();
	    main.setController(controller);
	    main.initiate();
	}
}