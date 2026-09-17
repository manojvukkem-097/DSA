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
    Stack<TreeNode>s1;
    Stack<TreeNode>s2;
    class bstiterator{
        bstiterator(TreeNode root){
            s1=new Stack<>();
            s2=new Stack<>();
            pushallleft(root);
            pushallright(root);
        }
        public int next(){
            TreeNode temp=s1.pop();
            pushallleft(temp.right);
            return temp.val;
        }
        public int before(){
            TreeNode temp=s2.pop();
            pushallright(temp.left);
            return temp.val;
        }
        public void pushallleft(TreeNode node){
            while(node!=null){
                s1.push(node);
                node=node.left;
            }
        }
        public void pushallright(TreeNode node){
            while(node!=null){
                s2.push(node);
                node=node.right;
            }
        }
    }
    public boolean findTarget(TreeNode root, int k) {
        if(root==null)return false;
        bstiterator b=new bstiterator(root);
        int left=b.next();
        int right=b.before();
        while(left<right){
            int sum=left+right;
            if(sum==k){
                return true;
            }else if(sum<k){
                left=b.next();
            }else{
                right=b.before();
            }
        }
        return false;
    }
}