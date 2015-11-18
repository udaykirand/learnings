package prjct;

import java.util.Scanner;

public class OneDArr2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			boolean flag = false;
			for (int i = 0; i < n; i++) {
				if (arr[i] == 0 && i + m > n){
					flag = true;
					break;
				}
			}
			if(flag)
				System.out.println("YES");
			else
				System.out.println("NO");
		}

	}

}
