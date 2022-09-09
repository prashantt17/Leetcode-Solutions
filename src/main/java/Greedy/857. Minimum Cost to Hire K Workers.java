class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[][] workers = new double[n][2];
        for (int i = 0; i < n; i++)
            workers[i] = new double[]{(double) wage[i] / quality[i], quality[i]};
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        double sum = 0, cost = Double.MAX_VALUE;
        for (double[] worker : workers) {
            pq.offer(worker[1]);
            sum += worker[1];
            if (pq.size() > k) sum -= pq.poll();
            if (pq.size() == k) cost = Math.min(cost, sum * worker[0]);
        }
        return cost;
    }
}
