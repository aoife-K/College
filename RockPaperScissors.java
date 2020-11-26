/* SELF ASSESSMENT 
   1. Did I use appropriate easy-to-understand, meaningful variables and CONSTANTS within the code?  
       Mark out of 10: 10
       Comment: All variables and CONSTANTS are easy to understand.
   2. Did I format the variable and CONSTANT names appropriate (in lowerCamelCase and UPPERCASE)? 
       Mark out of 5: 5
       Comment: Yes, such as computerScore and MAX_GAMES.
   3. Did I generate the computer's choice in each game correctly using a Random number generator? 
       Mark out of 10: 10
       Comment: Yes, I used a random number generator.
   4. Did I input the user's choice in each game correctly? 
       Mark out of 10: 10
       Comment: Yes, I used the same input as the example.
   5. Did I correctly compare the choices and update the score appropriately? 
       Mark out of 20: 20
       Comment: Yes, the scores update appropriately after each choice is compared.
   6. Did I inform the user of who won each game (and why) correctly? 
       Mark out of 10: 10
       Comment: Yes, this is the same as the example output.
   7. Did I use an appropriate for loop to allow the player to play 5 games?  There should be only one loop. 
       Mark out of 20:  20
       Comment: Yes, I only used one loop to allow the player to play 5 games.
   8. Did I output the final scores correctly after the 5 games were played. 
       Mark out of 10:  10
       Comment: Yes, the final scores output is correct.
   9. How well did I complete this self-assessment? 
       Mark out of 5: 5
       Comment: I completed this self assessment to the best of my ability.
   Total Mark out of 100 (Add all the previous marks): 100
*/

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
	
	public static final int MAX_GAMES = 5;
	public static final int MAX_GUESS = 3;
	public static void main(String[] args) {
		
		Random  generator = new Random(); 
		int computerScore = 0;
		int userScore = 0;
	    
	    for (int count = 0; (count < MAX_GAMES); count++)
	    {
	    	int computerChoice = generator.nextInt(MAX_GUESS)+1;
	    	Scanner input = new Scanner( System.in );
		    System.out.print("Enter 1 (for Rock) or 2 (for Paper) or 3 (for Scissors):");
		    int userChoice = input.nextInt();
		    
		    if ((computerChoice == 1) && (userChoice == 1))
		    	System.out.println("This round was a draw as I chose Rock too.");
		    else if ((computerChoice == 2) && (userChoice == 2))
		    	System.out.println("This round was a draw as I chose Paper too.");
		    else if ((computerChoice == 3) && (userChoice == 3))
		    	System.out.println("This round was a draw as I chose Scissors too.");
		    
		    else if ((computerChoice == 1) && (userChoice == 2)) {
		    	System.out.println("You won this round as I chose Rock.");
		    	userScore++;}
		    
		    else if ((computerChoice == 1) && (userChoice == 3)) {
		    	System.out.println("You lost this round as I chose Rock.");
		    	computerScore++;}
		    
		    else if ((computerChoice == 2) && (userChoice == 1)) {
		    	System.out.println("You lost this round as I chose Rock");
		    	computerScore++;}
		    
		    else if ((computerChoice == 2) && (userChoice == 3)) {
		    	System.out.println("You won this round as I chose Paper.");
		    	userScore++;}
		    
		    else if ((computerChoice == 3) && (userChoice == 1)) {
		    	System.out.println("You won this round as I chose Scissors.");
		    	userScore++;}
		    
		    else if ((computerChoice == 3) && (userChoice == 2)) {
		    	System.out.println("You lost this round as I chose Scissors.");
		    	computerScore++;}
		    }
	    
	    System.out.println("The final score was Computer:"+computerScore+" User:"+userScore );
	    
	    }
		
		
		// TODO Auto-generated method stub

	}


