class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int [] result = new int[k];
        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());
        
		// Count number of 1's using binary search
        for(int i=0;i<m;i++){
            int low = 0;
            int high = n-1;
            
            while(low <= high){
                int mid = low + (high - low)/2;
                if(mat[i][mid] == 1){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
            pq.add(new Pair(i, high+1));
        }
        
        for(int i=0;i<k;i++){
            result[i] = pq.poll().index;
        }
        
        return result;
    }
}

class Pair{
    int index;
    int count;
    
    Pair(int index, int count){
        this.index = index;
        this.count = count;
    }
}


class PairComparator implements Comparator<Pair>{
    @Override
    public int compare(Pair o1, Pair o2){
        if(o1.count == o2.count){
            return o1.index-o2.index;
        }
        else{
            return o1.count - o2.count;
        }
    }
}
