package prjct;

import java.util.Scanner;

public class PalindromeTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String revString = "";
		for ( int i = A.length() - 1 ; i >= 0 ; i-- )
			revString = revString + A.charAt(i);
		System.out.println(revString);
		if(revString.equals(A))
			System.out.println("Yes");
		else
			System.out.println("No");
	}

}
