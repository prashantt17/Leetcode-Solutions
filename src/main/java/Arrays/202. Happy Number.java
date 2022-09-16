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
