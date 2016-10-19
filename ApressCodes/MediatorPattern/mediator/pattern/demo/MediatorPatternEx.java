    package mediator.pattern.demo;

    abstract class Mediator
    {        
        public abstract void Send(Friend frd, String msg);         
    }

    // ConcreteMediator
    class ConcreteMediator extends  Mediator
    {
        private Friend1 friend1;
        private Friend2 friend2;
        private Boss boss;

        //In this example,setters are sufficient.
      
		public void setFriend1(Friend1 friend1) {
			this.friend1 = friend1;
		}
		
		public void setFriend2(Friend2 friend2) {
			this.friend2 = friend2;
		}
		
		public void setBoss(Boss boss) {
			this.boss = boss;
		}
        
        @Override
        public void Send(Friend frd,String msg)
        {
            //In all case, boss is notified
            if (frd == friend1)
            {
                friend2.Notify(msg);
                boss.Notify(friend1.name + " sends message to " + friend2.name);
            }
            if(frd==friend2)
            {
                friend1.Notify(msg);
                boss.Notify(friend2.name + " sends message to " + friend1.name);
               
            }
            //Boss is sending message to others
            if(frd==boss)
            {
                friend1.Notify(msg);
                friend2.Notify(msg);
            }           
        }

		
    }

    // Friend
    abstract class Friend
    {
        protected Mediator mediator;
        public String name;

        // Constructor 
        public Friend(Mediator _mediator)
        {
            mediator = _mediator;
        }
    }

    // Friend1-first participant
    class Friend1 extends Friend
    {
        public Friend1(Mediator mediator,String name)
        {
        	super(mediator);
            this.name = name;
        }

        public void Send(String msg)
        {
            mediator.Send(this,msg);
        }

        public void Notify(String msg)
        {
        	System.out.println("Amit gets message: "+ msg);
        }
    }

    // Friend2-Second participant
    class Friend2 extends Friend
    {
        // Constructor 
        public Friend2(Mediator mediator,String name)
        {
            super(mediator);
        	this.name = name;
        }

        public void Send(String msg)
        {
            mediator.Send(this,msg);
        }

        public void Notify(String msg)
        {
        	System.out.println("Sohel gets message: "+ msg);
        }
    }
    // Friend3-Third Participant.He is the boss.He is notified whenever friend1 and friend2 communicates.
    class Boss extends Friend
    {
        // Constructor 
        public Boss(Mediator mediator,String name)
        {
        	super(mediator);
            this.name = name;
        }

        public void Send(String msg)
        {
            mediator.Send(this, msg);
        }

        public void Notify(String msg)
        {
        	System.out.println("\nBoss sees message: " + msg);
        	System.out.println("");
        }
    }

    class MediatorPatternEx
    {
        public static void main(String[] args)
        {
        	System.out.println("***Mediator Pattern Demo***\n");
        	ConcreteMediator m = new ConcreteMediator();

            Friend1 Amit= new Friend1(m,"Amit");
            Friend2 Sohel = new Friend2(m,"Sohel");
            Boss Raghu = new Boss(m,"Raghu");

            m.setFriend1(Amit);
            m.setFriend2(Sohel);
            m.setBoss(Raghu);

            Amit.Send("[Amit here]Good Morrning. Can we discuss the mediator pattern?");
            Sohel.Send("[Sohel here]Good Morning.Yes, we can discuss now.");
            Raghu.Send("\n[Raghu here]:Please get back to work quickly");

          
        }
    }


