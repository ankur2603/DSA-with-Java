Link : https://leetcode.com/problems/set-matrix-zeroes/description/

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean rflag[] = new boolean[m];
        boolean cflag[] = new boolean[n];

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(matrix[i][j] == 0){
                    rflag[i] = true;
                    cflag[j] = true;
                }
            }
        }

        for(int i = 0;i < m;i++){
            if(rflag[i] == true){
                for(int j = 0;j < n;j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j = 0;j < n;j++){
            if(cflag[j] == true){
                for(int i = 0;i < m;i++){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
