package prjct;

public class Sample {
	public static void main(String[] s) {
		System.out.println(decrypt("kjh"));
	}

	private static String decrypt(String toDecrypt) {
		//int key = toDecrypt.charAt(0) - 'a';
		int key = 'a'-toDecrypt.charAt(0);
		System.out.println(key);
		char[] encrypted = toDecrypt.toCharArray();
		for (int i = 0; i < encrypted.length; i++) {
			if((char) (encrypted[i] + key) > 'z')
				encrypted[i] = (char) (encrypted[i] + key-25);
			else if((char) (encrypted[i] + key) < 'a')
				encrypted[i] = 
			encrypted[i] = (char) (encrypted[i] + key) > 'z' ? (char) (encrypted[i] + key-25) : (char) (encrypted[i] + key);
		}
		return new String(encrypted);
	}
}
