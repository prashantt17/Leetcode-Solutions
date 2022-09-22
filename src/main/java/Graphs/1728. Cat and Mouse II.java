class Solution {
	private final int MOUSE = 1, CAT = 2, NO_ONE = 0;
	private int rows, cols, N;

	private String[] grid;
	private List<Integer> [] catJumps;
	private List<Integer> [] mouseJumps;
	private int[][][] winners;

	public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
		this.grid = grid;
		rows = grid.length;
		cols = grid[0].length();
		N = rows * cols;

		winners = new int[N][N][3];

		catJumps = getAllJumps(catJump);
		mouseJumps = getAllJumps(mouseJump);

		int[] locations = locate();
		int mouse = locations[0], cat = locations[1], food = locations[2];

		int[][][] degree = new int[N][N][3];

		for (int m = 0; m<N; m++) {
			for (int c = 0; c<N; c++) {
				degree[m][c][MOUSE] = mouseJumps[m].size();
				degree[m][c][CAT] = catJumps[c].size();
			}
		}

		Queue<State> queue = new LinkedList<>();
		for (int i = 0; i<N; i++) {
			if (isWall(i / cols, i % cols)) continue;

			State mouseToCat = new State(i, i, MOUSE);
			State catToMouse = new State(i, i, CAT);
			State catToFood = new State(i, food, CAT);
			State mouseToFood = new State(food, i, MOUSE);

			queue.offer(mouseToCat);
			queue.offer(catToMouse);
			queue.offer(catToFood);
			queue.offer(mouseToFood);

			setWinner(mouseToCat, CAT);
			setWinner(catToMouse, CAT);
			setWinner(catToFood, CAT);
			setWinner(mouseToFood, MOUSE);
		}

		while (!queue.isEmpty()) {
			State sub = queue.poll();
			int subWinner = getWinner(sub);

			for (State cur: parents(sub)) {
				int winner = getWinner(cur);
				if (winner == NO_ONE) {
					if (cur.turn == subWinner) {
						winner = cur.turn;
					} else if (--degree[cur.mouse][cur.cat][cur.turn] == 0) {
						winner = 3 - cur.turn;
					}

					if (winner != NO_ONE) {
						queue.offer(cur);
						setWinner(cur, winner);
					}
				}
			}
		}

		return winners[mouse][cat][MOUSE] == MOUSE;
	}

	private int getWinner(State state) {
		return winners[state.mouse][state.cat][state.turn];
	}

	private void setWinner(State state, int winner) {
		winners[state.mouse][state.cat][state.turn] = winner;
	}

	private List<Integer> [] getAllJumps(int jump) {
		List<Integer> [] jumps = new List[N];
		for (int i = 0; i<N; i++) {
			jumps[i] = getJumps(i, jump);
		}

		return jumps;
	}

	private final int[] dir = { 0, 1, 0, -1, 0 };

	private List<State> parents(State sub) {
		List<State> list = new LinkedList<>();
		if (sub.turn == MOUSE) {
			for (int cat: catJumps[sub.cat]) {
				list.add(new State(sub.mouse, cat, CAT));
			}
		} else {
			for (int mouse: mouseJumps[sub.mouse]) {
				list.add(new State(mouse, sub.cat, MOUSE));
			}
		}

		return list;
	}

	private List<Integer> getJumps(int index, int jump) {

		List<Integer> jumps = new LinkedList<>();
		int i = index / cols, j = index % cols;
		if (isWall(i, j)) return jumps;

		jumps.add(index);
		for (int d = 0; d<dir.length - 1; d++) {
			for (int k = 1; k<= jump; k++) {
				int x = i + k * dir[d];
				int y = j + k * dir[d + 1];

				if (isWall(x, y)) break;
				jumps.add(x * cols + y);
			}
		}

		return jumps;
	}

	private boolean isWall(int x, int y) {
		return x<0 || x >= rows || y<0 || y >= cols || grid[x].charAt(y) == '#';
	}

	private int[] locate() {
		int[] locations = { 0, 0, 0 };
		for (int i = 0; i<N; i++) {
			int x = i / cols;
			int y = i % cols;
			switch (grid[x].charAt(y)) {
				case 'M' -> locations[0] = i;
				case 'C' -> locations[1] = i;
				case 'F' -> locations[2] = i;
			}
		}
		return locations;
	}

	private static class State {
		int mouse;
		int cat;
		int turn;

		State(int mouse, int cat, int turn) {
			this.mouse = mouse;
			this.cat = cat;
			this.turn = turn;
		}
	}
}
