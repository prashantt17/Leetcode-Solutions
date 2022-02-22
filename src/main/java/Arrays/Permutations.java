package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> output = new ArrayList<Integer>();


		getCombinations( nums, output, result);
		System.out.println(Arrays.asList(result));

	}

	public static void getCombinations(int[] nums, List<Integer> output,
			List<List<Integer>> result) {

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