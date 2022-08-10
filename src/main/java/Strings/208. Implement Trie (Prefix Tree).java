class Trie {

    static class Node {
        Map<Character, Node> map;
        Boolean isEnd;
        Node() {
            map = new HashMap<>();
            isEnd = false;
        }
    }
    
    Node root;
    
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(char ch : word.toCharArray()) {
            if(!node.map.containsKey(ch)) {
                node.map.put(ch, new Node());
            }
            node = node.map.get(ch);
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (!node.map.containsKey(ch)) {
                return false;
            }
            node = node.map.get(ch);
        }
        return node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for (char ch : prefix.toCharArray()) {
            if (!node.map.containsKey(ch)) {
                return false;
            }
            node = node.map.get(ch);
        }
        return true;
}
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
