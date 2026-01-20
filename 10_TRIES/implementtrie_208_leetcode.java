Link : https://leetcode.com/problems/implement-trie-prefix-tree/description/

class Trie {

    // Trie node structure
    static class Node {
        Node[] children = new Node[26]; // links for 'a' to 'z'
        boolean isEnd;                  // true if a word ends here
    }

    Node root; // root of the trie (non-static)

    // initialize a fresh trie
    public Trie() {
        root = new Node();
    }

    // inserts a word into the trie
    public void insert(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true; // mark end of word
    }

    // checks if a complete word exists
    public boolean search(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) return false;
            curr = curr.children[idx];
        }
        return curr.isEnd;
    }

    // checks if any word starts with given prefix
    public boolean startsWith(String prefix) {
        Node curr = root;

        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';

            if (curr.children[idx] == null) return false;
            curr = curr.children[idx];
        }
        return true;
    }
}
