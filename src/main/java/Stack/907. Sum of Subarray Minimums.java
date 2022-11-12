class Solution {
    int MOD = (int) 1e9 + 7;

    private int getElement(int[] arr, int n, int i) {
        return (i == -1 || i == n) ? Integer.MIN_VALUE : arr[i];
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long ans = 0;
        Deque<Integer> stack = new LinkedList<>();

        for (int i = -1; i <= n; i++) {
            while (!stack.isEmpty() && getElement(arr, n, stack.peek()) > getElement(arr, n, i)) {
                int currIdx = stack.pop();
                int left = stack.peek(), right = i;
                ans = (ans + (long) (currIdx - left) * (right - currIdx) * arr[currIdx]) % MOD;
            }
            stack.push(i);
        }

        return (int) ans;
        
    }
}
