package gmit;

public class Weapon 
{
	private String name;
	private int value;
	private Location location;
	

	public String getName() 
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}	
	
	public void use()
	{
		System.out.println("They have " + name);
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
		this.location = location;
	}

	
}
