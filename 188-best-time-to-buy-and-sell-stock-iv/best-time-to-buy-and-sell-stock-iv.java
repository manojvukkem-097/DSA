class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        if(n==0||k==0)return 0;
        if(k>=n/2){
            int profit=0;
            for(int i=1;i<n;i++){
                if(prices[i]>prices[i-1]){
                    profit+=prices[i]-prices[i-1];
                }
            }
            return profit;
        }
        int[]buy=new int[k+1];
        int[]sell=new int[k+1];
        for(int j=1;j<=k;j++){
            buy[j]=-prices[0];
            sell[j]=0;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=k;j++){
                buy[j]=Math.max(buy[j],sell[j-1]-prices[i]);
                sell[j]=Math.max(sell[j],buy[j]+prices[i]);
            }
        }
        return sell[k];
    }
}