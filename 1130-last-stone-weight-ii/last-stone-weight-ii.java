class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int stone:stones){
            sum+=stone;
        }
        int achievable=0;
        for(int target=sum/2;target>=0;target--){
            Boolean[][]dp=new Boolean[stones.length][target+1];
            if(helper(stones,0,target,dp)){
                achievable=target;
                break;
            }
        }
        return Math.abs(sum-achievable-achievable);
    }
    private boolean helper(int[]stones,int index,int target,Boolean[][]dp){
        if(target==0)return true;
        if(index==stones.length||target<0)return false;
        if(dp[index][target]!=null)return dp[index][target];
        return dp[index][target]=helper(stones,index+1,target-stones[index],dp)||helper(stones,index+1,target,dp);
    }
}