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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        if(root==null)return ans;
        Queue<TreeNode>s=new LinkedList<>();
        s.offer(root);
        boolean lefttoright=true;
        while(!s.isEmpty()){
            int listsize=s.size();
            Integer[]curr=new Integer[listsize];
            for(int i=0;i<listsize;i++){
                TreeNode remove=s.poll();
                int idx=lefttoright?i:listsize-i-1;
                curr[idx]=remove.val;
                if(remove.left!=null)s.add(remove.left);
                if(remove.right!=null)s.add(remove.right);
            }
            ans.add(Arrays.asList(curr));
            lefttoright=!lefttoright;
        }
        return ans;
    }
}