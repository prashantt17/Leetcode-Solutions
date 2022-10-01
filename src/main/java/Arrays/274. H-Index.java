class Solution {
    public int hIndex(int[] citations) {
        int[] counts = new int[citations.length + 2];
        for (int i = citations.length - 1; i >= 0; i--)  
            counts[Math.min(citations[i], citations.length)]++;
        
        int h;
        for (h = citations.length; h > 0; h--) {
            counts[h] += counts[h + 1];
            if (counts[h] >= h)  break;
        }
        return h;
    }
}
