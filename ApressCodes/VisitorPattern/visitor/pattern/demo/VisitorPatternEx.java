package visitor.pattern.demo;

interface IOriginalInterface
{
	void accept(IVisitor visitor);
}
class MyClass implements IOriginalInterface
{
	//Initial or default value
	private int myInt = 5;
	public int getMyInt() 
	{
		return myInt;
	}

	public void setMyInt(int myInt) 
	{
		this.myInt = myInt;
	}

	@Override
	public void accept(IVisitor visitor) 
	{             
		System.out.println("Initial value of the integer :"+ myInt);
		visitor.visit(this);
		System.out.println("\nValue of the integer now :"+ myInt);                   
	}		
}

interface IVisitor
{
	void visit(MyClass myClassElement);
}
class Visitor implements IVisitor
{
	@Override
	public void visit(MyClass myClassElement)  
	{
		System.out.println("Visitor is trying to change the integer value");            
		myClassElement.setMyInt(100);
		System.out.println("Exiting from Visitor- visit");
	}
}
class VisitorPatternEx 
{
	public static void main(String[] args)
	{
		System.out.println("***Visitor Pattern Demo***\n");
		IVisitor v = new Visitor();
		MyClass myClass = new MyClass();
		myClass.accept(v);           
	}
}





