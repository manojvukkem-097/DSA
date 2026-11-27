class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n=items.length;
        Arrays.sort(items,(a,b)->a[1]-b[1]);
        int[]map=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j&&items[j][0]%items[i][0]==0){
                    map[i]++;
                }
            }
        }
        int[][][]dp=new int[n][1501][2];
        for(int[][]row:dp){
            for(int[]col:row){
                Arrays.fill(col,-1);
            }
        }
        return helper(0,items,map,budget,1,dp);
    }
    private int helper(int i,int[][]items,int[]map,int budget,int isfirst,int[][][]dp){
        if(i>=items.length||budget<=0)return 0;
        if(dp[i][budget][isfirst]!=-1)return dp[i][budget][isfirst];
        int best=helper(i+1,items,map,budget,1,dp);
        if(budget>=items[i][1]){
            int gain=isfirst==1?1+map[i]:1;
            int buyone=gain+helper(i,items,map,budget-items[i][1],0,dp);
            best=Math.max(best,buyone);
        }
        return dp[i][budget][isfirst]=best;
    }
}