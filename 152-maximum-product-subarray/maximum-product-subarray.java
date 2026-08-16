class Solution {
    public int maxProduct(int[] nums) {
        int pre=1,pos=1,max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(pre==0)pre=1;
            if(pos==0)pos=1;
            pre*=nums[i];
            pos*=nums[nums.length-1-i];
            max=Math.max(max,Math.max(pre,pos));
        }
        return max;
    }
}