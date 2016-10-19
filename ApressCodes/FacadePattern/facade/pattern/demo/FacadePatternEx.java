package facade.pattern.demo;
import robotfacade.RobotFacade;

class FacadePatternEx 
{
	public static void main(String[] args)
	{
		System.out.println("***Facade Pattern Demo***");
		RobotFacade rf1 = new RobotFacade();
		rf1.ConstructRobot("Green", "Iron");
		RobotFacade rf2 = new RobotFacade();
		rf2.ConstructRobot("Blue", "Steel");        

	}
}