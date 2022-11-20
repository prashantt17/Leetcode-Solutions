class Solution {
    public String validIPAddress(String queryIP) {
         boolean ipv4 = true;
        String[] query;
        if(queryIP==null)
            return "Neither";
        if(queryIP.contains("."))
            query = queryIP.split("\\.", -1);
        else
        {
            query = queryIP.split(":", -1);
            ipv4 = false;
        }
        if(ipv4)
        {
            if(query.length!=4)
                return "Neither";
            for(String x : query)
            {
                int x_int;
                try{
                    x_int = Integer.parseInt(x);
                }catch(NumberFormatException e)
                {
                    return "Neither";
                }
                if(x_int<0 || x_int>255 || !x.equals(String.valueOf(x_int)))
                    return "Neither";
            }
            return "IPv4";
        }
        else
        {
            if(query.length!=8)
                return "Neither";
            for(String x : query)
            {
                if(x.length()<1 || x.length()>4)
                    return "Neither";
                for(int j=0; j<x.length(); j++)
                {
                    char c = x.charAt(j);
                    if((c > 'f' && c <= 'z') || (c > 'F' && c <= 'Z'))
                        return "Neither";
                }
            }
            return "IPv6";
        }
    }
}
