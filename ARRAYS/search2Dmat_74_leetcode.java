Link : https://leetcode.com/problems/search-a-2d-matrix/description/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int imax = matrix.length-1;
        int jmax = matrix[0].length-1;
        int i = imax;
        int j = 0;
        int curr = 0;
        while(i >= 0 && j <= jmax){
            curr = matrix[i][j];
            if(curr == target){
                return true;
            }
            else if(curr < target){
                j++;
            }
            else{
                i--;
            }
        }
        return false;
    }
}
