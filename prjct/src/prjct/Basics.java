package prjct;

public class Basics {
	
	public void someMethod() {}
	
	public class Inner {
		Inner() {
			System.out.println("Inner");
		}
	}
	
	public static void main(String[] s) {
		Basics b = new Basics();
		Basics.Inner i = b.new Inner();
	}
}


