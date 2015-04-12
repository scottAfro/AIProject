/**
 * Scott Kennedy
 */
package gmit;

public class Exit 
{
	private Directions directions;
	private Location locat;	
	
	public Exit(Directions directions, Location location)
	{
		super();
		this.directions = directions;
		this.locat = location;
	}
	
	public Directions getDirections()
	{
		return directions;
	}
	
	public void setDirections(Directions directions) 
	{
		this.directions = directions;
	}
	
	public Location getLocation() 
	{
		return locat;
	}
	
	public void setLocation(Location location)
	{
		this.locat = location;
	}
	
	
}
