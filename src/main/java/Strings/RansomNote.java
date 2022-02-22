package Strings;

public class RansomNote {

	public static void main(String[] args) {

		//String ransomNote = "a"; String magazine = "b"; // output: false;
		 String ransomNote = "aa" ; String magazine = "aab" ; // output: true;

		boolean result = canConstruct2(ransomNote, magazine);
		System.out.println("RESULT : " + result);
	}

	// Approach - 1
	public static boolean canConstruct(String ransomNote, String magazine) {

		if (ransomNote.length() > magazine.length()) {
			return false;
		}
		int ransomArr[] = new int[26];
		int magazineArr[] = new int[26];

		ransomArr = charArr(ransomNote);
		magazineArr = charArr(magazine);

		for (int j = 0; j < ransomArr.length; j++) {
			if (ransomArr[j] > magazineArr[j]) {
				return false;
			}
		}

		return true;
	}

	private static int[] charArr(String str) {

		int a[] = new int[26];

		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i) - 'a';
			a[index] = a[index] + 1;
		}

		return a;
	}

	// Approach - 2
	public static boolean canConstruct2(String ransomNote, String magazine) {
		int[] arr = new int[26];
		for (int i = 0; i < magazine.length(); i++) {
			arr[magazine.charAt(i) - 'a']++;
		}
		for (int i = 0; i < ransomNote.length(); i++) {
			int num = --arr[ransomNote.charAt(i) - 'a'];
			if (num < 0) {
				return false;
			}
		}
		return true;
	}
}
