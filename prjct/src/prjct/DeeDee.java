package prjct;

import java.util.Scanner;

public class DeeDee {
	static final int A = 6;
	static final int B = 8;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tcCnt = sc.nextInt();
		while (tcCnt-- > 0) {
			int count = Integer.MAX_VALUE, i = sc.nextInt();
			for (int j = 0; j <= i / 8; j++)
				for (int k = 0; k <= i / 6; k++)
					if ((j * 8) + (k * 6) == i)
						if (count > j + k)
							count = j + k;
			System.out.println(count == Integer.MAX_VALUE ? "-1" : count);
		}

	}

}
