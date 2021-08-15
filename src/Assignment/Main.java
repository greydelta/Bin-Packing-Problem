package Assignment;
import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class Main {
	// ----------------------------------- [ VARIABLES ]
	private Scanner scan;
	private Controller control;
	
	// ----------------------------------- [ ASSUMPTION VARIABLES ]
	private int truckCapacity = 0;
	private int tempAvailableCapacity = 0;
	private ArrayList<Integer> inputDataPackages = new ArrayList<>();
	// ----------------------------------- [ CONSTRUCTOR ]
	public Main() {
		scan = null;
		control = null;
	}
	
	// ----------------------------------- [ ACCESSOR METHODS ]
	public void setScanner(Scanner scan) {
		this.scan = scan;
	}
	
	public void setController(Controller cont) {
		this.control = cont;
	}
	
	public void setTruckCapacity(int truckCapacity) {
		this.truckCapacity = truckCapacity;
	}
	
	public void setTempAvailableCapacity(int tempAvailableCapacity) {
		this.tempAvailableCapacity = tempAvailableCapacity;
	}
	
	public void addToInputDataPackages(int inputData) {
		inputDataPackages.add(inputData);
	}
	
	public void clearInputDataPackages() {
		inputDataPackages.clear();
	}
	
	// B1 : Method to initiate program Main Menu
	public void initiate() {
		int mainMenuChoice = -1, userInputFlag = -1, algorithmType =-1;
		do {
			System.out.println("\n<<Main Menu>>");
			System.out.println("=====================================================================================");
			System.out.println(" This program utilizes the following algorithms for the bin packing problem: ");
			System.out.println("\t1. Next Fit");
			System.out.println("\t2. Best Fit Decreasing");
			System.out.println("=====================================================================================");
			System.out.println("Would you like to,");
			System.out.println("1. Use data from text file");
			System.out.println("2. Enter your own data");
			System.out.println("3. Exit the system");

			mainMenuChoice = intInput(1, 3, 0);

			switch (mainMenuChoice) {
			case 1:
				getDataFromFile();
				algorithmType = loadData(1, 1, inputDataPackages);
				initiateAlgorithm(algorithmType);
				getDataFromFile();
				algorithmType = loadData(1, 2, inputDataPackages);
				initiateAlgorithm(algorithmType);
				break;
			case 2:
				userInputFlag = promptUserInput();
				if(userInputFlag !=1) {
					algorithmType = loadData(2, 1, inputDataPackages);
					initiateAlgorithm(algorithmType);
					algorithmType = loadData(2, 2, inputDataPackages);
					initiateAlgorithm(algorithmType);
				}
				System.out.println("\n<<User terminated data input process>>");
				break;
			case 3:
				System.out.println("\nThank you & have a nice day!");
				System.exit(0);
				break;
			}
		} while (mainMenuChoice != 3);
	}
	
	// B2 : Method to get data from text file
	public void getDataFromFile() {
		int count = 0;
		clearInputDataPackages();
		System.out.println("\n<<Using text file data>>");
		//File initialDataFromFile = new File("data.txt"); // truckCapacity = 10 optimal = 4
		//File initialDataFromFile = new File("data2.txt"); // truckCapacity = 10 optimal = 3
		File initialDataFromFile = new File("data3.txt"); // truckCapacity = 100 optimal = 2
		//File initialDataFromFile = new File("data4.txt"); // truckCapacity = 100 optimal = 11
		//File initialDataFromFile = new File("data5.txt"); // truckCapacity = 10 optimal = 3
		//File initialDataFromFile = new File("data6.txt"); // truckCapacity = 1000 optimal = 12
		try {
			setScanner(new Scanner(initialDataFromFile));
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		while(scan.hasNextLine()) {
			String dataFromFile = scan.nextLine();
			if(count == 0) {
				setTruckCapacity(Integer.parseInt(dataFromFile));
				setTempAvailableCapacity(Integer.parseInt(dataFromFile));
			}
			else
				addToInputDataPackages(Integer.parseInt(dataFromFile));
			count++;
		}
	}
	
	// B3 : Method to get data from user input
	public int promptUserInput() {
		clearInputDataPackages();
		int input = 0, userInputFlag = -1;
		System.out.println("\n<<Using user input data>>");
		System.out.println("=====================================================================================");
		System.out.println(" This process involves user entering Truck & Package data as follows: ");
		System.out.println("\t1. User enters Truck Capacity (maximum is 1000 KG/1 Tonne)");
		System.out.println("\t2. User enters All Packages (weight)");
		System.out.println("\t(loop until user enters (0) to quit)");
		System.out.println("\t\tIF user enters any value > 0 && value <= Truck Capacity");
		System.out.println("\t\t\tTHEN insert into data");
		System.out.println("\t\tELSE IF user enters value = 0");
		System.out.println("\t\t\tTHEN terminate data input process");
		System.out.println("=====================================================================================");
		System.out.println("\n<<Enter Truck Capacity>>");
		this.truckCapacity = intInput(1, 1000, 1);
		System.out.println("\n<<Enter all packages>>");
		System.out.println("**Enter (0) to STOP/TERMINATE input package process");
		int iteration = 0;
		do {
			iteration++;
			System.out.print("Enter Weight for Package("+ iteration +"): ");
			input = intInput(0, truckCapacity, 1);
			if (input != 0)
				addToInputDataPackages(input);
			else
				if(iteration == 1){
					userInputFlag = 1;
					break;
				}
		} while (input != 0);
		return userInputFlag;
	}
}
