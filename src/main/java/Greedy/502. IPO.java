class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;
        PriorityQueue<Integer> minCapitalHeap=new PriorityQueue<>(n,(i1,i2)->Integer.compare(capital[i1],capital[i2]));
        PriorityQueue<Integer> maxProfitHeap=new PriorityQueue<>(n,(i1,i2)->Integer.compare(profits[i2],profits[i1]));
        
        for(int i=0;i<n;i++)
            minCapitalHeap.offer(i);
        for(int i=0;i<k;i++){
     
            while(!minCapitalHeap.isEmpty() && capital[minCapitalHeap.peek()]<=w)
                maxProfitHeap.offer(minCapitalHeap.poll());
        
            if(maxProfitHeap.isEmpty())
                break;
            w+=profits[maxProfitHeap.poll()];
            
        }
        return w;
    }
}
