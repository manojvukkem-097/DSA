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
    private int i=0;
    private int p=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,Integer.MAX_VALUE); 
    }
    private TreeNode build(int[]preorder,int[]inorder,int stop){
        if(p>=preorder.length)return null;
        if(inorder[i]==stop){
            i++;
            return null;
        }
        TreeNode root=new TreeNode(preorder[p++]);
        root.left=build(preorder,inorder,root.val);
        root.right=build(preorder,inorder,stop);
        return root;
    }
}