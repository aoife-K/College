/* SELF ASSESSMENT 
   1. Did I use easy-to-understand meaningful variable and CONSTANT names? 
       Mark out of 10: 10
       Comment: All variable and CONSTANT names are easy to understand.
   2. Did I format the variable and CONSTANT names properly (in lowerCamelCase and UPPERCASE_WITH_UNDERSCORES)? 
       Mark out of 10: 10
       Comment: Yes.
   3. Did I indent the code appropriately? 
       Mark out of 10: 10
       Comment: Yes.
   4. Did I read the input correctly from the user using appropriate questions? 
       Mark out of 15: 15
       Comment: Yes.
   5. Did I computer the disposable income and disposable income percentage correctly, and output it in the correct format? 
       Mark out of 15: 13
       Comment: All calculations are correct, but are to one decimal place unlike the sample output.
  6. Did I use an appropriate series of if statements to generate the income analysis to the user? 
       Mark out of 25: 25
       Comment: Yes.
   7. Did I provide the correct output for each possibility in an easy to read format? 
       Mark out of 10: 10
       Comment: Yes.
   8. How well did I complete this self-assessment? 
       Mark out of 5: 5
       Comment: I completed this self assessment to the best of my ability.
   Total Mark out of 100 (Add all the previous marks): 98
*/


import java.util.Scanner;
import javax.swing.JOptionPane;

public class AnalysingDisposableIncome {
		
			public static final double TAX_CONSTANT = 0.35;
			public static final double AVERAGE_INCOME = 500.00;
			public static final double MUCH_BELOW_AVERAGE_INCOME = 250.00;
			public static final double MUCH_ABOVE_AVERAGE_INCOME = 750.00;
			public static void main(String[]args) {

				String grossInput = JOptionPane.showInputDialog("How much are you paid a month before tax?");
				Scanner input = new Scanner(grossInput);
				double grossIncome = input.nextDouble();
				
				String accommodationInput = JOptionPane.showInputDialog("How much do you pay in rent/mortgage a month?");
				input = new Scanner(accommodationInput);
				double accommodation = input.nextDouble();
				
				String commuteInput = JOptionPane.showInputDialog("How much does your commute cost a month?");
				input = new Scanner(commuteInput);
				double commute = input.nextDouble();
				
				String foodInput = JOptionPane.showInputDialog("How much do you spend on food per month?");
				input = new Scanner(foodInput);
				double food = input.nextDouble();
				
				double taxedIncome = grossIncome*TAX_CONSTANT; 
				double disposable = grossIncome-taxedIncome-food-commute-accommodation;
				double percentageDisposable = (disposable/grossIncome)*100;
				JOptionPane.showMessageDialog(null, "Your monthly disposable income is €"+ disposable + " which is "+ percentageDisposable +"% of your salary.");
				
				if (disposable <= 0)
				{ 
					JOptionPane.showMessageDialog(null, "You have no disposable income.");
				}
				else if (disposable<MUCH_BELOW_AVERAGE_INCOME)
				{
					JOptionPane.showMessageDialog(null, "Your monthly disposable income is much less than the average disposable per month.");
				}
				else if (disposable<AVERAGE_INCOME)
				{
					JOptionPane.showMessageDialog(null, "Your monthly disposable income is less than the average disposable per month.");
				}
				else if (disposable==AVERAGE_INCOME)
				{
					JOptionPane.showMessageDialog(null, "Your monthly disposable income is equal to the average disposable per month.");
				}
				else if (disposable<MUCH_ABOVE_AVERAGE_INCOME)
				{
					JOptionPane.showMessageDialog(null, "Your monthly disposable income is greater than the average disposable per month.");
				}
				else if (disposable>MUCH_ABOVE_AVERAGE_INCOME)
				{
					JOptionPane.showMessageDialog(null, "Your monthly dispoable income is much greater than the average disposable per month.");
				}
		// TODO Auto-generated method stub

	}

}
