class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0)return false;
        int target=sum/2;
        boolean[]next=new boolean[target+1];
        next[0]=true;
        for(int i=nums.length-1;i>=0;i--){
            for(int j=target;j>=nums[i];j--){
                next[j]=next[j-nums[i]]||next[j];
            }
            if(next[target])return true;
        }
        return next[target];
    }
}