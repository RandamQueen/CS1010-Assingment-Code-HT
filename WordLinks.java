import java.util.ArrayList;
import java.util.Scanner;
public class WordLinks {

	public static void main(String[] args) throws Exception
	{
		LinkChecker linkCheck = new LinkChecker(); 
		Scanner inputScanner = new Scanner(System.in); 
		boolean wordChainInputted = false; 
		while(!wordChainInputted )
		{
			System.out.println("Enter a comma separated list of words (or an empty list to quit):");
			ArrayList<String> wordList = new ArrayList<String> ();
			if( inputScanner.hasNextLine())
			{
					wordList = linkCheck.readWordList(inputScanner.nextLine());
					if(wordList.size() ==0 )
					{
						wordChainInputted = true; 
					}
					else if(linkCheck.isWordChain(wordList))
					{
						System.out.println("Valid chain of words from Lewis Carroll's word-links game.");
					}
					else 
					{
						System.out.println("Not a valid chain of words from Lewis Carroll's word-links game.");
					}
			}
		}
		inputScanner.close(); 
	}
}
