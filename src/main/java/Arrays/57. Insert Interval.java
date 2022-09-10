class Solution {
	public int[][] insert(int[][] intervals, int[] newInterval) {
		int p = 0, k = 0, n = intervals.length;
		int[][] res = new int[n + 1][2];
		boolean newIntervalUsed = false;

		while (k<n) {
			int current[] = intervals[k];

			// If the new interval does not overlap with current and can be placed before current
			if (newInterval[1]<current[0]) {
				res[p++] = newInterval;
				newIntervalUsed = true;
				break;
			}

			// If the new interval overlaps with current, then we merge them and assign it to newInterval 
			if (newInterval[0]<= current[1]) {
				newInterval[0] = Math.min(current[0], newInterval[0]);
				newInterval[1] = Math.max(current[1], newInterval[1]);
				k++;
			} else {
				res[p++] = current;
				k++;
			}
		}

		// Add remaining intervals
		while (k<n) {
			res[p++] = intervals[k++];
		}

		// newInterval does not overlap with any interval and needs to be placed at end
		if (!newIntervalUsed) {
			res[p++] = newInterval;
		}

		return Arrays.copyOfRange(res, 0, p);
	}
}
