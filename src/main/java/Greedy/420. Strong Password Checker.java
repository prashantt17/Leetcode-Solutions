class Solution {
    public int strongPasswordChecker(String password) {
        int[] ok = new int[]{1, 1, 1};
        char[] A = password.toCharArray();
        for (char ch : A){ 
            ok[0] &= Character.isLowerCase(ch)? 0 : 1;
            ok[1] &= Character.isUpperCase(ch)? 0 : 1;
            ok[2] &= Character.isDigit(ch)? 0 : 1;
        }
        int ans = 0, len = password.length(), cond = ok[0]+ok[1]+ok[2]; 
        var minheap = new PriorityQueue<Integer>(Comparator.comparingInt(o -> o%3)); 
        for (int i = 0, cnt = 1; i < len; i++, cnt++){ 
            if (i == len-1 || A[i] != A[i+1]){
                if (cnt >= 3){
                    minheap.offer(cnt);
                }
                cnt = 0;
            }
        }
        while(len > 20 && !minheap.isEmpty()){ 
            int cur = minheap.poll();
            if (--cur >= 3){
                minheap.offer(cur);
            }
            --len;
            ++ans;
        }
        while(!minheap.isEmpty()){ 
            int cur = minheap.poll();
            cond -= cur/3;
            ans += cur/3;
            if (len < 6){ 
                len++;    
            }
        }
        while(len > 20){ 
            ans++;
            len--;
        }
        while(len < 6){
            cond--;
            ans++;
            len++;
        }
        return ans + (cond < 0? 0 : cond); 
    }
}
