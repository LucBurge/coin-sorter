import java.util.Scanner;

public class testCoinSorter {
	public static int menuChoice;
	public static void main(String[] args) {
		
		// creates a Coin Sorter object
		CoinSorter test = new CoinSorter();
		
		
		
		// creates a scanner to gather user input
		Scanner sc = new Scanner(System.in);
		
		
		
		
		do 
		{
			mainMenu(); //displays main menu
			
			
			try
			{
			System.out.println("Please select an option (1-6):");
			String enterMenuChoice = sc.next(); //takes user input to choose an option from the menu
			menuChoice = Integer.parseInt(enterMenuChoice);
			
			}
			catch (NumberFormatException numExcep)
			{
				System.out.println("Error. Invalid input");
			}
			
			
			
			
			//OPTION 1 COIN CALCULATOR
			
			
			
			if(menuChoice == 1) 
			{
				try {//try block to set button action when user input is in a valid format
				int totalCoinIn;
				int coinTypeIn;
				
				do 
				{ //do while loop repeats until the user enters a valid total value to exchange
					
					
					System.out.println("Please enter the coin type you wish to exchange: ");
					
					String enterCoinTypeIn = sc.next(); //takes user input for coin type to exchange
					coinTypeIn = Integer.parseInt(enterCoinTypeIn); //converts string input to integer to use in calculation
					
					
					
					System.out.println("Please enter the total value you wish to exchange: ");
					String enterTotalCoinIn = sc.next(); //takes user input for total value
					totalCoinIn = Integer.parseInt(enterTotalCoinIn);
				
				
				
					totalCoinIn = test.validateTotalValue(totalCoinIn); //validates that total value is within min-max range
				
				
					
					if(totalCoinIn == -1) 
					{
						System.out.println("Sorry, this total value is not a valid input. Please enter a number from " + test.getMinCoinIn() + "-" + test.getMaxCoinIn()); 
					}
				
					else 
					{
						if(coinTypeIn < 1 || coinTypeIn > test.getMaxCoinIn()) // checks coin type in is an expected value
        				{
        					
        					System.out.println("Error. Invalid input."); //displays the output of coin calculator if user input was invalid 
        					
        				}
						
						else {

						System.out.println(test.coinCalculator(coinTypeIn)); //displays calculation result if user input was valid
						
						}
					}
					
						
					
					} while (totalCoinIn == -1);
					
				}
				
				catch (NumberFormatException numExcep) //catch block to set button action when user input is in an invalid format
				{
					System.out.println("Sorry. This is not a valid input."); //displays message to inform user input was not valid
				}
		
					
					
			}
		
				
			
			//OPTION 2 MULTI COIN CALULATOR
			
			
			
			else if(menuChoice == 2) 
			{
				try
				{
				
				int totalCoinIn;
				int excludedCoinIn;
				
				do { //do while loop repeats until the user enters a valid total value to exchange
				
					System.out.println("Please enter the total value you wish to exchange: ");
					String enterTotalCoinIn = sc.next(); //takes user input for total value
					totalCoinIn = Integer.parseInt(enterTotalCoinIn); //converts input to integer to use in calculation
				
					System.out.println("Please enter the coin type you wish to exclude: ");
					String enterExcludedCoinIn = sc.next(); //takes user input for coin type to exclude
					excludedCoinIn = Integer.parseInt(enterExcludedCoinIn); //converts input to integer to use in calculation
				
				
					test.validateTotalValue(totalCoinIn); //validates that total value is within min-max range
					test.validateExcludedCoin(excludedCoinIn); //validates that the excluded coin entered is a coin currently in circulation
				
				
				
					if(test.validateTotalValue(totalCoinIn) == -1) 
					{
						System.out.println("Sorry, this total value is not a valid input. Please enter a number from " + test.getMinCoinIn() + "-" + test.getMaxCoinIn()); 
					}
					
					else if(test.validateExcludedCoin(excludedCoinIn) == -1) 
					{
						System.out.println("Sorry, this excluded coin is not a valid input. " + test.printCoinList());
					}
				
					else 
					{
						System.out.println(test.multiCoinCalculator()); //prints calculation result
					}
				
					} while (test.validateTotalValue(totalCoinIn) == -1 || test.validateExcludedCoin(excludedCoinIn) == -1);
				
				}
				
				catch(NumberFormatException numExcep) 
				{
					System.out.println("Sorry. This is not a valid input."); //displays message to inform user input was not valid
				}
				
			}
			
			
			
			//OPTION 3 DISPLAY COIN LIST
			
			
			
			else if(menuChoice == 3) {
				System.out.println(test.printCoinList());
			}
			
			
			
			//OPTION 4 SET PROGRAM CONFIGURATIONS
			
			
			
			else if(menuChoice == 4) {
				
				try
				{
					
				int subMenuChoice;
				
				do {
					subMenuOption4();
					System.out.println("Please make a choice (1-4):");
					subMenuChoice = sc.nextInt();
					
					if(subMenuChoice == 1) 
						{
				
						System.out.println("Enter a currency: ");
						String currencyIn = sc.next();
						test.setCurrency(currencyIn);
						System.out.println("Your chosen currency is: " + currencyIn);
						}
				
					else if(subMenuChoice == 2) 
						{
						System.out.println("Enter a minimum coin input value: ");
						String enterCoinIn = sc.next();
						int coinIn = Integer.parseInt(enterCoinIn); //converts input to integer to use in calculation
						test.setMinCoinIn(coinIn);
						System.out.println("Your chosen minimum coin value is: " + coinIn);
						}
				
					else if(subMenuChoice == 3) 
						{
						System.out.println("Enter a maximum coin input value: ");
						String enterCoinIn = sc.next();
						int coinIn = Integer.parseInt(enterCoinIn); //converts input to integer to use in calculation
						test.setMaxCoinIn(coinIn);
						System.out.println("Your chosen maximum coin value is: " + coinIn);
						}
				
						else if(subMenuChoice == 4) 
						{
						break;
						}
				
					else 
					{
						System.out.println("Error. Please select a number from 1-4.");
					}
				
				} while(subMenuChoice != 4);
				
			
			}
				
			catch (NumberFormatException numExcep) //catch block to set button action when user input is in an invalid format
			{
				System.out.println("Sorry. This is not a valid input."); //displays message to inform user input was not valid
			}
				
			}
			
			
			
			//OPTION 5 DISPLAY PROGRAM CONFIGURATIONS
			
			
			
			else if(menuChoice == 5) //displays current program configurations for currency and min/max total values
			{
				System.out.println(test.displayProgramConfigs());
			}
			
			
			
			//OPTION 6 EXIT PROGRAM
			
			
			
			else if(menuChoice == 6) //displays message to user before program terminates
			{
				System.out.println("You have chosen to quit the program. Goodbye!");
			}
			
			
			
			//UNEXPECTED INPUT
			
			
			
			else //prompts user to enter a number from 1-6 if they enter a number outside this range
			{ 
				System.out.println("Error. Please enter a number from 1-6");
			} 
		
			
			
			
			
			
			
		}while(menuChoice != 6); //loop ends when menu choice 6 is entered, terminating the program
		
		sc.close(); //closes scanner

	}
	
	
	
	
	
	
	public static void mainMenu() //displays main menu
	{
		System.out.println();
		System.out.println("***Coin Sorter - Main Menu***");
		System.out.println("1 - Coin calculator");
		System.out.println("2 - Multiple coin calculator");
		System.out.println("3 - Print coin list");
		System.out.println("4 - Set details");
		System.out.println("5 - Display program configurations");
		System.out.println("6 - Quit the program");
		System.out.println();
		
	}
	
	public static void subMenuOption4() //displays sub menu for option 4 (set details)
	{
		
		System.out.println("***Set Details Sub-Menu***");
		System.out.println("1 - Set currency");
		System.out.println("2 - Set minimum coin input value");
		System.out.println("3 - Set maximum coin input value");
		System.out.println("4 - Return to main menu");
		
	}
	
	


}
