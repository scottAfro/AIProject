/**
 * Scott Kennedy
 * Main Class
 */
package gmit;

import java.io.*;
import java.util.*;

import javax.xml.parsers.*;

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
	        
	        //Get Employees list
	        //List<Employee> empList = handler.getEmpList();
	        
	        //print employee information
	       /* for(Employee emp : empList)
	        {
	        	System.out.println(emp);
	        }*/
	            
	    } catch (ParserConfigurationException | SAXException | IOException e)
	    {
	        e.printStackTrace();
	    }
	    
	    
	    //System Object	    
		Scanner in = new Scanner(System.in);
		String urInput = in.nextLine();
		urInput.toLowerCase(); 
		System.out.println("> User's Input: " + urInput);
		
		
	}
}
