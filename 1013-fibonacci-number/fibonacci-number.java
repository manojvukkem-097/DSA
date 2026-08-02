class Solution {
    public int fib(int n) {
        if(n==1){
            return 1;
        }
        if(n==0){
            return 0;
        }
        int first=0;
        int second=1;
        int curr=0;
        for(int i=2;i<=n;i++){
            curr=first+second;
            first=second;
            second=curr;
        }
        return curr;
    }
}