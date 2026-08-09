class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pi=0,ni=1;
        int[]ans=new int[nums.length];
        for(int num:nums){
            if(num>0){
                ans[pi]=num;
                pi+=2;
            }else{
                ans[ni]=num;
                ni+=2;
            }
        }
        return ans;
    }
}