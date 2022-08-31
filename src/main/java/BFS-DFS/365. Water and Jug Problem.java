class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
         if(jug1Capacity + jug2Capacity < targetCapacity) 
             return false;
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited.add(0);
        int curr = 0;
        while(!q.isEmpty()){
            int top = q.poll();
            if(top==targetCapacity) return true;
            if(top+jug1Capacity<=jug1Capacity+jug2Capacity && !visited.contains(top+jug1Capacity)){
                q.add(top+jug1Capacity);
                visited.add(top+jug1Capacity);
            }
            if(top-jug1Capacity>=0 && !visited.contains(top-jug1Capacity)){
                q.add(top-jug1Capacity);
                visited.add(top-jug1Capacity);
            }
            if(top+jug2Capacity<=jug1Capacity+jug2Capacity && !visited.contains(top+jug2Capacity)){
                q.add(top+jug2Capacity);
                visited.add(top+jug2Capacity);
            }
            if(top-jug2Capacity>=0 && !visited.contains(top-jug2Capacity)){
                q.add(top-jug2Capacity);
                visited.add(top-jug2Capacity);
            }
        }
        return false;
    }
}
