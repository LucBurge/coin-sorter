import java.util.ArrayList;
import java.util.Collections;

public class CoinSorter {
	
	
	// declarations of attributes to be used internally
	private String currency;
	private int minCoinIn;
	private int maxCoinIn;
	private int totalCoinIn;
	private int excludedCoin;
	private ArrayList<Integer> coinList = new ArrayList<Integer>();
	
	
	
	//CONSTRUCTORS
	
	
	
	// constructor that takes requires the user to set the program values 
	public CoinSorter(String currencyIn, int minCoinIn, int maxCoinIn, ArrayList<Integer> coinListIn) 
	{
		
		currency = currencyIn;
		this.minCoinIn = minCoinIn;
		this.maxCoinIn = maxCoinIn;
		coinList = coinListIn;
		
	}
	
	
	
	 // constructor that sets default program values
	public CoinSorter() 
	{
		
		currency = "Pound sterling";
		minCoinIn = 0;
		maxCoinIn = 10000;
		coinList.add(200);
		coinList.add(100);
		coinList.add(50);
		coinList.add(20);
		coinList.add(10);
		
	}
	
	
	
	// set methods
	public void setCurrency(String currencyIn) //sets internal attribute: currency
	{ 
		
		currency = currencyIn;
		
	}
	
	
	
	public void setMinCoinIn(int minCoinIn) //sets internal attribute: minimum value in
	{ 
		
		 this.minCoinIn = minCoinIn;
		 
	}
	
	
	
	public void setMaxCoinIn(int maxCoinIn) //sets internal attribute: maximum value in
	{ 
		
		this.maxCoinIn = maxCoinIn;
		
	}
	
	
	
	// get methods
	public String getCurrency() //gets internal attribute: currency
	{
		
		return currency;
		
	}
	
	
	
	public int getMinCoinIn() //gets internal attribute: minimum value in
	{
		
		return minCoinIn;
		
	}
	
	
	
	public int getMaxCoinIn() //gets internal attribute: maximum coin in
	{
		
		return maxCoinIn;
		
	}
	
	
	
	// method returns a String of the coins currently in circulation from internal attribute: coinList
	public String printCoinList() 
	{
		
		return "The coin denominations currently available are:\n" + coinList;
		
	}
	
	
	
	// validation methods
	public int validateTotalValue(int totalValueIn) //validates that total value is within the min-max range
	{
		
		if(totalValueIn >= getMinCoinIn() && totalValueIn <= getMaxCoinIn()) 
		{
			
			totalCoinIn = totalValueIn; //assigns the user input value to the internal attribute IF it is within the min-max range
		
		}
		
		else 
		{
			
			totalCoinIn = -1; //assigns a standard value to the internal attribute for checking purposes 
			
		}
		
		return totalCoinIn;
		
	}
	
	
	
	public int validateExcludedCoin(int excludedCoinIn) //validates that the coin to be excluded by user is one of the coins currently in circulation
	{
			
		if(coinList.contains(excludedCoinIn)) //assigns the user input for excluded coin to the internal attribute if it is contained in the list
		{
			
			excludedCoin = excludedCoinIn;
	
		}
			
		else 
		{
			
			excludedCoin = -1; //assigns a standard value to the internal attribute for checking purposes
			
		}
		
		return excludedCoin; 
		
	}
	
	
	
	// calculator methods
	public String coinCalculator(int coinTypeIn) 
	{
		
		int coinCalculation = totalCoinIn/coinTypeIn; //calculates the amount of coins that go into the total coin value
		int remainderCalculation = totalCoinIn%coinTypeIn; //calculates the remainder of coins
		
		return "A total of " + coinCalculation + "x " + coinTypeIn + "p coins can be exchanged, with a remainder of " + remainderCalculation + "p.";
		
	}
	
	
	
	public String multiCoinCalculator() 
	{
		
		//sorts the list to ensure it always favours larger values
		Collections.sort(coinList);
		Collections.reverse(coinList);
		
		
		
		//allows different values from within the for loop to be appended to the String on each run
		StringBuilder sb = new StringBuilder();
		sb.append("The coins exchanged are: ");
		
		
		
		for(int i=0; i < coinList.size(); i++) {
			
			if(coinList.get(i) != excludedCoin) 
			{
				
				int calculate = totalCoinIn / coinList.get(i);
				sb.append(calculate + "x " + coinList.get(i) + "p, ");
				totalCoinIn -= calculate * coinList.get(i);
				
			}
			
			else 
			{
				// do nothing for excluded value
			}
			
		}
		
		sb.append("with a remainder of " + totalCoinIn + "p."); //adds the remainder to the String
		return sb.toString();
		
	}
	
	
	
	//method displays current program configurations for min coin, max coin and currency
	public String displayProgramConfigs() 
	{
		
		return "Currency: " + currency + "\nMinimum input value: " + getMinCoinIn() + "\nMaximum input value: " + maxCoinIn;
	
	}
	
}
