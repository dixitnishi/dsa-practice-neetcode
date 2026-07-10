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
    public List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> ans = new ArrayList<>();
        helper(ans,root);
        return ans;
    }

    private void helper(List<Integer> ans,TreeNode node){
        if(node == null) return;
        helper(ans,node.left);
        helper(ans,node.right);
        ans.add(node.val);
    }
}