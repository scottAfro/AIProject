/**
 * Scott Kennedy
 * Interface class to set all the characters in the game
 */
package gmit;

/**The Runnable interface is implemented by any class whose instances are intended to be executed by a thread. **/
public interface Charater extends Runnable 
{
	public abstract String getName();
	
	public abstract void setName(String name);
}
