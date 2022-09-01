class Solution {
    public boolean checkIfExist(int[] arr) {
        ArrayList<Integer> al= new ArrayList<Integer>();
        int count=0;
        
        for(int i=0;i<arr.length;i++) {
            al.add(arr[i]);
            if(arr[i]==0) count++;
            
        }
		
        if(count ==2) return true;
		
        for(int i=0;i<arr.length;i++){
		
             if(al.contains(2*arr[i]) && arr[i]!=0) return true;
        }
          return false;
    }
}
