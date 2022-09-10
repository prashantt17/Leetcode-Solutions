class Solution {
    public int calculate(String s) {
         if(s==null || s.length()==0)return 0;
        int curr=0;
        char op='+';
        char [] ch = s.toCharArray();
        int sum=0;
        int last=0;
        for(int i=0;i<ch.length;i++){
            if(Character.isDigit(ch[i])){
                curr=curr*10+ch[i]-'0';
            }
            if(!Character.isDigit(ch[i]) && ch[i]!=' '||i==ch.length-1){
                if(op=='+'){
                    sum+=last;
                    last=curr;
                }else if(op=='-'){
                    sum+=last;
                    last=-curr;
                }else if(op=='*'){
                    last=last*curr;
                }else if(op=='/'){
                    last=last/curr;
                }
                op=ch[i];
                curr=0;
            }
        }
        sum+=last;
        return sum;
    }
}
