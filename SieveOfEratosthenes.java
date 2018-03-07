
/* SELF ASSESSMENT 
   1. createSequence:
	Did I use the correct method definition?
	Mark out of 5: 5
	Comment: For this method I used the int[] return type as this array type would allow 
	the program to differentiate between prime and non prime number using postive 
	and negative number.
	
	Did I create an array of size n (passed as the parameter) and initialise it?
	Mark out of 5:4
	Comment: I created an array that's length was one less then the inputed number. 
	For the elements of the array, their numerical value was two plus their index number. 
	For example, the number at the zero position of the index had the value of 2. 
	
	Did I return the correct item?
	Mark out of 5:5
	Comment: The function returned an int[] from 2 to the user's inputed max. 
	
   2. crossOutMultiples
	Did I use the correct method definition?
	Mark out of 5: 5
	Comment:Again, i used the int[] return type, as this function's purpose was to find 
	elements in an array that were multiples of a prime number. The parameter were the prime number 
	and the array.   
	
	Did I ensure the parameters are not null and one of them is a valid index into the array
	Mark out of 2:2
	Comment: I tested the prime number in the main sieve function to ensure it was valid number. 
	Before running through the loop, the array was tested to ensure it wasn't null. 
	
	Did I loop through the array using the correct multiple?
	Mark out of 5: 5 
	Comment: We divided the elements in our array that were greater than the prime 
	number in question. If the remainder of this equation was zero aka the prime number
	divided perfectly  into the elements, we marked it as not prime.  
	
	Did I cross out correct items in the array that were not already crossed out?
	Mark out of 3:3
	Comment: We recorded an item as being crossed out but timing it by -1. When we looped 
	through out array, we check to make sure the possible multiples was greater than the 
	prime number. If it was negative, it would be less than the prime number. So, we avoided 
	double checking a number. 
	
	
   3. sieve   
	Did I have the correct function definition?
	Mark out of 5: 5
	Comment: This function takes a user's inputed number and generates a int array 
	of the prime number between 2 and this maximum inputed number. 
	
	Did I make calls to other methods?
	Mark out of 5:5
	Comment: In this function, I called the createSequence,sequenceTostring and 
	crossOutHigherMultiples methods. The createSequence was called once 
	to generate our sequence of numbers. The sequenceTostring printed this sequence
	ThecrossOutHigherMultiples was looped through many times, in order to determine the prime
	number between 2 and the square root of the max numbers.     
	
	Did I return an array with all non-prime numbers are crossed out?
	Mark out of 2: 2 
	Comment: The array that was returned consistently removed all non-prime numbers.  
	
   4. sequenceTostring  
	Did I have the correct function definition?
	Mark out of 5: 5 
	Comment:The function takes the array and generates a string that shows the crossed out
	and non-crossed numbers. 
	
	Did I ensure the parameter to be used is not null?
	Mark out of 3:3 
	Comment: We tested to see if the passed array was null. If it was null, we returned
	an empty string.
	
	Did I Loop through the array updating the String variable with
	the non-crossed out numbers and the crossed numbers in brackets? 
	Mark out of 10: 8 
	Comment: We did in a fashion loop through and updated the String variable. However, 
	instead of updating the String per say, we updated the array that was being passed to this
	methods. This array recorded out crossed out and non-crossed out numbers. The string was simple u
	used to print to the console.   
	   
   5. nonCrossedOutSubseqToString  
	Did I have the correct function definition
	Mark out of 5:5
	Comment: We passed an array of prime and non-prime numbers. The non-prime numbers
	were marked as they were negative. A string of just the prime numbers was returned.         
	
	Did I ensure the parameter to be used is not null?  
	Mark out of 3:3
	Comment:We tested to see if the passed array was null. If it was null, we returned
	an empty string.
	
	Did I loop through the array updating the String variable with just the non-crossed out numbers? 
	Mark out of 5:5
	Comment: To begin with, we check the first element in the array to see if it was prime or not. 
	We had to check this element separately to error a printing error to do with our commas. 
	If we had instead looped through all the elements, there was an extra comma printing.  
	
   6. main  
	Did I ask  the user for input n and handles input errors?  
	Mark out of 5:5
	Comments: If the user inputed an int that was >2 or another character, an
	error message was displayed and a they were asked to reenter a max number. 
	
	Did I make calls to other methods (at least one)?
	Mark out of 5:5
	Comment:  We called the sieve methods, as this methods main purpose was to return 
	an array which had all the non prime numbers of a sequence from 2 to the users entered number 
	marked off. We also called nonCrossedOutSubseqToString to print the final list of numbers. 
	
	Did I print the output as shown in the question?  
	Mark out of 5:5
	Comment: The output of the function was the same as that shown in the question. 
	 
   7. Overall
	Is my code indented correctly?
	Mark out of 4:4
	Comments:The code was correctly indented. 
	
	Do my variable names make sense?
	Mark out of 4:4
	Comments: The variables contained the word String or sequence depending on the 
	data type of the variable. This was to ensure clarify across the program. 
	
	Do my variable names, method names and class name follow the Java coding standard
	Mark out of 4:4
	Comments: The variables and methods were formatted in LCC. The classes names were
	formatted in capitalized  letters.
	
      Total Mark out of 100 (Add all the previous marks): 97
 */

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
