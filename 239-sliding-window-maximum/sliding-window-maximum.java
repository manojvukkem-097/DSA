class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        if(n==0||k<=0)return new int[0];
        Deque<Integer>deque=new ArrayDeque<>();
        int[]ans=new int[n-k+1];
        for(int i=0;i<n;i++){
            if(!deque.isEmpty()&&deque.peekFirst()<=i-k){
                deque.pollFirst();
            }
            while(!deque.isEmpty()&&nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            if(i>=k-1){
                ans[i-k+1]=nums[deque.peekFirst()];
            }
        }
        return ans;
    }
}