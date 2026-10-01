class Solution {
    public int countSquares(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        int[][]dp=new int[m][n];
        for(int k=0;k<n;k++){
            dp[0][k]=matrix[0][k];
        }
        for(int k=0;k<m;k++){
            dp[k][0]=matrix[k][0];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0)dp[i][j]=0;
                else{
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
                }
            }
        }
        int ans=0;
        for(int[]row:dp){
            for(int j=0;j<n;j++){
                ans+=row[j];
            }
        }
        return ans;
    }
}