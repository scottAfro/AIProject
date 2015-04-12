package gmit;

public class Thief extends AbstractCharacter
{
	private float health = 75.00f;

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
