Link : https://leetcode.com/problems/remove-all-occurrences-of-a-substring/description/

class Solution {
    public String removeOccurrences(String s, String part) {

        StringBuilder sb = new StringBuilder(s);
        
        int start = 0;

        while(sb.indexOf(part) != -1){ 

            start = sb.indexOf(part);
            sb.delete(start, start+part.length());
            
        }
        return sb.toString();
    }
}
