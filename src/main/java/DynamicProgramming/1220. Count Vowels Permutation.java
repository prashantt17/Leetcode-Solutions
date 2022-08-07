class Solution {
	private long[][] dp;
	private int mod = (int) 1e9 + 7;

	public int countVowelPermutation(int n) {
		dp = new long[6][n + 1];
		if (n == 1) return 5;

		for (int i = 0; i<5; i++)
			dp[i][0] = 1;

		helper(n, 'z');
		return (int) dp[5][n];
	}

	private long helper(int n, char vowel) {
		long ans = 0;
		if (n == 0) return 1;

		if (vowel == 'z') {
			ans = (ans + helper(n - 1, 'a') + helper(n - 1, 'e') + helper(n - 1, 'i') + helper(n - 1, 'o') + helper(n - 1, 'u')) % mod;
			dp[5][n] = ans;
		} else if (vowel == 'a') {
			if (dp[0][n] != 0) return dp[0][n];
			ans = (ans + helper(n - 1, 'e')) % mod;
			dp[0][n] = ans;
		} else if (vowel == 'e') {
			if (dp[1][n] != 0) return dp[1][n];
			ans = (ans + helper(n - 1, 'a') + helper(n - 1, 'i')) % mod;
			dp[1][n] = ans;
		} else if (vowel == 'i') {
			if (dp[2][n] != 0) return dp[2][n];
			ans = (ans + helper(n - 1, 'a') + helper(n - 1, 'e') + helper(n - 1, 'o') + helper(n - 1, 'u')) % mod;
			dp[2][n] = ans;
		} else if (vowel == 'o') {
			if (dp[3][n] != 0) return dp[3][n];
			ans = (ans + helper(n - 1, 'i') + helper(n - 1, 'u')) % mod;
			dp[3][n] = ans;
		} else {
			if (dp[4][n] != 0) return dp[4][n];
			ans = (ans + helper(n - 1, 'a')) % mod;
			dp[4][n] = ans;
		}

		return ans;
	}
}
