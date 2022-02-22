package Strings;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacter {

	public static void main(String[] args) {
		// String s = "leetcode"; //output - 0
		String s = "loveleetcode"; // output - 2
		int index = firstUniqChar(s);
		System.out.println("INDEX : " + index);
	}

	// FIrst Approach
	public static int firstUniqChar(String s) {

		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!map.containsKey(ch)) {
				map.put(ch, i);
			} else {
				map.put(ch, -1);
			}
		}

		System.out.println(map.toString());

		int minIndex = Integer.MAX_VALUE;
		for (char c : map.keySet()) {

			if (map.get(c) > -1 && map.get(c) < minIndex) {
				minIndex = map.get(c);
			}
		}

		return minIndex = minIndex < Integer.MAX_VALUE ? minIndex : -1;

	}
	
	
	//Second Approach
	 public int firstUniqChar2(String s) {
	     
	        int arr[] = new int[26];
	        
	        for (int i = 0 ; i < s.length() ; i++) {
	            char ch = s.charAt(i);
	            int index = ch - 'a';
	            int count = arr[index];
	            if (count > 0) {
	                arr[index] = count + 1;
	            } else {
	               arr[index] = 1; 
	            }
	        }
	        
	        int j = 0;
	        while (j < s.length()) {
	            char ch = s.charAt(j);
	            int index = ch - 'a';
	            if (arr[index] == 1) {
	                return j;
	            }
	            j++;
	        }
	        
	        return -1;
	        
	    }
}
