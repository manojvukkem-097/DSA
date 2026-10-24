class Solution {
    public boolean isMatch(String s, String p) {
        int m=s.length(),n=p.length();
        boolean[][]dp=new boolean[m+1][n+1];
        dp[0][0]=true;
        for(int j=1;j<=n;j++){
            boolean flag=true;
            for(int k=1;k<=j;k++){
                if(p.charAt(k-1)!='*'){
                    flag=false;
                    break;
                }
            }
            dp[0][j]=flag;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                    continue;
                }
                if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];
                    continue;
                }
                dp[i][j]=false;
            }
        }
        return dp[m][n];
    }
}