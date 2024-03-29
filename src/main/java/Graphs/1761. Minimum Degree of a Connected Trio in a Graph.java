class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        int[] degrees = new int[n + 1];
    int[][] adjMatrix = new int[n + 1][n + 1];

    for (int[] edge : edges) {
      adjMatrix[edge[0]][edge[1]] = 1;
      adjMatrix[edge[1]][edge[0]] = 1;
      degrees[edge[0]]++;
      degrees[edge[1]]++;
    }

    int minTrios = Integer.MAX_VALUE;
    for (int i = 1; i <= n; i++) {
      for (int j = i + 1; j <= n; j++) {
        if (adjMatrix[i][j] == 0) continue;
        for (int k = j + 1; k <= n; k++) {
          if (adjMatrix[j][k] == 0 || adjMatrix[i][k] == 0) continue; 
          int trioDegree = degrees[i] + degrees[j] + degrees[k] - 6;
          minTrios = Math.min(minTrios, trioDegree);
        }
      }
    }
    return minTrios == Integer.MAX_VALUE ? -1 : minTrios;
    }
}
