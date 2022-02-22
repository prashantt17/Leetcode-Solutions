/*

Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].

You may return the answer in any order.

 

Example 1:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
Example 2:

Input: n = 1, k = 1
Output: [[1]]

*/

class Solution {
  public List < List < Integer >> combine(int n, int k) {
    List < List < Integer >> result = new ArrayList < List < Integer >> ();
    List < Integer > output = new ArrayList < Integer > ();
    getCombinations(1, n, k, output, result);
    return result;
  }

  private void getCombinations(int start, int n, int k, List < Integer > output, List < List < Integer >> result) {
    if (start > n) {
      if (k == output.size()) {
         result.add(new ArrayList < Integer > (output));
      }
    return;
    }

    //Exclude
    getCombinations(start + 1, n, k, output, result);

    //Inlcude
    output.add(start);
    getCombinations(start + 1, n, k, output, result);
    output.remove(output.size() - 1);
  }

}
