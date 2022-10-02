class Solution {
  public int strStr(String haystack, String needle) {
    haystack = haystack.replaceAll(needle, "-");
    for (int i = 0; i < haystack.length(); i++) {
      if (haystack.charAt(i) == '-')
        return i;
    }
    return -1;
  }
}
