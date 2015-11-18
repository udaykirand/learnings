package prjct;

import java.util.Scanner;

public class FunnyString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		while (T-- > 0) {
			String s = sc.next();
			int start = 0;
			int end = s.length() - 1;
			int flag = 0;
			while (start < (s.length() - 2)) {
				int first = (int) s.charAt(start);
				int last = (int) s.charAt(end);
				int start2 = (int) s.charAt(start + 1);
				int end2 = (int) s.charAt(end - 1);
				if (Math.abs(first - start2) != Math.abs(last - end2))
					flag = 1;

				start++;
				end--;
			}
			
			if(flag==0)
		        System.out.println("Funny");
		    else
		        System.out.println("Not Funny");
		}

	}
}
