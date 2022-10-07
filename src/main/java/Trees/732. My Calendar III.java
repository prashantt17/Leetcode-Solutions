class MyCalendarThree {

    TreeMap<Integer,Integer> map;
    int max=Integer.MIN_VALUE;
    public MyCalendarThree() {
        map =  new TreeMap<>();
    }
    
    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start,0)+1);
        map.put(end, map.getOrDefault(end,0)-1);
        int sum=0;
        for(int k: map.keySet()) {
            sum+=map.get(k);
            max=Math.max(max, sum);
            
        }
        
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
