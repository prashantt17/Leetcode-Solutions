class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end))
            return 0;
        
        HashSet<String> bankSet = new HashSet<>();
        for(String mutation : bank)
            bankSet.add(mutation);
        
        if(bankSet.contains(end) == false)
            return -1;
        
        char[] array = new char[]{'A', 'C', 'G', 'T'}; 
        
        Queue<String> q = new LinkedList<>();
        
        int level = 0;
        
        Set<String> visited = new HashSet<>();
        q.offer(start);
        visited.add(start);
        
        
        while(!q.isEmpty()){
            int size = q.size();
            level += 1;
            while(size != 0){
                
                String mutation = q.poll();
                char[] currMutation = mutation.toCharArray();
                
                for(int i = 0; i<currMutation.length; i++){
                    for(int j = 0; j<array.length; j++){
                        if(currMutation[i] == array[j])
                            continue;
                        currMutation[i] = array[j];
                        String possibleMutation = new String(currMutation);
                        if(possibleMutation.equals(end))
                            return level;
                        if(bankSet.contains(possibleMutation) && !visited.contains(possibleMutation)){
                            q.offer(possibleMutation);
                        }
                        currMutation[i] = mutation.charAt(i);
                    }
                }
                size--;
            }
        }
        
        return -1;
    }
}
