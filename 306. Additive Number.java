class Solution {
	public boolean isAdditiveNumber(String num) {
		List<String> res = new ArrayList<>();
		return dfs(num, res, 0);
	}

	private boolean dfs(String num, List<String> res, int start) {
		if (start == num.length()) return res.size() > 2;

		int len = num.length() / 2;
		for (int end = start + 1; end<= Math.min(num.length(), start + len); end++) {
			String curNum = "0";
			boolean skip = num.charAt(start) == '0';
			if (!skip) curNum = num.substring(start, end);

			if (res.size()<2 || isValid(res.get(res.size() - 1), res.get(res.size() - 2), curNum)) {
				res.add(curNum);
				if (dfs(num, res, end)) return true;
				res.remove(res.size() - 1);
				if (skip) return false;
			}

		}

		return false;
	}

	private boolean isValid(String num1, String num2, String target) {
		int s1 = num1.length() - 1;
		int s2 = num2.length() - 1;
		int carry = 0;
		StringBuilder res = new StringBuilder();
		while (s1 > -1 || s2 > -1) {
			int a = s1 > -1 ? num1.charAt(s1--) - '0' : 0;
			int b = s2 > -1 ? num2.charAt(s2--) - '0' : 0;
			int sum = carry + a + b;
			res.insert(0, sum % 10);
			carry = sum / 10;
		}
		if (carry == 1) res.insert(0, 1);
		return res.toString().equals(target);
	}
}
