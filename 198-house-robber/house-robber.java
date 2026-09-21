class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        int prev=0,prev2=0;
        for(int num:nums){
            int take=num+prev2;
            int nottake=prev;
            int curr=Math.max(take,nottake);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}