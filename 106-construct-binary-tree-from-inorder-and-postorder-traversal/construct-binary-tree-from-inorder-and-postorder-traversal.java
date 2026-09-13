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
    private int i;
    private int p;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        i=inorder.length-1;
        p=postorder.length-1;
        return build(inorder,postorder,Integer.MIN_VALUE);
    }
    private TreeNode build(int[]inorder,int[]postorder,int stop){
        if(p<0)return null;
        if(inorder[i]==stop){
            i--;
            return null;
        }
        TreeNode root=new TreeNode(postorder[p--]);
        root.right=build(inorder,postorder,root.val);
        root.left=build(inorder,postorder,stop);
        return root;
    }
}