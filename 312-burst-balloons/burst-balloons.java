class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[]arr=new int[n+2];
        arr[0]=1;
        for(int i=0;i<n;i++){
            arr[i+1]=nums[i];
        }
        arr[n+1]=1;
        int[][]dp=new int[n+2][n+2];
        for(int i=n;i>=1;i--){
            for(int j=i;j<=n;j++){
                int maxi=Integer.MIN_VALUE;
                for(int k=i;k<=j;k++){
                    int cost=arr[i-1]*arr[k]*arr[j+1]+dp[i][k-1]+dp[k+1][j];
                    maxi=Math.max(maxi,cost);
                }
                dp[i][j]=maxi;
            }
        }
        return dp[1][n];
    }
}