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
    private int idx=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildbst(preorder,Integer.MAX_VALUE);
    }
    private TreeNode buildbst(int[]preorder,int bound){
        if(idx==preorder.length||preorder[idx]>bound){
            return null;
        }
        TreeNode root=new TreeNode(preorder[idx++]);
        root.left=buildbst(preorder,root.val);
        root.right=buildbst(preorder,bound);
        return root;
    }
}