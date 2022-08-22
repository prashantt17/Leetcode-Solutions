class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n == 1) return 1;
        Map<Integer, Integer> normalPeople = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            normalPeople.put(i, 0);
        }
        Map<Integer, Integer> candidate = new HashMap<>();
        for (int[] a : trust) {
            normalPeople.put(a[0], normalPeople.get(a[0]) + 1);
            candidate.put(a[1], candidate.getOrDefault(a[1], 0) + 1);
        }
        for (int i : candidate.keySet()) {
            if(candidate.get(i) == n - 1 && normalPeople.get(i) == 0) return i; 
        }
        return -1;
    }
}
