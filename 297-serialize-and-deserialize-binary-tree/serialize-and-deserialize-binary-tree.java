/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return "";
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null){
                sb.append("#,");
            }else{
                sb.append(node.val).append(",");
                q.add(node.left);
                q.add(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null||data.length()==0)return null;
        String[]values=data.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        int i=1;
        while(i<values.length&&!q.isEmpty()){
            TreeNode node=q.poll();
            if(!values[i].equals("#")){
                TreeNode left=new TreeNode(Integer.parseInt(values[i]));
                node.left=left;
                q.add(node.left);
            }
            i++;
            if(i<values.length&&!values[i].equals("#")){
                TreeNode right=new TreeNode(Integer.parseInt(values[i]));
                node.right=right;
                q.add(node.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));