/**
 * Scott Kennedy
 * An abstract class that implements the Charater interface 
 */
package gmit;

public abstract class AbstractCharacter implements Charater
{
	private String name;

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}	
}
