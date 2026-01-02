Link : https://leetcode.com/problems/sudoku-solver/description/

class Solution {

    public static boolean isSafe(char board[][], int row, int col, char digit){

        // check for col
        for(int i=0 ; i<9 ; i++){
            if(board[i][col] == digit) return false;
        }

        // check for row
        for(int j=0 ; j<9 ; j++){
            if(board[row][j] == digit) return false;
        }

        // check for grid
        int strow = (row/3) * 3;
        int stcol = (col/3) * 3;

        for(int i=strow ; i<strow+3 ; i++){
            for(int j=stcol ; j<stcol+3 ;j++){
                if(board[i][j] == digit) return false;
            }
        }

        return true;
    }

    public static boolean solver(char board[][], int row, int col){

        if(row == 9) return true;

        int nextrow = row;
        int nextcol = col+1;

        if(col+1 == 9 ){
            nextrow = row+1;
            nextcol = 0;
        }

        if(board[row][col] != '.'){
            return solver(board, nextrow, nextcol);
        }

        for(int digit=1 ; digit<=9 ; digit++){

            char ch = (char) (digit + '0');

            if(isSafe(board, row, col, ch)){

                board[row][col] = ch;

                if(solver(board, nextrow, nextcol)){ // solution exists
                    return true;
                }

                board[row][col] = '.';
            }
        }

        return false;

    }
    public void solveSudoku(char[][] board) {
        boolean status = solver(board, 0, 0);
    }
}
