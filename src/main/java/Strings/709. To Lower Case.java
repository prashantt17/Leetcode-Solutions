class Solution {
    public String toLowerCase(String s) {
        char a[] = new char[s.length()];
        for(int i=0; i<s.length(); i++){
           a[i] = s.charAt(i)<91 && s.charAt(i)>64 ? (char)(s.charAt(i)+32) : s.charAt(i);
        }
        return new String(a);
    }
}
