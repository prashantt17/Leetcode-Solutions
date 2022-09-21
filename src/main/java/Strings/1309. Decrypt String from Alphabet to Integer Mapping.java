class Solution {
    public String freqAlphabets(String s) {
        int n = s.length();
        StringBuilder result = new StringBuilder();
        for (int i = n-1 ; i>=0; ){
            if(s.charAt(i) == '#') {
            	char temp  = (char) (Integer.parseInt(s.substring(i-2, i)) + 96 );
                result.append(temp);
                i-=3;
            }else{
                result.append((char)(96+(int)(s.charAt(i)-'0')));
                i--;
            }
        }
        return result.reverse().toString();
    }
}
