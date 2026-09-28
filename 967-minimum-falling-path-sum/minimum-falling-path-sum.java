class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int ans=Integer.MAX_VALUE;
        int[][]dp=new int[n][n];
        for(int i=0;i<n;i++)dp[0][i]=matrix[0][i];
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                int ld=Integer.MAX_VALUE,rd=Integer.MAX_VALUE;
                int s=dp[i-1][j];
                if(j>0)ld=dp[i-1][j-1];
                if(j<n-1)rd=dp[i-1][j+1];
                dp[i][j]=matrix[i][j]+Math.min(s,Math.min(ld,rd));
            }
        }
        for(int i=0;i<n;i++){
            ans=Math.min(ans,dp[n-1][i]);
        }
        return ans;
    }
}