class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int stone:stones){
            sum+=stone;
        }
        int achievable=0;
        for(int target=sum/2;target>=0;target--){
            boolean[][]dp=new boolean[stones.length+1][target+1];
            boolean[]next=new boolean[target+1];
            //for(int i=0;i<=stones.length;i++){
              //  dp[i][0]=true;
            //}
            next[0]=true;
            for(int index=stones.length-1;index>=0;index--){
                boolean[]curr=new boolean[target+1];
                for(int j=0;j<=target;j++){
                    boolean take=false;
                    if(j-stones[index]>=0)take=next[j-stones[index]];
                    boolean nottake=next[j];
                    curr[j]=take||nottake;
                }
                next=curr;
            }
            if(next[target]){
                achievable=target;
                break;
            }
        }
        return Math.abs(sum-2*achievable);
    }
}