Link : https://leetcode.com/problems/powx-n/description/

class Solution {
    public double myPow(double x, int n) {
        
        if(n == 0) return 1;
            
        else if(n > 0){ // power is positive
            
            if(n == 1) return x;
            
            if(n % 2 == 0){ // when power is even
                
                double half=myPow(x , n/2);
                return half * half;
                
            }
                
            else{ // when power is odd
                
                double half=myPow(x , n/2);
                return x * half * half;
                
            }
        }
            
        else{ // power is negitive
            
            if(n == -1) return 1/x;
            
            if(-n % 2 == 0){ // when power is even
                
                double half=myPow(x , n/2);
                return half * half;
                
            }
                
            else{ // when power is odd
                
                double half=myPow(x , n/2);
                return 1/x * half * half;
                
            }
        }
    }
}
