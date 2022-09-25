class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        
     List<int[]> diffs = new ArrayList<>();
        for (int[] building : buildings) {
            diffs.add(new int[] {building[0], building[2]});
            diffs.add(new int[] {building[1], -building[2]});
        }
        Collections.sort(diffs, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        tmap.put(0, 1);
        List<List<Integer>> rets = new ArrayList<>();
        for (int[] diff : diffs) {
            if (diff[1] > 0) {
                if (diff[1] > tmap.lastKey())
                    addNewPos(rets, diff[0], diff[1]);
                int count = tmap.getOrDefault(diff[1], 0);
                tmap.put(diff[1], count + 1);
            } else {
                int height = -diff[1];
                int count = tmap.get(height);
                if (count > 1) {
                    tmap.put(height, count - 1);
                } else {
                    tmap.remove(height);
                }
                if (tmap.lastKey() < height)
                    addNewPos(rets, diff[0], tmap.lastKey());
            }
        }
        return rets;
    }
    
    public void addNewPos(List<List<Integer>> rets, int pos, int height) {
        List<Integer> l = new ArrayList<>();
        l.add(pos);
        l.add(height);
        rets.add(l);
    }
}
