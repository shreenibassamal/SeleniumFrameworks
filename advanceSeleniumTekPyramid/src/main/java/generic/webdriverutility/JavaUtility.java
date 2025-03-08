package generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber(int number) {
		Random rn = new Random();
		
		int randomNumber = rn.nextInt(number);
		return randomNumber;
	}
	
	public String getSystemDateYYYYMMDD() {
		
		Date dateObj = new Date(); //The class Date represents a specific instant in time, with millisecond precision.
		//only Date should be upper case.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //SimpleDateFormat is a concrete class for formatting andparsing dates in a locale-sensitive manner. It allows for formatting(date → text), parsing (text → date), and normalization. 
	
		String date = sdf.format(dateObj); //Formats a Date into a date-time string.
		System.out.println(date);
		
		return date;
		
	}
	
    public String getRequiredDateYYYYMMDD(int days) {
    	Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateObj);
		
		//The Calendar class is an abstract class that provides methods for converting between a specific instant in time and a set of calendar fields such as YEAR,
		//MONTH, DAY_OF_MONTH, HOUR, and so on, and for manipulating the calendar fields, such as getting the date of the next week. 
		//An instant in time can be represented by a millisecond value that isan offset from the Epoch, January 1, 197000:00:00.000 GMT (Gregorian).
		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days); //Gets the calendar associated with this date/time formatter
	
		String reqDate = sdf.format(cal.getTime());
		
		System.out.println(reqDate);
		
		return reqDate;
    }
	

}
