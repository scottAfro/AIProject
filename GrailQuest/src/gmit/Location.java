/**
 * Scott Kennedy
 * Location class to have the relevant info to read the Xml file
 */
package gmit;

import java.util.*;

public class Location 
{
	private int id;
	private String name;
	private String description;
	private List<AbstractCharacter> observer = new ArrayList<AbstractCharacter>(); 
	private List<Item> objeccts = new ArrayList<Item>();
	private HashMap<Location, Directions> exits = new HashMap<Location, Directions>();
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public String getExitString()
	{
		String returnString = "Exits: ";
		Set<Location> keys = exits.keySet();
		for(Location exits : keys)
		{
			returnString += " " + exits;
		}
		return returnString;
	}
	
	public Directions getExit(Directions dir)
	{
		 return exits.get(dir);
	}
	public void setExit(Location neighbour, Directions dir) 
	{
		exits.put(neighbour, dir);
	}
	
	public void addItem(Item i)
	{
		objeccts.add(i);
	}
	
	public String getItem(int i)
	{
		if(i < objeccts.size())
		{
			return objeccts.get(i).toString();
		}
		else{
			return "item does not exist";
		}
	}
	@Override
	public String toString() 
	{
		return "Location Infromation: \n"
				+ "Location Id: " + this.getId();
	}	
	
	
	
}
