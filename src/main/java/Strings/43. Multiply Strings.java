class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        
        if(num1.equals("1"))
            return num2;
         if(num2.equals("1"))
            return num1;
        
        int[] result = new int[m+n];
        for(int i=m-1;i>=0;i--) {
            for(int j=n-1;j>=0;j--) {
                int product = ((int)num1.charAt(i) - (int)'0') * ((int)num2.charAt(j) - (int)'0');
                
                product += result[i+j+1];
                
                result[i+j+1] = product%10;
                result[i+j] += product/10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int digit : result) {
            if(sb.length() == 0 && digit == 0)
                continue;
            sb.append(digit);
        }
        
        return sb.toString();
    }
}
