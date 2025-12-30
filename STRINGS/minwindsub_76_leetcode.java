Link : https://leetcode.com/problems/minimum-window-substring/description/

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        int[] freqt = new int[128];   // frequency of characters in t
        int[] window = new int[128];  // frequency in current window

        for (int i = 0; i < t.length(); i++) {
            freqt[t.charAt(i)]++;
        }

        int l = 0, r = 0;             // window pointers
        int minLen = Integer.MAX_VALUE;
        int start = 0;                 // start index of min window
        int required = t.length();     // total characters still needed

        while (r < s.length()) {
            char c = s.charAt(r);
            window[c]++;

            // Only decrease required if this character is needed
            if (window[c] <= freqt[c]) {
                required--;
            }

            r++; // expand window

            // When window contains all characters, try to shrink from left
            while (required == 0) {
                if (r - l < minLen) {
                    minLen = r - l;
                    start = l;
                }

                char leftChar = s.charAt(l);
                window[leftChar]--;

                // If removing leftChar breaks the validity, increase required
                if (window[leftChar] < freqt[leftChar]) {
                    required++;
                }

                l++; // shrink window
            }
        }

        if (minLen == Integer.MAX_VALUE) return "";
        return s.substring(start, start + minLen);
    }
}
