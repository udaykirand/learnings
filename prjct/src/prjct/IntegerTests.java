package prjct;

import java.util.Scanner;

public class IntegerTests {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tcCnt = sc.nextInt();
		while (tcCnt > 0) {
			try {
				long ip = sc.nextLong();
				System.out.println(ip + " can be fitted in:");
				if (ip >= -128 && ip <= 127) {
					System.out.println("* byte");
					System.out.println("* short");
					System.out.println("* int");
					System.out.println("* long");
				} else if (ip >= -32768 && ip <= 32767) {
					System.out.println("* short");
					System.out.println("* int");
					System.out.println("* long");
				} else if (ip >= -2147483648 && ip <= 2147483647) {
					System.out.println("* int");
					System.out.println("* long");
				} else if (ip >= -9223372036854775808l
						&& ip <= 9223372036854775807l) {
					System.out.println("* long");
				}
				tcCnt--;
			} catch (Exception e) {
				System.out.println(sc.next() + " can't be fitted anywhere.");
			}
		}
		sc.close();

	}

}
