class Solution {
    public int minMoves2(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int median=nums[n/2];
        int ans=0;
        for(int i=0;i<n/2;i++){
            ans+=Math.abs(nums[i]-median);
            ans+=Math.abs(nums[n-i-1]-median);
        }
        return ans; 
    }
}