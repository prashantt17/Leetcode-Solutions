class Solution {
    public String breakPalindrome(String palindrome) {
        int len = palindrome.length();
        StringBuilder sb = new StringBuilder(palindrome);
        if(len<=1) {
            return "";
        }
        int endpoint = len%2==0 ? len/2 : (len/2)+1;
        boolean changed = false;
            for(int i=0; i<endpoint; i++) {
                
                if(palindrome.charAt(i)!='a') {
                    if(i==endpoint-1 && palindrome.charAt(i+1)=='a') {
                        break;
                    }
                    sb.setCharAt(i,'a');
                    changed = true;
                    break;
                }
            }
       
        if(!changed) {
            if(palindrome.equals(sb.toString())) {
                sb.setCharAt(len-1,'b');
            }
        }
        return sb.toString();
    }
}
