Link : https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

import java.util.*;

class Solution {

    // Recursive backtracking function to explore all paths
    public static void allways(int[][] maze, String s, int r, int c, int row, int col, List<String> ans) {

        // invalid cell: out of bounds, blocked, or already visited
        if (r < 0 || c < 0 || r > row || c > col || maze[r][c] == 0 || maze[r][c] == -1) {
            return;
        }

        // mark current cell as visited
        maze[r][c] = -1;

        // reached destination
        if (r == row && c == col) {
            ans.add(s);        // store the current path
            maze[r][c] = 1;    // backtrack: unmark
            return;
        }

        // explore all directions in lexicographical order: D < L < R < U
        allways(maze, s + "D", r + 1, c, row, col, ans); // down
        allways(maze, s + "L", r, c - 1, row, col, ans); // left
        allways(maze, s + "R", r, c + 1, row, col, ans); // right
        allways(maze, s + "U", r - 1, c, row, col, ans); // up

        // unmark current cell before returning to allow other paths
        maze[r][c] = 1;
    }

    public ArrayList<String> ratInMaze(int[][] maze) {

        List<String> temp = new ArrayList<>();  // store all paths
        int n = maze.length;

        // if start cell is blocked, return empty
        if (maze[0][0] == 0) return new ArrayList<>();

        // start recursive exploration from top-left
        allways(maze, "", 0, 0, n - 1, n - 1, temp);

        // convert to ArrayList and sort lexicographically
        ArrayList<String> result = new ArrayList<>(temp);
        Collections.sort(result);   // ensures lexicographical order

        return result;
    }
}
