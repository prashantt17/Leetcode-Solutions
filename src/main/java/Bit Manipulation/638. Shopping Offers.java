class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
         HashMap<String, Integer> dp = new HashMap<>();
        
        return backtrack(price, special, needs, dp);
        
    }
    
    private int backtrack(List<Integer> price, List<List<Integer>> special, List<Integer> needs, HashMap<String, Integer> dp) {
        
        boolean isComplete = isComplete(needs);
        if (isComplete) {
            return 0;
        }
        
        if (dp.containsKey(needs.toString())){
            return dp.get(needs.toString());
        }
        
        int min = directPurchase(price, needs);
        
        for(int i = 0; i < special.size(); i++) 
        {
            List<Integer> spec = special.get(i);
            
            if (!isValid(spec, needs)) {
                continue;
            }
            int cost = spec.get(spec.size() - 1);
            
           List<Integer> tempNeeds = newNeeds(spec, needs);
            
            min = Math.min(min, cost + backtrack(price, special, tempNeeds, dp));
        }
        
        dp.put(needs.toString(), min);        
        return min;
        
    }
    
    private boolean isComplete(List<Integer> needs) {
        
        for(int i = 0; i < needs.size(); i++) {
            if(needs.get(i) != 0) {
                return false;
            }
        }
        
        return true;
    }
    
    private List<Integer> newNeeds(List<Integer> special, List<Integer> needs) {
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < needs.size(); i++) {
            res.add(needs.get(i) - special.get(i));
        }
        
        return res;
    }
    
    private boolean isValid(List<Integer> special, List<Integer> needs) {
        
      for(int i = 0; i < needs.size(); i++) {
            if (needs.get(i) - special.get(i) < 0 ) {
                return false;
            }
        }
        
        return true;
        
    }
    
    private int directPurchase(List<Integer> price, List<Integer> needs) {
        int res = 0;
        
        for(int i = 0; i < needs.size(); i++) {
            res+= needs.get(i)*price.get(i);
        }
        
        return res;
    }
}
