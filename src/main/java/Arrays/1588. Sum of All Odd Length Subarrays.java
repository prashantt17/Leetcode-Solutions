class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int subArrayLength = 1;
        
        int sum = 0;
        
        while(subArrayLength <= arr.length){
                        
            int subArrayStart = 0;
            int subArrayEnd = subArrayStart + subArrayLength;
            
            while(subArrayEnd <= arr.length){
                int subSum = 0;
                
                int iterator = subArrayStart;
                
                while(iterator < subArrayEnd){
                    subSum += arr[iterator];
                    ++iterator;
                }
                
                sum += subSum;
                
                ++subArrayStart;
                ++subArrayEnd;
            }
            
            subArrayLength += 2;
        }
        
        return sum;
    }
}
