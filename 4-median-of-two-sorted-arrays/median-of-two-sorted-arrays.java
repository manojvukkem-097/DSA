class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length,n2=nums2.length;
        if(n1>n2)return findMedianSortedArrays(nums2,nums1);
        int range=(n1+n2+1)/2,total=n1+n2;
        int si=0,ei=n1;
        while(si<=ei){
            int mid1=si+(ei-si)/2;
            int mid2=range-mid1;
            int l1=(mid1!=0)?nums1[mid1-1]:Integer.MIN_VALUE;
            int l2=(mid2!=0)?nums2[mid2-1]:Integer.MIN_VALUE;
            int r1=(mid1<n1)?nums1[mid1]:Integer.MAX_VALUE;
            int r2=(mid2<n2)?nums2[mid2]:Integer.MAX_VALUE;
            if(l1<=r2 && l2<=r1){
                if(total%2==0){
                    return (double)((Math.max(l1,l2)+Math.min(r1,r2))/2.0);
                }else{
                    return (double)(Math.max(l1,l2));
                }
            }else if(l1>r2){
                ei=mid1-1;
            }else{
                si=mid1+1;
            }
        }
        return -1.0;
    }
}