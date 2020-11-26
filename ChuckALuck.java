/* SELF ASSESSMENT 

1. ResolveBet

I have correctly defined ResolveBet which takes the bet type (String) and the Wallet object, and a void return type [Mark out of 7:7 ].
Comment:Yes, ResolveBet is correctly defined with a void return type and the correct parameters.
My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet [Mark out of 8:8 ].
Comment:Yes, my program does this.
My program ensures the bet amount is not greater than the cash in the wallet [Mark out of 5: 5].
Comment:Yes, my program does this using if (wallet.get(bet)).
My program creates three Dice objects, rolls them and creates a total variable with a summation of the roll values returned [Mark out of 15:15 ]..
Comment:Yes, my program does this.
My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet [Mark out of 20: 20].
Comment: Yes, I used an if statement to do this.
My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses [Mark out of 10: 10].
Comment: Yes, my program outputs the results and changes the amount in the wallet to reflect this.

2. Main

I ask the user for the amount of cash he/she has, create a Wallet object and put this cash into it [Mark out of 15:15 ]
Comment: Yes, I asked the user for the amount of cash and created a Wallet object with this amount of cash in it.
My program loops continuously until the user either enters quit or the cash in the wallet is 0 [Mark out of 5: 5]
Comment: Yes, I used a while loop to do this.
I ask the user to enter any of the four bet types or quit [Mark out of 5: 5].
Comment:Yes.
My program calls resolveBet for each bet type entered [Mark out of 5:5 ].
Comment:resolveBet is called for each bet entered.
At the end of the game my program presents a summary message regarding winnings and losses [Mark out of 5: 5]
Comment:Yes, my program tells the user their initial cash and their final cash, and tells them how much of a win/loss this is.

 Total Mark out of 100 (Add all the previous marks):100
*/



import java.util.Scanner;

public class ChuckALuck {

	public static void main(String[] args) {
		Wallet wallet = new Wallet();
		double cash = 0.0;
		boolean finished = false;
		System.out.println("How much cash do you have?");
		Scanner input = new Scanner( System.in );
		if (input.hasNextDouble()) {
			cash = input.nextDouble();
		}
		else System.out.println("Invalid input.");
		wallet.put(cash);
		double bet = 0.0;
		while (!finished && wallet.check()>0) {
			System.out.println("Type of bet (Triple/Field/High/Low):- or enter 'quit'");
			Scanner inputBetType = new Scanner( System.in );
			if (inputBetType.hasNext("quit"))
				finished=true;
			else {
				String betType = inputBetType.nextLine();
				System.out.println("You have $"+wallet.check()+". How much would you like to bet?");
				Scanner inputBetAmount = new Scanner( System.in );
				if (inputBetAmount.hasNextDouble()) {
					bet = inputBetAmount.nextDouble();
				}
				else System.out.println("Invalid input.");
				resolveBet(wallet, betType, bet);
				System.out.println("You have $"+wallet.check()+".");
			}
		}
		System.out.println("Game finished - you started with $"+cash+" and finished with $"+wallet.check());
		if (cash>wallet.check())
			System.out.println("This is a loss of $"+(cash-wallet.check())+"  :(");
		else if (cash<wallet.check())
			System.out.println("This is a win of $"+(wallet.check()-cash)+"!");
		else if (cash==wallet.check())
			System.out.println("There were no wins or losses.");
	}

	public static void resolveBet(Wallet wallet, String betType, double bet) {
		boolean betWon=false;
		double winnings=0.0;
		double loss=0.0;
		
		Dice dice1 = new Dice();
		Dice dice2 = new Dice();
		Dice dice3 = new Dice();
		
		int result1 = dice1.roll();
		int result2 = dice2.roll();
		int result3 = dice3.roll();
		int total = result1 + result2 + result3;
		
		if(wallet.get(bet)) {
			
			if (betType.equalsIgnoreCase("triple")) {
				if (result1==result2 && result1==result3
					&& result1!=6 && result1!=1) {
					betWon=true;
					winnings=bet*30;
				}
				else {
					 betWon=false;
				}
			}
		
			else if (betType.equalsIgnoreCase("field")) {
				if(total<8 || total>12) {
					betWon=true;
					winnings=bet;
				}
				else {
					betWon=false;
				}
			}
	
			else if (betType.equalsIgnoreCase("high")) {
				if((result1==4 && result2==4 && result3==4) || (result1==5 && result2==5 && result3==5)
						|| (result1==6 && result2==6 && result3==6)) {
					betWon=false;
				}
				else if (total>10 ) {
					betWon=true;
					winnings=bet;
				}
			}
			
			else if (betType.equalsIgnoreCase("low")) {
				if((result1==1 && result2==1 && result3==1) || (result1==2 && result2==2 && result3==2)
						|| (result1==3 && result2==3 && result3==3)) {
					betWon=false;
				}
				else if (total<11 ) {
					betWon=true;
					winnings=bet;
				}
			}
		}

		else{ 
			System.out.println("You do not have enough cash in your wallet to bet this amount.");
		}
		
		System.out.println("Dice 1:"+result1+"  Dice 2:"+result2+"  Dice 3:"+result3);
		
		if (betWon==true) {
			System.out.println("You won this bet!");
			wallet.put(winnings+bet);
		}
		else if (betWon==false) {
			System.out.println("You lost this bet.");
		}
		
		
	}
	
}


