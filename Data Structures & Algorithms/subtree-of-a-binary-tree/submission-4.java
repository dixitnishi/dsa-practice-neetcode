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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) return true;
        if(root == null) return false;
        String rootStr = turnIntoString(root);
        String subRootStr = turnIntoString(subRoot);
        return rootStr.contains(subRootStr);
    }

    public String turnIntoString(TreeNode root){
        StringBuilder sb = new StringBuilder();
        preorder(root,sb);
        return sb.toString();
    }

    public void preorder(TreeNode root,StringBuilder sb){
        if (root == null) {
            sb.append("#,");
            return;
        }

        sb.append(root.val).append(",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    public boolean sameTree(TreeNode root1,TreeNode root2){
        if(root1 == null || root2 == null) return root1 == root2;
        return root1.val == root2.val && sameTree(root1.left,root2.left) && sameTree(root1.right,root2.right);
    }
}
