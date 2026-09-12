/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void markparent(TreeNode root,Map<TreeNode,TreeNode>parentmap){
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node.left!=null){
                parentmap.put(node.left,node);
                q.add(node.left);
            }if(node.right!=null){
                parentmap.put(node.right,node);
                q.add(node.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode>parentmap=new HashMap<>();
        markparent(root,parentmap);
        Map<TreeNode,Boolean>visited=new HashMap<>();
        Queue<TreeNode>q=new LinkedList<>();
        q.add(target);
        visited.put(target,true);
        int count=0;
        while(!q.isEmpty()){
            int size=q.size();
            if(count==k)break;
            count++;
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.left!=null&&visited.get(node.left)==null){
                    q.add(node.left);
                    visited.put(node.left,true);
                }if(node.right!=null&&visited.get(node.right)==null){
                    q.add(node.right);
                    visited.put(node.right,true);
                }
                if(parentmap.get(node)!=null&&visited.get(parentmap.get(node))==null){
                    q.add(parentmap.get(node));
                    visited.put(parentmap.get(node),true);
                }
            }
        }
        List<Integer>ans=new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
}