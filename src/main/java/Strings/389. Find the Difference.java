class Solution {
    public char findTheDifference(String s, String t) {
        int charS=0 , charT=0;
        for(int i=0;i<s.length();i++) charS+=s.charAt(i);
        for(int i=0;i<t.length();i++) charT+=t.charAt(i);
        return (char)(charT-charS);
    }
}
