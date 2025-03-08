package DDTwithRandomNumber;

import java.util.Random;

public class GenerateRandomNumber {

	public static void main(String[] args) {
		Random rn = new Random();
		int randomInt = rn.nextInt(10);
		
		System.out.println(randomInt);

	}

}
