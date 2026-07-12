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
    public TreeNode deleteNode(TreeNode root, int key) {
        // node to be deleted can be a leaf node - easiest case
        // deleted node can be a node somewhere in between or root node
        // so after deletion we need to rebalance the tree properly
        // rebalancing can have multiple solutions
        if(root == null) return root;
        if(key < root.val) root.left = deleteNode(root.left,key);
        else if(key > root.val) root.right = deleteNode(root.right,key);
        else{
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            TreeNode curr = root.right;
            while(curr.left != null) curr = curr.left;
            root.val = curr.val;
            root.right = deleteNode(root.right,root.val);
        }
        return root;
    }
}