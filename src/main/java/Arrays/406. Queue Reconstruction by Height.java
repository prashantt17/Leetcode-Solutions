class Solution {
    public int[][] reconstructQueue(int[][] people) {
         Arrays.sort(people,new peopleComparator());
        
        List<int[]> result=new ArrayList<int[]>();
        
        for(int[] p:people){
            result.add(p[1],p);
        }
        
        return result.toArray(new int[people.length][2]);
    }
    
    public class peopleComparator implements Comparator<int[]>{
        public int compare(int[] one,int[] two){
            if(one[0]==two[0]) return one[1]-two[1];
            return two[0]-one[0];
        }
    
    }
}
