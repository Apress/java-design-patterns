package prototype.pattern.demo;
import car.BasicCar;
import car.Ford;
import car.Nano;
//import car.*;

public class PrototypePatternEx 
{
    public static void main(String[] args) throws CloneNotSupportedException
    {
    	System.out.println("***Prototype Pattern Demo***\n");
    	BasicCar nano_base = new Nano("Green Nano") ;
        nano_base.price=100000;
        
        BasicCar ford_basic = new Ford("Ford Yellow");
        ford_basic.price=500000;        
       
        BasicCar bc1;
        //Nano
        bc1 =nano_base.clone();
       //Price will be more than 100000 for sure
        bc1.price = nano_base.price+BasicCar.setPrice();
        System.out.println("Car is: "+ bc1.modelname+" and it's price is Rs."+bc1.price);
        
        //Ford            
        bc1 =ford_basic.clone();
        //Price will be more than 500000 for sure
        bc1.price = ford_basic.price+BasicCar.setPrice();
        System.out.println("Car is: "+ bc1.modelname+" and it's price is Rs."+bc1.price);

        
    }
}
