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
    class pair{
        TreeNode node;
        int index;
        pair(TreeNode node,int index){
            this.node=node;
            this.index=index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        int maxwidth=0;
        Queue<pair>q=new LinkedList<>();
        q.add(new pair(root,1));
        while(!q.isEmpty()){
            int size=q.size();
            int minindex=q.peek().index;
            int first=0,last=0;
            for(int i=0;i<size;i++){
                pair curr=q.poll();
                TreeNode node=curr.node;
                int curridx=curr.index-minindex;
                if(i==0)first=curridx;
                if(i==size-1)last=curridx;
                if(node.left!=null){
                    q.add(new pair(node.left,2*curridx+1));
                }if(node.right!=null){
                    q.add(new pair(node.right,2*curridx+2));
                }
            }
            maxwidth=Math.max(maxwidth,last-first+1);
        }
        return maxwidth;
    }
}