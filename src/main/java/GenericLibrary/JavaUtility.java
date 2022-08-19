package GenericLibrary;

import java.util.Random;
/**
 * This class contains java specific methods
 * @author LAVA KUMAR
 *
 */
public class JavaUtility {
	/**
	 * This method is used for get random numbers
	 * @return
	 */
	public int random() {
		Random r=new Random();
		int num=r.nextInt(2000);
		return num;
	}
}
