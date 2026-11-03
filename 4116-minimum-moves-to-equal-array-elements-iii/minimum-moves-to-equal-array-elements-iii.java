class Solution {
    public int minMoves(int[] nums) {
        int maxi=0,sum=0;
        for(int x:nums){
            maxi=Math.max(maxi,x);
            sum+=x;
        }
        return nums.length*maxi-sum;        
    }
}