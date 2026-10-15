class Solution {
    public int longestPalindromeSubseq(String s) {
        String s1=s;
        String s2=new StringBuilder(s).reverse().toString();
        int m=s1.length(),n=s2.length();
        int[]dp=new int[n+1];
        for(int i=1;i<=m;i++){
            int prevdia=0;
            for(int j=1;j<=n;j++){
                int temp=dp[j];
                if(s1.charAt(i-1)==s2.charAt(j-1)){
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