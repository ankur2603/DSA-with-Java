Link : https://leetcode.com/problems/reverse-words-in-a-string/description/

class Solution {
    public String reverseWords(String s) {
        String s1 = s.trim()+" ";
        StringBuilder s2 = new StringBuilder();
        int start = 0;
        int end = s1.length()-1;
        for(int i = s1.length()-2;i >= 0;i--){
            if(i == 0){
                s2.append(s1,0,end);
            }
            if(s1.charAt(i) == ' ' && s1.charAt(i+1) != ' '){
                start = i+1;
                s2.append(s1,start,end);
                s2.append(' ');
                end = i;
            }
            else if(s1.charAt(i) == ' ' && s1.charAt(i+1) == ' '){
                end--;
            }
        }
        return s2.toString();
    }
}
