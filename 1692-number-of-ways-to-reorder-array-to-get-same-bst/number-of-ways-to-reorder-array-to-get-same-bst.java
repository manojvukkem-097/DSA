class Solution {
    long[][]pt;
    long MOD=1000000007L;
    private long solve(List<Integer>temp){
        int n=temp.size();
        if(n<3)return 1;
        int root=temp.get(0);
        List<Integer>left=new ArrayList<>();
        List<Integer>right=new ArrayList<>();
        for(int i=1;i<n;i++){
            if(temp.get(i)<root){
                left.add(temp.get(i));
            }else{
                right.add(temp.get(i));
            }
        }
        long x=solve(left)%MOD;
        long y=solve(right)%MOD;
        long z=pt[n-1][left.size()]%MOD;
        return ((x*y)%MOD*z)%MOD;
    }
    public int numOfWays(int[] nums) {
        int n=nums.length;
        pt=new long[n+1][];
        for(int i=0;i<=n;i++){
            pt[i]=new long[i+1];
            Arrays.fill(pt[i],1);
            for(int j=1;j<i;j++){
                pt[i][j]=(pt[i-1][j]+pt[i-1][j-1])%MOD;
            }
        }
        List<Integer>temp=new ArrayList<>();
        for(int i=0;i<n;i++){
            temp.add(nums[i]);
        }
        return (int)((solve(temp)-1+MOD)%MOD);
    }
}