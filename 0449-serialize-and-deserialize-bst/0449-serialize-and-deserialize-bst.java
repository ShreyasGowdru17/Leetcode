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
    // Encodes a tree to a single string.
    public void preorderSerialize(TreeNode root,StringBuilder sb){
        if(root==null){
            return;
        }
        sb.append(Integer.toString(root.val)+" ");
        preorderSerialize(root.left,sb);
        preorderSerialize(root.right,sb);
    }
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        preorderSerialize(root,sb);
        return sb.toString().trim();
    }

    public TreeNode preorderDeserialize(String[] values,int min,int max){
        if(index>=values.length) return null;

        int val=Integer.parseInt(values[index]);
        if(val<min || val>max ) return null;

        TreeNode root=new TreeNode(val);
        index++;
        root.left=preorderDeserialize(values,min,val);
        root.right=preorderDeserialize(values,val,max);
        return root;
    }    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        String[] values=data.split(" ");
        index=0;
        return preorderDeserialize(values,Integer.MIN_VALUE,Integer.MAX_VALUE); 
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;