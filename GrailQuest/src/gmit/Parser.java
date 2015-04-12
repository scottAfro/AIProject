package gmit;

//These are all standard Java libraries
import java.io.*;
import java.util.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import javax.xml.parsers.*;

/* 
 * SAX (Simple API for XML) provides a mechanism for serially parsing an XML document. SAX parses a document line-by-line and invokes call-back methods
 * like startDocument(), startElement() and characters() to respond to different events in the input stream. By overriding the methods and registering
 * ourselves as a handler, we can process the XML data in these call-back methods. Note that we cannot move backward in the stream - events are fired and
 * it's up to us to respond accordingly. As a serial access mechanism, SAX has a very low memory overhead and has long been the de facto standard for XML
 * parsing.
 * 
 */
public class Parser extends DefaultHandler
{
	private static final String GAME_FILE = "game.xml";
	
	/**
	 * List to hold Exit Objects
	 */
	private List<Exit> exitList = null;
	private Exit ext = null;
	
	/**
	 * List to hold Location objects
	 */
	private List<Location> locationList = null;
	private Location locat;
	private Location des;
	
	//You should have a boolean switch for each XML element, but not attribute
	boolean location = false;
	boolean description = false;
	boolean exit = false;
	boolean item = false;	
	boolean gameCharacter = false;
	boolean searchAlgorithm = false;	

	//Read in the XML file game.xml and use the current object as the SAX event handler
	public void parse() throws ParserConfigurationException, SAXException, IOException
	{
		XMLReader xmlReader = null;
		SAXParserFactory spfactory = SAXParserFactory.newInstance();
		spfactory.setValidating(false);
		SAXParser saxParser = spfactory.newSAXParser();
		xmlReader = saxParser.getXMLReader();
		xmlReader.setContentHandler(this);
		InputSource source = new InputSource(GAME_FILE);
		xmlReader.parse(source);
		xmlReader.setErrorHandler(this);
	}
	
	//Called by SAX when it reaches the starting root element <game-graph>
	public void startDocument() throws SAXException 
	{
		System.out.println("At start of document...");
	}
	
	//Called by SAX when it reaches the closing root element </game-graph>
	public void endDocument()
	{
		System.out.println("At end of document...");
	}
	
	/*
	 * Use the characters() method to extract the PCDATA contained by an XML element, e.g. the text You are in hot dreary desert, with sand dunes and ......
	 * contained by the element <description> in the sample XML files. Read attribute data in startElement(). See the Location example below.
	 */
	public void characters(char[] ch,int start, int length) throws SAXException
	{
		if (location)
		{
			
		}else if (description)
		{
			des.setDescription(new String(ch, start, length));	
			description = false;
		}else if (exit)
		{
		
		}else if (item)
		{
			
		}else if (gameCharacter)
		{	
		
		}else if (searchAlgorithm)
		{
			
		}
	}	
	
	
	/*
	 * 	This call-back method in executed by SAX when a new starting element is encountered in the XML document. The PCDATA (parseable character data), i.e.
		the data contained between the opening and closing XML element (e.g. <description>) is not read here, but in the characters() method above. Unless you
		are reading attribute values, startElement() is only used to switch on the boolean instance variables for each element.
	*/
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException 
	{
		if (qName.equals("location"))
		{
			location = true;
			
			System.out.println("Found a location...");
			try 
			{
				//Read in the values for the attributes of the element <location>
				int locationID = Integer.parseInt(atts.getValue("id"));
				String locationName = atts.getValue("name");
				
				//Generate a new instance of Location on-the-fly using reflection. The statement Class.forName("gmit.Location").newInstance(); invokes the 
				//Java Class Loader and the calls the null (default) constructor of Location.
				Location loc = (Location) Class.forName("gmit.Location").newInstance();
				//Now configure the Location object with an ID, Name, Description etc...
				loc.setId(locationID); 
				loc.setName(locationName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if (qName.equals("description"))
		{
			description = true;
			System.out.println("Found a description...");		
			
		}else if (qName.equals("exit"))
		{
			exit = true;
			System.out.println("Found an exit...");
			
			try 
			{
				//Read in the values for the attributes of the element <exit>
				//Location locationTitle =  
				//Directions dir = atts.getValue("direction");
				
				//Generate a new instance of Exit on-the-fly using reflection. The statement Class.forName("gmit.Exit").newInstance(); invokes the 
				//Java Class Loader and the calls the null (default) constructor of Location.
				Exit ex = (Exit) Class.forName("gmit.Exit").newInstance();
				//ex.setLocation(locationTitle);
				//ex.setDirections(dir);
				
				//Now configure the exit object with an title, direction
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}else if (qName.equals("item"))
		{
			item = true;
			System.out.println("Found an item. You should tie this to the last game-character you encountered if the boolean gameCharacter flag is true...");
			
			try 
			{
				//Read in the values for the attributes of the element <item>				
				String itemName = atts.getValue("name");
				int itemValue = Integer.parseInt(atts.getValue("value"));
				
				
				//Generate a new instance of Location on-the-fly using reflection. The statement Class.forName("gmit.Location").newInstance(); invokes the 
				//Java Class Loader and the calls the null (default) constructor of Location.
				Item it = (Item) Class.forName("gmit.Item").newInstance();
				Location loc = (Location) Class.forName("gmit.Location").newInstance();
				
				//Now configure the Location object with an ID, Name, Description etc...
				it.setName(itemName); 				
				it.setValue(itemValue);
				//loc.setId(locationID);
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}else if (qName.equals("game-character"))
		{
			gameCharacter = true;
			System.out.println("Found a game character...");
			
			try 
			{
				//Read in the values for the attributes of the element <description>
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}else if (qName.equals("search-algorithm"))
		{
			searchAlgorithm = true;
			System.out.println("Found a search algo. You should tie this to the last game-character you encountered if the boolean gameCharacter flag is true...");
			try 
			{
				//Read in the values for the attributes of the element <description>
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}	
	
	/*
	 * This method is called when the SAX parser encounters a closing element, e.g. </location> and is used to switch off any boolean flags
	 * currently set to true.
	 */
	public void endElement(String namespaceURI,String localName, String qName) throws SAXException
	{
		if (qName.equals("location"))
		{
			location = false;
			System.out.println("End of location...\n");
		}else if (qName.equals("description"))
		{
			description = false;
		}else if (qName.equals("exit"))
		{
			exit = false;
		}else if (qName.equals("item")){
			item = false;
			System.out.println("End of item...\n");
		}else if (qName.equals("game-character"))
		{
			gameCharacter = false;
			System.out.println("End of game-character...\n");
		}else if (qName.equals("search-algorithm"))
		{
			searchAlgorithm = false;
		}
	}
	
	//Hopefully, you won't have to worry about this...
   	public void error(SAXParseException e) 
   	{
   		System.out.println("[ERROR] " + "Yikes....:" + e.getMessage());
   		System.exit(0);
   	}

   	//Or this either...
   	public void warning(SAXParseException e)
   	{
   		System.out.println("[ERROR] " + "Warning....:" + e.getMessage());
   	}

   	//You definitely do not want this method executing... 
   	public void fatalError(SAXParseException e)
   	{
   		System.out.println("[ERROR] " + "Fatal....:" + e.getMessage());
   		System.exit(0);
   	}
	
   	
   	//Start the ball rolling...
   	public static void main(String[] args) 
   	{
		try 
		{
			Parser p = new Parser();
			p.parse();
			
		} catch (ParserConfigurationException e)
		{
			e.printStackTrace();
		} catch (SAXException e) 
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}