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
	private String exit;
	private List<AbstractCharacter> observer = new ArrayList<AbstractCharacter>(); 
	private List<Item> objeccts = new ArrayList<Item>();
	private List<Exit> exits = new ArrayList<Exit>();
	
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
	
	public String getExit()
	{
		return exit;
	}
	public void setExit(String exit) 
	{
		this.exit = exit;
	}
	@Override
	public String toString() 
	{
		return "Location Infromation: \n"
				+ "Location Id: " + this.getId();
	}	
	
	
	
}
