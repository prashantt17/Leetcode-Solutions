/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]

*/

class Solution {
	public List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> result = new ArrayList<List<Integer>> ();
		List<Integer> output = new ArrayList<Integer> ();
    
        
		getCombinations(nums, output, result);
		return result;
	}

	private void getCombinations(int[] nums, List<Integer> output, List<List<Integer>> result) {
		
      if (output.size() == nums.length) {
			result.add(new ArrayList<Integer>(output));	
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (output.contains(nums[i])) continue;
				output.add(nums[i]);
				getCombinations( nums, output, result);

				output.remove(output.size() - 1);

			}
		}
        
	}

}

