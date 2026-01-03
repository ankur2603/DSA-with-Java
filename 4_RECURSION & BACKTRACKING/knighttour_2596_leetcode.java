Link : https://leetcode.com/problems/check-knight-tour-configuration/description/

class Solution {

    // keeps track of the next move number we are expecting
    public int move = 1;

    // checks if (r, c) is inside the board and matches the expected move value
    public boolean isValid(int grid[][], int r, int c, int val){

        int n = grid.length;

        // out of bounds or not the required next number
        if(r < 0 || c < 0 || r >= n || c >= n || grid[r][c] != val) 
            return false;

        return true;
    }

    public boolean checkValidGrid(int[][] grid){

        int n = grid.length;

        // knight always starts from top-left
        int r = 0;
        int c = 0;

        // starting cell must be 0
        if(grid[r][c] != 0) return false;
        
        while(true){

            // if we have successfully validated all n*n cells
            if(move == n*n) return true;

            else if(isValid(grid, r-2, c-1, move)){ // 2 up, 1 left
                r = r-2;
                c = c-1;
                move++;
                continue;
            }
            else if(isValid(grid, r-2, c+1, move)){ // 2 up, 1 right
                r = r-2;
                c = c+1;
                move++;
                continue;
            }

            else if(isValid(grid, r+2, c-1, move)){ // 2 down, 1 left
                r = r+2;
                c = c-1;
                move++;
                continue;
            }
            else if(isValid(grid, r+2, c+1, move)){ // 2 down, 1 right
                r = r+2;
                c = c+1;
                move++;
                continue;
            }

            else if(isValid(grid, r-1, c-2, move)){ // 1 up, 2 left
                r = r-1;
                c = c-2;
                move++;
                continue;
            }
            else if(isValid(grid, r+1, c-2, move)){ // 1 down, 2 left
                r = r+1;
                c = c-2;
                move++;
                continue;
            }

            else if(isValid(grid, r-1, c+2, move)){ // 1 up, 2 right
                r = r-1;
                c = c+2;
                move++;
                continue;
            }
            else if(isValid(grid, r+1, c+2, move)){ // 1 down, 2 right
                r = r+1;
                c = c+2;
                move++;
                continue;
            }

            // no valid knight move found for the next number
            else return false;
        }
    }
}
