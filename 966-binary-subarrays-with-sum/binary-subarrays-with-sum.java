class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum1=0,sum2=0,l1=0,l2=0,ans=0;
        for(int r=0;r<nums.length;r++){
            sum1+=nums[r];
            sum2+=nums[r];
            while(l1<=r && sum1>goal){
                sum1-=nums[l1++];
            }
            while(l2<=r && sum2>goal-1){
                sum2-=nums[l2++];
            }
            ans+=(l2-l1);
        }
        return ans;
    }
}