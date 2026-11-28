class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n=items.length;
        int minprice=Integer.MAX_VALUE;
        int[]frequency=new int[n+1];
        for(int[]x:items){
            frequency[x[0]]++;
            minprice=Math.min(minprice,x[1]);
        }
        int[]gain=new int[n+1];
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j+=i){
                gain[i]+=frequency[j];
            }
            gain[i]--;
        }
        Arrays.sort(items,(a,b)->a[1]-b[1]);
        long ans=0,remaining=budget;
        for(int[]item:items){
            int factor=item[0];
            int price=item[1];
            if(price>2L*minprice){
                break;
            }
            long buy=Math.min(gain[factor],remaining/price);
            ans+=buy*2;
            remaining-=buy*price;
        }
        ans+=remaining/minprice;
        return (int)ans;
    }
}