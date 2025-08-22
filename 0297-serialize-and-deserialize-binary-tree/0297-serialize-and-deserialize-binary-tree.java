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

    private int index;
    private void preorderSerialize(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("null ");
            return;
        }
        sb.append(Integer.toString(root.val)+" ");
        preorderSerialize(root.left,sb);
        preorderSerialize(root.right,sb);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        preorderSerialize(root,sb);
        return sb.toString();
    }

    private TreeNode preorderDeserialize(String[] values){
        if(values[index].equals("null")){
            index++;
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(values[index++]));
        root.left=preorderDeserialize(values);
        root.right=preorderDeserialize(values);
        return root;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values=data.split(" ");
        index=0;
        return preorderDeserialize(values);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));