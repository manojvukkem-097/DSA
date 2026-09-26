class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String>map=new HashMap<>();
        for(List<String>pair:knowledge){
            map.put(pair.get(0),pair.get(1));
        }
        StringBuilder ans=new StringBuilder();
        int prev=-1,i=0,n=s.length();
        while(i<n){
            char ch=s.charAt(i);
            if(ch=='('){
                prev=i+1;
                while(i<n&&s.charAt(i)!=')'){
                    i++;
                }
                String key=s.substring(prev,i);
                ans.append(map.getOrDefault(key,"?"));
            }else{
                ans.append(ch);
            }
            i++;
        }
        return ans.toString();
    }
}