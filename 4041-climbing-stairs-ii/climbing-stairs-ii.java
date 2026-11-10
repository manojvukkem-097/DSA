class Solution {
    public int climbStairs(int n, int[] costs) {
        int[]dp=new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,costs,dp);
    }
    private int helper(int i,int[]costs,int[]dp){
        if(i<=0)return 0;
        if(dp[i]!=-1)return dp[i];
        int ans=Integer.MAX_VALUE;
        for(int j=1;j<=3;j++){
            int cost=costs[i-1]+j*j;
            int nextcost=helper(i-j,costs,dp);
            ans=Math.min(ans,cost+nextcost);
        }
        return dp[i]=ans;
    }
}