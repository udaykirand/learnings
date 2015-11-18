package prjct;

import java.util.Arrays;
import java.util.Scanner;

public class Prom {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		while(N-- > 0) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int[] bht = new int[m];
			int[] ght = new int[n];
			for(int i = 0; i < m; i++) 
				bht[i] = sc.nextInt();
			
			for(int i = 0; i < n; i++)
				ght[i] = sc.nextInt();
			
			Arrays.sort(bht);
			Arrays.sort(ght);
			int tmp = 0;
			for(int i = 0; i < m; i++) {
				if(tmp == n)
					break;
				if(ght[i] < bht[tmp]){
					tmp++;
					continue;
				}
					
			}
			
			if(tmp == n)
				System.out.println("YES");
			else
				System.out.println("NO");
		}

	}

}
