class Solution {
    public int climbStairs(int n, int[] costs) {
        int[]dp=new int[n+1];
        for(int i=1;i<=n;i++){
            int ans=Integer.MAX_VALUE;
            for(int j=1;j<=3;j++){
                int cost=costs[i-1]+j*j;
                int nextcost=0;
                if(i-j>=0)nextcost=dp[i-j];
                ans=Math.min(ans,cost+nextcost);
            }
            dp[i]=ans;
        }
        return dp[n];
    }
}