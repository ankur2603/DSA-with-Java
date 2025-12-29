Link : https://www.spoj.com/problems/AGGRCOW/

import java.util.*;

class aggrcow {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // number of test cases

        while (t-- > 0) {
            int n = sc.nextInt();    // number of stalls
            int cows = sc.nextInt(); // number of cows
            int[] stalls = new int[n];

            // Read stall positions
            for (int i = 0; i < n; i++) {
                stalls[i] = sc.nextInt();
            }

            // Call the function to find largest minimum distance
            System.out.println(largestMinDist(stalls, n, cows));
        }

        sc.close();
    }
    static int largestMinDist(int stalls[], int n, int cows){
        
        Arrays.sort(stalls);

        int min = stalls[0];
        int max = stalls[n - 1];

        int start = 0;
        int end  = max-min;
        int mid = 0;
        int ans = 0;

        while(start <= end){

            mid = start + (end - start)/2;

            if(ispossible(mid, stalls, cows)){
                ans = mid;
                start = mid + 1;
            }
            else{
                end = mid -1 ;
            }
        }
        return ans;
    }

    static boolean ispossible(int mid, int stalls[], int cows){
        int lastpos = stalls[0];
        int count = 1;
        int n = stalls.length;

        for (int i = 1; i < n; i++) {
            if(stalls[i] - lastpos >= mid ){
                count++;
                lastpos = stalls[i];
            }
        }

        if(count >= cows){
            return true;
        }
        else{
            return false;
        }
    }
}
