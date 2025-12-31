Link : https://leetcode.com/problems/next-permutation/description/

class Solution {
    public void nextPermutation(int[] nums) {
        
        boolean flag = false;
        int n = nums.length;
        int pivot = 0;
        int idx = n-1;
        int temp;
        
        for(int i = n-1;i > 0;i--){ // finding the pivot
            
            if(nums[i] > nums[i-1]){
                
                pivot = i-1;
                flag = true;
                break;
                
            }
        }

        if(flag == true){
            
            for(int i = n-1;i > pivot;i--){ // finding the rightmost element greater than the pivot
                
                if(nums[pivot] < nums[i]){
                    
                    idx = i;
                    break;
                    
                }
            }
            
            temp = nums[idx]; // swapping the pivot with element
            nums[idx] = nums[pivot];
            nums[pivot] = temp;

            int i = pivot+1;
            int j = n-1;
            
            while(i < j){ //reversing the array
                
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
                
            }
        }
        else{
            
            int i = 0;
            int j = n-1;
            
            while(i < j){
                
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
                
            }
        }
    }
}
