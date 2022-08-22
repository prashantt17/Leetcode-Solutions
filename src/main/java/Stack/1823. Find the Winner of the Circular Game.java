class Solution {
    public int findTheWinner(int n, int k) {
        
    if(n == 1)
        return 1; // If n reaches 1 then return 1 because any value of k when n is 1 would return n.
		
		// For every recursion level, we add k to returned value and then mod it with n, we are using mod as the value can go above n.
        int y = (findTheWinner(n-1, k) + k) % n; // If 0 based indexing was used then we could have directly returned this.

        return (y == 0) ? n : y; // For 1 based indexing if the returned value is 0 then return n otherwise return the original value (y).
    }
}
