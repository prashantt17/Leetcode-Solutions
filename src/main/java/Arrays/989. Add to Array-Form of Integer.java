class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> list = new ArrayList<Integer>();
        
        int i = num.length - 1;
        int residue = 0;
            
        while(residue > 0 || i >= 0 || k > 0){
            int n = i >= 0 ? num[i--] : 0;
            int sum = n + residue + k % 10;
            list.add(sum % 10);
            residue = sum / 10;
            k /= 10;
            
        }
        Collections.reverse(list);
        return list;
    }
}
