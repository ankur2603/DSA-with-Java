Link : https://leetcode.com/problems/set-matrix-zeroes/description/

class Solution {
    public void setZeroes(int[][] matrix) {
        
        int m = matrix.length; // number of rows
        int n = matrix[0].length; // number of cols
        
        boolean rflag[] = new boolean[m]; // used to store which row has zero
        boolean cflag[] = new boolean[n]; // used to store which col has zero

        for(int i = 0;i < m;i++){ // search for zeroes
            for(int j = 0;j < n;j++){
                if(matrix[i][j] == 0){ // if zero found -> true
                    rflag[i] = true;
                    cflag[j] = true;
                }
            }
        }

        for(int i = 0;i < m;i++){ 
            if(rflag[i] == true){
                for(int j = 0;j < n;j++){ // fill entire col with zero
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j = 0;j < n;j++){
            if(cflag[j] == true){
                for(int i = 0;i < m;i++){ // fill entire row with zero
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
