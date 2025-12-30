Link : https://leetcode.com/problems/longest-happy-prefix/description/

class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n];

        int len = 0;
        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;                 // move forward only on match
            } else {
                if (len > 0) {
                    len = lps[len - 1];  // magical line
                } else {
                    lps[i] = 0;
                    i++;                 // move forward only here
                }
            }
        }

        return s.substring(0, lps[n - 1]);
    }
}
