class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums,0,target);
    }
    private int helper(int[]nums,int index,int target){
        if(index==nums.length)return target==0?1:0;
        int positive=helper(nums,index+1,target-nums[index]);
        int negative=helper(nums,index+1,target+nums[index]);
        return positive+negative;
    }
}