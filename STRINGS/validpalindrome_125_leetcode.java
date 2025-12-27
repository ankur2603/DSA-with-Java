Link : https://leetcode.com/problems/valid-palindrome/description/

class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        int val1 = 0;
        int val2 = 0;
        char chi,chj;
        while(i <= j){
            val1 = (int)(s.charAt(i));
            val2 = (int)(s.charAt(j));
            if(val1 <= 90 && val1 >= 65  || val2 <= 90 && val2 >= 65){//Upper case to lower case
                if((val1 <= 90 && val1 >= 65) && (val2 <= 90 && val2 >= 65)){
                    val1 += 32;
                    val2 += 32;
                }
                else if((val2 <= 90 && val2 >= 65)  && (val1 > 90 || val1 < 65)){
                    val2 += 32;
                }
                else{
                    val1 += 32;
                }
            }
            if(((val1 <= 122 && val1 >= 97) || (val1 <= 57 && val1 >= 48))  &&  ((val2 <= 122 && val2 >= 97) || (val2 <= 57 && val2 >= 48))){// Alphanumeric case
                if(val1 != val2){
                    return false;
                }
                i++;
                j--;
            }
            else{
                if(val1 <= 122 && val1 >= 97 || val1 <= 57 && val1 >= 48){//val2 is not in range
                    j--;
                }
                else{//val1 is not in range
                    i++;
                }
            }
        }
        return true;
    }
}
