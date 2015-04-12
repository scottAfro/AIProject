package gmit;

import java.io.*;

public class Battle
{
	public Battle(Player player, Saracen saracen) throws IOException
	{
		  System.out.println("You encounter " + saracen );
	        System.out.println("Battle with " + saracen 
	        		+ " starts (" + player.getStatus() + " / "
	                + saracen.getStatus() + ")");
	        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        while (player.isAlive() && saracen.isAlive()) {
	            System.out.print("Attack (a) or heal (h)? ");
	            String action = in.readLine();
	            if (action.equals("h")) {
	                player.heal();
	            } else {
	            	
	            }
	            if (saracen.isAlive()) {
	                player.defend(saracen);
	            }
	        }
	}
}
