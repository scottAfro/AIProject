package gmit;

import java.util.*;

public class Player implements Attackable
{
	private String name;
	private String description;
	private int maxHitDamage;
	private int hitDamage;
	private int numPotions;
	private int minDamage;
	private int maxDamage;
	private Random random = new Random();
	
	public Player(String name, String description, int maxHitDamage, int hitDamage, int numPotions, int minDamage, int maxDamage)
	{
		this.name = name;
		this.description = description;
		this.maxHitDamage = maxHitDamage;
		this.hitDamage = hitDamage;
		this.numPotions = numPotions;
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;		
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

	public int getMaxHitDamage()
	{
		return maxHitDamage;
	}
	public void setMaxHitDamage(int maxHitDamage) 
	{
		this.maxHitDamage = maxHitDamage;
	}

	public int getHitDamage() 
	{
		return hitDamage;
	}
	public void setHitDamage(int hitDamage)
	{
		this.hitDamage = hitDamage;
	}

	public int getNumPotions() 
	{
		return numPotions;
	}
	public void setNumPotions(int numPotions)
	{
		this.numPotions = numPotions;
	}

	public int getMinDamage() 
	{
		return minDamage;
	}
	public void setMinDamage(int minDamage)
	{
		this.minDamage = minDamage;
	}

	public int getMaxDamage()
	{
		return maxDamage;
	}
	public void setMaxDamage(int maxDamage) 
	{
		this.maxDamage = maxDamage;
	}
	
	public boolean isAlive()
	{
		return hitDamage > 0;
	}
	
	public String getStatus()
	{
		return "Players HP: " + hitDamage;
	}	
	
	
	@Override
	public String toString() 
	{
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int attack() 
	{		
		return random.nextInt(maxDamage - minDamage + 1) + minDamage;
	}
	
	public void defend(Saracen saracen)
	{
		int attactMax = saracen.attack();
		hitDamage = (hitDamage > attactMax) ? hitDamage - attactMax : 0;
		System.out.println(name + " is attacked!!!");
		System.out.println("The attack damage was " + attactMax);
		System.out.println(name + " health is " + getStatus());		
		System.out.println("----------------------------------------");
	
		if(hitDamage == 0)
		{
			System.out.println(" " + name + " is dead!!!");
		}
	}
	
	public void heal()
	{
		if(numPotions > 0)
		{
			hitDamage = Math.min(maxHitDamage, hitDamage + 20);
			System.out.println(name + " drinks the healing potion");
			System.out.println(name + " health is " + getStatus());
			System.out.println(--numPotions + " potions you have left!");
			System.out.println("----------------------------------------");
		}else{
			System.out.println(" You've no more Potions");
		}
	}
		
}