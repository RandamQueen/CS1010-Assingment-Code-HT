import java.util.Scanner;

public class XAndO {
	public static char NOUGHTS = 'O'; 
	public static char CROSSES = 'X'; 
	public static char BLANK = ' ';

	public static int NUMBER_OF_ROWS = 11;
	public static int NUMBER_OF_COLUMNS = 11;

	public static int ROW_INDEX =0; 
	public static int COLUMN_INDEX =1; 

	static Scanner boardScanner = new Scanner(System.in); 
	public static void main(String[] args) {

		gameStartText(); 
		char[][] xoArray = new char[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
		GameBoard xoBoard = new GameBoard(); 

		xoBoard.clearBoard(xoArray);
		xoBoard.printBoard(xoArray); 

		while(!xoBoard.isBoardFull(xoArray) && xoBoard.winner(xoArray) == BLANK)
		{
			char currentPlayer =BLANK;
			boolean inputtingCoordinates = true; 
			if(xoBoard.movesMade %2 == 0 )
			{	
				System.out.println("It is X's go!");
				currentPlayer =CROSSES; 
			}	
			else 
			{
				System.out.println("It is O's go!");
				currentPlayer =NOUGHTS; 
			}

			while(inputtingCoordinates)
			{
				System.out.print("Co-ordinates for the next move:  ");
				if(boardScanner.hasNextLine())
				{
					String cordString = boardScanner.nextLine();
					if( cordString.length() == 2  )
					{
						char [] cordArray = cordString.toCharArray();
						int rowNum = -1; 
						int columnNum =-1; 
						if(cordArray[ROW_INDEX] =='A') 
						{
							rowNum =1; 
						}
						else if(cordArray[ROW_INDEX] =='B') 
						{
							rowNum =5; 
						}
						else if(cordArray[ROW_INDEX] =='C') 
						{
							rowNum =9; 
						}

						if(cordArray[COLUMN_INDEX] =='1') 
						{
							columnNum =1; 
						}
						else if(cordArray[COLUMN_INDEX] =='2') 
						{
							columnNum =5; 
						}
						else if(cordArray[COLUMN_INDEX] =='3') 
						{
							columnNum =9; 
						}
						if((rowNum == 1 || rowNum == 5 || rowNum == 9 ) && 
								(columnNum == 1 || columnNum == 5 || columnNum == 9 ))
						{
							xoBoard.makeMove(xoArray,currentPlayer,rowNum, columnNum);
							inputtingCoordinates = false;
						}
						else 
						{
							incorrectInput(); 
						}
					}
					else 
					{
						incorrectInput(); 
					}
				}
			}
			xoBoard.printBoard(xoArray); 
			System.out.println(BLANK);
		} 
		boardScanner.close();
		if(xoBoard.winner(xoArray) == BLANK) 
		{
			System.out.print("Looks like no one won! Better luck next time!");
		}
		else if(xoBoard.winner(xoArray) == NOUGHTS ) 
		{
			System.out.print("Congrats to Noughts for winning!");
		}
		else if(xoBoard.winner(xoArray) == CROSSES) 
		{
			System.out.print("Congrats to Crosses for winning");
		}
	}

	public static void gameStartText()
	{
		System.out.println("The Game is Noughts & Crosses!");
		System.out.println("The aim is to get a Row/ columns of your player!");
		System.out.println("Please enter the Co-ordinates of your move in the following format: RowColumn");
		System.out.println("Make sure you don't use any spaces & the row is in caps!") ;
		System.out.println("Good Luck!!!");
		System.out.println( " ");
	}

	public static void incorrectInput() 
	{
		System.out.println("Sorry, that input is incorrect"); 
		boardScanner = new Scanner(System.in); 
	}
}
