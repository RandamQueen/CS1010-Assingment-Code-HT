import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
public class LinkChecker {
	public final int DICTIONARY_SIZE=658964;
	public final int INDEX_START_VALUE =0; 

	public  String[] readDictionary() throws Exception
	{
		String[] dictionaryList = new String[DICTIONARY_SIZE];
		String FilePath = new File("words.txt").getAbsolutePath();; 
		FileReader fileRead = new FileReader(FilePath); 
		BufferedReader buffRead = new BufferedReader(fileRead);
		for(int index = INDEX_START_VALUE; index<dictionaryList.length -1 ; index++ )
		{
			dictionaryList[index] = buffRead.readLine();
		}
		buffRead.close(); 
		fileRead.close(); 
		return dictionaryList; 
	}

	public  ArrayList<String> readWordList(String wordChain) 
	{
		boolean creatingArray = true; 
		ArrayList<String> wordList= new ArrayList<String>(); 
		Scanner wordScanner = new Scanner(wordChain); 
		wordScanner.useDelimiter(",");
		while( creatingArray)
		{
			if( wordScanner.hasNext())
			{
				wordList.add(wordScanner.next());
			}
			else 
			{
				creatingArray = false;
			}
		}
		wordScanner.close();
		return wordList; 
	}

	public boolean isUniqueList(ArrayList<String> wordList)
	{ 
		boolean noSimilarWords = true; 
		int index = INDEX_START_VALUE;
		int offset =1; 
		if( wordList.size() > 2) {
			while(index < wordList.size() && noSimilarWords)
			{
				String indexString = wordList.get(index);
				for( offset = 1; offset < (wordList.size() - index);offset++)
				{
					String offsetString =  wordList.get(index + offset); 
					if(indexString == offsetString )
					{
						noSimilarWords = false; 
					}		
				}
				index++;
				offset =1; 
			}
		}
		else if( wordList.size() == 2)
		{
			if(wordList.get(offset) ==  wordList.get(index)  )
			{
				noSimilarWords = false; 
			}
		}
		return noSimilarWords;
	}

	public  boolean isEnglishWord(String testWord, String[] dictionaryList )
	{
		if( Arrays.binarySearch(dictionaryList,testWord) >= 0)
		{
			return true;
		}
		else {
			return false; 
		}
	}

	public boolean isDifferentByOne(String oldWord, String newWord)
	{
		int charDifferences = 0;
		char[] oldWordChar = oldWord.toCharArray(); 
		char[] newWordChar = newWord.toCharArray();  
		if(oldWordChar.length == newWordChar.length)
		{
			for( int index =INDEX_START_VALUE ; index < oldWordChar.length; index++)
			{
				if(oldWordChar[index] != newWordChar[index]  )
				{
					charDifferences++; 
				}
			}
			if( charDifferences == 1)
			{
				return true; 
			}
			else 
			{
				return false;
			}
		}
		else
		{	
			return false;
		}
	}

	public  boolean isWordChain(ArrayList<String> wordList) throws Exception
	{
		boolean validWordChain = true; 
		int index = INDEX_START_VALUE; 
		String[] dictionaryList = readDictionary();  
		while(index < wordList.size() -1 && validWordChain)
		{
			String previousWord = wordList.get(index);  
			if(isEnglishWord(previousWord, dictionaryList) == false)
			{
				validWordChain = false; 
			}
			index++; 
			String nextWord = wordList.get(index); 
			if(isDifferentByOne(previousWord,nextWord)== false)
			{
				validWordChain = false; 
			}
		}
		if(!isUniqueList(wordList))
		{
			validWordChain = false; 
		}
		return validWordChain;
	}
}
