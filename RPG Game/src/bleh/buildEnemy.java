package bleh;
import java.util.*;
public interface buildEnemy 
{
	public static ArrayList<Integer> buildE(int x, ArrayList<Integer> y) 
	{
        int Level = x;
		switch(Level){
        case 1:
            y.add(9);
            y.add(1);
            break;
        case 2:
        	y.add(19);
        	y.add(4);
            break;
        case 3:
        	y.add(24);
        	y.add(6);
            break;
        case 4:
        	y.add(32);
        	y.add(7);
            break;
        case 5:
        	y.add(40);
        	y.add(9);
            break; //initializes enemy stats based on player level
        }
		return y;
    }
	
	public static void printEnemyStats(ArrayList<Integer> x) 
	{
        System.out.println("Enemy "+"\nhp: " + x.get(0) + "\ndmg: " + x.get(1) + "\n");
    }
}
