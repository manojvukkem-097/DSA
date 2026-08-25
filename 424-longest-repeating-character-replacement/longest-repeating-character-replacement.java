class Solution {
    public int characterReplacement(String s, int k) {
        char[]chars=s.toCharArray();
        int[]count=new int[26];
        int l=0,maxfreq=0;
        for(int r=0;r<chars.length;r++){
            maxfreq=Math.max(maxfreq,++count[chars[r]-'A']);
            if((r-l+1)-maxfreq>k){
                count[chars[l]-'A']--;
                l++;
            }
        }
        return chars.length-l;
    }
}