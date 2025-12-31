Link : https://leetcode.com/problems/merge-intervals/description/

class Solution {
    public int[][] merge(int[][] intervals) {

        // Sort intervals by starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // This list will store the merged intervals
        List<int[]> res = new ArrayList<>();

        // Add the first interval as the starting reference
        res.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++){

            int[] last = res.get(res.size() - 1);

            int[] curr = intervals[i];

            // If intervals overlap (or touch)
            if(last[1] >= curr[0]){
                // Merge by extending the end time
                last[1] = Math.max(last[1], curr[1]);
            }
                
            else {
                // No overlap → add as a new interval
                res.add(curr);
            }
        }

        // Convert List<int[]> to int[][]
        return res.toArray(new int[res.size()][]);
    }
}
