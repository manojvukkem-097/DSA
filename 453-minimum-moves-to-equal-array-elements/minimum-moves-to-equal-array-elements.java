class Solution {
    public int minMoves(int[] nums) {
        int m=Integer.MAX_VALUE;
        for(int x:nums)if(x<m)m=x;
        int moves=0;
        for(int x:nums)moves+=x-m;
        return moves;
    }
}