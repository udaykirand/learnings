package prjct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StringTest2 {
	public static void main(String[] s) {
		Scanner sc = new Scanner(System.in);
		String ip = sc.next();
		int length = sc.nextInt();
		List<String> subStrings = new ArrayList<String>();
		for (int i = 0; i < ip.length() - 1; i++) {
			if((i+length)<=ip.length()){
				subStrings.add(ip.substring(i, i+length));

	        }
			
		}
		Collections.sort(subStrings);
		System.out.println(subStrings.get(0));
		System.out.println(subStrings.get(subStrings.size() - 1));
	}
}
