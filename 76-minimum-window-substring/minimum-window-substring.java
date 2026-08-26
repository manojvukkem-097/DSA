class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())return "";
        int[]map=new int[128];
        for(char ch:t.toCharArray()){
            map[ch]++;
        }
        int l=0,r=0,start=-1,count=0,minlength=Integer.MAX_VALUE;
        while(r<s.length()){
            char curr=s.charAt(r);
            if(map[curr]>0)count++;
            map[curr]--;
            while(count==t.length()){
                char first=s.charAt(l);
                if(r-l+1<minlength){
                    minlength=r-l+1;
                    start=l;
                }
                map[first]++;
                if(map[first]>0)count--;
                l++;
            }
            r++;
        }
        return start==-1?"":s.substring(start,start+minlength);
    }
}