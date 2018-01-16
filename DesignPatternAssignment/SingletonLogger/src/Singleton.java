import java.util.Date;

public class Singleton implements LoggerInterface {
	private volatile static Singleton obj;
	
	private Singleton() {  }
	
	public static Singleton getInstance()
	{
		if(obj == null)
		{
			synchronized(Singleton.class)
			{
				if(obj == null)
					obj = new Singleton();
			}
		}
		return obj;
	}

	public String logger() {
		return "Log message at time " + (new Date() );
	}
	
}
