package gmit;

import java.util.*;

public class Saracen extends AbstractCharacter implements Attackable
{
	private float health = 100.00f;
	private int hitPoints;
	private Item itValue;
	private int value;
	private final static Random random = new Random();		
	
	public Saracen(float health, int hitPoints, Item itValue) 
	{		
		this.health = health;
		this.hitPoints = hitPoints;
		this.itValue = itValue;
	}

	public float getHealth()
	{
		return health;
	}
	public void setHealth(float health)
	{
		this.health = health;
	}

	public int getHitPoints() 
	{
		return hitPoints;
	}
	public void setHitPoints(int hitPoints) 
	{
		this.hitPoints = hitPoints;
	}

	public Item getItValue()
	{
		return itValue;
	}	
	public void setItValue(Item itValue) 
	{		
		itValue.setValue(value);
	}
	
	public String getStatus()
	{
		return this.getName() + " : " + hitPoints;
	}
	
	@Override
	public int attack() 
	{
		// TODO Auto-generated method stub				
		System.out.println(this.getName() + " attacks you");
		System.out.println();
		return 1;
	}
	
	public boolean isAlive()
	{
		return hitPoints > 0;
	}

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
