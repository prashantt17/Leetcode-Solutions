class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> numbers = new ArrayList<> ();
        
        for (int num = 1; num < 10; num++) {
            dfs (num, num, n - 1, k, numbers);
        }
        
        int[] answer = new int[numbers.size ()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = numbers.get (i);
        }
        
        return answer;
    }
    
    private void dfs (int num, int digit, int n, int k, List<Integer> numbers) {
        
        if (n == 0) {
            numbers.add (num);
            return;
        }
        if (digit + k <= 9) {
            dfs (num * 10 + (digit + k), digit + k, n - 1, k, numbers);
        }
        if (k != 0 && digit - k >= 0) {
            dfs (num * 10 + (digit - k), digit - k, n - 1, k, numbers);
        }
    }
}
