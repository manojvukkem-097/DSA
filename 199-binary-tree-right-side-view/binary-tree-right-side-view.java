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
    class tuple{
        TreeNode node;
        int row;
        tuple(TreeNode node,int row){
            this.node=node;
            this.row=row;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        if(root==null)return ans;
        Queue<tuple>q=new LinkedList<>();
        q.add(new tuple(root,0));
        while(!q.isEmpty()){
            tuple t=q.poll();
            TreeNode node=t.node;
            int row=t.row;
            if(ans.size()==row)ans.add(node.val);
            if(node.right!=null)q.add(new tuple(node.right,row+1));
            if(node.left!=null)q.add(new tuple(node.left,row+1));
        }
        return ans;
    }
}