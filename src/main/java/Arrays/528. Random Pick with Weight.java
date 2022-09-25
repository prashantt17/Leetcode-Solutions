class Solution {

   List<Integer> arr=new ArrayList<Integer>();
public Solution(int[] w) {
    int n=w.length;
    arr.add(w[0]);
    for(int i=1;i<n;i++){
        arr.add(w[i] + arr.get(i-1));
    }
}

public int binSearch(List<Integer> a,int l, int h, int key){
    if(l<=h){
        int m=l+(h-l)/2;
        if((m==0 || a.get(m-1)<=key) && a.get(m)>key){
            return m;
        }
        if((m==a.size()-1 || a.get(m+1)>key) && a.get(m)<=key){
            return m+1;
        }
        if(a.get(m)>key){
            return binSearch(a,l,m-1,key);
        }else{
            return binSearch(a,m+1,h,key);
        }
    }
    return -1;
}

public int pickIndex() {
    int n=arr.size();
    Integer totalSum=arr.get(n-1);
    Integer rval=(int)(Math.random()*totalSum);
    return binSearch(arr,0,n-1,rval);
}
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
