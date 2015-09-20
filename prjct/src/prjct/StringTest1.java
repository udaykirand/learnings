package prjct;

import java.util.Scanner;

public class StringTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		System.out.println((A + B).length());
		System.out.println(A.compareTo(B) > 0 ? "Yes" : "No");
		char[] arrA = A.toCharArray();
		arrA[0] = Character.toUpperCase(arrA[0]);
		char[] arrB = B.toCharArray();
		arrB[0] = Character.toUpperCase(arrB[0]);
		System.out.println(new String(arrA) + " " + new String(arrB));
		sc.close();
	}

}
