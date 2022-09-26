class RandomizedCollection {

    Map<Integer, Set<Integer>> map;
List<Integer> list;
Random random;

public RandomizedCollection() {
    this.map = new HashMap<Integer, Set<Integer>>();
	this.list = new ArrayList<Integer>();
	this.random = new Random();
}

public boolean insert(int val) {
    if(!map.containsKey(val)) {
    	map.put(val, new HashSet<Integer>());
    }
    map.get(val).add(list.size());
    list.add(val);
    return map.get(val).size() == 1;
}

public boolean remove(int val) {
    if(!map.containsKey(val)) {
    	return false;
    }
    
    Integer removeIndex = map.get(val).iterator().next();
    
    map.get(val).remove(removeIndex);
    
    int lastIndex = list.size()-1;
    int lastElement = list.get(lastIndex);
    
    list.set(removeIndex, lastElement);
    
    map.get(lastElement).add(removeIndex);
    map.get(lastElement).remove(lastIndex);
    
    list.remove(lastIndex);
    
    if(map.get(val).size() == 0) {
    	map.remove(val);
    }
    return true;
}

public int getRandom() {
   int index = random.nextInt(list.size());
   return list.get(index);
        
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
