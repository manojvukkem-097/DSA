class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[]highest=new int[nums.length];
        highest[0]=nums[0];
        int[]lowest=new int[nums.length];
        lowest[nums.length-1]=nums[nums.length-1];
        for(int i=1;i<nums.length;i++){
            highest[i]=Math.max(nums[i],highest[i-1]);
        }
        for(int i=nums.length-2;i>=0;i--){
            lowest[i]=Math.min(nums[i],lowest[i+1]);
        }
        int ans=-1;
        for(int i=0;i<nums.length;i++){
            if(highest[i]-lowest[i]<=k){
                ans=i;
                break;
            }
        }
        return ans;
    }
}