/**
 * Scott Kennedy
 * Main Class
 */
package gmit;

import java.io.*;
import java.util.*;

import javax.xml.parsers.*;

import net.sourceforge.jFuzzyLogic.FIS;

import org.xml.sax.SAXException;

public class Main
{
	private static Location location = new Location();
	
	public static Location getInstance()
	{
		return location;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
	    try 
	    {
	        SAXParser saxParser = saxParserFactory.newSAXParser();
	        Parser handler = new Parser();
	        saxParser.parse(new File("game.xml"), handler);
	       	            
	    } catch (ParserConfigurationException | SAXException | IOException e)
	    {
	        e.printStackTrace();
	    }
	    
	    // Load from 'FCL' file
        String fileName = "fcl/tipper.fcl";
        FIS fis = FIS.load(fileName,true);

        // Error while loading?
        if( fis == null ) 
        { 
            System.err.println("Can't load file: '" + fileName + "'");
            return;
        }	    
	    
	    //System Object	    
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome Adventurer!!! \n What is your name?");
		String name = input.nextLine();
		System.out.println("Welcome " + name);
		System.out.println("----------------------------------------------------------------------");
		System.out.println("The year is  1187 and the crusader army of the Kingdom of Jerusalem \n" 
							+ "has been all but destroyed by Saladin at the Horns of Hattin.\n"
							+ "As a Templar knight, having survived the battle, you have been entrusted with going to Jerusalem, \n"
						    + "taking the Holy Grail from the Temple Mount and brining it safely to Cyprus, via the port of Antioch.\n"
							+ "As a consequence of the defeat at Hattin, a large Saracen army is marching on Jerusalem and the Kingdom is now swarming\n"
						    + "with Saracen invaders. Danger lurks everywhere, among the common folk are thieves and brigands who wish to assail or rob you or worse...!");
		System.out.println("----------------------------------------------------------------------");
		
		JourneyMap jm = new JourneyMap();
		
		String urInput = input.nextLine();		
		System.out.println("> User's Input: " + urInput);
		
		
	}
}
