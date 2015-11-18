package prjct;

import java.util.Scanner;

public class OneDArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		int cnt = 0;
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum = sum + arr[j];
				if (sum < 0)
					cnt++;
			}
		}
		System.out.println(cnt);

	}

}
