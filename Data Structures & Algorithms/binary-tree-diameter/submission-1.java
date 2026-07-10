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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = new int[1];
        helper(root,ans);
        return ans[0];
    }

    public int helper(TreeNode root,int[] ans){
        if(root == null) return 0;
        int leftHeight = helper(root.left,ans);
        int rightHeight = helper(root.right,ans);
        int dia = leftHeight + rightHeight;
        ans[0] = Math.max(ans[0],dia);
        return 1 + Math.max(helper(root.left, ans),helper(root.right,ans));
    }
}
