Link : https://leetcode.com/problems/next-greater-element-ii/description/

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        Stack<Integer> s = new Stack<>();
        int n = nums.length;
        int nextGreater[] = new int[n];

        // traverse from right twice to handle circular nature
        for(int i = 2*n - 1; i >= 0; i--){

            // remove all elements smaller than or equal to current
            while(!s.empty() && nums[s.peek()] <= nums[i % n]){
                s.pop();
            }

            // if stack is empty, no greater element exists
            if(s.empty()){
                nextGreater[i % n] = -1;
            }
            else{
                // top of stack is the next greater element
                nextGreater[i % n] = nums[s.peek()];
            }

            // push current index for future elements
            s.push(i % n);
        }

        return nextGreater;
    }
}
