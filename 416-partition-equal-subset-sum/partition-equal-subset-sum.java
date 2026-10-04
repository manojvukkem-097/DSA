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
            boolean[]curr=new boolean[target+1];
            curr[0]=true;
            for(int j=target;j>=0;j--){
                boolean take=false;
                if(j-nums[i]>=0)take=next[j-nums[i]];
                boolean nottake=next[j];
                curr[j]=take||nottake;
            }
            next=curr;
        }
        return next[target];
    }
}