class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        ArrayList<Integer>value = new ArrayList<>();
        ArrayList<Integer>rightmul = new ArrayList<>();
        ArrayList<Character>op = new ArrayList<>();
        char lastop =  '#';
        int j = 0,len = expression.length();
        
        for( int i=0; i<len; i++ ){
            
            char ch = expression.charAt(i);
            if( ch=='+' || ch=='-' || ch=='*' ){
                int num = Integer.parseInt(expression.substring(j,i));
                
                if( lastop!='#' ){
                    rightmul.add(getres(lastop,num,value.get(value.size()-1)));
                }
 
                value.add(num);
                lastop = ch;
                op.add(ch);
                j = i+1;
            }
                
            if( i==len-1 ){
                if( value.size()==0 ) value.add(Integer.parseInt(expression));
                else{
                    int num = Integer.parseInt(expression.substring(j,i+1));
                    rightmul.add(getres(lastop,num,value.get(value.size()-1)));
                    value.add(num);  
                }       
            }
        }
        
        return helper(0,value.size()-1,op,value,rightmul);
    }
    
    public int getres( char op , int n1 , int n2 ){
        if( op=='-' ) return n2-n1;
        else if( op=='+' ) return n2+n1;
        else{
            return n2*n1;
        }
    }
    
	
    public ArrayList<Integer> helper( int st , int ed , ArrayList<Character>op , ArrayList<Integer>value , ArrayList<Integer>rm ){
        
        if( st==ed ){
            ArrayList<Integer>sa = new ArrayList<>();
            sa.add(value.get(st));
            return sa;
        }
        
        if( ed-st==1 ){
            ArrayList<Integer>sa = new ArrayList<>();
            sa.add(rm.get(st));
            return sa;
        }
        
        ArrayList<Integer>ans = new ArrayList<>();
        
        for( int i=st; i<ed; i++ ){
            ArrayList<Integer>right = helper(i+1,ed,op,value,rm);
            ArrayList<Integer>left = helper(st,i,op,value,rm);
            for( int num : left ){
                for( int val : right ){
                    ans.add(getres(op.get(i),val,num));
                }
            }
        }
        
        return ans;
    }
}
