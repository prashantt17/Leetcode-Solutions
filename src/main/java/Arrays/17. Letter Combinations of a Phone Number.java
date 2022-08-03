class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

    List<List<String>> input = new ArrayList<>();
    for(char c: digits.toCharArray())
      input.add(getCharList(c));
    
    if(input.isEmpty())
      return ans;
    
    List<String> prev = input.get(0);
    for(int i=1;i<input.size();i++){
      List<String> curr = input.get(i);
      prev = getAllCombinations(prev, curr);
    }
    
    return prev;
  }

  private List<String> getAllCombinations(List<String> l1, List<String> l2){
    List<String> res = new ArrayList<>();
    for(String s1: l1){
      var list = appendChar(s1, l2);
      res.addAll(list);
    }
    return res;
  }
  
  private List<String> appendChar(String c, List<String> list){
    List<String> res = new ArrayList<>();
    for(String s: list)
      res.add(c + s);  
    
    return res;
  }
  
  private List<String> getCharList(char c){
    if(c ==  '2')
      return List.of("a","b","c");
    else if(c == '3')
      return List.of("d","e","f");
    else if(c == '4')
      return List.of("g","h","i");
    else if(c == '5')
      return List.of("j","k","l");
    else if(c == '6')
      return List.of("m","n","o");
    else if(c == '7')
      return List.of("p","q","r", "s");
    else if(c == '8')
      return List.of("t","u","v");
    else if(c == '9')
      return List.of("w","x","y","z");

    return null;
  }
}
