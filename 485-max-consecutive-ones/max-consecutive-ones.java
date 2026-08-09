class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int curr=0;
        int ans=0;
        for(int num:nums){
            if(num==1){
                curr++;
                ans=Math.max(ans,curr);
            }
            else{
                curr=0;
            }
        }
        return ans;
    }
}