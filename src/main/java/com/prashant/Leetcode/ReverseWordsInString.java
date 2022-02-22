package com.prashant.Leetcode;

import java.util.Arrays;

public class ReverseWordsInString {

	public static void main(String[] args) {

		String s = "God Ding";
		char[] splitArr = s.toCharArray();
		System.out.print(Arrays.toString(splitArr));
		String res = "";
		reverseString(splitArr, res);

	}

	private static void reverseString(char[] s, String res) {
	      
	        
	        int start = 0;
	        int end = s.length -1 ;
	        
	       while (start <= end) {
	           char temp = s[start];
	           s[start] = s[end];
	           s[end] = temp;
	           
	           start++;
	           end--;
	       }
	    }
}
