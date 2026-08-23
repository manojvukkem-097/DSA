class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m=mat.length,n=mat[0].length;
        int low=0,high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int rowmax=0;
            for(int i=1;i<m;i++){
                if(mat[i][mid]>mat[rowmax][mid]){
                    rowmax=i;
                }
            }
            int lval=(mid!=0)?mat[rowmax][mid-1]:-1;
            int rval=(mid!=n-1)?mat[rowmax][mid+1]:-1;
            if(mat[rowmax][mid]>=lval && mat[rowmax][mid]>=rval){
                return new int[]{rowmax,mid};
            }else if(mat[rowmax][mid]<lval){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return new int[]{-1,-1};
    }
}