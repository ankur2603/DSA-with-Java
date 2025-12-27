Link : https://leetcode.com/problems/valid-anagram/description/

class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(m != n){
            return false;
        }
        else{
            int map1[] = new int[26];
            for(int i = 0;i < n;i++){
                map1[s.charAt(i) - 'a']++;
                map1[t.charAt(i) - 'a']--;
            }
            for(int i = 0;i < 26;i++){
                if(map1[i] != 0){
                    return false;
                }
            }
            return true;
        }
    }
}
