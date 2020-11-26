/* SELF ASSESSMENT 
   1.  createSequence:
Did I use the correct method definition?
Mark out of 5:5
Comment:Yes, the method is defined as int[].
Did I create an array of size n (passed as the parameter) and initialise it?
Mark out of 5:5
Comment:Yes, I created and initialised an array of size n.
Did I return the correct item?
Mark out of 5:5
Comment:Yes, I returned the appropriate sequence.
   2.  crossOutMultiples
Did I use the correct method definition?
Mark out of 5:5
Comment:Yes, the method is defined as int[].
Did I ensure the parameters are not null and one of them is a valid index into the array
Mark out of 2:2
Comment:Yes, I used if(sequence!=null).
Did I loop through the array using the correct multiple?
Mark out of 5:5
Comment:Yes, I used the correct multiple.
Did I cross out correct items in the array that were not already crossed out?
Mark out of 3:3
Comment:Yes, correct items are crossed out that aren't already.
   3.  sieve   
Did I have the correct function definition?
Mark out of 5:5
Comment:Yes, the method is defined as int[].
Did I make calls to other methods?
Mark out of 5:5
Comment: Yes, I made calls to createSequence, sequenceToString and crossOutHigherMultiples.
Did I return an array with all non-prime numbers are crossed out?
Mark out of 2:2
Comment:Yes.
   4.  sequenceTostring  
Did I have the correct function definition?
Mark out of 5:5
Comment:Yes, the method is defined as String.
Did I ensure the parameter to be used is not null?
Mark out of 3:3
Comment: Yes, I used if(sequence!=null).
Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets? 
Mark out of 10:10
Comment: Yes, I looped through the array so that crossed out numbers are in brackets and non-crossed out numbers are not.
   5.  nonCrossedOutSubseqToString  
Did I have the correct function definition
Mark out of 5:5
Comment:  Yes, the method is defined as String. 
Did I ensure the parameter to be used is not null?  
Mark out of 3:3
Comment:Yes, I used if(sequence!=null).
Did I loop through the array updating the String variable with just the non-crossed out numbers? 
Mark out of 5:5
Comment:Yes, the String variable is updated only with non-crossed out numbers as I looped through the array.
   6.  main  
Did I ask  the user for input n and handles input errors?  
Mark out of 5:5
Comments:Yes, using if(input.hasNextInt()).
Did I make calls to other methods (at least one)?
Mark out of 5:5
Comment:  Yes, I made calls to sieve and nonCrossedOutSubseqToString.
Did I print the output as shown in the question?  
Mark out of 5:5
Comment:  Yes, all crossed out numbers are in square brackets.
   7.  Overall
Is my code indented correctly?
Mark out of 4:4
Comments:Yes, my code is indented correctly.
Do my variable names make sense?
Mark out of 4:4
Comments:Yes, all variable names are appropriate, for example integerN.
Do my variable names, method names and class name follow the Java coding standard
Mark out of 4:4
Comments:Yes.
      Total Mark out of 100 (Add all the previous marks): 100
*/


import java.util.Arrays;
import java.util.Scanner;

public class SieveOfEratosthenes {

	private static int[] createSequence(int integerN)
	{
		int j = 2;
		int[] sequence = new int[integerN-1];
		for(int i = 0;j<=integerN;i++)
		{
			sequence[i] = j;
			j++;
			
		}
		return sequence;
	}
	
	private static int[] crossOutHigherMultiples(int[] sequence, int integerN) {
		if(sequence!=null) {
			for(int n = 2;n<=Math.sqrt(sequence.length+2);n++)
			{
				for(int i = 2;i<sequence.length;i++)
				{
					if(sequence[i] % n == 0 && sequence[i]>0)
						sequence[i] *= -1;
				}
				System.out.println(sequenceToString(sequence));
			}
		}
		return sequence;
	}
	
	private static int[] sieve(int integerN) {
		int[] sequence = createSequence(integerN);
		System.out.println(sequenceToString(sequence));
		sequence = crossOutHigherMultiples(sequence,integerN);
		return sequence;
	}
	
	private static String sequenceToString(int[] sequence) {
		String sequenceString=" ";
		if(sequence!=null) {
			for (int i : sequence)
			{
				if(i<0 && i!=(sequence.length+1))
					sequenceString+="["+Math.abs(i)+"], ";
				else if (i<0 && i==(sequence.length+1))
					sequenceString+="["+Math.abs(i)+"]";
				else if (i>0 && i!=(sequence.length+1))
					sequenceString+=i+", ";
				else
					sequenceString+=i;
			}
		}
		return sequenceString;
	}
	
	private static String nonCrossedOutSubseqToString(int[] sequence) {
		String finalString=" ";
		if (sequence!=null) {
			for (int i : sequence)
			{
				if(i>0)
					finalString+= i+", ";
			}
		}
		return finalString;
	}
	
	public static void main(String[] args) {
		int integerN=2;
		System.out.println("Enter integer:");
		Scanner input = new Scanner( System.in );
		if (input.hasNextInt())
			integerN = input.nextInt();
		
		int[] seq = sieve(integerN);
		System.out.println(nonCrossedOutSubseqToString(seq));
	}

}
