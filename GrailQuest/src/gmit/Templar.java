/**
 * Scott Kennedy
 * Class based for the Templar Knight character
 */
package gmit;

public class Templar extends AbstractCharacter
{
	private float health = 100.00f;

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		while(health > 0.00f)
		{
			try 
			{
				Thread.sleep(10000);
			} catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(this.getName() + " has just died...");
	}
	
}
