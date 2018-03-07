public class Eratosthenes {
	private float sqrtOfMax = -1; 
	public int[] createSequence( int maxNum) 
	{ 
		sqrtOfMax = (float) Math.sqrt(maxNum);
		int[] sequenceArray =  new int[maxNum -1]; 
		for( int index = 0; index < sequenceArray. length; index++) 
		{ 
			sequenceArray[index] = index + 2; 
		}
		return sequenceArray; 
	}
	
	public int[] crossOutHigherMultiples(int[] sequenceArray, int primeNum )
	{
		if(sequenceArray != null  ){
			for( int index = 0; index < sequenceArray. length; index++) 
			{ 
				if (sequenceArray[index] > primeNum) 
				{ 
					if( ( sequenceArray[index] % primeNum) ==0) 
					{
						sequenceArray[index] *= -1;
					}
				}
			}
			String sequenceString = sequenceToString(sequenceArray); 
			System.out.println( sequenceString);
		}
		return sequenceArray; 
	}

	public int[] sieve( int userInput) 
	{
		int[] mainSequence = createSequence(userInput);
		String mainString = sequenceToString( mainSequence);
		System.out.println( mainString);
		int mainIndex = 0; 
		while(mainSequence[mainIndex] <= sqrtOfMax)
		{
			if(  mainSequence[mainIndex] >=2 )
			{
				crossOutHigherMultiples( mainSequence, mainSequence[mainIndex]);
			}
			mainIndex++; 
		}
		return mainSequence;
	}

	public String sequenceToString( int [] squenceArray )
	{
		String sequenceString = ""; 
		if( squenceArray != null) { 
			for( int index = 0; index < squenceArray. length -1  ; index++) 
			{
				if( squenceArray[index] >= 2)
				{
					String numString = Integer.toString(squenceArray[index]); 
					numString += ","; 
					sequenceString += numString; 
				}
				else 
				{ 
					String numString = "[";
					numString += Integer.toString(Math.abs(squenceArray[index])); 
					numString += "],"; 
					sequenceString += numString; 
				}
			}
			if( squenceArray[squenceArray. length -1] >= 2)
			{
				String numString = Integer.toString(squenceArray[squenceArray. length -1]); 
				sequenceString += numString; 	
			}	
			else 
			{ 
				String numString = "[";
				numString += Integer.toString(Math.abs(squenceArray[squenceArray. length -1])); 
				numString += "]"; 
				sequenceString += numString; 
			}
		}
		return sequenceString;
	}

	public String nonCrossedOutSubseqToString ( int [] squenceArray )
	{
		String sequenceString = ""; 
		if( squenceArray != null) { 
			if( squenceArray[0] >= 2)
			{
				String numString = Integer.toString(squenceArray[0]); 
				sequenceString += numString; 	
			}	
			for( int index = 1; index < squenceArray. length  ; index++) 
			{
				if( squenceArray[index] >= 2)
				{
					String numString = ","; 
					numString += Integer.toString(squenceArray[index]); 
					sequenceString += numString; 
				}
			}
		}
		return sequenceString;
	}
}
