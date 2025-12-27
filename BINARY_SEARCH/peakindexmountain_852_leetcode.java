Link : https://leetcode.com/problems/peak-index-in-a-mountain-array/description/

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        int mid = 0;
        int i = 0;
        int max = Integer.MIN_VALUE;
        while( start <= end){
            mid = start + (end-start)/2;
            if(max <= arr[mid]){
                max = arr[mid];
                i = mid;
            }
            if(arr[mid] >= arr[mid+1]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return i;
    }
}
