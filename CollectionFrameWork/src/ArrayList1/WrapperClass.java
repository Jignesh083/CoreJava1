package ArrayList1;

public class WrapperClass {
	public static void main(String[] args) {
//		Integer i = new Integer(3); //error
		
		Integer i = Integer.valueOf(3);
		System.out.println(i);
		
		Float f = Float.valueOf(4.6f);
		
		System.out.println(f);
	}
}
