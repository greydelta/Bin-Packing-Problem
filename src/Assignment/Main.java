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
