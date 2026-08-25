class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atmost(nums,goal)-atmost(nums,goal-1);
    }
    private int atmost(int[]nums,int goal){
        if(goal<0)return 0;
        int l=0,ans=0,sum=0;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];
            while(sum>goal){
                sum-=nums[l++];
            }
            ans+=r-l+1;
        }
        return ans;
    }
}