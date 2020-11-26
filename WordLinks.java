/* SELF ASSESSMENT 

1. readDictionary
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes, the method is defined as public static ArrayList<String>.
- My method reads the words from the "words.txt" file. [Mark out of 5:5] 
- Comment: Yes, my method successfully does this.
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5:5] 
- Comment: Yes, my method successfully does this.

2. readWordList
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes, the method is defined as public static ArrayList<String>.
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5:5]
- Comment: Yes, my method does this.

3. isUniqueList
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes, the method is defined as public static boolean.
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5:5]
- Comment: Yes, my method does this.
- Exits the loop when a non-unique word is found. [Mark out of 5:5]
- Comment: Yes, my method does this.
- Returns true is all the words are unique and false otherwise. [Mark out of 5:5]
- Comment: Yes, my method does this.

4. isEnglishWord
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes, the method is defined as public static boolean.
- My method uses the binarySearch method in Arrays library class. [Mark out of 3:3]
- Comment: My method uses Collections.binarySearch as I am using an ArrayList, but this does the same thing.
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2:2]
- Comment: Yes.

5. isDifferentByOne
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes, the method is defined as public static boolean.
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10:10]
- Comment: Yes, my method does this.

6. isWordChain
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes, the method is defined as public static String.
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10:10]
- Comment: Yes, it calls all of these methods and prints the appropriate message.

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of teh Java.IO classes covered in lectures [Mark out of 10:10]
- Comment: Yes, the main uses FileReader and BufferedReader.
- Asks the user for input and calls isWordChain [Mark out of 5:5]
- Comment: Yes.

 Total Mark out of 100 (Add all the previous marks):100
*/

import java.util.*;
import java.io.*;
public class WordLinks {
	
	public static void main(String[] args) {
		ArrayList<String> dictionary = new ArrayList<String>();

        try{
            FileReader fileReader = new FileReader("words.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            dictionary = readDictionary(bufferedReader);
        } catch (Exception e){
            System.out.print(e);
        }
		
		boolean quit = false;
		while(!quit) {
			System.out.println("Enter a comma separated list of words (or an empty list to quit):");
			Scanner input = new Scanner( System.in );
			String userInput = input.next();
			if (input.equals(""))
				quit = true;
			ArrayList<String> userWords = new ArrayList<String>(readWordList(userInput));
			String output = isWordChain(userWords, dictionary);
			System.out.println(output);
		}
	}
	
	public static ArrayList<String> readDictionary(BufferedReader dictionary){
		ArrayList<String> wordsFromFile = new ArrayList<String>();
		try {
	        String nextWord = dictionary.readLine();
	        while(nextWord != null){
	            wordsFromFile.add(nextWord);
	            nextWord = dictionary.readLine();
	        }
        } catch (Exception e) {
        	System.out.println(e);
        }
        return wordsFromFile;
	}

	public static ArrayList<String> readWordList(String userInput){
		String[] tempArray = userInput.split(","); 
		ArrayList<String> result = new ArrayList<String>();
		for (int i = 0; i<tempArray.length;i++)
			result.add(tempArray[i].trim());
		return result;
	}
	
	public static boolean isUniqueList(ArrayList<String> words) {
		boolean unique = true;
		for (int i = 0; !unique || i<words.size();i++) {
			String wordOne = words.get(i);
			for (int j=0;j<words.size();j++) {
				if (i!=j) {
					String wordTwo = words.get(j);
					if (wordOne.equalsIgnoreCase(wordTwo))
						unique = false;
				}
			}
		}
		return unique;
	}
	
	public static boolean isEnglishWord(String word, ArrayList<String> dictionary) {
		ArrayList<String> temp = new ArrayList<String>(dictionary);
		if (Collections.binarySearch(temp,word) >=0)
			return true;
		else return false;
	}
	
	public static boolean isDifferentByOne(String wordOne, String wordTwo) {
		boolean differentByOne = true;
		int differentBy = 0;
		if (wordOne.length() != wordTwo.length())
			differentByOne = false;
		for (int i = 0;i<wordOne.length();i++) {
			if (wordOne.charAt(i) != wordTwo.charAt(i))
				differentBy++;
		}
		if (differentBy != 1) {
			differentByOne = false;
		}
		return differentByOne;
	}
	
	public static String isWordChain(ArrayList<String> words, ArrayList<String> dictionary) {
		String result = "";
		boolean isWordChain = true;
		if (isUniqueList(words) != true)
			isWordChain = false;
		int j = 1;
		for (int i=0; j<words.size(); i++) {
			String firstWord = words.get(i);
			String secondWord = words.get(j);
			if (isEnglishWord(words.get(i), dictionary)!=true || (isDifferentByOne(firstWord, secondWord) != true)) {
				isWordChain = false;
			}
			j++;
		}
		if (isWordChain == true)
			result = ("Valid chain of words from Lewis Carroll's word-links game.");
		else if (isWordChain == false)
			result = ("Not a valid chain of words from Lewis Carroll's word-links game.");
		return result;
	}
}
