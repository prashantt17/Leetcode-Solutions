class Solution {
    int[] parent = new int[26];
    int[] size = new int[26];
    public boolean equationsPossible(String[] equations) {
         for(int i = 0; i < 26; i++){
            size[i] = 1;
            parent[i] = i;
        }
        for(String s: equations){
            if(s.charAt(1) == '='){
                int a = s.charAt(0) - 'a';
                int b = s.charAt(3) - 'a';
                connect(a, b);
            }
        }
         for(String s : equations){
            if(s.charAt(1) == '!'){
                int a = s.charAt(0) - 'a';
                int b = s.charAt(3) - 'a';
                if(checkConnection(a, b)) return false;
            }
        }
        return true;
    }
    public void connect(int a, int b){
        int roota = findRoot(a);
        int rootb = findRoot(b);
        if(roota == rootb) return;
        if(size[roota] >= size[rootb]){
            parent[rootb] = roota;
            size[roota] += size[rootb];
        }else{
            parent[roota] = rootb;
            size[rootb] += size[roota];
        }
    }
    public int findRoot(int a){
        while(parent[a] != a){
            parent[a] = parent[parent[a]];
            a = parent[a];
        }
        return a;
    }
    public boolean checkConnection(int a, int b){
        int roota = findRoot(a);
        int rootb = findRoot(b);
        if(roota == rootb) return true;
        return false;
    }
}
