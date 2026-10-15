class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int[]dp=new int[n+1];
        for(int i=1;i<=n;i++){
            int prevdia=0;
            for(int j=1;j<=n;j++){
                int temp=dp[j];
                if(s.charAt(i-1)==s.charAt(n-j)){
                    dp[j]=1+prevdia;
                }else{
                    dp[j]=Math.max(dp[j-1],dp[j]);
                }
                prevdia=temp;
            }
        }
        return dp[n];
    }
}