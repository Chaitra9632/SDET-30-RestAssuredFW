package commonLibraries;

import java.util.Random;

/**
 * This class contains generic method related to java
 * @author Chaitra M
 *
 */
public class JavaLibrary {
	
	/**
	 * This method will generate a random numbner for every execution
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran = new Random();
		return ran.nextInt(1000);
	}

}
