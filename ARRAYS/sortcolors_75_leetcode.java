Link : https://leetcode.com/problems/sort-colors/description/

class Solution {
    public void sortColors(int[] nums) {
        int map[] = new int[3];
        for(int i = 0;i < nums.length;i++){
            map[nums[i]]++;
        }
        int j=0;
        for(int i = 0;i < 3;){
            if(map[i] == 0){
                i++;
            }
            else{
                nums[j++] = i;
                map[i]--;
            }
        }
    }
}
