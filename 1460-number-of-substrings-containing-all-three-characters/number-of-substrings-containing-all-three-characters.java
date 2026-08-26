class Solution {
    public int numberOfSubstrings(String s) {
        int[]count=new int[3];
        int l=0,ans=0;
        for(int r=0;r<s.length();r++){
            char ch=s.charAt(r);
            count[ch-'a']++;
            while(count[0]>=1 && count[1]>=1 && count[2]>=1){
                ans+=s.length()-r;
                count[s.charAt(l)-'a']--;
                l++;
            }
        }
        return ans;
    }
}