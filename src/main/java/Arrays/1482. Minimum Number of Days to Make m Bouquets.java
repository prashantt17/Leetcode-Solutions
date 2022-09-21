class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
         if(m*k>bloomDay.length){
		 return -1;
	 }   
		int min=0;
		int max=0;
		for(int i:bloomDay){
			min=Math.min(min,i);
			max=Math.max(max,i);
		}
		int ans=0;
		while(min<=max){
			int mid=min+(max-min)/2;
			if(valid(bloomDay,mid,m,k)){
				ans=mid;
			   max=mid-1; 
			}
			else
				min=mid+1;
		}
		return ans;
	}
	public static boolean valid(int[]bloomDay,int mid,int m,int k){
		int flower=0;
		int count=0;
		for(int i:bloomDay){
			if(i<=mid)
			{
				flower++;

				if(flower==k){
					count++;    
					flower=0;
				}
			}
			else
				flower=0;
		}
		if(count>=m){
			return true;
		}
		return false;
    }
}
