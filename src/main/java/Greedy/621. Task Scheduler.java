class Solution {
    public int leastInterval(char[] tasks, int n) {
        int coolDown[]=new int[26];
        int freq[]=new int[26];
        for(int i=0;i<task.length;i++) {
            freq[task[i]-'A']++;
        }
        int i=0;
        int t=0;
        int prev=0;
        while(i<task.length) {
            int min=Integer.MAX_VALUE;
            int idx=-1;
            for(int j=0;j<26;j++) {
                if(freq[j]==0) continue;
                if(min>coolDown[j]) {
                    min=coolDown[j];
                    idx=j;
                }else if(min==coolDown[j]) {
                    if(freq[idx]<freq[j]) {
                        min=coolDown[j];
                        idx=j;
                    }
                }
            }
            
            prev=t;
            t+=(coolDown[idx])+1;
            freq[idx]--;
            if(freq[idx]>0) 
                coolDown[idx]=n;
            else coolDown[idx]=0;
            int timeElapsed=t-prev;
            
            for(int j=0;j<26;j++) {
                if(freq[j]==0 || j==idx) continue;
                
                
                coolDown[j]-=timeElapsed;
                if(coolDown[j]<0) coolDown[j]=0;
            }
            
            i++;
        }
        return t;
    }
}
