package bleh;
import java.util.*;
public interface buildCharacter 
{
	static Scanner scan = new Scanner(System.in);
    public static ArrayList<String> make()
	{
    	ArrayList<String> info = new ArrayList<String> ();
		System.out.println("Enter your Name: ");
	    String playerName = scan.nextLine();
	    System.out.println("Choose your class: ");
	    System.out.println("'w' for warrior");
	    System.out.println("'a' for archer");
	    System.out.println("'m' for mage");
	    String charclass = scan.nextLine();
	    info.add(playerName);
	    info.add(charclass);
	    while(charclass.charAt(0) != 'w' && charclass.charAt(0) != 'a' && charclass.charAt(0) != 'm')
	    {
	    	System.out.println("'w' for warrior");
	        System.out.println("'a' for archer");
	        System.out.println("'m' for mage");
	        charclass = scan.nextLine();
	    }
	    if(charclass.charAt(0) == 'w')
	    {
	    	info = buildWarrior(info);
	    }
	    if(charclass.charAt(0) == 'a')
	    {
	    	info = buildArcher(info);
	    }
	    if(charclass.charAt(0) == 'm')
	    {
	        info = buildMage(info);
	        
	    }
	    ArrayList<Integer> numCharacterInfo = new ArrayList<Integer>();
	    if(charclass.equals("mage"))
	    {
	    	numCharacterInfo.add(Integer.parseInt(info.get(2)));
	    	numCharacterInfo.add(Integer.parseInt(info.get(2)));
	    	numCharacterInfo.add(Integer.parseInt(info.get(3)));
	    	numCharacterInfo.add(Integer.parseInt(info.get(3)));
	    	numCharacterInfo.add(Integer.parseInt(info.get(4)));
	    	numCharacterInfo.add(Integer.parseInt(info.get(5)));
	    	numCharacterInfo.add(Integer.parseInt(info.get(6)));	
	    }
	    else
	    {
	    	numCharacterInfo.add(Integer.parseInt(info.get(2)));
	    	numCharacterInfo.add(Integer.parseInt(info.get(2)));
	    	numCharacterInfo.add(Integer.parseInt(info.get(3)));
	    	numCharacterInfo.add(Integer.parseInt(info.get(4)));
	    	numCharacterInfo.add(Integer.parseInt(info.get(5)));
	    }
	    printStats(info, numCharacterInfo);
	    return (info);
	}
	private static ArrayList<String> buildWarrior(ArrayList<String> x) {
		String charclass = "warrior";
        String playerhp = "20";
        String playermeleedmg = "4";
        String xp = "0";
        String Level = "1"; 
        x.set(1, charclass);
        x.add(playerhp);
        x.add(playermeleedmg);
        x.add(xp);
        x.add(Level);
        return x;
    }
    private static ArrayList<String> buildArcher(ArrayList<String> x) {
    	String charclass = "archer";
    	String playerhp = "14";
    	String playermeleedmg = "6";
    	String xp = "0";
    	String Level = "1";
    	x.set(1, charclass);
        x.add(playerhp);
        x.add(playermeleedmg);
        x.add(xp);
        x.add(Level);
    	return x;
    }
    private static ArrayList<String> buildMage(ArrayList<String> x) {
    	String charclass = "mage";
        String playerhp = "10";
        String mana = "20";
        String playermeleedmg = "2";
        String xp = "0";
        String Level = "1"; 
        x.set(1, charclass);
        x.add(playerhp);
        x.add(mana);
        x.add(playermeleedmg);
        x.add(xp);
        x.add(Level);
        return x;// initializes globals according to class
    }
    public static void printStats(ArrayList<String> x, ArrayList<Integer> numX) 
    {
        if(x.get(1).equals("mage"))
        {
            System.out.println("Name: " + x.get(0) + "\nClass: " + x.get(1) + "\nHp: " + numX.get(1) + "\nMana: " + numX.get(3) + "\nDamage: " + numX.get(4) + "\nXp: " + numX.get(5) +  "\nLevel: " + numX.get(6) + "\n");
        }
        else
        {
            System.out.println("Name: " + x.get(0) + "\nClass: " + x.get(1) + "\nHp: " + numX.get(1) + "\nDamage: " + numX.get(2) + "\nXp: " + numX.get(3) + "\nLevel: " + numX.get(4) + "\n");
        }
    }
}
