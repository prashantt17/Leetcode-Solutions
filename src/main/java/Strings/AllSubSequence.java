package Strings;

import java.util.ArrayList;

public class AllSubSequence {

	public static void main(String[] args) {
		String str= "abc";
		ArrayList<String> results = subsequences(str);
		
		for (String result : results) {
			System.out.print(result + " ");
		}
	}
	
	public static ArrayList<String> subsequences(String str) {
        // Write your code here
        ArrayList<String> list = new ArrayList<String>();
        int index = 0;
        String subSeq = "";
        solve(str, index, list , subSeq);
        
        return list;
    }
    
    private static void solve (String str, int index, ArrayList<String> list , String subSeq) {
        
        //Base Condition
        if (index >= str.length()) {
            list.add(subSeq);
            return;
        }
        
        //Exclude condition
        solve (str, index+1, list, subSeq);
        
        //Include condition
        String currentStr = String.valueOf(str.charAt(index));
        subSeq += currentStr; 
        solve (str, index+1, list, subSeq);
        
    }
}
