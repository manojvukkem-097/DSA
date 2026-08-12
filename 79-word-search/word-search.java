class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(i,j,0,board,word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean dfs(int row,int col,int idx,char[][]board,String word){
        if(idx==word.length())return true;
        if(row<0||row>=board.length||col<0||col>=board[0].length||board[row][col]!=word.charAt(idx))return false;
        char temp=board[row][col];
        board[row][col]='#';
        boolean found=dfs(row,col+1,idx+1,board,word)||dfs(row,col-1,idx+1,board,word)||dfs(row+1,col,idx+1,board,word)||dfs(row-1,col,idx+1,board,word);
        board[row][col]=temp;
        return found;
    }
}