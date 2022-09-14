class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        boolean flag = true;
        int pos = Arrays.binarySearch(arr, x);
        if (pos < 0) {
            pos = Math.abs(pos) - 1;
            flag = false;
        }
        if (flag) {
            res.add(arr[pos]);
            k--;
            f(arr, pos - 1, pos + 1, k, x, res);
        } else 
            f(arr, pos - 1, pos, k, x, res);
        return res;
    }

    public void f(int arr[], int i, int j, int k, int x, List<Integer> res) {
        while (i >= 0 && j < arr.length && k > 0) {
            if (Math.abs(arr[i] - x) <= Math.abs(arr[j] - x)) {
                res.add(0, arr[i]);
                i--;
            } else if (Math.abs(arr[i] - x) > Math.abs(arr[j] - x)) {
                res.add(arr[j]);
                j++;
            }
            k--;
        }
        while (i >= 0 && k > 0) {
            res.add(0, arr[i]);
            i--;
            k--;
        }
        while (j < arr.length && k > 0) {
            res.add(arr[j]);
            j++;
            k--;
        }
    }
}
