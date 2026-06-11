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
    public int count;
    public int val = -1;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root,k);
        return val;
    }

    private void helper(TreeNode root,int k){
        if( root == null) return;
        helper(root.left,k);
        if(count == 0) return;
        count--;
        if(count == 0) val = root.val;
        if(val == -1) helper(root.right,k);
    }
}
