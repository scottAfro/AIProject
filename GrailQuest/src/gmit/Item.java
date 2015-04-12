package gmit;

public class Item 
{
	private String name;
	private int value;
	private Location location;	
	private int locationID;

	public String getName() 
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}		

	public int getValue()
	{
		return value;
	}

	public void setValue(int value) 
	{
		this.value = value;
	}

	public Location getLocation() 
	{
		return location;
	}

	public void setLocation(Location location)
	{
		location.setId(locationID);
	}
	
	public void use()
	{
		System.out.println("They have " + name);
	}

}
