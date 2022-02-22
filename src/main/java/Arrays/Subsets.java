package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {

		int nums[] = { 1, 2, 3 };
		List<List<Integer>> list = subsets(nums);

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}

	}

	public static List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> outputList = new ArrayList<Integer>();
		int index = 0;

		solve(nums, index, outputList, list);
		return list;
	}


	
	private static void solve(int[] nums, int index, List<Integer> outputList, List<List<Integer>> list) {

		// Base Statement
		if (index >= nums.length) {
			list.add(new ArrayList<Integer>(outputList));
			return;
		}

		// Exclude numbers
		solve(nums, index + 1, outputList, list);

		// Include numbers
		outputList.add(nums[index]);
		solve(nums, index + 1, outputList, list);
		
		outputList.remove(outputList.size()-1);
		
	}

}
