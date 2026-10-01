class Solution {
    public int maxProfit(int[] prices) {
        int i=0,profit=0;
        while(i<prices.length){
            int curr=prices[i];
            int high=prices[i++];
            while(i<prices.length&&high<prices[i]){
                high=prices[i];
                i++;
            }
            if(high>curr){
                profit+=(high-curr);
            }
        }
        return profit;
    }
}