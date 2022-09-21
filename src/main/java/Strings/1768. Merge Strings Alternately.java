class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int i= 0;
        char ch1 = 0, ch2 = 0;
        while(i <word1.length() || i < word2.length())
        {  
            if(i <word1.length())
            {
                ch1 = word1.charAt(i);
                res.append(ch1);
            }

            if(i <word2.length())
            {
                ch2 = word2.charAt(i);
                res.append(ch2);
            }

            i++;
        }

       return res.toString();
    }
}
