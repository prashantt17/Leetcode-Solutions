/*
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

 

Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Example 2:

Input: n = 2
Output: false
*/

class Solution {
     public boolean isHappy(int n) {
        int sum = 0;
        int m = 0;
        
        Map<Integer, Integer> rec = new HashMap<Integer, Integer>();
        
        while (true) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
            
            if(n == 0) {
                if(rec.containsValue(sum)) {
                     break;
                }
                n = sum;
                rec.put(++m, sum);
                sum = 0;
            }
        }
        
        return sum == 1;
     }
}

