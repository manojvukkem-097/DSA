class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>allboards=new ArrayList<>();
        boolean[][]board=new boolean[n][n];
        helper(0,board,allboards);
        return allboards;
    }
    private boolean issafe(int row,int col,boolean[][]board){
        for(int i=0;i<board.length;i++){
            if(board[row][i])return false;
        }
        int r=row;
        for(int c=col;r>=0&&c>=0;r--,c--){
            if(board[r][c])return false;
        }
        r=row;
        for(int c=col;r<board.length && c>=0;r++,c--){
            if(board[r][c])return false;
        }
        return true;
    }
    private void helper(int col,boolean[][]board,List<List<String>>allboards){
        if(col==board.length){
            saveboard(board,allboards);
            return;
        }
        for(int row=0;row<board.length;row++){
            if(issafe(row,col,board)){
                board[row][col]=true;
                helper(col+1,board,allboards);
                board[row][col]=false;
            }
        }
    }
    private void saveboard(boolean[][]board,List<List<String>>allboards){
        List<String>curr=new ArrayList<>();
        for(int i=0;i<board.length;i++){
            String str="";
            for(int j=0;j<board.length;j++){
                if(board[i][j]){
                    str+="Q";
                }else{
                    str+=".";
                }
            }
            curr.add(str);
        }
        allboards.add(new ArrayList<>(curr));
    }
}