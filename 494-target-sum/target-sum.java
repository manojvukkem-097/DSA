class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(Math.abs(target)>sum||(target+sum)%2!=0)return 0;
        int[]dp=new int[(target+sum)/2+1];
        dp[0]=1;
        for(int index=nums.length-1;index>=0;index--){
            for(int j=(target+sum)/2;j>=nums[index];j--){
                dp[j]=dp[j-nums[index]]+dp[j];
            }
        }
        return dp[(target+sum)/2];
    }
}