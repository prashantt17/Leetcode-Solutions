class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int len = arr.length;
       int start = 0;
        while(start < len -1 && arr[start]<= arr[start+1])
            start++;
        if (start== len-1)
            return 0;
        int end = len - 1;
        while(end > 0 && arr[end]>= arr[end-1])
            end--;
        if (end == 0)
            return 0;
        int result = Math.min((len-(start+1)), end);
        int begin = 0;
        while(begin <= start && end < len){
            if (arr[begin] > arr[end])
                end++;
            else{
                result = Math.min(result, end - begin -1);
                begin++;
            }
        }
        return result;
    }
}
