package state.pattern.demo;
abstract class RemoteControl
{
    public abstract void pressSwitch(TV context);
}


class Off extends RemoteControl
{
   	@Override
	public void pressSwitch(TV context){
        System.out.println("I am Off .Going to be On now");
        context.setState(new On());
    }
}


class On extends RemoteControl
{
   	@Override
	public void pressSwitch(TV context)
	{
   		System.out.println("I am already On .Going to be Off now");
        context.setState(new Off());
    }
}


class TV
{
    private RemoteControl state;    
    
    public RemoteControl getState() {
		return state;
	}
	public void setState(RemoteControl state) {
		this.state = state;
	}
	public TV(RemoteControl state)
    {
        this.state=state;
    }
	public void pressButton()
    {
        state.pressSwitch(this);
    }
}
 class StatePatternEx 
{
	 public static void main(String[] args)
    {
		 System.out.println("***State Pattern Demo***\n");
		 //Initially TV is Off
        Off initialState = new Off();
        TV tv = new TV(initialState);
        //First time press
        tv.pressButton();
        //Second time press
        tv.pressButton();        
    }
}



