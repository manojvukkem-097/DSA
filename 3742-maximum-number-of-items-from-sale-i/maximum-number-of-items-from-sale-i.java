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
        int[][]next=new int[budget+1][2];
        for(int i=n-1;i>=0;i--){
            int[][]curr=new int[budget+1][2];
            for(int j=0;j<=budget;j++){
                for(int isfirst=1;isfirst>=0;isfirst--){
                    int best=next[j][1];
                    if(j>=items[i][1]){
                        int gain=isfirst==1?1+map[i]:1;
                        int buyone=gain+curr[j-items[i][1]][0];
                        best=Math.max(best,buyone);
                    }
                    curr[j][isfirst]=best;
                }
            }
            next=curr;
        }
        return next[budget][1];
    }
}