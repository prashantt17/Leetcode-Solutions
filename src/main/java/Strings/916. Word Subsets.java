/*

You are given two string arrays words1 and words2.

A string b is a subset of string a if every letter in b occurs in a including multiplicity.

For example, "wrr" is a subset of "warrior" but is not a subset of "world".
A string a from words1 is universal if for every string b in words2, b is a subset of a.

Return an array of all the universal strings in words1. You may return the answer in any order.

Example 1:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
Output: ["facebook","google","leetcode"]
Example 2:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
Output: ["apple","google","leetcode"]

*/

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        List<String> resultList = new ArrayList<>();
		int[] wordArrCount = new int[26];

		for (String word2 : words2) {
			int[] word2ArrCount = getWordsCount(word2);
			for (int i = 0; i < 26; i++)
				wordArrCount[i] = Math.max(wordArrCount[i], word2ArrCount[i]);
		}

		for (String word1 : words1) {
			int[] word1ArrCount = getWordsCount(word1);
			boolean flag = true;

			// To CHECK THAT WORD2 HAS LESS CHARACTERS THAN WORD1 FOR BEING SUBSET
			for (int j = 0; j < 26; j++) {
				if (wordArrCount[j] > word1ArrCount[j]) {
					flag = false;
					break;
				}
			}

			if (flag)
				resultList.add(word1);
		}
		return resultList;
	}

	/**
	 * METHOD TO CREATE THE ARRAY WITH EACH CHARACTER COUNT OF INPUT WORD
	 * 
	 * @param word
	 * @return
	 */
	private static int[] getWordsCount(String word) {
		int[] wordCountArr = new int[26];

		for (char c : word.toCharArray())
			wordCountArr[c - 97] += 1;

		return wordCountArr;
	}
}

