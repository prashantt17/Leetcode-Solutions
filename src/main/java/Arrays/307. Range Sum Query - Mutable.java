/*
Given an integer array nums, handle multiple queries of the following types:

Update the value of an element in nums.
Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
void update(int index, int val) Updates the value of nums[index] to be val.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 

Example 1:

Input
["NumArray", "sumRange", "update", "sumRange"]
[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
Output
[null, 9, null, 8]

Explanation
NumArray numArray = new NumArray([1, 3, 5]);
numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
numArray.update(1, 2);   // nums = [1, 2, 5]
numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8

*/

class NumArray {

    static class BinaryIndexedTree {
    int[] nums;
    int[] BIT;
    int n;

    public BinaryIndexedTree(int[] nums) {
      this.nums = nums;
      this.n = nums.length;
      BIT = new int[n + 1];
      for (int i = 0; i < n; i++) {
        init(i, nums[i]);
      }
    }

    void init(int i, int val) {
      i++;
      while (i <= n) {
        BIT[i] += val;
        i += (i & -i);
      }
    }

    void update(int i, int val) {
      int diff = val - nums[i];
      nums[i] = val;
      init(i, diff);
    }

    int getSum(int i) {
      i++;
      int ret = 0;
      while (i > 0) {
        ret += BIT[i];
        i -= (i & -i);
      }
      return ret;
    }
  }

  BinaryIndexedTree binaryIndexedTree;

  public NumArray(int[] nums) {
    binaryIndexedTree = new BinaryIndexedTree(nums);
  }

  public void update(int index, int val) {
    binaryIndexedTree.update(index, val);
  }

  public int sumRange(int left, int right) {
    return binaryIndexedTree.getSum(right) - binaryIndexedTree.getSum(left - 1);
  }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
