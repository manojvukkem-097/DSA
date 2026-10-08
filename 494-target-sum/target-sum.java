class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(Math.abs(target)>sum||(target+sum)%2!=0)return 0;
        return helper(nums,0,(target+sum)/2);
    }
    private int helper(int[]nums,int index,int target){
        if(target<0)return 0;
        if(index==nums.length)return target==0?1:0;
        int take=0;
        if(target-nums[index]>=0)take=helper(nums,index+1,target-nums[index]);
        int nottake=helper(nums,index+1,target);
        return take+nottake;
    }
}