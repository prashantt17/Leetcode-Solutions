class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int e: asteroids){
            if(st.isEmpty())
                st.push(e);
            else if(st.peek()<0 && (e<0 || e>0))
                st.push(e);
            else if(st.peek()>0 && e>0)
                st.push(e);
            else if(st.peek()>0 && e<0){
                if(st.peek()==(e*-1))
                    st.pop();
                else if(st.peek()>(e*-1))
                    continue;
                else if(st.peek()<(e*-1)){
                    while(!st.isEmpty() && st.peek()>0 && (st.peek()<(e*-1)))
                        st.pop();
                    if(!st.isEmpty() && st.peek()==(e*-1))
                        st.pop();
                    else if(!st.isEmpty() && st.peek()>(e*-1))
                        continue;
                    else
                        st.push(e);
                }
            }
        }
        int[] res=new int[st.size()];
        int i=st.size()-1;
        while(!st.isEmpty())
            res[i--]=st.pop();
        return res;
    }
}
