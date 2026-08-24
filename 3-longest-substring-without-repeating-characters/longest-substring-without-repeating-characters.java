class Solution {
    public int lengthOfLongestSubstring(String s) {
        int charIndex[] = new int[128];

        int maxLength=0, left=0;
        
        for(int right = 0; right<s.length(); right++){
            char ch = s.charAt(right);
            left = Math.max(left, charIndex[ch]);

            charIndex[ch] = right + 1;

            maxLength = Math.max(maxLength,right - left + 1); 
        }

        return maxLength;
    }
}