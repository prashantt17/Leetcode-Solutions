class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0)return "0";
        if(denominator==0)return "";
        StringBuilder sb = new StringBuilder();
        if(numerator<0 && denominator>0 || numerator>0 && denominator<0)
            sb.append("-");
        long nume = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        long rem = nume%den;
        sb.append(nume/den);
        if(rem==0)return sb.toString();
        sb.append(".");
        Map<Long,Integer>map = new HashMap<>();
        while(rem!=0){
            if(map.containsKey(rem)){
                sb.insert(map.get(rem),"(");
                sb.append(")");
                break;
            }
           map.put(rem,sb.length());
           rem*=10;
           sb.append(rem/den);
           rem %= den; 
        }
        return sb.toString();
    }
}
