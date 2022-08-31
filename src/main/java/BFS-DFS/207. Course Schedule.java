class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        
        boolean[] visited = new boolean[numCourses];
        for(int i=0; i < numCourses; i++){
            if(!dfs(i, map, visited)){
                return false;
            }
        }
                 
        return true;
    }
                                              
     public boolean dfs(int course, Map<Integer, List<Integer>> map, boolean[] visited ){
         List<Integer> courses = map.get(course);
         
         if(visited [course]){
             return false;
         }
         
         if(courses.isEmpty()){
             return true;
         }
         
         visited[course] = true;
         for(int i : courses){
             if(!dfs(i, map, visited)){
                 return false;
             }
         }
        visited[course] = false;
        map.put(course, List.of()); 
        return true;
    }
}
