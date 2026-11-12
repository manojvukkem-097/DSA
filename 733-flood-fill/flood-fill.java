class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int prev=image[sr][sc];
        if(prev!=color){
            helper(image,sr,sc,color,prev);
        }
        return image;
    }
    private void helper(int[][] image, int sr, int sc, int color,int prev){
        int m=image.length,n=image[0].length;
        if(sc<0||sr<0||sr>=m||sc>=n||image[sr][sc]!=prev)return;
        image[sr][sc]=color;
        helper(image,sr,sc-1,color,prev);
        helper(image,sr,sc+1,color,prev);
        helper(image,sr+1,sc,color,prev);
        helper(image,sr-1,sc,color,prev);
    }
}