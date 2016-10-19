package different.type.adapter;
interface IIntegerValue
{
	public int getInteger(); 

}
class IntegerValue implements IIntegerValue
{
	@Override
	public int getInteger() 
	{
		return 5;
	}    
}
class ClassAdapter extends IntegerValue
{
	//Incrementing by 2
	public int getInteger()
	{
		return 2+super.getInteger();
	}
}
class ObjectAdapter
{
	private IIntegerValue myInt;
	public ObjectAdapter(IIntegerValue myInt)
	{
		this.myInt=myInt;
	}
	//Incrementing by 2
	public int getInteger()
	{
		return 2+this.myInt.getInteger();
	}

}

class ClassAndObjectAdapter 
{
	public static void main(String args[])
	{		
		System.out.println("***Class and Object Adapter Demo***");
		ClassAdapter ca1=new ClassAdapter();
		System.out.println("Class Adapter is returning :"+ca1.getInteger());

		ClassAdapter ca2=new ClassAdapter();
		ObjectAdapter oa=new ObjectAdapter(new IntegerValue());		
		System.out.println("Object Adapter is returning :"+oa.getInteger());
	}
}
