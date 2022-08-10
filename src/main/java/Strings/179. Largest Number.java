class Solution {
    public String largestNumber(int[] nums) {
    StringBuilder sb =  new StringBuilder();
	int n = nums.length;
    int count_zeros = 0;

	Integer[] customSort = new Integer [nums.length];

    for(int i=0; i<nums.length; i++){
        customSort[i]=nums[i];
    }

   
	Arrays.sort(customSort, (a,b) ->{

		String x = "" + a + b;
		String y = "" + b + a;
		return y.compareTo(x); 
	
	});

    if(customSort[0]==0 && customSort[nums.length-1]==0){
        return "0";
    }


	for(int i=0; i<nums.length; i++){
		sb.append(customSort[i]);
	}

    return sb.toString();
    }
}
