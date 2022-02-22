/*

Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]

*/

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
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
