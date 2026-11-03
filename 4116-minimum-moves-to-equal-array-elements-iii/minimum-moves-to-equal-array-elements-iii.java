class Solution {
    public int minMoves(int[] nums) {
        int maxi=0;
        for(int x:nums)maxi=Math.max(maxi,x);
        int ans=0;
        for(int x:nums)ans+=maxi-x;
        return ans;
    }
}