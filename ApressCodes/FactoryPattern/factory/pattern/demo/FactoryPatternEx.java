package factory.pattern.demo;
interface IAnimal
{
	void Speak();
}
class Duck implements IAnimal
{
	@Override
	public void Speak()
	{
		System.out.println("Duck says Pack-pack");
	}
}
class Tiger implements IAnimal
{
	@Override
	public void Speak() 
	{
		System.out.println("Tiger says: Halum..Halum");

	}
}

abstract class IAnimalFactory
{
	public abstract IAnimal GetAnimalType(String type) throws Exception;//if we cannot instantiate later we'll throw exception
}
class ConcreteFactory extends IAnimalFactory
{
	//IAnimal animalType;
	//Duck duck=null;
	//Tiger tiger=null;
	@Override
	public  IAnimal GetAnimalType(String type) throws Exception
	{
		/*
		 * IAnimal animal;
		if (type.Equals("Duck"))
		{
		    animal = new Duck();
		}
		else
		{
		    animal = new Tiger();
		}
		return animal;

		//OR-use the following codes-just a change. I wanted to use switch instead of if-else. 
		//It is better readable when there are many options.      
		 */
		
		switch (type)
		{
		case "Duck": 
			//duck= new Duck();
			//return duck;
			return new Duck();
		case "Tiger":
			//tiger= new Tiger();
			//return tiger;
			return new Tiger();
		default:
			throw new Exception( "Animal type : "+type+" cannot be instantiated");
		}
	}
}
class FactoryPatternEx
{
	public static void main(String[] args) throws Exception
	{
		System.out.println("***Factory Pattern Demo***\n");
		IAnimalFactory animalFactory = new ConcreteFactory();
		IAnimal DuckType=animalFactory.GetAnimalType("Duck");
		DuckType.Speak();

		IAnimal TigerType = animalFactory.GetAnimalType("Tiger");
		TigerType.Speak(); 
		//There is no Lion type. So, an exception will be thrown   
		IAnimal LionType = animalFactory.GetAnimalType("Lion");
		LionType.Speak();          

	}
}

