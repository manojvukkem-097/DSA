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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>result=new ArrayList<>();
        if(root==null)return result;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int listsize=q.size();
            List<Integer>curr=new ArrayList<>();
            for(int i=0;i<listsize;i++){
                TreeNode removed=q.poll();
                curr.add(removed.val);
                if(removed.left!=null){
                    q.offer(removed.left);
                }if(removed.right!=null){
                    q.offer(removed.right);
                }
            }
            result.add(curr);
        }
        return result;
    }
}