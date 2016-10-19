package flyweight.pattern.modified.demo;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
class Robot implements IRobot
{ 
	String robotType;
	public String colorOfRobot;
	public Robot(String robotType)
	{
		this.robotType=robotType;
	}
	public void setColor(String colorOfRobot)
	{
		this.colorOfRobot=colorOfRobot;
	}
	@Override
	public void Print() 
	{
		System.out.println(" This is a " +robotType+ " type robot with "+colorOfRobot+ "color");
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

	public IRobot GetRobotFromFactory(String robotType) throws Exception
	{
		IRobot robotCategory= null;
		if (shapes.containsKey(robotType))
		{
			robotCategory = shapes.get(robotType);
		}
		else
		{
			switch (robotType)
			{
			case "King":
				System.out.println("We do not have King Robot.So we are creating a King Robot now.");
				robotCategory = new Robot("King");
				shapes.put("King",robotCategory);
				break;
			case "Queen":
				System.out.println("We do not have Queen Robot.So we are creating a Queen Robot now.");
				robotCategory = new Robot("Queen");
				shapes.put("Queen",robotCategory);
				break;
			default:
				throw new Exception(" Robot Factory can create only king and queen type robots");
			}
		}
		return robotCategory;
	}

}
/**
 * @author sarcarv
 *FlyweightPattern is in action.
 */

class FlyweightPatternModifiedEx 
{
	public static void main(String[] args) throws Exception
	{
		RobotFactory myfactory = new RobotFactory();
		System.out.println("\n***Flyweight Pattern Example Modified***\n");
		Robot shape;
		//Here we are trying to get 3 king type robots
		for (int i = 0; i < 3; i++)
		{
			shape =(Robot) myfactory.GetRobotFromFactory("King");
			shape.setColor(getRandomColor());
			shape.Print();
		}
		//Here we are trying to get 3 queen type robots
		for (int i = 0; i < 3; i++)
		{
			shape =(Robot) myfactory.GetRobotFromFactory("Queen");
			shape.setColor(getRandomColor());
			shape.Print();
		}
		int NumOfDistinctRobots = myfactory.TotalObjectsCreated();
		//System.out.println("\nDistinct Robot objects created till now= "+ NumOfDistinctRobots);		
		System.out.println("\n Finally no of Distinct Robot objects created: "+ NumOfDistinctRobots);            
	}
	static String getRandomColor()
	{
		Random r=new Random();
		/*You can supply any number of your choice in nextInt argument.
		 * we are simply checking the random number generated is an even number
		 * or and odd number.And based on that we are choosing the color. 
		 * For simplicity, we'll use only two color-red and green
		 */

		int random=r.nextInt(20);
		if(random%2==0)
		{
			return "red";
		}
		else
		{
			return "green";
		}		
	}	
}


