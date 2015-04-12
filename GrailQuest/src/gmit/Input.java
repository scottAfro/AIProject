/**
 * Scott Kennedy
 * Class to handle the users input of the text based game
 */
package gmit;

import java.util.Scanner;

public class Input
{
	public static String getInput()
	{
		System.out.println("User's Input: ");
		Scanner in = new Scanner(System.in);
		String urInput = in.nextLine();
		urInput.toLowerCase();
		return urInput;
	}
}
