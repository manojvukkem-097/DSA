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
class Solution {
    public int maxPathSum(TreeNode root) {
        int[]max=new int[1];
        max[0]=Integer.MIN_VALUE;
        find(root,max);
        return max[0];
    }
    private int find(TreeNode root,int[]max){
        if(root==null)return 0;
        int ls=Math.max(0,find(root.left,max));
        int rs=Math.max(0,find(root.right,max));
        max[0]=Math.max(max[0],ls+rs+root.val);
        return Math.max(ls,rs)+root.val;
    }
}