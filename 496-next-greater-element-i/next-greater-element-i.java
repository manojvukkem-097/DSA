class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[]ans=new int[nums1.length];
        Stack<Integer>s=new Stack<>();
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i],i);
        }
        for(int i=nums2.length-1;i>=0;i--){
            while(!s.isEmpty()&& nums2[i]>=s.peek()){
                s.pop();
            }
            if(map.containsKey(nums2[i])){
                int index=map.get(nums2[i]);
                ans[index]=(s.isEmpty())?-1:s.peek();
            }
            s.push(nums2[i]);
        }
        return ans;
    }
}