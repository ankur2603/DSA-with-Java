Link : https://leetcode.com/problems/trapping-rain-water/description/

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int store=0;
        int lmax[] = new int[n];//Auxillary arrays or helper arrays
        int rmax[] = new int[n];
        for(int i = n-1;i >= 0;i--){//for maximum right
            int self = height[i];
            if(i == n-1){
                rmax[i] = self;
            }
            else{
                rmax[i] = self > rmax[i+1] ? self : rmax[i+1];
            }
        }
        for(int i = 0;i < n ;i++){// for maximum left 
            int self = height[i];
            if(i == 0){
                lmax[i] = self;
            }
            else{
                lmax[i] = self > lmax[i-1] ? self : lmax[i-1];
            }
        }
        for(int i = 0;i < n;i++){
            int temp=0;
            int a = lmax[i];
            int b = rmax[i];
            if(a > b){
                temp = b - height[i];
            }
            else{
                temp = a - height[i];
            }
            if(temp > 0){
                store += temp;
            }
        }
        return store;
    }
}
