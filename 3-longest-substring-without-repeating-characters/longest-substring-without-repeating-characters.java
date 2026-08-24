class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[]index=new int[128];
        int l=0,ans=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            l=Math.max(l,index[ch]);
            index[ch]=i+1;
            ans=Math.max(ans,i-l+1);
        }
        return ans;
    }
}