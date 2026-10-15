class Solution {
    public int longestPalindromeSubseq(String s) {
        String s1=s;
        String s2=new StringBuilder(s).reverse().toString();
        return lcs(s1,s2);
    }
    private int lcs(String s1,String s2){
        int m=s1.length(),n=s2.length();
        int[][]dp=new int[m][n];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return helper(s1,s2,m-1,n-1,dp);
    }
    private int helper(String s1,String s2,int i,int j,int[][]dp){
        if(i<0||j<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=1+helper(s1,s2,i-1,j-1,dp);
        }
        return dp[i][j]=Math.max(helper(s1,s2,i,j-1,dp),helper(s1,s2,i-1,j,dp));
    }
}