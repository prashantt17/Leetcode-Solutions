class Solution {
	public String removeDuplicateLetters(String s) {

		int[] freq = new int[26];
		for (int i = 0; i<s.length(); i++) {
			freq[s.charAt(i) - 'a']++;
		}

		Stack<Character> st = new Stack<>();
		boolean[] isVisited = new boolean[26];

		for (int i = 0; i<s.length(); i++) {
			char ch = s.charAt(i);
			freq[ch - 'a']--;
			if (!isVisited[ch - 'a']) {
				isVisited[ch - 'a'] = true;

				while (!st.empty() && st.peek() > ch && freq[st.peek() - 'a'] > 0) {
					isVisited[st.peek() - 'a'] = false;
					st.pop();
				}
				st.push(ch);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!st.isEmpty()) {
			sb.insert(0, st.pop());
		}
		return sb.toString();
	}
}
