class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>>mlist=new ArrayList<>();
            List<Integer> clist=new ArrayList<>();
            subset(nums, 0, mlist, clist);
            return mlist;
}
        private static void subset(int arr[],int ind,List<List<Integer>>mlist,List<Integer>clist) {
                if(ind==arr.length) {
                        List<Integer>cclist=new ArrayList<>(clist);
						Collections.sort(cclist);
						if(!mlist.contains(cclist)) {
						       mlist.add(new ArrayList<>(cclist));
					    }
		        return;
		        }
		clist.add(arr[ind]);
		subset(arr, ind+1, mlist, clist);
		clist.remove(clist.size()-1);
		subset(arr, ind+1, mlist, clist);
	}
}
