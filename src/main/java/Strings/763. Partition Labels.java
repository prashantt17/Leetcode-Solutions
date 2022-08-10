class Solution {
    public List<Integer> partitionLabels(String s) {
         List<Integer> lengths = new ArrayList<>();
        int currLast = 0; 
        int currStart = 0; 
        Map<Character, Integer> lastOccurence = new HashMap<>();
		for (int i = s.length() - 1; i >= 0; i--) lastOccurence.putIfAbsent(s.charAt(i), i);
        for (int i = 0; i < s.length(); i++) {
		    currLast = Math.max(currLast, lastOccurence.get(s.charAt(i)));
		    if (currLast == i) {
		        lengths.add(currLast - currStart + 1);
		        currStart = i + 1;
            }
        }
        return lengths;
    }
}
