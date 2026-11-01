class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[]dp=new int[n];
        Arrays.fill(dp,-1);
        return helper(arr,0,k,dp);
    }
    private int helper(int[]arr,int i,int k,int[]dp){
        if(i>=arr.length)return 0;
        if(dp[i]!=-1)return dp[i];
        int ans=Integer.MIN_VALUE;
        int maxi=Integer.MIN_VALUE;
        for(int j=i;j<i+k&&j<arr.length;j++){
            maxi=Math.max(arr[j],maxi);
            int sum=(maxi)*(j-i+1)+helper(arr,j+1,k,dp);
            ans=Math.max(ans,sum);
        }
        return dp[i]=ans;
    }
}