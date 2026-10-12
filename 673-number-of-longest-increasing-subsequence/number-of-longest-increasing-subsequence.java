class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[]dp=new int[nums.length];
        int[]count=new int[nums.length];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        int maxlen=1;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(dp[i]<dp[j]+1){
                        dp[i]=dp[j]+1;
                        count[i]=count[j];
                    }else if(dp[i]==1+dp[j]){
                        count[i]+=count[j];
                    }
                }
            }
            maxlen=Math.max(maxlen,dp[i]);
        }
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(dp[i]==maxlen){
                ans+=count[i];
            }
        }
        return ans;
    }
}