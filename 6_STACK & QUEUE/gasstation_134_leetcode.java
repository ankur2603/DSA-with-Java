Link : https://leetcode.com/problems/gas-station/description/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int tgas = 0;    // total gas available
        int tcost = 0;   // total cost needed
        int n = gas.length;

        // check if completing the circuit is even possible
        for(int i = 0; i < n; i++){
            tgas += gas[i];
            tcost += cost[i];
        }

        // if total gas is less than total cost, no solution exists
        if(tgas < tcost) return -1;

        int currgas = 0; // gas in tank while moving
        int start = 0;   // current candidate starting index

        // try to find the valid starting point
        for(int i = 0; i < n; i++){
            currgas = currgas + gas[i] - cost[i];

            // if we run out of gas, this start won't work
            if(currgas < 0){
                start = i + 1;   // next station becomes new start
                currgas = 0;     // reset tank
            }
        }

        return start;
    }
}
