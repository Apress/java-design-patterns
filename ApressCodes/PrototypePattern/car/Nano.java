package car;

public class Nano extends BasicCar 
{
    public Nano(String m)
    {
        modelname = m;
    }   
	@Override	
	public BasicCar clone() throws CloneNotSupportedException 
	{
		 return (Nano)super.clone();
		 //return this.clone();
	}
}