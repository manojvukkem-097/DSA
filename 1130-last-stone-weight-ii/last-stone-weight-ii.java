class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int stone:stones){
            sum+=stone;
        }
        int achievable=0;
        for(int target=sum/2;target>=0;target--){
            if(helper(stones,0,target)){
                achievable=target;
                break;
            }
        }
        return Math.abs(sum-achievable-achievable);
    }
    private boolean helper(int[]stones,int index,int target){
        if(target==0)return true;
        if(index==stones.length||target<0)return false;
        return helper(stones,index+1,target-stones[index])||helper(stones,index+1,target);
    }
}