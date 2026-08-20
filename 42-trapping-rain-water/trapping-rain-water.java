class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int water=0;
        int leftmax=0;
        int rightmax=0,start=0,end=n-1;
        while(start<end){
            leftmax=Math.max(leftmax,height[start]);
            rightmax=Math.max(rightmax,height[end]);
            if(leftmax<rightmax){
                water+=leftmax-height[start];
                start++;
            }
            else{
                water+=rightmax-height[end];
                end--;
            }
        }
        return water;
    }
}