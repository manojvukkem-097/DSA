class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n=nums.length;
        long ans=0;
        long cost=0;
        int j=n-1;
        Deque<int[]>dq=new ArrayDeque<>();
        for(int i=n-1;i>=0;i--){
            int num=nums[i];
            int count=1;
            while(!dq.isEmpty()&&dq.peekLast()[0]<num){
                int[]p=dq.pollLast();
                count+=p[1];
                cost+=(long)(num-p[0])*p[1];
            }
            dq.offerLast(new int[]{num,count});
            while(cost>k){
                int[]p=dq.pollFirst();
                cost-=(long)(p[0]-nums[j]);
                j--;
                if(p[1]>1)dq.offerFirst(new int[]{p[0],p[1]-1});
            }
            ans+=j-i+1;
        }
        return ans;
    }
}