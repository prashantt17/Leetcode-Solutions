class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        if(pattern.length() != str.length) 
            return false;
        HashMap<String,Character> map1 = new HashMap<>();
        HashMap<Character,String> map2 = new HashMap<>();
        
        for(int i=0;i<str.length;i++){
            char ch = pattern.charAt(i);
            if(!map1.containsKey(str[i])){
                map1.put(str[i],ch);
            }
             if(!map2.containsKey(ch)){
                map2.put(ch,str[i]);
            }
            if(map1.get(str[i]) != ch || !str[i].equals(map2.get(ch)))
                return false;
        }
        
        return true;
    }
}
