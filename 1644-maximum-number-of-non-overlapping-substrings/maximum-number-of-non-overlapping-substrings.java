class Solution {
    class property{
        int si,ei;
        property(int si,int ei){
            this.si=si;
            this.ei=ei;
        }
    }
    public List<String> maxNumOfSubstrings(String s) {
        List<String>ans=new ArrayList<>();
        if(s.isEmpty()||s.length()==0)return ans;
        Map<Character,property>map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,new property(map.get(ch).si,i));
            }else{
                map.put(ch,new property(i,i));
            }
        }
        List<property>valid=new ArrayList<>();
        for(property p:map.values()){
            int l=p.si,r=p.ei;
            boolean isvalid=true;
            for(int i=l;i<=r;i++){
                char ch=s.charAt(i);
                property child=map.get(ch);
                if(child.si<l){
                    isvalid=false;
                    break;
                }
                r=Math.max(r,child.ei);
            }
            if(isvalid){
                valid.add(new property(l,r));
            }
        }
        valid.sort((a,b)->a.ei-b.ei);
        int prev=-1;
        for(property p:valid){
            if(prev<p.si){
                ans.add(s.substring(p.si,p.ei+1));
                prev=p.ei;
            }
        }
        return ans;
    }
}