class Solution {
    public boolean isPossible(int[] nums) {
        if (nums.length < 3) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(map.keySet().size());
        for (int num : map.keySet()) {
            queue.add(num);
        }

        while (!queue.isEmpty()) {
            int min = queue.peek();
            int count = 0;
            while (true) {
                if (!map.containsKey(min)) { 
		            if (count < 3) return false;
		            break;
                }
                map.put(min, map.get(min) - 1);
                count++;
                if (map.get(min) == 0) {
		            if (min != queue.peek()) return false;
		            queue.poll();
                }
		        if (map.containsKey(min + 1) && map.get(min) + 1 > map.get(min + 1)) {
                    if (count < 3) return false;
                    break;
                }

                min += 1;
            }
        }
		return true;
    }
}
