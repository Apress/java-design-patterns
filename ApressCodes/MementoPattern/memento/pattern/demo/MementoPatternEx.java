package memento.pattern.demo;

// Memento class

class Memento
{
	private String state;

	public Memento(String state)
	{
		this.state = state;
	}       

	public String getState() 
	{
		return state;
	}

}    

//  Originator class

class Originator
{
	private String state;
	Memento m;

	public void setState(String state) 
	{
		this.state = state;
		System.out.println("State at present : " +state);
	}

	// Creates memento 
	public Memento OriginatorMemento()
	{
		m = new Memento(state);
		return m;
	}


	// Back to old state
	public void Revert(Memento memento)
	{
		System.out.println("Restoring to previous state...");
		state = memento.getState();
		System.out.println("State at present :" +state);
	}		
}



//Caretaker Class
class Caretaker
{
	private Memento _memento;

	public void SaveMemento(Memento m)
	{
		_memento = m;       
	}
	public Memento RetrieveMemento()
	{
		return _memento;
	}

}

class MementoPatternEx 
{
	public static void main(String[] args)
	{
		System.out.println("***Memento Pattern Demo***\n");
		Originator o = new Originator();
		o.setState("First state");

		// Holding old state 
		Caretaker c = new Caretaker();
		c.SaveMemento(o.OriginatorMemento());

		//Changing state
		o.setState("Second state");

		// Restore saved state           
		o.Revert(c.RetrieveMemento());

	}
}

