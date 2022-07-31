/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"

*/

class Solution {
    public String decodeString(String s) {
        
        int n = s.length();
        Stack<Integer> numStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int h = 0;
            while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                h = h * 10 + (s.charAt(i) - '0');
                i++;
            }
            if (h == 0) {
                res.append(s.charAt(i));
                continue;
            }
            i++;
            numStack.push(h);
            indexStack.push(i);
            strStack.push(new StringBuilder());
            
            while (!numStack.isEmpty()) {
                int index = indexStack.pop();
                int num = numStack.pop();
                StringBuilder str = strStack.pop();
                
                for (int j = index; j < n; j++) {
                    char c = s.charAt(j);
                    if (c == ']') {
                        if (numStack.isEmpty()) {
                            res.append(str.toString().repeat(num));
                            i = j;
                        }
                        else {
                            indexStack.pop();
                            StringBuilder rStr = strStack.pop();
                            indexStack.push(j + 1);
                            strStack.push(rStr.append(str.toString().repeat(num)));
                        }
                        break;
                    }
                    else if (c >= '0' && c <= '9') {
                        numStack.push(num);
                        indexStack.push(j);
                        strStack.push(str);
                        
                        int l = 0;
                        while (j < n 
                               && s.charAt(j) >= '0' 
                               && s.charAt(j) <= '9'
                        ) {
                            l = l * 10 + (s.charAt(j) - '0');
                            j++;
                        }
                        j++;
                        numStack.push(l);
                        indexStack.push(j);
                        strStack.push(new StringBuilder());
                        break;
                    }
                    else {
                        str.append(c);
                    }
                }
                
            }
        }
        return res.toString();
    }
}

