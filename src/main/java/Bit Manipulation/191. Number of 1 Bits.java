public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
    	while(n!=0) {
    		result = result + (n & 1);
    		n = n>>>1;
    	}
    	return result;
    }
}
