class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int n = words.length;
        for(int i=0;i<n-1;i++)
        {
            int l1 = words[i].length();
            int l2 = words[i+1].length();
            int m = Math.min(l1,l2);
            int k = 0;
            while(k<m && order.indexOf(words[i].charAt(k)) <= order.indexOf(words[i+1].charAt(k)))
            {
                if(order.indexOf(words[i].charAt(k)) < order.indexOf(words[i+1].charAt(k)))
                {
                    if(i+1 == n-1)
                    {
                        return true;
                    }
                }
                k++;
            }
            if(k < m || k < l1)
            {
                return false;
            }
        }
        return true;
    }
}
