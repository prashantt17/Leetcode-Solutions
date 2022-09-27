class Solution {
    public String pushDominoes(String dominoes) {
        StringBuilder sb = new StringBuilder(dominoes);
        
        int n = sb.length();
        
        char prev = '.';
        boolean[] forward = new boolean[n];
        for(int i = 0; i < n; i++){
            char c = dominoes.charAt(i);
            if(c == '.'){
                if(prev == 'R') forward[i] = true; 
            }else{
                prev = c;
            }
        }
        
        prev = '.';
        boolean[] backward  = new boolean[n];
        for(int i = n - 1; i >= 0; i--){
            char c = dominoes.charAt(i);
            if(c == '.'){
                if(prev == 'L') backward[i] = true; 
            }else{
                prev = c;
            }
        }
        
        int i = 0;
        while(i < n){
            if(backward[i] && !forward[i]){
                sb.setCharAt(i++, 'L');
                
            }else if(!backward[i] && forward[i]){
                sb.setCharAt(i++, 'R');
                
            }else if(backward[i] && forward[i]){
                int j = (i + 1);
                while(j < n && backward[j] && forward[j]){
                    j++;
                }
                pushDominoesInBetween(sb, i, j - 1);
                i = j;
            }else{
                i++;
            }
            
        }
        
        return sb.toString();
    }
    
    
    private void pushDominoesInBetween(StringBuilder sb, int l, int r){
        while(l < r){
            sb.setCharAt(l++, 'R');
            sb.setCharAt(r--, 'L');
        }
        
    }
}
