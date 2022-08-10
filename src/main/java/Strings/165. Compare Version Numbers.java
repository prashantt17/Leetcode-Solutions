class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("[.]");
        String[] v2 = version2.split("[.]");
        for(int i=0;i<v1.length&&i<v2.length;i++){
            if(Integer.valueOf(v1[i])>Integer.valueOf(v2[i])){
                return 1;
            }else if(Integer.valueOf(v1[i])<Integer.valueOf(v2[i])){
                return -1;
            }
        }
        if(v1.length>v2.length){
            for(int i=v2.length;i<v1.length;i++){
                if(Integer.valueOf(v1[i])>0){
                    return 1;
                }
            }
        }
        if(v1.length<v2.length){
            for(int i=v1.length;i<v2.length;i++){
                if(Integer.valueOf(v2[i])>0){
                    return -1;
                }
            }
        }
        return 0;
    }
}
