package prjct;

/* IMPORTANT: class must not be public. */

/*
 * uncomment this if you want to read input.*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

class ChallengeOne {
	public static void main(String args[]) throws Exception {
		/*
		 * Read input from stdin and provide input before running
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String count = br.readLine();
		int N = Integer.parseInt(count);
		System.out.println("--" + N);
		String[] decrypted = new String[N];

		for (int i = 0; i < N; i++) {
			decrypted[i] = decrypt(br.readLine());
		}

		for (int i = 0; i < decrypted.length; i++) {
			System.out.println(decrypted[i]);
		}
	}

	private static String decrypt(String toDecrypt) {
		int key = toDecrypt.charAt(0) - 'a';
		char[] encrypted = toDecrypt.toCharArray();
		for (int i = 0; i < encrypted.length; i++) {
			encrypted[i] = (char) (encrypted[i] + key);
		}
		return new String(encrypted);
	}
}
