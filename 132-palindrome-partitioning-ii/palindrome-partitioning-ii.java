class Solution {
    private boolean ispalindrome(String s,int l,int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public int minCut(String s) {
        int n=s.length();
        int[]dp=new int[n];
        Arrays.fill(dp,-1);
        return helper(s,0,dp)-1;
    }
    private int helper(String s,int i,int[]dp){
        if(i==s.length())return 0;
        if(dp[i]!=-1)return dp[i];
        int mini=Integer.MAX_VALUE;
        for(int k=i;k<s.length();k++){
            if(ispalindrome(s,i,k)){
                mini=Math.min(mini,1+helper(s,k+1,dp));
            }
        }
        return dp[i]=mini;
    }
}