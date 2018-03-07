import java.util.Scanner;

public class ChuckALuck {
	public static int AMOUNT_OF_DICE = 3; 
	public static int SLIDES_OF_DICE = 6; 
	public static int INDEX_START_VALUE = 0; 
	
	public static double MIN_WALLET_AMOUNT = 0.0;

	public static int TRIPLE_PAYOUT = 30; 
	public static int STANDARD_PAYOUT =1; 

	public static int TRIPLE_CASE_NUM =1; 
	public static int FIELD_CASE_NUM =2; 
	public static int HIGH_CASE_NUM =3; 
	public static int LOW_CASE_NUM =4; 

	public static int MAX_VALUE_LOW = 11; 
	public static int MIN_VALUE_HIGH = 10; 
	public static int MAX_VALUE_FIELD = 12; 
	public static int MIN_VALUE_FIELD = 8; 

	public static int ALL_ONES_VALUE = 3; 
	public static int ALL_TWO_VALUE = 6; 
	public static int ALL_THREE_VALUE = 9; 
	public static int ALL_FOUR_VALUE = 12; 
	public static int ALL_FIVE_VALUE = 15; 
	public static int ALL_SIX_VALUE = 18; 

	public static void main(String[] args) {
		System.out.println("Welcome to Chuck-A-Luck"); 
		boolean isgameOver  = false;
		Wallet userWallet = new Wallet(); 
		Scanner inputScanner = new Scanner(System.in); 
		initiateWallet( userWallet, inputScanner);
		double userStartingCash = userWallet.check();
	
		while(!isgameOver && userWallet.check() > MIN_WALLET_AMOUNT )
		{
			inputScanner = new Scanner(System.in); 
			String betString = null;
			System.out.println("What type of bet do you want to place?"); 
			System.out.println("If you want to leave the game, enter Quit"); 
			System.out.print("Low, High, Field or Triple?: "); 

			betString = generatingBet( inputScanner);
			
			if(betString.equals("Low") || betString.equals("High") 
					|| betString.equals("Field") || betString.equals("Triple") )
			{
				resolveBet(betString, userWallet,inputScanner);
			}

			else if( betString.equals("Quit"))
			{
				isgameOver = true; 
			}
			else 
			{
				System.out.println( "Sorry, this isn't a valid bet type");
			}
		}
		inputScanner.close(); 
		gameOver(userWallet,userStartingCash );
	}

	public static void initiateWallet( Wallet userWallet, Scanner walletScanner ) 
	{ 
		boolean walletEmpty = true;  
		while( walletEmpty)
		{
			System.out.print("How much cash do you have?: ");
			if( walletScanner.hasNextDouble())
			{
				double usersStartingCash =  walletScanner.nextDouble(); 
				userWallet.put(usersStartingCash);
				walletEmpty = false;
			}
			else if(walletScanner.hasNext() )
			{
				System.out.println("Sorry, this isn't a valid input");
				walletScanner = new Scanner(System.in); 
			}
		}
	}

	private static String generatingBet(Scanner inputScanner) {
		String betString =null;
		boolean gettingBet = true;
		while( gettingBet)
		{
			if(inputScanner.hasNextLine())
			{
				betString = inputScanner.nextLine();
				gettingBet = false;
			}
		}
		return betString;
	}

	public static void resolveBet( String betType,  Wallet userWallet, Scanner betScanner  )
	{
		Dice[] diceArray = new Dice[AMOUNT_OF_DICE]; 
		int betCase = -1; 
		int payoutMul = STANDARD_PAYOUT;
		int diceTotal = 0; 

		switch (betType)
		{
		case "Triple": 
			payoutMul = TRIPLE_PAYOUT; 
			betCase = TRIPLE_CASE_NUM; 
			break; 

		case "Field": 
			payoutMul = STANDARD_PAYOUT; 
			betCase = FIELD_CASE_NUM; 
			break; 

		case "Low": 
			payoutMul = STANDARD_PAYOUT; 
			betCase = LOW_CASE_NUM; 
			break; 

		case "High": 
			payoutMul = STANDARD_PAYOUT; 
			betCase = HIGH_CASE_NUM; 
			break; 

		default: 
			break; 
		}

		for( int index =INDEX_START_VALUE; index < diceArray.length; index++)
		{

			diceArray[index] = new Dice(SLIDES_OF_DICE);	
			diceArray[index].roll();	
			diceTotal +=  diceArray[index].topFace(); 
		}

		boolean calculateBettingAmount = true; 
		double betAmount = -1; 	
		System.out.println( userWallet.toString() );	
		while(calculateBettingAmount )
		{
			System.out.print("How much would you like to bet?: "); 
			if( betScanner.hasNextDouble())
			{
				betAmount =  betScanner.nextDouble(); 
				if( betAmount <= userWallet.check() )
				{
					calculateBettingAmount = false;
				}
				else 
				{
					System.out.println("Sorry, You didn't have enough money for this bet.");
					betScanner = new Scanner(System.in); 
				}
			}
			else if(betScanner.hasNext() )
			{
				System.out.println("Sorry, this isn't a valid input");
				betScanner = new Scanner(System.in); 
			}
		}
		if( isBetWon( betCase, diceTotal, diceArray))
		{
			System.out.println("Congrats, your Bet was correct.");
			userWallet.put( payoutMul * betAmount);
		}
		else
		{
			System.out.println("Sorry, your Bet was incorrect.");
			userWallet.get(betAmount);
		}
		printDisc(diceArray, diceTotal);
	}

	public static boolean isBetWon( int betCase, int diceTotal, Dice[] diceArray )
	{
		boolean betWon =false;
		if( betCase == TRIPLE_CASE_NUM) 
		{
			if (diceArray[INDEX_START_VALUE].topFace() == diceArray[INDEX_START_VALUE +1 ].topFace() 
					&& diceArray[INDEX_START_VALUE].topFace() == diceArray[INDEX_START_VALUE +2 ].topFace()  )
			{
				if(diceTotal == ALL_SIX_VALUE || diceTotal == ALL_ONES_VALUE )
				{
					betWon = false; 
				}
				else 
				{
					betWon = true;  
				}
			}
			else 
			{
				betWon = false; 	
			}
		}

		else if( betCase == FIELD_CASE_NUM) 
		{
			if(diceTotal < MIN_VALUE_FIELD || diceTotal > MAX_VALUE_FIELD )
			{
				betWon = true; 
			}
			else 
			{
				betWon = false; 
			}
		}

		else if( betCase == HIGH_CASE_NUM) 
		{
			if(diceTotal == ALL_SIX_VALUE )
			{
				betWon = false; 
			}
			else if (diceTotal == ALL_FIVE_VALUE )
			{
				if (diceArray[INDEX_START_VALUE].topFace() == diceArray[INDEX_START_VALUE +1 ].topFace()
						&& diceArray[INDEX_START_VALUE].topFace() == diceArray[INDEX_START_VALUE +2 ].topFace() )
				{
					betWon = false; 
				}
				else 
				{
					betWon = true; 
				}
			}
			else if (diceTotal == ALL_FOUR_VALUE )
			{
				if (diceArray[INDEX_START_VALUE].topFace() == diceArray[INDEX_START_VALUE +1 ].topFace()
						&& diceArray[INDEX_START_VALUE].topFace() == diceArray[INDEX_START_VALUE +2 ].topFace())
				{
					betWon = false; 
				}
				else 
				{
					betWon = true; 
				}
			}
			else if(diceTotal > MIN_VALUE_HIGH )
			{ 
				betWon = true; 
			}
			else 
			{
				betWon = false; 
			}
		}

		else if( betCase == LOW_CASE_NUM) 
		{
			if(diceTotal == ALL_ONES_VALUE )
			{
				betWon = false; 
			}
			else if (diceTotal == ALL_TWO_VALUE )
			{
				if (diceArray[INDEX_START_VALUE].topFace() == diceArray[INDEX_START_VALUE +1 ].topFace()
						&& diceArray[INDEX_START_VALUE].topFace() == diceArray[INDEX_START_VALUE +2 ].topFace())
				{
					betWon = false; 
				}
				else 
				{
					betWon = true; 
				}
			}
			else if (diceTotal == ALL_THREE_VALUE )
			{
				if (diceArray[INDEX_START_VALUE].topFace() == diceArray[INDEX_START_VALUE +1 ].topFace()
						&& diceArray[INDEX_START_VALUE].topFace() == diceArray[INDEX_START_VALUE +2 ].topFace() )
				{
					betWon = false; 
				}
				else 
				{
					betWon = true; 
				}
			}
			else if(diceTotal < MAX_VALUE_LOW )
			{ 
				betWon = true; 
			}
			else 
			{
				betWon = false; 
			}
		}
		return betWon; 
	}

	public static void printDisc(Dice[] diceArray, int diceTotal) 
	{
		System.out.println("The Dice for this round were: ");
		for( int index = INDEX_START_VALUE; index < diceArray.length; index++)
		{
			System.out.println( diceArray[index]);
		}
		System.out.println(" The Total was : " + diceTotal);
		System.out.println("");
	}

	public static void gameOver(Wallet userWallet, double  userStartingCash)
	{
		System.out.println("This game of Chuck-a-Luck is over"); 
		System.out.println( userWallet.toString() );	
		if( userWallet.check() == MIN_WALLET_AMOUNT)
		{
			System.out.println("Unforunately, you lost all your money :( "); 
		}
		else 
		{
			double diffFromStartingAmount = ( userWallet.check() - userStartingCash); 
			if (diffFromStartingAmount == 0 )
			{
				System.out.println("You didn't make or lose any money!"); 
			}
			else if (diffFromStartingAmount >  0 )
			{
				String winings = Double.toString(diffFromStartingAmount);
				System.out.println("Congrats! You made " + winings+  " euro."); 
			}
			else
			{
				String winings = Double.toString(diffFromStartingAmount);
				System.out.println("Hard luck! You lost " + winings +  " euro."); 
			}
		}
	}
}
