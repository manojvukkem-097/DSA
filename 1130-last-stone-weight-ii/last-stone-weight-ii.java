class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int stone:stones){
            sum+=stone;
        }
        int achievable=0;
        for(int target=sum/2;target>=0;target--){
            boolean[][]dp=new boolean[stones.length+1][target+1];
            for(int i=0;i<=stones.length;i++){
                dp[i][0]=true;
            }
            for(int index=stones.length-1;index>=0;index--){
                for(int j=0;j<=target;j++){
                    boolean take=false;
                    if(j-stones[index]>=0)take=dp[index+1][j-stones[index]];
                    boolean nottake=dp[index+1][j];
                    dp[index][j]=take||nottake;
                }
            }
            if(dp[0][target]){
                achievable=target;
                break;
            }
        }
        return Math.abs(sum-2*achievable);
    }
    private boolean helper(int[]stones,int index,int target,Boolean[][]dp){
        if(target==0)return true;
        if(index==stones.length||target<0)return false;
        if(dp[index][target]!=null)return dp[index][target];
        return dp[index][target]=helper(stones,index+1,target-stones[index],dp)||helper(stones,index+1,target,dp);
    }
}