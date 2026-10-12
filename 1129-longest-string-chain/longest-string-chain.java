class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->Integer.compare(a.length(),b.length()));
        Map<String,Integer>dp=new HashMap<>();
        int ans=1;
        for(String word:words){
            int curr=1;
            for(int i=0;i<word.length();i++){
                String predecessor=word.substring(0,i)+word.substring(i+1);
                if(dp.containsKey(predecessor)){
                    curr=Math.max(curr,dp.get(predecessor)+1);
                }
            }
            dp.put(word,curr);
            ans=Math.max(ans,curr);
        }
        return ans;
    }
}