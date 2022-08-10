class Node {
    HashMap<Character, Node> children = new HashMap<>();
    boolean isWord = false;
}

class WordDictionary {
    private Node root;

    public WordDictionary() {
        this.root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = this.root;
        for (char c: word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new Node());
            }
            curr = curr.children.get(c);
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        return search(word, 0, this.root);
    }
    
    private boolean search(String str, int index, Node node) {
        Node curr = node;
        for (int i = index; i < str.length() ; i++) {
            if (str.charAt(i) == '.') {
                for (Node child: curr.children.values()) {
                    if (search(str, i+1, child)) return true;
                }
                return false;
            } else {
                if (!curr.children.containsKey(str.charAt(i))) {
                    return false;
                } 
                curr = curr.children.get(str.charAt(i));
            }
        }
        return curr.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
