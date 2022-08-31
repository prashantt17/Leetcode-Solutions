class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
            for(int i=0; i < numCourses; i++){
                map.put(i, new ArrayList<>());
            }

             for(int i=0; i < prerequisites.length; i++){
                int c = prerequisites[i][0];
                List list = map.get(c);
                if(!list.contains(c)){
                   list.add(prerequisites[i][1]);
                   map.put(c, list);
                }
            }

            Set<Integer> set = new LinkedHashSet<>();
            boolean[] visited = new boolean[numCourses];
            for(int i=0; i < numCourses; i++){
                if(!dfs(i, map, visited, set)){
                    return new int[0];
                }
            }
            
            return set.stream().mapToInt(Number::intValue).toArray();    
    }
    
                                              
     public boolean dfs(int course, Map<Integer, List<Integer>> map, boolean[] visited, Set<Integer> set){
         List<Integer> courses = map.get(course);
         
         if(visited [course]){
             return false;
         }
         if(courses.isEmpty()){
             set.add(course);
             return true;
         }
         
         visited[course] = true;
         for(int i : courses){
             if(!dfs(i, map, visited, set)){
                 return false;
             }
         }
        visited[course] = false;
        map.put(course, List.of()); 
        set.add(course);
        return true;
    }
}
