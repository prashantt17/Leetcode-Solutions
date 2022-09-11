class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] players = new int[n][2];
        for (int i=0; i<n; i++) {
            players[i][0] = efficiency[i];
            players[i][1] = speed[i];
        }
		Arrays.sort(players, (p1, p2) -> (p2[0] - p1[0]));

		PriorityQueue<Integer> speedQueue = new PriorityQueue<>(k);
        long teamPerformance = 0, teamSpeed = 0;

        for (int i=0; i<n; i++) {
		    if (speedQueue.size() >= k) {
                teamSpeed -= speedQueue.remove();
            }
            speedQueue.add(players[i][1]);
            teamSpeed += players[i][1];

            teamPerformance = Math.max(teamPerformance, teamSpeed * players[i][0]);
        }
        return (int) (teamPerformance % 1000000007);
    }
}
