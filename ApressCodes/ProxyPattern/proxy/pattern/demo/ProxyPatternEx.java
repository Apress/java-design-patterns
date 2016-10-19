package proxy.pattern.demo;
import ProxyClasses.Proxy;

class ProxyPatternEx 
    {
        public static void main(String[] args)
        {
        	
        	System.out.println("***Proxy Pattern Demo***\n");
            Proxy px = new Proxy();
            px.doSomeWork();           
        }
    }
