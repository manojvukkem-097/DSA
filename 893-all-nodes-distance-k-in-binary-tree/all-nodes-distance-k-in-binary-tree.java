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
        Set<TreeNode>visited=new HashSet<>();
        Queue<TreeNode>q=new LinkedList<>();
        q.add(target);
        visited.add(target);
        int count=0;
        while(!q.isEmpty()){
            int size=q.size();
            if(count==k)break;
            count++;
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.left!=null&&!visited.contains(node.left)){
                    q.add(node.left);
                    visited.add(node.left);
                }if(node.right!=null&&!visited.contains(node.right)){
                    q.add(node.right);
                    visited.add(node.right);
                }
                if(parentmap.get(node)!=null&&!visited.contains(parentmap.get(node))){
                    q.add(parentmap.get(node));
                    visited.add(parentmap.get(node));
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