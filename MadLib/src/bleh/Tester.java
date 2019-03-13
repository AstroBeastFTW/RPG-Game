package bleh;
import java.io.*;
import java.util.*;
public class Tester
{
	public static void main(String args[]) throws InterruptedException
	{
		String noun = nounRequest();
		String nounP = nounPRequest();
		String nounTwo = nounRequest();
		String place = placeRequest();
		String adjective = adjRequest();
		String nounThree = nounRequest();
		System.out.println("");
		System.out.println("----------------------------");
		Thread.sleep(1000);
		System.out.print("Loading");
		Thread.sleep(1000);
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print(".\n");
		Thread.sleep(1000);
		System.out.println("----------------------------");
		System.out.println("\n\n\n");
		Thread.sleep(1000);
		System.out.println("Be kind to your " + noun + "-footed " + nounP + "\r\n" + "For a duck may be somebody`s " 
							+ nounTwo + ",\r\n" + "Be kind to your " + nounP + " in " + place + "\r\n" + "Where the weather is always " 
							+ adjective + ".\r\n" + "You may think that this is the " + nounThree + ",\r\n" + "Well it is.");
	}
	private static String nounRequest()
	{
		Scanner noun = new Scanner(System.in);
		System.out.println("Can you give me a noun?");
		String bleh = noun.nextLine();
		return bleh;
	}
	private static String nounPRequest()
	{
		Scanner nounP = new Scanner(System.in);
		System.out.println("Can you give me a noun (plural)?");
		String bleh = nounP.nextLine();
		return bleh;
	}
	private static String placeRequest()
	{
		Scanner place = new Scanner(System.in);
		System.out.println("Can you give me a place?");
		String bleh = place.nextLine();
		return bleh;
	}
	private static String adjRequest()
	{
		Scanner adj = new Scanner(System.in);
		System.out.println("Can you give me an adjective?");
		String bleh = adj.nextLine();
		return bleh;
	}
}
