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
        if(root == null && subRoot != null) return false;
        boolean isCurrRootSubRoot = sameTree(root,subRoot);
        if(isCurrRootSubRoot) return true;
        boolean isLeftSubTree = isSubtree(root.left,subRoot);
        boolean isRightSubTree = isSubtree(root.right,subRoot);
        return isLeftSubTree || isRightSubTree;
    }

    public boolean sameTree(TreeNode root1,TreeNode root2){
        if(root1 == null || root2 == null) return root1 == root2;
        return root1.val == root2.val && sameTree(root1.left,root2.left) && sameTree(root1.right,root2.right);
    }
}
