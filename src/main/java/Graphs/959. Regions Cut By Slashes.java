class Solution {
    
    int[] id;
    int cnct = 0; 
    private int find(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
    private void connect(int i, int j) {
        i = find(i);
        j = find(j);
        if (i != j) {
            id[i] = j;
            cnct++;
        }
    }
    public int regionsBySlashes(String[] grid) { 
        HashSet<Integer> points = new HashSet();
        int edgePoints = 0;
        int edge = 0;
        int n = grid.length;
		id = new int[(n + 1) * (n + 1)];
        for (int i = 0; i < (n+1)*(n+1); i++) {
            id[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == ' ') continue;
                int index1 = -1, index2 = -1;
                if (grid[i].charAt(j) == '\\') {
                    index1 = i * (n+1) + j;
                    index2 = (i+1) * (n+1) + j + 1;
                } 
                if (grid[i].charAt(j) == '/') {
                    index1 = i * (n+1) + j + 1;
                    index2 = (i+1) * (n+1) + j;
                } 
                points.add(index1);
                points.add(index2);
                connect(index1, index2);
                edge++;
            }
        }
		
	    points.add(0 * (n+1) + 0);
        points.add(0 * (n+1) + n);
        points.add(n * (n+1) + 0);
        points.add(n * (n+1) + n);
		
	    for (int p : points) {
            if (p / (n+1) == 0) {edgePoints++; connect(p, 0);}
            if (p / (n+1) == n) {edgePoints++; connect(p, 0);}
            if (p % (n+1) == 0) {edgePoints++; connect(p, 0);}
            if (p % (n+1) == n) {edgePoints++; connect(p, 0);}
        }
        edge += (edgePoints - 4);
	
        return edge - cnct;
    }
}
