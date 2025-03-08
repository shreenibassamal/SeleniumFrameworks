package miscaThing;

import java.lang.reflect.Method;

public class Names {
 public void namsteaID() {
	 
		 
	 }

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		String className = Names.class.getName();
		System.out.println(className);
		
		
		Names n = new Names();
		Method mname = n.getClass().getMethod("namsteaID");
		String aname = mname.getName();
		System.out.println(aname);
	
	}
	

}
