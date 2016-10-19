package adapter.pattern.demo;
class Rect
    {
        public double l;
        public double w;
    }
class Triangle
{
    public double b;//base
    public double h;//height
    public Triangle(int b, int h)
    {
        this.b = b;
        this.h = h;
    }
}
/*Calculator can calculate the area of a rectangle.To calculate the area we it needs an Rectangle input.*/
class Calculator
{   Rect rectangle;
	public double getArea(Rect r)
	{
		rectangle=r;
		return rectangle.l * rectangle.w;
	}
}    
    
/*Calculate the area of a Triangle using CalculatorAdapter.Please note here:this time our input is a Triangle.*/
class CalculatorAdapter
{
	Calculator calculator;
	Triangle triangle;
	public double getArea(Triangle t)
	{
		calculator = new Calculator();
		triangle=t;
		Rect r = new Rect();
		//Area of Triangle=0.5*base*height
		r.l = triangle.b;
		r.w = 0.5*triangle.h;
		return calculator.getArea(r);
	}

}
   
public class AdapterPattern 
{
	public static void main(String[] args)
	{
		System.out.println("***Adapter Pattern Demo***");
		CalculatorAdapter cal=new CalculatorAdapter();           
		Triangle t = new Triangle(20,10);
		System.out.println("\nAdapter Pattern Example\n");
		System.out.println("Area of Triangle is :" + cal.getArea(t));        
	}
}
