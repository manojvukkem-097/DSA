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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)return null;
        TreeNode prev=null;
        TreeNode curr=root;
        while(curr!=null&&curr.val!=key){
            prev=curr;
            if(curr.val<key){
                curr=curr.right;
            }else{
                curr=curr.left;
            }
        }
        if(curr==null)return root;
        TreeNode replacement;
        if(curr.left==null){
            replacement=curr.right;
        }else if(curr.right==null){
            replacement=curr.left;
        }else{
            TreeNode temp=curr.left;
            while(temp.right!=null){
                temp=temp.right;
            }
            temp.right=curr.right;
            replacement=curr.left;
        }
        if(prev==null){
            return replacement;
        }
        else if(prev.right==curr){
            prev.right=replacement;
        }else{
            prev.left=replacement;
        }
        return root;
    }
}