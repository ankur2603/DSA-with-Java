Link : https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character, Integer>map = new HashMap<>();

        int start = 0;
        int maxLen = 0;

        for(int i = 0;i < s.length();i++){

            char c = s.charAt(i);

            if (map.containsKey(c)){ // if value repeats then window is shrinked
                start = Math.max(start, map.get(c)+1); // math.max is use here to tackle edge cases like "abba" dry run this 
            }                                          // and compare this with other cases u'll understand

            map.put(c, i); // placing the values in the map 
            maxLen = Math.max(maxLen, i-start+1); // simply keeping a track of maximum length
        }
        return maxLen;
    }
}
