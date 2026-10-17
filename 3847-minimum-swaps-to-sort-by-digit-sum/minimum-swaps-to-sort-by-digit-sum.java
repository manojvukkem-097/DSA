class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        int[][]temp=new int[n][2];
        for(int i=0;i<n;i++){
            temp[i][0]=nums[i];
            temp[i][1]=i;
        }
        Arrays.sort(temp,(a,b)->{
            int suma=sumdigits(a[0]);
            int sumb=sumdigits(b[0]);
            if(suma!=sumb){
                return suma-sumb;
            }
            return a[0]-b[0];
        });
        boolean[]visited=new boolean[n];
        int ans=0;
        for(int i=0;i<n;i++){
            if(temp[i][1]==i||visited[i]){
                continue;
            }
            int cyclesize=0;
            int curr=i;
            while(!visited[curr]){
                visited[curr]=true;
                curr=temp[curr][1];
                cyclesize++;
            }
            if(cyclesize>1){
                ans+=(cyclesize-1);
            }
        }
        return ans;
    }
    private int sumdigits(int n){
        int sum=0;
        while(n>0){
            sum+=n%10;
            n=n/10;
        }
        return sum;
    }
}