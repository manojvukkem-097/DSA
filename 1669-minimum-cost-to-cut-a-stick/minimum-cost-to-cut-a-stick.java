class Solution {
    public int minCost(int n, int[] cuts) {
        int m=cuts.length;
        int[]newcuts=new int[m+2];
        System.arraycopy(cuts,0,newcuts,1,m);
        newcuts[0]=0;
        newcuts[m+1]=n;
        Arrays.sort(newcuts);
        int[][]dp=new int[m+2][m+2];
        for(int i=m;i>=1;i--){
            for(int j=i;j<=m;j++){
                int mini=Integer.MAX_VALUE;
                for(int k=i;k<=j;k++){
                    int cost=(newcuts[j+1]-newcuts[i-1])+dp[i][k-1]+dp[k+1][j];
                    mini=Math.min(mini,cost);
                }
                dp[i][j]=mini;
            }
        }
        return dp[1][m];
    }
}