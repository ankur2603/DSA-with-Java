Link : https://leetcode.com/problems/permutation-in-string/description/

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        int freq1[] = new int[26];
        int freq2[] = new int[26];

        // freq of s1
        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
        }

        int windsize = s1.length();

        // first window
        for (int i = 0; i < windsize; i++) {
            freq2[s2.charAt(i) - 'a']++;
        }

        if (isFreqSame(freq1, freq2)) return true;

        // slide window
        for (int i = windsize; i < s2.length(); i++) {
            freq2[s2.charAt(i) - 'a']++;
            freq2[s2.charAt(i - windsize) - 'a']--;

            if (isFreqSame(freq1, freq2)) return true;
        }

        return false;
    }

    boolean isFreqSame(int freq1[], int freq2[]) {
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) return false;
        }
        return true;
    }
}
