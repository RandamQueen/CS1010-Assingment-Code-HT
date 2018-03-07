
/* SELF ASSESSMENT 

Class Retional 
I declared two member variables: numerator and denominator (marks out of 4: ). 4 
Comment: We had to private int variables called numerator and denominator. 

Constructor 1 
My program takes take two integers as parameters (for numerator and denominator) and initialises the member
variables with the corresponding values. 
If the denominator is equal to 0 I throw an exception (marks out of 5: ). 4
Comment: The reason that we took away a mark here, was that we do not throw an exception when zero is
inputed. That is because in our method were we take in the user's input, we do not let the user input a
zero. 

Constructor 2 
My program takes only one integer as parameter (numerator), and set the numerator to this value .
I set the denominator to 1 in this case, as the resulting rational
number in this case is an integer (marks out of 3: ). 2 
Comment: We wrote this constructor as well and it was used by the other constructor to make the program
more efficient. Unfortunately, we relies that this constructor was never called due to the way we wrote
our user input. 

Add Method 
My program takes only a rational number as a parameter and returns a new rational number which has
a numerator and denominator which the addition of the two objects - this and the parameter. 
My program does not overwrite any of the other two rational numbers (marks out of 8: ). 8
Comment: We wrote this method to add our two rational and create a new rational of the addition. We 
also simplified the asnwer of the addition as well. 

Subtract Method 
I have implemented this the same as add method, except it implements subtraction (marks out of 8: ).8
Comment: This method was pretty much identical to the addition method, except the resultNumerator was
the result of the two number subtracted instead of added. 

Multiply Method 
I have implemented this the same as add method, except it implements multiplication (marks out of 8: ) 8 .
Comment: This method was shorter than add and subtract, as rational multiplication is quite easy to do. 

Divide Method 
I have implemented this the same as add method, except it implements divide (marks out of 8:)8.
Comment: The Divide method was quite like the Multiply, except we flip the value for the second 
Rational around. 

Equals Method 
My program takes a rational number as a parameter and compares it to the reference object.
I only use multiplication between numerators/denominators for the purpose of comparison,
as integer division will lead to incorrect results. I return a boolean value ((marks out of 8:). 6
Comment: For this method, we tested to see if the value of the numerator or the denominator were equal
for the two rational. If they were, we performed a certain type of testing. If all the variable of the
Rationals are unique, we performed a different type of testing.  

isLessThan 
My program takes a rational number as a parameter and compares it to the reference object.
I only use multiplication as integer division will lead to incorrect results.
I return a boolean value (marks out of 8: ).8
Comment: We based this method around the fact that fraction are get smaller as their denominator gets larger.
We compared the denominator of our two Rational numbers, and then compared their numerator. This method
required a us to consider all the different possibilities of Rational numbers the users could enter
and as a result it was quite large. 

Simplify Method 
My program returns a rational number but not a new rational number, instead it returns the current
reference which is this. It doesn't take any parameters as it works only with the reference object.
I first find the greatest common divisor (GCD) between the numerator and denominator, and then
obtain the new numerator and denominator by dividing to the GCD (marks out of 8: ). 8 
Comment: This methods uses the GCD function to find the number that divides evenly into both numbers. 
We also test and made sure that the minus sign appeared in the correct place, aka, in front of the numerator. 

gcd function 
My program returns the greatest common divider of two integers:
 the numerator and the denominator (marks out of 6: ).6
Comment: We tested to see if which of the numerator and the denominator had the lower value. We looped through
from 2 to the lowest value to see if a number divided evenly into both. If it divided evenly, it became our GCD
until we found a higher value. We returned the last recorded value that divided into both. 

toString Method 
My program returns a string showing the fraction representation of the number, eg. "1/2". 
It takes no parameters (marks out of 4: ). 4 
Comment: We created a toString method that return this format. 

Test Client Class 
My program asks the user for two rational numbers, creates two rational objects using the
constructor and passing in the provided values, calls addition, subtraction, multiplication,
division, comparison and simplification and prints out the results (marks out of 22: ). 20 
Comment: The way that we created took in the user input meant that we couldn't let users just
enter in one digit, meaning they could just call the numerator constructor. Besides that, everything
else worked perfectly.  

Total: 94/100
*/

import java.util.Scanner;

public class userInput {
public static final int START_VALUE = 0; 
	public static void main(String[] args) {

		Rational firstRational; 
		Rational secondRational;
		System.out.println("Please input your first Rational Number");
		firstRational = initiateRational();
		System.out.println("Please input your second Rational Number");
		secondRational = initiateRational();
		Rational additionRational = firstRational.add(secondRational);
		Rational subRational = firstRational.subtract(secondRational);
		Rational multiplyRational = firstRational.multiply(secondRational);
		Rational divideRational = firstRational.divide(secondRational);
		System.out.println("Your numbers simplify are: " +firstRational.toString()
				+ " + " + secondRational.toString());
		System.out.println("The result of the addition is: " + additionRational.toString());
		System.out.println("The result of the subtraction is: " + subRational.toString());
		System.out.println("The result of the multiplication is: " + multiplyRational.toString());
		System.out.println("The result of the division is: " + divideRational.toString());
		if(firstRational.equals(secondRational) )
		{
			System.out.println("The two rationals are equals");
		}
		else 
		{
			System.out.println("The two rationals are not equals");
			if(firstRational.isLessThan(secondRational) )
			{
				System.out.println("The first Rational is less than the second");
			}
			else 
			{
				System.out.println("The first Rational is greather than the second");
			}
		}
	}

	public static Rational initiateRational() 
	{
		boolean inputNum = true; 
		boolean inputDen = true;
		int numerator = START_VALUE;
		int denominator = START_VALUE ;
		Scanner userInput = new Scanner(System.in);

		
		while(inputNum)
		{
			System.out.print("Please enter the numerator:");
			if( userInput.hasNextLine())
			{
				if( userInput.hasNextInt() )
				{
					numerator = userInput.nextInt();
					inputNum = false;
				}
				else 
				{
					System.out.println("Please input the number again."
							+ " Remember enter them as intergers");
				}
			}
			userInput = new Scanner(System.in);
		}
		while(inputDen)
		{
			System.out.print("Please enter the denominator:");
			if( userInput.hasNextLine())
			{
				if( userInput.hasNextInt() )
				{
					denominator = userInput.nextInt();
					if( denominator ==START_VALUE)
					{
						System.out.println("Please input the number again."
								+ " Remember zero can't be on the bottom");
						
					}
					else
					{
						inputDen = false;
					}
				}
				else 
				{
					System.out.println("Please input the number again."
							+ " Remember enter them as intergers");
				}
			}
			userInput = new Scanner(System.in);
		}
		Rational newRational = new Rational (numerator, denominator);
		newRational.simplify();
		return newRational;
	}
}
