class Solution {
    public int numDecodings(String s) {
        
    int n=s.length();
        Integer[] mem=new Integer[n];
        return s.length()==0?0:numDecodings(0,s,mem);      
    }
    private int numDecodings(int p, String s, Integer[] mem) {
        int n=s.length();
        if(p==n) return 1;
        if(s.charAt(p)=='0') return 0;
        if(mem[p]!=null) return mem[p];
        int res=numDecodings(p+1,s,mem);
        if(p<n-1&&(s.charAt(p)=='1'||s.charAt(p)=='2'&&s.charAt(p+1)<'7')) 
			res+=numDecodings(p+2,s,mem);
        return mem[p]=res;
    }
}
