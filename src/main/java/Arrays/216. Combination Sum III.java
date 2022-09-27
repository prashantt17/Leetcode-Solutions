class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
         List<List<Integer>> list = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        int f = n;  
        rec(k,n,f,1,list,ds);
        return list;
    }
    public void rec(int k,int n,int f,int index,List<List<Integer>>list,List<Integer>ds){
        
        if(ds.size()==k){
            int sum = 0;
            for(int i = 0;i<ds.size();i++){
                sum+=ds.get(i);
            }
            if(sum==f){
                list.add(new ArrayList<>(ds));
            }
            return;
        }
        
        if(index<=n&&index<10){
            ds.add(index);
            rec(k,n-index,f,index+1,list,ds); 
            ds.remove(ds.size()-1);
            rec(k,n,f,index+1,list,ds); 
        }
    }
}
