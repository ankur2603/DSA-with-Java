Link : https://leetcode.com/problems/valid-parentheses/description/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> store = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (curr == '(' || curr == '{' || curr == '[') {
                store.push(curr);
                continue;
            }

            if (store.isEmpty()) return false; // closing bracket without opening

            char top = store.peek();
            if ((top == '(' && curr == ')') ||
                (top == '{' && curr == '}') ||
                (top == '[' && curr == ']')) {
                store.pop();
            } else {
                return false; // mismatch
            }
        }

        return store.isEmpty(); // true if all matched
    }
}
