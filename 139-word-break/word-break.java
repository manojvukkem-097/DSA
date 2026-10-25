class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int m=s.length(),n=wordDict.size();
        Set<String>set=new HashSet<>(wordDict);
        Boolean[]dp=new Boolean[m];
        return helper(s,0,set,dp);
    }
    private boolean helper(String s,int start,Set<String>set,Boolean[]dp){
        if(start==s.length()){
            return true;
        }
        if(dp[start]!=null)return dp[start];
        for(int end=start+1;end<=s.length();end++){
            String prefix=s.substring(start,end);
            if(set.contains(prefix)&&helper(s,end,set,dp)){
                return dp[start]=true;
            }
        }
        return dp[start]=false;
    }
}