import java.util.Scanner;

public class TestOne {

	public static final int MIN_TEENAGER_AGE = 13;
	public static final int MAX_TEENAGER_AGE = 19;
	public static void main(String[] args) {
		
		int averageAge = 0;
		int numberOfTeenagers = 0;
		int percentageOfTeenagers = 0;
		int numberOfEntries = 0;
		int totalAge = 0;
		boolean finished = false;
		Scanner inputScanner = new Scanner( System.in) ;
		do {
			System.out.print("Enter a person's age (or 'quit'):");
			if (inputScanner.hasNextInt())
			{
				int age = inputScanner.nextInt();
				numberOfEntries++;
				totalAge = totalAge + age;
				averageAge = totalAge/numberOfEntries;
				
				if (age>=MIN_TEENAGER_AGE && age<=MAX_TEENAGER_AGE)
				{
					numberOfTeenagers++;
					percentageOfTeenagers = (numberOfTeenagers/numberOfEntries)*100;
				}
				
				System.out.println("The average age entered is "+averageAge+" and "+percentageOfTeenagers+"% of the ages correspond to teenagers.");
			}
			else if (inputScanner.hasNext("quit"))
				finished = true;
			else inputScanner.next();
			
		} while (!finished);
		inputScanner.close();
		
		// TODO Auto-generated method stub

	

}
}
