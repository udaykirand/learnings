package prjct;

import java.util.Scanner;

public class LoopsTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tcCnt = sc.nextInt();
		while (tcCnt > 0) {
			processInput(sc.nextInt(), sc.nextInt(), sc.nextInt());
			tcCnt--;
		}
		sc.close();

	}

	private static void processInput(int a, int b, int n) {
		int sum = a;
		for (int i = 0; i <= n - 1; i++) {
			sum += (int) pow(2, i) * b;
			System.out.print(sum + " ");
		}
		System.out.println();
	}
	
	static long pow (long a, int b)
	{
	    if ( b == 0)        return 1;
	    if ( b == 1)        return a;
	    if ( b % 2 == 0)    return     pow ( a * a, b/2); //even a=(a^2)^b/2
	    else                return a * pow ( a * a, b/2); //odd  a=a*(a^2)^b/2

	}

}
