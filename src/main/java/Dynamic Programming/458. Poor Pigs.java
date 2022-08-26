class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int temp = minutesToTest/minutesToDie;
        int noOfPigs = 0;
      
        while( Math.pow(temp+1, noOfPigs) < buckets){
            noOfPigs++;
        }
        return noOfPigs;
    }
}
