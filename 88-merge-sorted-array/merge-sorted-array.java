class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[]merged=new int[m+n];
        int idx1=0,idx2=0,x=0;
        while(idx1<=m-1 && idx2<=n-1){
            if(nums1[idx1]<=nums2[idx2]){
                merged[x++]=nums1[idx1++];
            }else{
                merged[x++]=nums2[idx2++];
            }
        }
        while(idx1<=m-1){
            merged[x++]=nums1[idx1++];
        }
        while(idx2<=n-1){
            merged[x++]=nums2[idx2++];
        }
        for(int i=0,j=0;i<merged.length;i++,j++){
            nums1[j]=merged[i];
        }
    }
}