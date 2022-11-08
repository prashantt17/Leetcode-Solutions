class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        int pt2 = 0;
        for(int i = 0; i<s.length(); i++){
            if(pt2>0 && Math.abs(sb.charAt(pt2-1) - s.charAt(i)) == 32){
                pt2--;
                sb.deleteCharAt(pt2);
            }
            else{
                sb.append(s.charAt(i));
                pt2++;
            }
        }
        return sb.toString();
    }
}
