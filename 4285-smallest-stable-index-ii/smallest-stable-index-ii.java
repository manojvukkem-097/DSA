class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[]lowest=new int[nums.length];
        lowest[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            lowest[i]=Math.min(nums[i],lowest[i+1]);
        }
        int maxi=nums[0];
        for(int i=0;i<nums.length;i++){
            maxi=Math.max(maxi,nums[i]);
            if(maxi-lowest[i]<=k){
                return i;
            }
        }
        return -1;
    }
}