class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0,zeros=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)zeros++;
            if(zeros>k){
                if(nums[l]==0)zeros--;
                l++;
            }
        }
        return nums.length-l;
    }
}