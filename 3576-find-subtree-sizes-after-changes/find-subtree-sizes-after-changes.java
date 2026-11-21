class Solution {
    List<List<Integer>>adj;
    int[]result;
    int[]lastseen;
    private void dfs(int node,int[]parent,String s){
        int c=s.charAt(node)-'a';
        int prevancestor=lastseen[c];
        lastseen[c]=node;
        for(int child:adj.get(node)){
            dfs(child,parent,s);
        }
        lastseen[c]=prevancestor;
        if(node!=0){
            int newParent = (prevancestor != -1) ? prevancestor : parent[node];
            result[newParent] += result[node];
        }
    }
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n=parent.length;
        adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        result=new int[n];
        lastseen=new int[26];
        Arrays.fill(lastseen,-1);
        Arrays.fill(result,1);
        for(int i=1;i<n;i++){
            int u=parent[i];
            adj.get(u).add(i);
        }
        dfs(0,parent,s);
        return result;
    }
}