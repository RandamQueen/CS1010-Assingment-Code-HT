public class GameBoard {
	public static int NUMBER_OF_ROWS = 11;
	public static int NUMBER_OF_COLUMNS = 11;
	public static int AMOUNT_OF_SPACES = 9;

	public static int ROW_COLUMN_NUM_ONE=1; 
	public static int ROW_COLUMN_NUM_TWO =5; 
	public static int ROW_COLUMN_NUM_THREE =9; 	


	public static char NOUGHTS = 'O'; 
	public static char CROSSES = 'X';
	public static char BLANK = ' ';
	public static char VERTICAL_BARS = '|';
	public static char HOZ_BARS = '-';

	public static int INDEX_START_VALUE = 1; 
	public static int INDEX_INCREASE= 4; 

	public int movesMade = 0; 


	void clearBoard( char[][] board)
	{
		for( int i =INDEX_START_VALUE -1 ; i <NUMBER_OF_ROWS; i++)
		{
			for( int j = INDEX_START_VALUE -1; j < NUMBER_OF_COLUMNS; j++)
			{
				if( i == 3 || i == 7 ) 
				{
					board[i][j] = HOZ_BARS;
				}
				else if( j == 3 || j == 7)
				{
					board[i][j] = VERTICAL_BARS;
				}
				else
				{
					board[i][j] = BLANK;
				}
			}
		}
	}

	void printBoard( char[][] board) 
	{
		for( int i =INDEX_START_VALUE -1; i <=NUMBER_OF_ROWS; i++)
		{
			switch(i )
			{
			case 1:
				System.out.print("A");	
				break; 
			case 5:
				System.out.print("B");	
				break;
			case 9:
				System.out.print("C");	
				break;	
			default:
				System.out.print(" ");
				break;
			}
			if( i == NUMBER_OF_ROWS  )
			{
				for( int j =INDEX_START_VALUE -1; j <NUMBER_OF_COLUMNS; j++ )
				{
					switch(j )
					{
					case 1:
						System.out.print("1");	
						break; 
					case 5:
						System.out.print("2");	
						break;
					case 9:
						System.out.print("3");	
						break;	
					default:
						System.out.print(" ");
						break;
					}
				}
			}
			else
			{
				for( int j = INDEX_START_VALUE -1; j <NUMBER_OF_COLUMNS; j++ )
				{
					char tempElem = board[i][j]; 
					String elemString = Character.toString(tempElem);
					System.out.print(elemString);
				}
			}
			System.out.println(BLANK);
		}
	}

	boolean canMakeMove( char[][] board, int row, int column) 
	{ 
		if(board[row][column] == BLANK )
		{
			return true;
		}
		else { 
			return false;
		}
	}

	void makeMove( char[][]board, char currentPlayerPiece, int row, int column)
	{

		if( canMakeMove( board, row,column))
		{
			board[row][column] = currentPlayerPiece;
			movesMade++;
		}
		else 
		{
			board[row][column] = board[row][column];
			System.out.println("Sorry, there is already a player on this slot. Chose again.");
		}
	}

	boolean isBoardFull(char[][] board) 
	{
		int filledSpaces = 0; 
		for( int i =INDEX_START_VALUE; i <NUMBER_OF_ROWS; i+=INDEX_INCREASE)
		{
			for( int j = INDEX_START_VALUE; j < NUMBER_OF_COLUMNS; j+=INDEX_INCREASE)
			{
				if(  board[i][j] == NOUGHTS ||  board[i][j] == CROSSES)
				{
					filledSpaces++;
				}
			}
		}
		if( filledSpaces == AMOUNT_OF_SPACES )
		{
			return true; 
		}
		else {
			return false;
		}
	}

	char winner(char[][] board) 
	{
		char returnChar = BLANK; 
		for(int index = INDEX_START_VALUE; index < NUMBER_OF_ROWS; index +=INDEX_INCREASE )
		{
			if( board[index][ROW_COLUMN_NUM_ONE] == board[index][ROW_COLUMN_NUM_TWO]) 
			{
				if( board[index][ROW_COLUMN_NUM_ONE] == board[index][ROW_COLUMN_NUM_THREE])
				{
					returnChar = board[index][ROW_COLUMN_NUM_ONE]; 
				}
			}
		}

		for(int index = INDEX_START_VALUE; index < NUMBER_OF_ROWS; index +=INDEX_INCREASE )
		{
			if( board[ROW_COLUMN_NUM_ONE][index] == board[ROW_COLUMN_NUM_TWO][index]) 
			{
				if( board[ROW_COLUMN_NUM_ONE][index] == board[ROW_COLUMN_NUM_THREE][index])
				{
					returnChar = board[ROW_COLUMN_NUM_ONE][index]; 
				}
			}
		}

		if( board[ROW_COLUMN_NUM_ONE][ROW_COLUMN_NUM_ONE] == board[ROW_COLUMN_NUM_TWO][ROW_COLUMN_NUM_TWO]) 
		{
			if( board[ROW_COLUMN_NUM_ONE][ROW_COLUMN_NUM_ONE] == board[ROW_COLUMN_NUM_THREE][ROW_COLUMN_NUM_THREE])
			{
				returnChar = board[ROW_COLUMN_NUM_TWO][ROW_COLUMN_NUM_TWO]; 
			}
		}	

		if( board[ROW_COLUMN_NUM_ONE][ROW_COLUMN_NUM_THREE] == board[ROW_COLUMN_NUM_TWO][ROW_COLUMN_NUM_TWO]) 
		{
			if( board[ROW_COLUMN_NUM_ONE][ROW_COLUMN_NUM_THREE] == board[ROW_COLUMN_NUM_THREE][ROW_COLUMN_NUM_ONE])
			{
				returnChar = board[ROW_COLUMN_NUM_ONE][ROW_COLUMN_NUM_THREE]; 
			}
		}
		return returnChar;
	}
}
