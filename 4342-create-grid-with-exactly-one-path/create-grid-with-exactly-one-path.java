class Solution {
    public String[] createGrid(int m, int n) {
        String[]ans=new String[m];
        for(int i=0;i<m;i++){
            StringBuilder temp=new StringBuilder();
            for(int j=0;j<n;j++){
                if(j==0||i==m-1){
                    temp.append(".");
                }else{
                    temp.append("#");
                }
            }
            ans[i]=temp.toString();
        }
        return ans;
    }
}