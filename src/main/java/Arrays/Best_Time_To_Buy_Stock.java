package Arrays;

import java.util.List;

public class Best_Time_To_Buy_Stock {

	public static void main(String[] args) {

		// TestCase-1 - output= 5
		// int nums[] = { 7,1,5,3,6,4 };

		// TestCase-1 - output= 0
		int nums[] = { 7, 6, 4, 3, 1 };

		int result = maxProfit(nums);

		System.out.println("result : " + result);
	}

	public static int maxProfit(int[] prices) {
		int end = prices.length - 1;
		int diff = 0;

		int i = 0;
		int j = i + 1;

		while (i < end) {
			if (j == prices.length) {
				i++;
				j = i + 1;
				continue;
			}
			int currentDiff = prices[j] - prices[i];
			if (currentDiff > diff) {
				diff = currentDiff;
			} else {
				j++;
			}
		}
		return diff;
	}
}
