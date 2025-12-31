Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

class Solution {
    public int maxProfit(int[] prices) {
        
        int minprice=Integer.MAX_VALUE; // keep the track of minprice and maxprofit
        int maxprofit=0;
        
        for(int i=0;i<prices.length;i++){
            
            int curr=prices[i];
            
            if(curr<minprice){
                minprice=curr;
            }
            
            if(curr-minprice>maxprofit){
                maxprofit=curr-minprice;
            }
        }
        return maxprofit;
    }
}
