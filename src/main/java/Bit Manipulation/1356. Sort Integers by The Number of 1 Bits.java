class Solution {
    public int[] sortByBits(int[] arr) {
        Map<Integer,List<Integer>> map=new HashMap();
        Arrays.sort(arr);            
        for(int i=0;i<arr.length;++i){
            String temp=Integer.toBinaryString(arr[i]);
            temp=temp.replace("0","");
            int count = temp.length();
            if(map.containsKey(count)){
                List<Integer> list=map.get(count);
                list.add(arr[i]);
                map.put(count,list);
            }
            else{
                List<Integer> list=new ArrayList();
                list.add(arr[i]);
                map.put(count,list);
            }
        }
        int idx=0;
        for(int key:map.keySet()){            
           for(int val:map.get(key))
               arr[idx++]=val;
        }
        return arr;
    }
}
