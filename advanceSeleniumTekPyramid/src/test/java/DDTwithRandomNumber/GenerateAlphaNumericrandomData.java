package DDTwithRandomNumber;

public class GenerateAlphaNumericrandomData {

	public static void main(String[] args) {
		int n = 10;
		//Choose a character random from this string
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		
		//create StringBuilder size of alphanumericString
		StringBuilder sb = new StringBuilder(n);
		
		for(int i = 0;i<n;i++) {
		//generate a random number between 0 to Alphanumeric variable length
		int index =(int)(AlphaNumericString.length()*Math.random());
		
		//add Character one by one in end of sb
		sb.append(AlphaNumericString.charAt(index));
			
		}
		System.out.println(sb);

	}

}
