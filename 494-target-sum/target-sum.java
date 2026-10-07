class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(Math.abs(target)>sum){
            return 0;
        }
        int[][]dp=new int[nums.length+1][2*sum+1];
        int[]next=new int[2*sum+1];
        next[sum]=1;
        for(int index=nums.length-1;index>=0;index--){
            int[]curr=new int[2*sum+1];
            for(int j=-sum;j<=sum;j++){
                int dpindex=j+sum;
                if(next[dpindex]>0){
                    if (dpindex - nums[index] >= 0) {
                        curr[dpindex - nums[index]] += next[dpindex];
                    }
                    if (dpindex + nums[index] <= 2 * sum) {
                        curr[dpindex + nums[index]] += next[dpindex];
                    }
                }
            }
            next=curr;
        }
        return next[target+sum];
    }
}