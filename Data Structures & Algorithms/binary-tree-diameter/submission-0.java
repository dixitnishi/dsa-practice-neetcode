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
    private int maxDia = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        int[] arr = new int[1];
        helper(root,arr);
        return arr[0];
    }

    public int helper(TreeNode root, int []dia){
        if(root == null) return 0;
        int left = helper(root.left,dia);
        int right = helper(root.right,dia);
        dia[0] = Math.max(dia[0],left + right);
        return Math.max(left,right) + 1;
    }
}
