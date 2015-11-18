package prjct;

import java.util.Scanner;


public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int h = 1;
        while(T-- > 0) {
            int N = sc.nextInt();

            for(int i = 1; i<= N; i++){
                if(i % 2 == 1)
                    h = h * 2;
                else
                    h++;
            }
            System.out.println(h);
        }
    }
}
