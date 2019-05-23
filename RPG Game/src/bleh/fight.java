package bleh;
import java.io.*;
import java.util.*;
public interface fight extends buildEnemy, dice 
{
	/* enemy set up
	 * hp
	 * damage
	 */
	public static Scanner scan = new Scanner(System.in);
	public static ArrayList<Integer> fighting(ArrayList<String> wordX, ArrayList<Integer> x) //char info
	{
		ArrayList<Integer> charInfo = x;
		int Level = charInfo.get(charInfo.size()-1);
		int xp = charInfo.get(charInfo.size()-2);
		int mana = 0;
		String action;
        String spellAction = null;
        System.out.println("An enemy approaches");
        ArrayList<Integer> enemyInfo = new ArrayList<Integer> ();
        enemyInfo = buildEnemy.buildE(Level, enemyInfo);
        int enemyhp = enemyInfo.get(0);
        boolean fighting = true;
        while(fighting = true)
        {
            System.out.println("Press 'a' to attack\nPress 'i' for info");
            if(charInfo.size() == 7)
            {
                System.out.print("Press 's' for spells\n");
                mana = charInfo.get(3);
            }
            action = scan.nextLine();
            if(action.charAt(0) == 'a')
            {
            	enemyInfo = attack(charInfo, enemyInfo);
            	if(enemyInfo.get(0) <= 0)
            	{
            		fighting = false;
            	}
            	else
            	{
            		fighting = true;
            	}
                if(fighting == false)
                {
                    switch(Level)
                    {
	                    case 1: 
	                        xp = xp + 4;
	                        break;
	                    case 2:
	                        xp = xp + 6;
	                        break;
	                    case 3:
	                        xp = xp + 9;
	                        break;
	                    case 4:
	                        xp = xp + 12;
	                        break;
                    }
                    System.out.println("You earned :" + xp + " xp");
                    charInfo.set((charInfo.size()-2), xp);
                    charInfo = checkLevelUp(charInfo);
                    return charInfo;
                }
                charInfo = enemyattack(charInfo, enemyInfo);  
            }
            if(action.charAt(0) == 'i')
            {
            	buildCharacter.printStats(wordX,  charInfo);
                buildEnemy.printEnemyStats(enemyInfo);
            }
            if(action.charAt(0) == 's')
            {
	            System.out.println("Press 'f' for fireball\nPress 'h' to heal\n");
	            spellAction = scan.nextLine();
	            if(spellAction.charAt(0) == 'f')
	            {
		            if(dice.roll10() > 2)
		            {
		                mana = mana - 10;
		                if(mana <0)
		                {
		                    System.out.println("You don't have enough mana...");
		                    mana = mana + 10;
		                }
		                else
		                {
			                int k = 10; //randomly hurts 1-10
			                System.out.println("You hit for " + k + " damage!");
			                enemyhp = enemyhp - k;
			                if(enemyhp <= 0)
			                {
			                    System.out.println("You Won!"); 
			                    switch(Level)
			                    {
				                    case 1: 
				                        xp = xp + 4;
				                        break;
				                    case 2:
				                        xp = xp + 6;
				                        break;
				                    case 3:
				                        xp = xp + 9;
				                        break;
				                    case 4:
				                        xp = xp + 12;
				                        break;
			                    }
			                    System.out.println("You earned :" + xp + " xp");
			                    charInfo.set((charInfo.size()-2), xp);
			                    charInfo = checkLevelUp(charInfo);
			                    return charInfo;
			                }
		                charInfo = enemyattack(charInfo, enemyInfo);  
		                }
		            }
		            else
		            {
		                System.out.println("You miss!");
		                charInfo = enemyattack(charInfo, enemyInfo);
		            }
		        }
	            else if(spellAction.charAt(0) == 'h')
	            {
	                mana = mana - 8;
	                if(mana <0)
	                {
	                    System.out.println("You don't have enough mana...");
	                    mana = mana + 8;
	                }
	                else
	                {
	                    int heal = dice.roll10(); //randomly heals 1-8
	                    System.out.println("You heal your wounds...");
	                    System.out.println("+ " + heal + " hp");
	                    charInfo.set(1, (charInfo.get(1) + heal));
	                    if(charInfo.get(1)>charInfo.get(0))
	                    {
	                    	charInfo.set(1, charInfo.get(0));
	                    }
	                    charInfo = enemyattack(charInfo, enemyInfo);  
	                }
	            }
            }
        }
        return charInfo;
    }
	
	public static ArrayList<Integer> enemyattack(ArrayList<Integer> x, ArrayList<Integer> y) //char then enemy
	{
		int playerhp = x.get(1);
		int enemymeleedmg = y.get(1);
        if(dice.roll6() > 2)
        {
            System.out.println("Enemy hits!");
            playerhp = playerhp - enemymeleedmg;
            x.set(1, playerhp);
            if(playerhp <= 0)
            {
                gameover(x);
                System.exit(0);//game over if player health < 0
            }
        }
        else
        {
            System.out.println("Enemy Misses!");
        }       
        return x;
    }

	public static ArrayList<Integer> attack(ArrayList<Integer> x, ArrayList<Integer> y) //char then enemy
	{
    	int enemyhp = y.get(0);
        if(dice.roll6() > 2)
        {
            System.out.println("You hit!");
            if(x.size() == 7)
            {
            	enemyhp = enemyhp - x.get(4);
            }
            else
            {
            	enemyhp = enemyhp - x.get(2);
            }
            if(enemyhp <= 0)
            {
                System.out.println("You Won!"); //prints if enemy health < 0
                y.set(0, enemyhp);
                return y; 
            }
        }
        else
        {
            System.out.println("You miss!");
        }
        y.set(0, enemyhp);
        return y; 
    }
    
	public static void gameover(ArrayList<Integer> x) //char info
	{
        System.out.println("You Died!") ;
        System.out.println("GAME OVER!");
        System.exit(0); //terminates if lost
        return;
    }
	
	public static ArrayList<Integer> checkLevelUp(ArrayList<Integer> x)  //char info
	{
		int xp = x.get(x.size()-2);
		int Level = x.get(x.size()-1);
		int maxhp = x.get(0);
		int playerhp = x.get(1);
		int mana = 0;
		int maxmana = 0;
		int playermeleedmg = x.get(2);
		if(x.size() >= 7)
		{
			mana = x.get(3);
			maxmana = x.get(2);
			playermeleedmg = x.get(4);
		}
        if(xp >= 100 && Level == 4)
        {
            System.out.println("Level 5!");
            Level = Level + 1;
            maxhp = maxhp + 25;
            playerhp = maxhp;
            if(x.size() > 6)
            {
                maxmana = maxmana + 7;
                mana = maxmana;            
                playermeleedmg = playermeleedmg + 1;
            }
            else
            {
            	playermeleedmg = playermeleedmg + 1;
            }
        }
        else if(xp >= 50 && Level == 3)
        {
            System.out.println("Level 4!");
            Level = Level + 1;
            maxhp = maxhp + 20;
            playerhp = maxhp;
            if(x.size() > 6)
            {
                maxmana = maxmana + 7;
                mana = maxmana;            
                playermeleedmg = playermeleedmg + 1;
            }
            else
            {
            	playermeleedmg = playermeleedmg + 1;
            }
        }
        else if(xp >= 25 && Level == 2)
        {
            System.out.println("Level 3!");
            Level = Level + 1;
            maxhp = maxhp + 10;
            playerhp = maxhp;
            if(x.size() > 6)
            {
                maxmana = maxmana + 7;
                mana = maxmana;            
                playermeleedmg = playermeleedmg + 1;
            }
            else
            {
            	playermeleedmg = playermeleedmg + 1;
            }
        }
        else if(xp >= 10 && Level == 1)
        {
            System.out.println("Level 2!");
            Level = Level + 1;
            maxhp = maxhp + 5;
            playerhp = maxhp;
            if(x.size() > 6)
            {
                maxmana = maxmana + 7;
                mana = maxmana;            
                playermeleedmg = playermeleedmg + 1;
            }
            else
            {
            	playermeleedmg = playermeleedmg + 1;
            }
        }//increments player level and adds to stats with xp
        x.set(0, maxhp);
        x.set(1, playerhp);
        if(x.size() == 7)
        {
        	x.set(2, maxmana);
        	x.set(3, mana);
        	x.set(4, playermeleedmg);
        }
        else
        {
        	x.set(2, playermeleedmg);
        }
        x.set((x.size()-2), xp);
        x.set((x.size()-1), Level);
        return x;
    }
}
