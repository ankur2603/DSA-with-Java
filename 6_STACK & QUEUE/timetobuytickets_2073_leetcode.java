Link : https://leetcode.com/problems/time-needed-to-buy-tickets/submissions/1880955966/

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        int target = tickets[k];  // tickets person k needs

        for(int i = 0; i < tickets.length; i++){
            if(i <= k){
                // people before or at k can buy up to their tickets or target tickets
                time += Math.min(tickets[i], target);
            } else {
                // people after k buy at most target-1 tickets, because we stop after k finishes
                time += Math.min(tickets[i], target - 1);
            }
        }

        return time;
    }
}
