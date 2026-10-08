class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(Math.abs(target)>sum||(target+sum)%2!=0)return 0;
        int s1=(target + sum) / 2;
        int[]dp=new int[s1+1];
        dp[0]=1;
        for(int num:nums){
            for(int j=s1;j>=num;j--){
                dp[j]=dp[j-num]+dp[j];
            }
        }
        return dp[(target+sum)/2];
    }
}