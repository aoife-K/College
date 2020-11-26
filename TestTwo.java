import java.util.Arrays;
import java.util.Scanner;
public class TestTwo {

	public static void main(String[] args) {
		int [] numbers = null;
		boolean quit = false;
		Scanner input = new Scanner( System.in );
		do {
			System.out.println("Enter an integer to add to the array (or 'quit' to finish):");
			if (input.hasNextInt())
			{
				int[] newNumbers = new int[(numbers==null)?1:numbers.length+1];
				if (numbers!= null)
					System.arraycopy( numbers, 0, newNumbers, 0, numbers.length );
				newNumbers[newNumbers.length-1] = input.nextInt();;
				numbers = newNumbers;
			}
			System.out.println("The minimum value is "+getMinimumValue(numbers)+", and the values "+isPalindromic(numbers)+" palindromic.");
			if (input.hasNext("quit"))
				quit = true;
		}
		while (!quit);

	}
	
	private static int getMinimumValue(int [] numbers) {
		if (numbers!=null)
		{
			for (int index = 0;index<numbers.length;index++)
			{
				for(int index2 = 1;index2<numbers.length;index2++)
				{
					if (numbers[index2]<numbers[index])
					{
						int temp = numbers[index];
						numbers[index] = numbers[index2];
						numbers[index2] = temp;
					}
				}
			}
			int minimumValue = numbers[0];
			return minimumValue;	
		}
		else return 0;
	}
	
	private static String isPalindromic(int [] numbers) {
		boolean isPalindromic = false;
		if (numbers!=null)
		{
			for (int count = 0;count<(numbers.length/2);count++)
			{
				for (int index = 0;index<=numbers.length;index++)
				{
					for (int index2 = numbers.length;index2>=0;index2--)
					{
						if (numbers[index]==numbers[index2])
							isPalindromic = true;
					}
				}
			}
		}
		if (isPalindromic = true)
			return "are";
		else return "are not";
			
	}

}
