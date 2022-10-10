class Solution {
    public String addBinary(String a, String b) {
        Stack A = new Stack();
        Stack B = new Stack();
        Stack C = new Stack();
        String s = "";
        for(char x :a.toCharArray()){
            A.push(x);
        }
        for(char xx:b.toCharArray()){
            B.push(xx);
        }
        while(!A.isEmpty()&&!B.isEmpty()){
            int apop = (char)A.pop();
            int bpop = (char)B.pop();
            if(apop!=bpop){
                if(C.isEmpty()){
                    s = s+"1";
                }else{
                    s = s+"0";
                }
            }
            if(apop==bpop&&apop=='0'){
                if(C.isEmpty()){
                    s = s+"0";
                }else{
                    s = s+"1";
                    C.pop();
                }
            }
            if(apop==bpop&&apop=='1'){
                if(C.isEmpty()){
                    s = s+"0";
                    C.push('1');
                }else{
                    s = s+"1";
                }
            }
        }
        while(!A.isEmpty()){
            if((char)A.pop()=='1'){
                if(C.isEmpty()){
                    s = s+"1";
                }else{
                    s = s+"0";
                }
            }else{
                if(C.isEmpty()){
                    s = s+"0";
                }else{
                    s = s+"1";
                    C.pop();
                }
            }
        }
        while(!B.isEmpty()){
            if((char)B.pop()=='1'){
                if(C.isEmpty()){
                    s = s+"1";
                }else{
                    s = s+"0";
                }
            }else{
                if(C.isEmpty()){
                    s = s+"0";
                }else{
                    s = s+"1";
                    C.pop();
                }
            }
        }
        while(!C.isEmpty()){
            s = s +String.valueOf((char)C.pop());
        }
        String k = "";
        for(int j = s.length()-1;j>=0;j--){
            k = k + String.valueOf(s.charAt(j));
        }
        return k;
    }
}
