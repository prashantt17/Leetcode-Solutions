class Solution {
    public int minPatches(int[] nums, int n) {
         ArrayList <Long> valuesToAdd = new ArrayList <Long>();
        long partialSum = 0; 
        if (nums[0] == 1) {
            partialSum += nums[0];
            int i = 1; 
            while (partialSum < n) {
                if (i < nums.length) {
                    while (partialSum + 1 < nums[i]) {
                        valuesToAdd.add (partialSum + 1);
                        partialSum += (partialSum + 1);
                        if (partialSum >= n) {
                        break;
                        }
                    }
                    partialSum += nums[i];
                    
                }
                else {
                    valuesToAdd.add (partialSum + 1);
                    partialSum += (partialSum + 1);
                }
                i++;
            }
        }
        else {
            partialSum += 1; 
            valuesToAdd.add((long) 1);
            int i = 0; 
            while (partialSum < n) {
                if (i < nums.length) {
                    while (partialSum + 1 < nums[i]) {
                        valuesToAdd.add (partialSum + 1);
                        partialSum += (partialSum + 1);
                    }
                    partialSum += nums[i];
                }
                else {
                    valuesToAdd.add (partialSum + 1);
                    partialSum += (partialSum + 1);
                }
                i++;
            }
        
            
        }
        //System.out.println(valuesToAdd);
        return valuesToAdd.size();
    }
}
