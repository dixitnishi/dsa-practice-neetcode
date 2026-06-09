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
    public int goodNodes(TreeNode root) {
        return helper(root,root.val);
    }

    public int helper(TreeNode root,int maxValue){
        if(root == null) return 0;
        int res = (root.val >= maxValue) ? 1 : 0;
        maxValue = Math.max(maxValue, root.val);
        res += helper(root.left,maxValue);
        res += helper(root.right,maxValue);
        return res;
    }
}
