class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int stone:stones){
            sum+=stone;
        }
        int target=sum/2;
        boolean[]dp=new boolean[target+1];
        dp[0]=true;
        for(int index=0;index<stones.length;index++){
            for(int j=target;j>=stones[index];j--){
                dp[j]=dp[j]||dp[j-stones[index]];
            }
        }
        for(int j=target;j>=0;j--){
            if(dp[j]){
                return sum-2*j;
            }
        }
        return 0;
    }
}