package decorator.pattern.demo;
abstract class Component
    {
        public abstract void doJob();
        
    }
    class ConcreteComponent extends Component
    {
        @Override
		public void doJob() 
        {
			System.out.println(" I am from Concrete Component-I am closed for modification.");
			
		}
    }

    abstract class AbstractDecorator extends Component
    {
        protected Component com ;
        public void SetTheComponent(Component c)
        {
            com = c;
        }
        public void doJob()
        {
            if (com != null)
            {
                com.doJob();
            }
        }
       
    }
    class ConcreteDecoratorEx_1 extends AbstractDecorator
    {
       public void doJob()
        {
            super.doJob();
            //Add additional thing if necessary          
            System.out.println("I am explicitly from Ex_1");
        }
    }
    class ConcreteDecoratorEx_2 extends AbstractDecorator
    {
        public  void doJob()
        {
        	System.out.println("");
        	System.out.println("***START Ex-2***");
            super.doJob();
            //Add additional thing if necessary
            System.out.println("Explicitly From DecoratorEx_2");
            System.out.println("***END. EX-2***");
        }
    }
    class DecoratorPatternEx 
    {
        public static void main(String[] args)
        {
        	System.out.println("***Decorator pattern Demo***");
            ConcreteComponent cc = new ConcreteComponent();
            
            ConcreteDecoratorEx_1 cd_1 = new ConcreteDecoratorEx_1();
            cd_1.SetTheComponent(cc);
            cd_1.doJob();

            ConcreteDecoratorEx_2 cd_2= new ConcreteDecoratorEx_2();
            cd_2.SetTheComponent(cd_1);//Adding results from cd_1 now
            cd_2.doJob();            
        }
    }





