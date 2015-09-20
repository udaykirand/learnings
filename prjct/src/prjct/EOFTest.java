package prjct;

import java.util.Scanner;

public class EOFTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = 1;
		while(sc.hasNext()) {
			String ip = sc.nextLine();
			System.out.println(i++ + " "+ip);
		}

	}
}
