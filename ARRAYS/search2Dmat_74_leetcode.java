Link : https://leetcode.com/problems/search-a-2d-matrix/description/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) { // search in a 2D sorted matrix
        
        int imax = matrix.length-1;
        int jmax = matrix[0].length-1;
        
        int i = imax;
        int j = 0;
        int curr = 0; // we start our search from bottom left and proceed towards top right ie STAIRCASE METHOD
        
        while(i >= 0 && j <= jmax){
            
            curr = matrix[i][j];
            
            if(curr == target) return true; // favourable case
                
            else if(curr < target) j++; // move towards left to find a greater value than curr
                
            else i--; // move upwards to find a smaller value than curr
            
        }
        return false;
    }
}
