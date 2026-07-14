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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsPreOrder(root,sb);
        return sb.toString();
    }

    private void dfsPreOrder(TreeNode root,StringBuilder sb){
        if(root == null){
            sb.append("N,");
            return;
        }
        sb.append(root.val+",");
        dfsPreOrder(root.left,sb);
        dfsPreOrder(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int[] temp = {0};
        return dfsDeserialize(vals,temp);
    }

    public TreeNode dfsDeserialize(String[] vals,int[] temp){
        if(vals[temp[0]].equals("N")){
            temp[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(vals[temp[0]]));
        temp[0]++;
        node.left = dfsDeserialize(vals,temp);
        node.right = dfsDeserialize(vals,temp);
        return node;
    }
}
