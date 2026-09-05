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
    public int diameterOfBinaryTree(TreeNode root) {
        int[]diameter=new int[1];
        find(root,diameter);
        return diameter[0];
    }
    private int find(TreeNode root,int[]d){
        if(root==null){
            return 0;
        }
        int lh=find(root.left,d);
        int rh=find(root.right,d);
        d[0]=Math.max(d[0],lh+rh);
        return Math.max(lh,rh)+1;
    }
}