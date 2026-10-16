class Solution {
    long[]squaresum;
    long[]sum;
    long[]lazy;
    int MOD=1000000007;
    private void update(int i,int l,int r,long val){
        long len=r-l+1;
        squaresum[i]+=2*val*sum[i]+val*val*len;
        sum[i]+=len*val;
    }
    private void updaterange(int start,int end,int i,int l,int r,long val){
        if(lazy[i]!=0){
            update(i,l,r,lazy[i]);
            if(l!=r){
                lazy[2*i+1]+=lazy[i];
                lazy[2*i+2]+=lazy[i];
            }
            lazy[i]=0;
        }
        if(l>end||l>r||r<start){
            return;
        }
        if(l>=start&&r<=end){
            update(i,l,r,val);
            if(l!=r){
                lazy[2*i+1]+=val;
                lazy[2*i+2]+=val;
            }
            return;
        }
        int mid=l+(r-l)/2;
        updaterange(start,end,2*i+1,l,mid,val);
        updaterange(start,end,2*i+2,mid+1,r,val);
        sum[i]=sum[2*i+1]+sum[2*i+2];
        squaresum[i]=squaresum[2*i+1]+squaresum[2*i+2];
    }
    public int sumCounts(int[] nums) {
        int n=nums.length;
        squaresum=new long[4*n];
        sum=new long[4*n];
        lazy=new long[4*n];
        int[]last=new int[100001];
        Arrays.fill(last,-1);
        long ans=0;
        for(int i=0;i<n;i++){
            int start=last[nums[i]]+1;
            int end=i;
            updaterange(start,end,0,0,n-1,1);
            ans=(ans+squaresum[0])%MOD;
            last[nums[i]]=i;
        }
        return (int)ans;
    }
}