Link : https://leetcode.com/problems/first-unique-character-in-a-string/description/

class Solution {
    public int firstUniqChar(String s) {

        int freq[] = new int[26];            // count of each character
        Queue<Integer> q = new LinkedList<>(); // store indices of characters

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            freq[ch - 'a']++;   // update count
            q.add(i);           // keep index in order

            // remove all non-unique chars from front
            while (!q.isEmpty() && freq[s.charAt(q.peek()) - 'a'] > 1) {
                q.remove();
            }
        }

        // if queue is empty, no unique character
        return q.isEmpty() ? -1 : q.peek();
    }
}
