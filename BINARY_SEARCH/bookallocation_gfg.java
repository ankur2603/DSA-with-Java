Link : https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/0

class Solution {
    public int findPages(int[] arr, int k) {
        
        int n = arr.length;
        int max = 0;
        
        if (k > n) return -1;
        
        for(int i = 0;i < n;i++){
            max += arr[i];
        }
        
        int start = 0;
        int end = max;
        int mid = 0;
        int ans = -1;
        
        while(start <= end){
            mid = start + (end-start)/2;
            
            if(isValid(mid, k, n, arr)){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }
    boolean isValid(int maxpg, int k, int n, int arr[]){
        
        
        int stud = 1;
        int pages = 0;
        
        for(int i = 0;i < n;i++){
            
            if(arr[i] > maxpg) return false;
            
            if(pages +arr[i] <= maxpg){
                pages += arr[i];
            }
            else{
                pages = arr[i];
                stud++;
            }
        }
        
        if(stud <= k) return true;
        else return false;
    }
}
