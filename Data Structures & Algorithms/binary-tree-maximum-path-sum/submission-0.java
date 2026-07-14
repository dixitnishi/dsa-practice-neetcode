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
    public int maxPathSum(TreeNode root) {
        int temp[] = new int[]{root.val};
        dfs(root,temp);
        return temp[0];
    }

    public int dfs(TreeNode root,int[] temp){
        if(root == null) return 0;
        int left = Math.max(dfs(root.left,temp),0);
        int right = Math.max(dfs(root.right,temp),0);
        temp[0] = Math.max(temp[0],root.val + left + right);
        return root.val + Math.max(left,right);
    }
}
