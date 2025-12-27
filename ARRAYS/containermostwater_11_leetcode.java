Link : https://leetcode.com/problems/container-with-most-water/description/

class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int area = 0; 
        int max = Integer.MIN_VALUE;
        while(l != r){
            area = Math.min(height[l] , height[r]) * (r - l);
            if(area > max){
                max = area;
            }
            if(height[l] < height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return max;
    }
}
