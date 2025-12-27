Link : https://leetcode.com/problems/median-of-two-sorted-arrays/description/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int imax = nums1.length;
        int jmax = nums2.length;
        int k = 0;
        int i = 0;
        int j = 0;
        int arr[] = new int[imax+jmax];
        double med = 0.0;
        int n = arr.length;
        while(i < imax || j < jmax){
            if(i == imax && j < jmax){
                arr[k++] = nums2[j++];
            }
            else if(j == jmax && i < imax){
                arr[k++] = nums1[i++];
            }
            else{
                if(nums1[i] < nums2[j]){
                    arr[k++] = nums1[i++];
                }
                else{
                    arr[k++] = nums2[j++];
                }
            }
        }
        if(n % 2 == 0){
            med = (double)(arr[n/2] + arr[(n-1)/2]) / 2;
        }
        else{
            med = arr[n/2];
        }
        return med;
    }
}
