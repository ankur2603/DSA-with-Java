Link : https://leetcode.com/problems/longest-common-prefix/description/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String str1 = strs[0];
        String str2 = strs[0];
        for(int i = 0;i < strs.length;i++){
            if(strs[i].compareTo(str1) < 0){
                str1 = strs[i];
            }
            if(strs[i].compareTo(str2) > 0){
                str2 = strs[i];
            }
        }
        StringBuilder prefix = new StringBuilder();
        int min = Math.min(str1.length(),str2.length());
        for(int i = 0;i < min;i++){
            if(str1.charAt(i) == str2.charAt(i)){
                prefix.append(str1.charAt(i));
            }
            else{
                return prefix.toString();
            }
        }
        return prefix.toString();
    }
}
