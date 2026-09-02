class Solution {
    public int jump(int[] nums) {
        int distance=0,ans=0,end=0;
        for(int i=0;i<nums.length-1;i++){
            distance=Math.max(distance,i+nums[i]);
            if(i==end){
                ans++;
                end=distance;
            }
        }
        return ans;
    }
}