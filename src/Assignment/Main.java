/* A) Assignment Assumptions:
 * PACKAGE DETAILS:
 * 1. WEIGHT
 * 		- Measured only in KG (only in Integer)
 * 
 * 2. SIZE
 * 		- Assume that company has estimated that the load limit for each truck has taken into account the size of parcel (regardless of how big or small)
 * 		- Hence, size is disregarded in the calculation of the two following approximation algorithms
 * 
 * 3. NUM OF PACKAGES
 * 		- Any number of packages is acceptable
 * 
 * TRUCK DETAILS:
 * 1. LOAD LIMIT
 * 		- Each truck has a load limit of:
 * 			i) 10/100/1000KG (using text file)
 * 			ii) is dynamic and can be specified by user (using user input)
 * 		- Package weight cannot be > truck capacity
 * 
 * SUMMARY:
 * 		In each delivery batch, the algorithm would determine which PACKAGE should be loaded into which TRUCK.
 * 		
 * 		- Trucks = bins
 * 		- truckCapacity = capacity
 * 		- Packages = objects
 * 		- Package Weight = size
 * 1. The program is driven by a main menu which allows user to choose to:
 * 		A. use existing data in text file
 * 			- program behavior will take the very first value of the text file as truck capacity
 * 			- the subsequent values will be for the packages
 * 
 * 		B. manually enter data input
 * 			- program will prompt user to enter truck capacity / all packages
 * 			- program will continue to prompt user for packages data input until user enters "0" to stop the process
 * 	Section A: Constructor/Accessor methods
 * 		public void setTruckCapacity(int truckCapacity)
 * 		public void setTempAvailableCapacity(int tempAvailableCapacity)
 * 		public void addToInputDataPackages(int inputData)
 * 		public void clearInputDataPackages()
 * 
 * 	Section B : Navigation/Data Processing methods
 * 		public void initiate()
 * 		public void getDataFromFile()
 * 		public int promptUserInput()
 * 		public ArrayList<Integer> sortPackages(ArrayList<Integer> data)
 * 		public int loadData(int inputType, int algorithmType, ArrayList<Integer> inputDataPackages)
 * 		public void displayLoadedData(int type)
 * 
 * 	Section C : Algorithm methods
 * 		public void initiateAlgorithm(int algorithmType)
 * 		public int computeAvailableCapacity(int truckAvailableCapacity, int packageWeight)
 * 		public void NextFit(Package currentPackage)
 * 		public void BestFitDecreasing(Package currentPackage)
 * 		public void displayResults()
 * 
 * 	Section D : Exception/Error handling methods
 * 		public int intInput(int x, int y, int type)
 * 		public int intInputValidation(int lower, int upper) throws IllegalArgumentException
 * 		public void delayFor5Miliseconds()
 */
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
	
	/* -------------------------------------------------------------------
	 * ------------ Section A : Constructor/Accessor methods -------------
	 * ------------------------------------------------------------------- */
	
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
	
	/* -------------------------------------------------------------------
	 * --------- Section B : Navigation/Data Processing methods ----------
	 * ------------------------------------------------------------------- */
	
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
	
	// B4 : Method to sort packages in decreasing order
	public ArrayList<Integer> sortPackages(ArrayList<Integer> data){
		Collections.sort(data, Collections.reverseOrder());
		return data;
	}
	
	// B5 : Method to load data from (text/user) and according to algorithm (NF/BFD)
	public int loadData(int inputType, int algorithmType, ArrayList<Integer> inputDataPackages) {
		control.clearAllPackages();
		control.clearAllTrucks();
		/* inputType(1) = Text File
		 * inputType(2) = User Input
		 * choice(1) = NextFit()
		 * choice(2) = BestFitDecreasing()
		 */
		if(algorithmType != 1)
			inputDataPackages = sortPackages(inputDataPackages);
		
		int packageID = -1;
		for(int count = 0; count<inputDataPackages.size(); count++) {
			packageID++;
			control.add(new Package(packageID, inputDataPackages.get(count)));
		}
		System.out.println("Loaded "+control.getTotalNumOfPackages()+" instances of package");
		if (inputType == 1)
			displayLoadedData(1);
		else
			displayLoadedData(2);
		return algorithmType;
	}
	
	// B6 : Method to display loaded data
	public void displayLoadedData(int type) {
		int count = 0;
		if(type == 1)
			System.out.println("\n<<Loaded data from text file>>");
		else
			System.out.println("\n<<Received data from user>>");
		System.out.println("Truck Capacity: " + truckCapacity);
		System.out.print("Packages: ");
		ArrayList<Package> temp = control.getAllPackages();
		for(Package tempPackage: temp) {
			count++;
			System.out.print(tempPackage.get_weight());
			if(count != control.getTotalNumOfPackages())
				System.out.print(", ");
		}
		System.out.print("\n");
	}
	
	/* -------------------------------------------------------------------
	 * ----------------- Section C : Algorithm methods -------------------
	 * ------------------------------------------------------------------- */
	
	// C1 : Method to initiate NextFit/BestFitDecreasing algorithm
	public void initiateAlgorithm(int algorithmType) {
		int truckID = 0, count = 0;
		setTempAvailableCapacity(truckCapacity);
		
		// STEP 01: Initial run (create initial truck)
		// ===========================================
		control.add(new Truck(truckID, truckCapacity));
		
		// STEP 02: Get all packages
		ArrayList<Package> rawPackage = control.getAllPackages();
		
		if(algorithmType == 1)
			System.out.print("\n<<Next Fit (NF) Algorithm>>");
		else
			System.out.print("\n<<Best Fit Decreasing (BFD) Algorithm>>");
		System.out.print("\n=====================================================================================");
		System.out.print("\nSteps\tPackage\tCondition\t\t\tAction");
		System.out.println("\n=====================================================================================");
		
		// STEP 03: For each package
		for(Package processingPackage: rawPackage) {
			System.out.print("\nStep "+ ++count);
			
			// STEP 04: Initiate algorithm to fit package into truck
			if(algorithmType == 1)
				NextFit(processingPackage);
			else
				BestFitDecreasing(processingPackage); 
		}
		displayResults();
	}

	// C2 : Method to calculate available capacity for each (truck + package) combination
	public int computeAvailableCapacity(int truckAvailableCapacity, int packageWeight) {
		// if truck is FULL or is -VE capacity
		if (truckAvailableCapacity == 0 || truckAvailableCapacity < packageWeight) 
			return -1;
		else
			return truckAvailableCapacity - packageWeight;
	}
	
	// C3 : Method to implement Next Fit algorithm
	public void NextFit(Package currentPackage) {
		int availableCapacity = -1, tempTruckID = -1;

		// (NF) STEP 05: Get all trucks
		// ============================
		ArrayList<Truck> rawTruck = control.getAllTrucks();
		
		// (NF) STEP 06: Get current (active) truck
		// ========================================
		Truck processingTruck = rawTruck.get(rawTruck.size() - 1);

		// (NF) STEP 07: Calculate Available Capacity (for loading the current package into the current truck)
		// ===================================================================================================
		availableCapacity = computeAvailableCapacity(processingTruck.get_available_capacity(), currentPackage.get_weight());

		System.out.print("\t  "+currentPackage.get_weight()+" \tTruck("+processingTruck.get_id()+") / Available("+availableCapacity+")\t");
		
		/* The current truck (active) + package combination has to go through the following conditions; then decide either one of these actions:
		 * 1. Load into Truck
		 * 2. Create new Truck + Load into Truck
		*/
		
		// (NF) STEP 08: Determine which condition is fulfilled
		// =====================================================
		// << CONDITION >>
		if (availableCapacity > 0) // (Condition 1) Package can fit into current Truck
			tempTruckID = processingTruck.get_id();
		else if (availableCapacity <= 0) // (Condition 2) Package cannot fit into current Truck
			tempTruckID = -1;

		// (NF) STEP 09: Take appropriate action
		// =====================================
		// << ACTION >>
		if (tempTruckID != -1) { // SCENARIO 1: FIT PERFECTLY / CAN FIT
			
			// (Action 1) > Load into Truck
			control.loadTruck(tempTruckID, currentPackage, availableCapacity);
			System.out.println("\tloadIntoTruck(" + tempTruckID + ")");
		} 
		else { // SCENARIO 2: CAN'T FIT INTO ANY TRUCK 
			
			// (Action 2) > Create New Truck + Load into newly created Truck
			control.add(new Truck(control.getTotalNumOfTrucks(), truckCapacity, currentPackage));
			System.out.println("createNewTruck(" + (control.getTotalNumOfTrucks() - 1) + ") + loadIntoTruck("+ (control.getTotalNumOfTrucks() - 1) + ")");
		}
		System.out.println("_____________________________________________________________________________________");
	}

	// C4 : Method to implement Best Fit Decreasing algorithm
	public void BestFitDecreasing(Package currentPackage) {
		int availableCapacity = -1, count = 0, tempTruckID =- 1, tempAvail = tempAvailableCapacity;
		
		// (BFD) STEP 05: Get all trucks
		// =============================
		ArrayList<Truck> rawTruck = control.getAllTrucks();
		
		// (BFD) STEP 06: For each truck
		// =============================
		for (Truck processingTruck : rawTruck) {
			count++;
			
			// (BFD) STEP 07: Calculate Available Capacity (for loading the current package into the current truck)
			// ====================================================================================================
			availableCapacity = computeAvailableCapacity(processingTruck.get_available_capacity(), currentPackage.get_weight());
			
			System.out.print("\t  "+currentPackage.get_weight()+" \tTruck("+processingTruck.get_id()+") / Available("+availableCapacity+")\t");
			if(count != control.getTotalNumOfTrucks())
				System.out.print("\n");
			
			/* Each truck + package combination has to go through the following conditions; then decide either one of these actions:
			 * 1. Load into Truck
			 * 2. Create new Truck + Load into Truck
			*/
			
			// (BFD) STEP 08: Determine which condition is fulfilled
			// =====================================================
			// << CONDITION >>
			if (availableCapacity >= 0) { // (Condition 1) Package can fit into current Truck
				// CHOOSE the truck with least remaining space | if >=2 truck's remaining space is the same, load into first one
				if(availableCapacity < tempAvail) {  
					tempAvail = availableCapacity;
					tempTruckID = processingTruck.get_id();
				}
				continue;
			} 
			else if(availableCapacity < 0) // (Condition 2) Package cannot fit into current Truck
				continue;
			else if(count == control.getTotalNumOfTrucks()) // CONTINUE checking REMAINING trucks
				break;
		}
		
		// (BFD) STEP 09: Take appropriate action
		// ======================================
		// << ACTION >>
		if(tempTruckID != -1) { // SCENARIO 1: FIT PERFECTLY / CAN FIT
			
			// (Action 1) > Load into Truck - with least avail space
			control.loadTruck(tempTruckID, currentPackage, tempAvail);
			System.out.println("\tloadIntoTruck("+tempTruckID+")");
		}
		else if(count == control.getTotalNumOfTrucks()) { // SCENARIO 2: CAN'T FIT INTO ANY TRUCK 
			
			// (Action 2) > Create New Truck + Load into newly created Truck
			control.add(new Truck(control.getTotalNumOfTrucks(), truckCapacity, currentPackage));
			System.out.println("createNewTruck("+(control.getTotalNumOfTrucks()-1)+") + loadIntoTruck("+(control.getTotalNumOfTrucks()-1)+")");	
		}
		System.out.println("_____________________________________________________________________________________");
	}
	
	// C5 : Method to display results (total bins used)
	public void displayResults() {
		ArrayList<Truck> rawTrucks = control.getAllTrucks();
		
		// STEP 10: Display total trucks used
		// ==================================
		System.out.println("\n<<Overall Results>>");
		for (Truck tempTruck : rawTrucks) {
			System.out.print("Truck(" + tempTruck.get_id() + ") | Remaining(" + tempTruck.get_available_capacity() + ") | Packages: ");
			Stack<Package> packagesInTruck = tempTruck.getPacakgeInTruck();
			while (!packagesInTruck.empty()) {
				Package temp = packagesInTruck.pop();
				System.out.print(temp.get_weight() + " ");
			}
			System.out.print("\n");
		}
		System.out.println("\nOptimal number of trucks (bins) used to pack "+ control.getTotalNumOfPackages() +" packages is "+ control.getTotalNumOfTrucks()+ " trucks");
	}
	
	/* -------------------------------------------------------------------
	 * ---------- Section D : Exception/Error handling methods -----------
	 * ------------------------------------------------------------------- */
	
	// D1 : Combination of Method D2 and D3
	public int intInput(int x, int y, int type) {
		int data = -1, doWhile = -1;
		do {
			if (type == 0)
				System.out.print(">>Choice: ");
			else
				System.out.print(">>Input: ");
			try {
				data = intInputValidation(x, y);
				doWhile = 1;
			} catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
				delayFor5Miliseconds();
				doWhile = 0;
			}
		} while (doWhile != 1);
		return data;
	}
	
	// D2 : Method for integer input validation
	public int intInputValidation(int lower, int upper) throws IllegalArgumentException {
		setScanner(new Scanner(System.in));
		int userInput;
		if (scan.hasNextLine()) {
			String tempString = scan.nextLine();
			// Check if blank / only whitespace
			if (tempString.isEmpty() == true)
				throw new IllegalArgumentException("\nNot allowed to enter blank values!");
			else
				// Check if is valid integer
				try {
					userInput = Integer.parseInt(tempString);
				} catch (NumberFormatException e) {
					throw new IllegalArgumentException("\nEnter integers Only!");
				}

			// Check if range is the same, if yes, can only enter that value
			if (lower == upper)
				if (userInput != lower)
					throw new IllegalArgumentException("\nEnter " + lower + " only!");
				else
					return userInput;

			// Check if it is within range
			if (userInput < lower || userInput > upper)
				throw new IllegalArgumentException("\nEnter values between " + lower + " and " + upper + " only!");
			else
				return userInput;
		} else
			throw new IllegalArgumentException("\nEnter integers Only!");
	}
 
	// Method D3 : Delay execution for 5 seconds
	public void delayFor5Miliseconds() {
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e1) {
			System.err.print(e1.getMessage());
		}
	}
}
