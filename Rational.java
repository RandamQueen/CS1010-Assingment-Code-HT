
public class Rational {
	private int numerator;
	private int denominator;

	Rational( int numerator )
	{
		this.numerator = numerator ;
		denominator = 1;
	}

	Rational( int numerator, int denominator )
	{
		this(numerator);
		this.denominator = denominator; 			
	}

	public Rational add (Rational secondRational)
	{
		int resultDenominator;
		int resultNumerator; 
		if( this.denominator == secondRational.getDenominator()) 
		{
			resultDenominator =  this.denominator;
			resultNumerator = this.numerator + secondRational.getNumerator();
		}
		else 
		{
			resultDenominator = this.denominator * secondRational.getDenominator();
			int firstNum = this.numerator * secondRational.getDenominator(); 
			int secondNum = secondRational.getNumerator() * this.denominator;
			resultNumerator = firstNum + secondNum; 
		}
		Rational resultRational = new Rational(resultNumerator,resultDenominator ); 
		resultRational.simplify(); 
		return resultRational;
	}

	public Rational subtract (Rational secondRational)
	{
		int resultDenominator;
		int resultNumerator; 
		if( this.denominator == secondRational.getDenominator()) 
		{
			resultDenominator =  this.denominator;
			resultNumerator = this.numerator - secondRational.getNumerator();
		}
		else 
		{
			resultDenominator = this.denominator * secondRational.getDenominator();
			int firstNum = this.numerator * secondRational.getDenominator(); 
			int secondNum = secondRational.getNumerator() * this.denominator;
			resultNumerator = firstNum - secondNum; 
		}
		Rational resultRational = new Rational(resultNumerator,resultDenominator ); 
		resultRational.simplify(); 
		return resultRational;
	}

	public Rational multiply (Rational secondRational)
	{
		int resultNumerator = this.numerator * secondRational.getNumerator(); 
		int resultDenominator = this.denominator * secondRational.getDenominator();
		Rational resultRational = new Rational (resultNumerator, resultDenominator );
		resultRational.simplify(); 
		return resultRational;
	}

	public Rational divide (Rational secondRational)
	{
		int resultNumerator = this.numerator * secondRational.getDenominator(); 
		int resultDenominator = this.denominator * secondRational.getNumerator();
		Rational resultRational = new Rational (resultNumerator, resultDenominator );
		resultRational.simplify(); 
		return resultRational;
	}

	public boolean equals(Rational secondRational ) 
	{
		boolean isEquals;
		boolean numEqual; 
		boolean denEqual; 

		if(this.numerator  == secondRational.getNumerator()) 
		{
			numEqual = true; 
			if	(this.denominator  == secondRational.getDenominator())
			{
				denEqual = true;
			}
			else
			{
				denEqual = false;
			}
		}
		else 
		{
			numEqual = false; 
			denEqual =false;
		}
		if( numEqual && denEqual)
		{
			isEquals = true; 
		}
		else 
		{
			isEquals = false; 
		}

		return isEquals;
	}

	public boolean isLessThan( Rational secondRational )
	{
		boolean isLessThan; 
		if(this.denominator == secondRational.getDenominator())
		{
			if (this.numerator < secondRational.getNumerator())
			{
				isLessThan = true;	
			}
			else 
			{
				isLessThan = false;	 
			}
		}
		else if(this.denominator < secondRational.getDenominator() )
		{
			if (this.numerator == secondRational.getNumerator())
			{
				isLessThan = false;	
			}
			else if (this.numerator < secondRational.getNumerator())
			{
				isLessThan = true;	
			}
			else 
			{
				isLessThan = false;	 
			}
		}
		else 
		{
			if (this.numerator == secondRational.getNumerator())
			{
				isLessThan = true;	
			}
			else if (this.numerator < secondRational.getNumerator())
			{
				isLessThan = true;	
			}
			else 
			{
				isLessThan = false;	 
			}
		}
		return isLessThan; 
	}

	public void simplify( ) 
	{
		if( this.numerator < 0 && this.denominator < 0 )
		{
			this.numerator *= -1; 
			this.denominator *= -1; 
		}
		else if(  this.numerator > 0 && this.denominator < 0 )
		{
			this.numerator *= -1; 
			this.denominator *= -1; 
		}
		int greatestCommonDivisor = 
				greatestCommonDivisor(Math.abs( this.numerator), Math.abs(this.denominator ));
		this.numerator =  this.numerator/ greatestCommonDivisor;
		this.denominator = this.denominator / greatestCommonDivisor;
	}

	public int greatestCommonDivisor(int firstNum, int  secondNum) 
	{
		int GCD =1;
		int possibleValue =1; 
		int maxValue = -1; 
		if(firstNum >=  secondNum)
		{
			maxValue = firstNum; 
		}
		else if (firstNum <  secondNum)
		{
			maxValue = secondNum; 
		}

		while( possibleValue <= maxValue)
		{
			if((firstNum % possibleValue ==0 ) && (secondNum % possibleValue ==0 )) 
			{
				GCD = possibleValue; 
			}
			possibleValue++;
		}
		return GCD; 
	}

	public String toString() {  
		return  this.numerator + "/" + this.denominator;
	}

	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}

}