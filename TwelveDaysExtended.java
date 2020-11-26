/* SELF ASSESSMENT
 1. Did I use easy-to-understand meaningful properly formatted, variable names and CONSTANTS?
        Mark out of 10:10
        Comment: Yes, all variable names are easy to understand and are formatted correctly, for example verseNumber and MAX_VERSES.  
 2. Did I implement the getVerse function correctly and in a manner that can be understood (5 marks for function definition, 5 marks for function call and 15 marks for function implementation)?
       Mark out of 25: 25
        Comment: Yes, the getVerse function is implemented correctly as it takes the verse number and returns a string containing that verse.
 3. Did I implement the getChristmasGift function correctly using a switch statement and in a manner that can be understood (5 marks for function definition, 5 marks for function call and 15 marks for function implementation)?
       Mark out of 25: 25
        Comment:  Yes, the getChristmasGift function uses a switch statement to return a string containing the gifts that correspond to a particular verse number.
 4. Did I implement the getOrdinalString function correctly using if or conditional operators and in a manner that can be understood (5 marks for function definition, 5 marks for function call and 15 marks for function implementation)?
       Mark out of 25: 25
        Comment:  Yes, I used a series of if statements in the getOrdinalString function to correctly return the corresponding ordinal string.
 5. Does the program produce the output correctly?
       Mark out of 10: 10
        Comment:  Yes, the output is correct.
 6. How well did I complete this self-assessment?
        Mark out of 5: 5
        Comment: I completed this self assessment to the best of my ability.
 Total Mark out of 100 (Add all the previous marks): 100
*/ 


public class TwelveDaysExtended {
	
	public static final int MAX_VERSES = 12;
	public static void main(String[] args) {
		for (int verseNumber = 1; (verseNumber <= MAX_VERSES); verseNumber++ )
		{
			System.out.println(getVerse(verseNumber));
		}
		
	}

	private static String getVerse (int verseNumber){
		return"\nOn the "+getOrdinalString(verseNumber)+" day of Christmas \nmy true love sent to me: "+getChristmasGift(verseNumber);
	}
	
	private static String getChristmasGift (int verseNumber){
		String giftString = "";
		switch (verseNumber)
		{
		case 12:
			giftString += "\n12 drummers drumming,";
		case 11:
			giftString += "\n11 pipers piping,";
		case 10:
			giftString += "\n10 lords a leaping,";
		case 9:
			giftString += "\n9 ladies dancing,";
		case 8:
			giftString += "\n8 maids a milking,";
		case 7:
			giftString += "\n7 swans a swimming,";
		case 6:
			giftString += "\n6 geese a laying,";
		case 5:
			giftString += "\n5 gold rings,";
		case 4:
			giftString += "\n4 calling birds,";
		case 3:
			giftString += "\n3 French hens,";
		case 2:
			giftString += "\n2 turtle doves and";
		case 1:
			giftString += "\na partridge in a pear tree.";
			break;
		default:
		}
		return(giftString);
		}
	
	
	private static String getOrdinalString (int verseNumber){
		String ordinalPhrase = "";
		if (verseNumber == 1)
			ordinalPhrase = "first";
		else if (verseNumber == 2)
			ordinalPhrase = "second";
		else if (verseNumber == 3)
			ordinalPhrase = "third";
		else if (verseNumber == 4)
			ordinalPhrase = "fourth";
		else if (verseNumber == 5)
			ordinalPhrase = "fifth";
		else if (verseNumber == 6)
			ordinalPhrase = "sixth";
		else if (verseNumber == 7)
			ordinalPhrase = "seventh";
		else if (verseNumber == 8)
			ordinalPhrase = "eighth";
		else if (verseNumber == 9)
			ordinalPhrase = "ninth";
		else if (verseNumber == 10)
			ordinalPhrase = "tenth";
		else if (verseNumber == 11)
			ordinalPhrase = "eleventh";
		else if (verseNumber == 12)
			ordinalPhrase = "twelfth";
			
		return ordinalPhrase;
				
	}
}

