class Solution {
    private static final Random rng=new Random();
    public int minMoves2(int[] nums) {
        int n=nums.length;
        int median=Quickselect(nums,n/2);
        int ans=0;
        for(int i=0;i<n/2;i++){
            ans+=Math.abs(nums[i]-median);
            ans+=Math.abs(nums[n-i-1]-median);
        }
        return ans; 
    }
    private int Quickselect(int[]nums,int k){
        int l=0,h=nums.length-1;
        while(true){
            int pivot=nums[l+rng.nextInt((h-l+1))];
            int lt=l,i=lt,gt=h;
            while(i<=gt){
                if(nums[i]<pivot)swap(nums,i++,lt++);
                else if(nums[i]>pivot)swap(nums,i,gt--);
                else i++;
            }
            if(k<lt)h=lt-1;
            else if(k>gt)l=gt+1;
            else return pivot;
        }
    }
    private void swap(int[]nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}