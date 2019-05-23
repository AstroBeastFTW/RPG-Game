package bleh;
import java.util.*;
public interface dice 
{	
	public static Random rand = new Random();
	public static int roll6()
	{
	    int n = rand.nextInt(7);
		while(n == 0)
		{
			n = rand.nextInt(7);
	    }//1-6
		return n;
	}
	public static int roll10()
	{
		int n = rand.nextInt(11);
		while(n == 0)
		{
		    n = rand.nextInt(11);
		}
		return n;
	}//1-10
	public static int roll20()
	{
	    int n = rand.nextInt(21);
	    while(n == 0)
	    {
	        n = rand.nextInt(21);
	    }//1-20
	    return n;
	}
}
