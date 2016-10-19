package interpreter.pattern.demo;

import java.util.Scanner;

/*Context class:interpretion is carried out based on our implementation.*/
class Context
{
	public String input;
	public Context(String input)
	{
		this.input=input;
	}
	public void getBinaryForm(String input)
	{
		int i = Integer.parseInt(input);
		//integer to its equivalent binary string representation
		String binaryString = Integer.toBinaryString(i);
		System.out.println("Binary equivalent of "+input+ " is "+ binaryString);
	}
	public void printInWords(String input)
	{
		this.input = input;
		System.out.println("Printing the input in words:");
		char c[]=input.toCharArray();
		for(int i=0;i<c.length;i++)
		{
			switch (c[i])
			{
			case '1':                    
				System.out.print("One ");
				break;
			case '2':                   
				System.out.print("Two ");
				break;
			case '3':                  
				System.out.print("Three ");
				break;
			case '4':                    
				System.out.print("Four ");
				break;
			case '5':                   
				System.out.print("Five ");
				break;
			case '6':                  
				System.out.print("Six ");
				break;
			case '7':                    
				System.out.print("Seven ");
				break;
			case '8':                   
				System.out.print("Eight ");
				break;
			case '9':                  
				System.out.print("Nine ");
				break;
			case '0':                  
				System.out.print("Zero ");
				break;
			default:
				System.out.print("* ");
				break;
			}
		}
	}
}



interface IExpression
{
	void interpret(Context ic);
}
class StringToBinaryExp implements IExpression
{
	private String str;
	public StringToBinaryExp(String s)
	{
		str = s;
	}    

	@Override
	public void interpret(Context ic) 
	{
		ic.getBinaryForm(str);
	}
}
class IntToWords implements IExpression
{
	private String str;
	public IntToWords(String str)
	{
		this.str = str;
	}        
	@Override
	public void interpret(Context ic) 
	{
		ic.printInWords(str);
	}
}
class InterpreterPatternEx
{
	public Context clientContext=null;
	public IExpression exp=null;
	public InterpreterPatternEx(Context c)
	{
		clientContext = c;
	}
	public void interpret(String str)
	{
		//We'll test 2 consecutive inputs at a time
		for(int i=0;i<2;i++){
			System.out.println("\nEnter ur choice(1 or 2)");
			Scanner in = new Scanner(System.in);
			String c = in.nextLine();
			if (c.equals("1"))
			{
				exp = new IntToWords(str);
				exp.interpret(clientContext);
			}
			else
			{
				exp = new StringToBinaryExp(str);
				exp.interpret(clientContext);
			}
		}                    
	}

	public static void main(String[] args)
	{
		System.out.println("\n***Interpreter Pattern Demo***\n");
		System.out.println("Enter a number :");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		//String input = "65";            
		Context context=new Context(input);
		InterpreterPatternEx client = new InterpreterPatternEx(context);           
		client.interpret(input);           
	}
}





