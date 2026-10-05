class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int stone:stones){
            sum+=stone;
        }
        int achievable=0;
        for(int target=sum/2;target>=0;target--){
            boolean[]dp=new boolean[target+1];
            dp[0]=true;
            for(int index=0;index<stones.length;index++){
                for(int j=target;j>=stones[index];j--){
                    dp[j]=dp[j]||dp[j-stones[index]];
                }
            }
            if(dp[target]){
                achievable=target;
                break;
            }
        }
        return Math.abs(sum-2*achievable);
    }
}