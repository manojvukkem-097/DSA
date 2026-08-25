class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count[]=new int[nums.length+1];
        count[0]=1;
        int currsum=0,ans=0;
        for(int r=0;r<nums.length;r++){
            currsum+=nums[r];
            if(currsum>=goal){
                ans+=count[currsum-goal];
            }
            count[currsum]++;
        }
        return ans;
    }
}