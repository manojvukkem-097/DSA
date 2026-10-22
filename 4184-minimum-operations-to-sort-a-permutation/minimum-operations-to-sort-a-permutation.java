class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        boolean issorted=true;
        for(int i=1;i<n;i++){
            if(nums[i]<nums[i-1]){
                issorted=false;
                break;
            }
        }
        if(issorted)return 0;
        int minindex=-1;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                minindex=i;
                break;
            }
        }
        boolean isincrease=true;
        for(int i=0;i<n;i++){
            if(nums[(i+minindex)%n]!=i){
                isincrease=false;
                break;
            }
        }
        if(isincrease){
            return Math.min(2+n-minindex,minindex);
        }
        boolean isdecrease=true;
        for(int i=0;i<n;i++){
            if(nums[(minindex-i+n)%n]!=i){
                isdecrease=false;
                break;
            }
        }
        if(isdecrease){
            return Math.min(minindex+2,n-minindex);
        }
        return -1;
    }
}