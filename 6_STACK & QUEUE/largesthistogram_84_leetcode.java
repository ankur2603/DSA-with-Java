Link : https://leetcode.com/problems/largest-rectangle-in-histogram/description/

class Solution {
    public int largestRectangleArea(int[] arr) {

        Stack<Integer> s = new Stack<>();
        int rsmaller[] = new int[arr.length];

        // find next smaller element on the right
        for (int i = arr.length - 1; i >= 0; i--) {

            // pop until a smaller bar is found
            while (!s.empty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            // if none found, boundary is end of array
            rsmaller[i] = s.empty() ? arr.length : s.peek();
            s.push(i);
        }

        Stack<Integer> t = new Stack<>();
        int lsmaller[] = new int[arr.length];

        // find next smaller element on the left
        for (int i = 0; i < arr.length; i++) {

            // pop taller bars
            while (!t.empty() && arr[t.peek()] >= arr[i]) {
                t.pop();
            }

            // if none found, boundary is before start
            lsmaller[i] = t.empty() ? -1 : t.peek();
            t.push(i);
        }

        int maxarea = 0;

        // calculate max area using width and height
        for (int i = 0; i < arr.length; i++) {
            int width = rsmaller[i] - lsmaller[i] - 1;
            maxarea = Math.max(maxarea, width * arr[i]);
        }

        return maxarea;
    }
}
