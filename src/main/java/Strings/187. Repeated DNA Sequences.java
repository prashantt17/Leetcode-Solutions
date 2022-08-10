class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
			Map<String, Integer> sequence = new HashMap<>();

			for(int i = 0; i < s.length() - 9; i++){
				String dna = s.substring(i, i + 10);
				if(sequence.containsKey(dna) && !res.contains(dna))
					res.add(dna);
				else
					sequence.put(dna, 1);
				}
			return res;
    }
}
