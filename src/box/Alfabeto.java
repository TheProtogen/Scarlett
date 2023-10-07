package box;

import java.util.HashMap;

public class Alfabeto {

	public static void main(String[] args) {
		char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		
		for (int i = 0; i < alphabet.length;i++) {
			System.out.println(alphabet[i]);
		}

		
		HashMap<Character, String> hashMap = new HashMap<Character, String>();
		for (int i = 0; i < alphabet.length; i++) {
			hashMap.put(alphabet[i], null);
		}
		
		System.out.println(hashMap);
		
	}

}
