class Pair{
    int index;
    int left;
    int right;
    Pair(int index,int left,int right)
    {
        this.index=index;
        this.left=left;
        this.right=right;
    }
}
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        Pair[]p=new Pair[intervals.length];
        for(int i=0;i<intervals.length;i++)
        {
            p[i]=new Pair(i,intervals[i][0],intervals[i][1]);
        }
        Arrays.sort(p,new Comparator<Pair>(){
            public int compare(Pair a,Pair b)
            {
                if(a.left<b.left) return -1;
                else if(a.left>b.left) return 1;
                else return 0;
            }
        });
        int[]ans=new int[intervals.length];
        for(int i=0;i<intervals.length;i++)
        {
            int end=p[i].right;
            int index=p[i].index;
            Pair res=binarySearch(0,intervals.length-1,p,end);
            if(res==null) ans[index]=-1;
            else ans[index]=res.index;
            
        }
        return ans;
    }
    Pair binarySearch(int low,int high,Pair[]p,int target)
    {
        Pair ans=null;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(p[mid].left>=target)
            {
                ans=p[mid];
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
}
