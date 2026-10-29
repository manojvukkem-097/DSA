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
        int[]dp=new int[n+1];
        for(int i=n-1;i>=0;i--){
            int mini=Integer.MAX_VALUE;
            for(int k=i;k<s.length();k++){
                if(ispalindrome(s,i,k)){
                    mini=Math.min(mini,1+dp[k+1]);
                }
            }
            dp[i]=mini;
        }
        return dp[0]-1;
    }
}