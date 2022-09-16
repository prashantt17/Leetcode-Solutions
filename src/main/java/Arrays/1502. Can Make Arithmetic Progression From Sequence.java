class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        boolean flag=true;
        for(int i=0;i<arr.length-2;i++){
            if(arr[i+1]-arr[i] != arr[i+2]-arr[i+1]){
                flag=false;
            }
        }
        return flag;
    }
}
