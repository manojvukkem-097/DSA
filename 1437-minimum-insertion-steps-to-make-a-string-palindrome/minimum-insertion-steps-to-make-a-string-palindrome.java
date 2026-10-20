class Solution {
    public int minInsertions(String s) {
        String str=new StringBuilder(s).reverse().toString();
        return s.length()-lcs(s,str);
    }
    private int lcs(String src,String target){
        int n=src.length();
        int[][]dp=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(src.charAt(i-1)==target.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[n][n];
    }
}