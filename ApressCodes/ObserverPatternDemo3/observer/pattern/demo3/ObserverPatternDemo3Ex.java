package observer.pattern.demo3;

import java.util.*;

    interface IObserver
    {
        void update(String s,int i);
    }
    class Observer1 implements IObserver
    {
        @Override
		public void update(String s,int i) 
		{
        	System.out.println("Observer1: myValue in "+ s+ " is now: "+i);	
		}
    }
    class Observer2 implements IObserver
    {
    	@Override
		public void update(String s,int i) 
		{
			System.out.println("Observer2: observes ->myValue is changed in "+s+" to :"+i);			
		}
    }
    class Observer3 implements IObserver
    {
    	@Override
		public void update(String s,int i) 
		{
			System.out.println("Observer3 is observing:myValue is changed in "+s+" to :"+i);			
		}
    }
    
    interface ISubject
    {
        void register(IObserver o);
        void unregister(IObserver o);
        void notifyObservers(int i);
    }
    
    class Subject1 implements ISubject
    {
        private int myValue;
        
        
        public int getMyValue() {
			return myValue;
		}

		public void setMyValue(int myValue) {
			this.myValue = myValue;
			 //Notify observers
			notifyObservers(myValue);
		}

		List<IObserver> observersList=new ArrayList<IObserver>();
        
		@Override
        public void register(IObserver o)
        {
 	        observersList.add(o);
        }
		@Override
        public void unregister(IObserver o)
        {
 	        observersList.remove(o);
        }
        @Override
        public void notifyObservers(int updatedValue) 
        { 
           for(int i=0;i<observersList.size();i++)
        	{
        		observersList.get(i).update(this.getClass().getSimpleName(),updatedValue);
        	}
        }		       
    }
    class Subject2 implements ISubject
    {
        private int myValue;
        
        
        public int getMyValue() {
			return myValue;
		}

		public void setMyValue(int myValue) {
			this.myValue = myValue;
			 //Notify observers
			notifyObservers(myValue);
		}

		List<IObserver> observersList=new ArrayList<IObserver>();
        
		@Override
        public void register(IObserver o)
        {
 	        observersList.add(o);
        }
		@Override
        public void unregister(IObserver o)
        {
 	        observersList.remove(o);
        }
        @Override
        public void notifyObservers(int updatedValue) 
        { 
           for(int i=0;i<observersList.size();i++)
        	{
        		observersList.get(i).update(this.getClass().getSimpleName(),updatedValue);
        	}
        }		       
    }
    
    

    class ObserverPatternDemo3Ex 
    {
        public static void main(String[] args)
        {
        	System.out.println("*** Observer Pattern Demo3***\n");
            Subject1 sub1 = new Subject1();
            Subject2 sub2 = new Subject2();
            
            Observer1 ob1 = new Observer1();
            Observer2 ob2 = new Observer2();
            Observer3 ob3 = new Observer3();
            
          //Observer1 and Observer2 registers to Subject 1
            sub1.register(ob1);
            sub1.register(ob2);
          //Observer2 and Observer3 registers to Subject 2
            sub2.register(ob2);
            sub2.register(ob3);            
          //Set new value to Subject 1
          //Observer1 and Observer2 get notification            
            sub1.setMyValue(50);
            System.out.println();
          //Set new value to Subject 2
          //Observer2 and Observer3 get notification
            sub2.setMyValue(250);
            System.out.println();            
            //unregister Observer2 from Subject 1
            sub1.unregister(ob2);
          //Set new value to Subject & only Observer1 is notified 
            sub1.setMyValue(550);
            System.out.println();
            //ob2 can still notice change in Subject 2
            sub2.setMyValue(750);         
            
        }
    }

