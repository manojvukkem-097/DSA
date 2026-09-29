class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[]prev=new int[n];
        prev[0]=triangle.get(0).get(0);
        for(int i=1;i<n;i++){
            int[]curr=new int[n];
            for(int j=0;j<=i;j++){
                int val=triangle.get(i).get(j);
                int s=Integer.MAX_VALUE;
                if(j<i){
                    s=val+prev[j];
                }
                int ld=Integer.MAX_VALUE;
                if(j>0){
                    ld=val+prev[j-1];
                }
                curr[j]=Math.min(s,ld);
            }
            prev=curr;
        }
        int ans=Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            ans=Math.min(ans,prev[j]);
        }
        return ans;
    }
}