class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gidx=0;
        int sidx=0;
        while(gidx<g.length && sidx<s.length){
            if(s[sidx]>=g[gidx]){
                gidx++;
            }
            sidx++;
        }
        return gidx;
    }
}