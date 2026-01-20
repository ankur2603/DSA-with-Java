Link : https://leetcode.com/problems/longest-common-prefix/description/

class Solution {

    class Node {
        Node child[] = new Node[26];
        boolean eow;
        int freq;

        public Node() {
            for (int i = 0; i < child.length; i++) {
                child[i] = null;
            }
            freq = 0;
        }
    }

    public Node root = new Node();

    // insert a word into the trie
    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.child[idx] == null) {
                curr.child[idx] = new Node();
            }
            curr = curr.child[idx];
            curr.freq++; // increase frequency for this path
        }
        curr.eow = true; // mark end of word
    }

    // recursively find longest common prefix
    private String findLCP(Node root, String prefix) {
        if (root == null) return prefix;

        int count = 0;
        int nextIdx = -1;

        // count how many non-null children
        for (int i = 0; i < 26; i++) {
            if (root.child[i] != null) {
                count++;
                nextIdx = i;
            }
        }

        // stop if more than one child or end of a word
        if (count != 1 || root.eow) return prefix;

        // continue down the single path
        return findLCP(root.child[nextIdx], prefix + (char)(nextIdx + 'a'));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        // insert all words
        for (String s : strs) {
            insert(s);
        }

        // find LCP starting from root
        return findLCP(root, "");
    }
}
