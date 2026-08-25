class Solution {
    public int characterReplacement(String s, int k) {
        int[]count=new int[26];
        int l=0,maxfreq=0;
        for(int r=0;r<s.length();r++){
            count[s.charAt(r)-'A']++;
            maxfreq=Math.max(maxfreq,count[s.charAt(r)-'A']);
            if((r-l+1)-maxfreq>k){
                count[s.charAt(l)-'A']--;
                l++;
            }
        }
        return s.length()-l;
    }
}