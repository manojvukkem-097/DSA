class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[]dp=new int[n+1];
        for(int i=n-1;i>=0;i--){
            int ans=Integer.MIN_VALUE;
            int maxi=Integer.MIN_VALUE;
            for(int j=i;j<i+k&&j<n;j++){
                maxi=Math.max(arr[j],maxi);
                int sum=(maxi)*(j-i+1)+dp[j+1];
                ans=Math.max(ans,sum);
            }
            dp[i]=ans;
        }
        return dp[0];
    }
}