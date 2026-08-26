class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums,k)-atmost(nums,k-1);
    }
    private int atmost(int[]nums,int k){
        int l=0,r=0,count=0,distinct=0;
        int[]freq=new int[nums.length+1];
        while(r<nums.length){
            if(freq[nums[r]]==0){
                distinct++;
            }
            freq[nums[r]]++;
            while(distinct>k){
                freq[nums[l]]--;
                if(freq[nums[l]]==0){
                    distinct--;
                }
                l++;
            }
            count+=r-l+1;
            r++;
        }
        return count;
    }
}