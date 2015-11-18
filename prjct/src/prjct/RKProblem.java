package prjct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RKProblem {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        while(N-- > 0) {
            String ip = br.readLine();
            
            char[] arr = ip.toCharArray();
            int len = ip.length();
            int[] a = new int[len];
            int[] dp = new int[1000003];
            int cnt = 0;
            int x, maxi;
            for(int i = 0; i < len; i++) {
            	if(arr[i] == 'R'){
            		a[i] = -1;
            		cnt++;
            	}
            	else
            		a[i] = 1;
            }
            
            maxi = a[0];
            dp[0] = a[0];
            for(int i = 0; i < len; i++) {
            	dp[i] = Math.max(a[i], a[i]+dp[i-1]);
            	maxi = Math.max(dp[i], maxi);
            }
            
            System.out.println(maxi);
            		
        }

	}

}
