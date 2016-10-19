package strategy.pattern.demo;
import java.io.IOException;
//For Java old versions-to take input from user
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
/* Java 5  added a nice utility class called Scanner, to get input from user */
import java.util.Scanner;

import contextofchoice.Context;
//import choices.*;
import choices.FirstChoice;
import choices.IChoice;
import choices.SecondChoice;


class StrategyPatternEx
{
	public static void main(String[] args) throws IOException
	{
		System.out.println("***Strategy Pattern Demo***");
		Scanner in= new Scanner(System.in);//To take input from user
		IChoice ic = null;    	 
		Context cxt = new Context();
		String input1,input2;;
		//Looping twice to test two different choices
		try
		{
			for (int i = 1; i <= 2; i++)
			{	
				System.out.println("Enter an integer:");
				input1 = in.nextLine();
				System.out.println("Enter another integer:");
				input2 = in.nextLine();
				System.out.println("Enter ur choice(1 or 2)");
				System.out.println("Press 1 for Addition, 2 for Concatenation");
				String c = in.nextLine();

				/*For Java old versions-use these lines to collect input from user
				BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
				String c = br.readLine();*/

				if (c.equals("1"))
				{
					//If user input is 1, create object of FirstChoice (Strategy 1)
					ic = new FirstChoice();
				}
				else
				{
					//If user input is 2, create object of SecondChoice (Strategy 2)
					ic = new SecondChoice();
				}
				//Associate the Strategy with Context
				cxt.SetChoice(ic);
				cxt.ShowChoice(input1,input2);
			} 
		}
		finally
		{
			in.close();    		
		}
		System.out.println("End of Strategy pattern");
	}
}
