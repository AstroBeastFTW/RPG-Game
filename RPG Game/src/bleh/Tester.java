package bleh;
import java.io.*;
import javax.swing.*;
import java.util.*;
public class Tester extends MyButton implements buildCharacter, fight
{
	static Scanner scan = new Scanner(System.in);
    static Random rand = new Random();
    public static String playerName;
    public static int playerhp;
    public static int maxhp;
    public static int maxmana;
    public static int mana;
    public static int playermeleedmg;
    public static int xp;
    public static int enemyhp;
    public static int enemymeleedmg;
    public static int Level;
    public static String charclass;
    public static boolean fighting = false; //globals for player stats & enemy stats
    public static ArrayList<String> characterInfo = new ArrayList<String>();
    public static ArrayList<Integer> numCharacterInfo = new ArrayList<Integer>();
    /* Formatting the Array
     * PlayerName
     * class
     * hp
     * mana (if they have it)
     * meleedmg
     * xp
     * level
     */
    private static final long serialVersionUID = 1L;

	public Tester(String label) {
		super(label);
		// TODO Auto-generated constructor stub
	}
	public static void main(String args[]) throws IndexOutOfBoundsException
	{
	    int num = 2;
	    while(num > 1)
	    {
		    characterInfo = buildCharacter.make();
		    playerName = characterInfo.get(0);
		    charclass = characterInfo.get(1);
		    if(charclass.equals("mage"))
		    {
		    	numCharacterInfo.add(Integer.parseInt(characterInfo.get(2)));
		    	numCharacterInfo.add(Integer.parseInt(characterInfo.get(2)));
		    	numCharacterInfo.add(Integer.parseInt(characterInfo.get(3)));
		    	numCharacterInfo.add(Integer.parseInt(characterInfo.get(3)));
		    	numCharacterInfo.add(Integer.parseInt(characterInfo.get(4)));
		    	numCharacterInfo.add(Integer.parseInt(characterInfo.get(5)));
		    	numCharacterInfo.add(Integer.parseInt(characterInfo.get(6)));
		    	playerhp = numCharacterInfo.get(0);
		    	maxhp = playerhp;
		    	
		    }
		    else
		    {
		    	numCharacterInfo.add(Integer.parseInt(characterInfo.get(2)));
		    	numCharacterInfo.add(Integer.parseInt(characterInfo.get(2)));
		    	numCharacterInfo.add(Integer.parseInt(characterInfo.get(3)));
		    	numCharacterInfo.add(Integer.parseInt(characterInfo.get(4)));
		    	numCharacterInfo.add(Integer.parseInt(characterInfo.get(5)));
		    	maxmana = 0;
		    	mana = 0;
		    }
		  	while(numCharacterInfo.get(numCharacterInfo.size()-1) == 1)
		    {
		    	numCharacterInfo = fight.fighting(characterInfo, numCharacterInfo);
		    }
		    System.out.println("This area is clear... time to move on\n");
		    while(numCharacterInfo.get(numCharacterInfo.size()-1) == 2)
		    {
		    	numCharacterInfo = fight.fighting(characterInfo, numCharacterInfo);
		    }
		    System.out.println("This area is clear... time to move on\n");
		    while(numCharacterInfo.get(numCharacterInfo.size()-1) == 3)
		    {
		    	numCharacterInfo = fight.fighting(characterInfo, numCharacterInfo);
		    }
		    System.out.println("This area is clear... time to move on\n");
		    while(numCharacterInfo.get(numCharacterInfo.size()-1) == 4)
		    {
		    	numCharacterInfo = fight.fighting(characterInfo, numCharacterInfo);
		    }
		    System.out.println("This area is clear... time to move on\n");
		    while(numCharacterInfo.get(numCharacterInfo.size()-1) == 5)
		    {
		    	numCharacterInfo = fight.fighting(characterInfo, numCharacterInfo);
		    }//keeps in area until levelUp
		    num = 0;
	    }
   }
}
