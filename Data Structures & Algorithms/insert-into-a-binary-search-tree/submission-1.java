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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // standing at the root we need to compare root.val with val
        // if val > roo.val move towards right
        // if val < root.val move towards left
        // how to decide whether this val will be new root ?
        // if(root == null) return new TreeNode(val);
        // if(val < root.val) root.left = insertIntoBST(root.left,val);
        // else root.right = insertIntoBST(root.right,val);
        // return root;

        if(root == null) return new TreeNode(val);
        TreeNode curr = root;
        while(true){
            if(val > curr.val){
                if(curr.right == null){
                    curr.right = new TreeNode(val);
                    return root;
                }
                curr = curr.right;
            }
            else {
                if(curr.left == null){
                    curr.left = new TreeNode(val);
                    return root;
                }
                curr = curr.left;
            }
        }
    }
}