/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Nodevalue{
    int min,max,sum;
    boolean isbst;
    Nodevalue(int min,int max,int sum,boolean isbst){
        this.min=min;
        this.max=max;
        this.sum=sum;
        this.isbst=isbst;
    }
}
class Solution {
    private int maxsum=0;
    private Nodevalue find(TreeNode root){
        if(root==null){
            return new Nodevalue(Integer.MAX_VALUE,Integer.MIN_VALUE,0,true);
        }
        Nodevalue left=find(root.left);
        Nodevalue right=find(root.right);
        if(left.isbst&&right.isbst&&left.max<root.val&&right.min>root.val){
            int currsum=left.sum+right.sum+root.val;
            maxsum=Math.max(maxsum,currsum);
            return new Nodevalue(Math.min(root.val,left.min),Math.max(root.val,right.max),currsum,true);
        }
        return new Nodevalue(Integer.MAX_VALUE,Integer.MIN_VALUE,0,false);
    }
    public int maxSumBST(TreeNode root) {
        maxsum=0;
        find(root);
        return maxsum;
    }
}