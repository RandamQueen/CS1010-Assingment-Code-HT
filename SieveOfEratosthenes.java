import java.util.Scanner;
public class SieveOfEratosthenes {
	public static void main(String[] args) {
		int userInput = 0; 
		boolean userHasNotInputted = false; 
		Scanner inputScanner = new Scanner( System.in); 
		Eratosthenes primeSorter = new Eratosthenes();
		System.out.print("Enter int >= 2:");
		while(!userHasNotInputted ) { 
			if( inputScanner. hasNextInt())
			{
				userInput = inputScanner. nextInt();
				if( userInput >= 2)
				{
					userHasNotInputted = true; 
				}
			}
			else 
			{ 
				System.out.println("Sorry, this input isn't correct");
				System.out.print("Enter int >= 2:");
				inputScanner = new Scanner( System.in); 
			}
		}
		inputScanner.close();
		int[] mainSequence = primeSorter.sieve(userInput);
		String primeString = primeSorter.nonCrossedOutSubseqToString(mainSequence) ;
		System.out.print( primeString);
	}
}
