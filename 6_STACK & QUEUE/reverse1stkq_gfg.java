Link : https://www.geeksforgeeks.org/problems/reverse-first-k-elements-of-queue/1

import java.util.*;

class Solution {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {

        Stack<Integer> s = new Stack<>();
        int size = q.size();

        // if k is larger than queue size, nothing to reverse
        if (size < k) return q;

        // take first k elements and push into stack
        for (int i = 0; i < k; i++) {
            s.push(q.remove());
        }

        // put them back into queue (this reverses them)
        while (!s.isEmpty()) {
            q.add(s.pop());
        }

        // move remaining elements to the back to keep order
        for (int i = 0; i < size - k; i++) {
            q.add(q.remove());
        }

        return q;
    }
}
