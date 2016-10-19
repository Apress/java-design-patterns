package robotfacade;
import robotparts.*;


public class RobotFacade
{
	RobotColor rc;
	RobotMetal rm ;
	RobotBody rb;
	public RobotFacade()
	{
		rc = new RobotColor();
		rm = new RobotMetal();
		rb = new RobotBody();

	}
	public void ConstructRobot(String color,String metal)
	{
		System.out.println("\nCreation of the Robot Start");
		rc.SetColor(color);
		rm.SetMetal(metal);
		rb.CreateBody();
		System.out.println(" \nRobot Creation End");
		System.out.println();
	}    
}