Link : https://leetcode.com/problems/find-missing-and-repeated-values/description/

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int size=n*n+1;
        int arr[]=new int[size];
        int ans[]=new int[2];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[grid[i][j]]++;
            }
        }
        for(int i=1;i<size;i++){
            if(ans[0]!=0 && ans[1]!=0){
                break;
            }
            if(arr[i]==0){
                ans[1]=i;
            }
            if(arr[i]>1){
                ans[0]=i;
            }
        }
        return ans;
    }
}
