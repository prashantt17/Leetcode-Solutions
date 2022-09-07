class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length())return "";
    int m = t.length();
    int n = s.length();
    int [] freq = new int[58];
    int [] count = new int[58];
    String S = "";
    int window = n+1;
    for(int i=0; i<m; i++){
        freq[t.charAt(i)-'A']++;
    }
    int l = 0;
    for(int r=0; r<n; r++){
        count[s.charAt(r)-'A']++;
        while(compare(count,freq)){
            if(r-l+1 < window){
                S = s.substring(l,r+1);
                window = r-l+1;
            }
            count[s.charAt(l)-'A']--;
            l++;
        }
       
    }
    return S;
}
public boolean compare(int[] count,int[] freq){
    for(int i=0; i<freq.length; i++){
        if(count[i] < freq[i])return false;
    }
    return true;

    }
}
