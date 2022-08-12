class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] arr = preorder.split(",");
        int count = 1;
        
        for(String str : arr){
            
            if(--count < 0 ) return false;
            if(!str.equals("#"))            
                count += 2;
           
        }
        
        
        return count == 0;
    }
}
