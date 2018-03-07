
/* SELF ASSESSMENT 
   1. clearBoard:
	Did I use the correct method definition?
	Mark out of 5: 5 
	Comment: This method was need an 2-D char array that would found the base of our X & O board. 
	Hence this was a method that dealt with  initializing elements, we use a void return.   
	
	Did I use loops to set each position to the BLANK character?
	Mark out of 5: 4 
	Comment: The majority of the elements of the array were made blank. Due to the structure of our Array, 
	certain elements weren't blanks. These elements formed the structure of our Grids.If we didn't have this
	grid line in the array, we would have to print them in the printBoard function, which would be messier and
	more likely to case errors then the methods we chose. 

   2. printBoard
	Did I use the correct method definition?
	Mark out of 5: 5
	Comment: Similar to clearBoard, this method dealt with elements in the array. 
	These elements were printed to the console and there values weren't changed. As a result 
	we used the void return type. 
	
	Did I loop through the array and prints out the board in a way that it looked like a board?
	Mark out of 5:5
	Comment: We constructed for nest loop that looped the elements of the array. The loop began at the first row
	and went allow horizontal. The method also printed out the Co-Ordinates in there corresponding row/ columns 
	of the array.  
	
	
   3. canMakeMove
	Did I have the correct function definition and returned the correct item?
	Mark out of 5:5
	Comment: The parameters that we took in for this method were the 2-D Array,  the position of the row and
	column to be added. As we were testing to see if something could be added to the board or not,
	 we returned a boolean. We returned true if the movewas blank and false if there was already a piece there. 
	
	Did I check if a specified location was BLANK?
	Mark out of 5:5
	Comment: We loaded in the elements of the 2-D array that corresponded to the position that 
	the player wanted to place a piece. If this element was blank, the move was valid. Of not, the move
	was not possible and would returned false. 
	
   4. makeMove
	Did I have the correct function definition?
	Mark out of 5:5
	Comment:The parameters that we took in for this method were the 2-D Array, the current players piece, aka 
	was an X or O to be added to the board and the position of the row & column to be added. Unlike the canMakeMove
	function, we used a void return type as we didn't need to change anything in the main, just an element of the
	array. 
	
	Did I set the  currentPlayerPiece in the specified location?
	Mark out of 5: 5
	Comment: If the canMakeMove function returned a true value, we would set the element of the array that
	Corresponded to the inputed row & column to the  player character. If the was not applied, aka there was 
	a false returned, the elements was set to blank and an error message was displaced.  
	
   5. isBoardFull
	Did I have the correct function definition and returned the correct item?
	Mark out of 5: 5
	Comment: The parameter passed was the board, as we wanted to check the elements of the board. 
	We returned a boolean, to determine if the board was full and the game should end or was there
	still free positions.    
	    
	Did I loop through the board to check if there are any BLANK characters?
	Mark out of 5:5 
	Comment: We had a variable that counted the amount of filled spaces in the board. The for loop
	that we used only counted the elements that could be added to, aka those elements that corresponded 
	to the Co-ordinates.If the board had nine filled space, we would return a true value that showed the board 
	was full. If not, the board wasn't full and false was returned. 
	
   6. winner
	Did I have the correct function definition and returned the winning character
	Mark out of 5:5
	Comment: We took in the 2-D array that correspond to our board. The return type was a char, as we 
	wanted to calculate the player piece that had won the game, if there was a winner.      
	
	Did I identify all possible horizontal, vertical and diagonal winners  
	Mark out of 15: 15 15
	Comment: To begin with, we looped through the rows of the array to see if the elements of our
	Co- Ordinates columns were equals. In simple terms, we tested to see if the changeable elements 
	of a row were all equal to X or O  and matched. If the Rows weren't a matched, we tested the columns 
	in a similar way. The  last elements to test were the diagonal. Here, we just hard-coded a test to see if
	the diagonal were matching X or O elements.   
	
   7.main
	Did I create a board of size 3 by 3 and use the clearBoard method to set all the positions to the BLANK character ('  ')?
	Mark out of 3: 2 
	Comments: Due to the way we created our array, the size was 11x11 instead of 3 by 3. However, an grid was
	created that had blank elements in the locations that blank elements were needed. 
	
	Did I loop asking the user for a location until wither the board was full or there was a winner?
	Mark out of 5:5
	Comments: The while loop continued until a winner was declared or the board was full. 

	Did I call all of the methods above?
	Mark out of 5:5
	Comments:All of the GameBoard Methods were called. 

	Did I handle incorrect locations provided by the user (either occupied or invalid locations)?
	Mark out of 3:3 
	Comments: If the user enter an incorrect input, the error message function would run. We made sure
	that error checking occurred for both occupied spaces and invalid locations. 

	Did I switch the current player piece from cross to nought and vice versa after every valid move?
	Mark out of 3: 3 
	Comments: We made sure that that correct player piece was loaded in each time we ran though the loop. 
	As a bit of safety, to insure the correct player was loading in each time, we printed the currect
	player piece to the console. 

	Did I display the winning player piece or a draw at the end of the game?
	Mark out of 3:3
	Comments:When we exited the loop, we ran the winner method again to determine if there was a winner
	to the game. If there was a winner, we congratulated them. If not, we said hard luck to both
	players. 

   8. Overall
	Is my code indented correctly?
	Mark out of 3:3
	Comments:All of the code was correctly indented. 

	Do my variable names and Constants (at least four of them) make sense?
	Mark out of 3:3 
	Comments:The names were self-explanatory and highlighted
	there purpose. 
	
	Do my variable names, method names and class name follow the Java coding standard
	Mark out of 2:2 
	Comments:All of the variable were formatted in LCC. Constants were in all caps with _ Spacing. 
      Total Mark out of 100 (Add all the previous marks): 98
*/

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
