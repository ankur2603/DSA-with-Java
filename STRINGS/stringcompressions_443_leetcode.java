Link : https://leetcode.com/problems/string-compression/description/

class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int i = 0;      // write pointer
        int j = 1;      // read pointer
        int count = 1;

        if (n == 1) return 1;

        while (j <= n) {

            // group ends if:
            // 1) j reached end
            // 2) current char != previous char
            if (j == n || chars[j] != chars[j - 1]) {

                // write the character
                chars[i++] = chars[j - 1];

                // write count if > 1
                if (count > 1) {
                    String cnt = String.valueOf(count);
                    for (int k = 0; k < cnt.length(); k++) {
                        chars[i++] = cnt.charAt(k);
                    }
                }

                // reset for next group
                count = 1;
            } else {
                count++;
            }

            j++;
        }

        return i;
    }
}
