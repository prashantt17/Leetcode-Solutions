class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[]rightMax=new int[arr.length+1];
        int[]leftMin=new int[arr.length+1];
        
        int max=0;
        int min=Integer.MAX_VALUE;
        
        
        
        for(int i=0;i<leftMin.length-1;i++)
        {
            max=Math.max(max,arr[i]);
            rightMax[i]=max;
            
            
        }
        
        leftMin[arr.length]=Integer.MAX_VALUE;
        
        for(int i=leftMin.length-2;i>=0;i--)
        {
            min=Math.min(min,arr[i]);
            leftMin[i]=min;
        }
        
        int chunk=0;
        for(int i=0;i<rightMax.length-1;i++)
        {
           if(rightMax[i]<=leftMin[i+1])
           {
               chunk++;
           } 
        }
        
        return chunk;
    }
}
