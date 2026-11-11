class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long c1=cost1,c2=cost2,cboth=costBoth,n1=need1,n2=need2;
        long bothcount=Math.min(n1,n2);
        long ans=0;
        ans+=bothcount*Math.min(cboth,c1+c2);
        n1-=bothcount;
        n2-=bothcount;
        if(n1>0){
            ans+=n1*Math.min(c1,cboth);
        }
        if(n2>0){
            ans+=n2*Math.min(c2,cboth);
        }
        return ans;
    }
}