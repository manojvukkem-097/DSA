class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        List<String>ans=new ArrayList<>();
        if(s.isEmpty()||s.length()==0)return ans;
        int[]first=new int[26];
        int[]last=new int[26];
        Arrays.fill(first,-1);
        Arrays.fill(last,-1);
        for(int i=0;i<s.length();i++){
            int idx=s.charAt(i)-'a';
            if(first[idx]==-1){
                first[idx]=i;
            }
            last[idx]=i;
        }
        List<int[]>valid=new ArrayList<>();
        for(int c=0;c<26;c++){
            if(first[c]==-1)continue;
            int l=first[c],r=last[c];
            boolean isvalid=true;
            for(int i=l;i<=r;i++){
                int ch=s.charAt(i)-'a';
                if(first[ch]<l){
                    isvalid=false;
                    break;
                }
                r=Math.max(r,last[ch]);
            }
            if(isvalid){
                valid.add(new int[]{l,r});
            }
        }
        valid.sort((a,b)->a[1]-b[1]);
        int end=-1;
        for(int[]pair:valid){
            if(pair[0]>end){
                ans.add(s.substring(pair[0],pair[1]+1));
                end=pair[1];
            }
        }
        return ans;
    }
}