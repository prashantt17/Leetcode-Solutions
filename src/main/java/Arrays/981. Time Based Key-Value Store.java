class pair{
int x;
String y;
pair(int x1,String y1){
    x=x1;
    y=y1;
}
}

  class TimeMap {
    Map<String,List<pair>> m;
    Map<Integer,String> m1;
public TimeMap() {
    m=new HashMap<>();
    m1=new HashMap<>();
}

public void set(String key, String val, int time) {
    if(!m.containsKey(key)){
        m.put(key,new ArrayList<>());
    }
    m.get(key).add(new pair(time,val));
    m1.put(time,val);
}

public String get(String key, int time) {
    if(!m.containsKey(key))return "";
    List<pair> l=m.get(key);
    
    int ind=upperbound(l,time);
    
    if(ind==-1)return "";
    return m1.get(ind);
}
public int upperbound(List<pair> l,int x1){
    int i=0;
    int j=l.size()-1;
    int ans=-1;
    while(i<=j){
        int mid=(i+j)/2;
        if(l.get(mid).x<=x1){
            ans=mid;
            i=mid+1;
        }
        else j=mid-1;
    }
    if(ans==-1)return -1;
    return l.get(ans).x;
}
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
