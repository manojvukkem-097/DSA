class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer>set=new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        int longest=0;
        for(int n:set){
            if(!set.contains(n-1)){
                int num=n;
                int streak=1;
                while(set.contains(num+1)){
                    num+=1;
                    streak+=1;
                }
                longest=Math.max(longest,streak);
            }
        }
        return longest;
    }
}