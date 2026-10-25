class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int m=s.length();
        Set<String>set=new HashSet<>(wordDict);
        boolean[]dp=new boolean[m+1];
        dp[m]=true;
        for(int start=m-1;start>=0;start--){
            for(int end=start+1;end<=m;end++){
                String prefix=s.substring(start,end);
                if(set.contains(prefix)&&dp[end]){
                    dp[start]=true;
                    break;
                }
            }
        }
        return dp[0];
    }
}