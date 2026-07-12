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
    int count;
    int val = -1;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root,k);
        return val;
    }

    public void helper(TreeNode root,int k){
        if(root == null) return;
        helper(root.left,k);
        if(count == 0) return;
        count--;
        if(count == 0) {
            val = root.val;
            return;
        }
        helper(root.right,k);
    }


}
