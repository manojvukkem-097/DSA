class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][]dp=new int[n][n];
        dp[0][0]=triangle.get(0).get(0);
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                int val=triangle.get(i).get(j);
                int s=Integer.MAX_VALUE;
                if(j<i){
                    s=val+dp[i-1][j];
                }
                int ld=Integer.MAX_VALUE;
                if(j>0){
                    ld=val+dp[i-1][j-1];
                }
                dp[i][j]=Math.min(s,ld);
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            ans=Math.min(ans,dp[n-1][j]);
        }
        return ans;
    }
}