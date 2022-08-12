class Solution {
    public int maxProduct(String[] words) {
        List<Integer> list=new ArrayList<>();
		int len=0;
		for(int i=0;i<words.length;i++)
		{
			int state=0;
			for(int j=0;j<words[i].length();j++)
				state|=1<<words[i].charAt(j)-'a';
			list.add(state);
			for(int j=0;j<i;j++)
			{
				if((list.get(j)&list.get(i))==0)
					if(words[i].length()*words[j].length()>len)
						len=words[i].length()*words[j].length();
			}
		}
		return len;
    }
}
