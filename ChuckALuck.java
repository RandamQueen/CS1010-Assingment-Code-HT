
/* SELF ASSESSMENT 
1. ResolveBet
	I have correctly defined ResolveBet which takes the bet type (String) and the Wallet object,
 	and a void return type [Mark out of 7: ]. 6
	Comment: We took in the Bet type as a String and the Wallet Object. However, we also took in the
	Scanner as we found this was the best way to record additional inputs. 
	
	My program presents the amount of cash in the wallet and asks the user
	how much he/she would like to bet [Mark out of 8: ].8
	Comment: We asked the user to input the the amount of cash they currently have. It will only 
	accept a bet that is a double amount, aka it won't accept a String input. 
	
	My program ensures the bet amount is not greater than the cash in the wallet [Mark out of 5: ].5
	Comment:If a person enter an amount that more than the amount in their wallet, they will get a error
	message and asked to reenter an amount. 
	
	
	My program creates three Dice objects, rolls them and creates a total variable
	with a summation of the roll values returned [Mark out of 15: ]. 15
	Comment: Three dice objects were created and placed into an array. We rolled the dice and added up 
	the total of this dice rolls. 
	
	My program determines the winnings by comparing the bet type with the total
	and comparing the bet type with the dice faces for the triple bet [Mark out of 20: ].20 
	Comment: We used switch statements and our isBetWon function. The isBetWon function takes 
	the  betCase,  diceTotal and diceArray. If the bet was correct, we returna true value.  
	
	My program outputs the results (win or loss) and adds the winnings to the wallet 
	if user wins or removes the bet amount from the wallet if the user loses [Mark out of 10: ].10
	Comment: If the bet was won, we add the betting amount times the pay-out amount. If you lose, the money
	was removed from your account. We also printed our the dices rolls and the total.  

2. Main
	I ask the user for the amount of cash he/she has, 
	create a Wallet object and put this cash into it [Mark out of 15: ] 15
	Comment: We asked for the cash that the person has in there wallet and created the wallet. 
	If the user entered an non-double amount, we would ask them to reenter the amount.
	
	My program loops continuously until the user either enters quit or the cash in the wallet is 0 [Mark out of 5: ] 5 
	Comment: We tested to see if the user had no money left in the wallet or had quit the game. If the user enters
	'Quit', the boolean gameOver will be set to the value of true and exit the while loop. 
	
	I ask the user to enter any of the four bet types or quit [Mark out of 5: ].5
	Comment:We asked the user the enter the types Low,High, Triple and Field. If the users doesn't
	 enter any of these bet type or Quit, we displace an error message. 
	 
	My program calls resolveBet for each bet type entered [Mark out of 5: ].5
	Comment:If the user enters any of the bet type, we call the resolveBet method. 
	
	At the end of the game my program presents a summary message regarding winnings and losses [Mark out of 5: ] 5
	Comment: If the user lost all there money, we comment on this. Else, we say if overall did they make or lose 
	any money. 

 Total Mark out of 100 (Add all the previous marks):99
*/

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
