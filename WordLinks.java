
/* SELF ASSESSMENT 

1. readDictionary
	I have the correct method definition [Mark out of 5:]5
	Comment: The method doesn't need any parameters as the dictionary is created from the "words.txt" 
	file located in the Java project. We returned an String[] of the words.  

	My method reads the words from the "words.txt" file. [Mark out of 5:]5
	Comment: The methods uses the File, FileReader and BufferedReader class to locate in and
	read the elements of the words.txt array. 
	
	It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5:]5
	Comment: We load in each element of the words.txt file and add them to the ArrayList.We then return
	this String[] to the main body. 

2. readWordList
	I have the correct method definition [Mark out of 5:]5
	Comment: The parameter for this method is a String of words inputed by the users, that
	contains commas. We used the ArrayList<String> return type as the purpose of this method
	is to create an ArrayList of the users input that doesn't contains the commas. We also wanted to be
	able to look each word the user inputed separately, so that called for us to create an ArrayList of these
	words. 
	
	My method reads the words provided (which are separated by commas, saves them to an array or 
	ArrayList of String references and returns it. [Mark out of 5:] 5
	Comment:  We used the Scanner Class inside the method to exam the user's inputed String. 
	The words were added to the ArrayList and the commas were ignored using the .useDelimiter function. 
	Once we had examined all of the String,we returned the ArrayList of words. 

3. isUniqueList
	I have the correct method definition [Mark out of 5:]5
	Comment: The parameter that is passed into this method is an ArrayList of Strings of the
	user's inputed word link. The return type for this method is a boolean, as we wanted to determine 
	if all the elements of the ArrayList were unique. 
	
	My method compares each word in the array with the rest of the words in the list. [Mark out of 5:]5
	Comment: Our methods words by loading in element of the ArrayList and comparing in to 
	all the elements that follow it in the ArrayList. We do this by having an offset int in our for loop
	that allows us to load in the following elements. If two elements of the ArrayList are equal, we set our 
	noSimilarWords boolean to false.

	Exits the loop when a non-unique word is found. [Mark out of 5:]4
	Comment: We don't leave the loop the second a similar word is found. The while loop will only run
	as long as noSimilarWords is true, so once the while condition is tested, the program leaves the loop. 
	
	Returns true is all the words are unique and false otherwise. [Mark out of 5:] 5 
	Comment: The noSimilarWords is set to true and only returns false if two similar words
	are found in the ArrayList 

4. isEnglishWord
	I have the correct method definition [Mark out of 5:]4
	Comment: Instead of use taking in the String to be tested, we took in the dictionaryList as well. 
	This is because we found it more efficient to pass this list into the function, then call it 
	in the isEnglishWord method.We set the return type to a boolean type as we were only performing
	a small test to see if it was correct. 
	
	My method uses the binarySearch method in Arrays library class. [Mark out of 3:]3
	Comment: We used this method to find if the word was located in our dictionaryList. 

	Returns true if the binarySearch method return a value >= 0, 
	otherwise false is returned. [Mark out of 2:]2
	Comment: We returned these values. 

5. isDifferentByOne
	I have the correct method definition [Mark out of 5:] 5 
	Comment: The method calls for two string to be passed as parameters. We used the boolean return 
	type, as the purpose of this methods is to see if the two words are the same length and differ by one. 
	If the length were the same and there was one different, we returned true. Else we returned false. 
	
	My method loops through the length of a words comparing characters at the same position
	in both words searching for one difference. [Mark out of 10:] 10
	Comment: By converting our string to char arrays, we were able to test if the length or the 
	words was the same. It also allowed us to compare each element of the arrays individually. 
	This meant we could test if the words had one character different.   

6. isWordChain
 	I have the correct method definition [Mark out of 5:]5
	Comment: We pass the ArrayList of user inputed words. The return type for this method is a boolean
	as we wanted to determine if the 
	
	My method calls isUniqueList, isEnglishWord and isDifferentByOne methods
	and prints the appropriate message [Mark out of 10:]10
	Comment: The isWordList loops through, checking to see if the list is unique, the String only
	vary by one Character and are English words. 

7. main
	Reads all the words from file words.txt into an array or an ArrayList 
	using the any of the Java.IO classes covered in lectures [Mark out of 10:] 10
	Comment: We used the FileReader and BufferedReader classes to read the words.txt file. 
	
	Asks the user for input and calls isWordChain [Mark out of 5:]5 
	Comment: We looped through to see if the users had entered a word chain. If the word chain is
	valid, we printed a message saying so. If it's not, we print an error message. If they entered an
	empty sprint, we terminated the program.  

 Total Mark out of 100 (Add all the previous marks):98
*/

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