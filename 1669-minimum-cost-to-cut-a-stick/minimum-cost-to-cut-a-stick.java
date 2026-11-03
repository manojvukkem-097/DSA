class Solution {
    public int minCost(int n, int[] cuts) {
        int m=cuts.length;
        int[]newcuts=new int[m+2];
        System.arraycopy(cuts,0,newcuts,1,m);
        newcuts[0]=0;
        newcuts[m+1]=n;
        Arrays.sort(newcuts);
        int[][]dp=new int[m+2][m+2];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return helper(newcuts,1,m,dp);
    }
    private int helper(int[]newcuts,int i,int j,int[][]dp){
        if(i>j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int mini=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int cost=(newcuts[j+1]-newcuts[i-1])+helper(newcuts,i,k-1,dp)+helper(newcuts,k+1,j,dp);
            mini=Math.min(mini,cost);
        }
        return dp[i][j]=mini;
    }
}