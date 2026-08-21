class Solution {
    private int[]psee(int[]arr){
        int[]ans=new int[arr.length];
        int[]s=new int[arr.length];
        int top=-1;
        for(int i=0;i<arr.length;i++){
            while(top!=-1 &&arr[s[top]]>arr[i]){
                top--;
            }
            ans[i]=top==-1?-1:s[top];
            s[++top]=i;
        }
        return ans;
    }
    private int[]nse(int[]arr){
        int[]ans=new int[arr.length];
        int[]s=new int[arr.length];
        int top=-1;
        for(int i=arr.length-1;i>=0;i--){
            while(top!=-1&&arr[s[top]]>=arr[i]){
                top--;
            }
            ans[i]=top==-1?arr.length:s[top];
            s[++top]=i;
        }
        return ans;
    }
    public int sumSubarrayMins(int[] arr) {
        long total=0;
        int mod=(int)(1e9+7);
        int[]previous=psee(arr);
        int[]next=nse(arr);
        for(int i=0;i<arr.length;i++){
            long left=i-previous[i];
            long right=next[i]-i;
            long freq=(left*right)%mod;
            long val=(freq*arr[i])%mod;
            total=(total+val)%mod;
        }
        return (int)total;
    }
}