class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[]arr=new int[n+2];
        arr[0]=1;
        for(int i=0;i<n;i++){
            arr[i+1]=nums[i];
        }
        arr[n+1]=1;
        int[][]dp=new int[n+1][n+1];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return helper(arr,1,n,dp);
    }
    private int helper(int[]arr,int i,int j,int[][]dp){
        if(i>j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int maxi=Integer.MIN_VALUE;
        for(int k=i;k<=j;k++){
            int cost=arr[i-1]*arr[k]*arr[j+1]+helper(arr,i,k-1,dp)+helper(arr,k+1,j,dp);
            maxi=Math.max(maxi,cost);
        }
        return dp[i][j]=maxi;
    }
}