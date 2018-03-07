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
