class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
         set = new HashSet<>();
        set.add(0);
        solve(rooms,0);
        return set.size()==rooms.size();
    }
    static Set<Integer> set = null;
    static boolean solve(List<List<Integer>> roomsKeys, int index){
        if(set.size()==roomsKeys.size()) return true;
        if(!set.contains(index)) return false;
        boolean flag = true;
        for(int key: roomsKeys.get(index)){
            if(!set.contains(key)){
                set.add(key);
                flag = flag && solve(roomsKeys, key);
            }
        }
        return flag;
    }
}
