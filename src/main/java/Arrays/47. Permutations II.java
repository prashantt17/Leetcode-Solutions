class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, 1 + map.getOrDefault(num, 0));
        }

        // We can recursively create lists by taking any of these available keys from map
        return permute(map, nums.length);
    }

    private List<List<Integer>> permute(Map<Integer, Integer> map, int remainingNumbers) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (remainingNumbers == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }

        for (int key: map.keySet()) {
            int count = map.get(key);
            if (count == 0)
                continue;

            map.put(key, count-1); // We're using this value, so reducing the remaining count
            List<List<Integer>> subPermutes = permute(map, remainingNumbers-1);
            for (List<Integer> subPermute: subPermutes) {
                subPermute.add(key);
                results.add(subPermute);
            }
            map.put(key, count); // Important to reset the counter after this iteration for this key
        }

        return results;
    }
}
