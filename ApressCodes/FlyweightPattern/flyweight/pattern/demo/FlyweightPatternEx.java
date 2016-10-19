package flyweight.pattern.demo;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sarcarv
 * Our interface
 *
 */
interface IRobot
{
	void Print();
}

/**
 * @author sarcarv
 * A 'ConcreteFlyweight' class-SmallRobot
 *
 */
class SmallRobot implements IRobot
{
	@Override
	public void Print() 
	{
		System.out.println(" This is a Small Robot");
	}
} 


/**
 * @author sarcarv
 * A 'ConcreteFlyweight' class-LargeRobot
 *
 */
class LargeRobot implements IRobot
{
	@Override
	public void Print()
	{
		System.out.println(" I am a Large Robot");
	}
}

/**
 * @author sarcarv
 * The 'FlyweightFactory' class
 *
 */
class RobotFactory
{
	Map<String, IRobot> shapes = new HashMap<String, IRobot>();

	public int TotalObjectsCreated()
	{
		return shapes.size(); 
	}

	public IRobot GetRobotFromFactory(String RobotCategory) throws Exception
	{
		IRobot robotCategory = null;
		if (shapes.containsKey(RobotCategory))
		{
			robotCategory = shapes.get(RobotCategory);
		}
		else
		{
			switch (RobotCategory)
			{
			case "small":
				System.out.println("We do not have Small Robot.So we are creating a Small Robot now.");
				robotCategory = new SmallRobot();
				shapes.put("small", robotCategory);
				break;
			case "large":
				System.out.println("We do not have Large Robot.So we are creating a Large Robot now .");
				robotCategory = new LargeRobot();
				shapes.put("large", robotCategory);
				break;
			default:
				throw new Exception(" Robot Factory can create only small and large shapes");
			}
		}
		return robotCategory;
	}

}
/**
 * @author sarcarv
 *FlyweightPattern is in action.
 */

class FlyweightPatternEx 
{
	public static void main(String[] args) throws Exception
	{
		RobotFactory myfactory = new RobotFactory();
		System.out.println("\n***Flyweight Pattern Example***\n");

		IRobot shape = myfactory.GetRobotFromFactory("small");
		shape.Print();
		//Here we are trying to get the objects additional 2 times.
		//Note that: now onwards we need not create additional small robots-we have already created of this category.
		for (int i = 0; i < 2; i++)
		{
			shape = myfactory.GetRobotFromFactory("small");
			shape.Print();
		}
		int NumOfDistinctRobots = myfactory.TotalObjectsCreated();
		System.out.println("\nDistinct Robot objects created till now= "+ NumOfDistinctRobots);

		//Here we are trying to get the objects 5 times.
		//Note that: second time onwards we need not create additional large robots-we have already created of this category on first attempt(at i=0)
		for (int i = 0; i < 5; i++)
		{
			shape = myfactory.GetRobotFromFactory("large");
			shape.Print();
		}            

		NumOfDistinctRobots = myfactory.TotalObjectsCreated();
		System.out.println("\n Finally no of Distinct Robot objects created: "+ NumOfDistinctRobots);            
	}
}


